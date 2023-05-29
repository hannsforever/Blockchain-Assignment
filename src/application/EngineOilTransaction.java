package application;

import java.io.Serializable;

public class EngineOilTransaction implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ProductInformation productInformation;
    private ManufacturingInformation manufacturingInformation;
    private SupplierInformation supplierInformation;
    private TransactionDetails transactionDetails;
    private String digitalSignature;

    public EngineOilTransaction(ProductInformation productInformation, ManufacturingInformation manufacturingInformation,
                                String digitalSignature) {
        this.productInformation = productInformation;
        this.manufacturingInformation = manufacturingInformation;
        this.digitalSignature = digitalSignature;
    }
    
    public void addSupplierInformation(SupplierInformation supplierInformation) {
        this.supplierInformation = supplierInformation;
    }

    public void addTransactionDetails(TransactionDetails transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public ProductInformation getProductInformation() {
        return productInformation;
    }

    public void setProductInformation(ProductInformation productInformation) {
        this.productInformation = productInformation;
    }

    public ManufacturingInformation getManufacturingInformation() {
        return manufacturingInformation;
    }

    public void setManufacturingInformation(ManufacturingInformation manufacturingInformation) {
        this.manufacturingInformation = manufacturingInformation;
    }

    public SupplierInformation getSupplierInformation() {
        return supplierInformation;
    }

    public void setSupplierInformation(SupplierInformation supplierInformation) {
        this.supplierInformation = supplierInformation;
    }

    public TransactionDetails getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(TransactionDetails transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public String getDigitalSignature() {
        return digitalSignature;
    }

    public void setDigitalSignature(String digitalSignature) {
        this.digitalSignature = digitalSignature;
    }
    
    @Override
    public String toString() {
        return "EngineOilTransaction{" +
                "productInformation=" + productInformation +
                ", manufacturingInformation=" + manufacturingInformation +
                ", supplierInformation=" + supplierInformation +
                ", transactionDetails=" + transactionDetails +
                ", digitalSignature='" + digitalSignature + '\'' +
                '}';
    }
}

