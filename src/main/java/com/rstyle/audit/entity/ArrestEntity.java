package com.rstyle.audit.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "arrest")
public class ArrestEntity {
    @Id
//    @SequenceGenerator(name = "arrest_generator", sequenceName = "arrest_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "arrest_generator")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "organ_code")
    private int organCode;
    @Column(name = "doc_date")
    private Date docDate;
    @Column(name = "doc_num")
    private String docNum;
    @Column
    private String purpose;
    @Column
    private Long amount;
    @Column(name = "ref_doc_num")
    private String refDocNum;
    @Column
    private int operation;
}
