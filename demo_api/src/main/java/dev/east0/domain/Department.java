package dev.east0.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "departmentName")
    String name;

    /* *********************************
     *    Collection-Valued Association
     *********************************** */
    @JsonIgnore
    @OneToMany(mappedBy="department", fetch = FetchType.LAZY)
    List<Student> students;

    /* *********************************
     *    Collection-Valued Association
     *********************************** */
    @JsonIgnore
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    List<Professor> professors;


    /* *********************************
     *    Collection-Valued Association
     *********************************** */
    @JsonIgnore
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    List<User> users;


}
