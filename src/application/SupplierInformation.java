package application;

import java.io.Serializable;

public class SupplierInformation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final String name;
	private final String address;
	
	public SupplierInformation(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

	@Override
	public String toString() {
		return "SupplierInformation [name=" + name + ", address=" + address + "]";
	}
}
