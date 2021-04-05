package com.rstyle.audit.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "client")
public class ClientEntity {
    @Id
//    @SequenceGenerator(name = "client_generator", sequenceName = "client_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_generator")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "ident_doc")
    private int identDoc;
//    private DocEntity identDoc;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Column(name = "arrest_list")
    private int arrestList;
//    private List<ArrestEntity> arrestList;
}
