package application;

public class ManufacturingInformation {
	private String company;
	private String address;
	
	public ManufacturingInformation(String company, String address) {
        this.company = company;
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
