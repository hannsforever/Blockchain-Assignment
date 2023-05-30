module assignment {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.sql;
	requires java.base;
	requires gson;
	exports application;
	opens application;
	
//	opens application to javafx.graphics, javafx.fxml;
}