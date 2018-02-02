/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view;

import client.Client;
import client.model.Auto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author federico.rosato
 */

public class ClientViewController implements Initializable {
	
	@FXML
	private Label label;
	
	@FXML
	private TableView<Auto> tabAuto;
	
	@FXML
	private TableColumn<Auto, String> colMacchina;
	
	@FXML
	private TableColumn<Auto, Float> colLat;	

	@FXML
	private TableColumn<Auto, Float> colLong;

	@FXML
	private TableColumn<Auto, Integer> colOrario;

	@FXML
	private TableColumn<Auto, Integer> colData;	
	
	private Client mainApp;

	@FXML
	private void handleButtonAction(ActionEvent event) {
		System.out.println("You clicked me!");
		label.setText("Hello World!");
	}	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		colMacchina.setCellValueFactory(autoData -> autoData.getValue().nameProperty());
//		colLat.setCellValueFactory(autoData -> autoData.getValue().latProperty());
//		colLong.setCellValueFactory(autoData -> autoData.getValue().nameProperty());
//		colData.setCellValueFactory(autoData -> autoData.getValue().nameProperty());
//		colOrario.setCellValueFactory(autoData -> autoData.getValue().nameProperty());
	}	
	
	public void setMainApp(Client mainApp){
		this.mainApp = mainApp;
	}
}
