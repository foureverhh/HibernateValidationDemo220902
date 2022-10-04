package se.skolverket.hibernatevalidationdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="USERS")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //name should not be null or empty // at least 2 charactors
    @NotEmpty
    @Size(min = 2, message ="user name should have at least 2 characters")
    private String name;

    private String job;
    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min=8, message ="password should have at least 8 characters")
    private String password;
}
