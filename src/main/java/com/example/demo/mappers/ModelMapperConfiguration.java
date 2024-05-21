package com.example.demo.mappers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.dtos.BookDTO;
import com.example.demo.entities.Book;
import com.example.demo.repositories.BookRepository;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        // Set up a type map configuration
        modelMapper.createTypeMap(Book.class, BookDTO.class);

        return modelMapper;
    }
}