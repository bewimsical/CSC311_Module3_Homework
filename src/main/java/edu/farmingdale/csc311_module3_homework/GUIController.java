package edu.farmingdale.csc311_module3_homework;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GUIController {

    @FXML
    private TextField interestRateIn;
    @FXML
    private TextField loanAmountIn;
    @FXML
    private TextField monthlyPayment;
    @FXML
    private TextField totalPayment;
    @FXML
    private TextField yearsIn;
    @FXML
    private Label error;
    private boolean parseError = false;

    /**
     * This method converts a text field value to a double. It performs input validation and updates the style of the text field.
     * @param value text field value should be numerical
     * @return the text field value as a double or 0 if the value is not numerical
     */
    private double convert(TextField value){
        try{

            value.getStyleClass().remove("error");
            return Double.parseDouble(value.getText());
        }catch (NumberFormatException e){
            parseError = true;
            value.getStyleClass().add("error");
            return 0;
        }
    }

    /**
     * This method calculates the monthly payment and total payment and updates the text field values
     */
    @FXML
    protected void onCalcButtonClick() {
        parseError = false;
        double interestRate = convert(interestRateIn) / 100;
        double years = convert(yearsIn);
        double loanAmount = convert(loanAmountIn);

        if (!parseError) {
            double totalPaymentCalc = loanAmount + (loanAmount*years*interestRate);
            int months = (int)years * 12;
            double monthlyPaymentCalc = totalPaymentCalc/months;
            monthlyPayment.setText("$"+String.format("%.2f",monthlyPaymentCalc));
            totalPayment.setText("$"+String.format("%.2f",totalPaymentCalc));
            error.setText(" ");
        }else{
            error.setText("ERROR! Enter a valid value");
        }
    }
}