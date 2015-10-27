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
    /*
    @Column
    private String ordertype;

    @Column
    private String fio;
    */

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


}
