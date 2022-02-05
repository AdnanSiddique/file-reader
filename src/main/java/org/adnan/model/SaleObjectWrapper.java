package org.adnan.model;

import jakarta.xml.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "SaleObjects")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleObjectWrapper implements Serializable {
    private static final long serialVersionUID = 1861921195443706651L;

    @XmlAttribute(name = "count")
    private Integer numberOfSaleObjects;

    @XmlElement(name = "SaleObject")
    private List<SaleObject> saleObjects;

    public SaleObjectWrapper() {
    }

    public SaleObjectWrapper(Integer numberOfSaleObjects, List<SaleObject> saleObjects) {
        this.numberOfSaleObjects = numberOfSaleObjects;
        this.saleObjects = saleObjects;
    }

    public Integer getNumberOfSaleObjects() {
        return numberOfSaleObjects;
    }

    public void setNumberOfSaleObjects(Integer numberOfSaleObjects) {
        this.numberOfSaleObjects = numberOfSaleObjects;
    }

    public List<SaleObject> getSaleObjects() {
        return saleObjects;
    }

    public void setSaleObjects(List<SaleObject> saleObjects) {
        this.saleObjects = saleObjects;
    }
}
