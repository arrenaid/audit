package com.rstyle.audit.entity;

import javax.persistence.*;

@Entity
public class ClientArrestListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "id_client")
    private int idClient;
    @Column(name = "id_arrest")
    private int idArrest;

    public ClientArrestListEntity() {
    }

    public ClientArrestListEntity(int idClient, int idArrest) {
        this.idClient = idClient;
        this.idArrest = idArrest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdArrest() {
        return idArrest;
    }

    public void setIdArrest(int idArrest) {
        this.idArrest = idArrest;
    }
}
