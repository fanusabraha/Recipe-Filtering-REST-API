package com.coderscampus.fanusassignment9.WebApplication;

import com.coderscampus.fanusassignment9.domain.Recipe;
import com.coderscampus.fanusassignment9.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileController {
    @Autowired
     public FileService fileService;
    @GetMapping("/allrecipe")
    public List<Recipe> allrecipe() throws IOException {

        return fileService.readinTheFile();
    }
    @GetMapping("/vegan")
    public List<Recipe> vegan() throws IOException {

        return fileService.readinTheFile().stream().filter(Recipe::getVegan).collect(Collectors.toList());
    }
    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> veganAndGlutenfree() throws IOException {

        return fileService.readinTheFile().stream().filter(recipe->recipe.getGlutenFree()&&recipe.getVegan()).collect(Collectors.toList());
    }
    @GetMapping("/vegetarian")
    public List<Recipe> vegetarian() throws IOException {

        return fileService.readinTheFile().stream().filter(Recipe::getVegetarian).collect(Collectors.toList());
    }
    @GetMapping("/gluten-free")
    public List<Recipe> glutenFree() throws IOException {

        return fileService.readinTheFile().stream().filter(Recipe::getGlutenFree).collect(Collectors.toList());
    }
}
