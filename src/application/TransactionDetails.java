package application;

import java.time.LocalDateTime;

public class TransactionDetails {
	private LocalDateTime transactionDateTime;
    private String supplierName;

    public TransactionDetails(LocalDateTime transactionDateTime, String supplierName) {
        this.transactionDateTime = transactionDateTime;
        this.supplierName = supplierName;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(LocalDateTime transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
