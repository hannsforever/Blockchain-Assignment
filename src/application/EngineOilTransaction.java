package application;

import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EngineOilTransaction implements Serializable {
	
    private static final long serialVersionUID = 1L;

    public String merkleRoot;
    private final int SIZE = 10;
    private List<ProductInformation> productInformation;
    private List<SupplierInformation> supplierInformation;
    private List<String> transactionDateTime;
    
    public EngineOilTransaction() {
        productInformation = new ArrayList<>(SIZE);
        supplierInformation = new ArrayList<>(SIZE);
        transactionDateTime = new ArrayList<>(SIZE);
    }
    
    public List<ProductInformation> getProductInformationList() {
        return productInformation;
    }

    public void addProductInformation(ProductInformation productInfo) {
        productInformation.add(productInfo);
    }

    public List<SupplierInformation> getSupplierInformationList() {
        return supplierInformation;
    }

    public void addSupplierInformation(SupplierInformation supplierInfo) {
        supplierInformation.add(supplierInfo);
    }

    public List<String> getTransactionDateTimeList() {
		return transactionDateTime;
	}

	public void addTransactionDateTime(String tranxDateTime) {
		transactionDateTime.add(tranxDateTime);
	}
    
    public void setMerkleRoot(String root) {
    	this.merkleRoot = root;
    }
    
    public String getMerkleRoot() {
    	return this.merkleRoot;
    }

    @Override
	public String toString() {
		return "EngineOilTransaction [merkleRoot=" + merkleRoot + ", SIZE=" + SIZE + ", productInformation="
				+ productInformation + ", supplierInformation=" + supplierInformation + ", transactionDateTime="
				+ transactionDateTime + "]";
	}
}
