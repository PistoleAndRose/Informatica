/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivelatore.model;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

/**
 *
 * @author stoyan.botusharov
 */
public class rivelatoreController {
	@FXML
	private Slider slider;
	@FXML
	private Button buttonStop;
	@FXML
	private Button buttonStart;
	@FXML
	private Label outSlide;
	
	
	private MainApp mainApp;
	
	public rivelatoreController(){}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
	
	private void handleStart(){
		
	}
	private void handleStop(){
		
	}
}
