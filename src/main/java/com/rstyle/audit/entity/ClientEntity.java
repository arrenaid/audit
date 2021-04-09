package com.rstyle.audit.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "client")
public class ClientEntity {
    @Id
//    @SequenceGenerator(name = "client_generator", sequenceName = "client_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_generator")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int client_id;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "place_of_birth")
    private String placeOfBirth;

    //    @Column(name = "ident_doc")
//    private int identDoc;
//    private DocEntity identDoc;
    @Column(name = "type_doc")
    private  int typeDoc;
    @Column(name = "number_docseries_doc")
    private String numberDoc;
    @Column(name = "series_doc")
    private String seriesDoc;
    @Column(name = "issue_date_doc")
    private Date issueDateDoc;

    @Column(name = "arrest_list")
    private int arrestList;

//    private List<ArrestEntity> localArrestList;


    public ClientEntity() {
    }

    public ClientEntity(String lastName, String firstName, Date dateOfBirth, String placeOfBirth, int typeDoc, String numberDoc, String seriesDoc, Date issueDateDoc, int arrestList) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.typeDoc = typeDoc;
        this.numberDoc = numberDoc;
        this.seriesDoc = seriesDoc;
        this.issueDateDoc = issueDateDoc;
        this.arrestList = arrestList;
    }

    public ClientEntity(String lastName, String firstName, Date dateOfBirth, String placeOfBirth, int typeDoc, String numberDoc, String seriesDoc, Date issueDateDoc) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.typeDoc = typeDoc;
        this.numberDoc = numberDoc;
        this.seriesDoc = seriesDoc;
        this.issueDateDoc = issueDateDoc;
    }

    public ClientEntity(String lastName, String firstName, Date dateOfBirth, String placeOfBirth, int typeDoc, String numberDoc, String seriesDoc) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.typeDoc = typeDoc;
        this.numberDoc = numberDoc;
        this.seriesDoc = seriesDoc;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public int getArrestList() {
        return arrestList;
    }

    public void setArrestList(int arrestList) {
        this.arrestList = arrestList;
    }

    public int getTypeDoc() {
        return typeDoc;
    }

    public void setTypeDoc(int typeDoc) {
        this.typeDoc = typeDoc;
    }

    public String getNumberDoc() {
        return numberDoc;
    }

    public void setNumberDoc(String numberDoc) {
        this.numberDoc = numberDoc;
    }

    public String getSeriesDoc() {
        return seriesDoc;
    }

    public void setSeriesDoc(String seriesDoc) {
        this.seriesDoc = seriesDoc;
    }

    public Date getIssueDateDoc() {
        return issueDateDoc;
    }

    public void setIssueDateDoc(Date issueDateDoc) {
        this.issueDateDoc = issueDateDoc;
    }

    //    public List<ArrestEntity> getLocalArrestList() {
//        return localArrestList;
//    }
//
//    public void setLocalArrestList(List<ArrestEntity> localArrestList) {
//        this.localArrestList = localArrestList;
//    }
//    public void addLocalArrestList(ArrestEntity arrest){
//        this.localArrestList.add(arrest);
//    }
}
