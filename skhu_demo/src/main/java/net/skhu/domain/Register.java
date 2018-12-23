package net.skhu.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table()
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

   // @JsonIgnore
    @JoinColumn(name = "courseId")
    @JsonIgnore
    @ManyToOne
    Course course;

    @ManyToOne
    @JoinColumn(name="studentId")
    Student student;






}
