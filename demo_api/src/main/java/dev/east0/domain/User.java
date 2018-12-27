package dev.east0.domain;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "userid")
    String userId;

    String password;

    String name;

    String email;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    Department department;

    boolean enabled;

    String userType;


}
