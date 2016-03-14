package com.server.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "movements")
public class Movement implements Serializable {
    private static final long serialVersionUID = -5213809218541415247L;

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

    public Movement(){
    }

    public Movement(Movement another) {
        this.orderdate = another.getOrderdate();
        this.ordernum = another.getOrdernum();
        this.ordertype = another.getOrdertype();
        this.fio = another.getFio();
        this.ordertext = another.getOrdertext();
    }

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
