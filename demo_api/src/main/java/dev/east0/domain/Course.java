package dev.east0.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
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


    // ----------------------------
    //  Single-Valued Association
    // -----------------------------
    @ManyToOne
    @JoinColumn(name = "professorId")
    Professor professor;

    /* *********************************
    *    Collection-Valued Association
    *********************************** */
    @JsonIgnore
    @OneToMany(mappedBy = "course")
    List<Register> registers;








}
