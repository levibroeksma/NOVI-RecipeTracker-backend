package com.recipetracker.finalversionrecipetracker.demo.service;

import com.recipetracker.finalversionrecipetracker.demo.controller.dto.FileStorageRequestDto;
import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;

public interface FileStorageService {
    void init();
    Iterable<Recipe> getFiles();
    boolean fileExistsById(long id);
    long uploadFile(FileStorageRequestDto method1Dto);
    void deleteFile(long id);
}
