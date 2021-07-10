package com.recipetracker.finalversionrecipetracker.demo.controller.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileStorageRequestDto {
    private MultipartFile file;
}