module assignment {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.sql;
	requires gson;
	
	opens application to javafx.graphics, javafx.fxml;
}
