package com.company.resumecv.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "social")
@Data
public class Social {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String socialNetworkName;
    private String socialNetworkAddress;
}
