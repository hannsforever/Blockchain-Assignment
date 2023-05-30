package application;

import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EngineOilTransaction implements Serializable {
	
    private static final long serialVersionUID = 1L;

    public String merkleRoot;
    private List<ProductInformation> productInformationList;
    private List<SupplierInformation> supplierInformationList;
    private List<TransactionDetails> transactionDetailsList;
    private List<String> digitalSignatureList;
    
    public EngineOilTransaction() {
        productInformationList = new ArrayList<>();
        supplierInformationList = new ArrayList<>();
        transactionDetailsList = new ArrayList<>();
        digitalSignatureList = new ArrayList<>();
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

    public List<TransactionDetails> getTransactionDetailsList() {
        return transactionDetailsList;
    }

    public void addTransactionDetails(TransactionDetails transactionDetails) {
        transactionDetailsList.add(transactionDetails);
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
		return "EngineOilTransaction [productInformationList=" + productInformationList + ", supplierInformationList="
				+ supplierInformationList + ", transactionDetailsList=" + transactionDetailsList
				+ ", digitalSignatureList=" + digitalSignatureList + "]";
	}
}
