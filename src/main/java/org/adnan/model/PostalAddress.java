package org.adnan.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class PostalAddress implements Serializable {

    private static final long serialVersionUID = -6912226900472571081L;
    private String city;
    private String street;

    private BigDecimal floor;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public BigDecimal getFloor() {
        return floor;
    }

    public void setFloor(BigDecimal floor) {
        this.floor = floor;
    }
}
