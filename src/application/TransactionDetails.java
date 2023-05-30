package application;

import java.io.Serializable;

public class TransactionDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    private String transactionDateTime;
    private String supplierName;

    public TransactionDetails(String transactionDateTime, String supplierName) {
        this.transactionDateTime = transactionDateTime;
        this.supplierName = supplierName;
    }

    public String getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(String transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

	@Override
	public String toString() {
		return "TransactionDetails [transactionDateTime=" + transactionDateTime + ", supplierName=" + supplierName
				+ "]";
	}
}
