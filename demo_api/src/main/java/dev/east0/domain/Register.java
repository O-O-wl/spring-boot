package dev.east0.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "register")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

   // ----------------------------
   //  Single-Valued Association
   // -----------------------------
    @JoinColumn(name = "courseId")
    @ManyToOne
    Course course;

    // ----------------------------
    //  Single-Valued Association
    // -----------------------------
    @ManyToOne
    @JoinColumn(name="studentId")
    Student student;






}
