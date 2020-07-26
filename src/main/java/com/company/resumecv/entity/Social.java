package com.company.resumecv.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "social")
@Data
@EqualsAndHashCode(of = "id")
public class Social {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String socialNetworkName;
    private String socialNetworkAddress;
}
