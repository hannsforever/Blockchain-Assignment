package application;

import java.io.Serializable;

public class ProductInformation implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    private final String brand;
    private final String name;
    private final String code;
    private final String specifications;
    private final String factory;
    private final String manufacturingDate;

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


    public String getName() {
        return name;
    }


    public String getCode() {
        return code;
    }


    public String getSpecifications() {
        return specifications;
    }


    public String getFactory() {
        return factory;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    @Override
    public String toString() {
        return "ProductInformation [brand=" + brand + ", name=" + name + ", code=" + code + ", specifications="
                + specifications + ", factory=" + factory + ", manufacturingDate=" + manufacturingDate + "]";
    }
}
