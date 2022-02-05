package org.adnan.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
public class SaleObject implements Serializable {
    private static final long serialVersionUID = 2179807333028598577L;

    @XmlAttribute
    private String type;

    @XmlAttribute
    private Integer id;

    private Integer sizeSqm;

    private String startingPrice;

    private Integer pricePerSquareMeter;

    @XmlElement(name = "address")
    private PostalAddress postalAddress;

    public SaleObject() {
    }

    public SaleObject(String type, Integer id, Integer sizeSqm, String startingPrice, PostalAddress postalAddress) {
        this.type = type;
        this.id = id;
        this.sizeSqm = sizeSqm;
        this.startingPrice = startingPrice;
        this.postalAddress = postalAddress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSizeSqm() {
        return sizeSqm;
    }

    public void setSizeSqm(Integer sizeSqm) {
        this.sizeSqm = sizeSqm;
    }

    public String getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(String startingPrice) {
        this.startingPrice = startingPrice;
    }

    public PostalAddress getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }

    public Integer getPricePerSquareMeter() {
        return pricePerSquareMeter;
    }

    public void setPricePerSquareMeter(Integer pricePerSquareMeter) {
        this.pricePerSquareMeter = pricePerSquareMeter;
    }
}
