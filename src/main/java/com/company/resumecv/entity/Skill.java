package com.company.resumecv.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "skill")
@Data
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String skillName;
    private int power;
}
