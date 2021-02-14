package com.atmim.demo.config;

import com.atmim.demo.entities.Category;
import com.atmim.demo.models.category.CategoryModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.typeMap(CategoryModel.class, Category.class).addMappings(mapper ->
                mapper.skip(Category::setId)
        );
        return modelMapper;
    }
}
