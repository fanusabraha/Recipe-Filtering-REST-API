package com.coderscampus.fanusassignment9.service;

import com.coderscampus.fanusassignment9.domain.Recipe;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService {


    public List<Recipe> readinTheFile() throws IOException {
            List<Recipe> recipe = new ArrayList<>();
        Reader in = new FileReader("recipes.txt");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withDelimiter(',')
                .withIgnoreSurroundingSpaces()
                .withHeader()
                .withSkipHeaderRecord().withEscape('\\')
                .parse(in);
        for (CSVRecord record :records) {
            Integer cookingMinutes = Integer.parseInt(record.get(0));
            Boolean dairyFree = Boolean.parseBoolean(record.get(1));
            Boolean glutenFree = Boolean.parseBoolean(record.get(2));
            String instructions = record.get(3);
            Double preparationMinutes = Double.parseDouble(record.get(4));
            Double pricePerServing = Double.parseDouble(record.get(5));
            Integer readyInMinutes = Integer.parseInt(record.get(6));
            Integer servings = Integer.parseInt(record.get(7));
            Double spoonacularScore = Double.parseDouble(record.get(8));
            String title = record.get(9);
            Boolean vegan = Boolean.parseBoolean(record.get(10));
            Boolean vegetarian = Boolean.parseBoolean(record.get(11));
            recipe.add (new Recipe(cookingMinutes,dairyFree,glutenFree,instructions,preparationMinutes,pricePerServing,readyInMinutes,
                    servings,spoonacularScore,title,vegan,vegetarian));

        }
        return recipe;
    }

}




/* Using longer way
 public List<Recipe> glutenFree() throws IOException {

        return readinTheFile().stream().filter(Recipe::getGlutenFree).collect(Collectors.toList());
    }
            recipe.setCookingMinutes(Integer.parseInt(record.get(0)));
            recipe.setDairyFree(Boolean.parseBoolean(record.get(1)));
            recipe.setGlutenFree (Boolean.parseBoolean(record.get(2)));
            recipe.setInstructions(record.get(3));
            recipe.setPreparationMinutes(Double.parseDouble(record.get(4)));
            recipe.setPricePerServing(Double.parseDouble(record.get(5)));
            recipe.setReadyInMinutes(Integer.parseInt(record.get(6)));
            recipe.setServings(Integer.parseInt(record.get(7)));
            recipe.setSpoonacularScore(Double.parseDouble(record.get(8)));
            recipe.setTitle(record.get(9));
            recipe.setVegan(Boolean.parseBoolean(record.get(10)));
            recipe.setVegetarian(Boolean.parseBoolean(record.get(11)))*/