package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long idBook;
    private String name;
    private String date;
    private String author;
    private String edition;
    private Long price;
    private String type;
    private String famous;
}
