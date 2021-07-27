package com.recipetracker.finalversionrecipetracker.demo.service;

import com.recipetracker.finalversionrecipetracker.demo.controller.dto.RecipeRequestDto;
import com.recipetracker.finalversionrecipetracker.demo.controller.dto.RecipeResponseDto;
import com.recipetracker.finalversionrecipetracker.demo.exceptions.FileStorageException;
import com.recipetracker.finalversionrecipetracker.demo.exceptions.RecordNotFoundException;
import com.recipetracker.finalversionrecipetracker.demo.model.Direction;
import com.recipetracker.finalversionrecipetracker.demo.model.Ingredient;
import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;
import com.recipetracker.finalversionrecipetracker.demo.repository.RecipeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    private ObjectMapper objectMapper;

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
    public Iterable<Recipe> getAllRecipes() {
        return repository.findAllByOrderByIdDesc();
    }

    public long uploadRecipe(RecipeRequestDto recipeRequestDto) throws JsonProcessingException {

        MultipartFile file = recipeRequestDto.getFile();
        String originalFilename = "";
        Path copyLocation = null;
        if (file != null) {
            originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
            copyLocation = this.uploads.resolve(file.getOriginalFilename());
            try {
                Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                throw new FileStorageException("Could not store file " + originalFilename + ". Please try again!");
            }
        }

        Recipe newRecipeToStore = new Recipe();
        newRecipeToStore.setFileName(originalFilename);
        newRecipeToStore.setUsername(recipeRequestDto.getUsername());
        newRecipeToStore.setUserCountry(recipeRequestDto.getUserCountry());
        if (copyLocation != null ) { newRecipeToStore.setLocation(copyLocation.toString()); }
        newRecipeToStore.setTitle(recipeRequestDto.getTitle());
        newRecipeToStore.setDescription(recipeRequestDto.getDescription());
        newRecipeToStore.setCountry(recipeRequestDto.getCountry());
        newRecipeToStore.setCookingtime(recipeRequestDto.getCookingTime());
        newRecipeToStore.setCalories(recipeRequestDto.getCalories());
        newRecipeToStore.setBeef(recipeRequestDto.isBeef());
        newRecipeToStore.setFish(recipeRequestDto.isFish());
        newRecipeToStore.setLamb(recipeRequestDto.isLamb());
        newRecipeToStore.setPork(recipeRequestDto.isPork());
        newRecipeToStore.setVegan(recipeRequestDto.isVegan());
        newRecipeToStore.setVegetarian(recipeRequestDto.isVegetarian());
        newRecipeToStore.setSpicy(recipeRequestDto.isSpicy());

        objectMapper = new ObjectMapper();

        List<Ingredient> listIngredients = objectMapper.readValue(recipeRequestDto.getIngredients(), new TypeReference<List<Ingredient>>(){});
        for (Ingredient ingredient: listIngredients) {
//            ingredient.setRecipe(newRecipeToStore);
            newRecipeToStore.getIngredients().add(ingredient);
        }
        objectMapper = new ObjectMapper();

        List<Direction> listDirections = objectMapper.readValue(recipeRequestDto.getDirections(), new TypeReference<List<Direction>>(){});
        for (Direction direction: listDirections) {
            direction.setRecipe(newRecipeToStore);
            newRecipeToStore.getDirections().add(direction);
        }
        Recipe saved = repository.save(newRecipeToStore);

        return saved.getId();
    }

    @Override
    public void deleteFile(long id) {
        Optional<Recipe> stored = repository.findById(id);

        if (stored.isPresent()) {
            String filename = stored.get().getFileName();
            Path location = this.uploads.resolve(filename);
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

    @Override
    public RecipeResponseDto getFileById(long id) {
        Optional<Recipe> stored = repository.findById(id);

        if (stored.isPresent()) {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand("download").toUri();

            RecipeResponseDto responseDto = new RecipeResponseDto();
            responseDto.setFileName(stored.get().getFileName());
            responseDto.setTitle(stored.get().getTitle());
            responseDto.setUsername(stored.get().getUsername());
            responseDto.setUserCountry(stored.get().getUserCountry());
            responseDto.setDescription(stored.get().getDescription());
            responseDto.setCountry(stored.get().getCountry());
            responseDto.setCalories(stored.get().getCalories());
            responseDto.setBeef(stored.get().isBeef());
            responseDto.setFish(stored.get().isFish());
            responseDto.setLamb(stored.get().isLamb());
            responseDto.setPork(stored.get().isPork());
            responseDto.setVegan(stored.get().isVegan());
            responseDto.setVegetarian(stored.get().isVegetarian());
            responseDto.setSpicy(stored.get().isSpicy());
            responseDto.setDownloadUri(uri.toString());
            responseDto.setIngredients(stored.get().getIngredients());
            responseDto.setDirections(stored.get().getDirections());
            responseDto.setReviews(stored.get().getReviews());
            return responseDto;
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public Resource downloadFile(long id) {
        Optional<Recipe> stored = repository.findById(id);

        if (stored.isPresent()) {
            String filename = stored.get().getFileName();
            Path path = this.uploads.resolve(filename);

            Resource resource = null;
            try {
                resource = new UrlResource(path .toUri());
                return resource;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        else {
            throw new RecordNotFoundException();
        }
        return null;
    }

    @Override
    public void deleteRecipeById(Long id) {
        repository.deleteById(id);
    }
}
