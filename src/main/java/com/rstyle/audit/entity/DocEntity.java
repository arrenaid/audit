package com.rstyle.audit.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "client_doc")
public class DocEntity {
    @Id
//    @SequenceGenerator(name = "doc_generator", sequenceName = "doc_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doc_generator")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "type_")
    private  int type;
    @Column(name = "number_series")
    private String numberSeries;
    @Column(name = "issue_date")
    private Date issueDate;
}
