package com.recipetracker.finalversionrecipetracker.demo.service;

import com.recipetracker.finalversionrecipetracker.demo.controller.dto.FileStorageRequestDto;
import com.recipetracker.finalversionrecipetracker.demo.controller.dto.FileStorageResponseDto;
import com.recipetracker.finalversionrecipetracker.demo.exceptions.FileStorageException;
import com.recipetracker.finalversionrecipetracker.demo.exceptions.RecordNotFoundException;
import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;
import com.recipetracker.finalversionrecipetracker.demo.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Value("${app.upload.dir:${user.home}}")
    private String uploadDirectory;  // relative to root
    private final Path uploads = Paths.get("uploads");

    @Autowired
    private RecipeRepository repository;

    @Override
    public void init() {
        try {
            Files.createDirectory(uploads);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public Iterable<Recipe> getFiles() {
        return repository.findAll();
    }

    public long uploadFile(FileStorageRequestDto fileStorageRequestDto) {

        MultipartFile file = fileStorageRequestDto.getFile();

        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
        Path copyLocation = this.uploads.resolve(file.getOriginalFilename());

        try {
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new FileStorageException("Could not store file " + originalFilename + ". Please try again!");
        }

        Recipe newFileToStore = new Recipe();
        newFileToStore.setLocation(copyLocation.toString());

        Recipe saved = repository.save(newFileToStore);

        return saved.getId();
    }

    @Override
    public void deleteFile(long id) {
        Optional<Recipe> stored = repository.findById(id);

        if (stored.isPresent()) {
            Long fileId = stored.get().getId();
            Path location = this.uploads.resolve(String.valueOf(fileId));
            try {
                Files.deleteIfExists(location);
            }
            catch (IOException ex) {
                throw new RuntimeException("File not found");
            }

            repository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    public FileStorageResponseDto getFileById(long id) {
        Optional<Recipe> stored = repository.findById(id);

        if (stored.isPresent()) {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand("download").toUri();

            FileStorageResponseDto responseDto = new FileStorageResponseDto();
            return responseDto;
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public boolean fileExistsById(long id) {
        return repository.existsById(id);
    }

}