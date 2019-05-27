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
    void putSymbol(ActionEvent event){
    	Button btn = (Button) event.getSource();
    	String id = btn.getId();
    	char symbol = ' ';
    	switch(id) {
    		case "zero":
    			symbol = '0';
    			break;
    		case "one":
    			symbol = '1';
    			break;
    		case "two":
    			symbol = '2';
    			break;
    		case "three":
    			symbol = '3';
    			break;
    		case "four":
    			symbol = '4';
    			break;
    		case "five":
    			symbol = '5';
    			break;
    		case "six":
    			symbol = '6';
    			break;
    		case "seven":
    			symbol = '7';
    			break;
    		case "eight":
    			symbol = '8';
    			break;
    		case "nine":
    			symbol = '9';
    			break;
    		case "subtract":
    			symbol = '-';
    			break;
    		case "add":
    			symbol = '+';
    			break;
    		case "multiply":
    			symbol = '*';
    			break;
    		case "divide":
    			symbol = '/';
    			break;
    		case "decimal":
    			symbol = '.';
    			break;
    	}
    	setDisplayBox(symbol);	
    }

    @FXML
    void clearAll(ActionEvent event) {
    	displayBox.setText("");
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
    
    void setDisplayBox(char c) {
    	String oldText = displayBox.getText();
    	displayBox.setText(oldText + c);
    }


}
