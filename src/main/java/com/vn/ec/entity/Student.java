package com.vn.ec.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    @NotNull
    private String fullName;

    @Column(name = "birth_day")
    @NotNull
    private Date birthDay;

    @Column(name = "class_name")
    @NotNull
    private String className;

    @Column(name = "major")
    @NotNull
    private String major;

    @Column(name = "hometown")
    @NotNull
    private String hometown;

    @Column(name = "gender")
    @NotNull
    private String gender;

    @Column(name = "average_mark")
    @NotNull
    private Float averageMark;
    @Column(name = "delete_flag")
    @NotNull
    private Boolean deleteFlag = false;
}
