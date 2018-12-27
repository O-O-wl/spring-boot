package dev.east0.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    @Column(name = "studentNumber")
    String studentNo;

    // ----------------------------
    //  Single-Valued Association
    // -----------------------------
    @ManyToOne
    @JoinColumn(name = "departmentId")
    Department department;

    /* *********************************
     *    Collection-Valued Association
     *********************************** */
    @JsonIgnore
    @OneToMany(mappedBy = "student")
    List<Register> registers;







}
