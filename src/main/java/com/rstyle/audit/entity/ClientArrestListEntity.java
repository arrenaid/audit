package com.rstyle.audit.entity;

import javax.persistence.*;

@Entity
@Table(name = "client_arrest_list")
public class ClientArrestListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int arrest_list_id;
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
        return arrest_list_id;
    }

    public void setId(int id) {
        this.arrest_list_id = id;
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
