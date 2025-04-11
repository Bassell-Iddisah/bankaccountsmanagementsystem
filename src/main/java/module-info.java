module com.example.bankaccountsmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bankaccountsmanagementsystem to javafx.fxml;
    exports com.example.bankaccountsmanagementsystem;
}