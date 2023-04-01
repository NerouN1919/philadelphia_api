package com.philadelphia.api.Database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "login")
    @NotEmpty
    private String login;
    @Column(name = "password")
    @NotEmpty
    private String password;
    @Column(name = "name")
    @NotEmpty
    private String name;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "is_male")
    private Boolean male;
}
