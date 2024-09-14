package com.pmp.restful_web_service.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "user_details")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Size(min = 3, message = "Name must be minimum of 3 characters")
    @Size(max = 50, message = "Name must be maximum of 5 character")
    private String name;

    @Past(message = "Date of Birth must be a past date")
    private LocalDate dateOfBirth;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Post> posts;
}
