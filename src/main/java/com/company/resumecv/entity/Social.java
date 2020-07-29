package com.company.resumecv.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "social")
@Data
@EqualsAndHashCode(of = "id")
public class Social implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String socialNetworkName;
    private String socialNetworkAddress;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="resume_id")
//    private Resume resume;
}
