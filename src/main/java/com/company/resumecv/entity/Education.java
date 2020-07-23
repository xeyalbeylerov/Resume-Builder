package com.company.resumecv.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "education")
@Data
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String educationDate;
    private String educationHeader;
    private String educationBody;
}
