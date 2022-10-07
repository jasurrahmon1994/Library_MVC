package uz.jasur.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class User {
    private int id;
    private String fullName;
    private int birthYear;
}
