package application;

public class ProductInformation {
	private String brand;
	private String name;
	private String code;
	private String specifications;
	
	public ProductInformation(String brand, String name, String code, String specifications) {
		this.brand = brand;
		this.name = name;
		this.code = code;
		this.specifications = specifications;
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

}
