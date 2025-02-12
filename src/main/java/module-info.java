module edu.farmingdale.csc311_module3_homework {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.farmingdale.csc311_module3_homework to javafx.fxml;
    exports edu.farmingdale.csc311_module3_homework;
}