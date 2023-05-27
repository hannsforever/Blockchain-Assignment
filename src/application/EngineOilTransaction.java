package application;

public class EngineOilTransaction {
	private ProductInformation productInformation;
    private ManufacturingInformation manufacturingInformation;
    private SupplierInformation supplierInformation;
    private TransactionDetails transactionDetails;
    private String digitalSignature;

    public EngineOilTransaction(ProductInformation productInformation, ManufacturingInformation manufacturingInformation,
                                SupplierInformation supplierInformation, TransactionDetails transactionDetails,
                                String digitalSignature) {
        this.productInformation = productInformation;
        this.manufacturingInformation = manufacturingInformation;
        this.supplierInformation = supplierInformation;
        this.transactionDetails = transactionDetails;
        this.digitalSignature = digitalSignature;
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
}
