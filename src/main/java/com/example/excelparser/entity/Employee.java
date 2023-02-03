package com.example.excelparser.entity;


import jakarta.persistence.*;
import lombok.Data;

/**
 * Entity for employee.
 */

@Data
@Entity
@Table(name = "Medicine")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer age;
}
