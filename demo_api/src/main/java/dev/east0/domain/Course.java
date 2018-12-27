package dev.east0.domain;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String courseName;

    @ManyToOne
    @JoinColumn(name = "professorId")
    Professor professor;


    @OneToMany(mappedBy = "course")
    List<Register> registers;








}
