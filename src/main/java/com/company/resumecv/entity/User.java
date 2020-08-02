package com.company.resumecv.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode(of = "id")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;

    @OneToMany(orphanRemoval = true,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
//    @LazyCollection(LazyCollectionOption.FALSE)
//    @Fetch(value = FetchMode.SUBSELECT)
    private List<Resume> resumeList;
}
