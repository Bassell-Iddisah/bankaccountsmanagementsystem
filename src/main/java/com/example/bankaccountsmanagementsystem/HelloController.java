package com.example.bankaccountsmanagementsystem;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class HelloController implements Initializable {
    @FXML
    private TextField acc;

    @FXML
    private Text namelabel;

    @FXML
    private  Text acclabel;

    @FXML
    private  Text accountlabel;

    @FXML
    private ComboBox<String> dropdown;

    @FXML
    private TextField name;

    @FXML
    private TextField takeAmount;

    @FXML
    private Text userBalance;

//    @FXML
//    private Checkbox enablePicker;

    @FXML
    private DatePicker selectMaturityDate;

    @FXML
    private Text maturationDate;

    @FXML
    private Text dateToMature;

    @FXML
    private DatePicker getMaturationDate;

    @FXML
    private Tab transactionsTab;

    @FXML
    private Text transactionsCurrentBalance;

    @FXML
    private TextField addAmount;

    @FXML
    private Button withdrawButton;

    @FXML
    void handleCheckBoxToggle(ActionEvent event) {
//        System.out.println(enableMaturity.getState());enableMaturity.getState()
        selectMaturityDate.setDisable(true);
    }




    @FXML
    void initialize() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dropdown.setItems(FXCollections.observableArrayList(
                "Savings Account","Current Account","Fixed Deposit Account"
        ));
    }

    @FXML
    public void retreiveBalance(ActionEvent event) {
        String sBalance = "Ghs 0.00";

        if (currentAccount != null) {
            sBalance = String.format("Ghs %.2f", currentAccount.currentBalance);
        }

        userBalance.setText(sBalance);

    }

//    @FXML
//    public void startTransactions(ActionEvent event) {
//        if (((Tab) event.getSource()).isSelected()) {
//            String formattedBalance = String.format("Ghs %.2f", currentAccount.currentBalance);
//            transactionsCurrentBalance.setText(formattedBalance);
//        }
//    }

//    @FXML
//    void getCurrentBalance(ActionEvent event) {
//        if (currentAccount != null) {
//            System.out.println(currentAccount.currentBalance);
//        }

//    }

    private Account currentAccount;

    @FXML
    public void handleSubmit(javafx.event.ActionEvent actionEvent) {
        String accName= name.getText();
        String accNumber=acc.getText();
        String accType = dropdown.getSelectionModel().getSelectedItem();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalDate date = getMaturationDate.getValue();
//        String maturity = date.format(formatter);
        String sBalance = "Ghs 0.00";
        if (currentAccount != null) {
            sBalance = String.format("Ghs %.2f", currentAccount.currentBalance);
        }


        acclabel.setText(accNumber);
        accountlabel.setText(accType);
        namelabel.setText(accName);
        userBalance.setText(sBalance);
//        if (currentAccount.type == "Fixed Deposit") {
//            dateToMature.setText(maturity);
//        };

        // Validate maturity date data, creating object accordingly
//        if (maturity == null) {
        switch (accType) {
            case "Savings Account":
                currentAccount =  new SavingsAccount(accNumber, accName);
                break;
            case "Current Account":
                currentAccount =  new CurrentAccount(accNumber, accName);
                break;
//            }
        }
//        String maturityDate = maturity.toString();
        currentAccount =  new FixedDepositAccount(accNumber, accName);


        currentAccount.currentBalance += 1000;
    }

    @FXML
    public void getMaturationDate(ActionEvent event) {
    }

    public void withdrawhandle(ActionEvent actionEvent) {
        double amount = Double.parseDouble(takeAmount.getText());
        if (amount == 0) {
            System.out.println("Enter an amount to withdraw");
        }
            currentAccount.currentBalance -= amount;

        transactionsCurrentBalance.setText(String.format("Ghs %sf", currentAccount.currentBalance));

    }

    public void depositHandle(ActionEvent actionEvent) {
    }
}