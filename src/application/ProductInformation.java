package application;

import java.io.Serializable;

public class ProductInformation implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    private String brand;
    private String name;
    private String code;
    private String specifications;
    private String factory;
    private String manufacturingDate;

    public ProductInformation(String brand, String name, String code, String specifications, String factory, String manufacturingDate) {
        this.brand = brand;
        this.name = name;
        this.code = code;
        this.specifications = specifications;
        this.factory = factory;
        this.manufacturingDate = manufacturingDate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    @Override
    public String toString() {
        return "ProductInformation [brand=" + brand + ", name=" + name + ", code=" + code + ", specifications="
                + specifications + ", factory=" + factory + ", manufacturingDate=" + manufacturingDate + "]";
    }
}
