package uz.jasur.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Book {
    private int id;
    private String name;
    private String author;
    private int publishYear;
}
