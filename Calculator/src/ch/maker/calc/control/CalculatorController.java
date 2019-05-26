package ch.maker.calc.control;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {
	
    @FXML
    private Button zero;
	@FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button add;
    @FXML
    private Button subtract;
    @FXML
    private Button squareRoot;
    @FXML
    private Button positiveOrNegative;
    @FXML
    private Button clearAll;
    @FXML
    private Label displayBox;
    @FXML
    private Button equals;
    @FXML
    private Button divide;
    @FXML
    private Button multiply;
    @FXML
    private Button decimal;
    @FXML
    private Button deleteLast;

    @FXML
    void putZero(ActionEvent event) {
    	String text = displayBox.getText();
    	displayBox.setText(text + "0");

    }
    
    @FXML
    void putOne(ActionEvent event) {
    	String text = displayBox.getText();
    	displayBox.setText(text + "1");
    }
    
    @FXML
    void putTwo(ActionEvent event) {
    	String text = displayBox.getText();
    	displayBox.setText(text + "2");

    }

    @FXML
    void putThree(ActionEvent event) {
    	String text = displayBox.getText();
    	displayBox.setText(text + "3");

    }
    
    @FXML
    void putFour(ActionEvent event) {
    	String text = displayBox.getText();
    	displayBox.setText(text + "4");
    }

    @FXML
    void putFive(ActionEvent event) {
    	String text = displayBox.getText();
    	displayBox.setText(text + "5");
    }

    @FXML
    void putSix(ActionEvent event) {
    	String text = displayBox.getText();
    	displayBox.setText(text + "6");
    }
    
    @FXML
    void putSeven(ActionEvent event) {
    	String text = displayBox.getText();
    	displayBox.setText(text + "7");
    }
    
    @FXML
    void putEight(ActionEvent event) {
    	String text = displayBox.getText();
    	displayBox.setText(text + "8");
    }

    @FXML
    void putNine(ActionEvent event) {
    	String text = displayBox.getText();
    	displayBox.setText(text + "9");
    }

    @FXML
    void clearAll(ActionEvent event) {
    	displayBox.setText("");
    }
    
    @FXML
    void putDivision(ActionEvent event) {
    	String text = displayBox.getText();
    	displayBox.setText(text + "/");

    }
    
    @FXML
    void putMultiplication(ActionEvent event) {
    	String text = displayBox.getText();
    	displayBox.setText(text + "*");

    }
    
    @FXML
    void putSubtract(ActionEvent event) {
    	String text = displayBox.getText();
    	displayBox.setText(text + "-");

    }
    
    @FXML
    void putAdd(ActionEvent event) {
    	String text = displayBox.getText();
    	displayBox.setText(text + "+");

    }
    
    @FXML
    void putDecimal(ActionEvent event) {
    	String text = displayBox.getText();
    	displayBox.setText(text + ".");

    }

    @FXML
    void evaluate(ActionEvent event) {
    	ScriptEngineManager manager = new ScriptEngineManager();
    	ScriptEngine engine = manager.getEngineByName("js");
    	try {
    		String text = displayBox.getText();
			Object result = engine.eval(text);
			displayBox.setText(result+"");
		} catch (ScriptException e) {
			System.out.print(e);
			System.out.println("Invalid Equation");
		}
    }
    
    @FXML
    void deleteLast(ActionEvent event) {
    	String text = displayBox.getText();
    	try {
	    	text = text.substring(0, text.length()-1);
	    	displayBox.setText(text);
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
    @FXML
    void squareRoot(ActionEvent event) {
    	String text = displayBox.getText();
    	String sqrRoot = String.valueOf(Math.sqrt(Double.parseDouble(text))); 
    	displayBox.setText(sqrRoot);
    	
    }
    
    @FXML
    void plusMinus(ActionEvent event) {
    	String text = displayBox.getText();
    	double num = Double.parseDouble(text);
    	num = (num < 0) ? Math.abs(num) : num * -1;
    	text = String.valueOf(num);
    	displayBox.setText(text);
    }


}
