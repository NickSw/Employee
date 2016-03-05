package com.server.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="workplace")
public class WorkPlace implements Serializable {

    private static final long serialVersionUID = 4843762317424280154L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String place;

    @Column
    private String address;

    @Column
    private String phone;

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlace() {

        return place;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
