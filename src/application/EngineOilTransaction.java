package application;

import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EngineOilTransaction implements Serializable {
	
    private static final long serialVersionUID = 1L;

    public String merkleRoot;
    private final int SIZE = 10;
    private List<ProductInformation> productInformationList;
    private List<SupplierInformation> supplierInformationList;
    private List<String> transactionDateTimeList;
    private List<String> digitalSignatureList;
    
    public EngineOilTransaction() {
        productInformationList = new ArrayList<>(SIZE);
        supplierInformationList = new ArrayList<>(SIZE);
        transactionDateTimeList = new ArrayList<>(SIZE);
        digitalSignatureList = new ArrayList<>(SIZE);
    }
    
    public List<ProductInformation> getProductInformationList() {
        return productInformationList;
    }

    public void addProductInformation(ProductInformation productInformation) {
        productInformationList.add(productInformation);
    }

    public List<SupplierInformation> getSupplierInformationList() {
        return supplierInformationList;
    }

    public void addSupplierInformation(SupplierInformation supplierInformation) {
        supplierInformationList.add(supplierInformation);
    }

    public List<String> getTransactionDateTimeList() {
		return transactionDateTimeList;
	}

	public void addTransactionDateTime(String transactionDateTime) {
		transactionDateTimeList.add(transactionDateTime);
	}

    public List<String> getDigitalSignatureList() {
        return digitalSignatureList;
    }

    public void addDigitalSignature(String digitalSignature) {
        digitalSignatureList.add(digitalSignature);
    }
    
    public void setMerkleRoot(String root) {
    	this.merkleRoot = root;
    }
    
    public String getMerkleRoot() {
    	return this.merkleRoot;
    }

    @Override
	public String toString() {
		return "EngineOilTransaction [merkleRoot=" + merkleRoot + ", SIZE=" + SIZE + ", productInformationList="
				+ productInformationList + ", supplierInformationList=" + supplierInformationList
				+ ", transactionDateTimeList=" + transactionDateTimeList + ", digitalSignatureList="
				+ digitalSignatureList + "]";
	}
}
