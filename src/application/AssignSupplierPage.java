package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class DropdownOption {
    private String label;
    private String value;

    public DropdownOption(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return label;
    }
}

public class AssignSupplierPage {
	private static String masterFolder = "master";
	private static String fileName = masterFolder+ "/chain.bin";
	
    private TextField supplierNameField;
    private TextField supplierAddressField;
    private ComboBox<DropdownOption> productCodeComboBox;
    private Button assignSupplierButton;
    private Button backButton;
    private String productInformationFilePath;
    private List<DropdownOption> productCodes = new ArrayList<>();

    public AssignSupplierPage(String productInformationFilePath) {
        this.productInformationFilePath = productInformationFilePath;
    }

    public void display() {
        Stage stage = new Stage();

        // Create GUI components
        supplierNameField = new TextField();
        supplierAddressField = new TextField();
        productCodeComboBox = new ComboBox<>();
        assignSupplierButton = new Button("Assign Supplier");
        backButton = new Button("Back");

        // Configure event handlers
        assignSupplierButton.setOnAction(event -> {
			try {
				assignSupplier(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
        backButton.setOnAction(event -> stage.close());

        // Create layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(
                new Label("Supplier Name:"),
                supplierNameField,
                new Label("Supplier Address:"),
                supplierAddressField,
                new Label("Product Code:"),
                productCodeComboBox,
                assignSupplierButton,
                backButton
        );

        // Set up scene and stage
        Scene scene = new Scene(root, 300, 275);
        stage.setTitle("Assign Supplier");
        stage.setScene(scene);
        stage.show();

        // Load the engine oil codes
        loadEngineOilCodes();
    }

    private void extractProductCodes(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("ProductInformation")) {
                    int startIndex = line.indexOf("code=") + 5;
                    int endIndex = line.indexOf(",", startIndex);
                    if (endIndex == -1) {
                        endIndex = line.indexOf("]", startIndex);
                    }
                    String code = line.substring(startIndex, endIndex);
                    productCodes.add(new DropdownOption(code, code));  // Create DropdownOption and add to the list
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadEngineOilCodes() {
        extractProductCodes(productInformationFilePath);  // Pass the file path as an argument
        ObservableList<DropdownOption> codeList = FXCollections.observableArrayList();
        
        // Add the product codes in reverse order to the codeList
        for (int i = productCodes.size() - 1; i >= 0; i--) {
            codeList.add(productCodes.get(i));
        }
        
        productCodeComboBox.setItems(codeList);
    }

    private void assignSupplier(Stage stage) throws Exception {
        String supplierName = supplierNameField.getText();
        String supplierAddress = supplierAddressField.getText();
        DropdownOption selectedOption = productCodeComboBox.getValue();

        if (supplierName.isEmpty() || supplierAddress.isEmpty() || selectedOption == null) {
            // Display an error message if any of the fields are empty
            System.out.println("Please fill in all the fields.");
        } else {
            // Get the product information based on the selected product code
            ProductInformation productInformation = getProductInformation(selectedOption.getValue());

            EngineOilTransaction eoTranx = new EngineOilTransaction();
            
            // Set the supplier information
            SupplierInformation supplierInformation = new SupplierInformation(supplierName, supplierAddress);
            eoTranx.addSupplierInformation(supplierInformation);

            // Set the product information
            eoTranx.addProductInformation(productInformation);

            Blockchain blockchain;
            
            // Check if the master folder exists, create it if it doesn't
            if(!new File(masterFolder).exists()) {
    			new File(masterFolder).mkdir();
    			
    			// Initialize the blockchain with a genesis block
    	        blockchain = Blockchain.getInstance(fileName);
    	        blockchain.genesis();
    		} else {
    			blockchain = Blockchain.getInstance(fileName);
    		}
            
            // Set the transaction date time
            String dateTimeNow = LocalDateTime.now().toString();
            eoTranx.addTransactionDateTime(dateTimeNow);

            // Generate digital signature
            generateDigitalSignature(eoTranx.toString(), dateTimeNow);
            
            // Write transaction file with the EngineOilTransaction
            writeTransactionFile(eoTranx, dateTimeNow);
            
            // Create a new Block with the EngineOilTransaction object
            String previousHash = blockchain.get().getLast().getHeader().getCurrentHash();
            Block block = new Block(previousHash);
            block.setTransactions(eoTranx);
            
            // Add the Block to the blockchain
            blockchain.nextBlock(block);
            
			System.out.println(block);
			blockchain.distribute();
            
            showSuccessDialog(); // Display a success dialog

            System.out.println("Supplier assigned successfully.");
            stage.close();
        }
    }
    
    private ProductInformation getProductInformation(String productCode) {
        try (BufferedReader reader = new BufferedReader(new FileReader(productInformationFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("ProductInformation") && line.contains("code=" + productCode)) {
                    // Extract the required attributes from the line
                    String brand = extractAttributeValue(line, "brand=");
                    String name = extractAttributeValue(line, "name=");
                    String code = extractAttributeValue(line, "code=");
                    String specifications = extractAttributeValue(line, "specifications=");
                    String factory = extractAttributeValue(line, "factory=");
                    String manufacturingDate = extractAttributeValue(line, "manufacturingDate=");

                    // Create and return the ProductInformation object
                    return new ProductInformation(brand, name, code, specifications, factory, manufacturingDate);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // If the product information is not found, return null or handle the case as required
        return null;
    }

    private String extractAttributeValue(String line, String attribute) {
    	int startIndex = line.indexOf(attribute) + attribute.length();
    	int endIndex = line.indexOf(",", startIndex);
    	if (endIndex == -1) {
    	    endIndex = line.indexOf("]", startIndex);
    	    if (endIndex == -1) {
    	        endIndex = line.length();  // Use the end of the line if "]" is not found
    	    }
    	}
    	return line.substring(startIndex, endIndex);
    }


    private void generateDigitalSignature(String data, String dt) throws Exception {
    	String folderName = "SignedTransaction";
    	File folder = new File(folderName);
        if (!folder.exists()) {
            folder.mkdir();
        }
    	
    	MyKeyPair.create();
		byte[] publicKey = MyKeyPair.getPublicKey().getEncoded();
		byte[] privateKey = MyKeyPair.getPrivateKey().getEncoded();
		MyKeyPair.put(publicKey, "MyKeyPair/PublicKey");
		MyKeyPair.put(privateKey, "MyKeyPair/PrivateKey");
		
		DigitalSignature signature = new DigitalSignature();
        byte[] signedTransaction = signature.getSignature(data, MyKeyPair.getPrivateKey());
        String fileName = "signed_eo_transaction_" + dt.replace(":", "-") + ".txt";
        String filePath = folderName + "/" + fileName;
        FileWriter writer = new FileWriter(filePath);
        // Write the transaction details to the file
        writer.write(signedTransaction.toString());
        writer.close();
        
        System.out.println("Transaction signed successfully in " + filePath);
        
    }

    private void writeTransactionFile(EngineOilTransaction transaction, String dt) {
        try {
            // Create the EngineOilTransaction folder if it doesn't exist
            String folderName = "EngineOilTransaction";
            File folder = new File(folderName);
            if (!folder.exists()) {
                folder.mkdir();
            }

            // Generate a unique file name based on the current timestamp
            String fileName = "engine_oil_transaction_" + dt.replace(":", "-") + ".txt";
            String filePath = folderName + "/" + fileName;
            FileWriter writer = new FileWriter(filePath);
            
            // Write the transaction details to the file
            writer.write(transaction.toString());
            writer.close();

            System.out.println("Transaction details saved successfully in " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void showSuccessDialog() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Assign Supplier");
        alert.setHeaderText(null);
        alert.setContentText("Supplier assigned successfully.");
        alert.showAndWait();
    }

}
