package com.rstyle.audit.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "arrest")
public class ArrestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int arrest_id;
    @Column(name = "organ_code")
    private int organCode;
    @Column(name = "doc_date")
    private LocalDate docDate;
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

    public ArrestEntity() {
    }

    public ArrestEntity(int organCode, LocalDate docDate, String docNum,
                        String purpose, Long amount, String refDocNum) {
        this.organCode = organCode;
        this.docDate = docDate;
        this.docNum = docNum;
        this.purpose = purpose;
        this.amount = amount;
        this.refDocNum = refDocNum;
        this.operation = 1;
    }

    public int getArrest_id() {
        return arrest_id;
    }

    public void setArrest_id(int arrest_id) {
        this.arrest_id = arrest_id;
    }

    public int getOrganCode() {
        return organCode;
    }

    public void setOrganCode(int organCode) {
        this.organCode = organCode;
    }

    public LocalDate getDocDate() {
        return docDate;
    }

    public void setDocDate(LocalDate docDate) {
        this.docDate = docDate;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getRefDocNum() {
        return refDocNum;
    }

    public void setRefDocNum(String refDocNum) {
        this.refDocNum = refDocNum;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }
}
