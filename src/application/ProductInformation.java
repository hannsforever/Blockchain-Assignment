package application;

public class ProductInformation {
	private String brand;
    private String name;
    private String code;
    private String specifications;
    private String manufacturingDate;

    public ProductInformation(String brand, String name, String code, String specifications, String manufacturingDate) {
        this.brand = brand;
        this.name = name;
        this.code = code;
        this.specifications = specifications;
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

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

}
