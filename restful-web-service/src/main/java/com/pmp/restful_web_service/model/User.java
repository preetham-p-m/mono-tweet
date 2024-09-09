package com.pmp.restful_web_service.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private int id;

    @Size(min = 3, message = "Name must be minumum of 3 characters")
    @Size(max = 50, message = "Name must be maximum of 5 character")
    private String name;

    @Past(message = "Date of Birth must be a past date")
    private LocalDate dateOfBirth;
}
