package com.server.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "mov_archive")
public class MovementArchive implements Serializable {

    private static final long serialVersionUID = -336436136212724683L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private java.sql.Date orderdate;

    @Column
    private String ordernum;

    @Column
    private String ordertype;

    @Column
    private String fio;

    @Column
    private String ordertext;

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }
    public String getOrdertype() {

        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype;
    }

    public String getFio() {

        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getOrdertext() {
        return ordertext;
    }

    public void setOrdertext(String ordertext) {
        this.ordertext = ordertext;
    }
}
