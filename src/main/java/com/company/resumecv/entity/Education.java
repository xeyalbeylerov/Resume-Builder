package com.company.resumecv.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "education")
@Data
@EqualsAndHashCode(of = "id")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String educationDate;
    private String educationHeader;
    private String educationBody;
}
