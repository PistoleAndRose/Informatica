/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import client.model.Auto;
import client.view.ClientViewController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author federico.rosato
 */


public class Client extends Application {

	public ObservableList<Auto> autoData = FXCollections.observableArrayList();
	private AnchorPane rootLayout;
	private Stage primaryStage;

	@Override
    public void start(Stage primaryStage) throws IOException {
        
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Client");
		
		Parent root = FXMLLoader.load(getClass().getResource("view/ClientView.fxml"));
		Scene scene = new Scene(root);
        initRootLayout();
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Client");
		primaryStage.show();
        showPersonOverview();
    }	
	
	public ObservableList<Auto> getAutoData(){
		return autoData;
	}
		
	public Client(){
		autoData.add(new Auto("meme"));
	}

//	@Override
//	public void start(Stage stage) throws Exception {
//		
//		Parent root = FXMLLoader.load(getClass().getResource("view/ClientView.fxml"));
//		
//		Scene scene = new Scene(root);
//		
//		stage.setScene(scene);
//		stage.setTitle("Client");
//		stage.show();
//	}
	
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Client.class.getResource("view/RootLayout.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void showPersonOverview() {
		try {
        
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Client.class.getResource("view/ClientView.fxml"));
			AnchorPane clientOverview = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			//rootLayout.setCenter(clientOverview);

			// Give the controller access to the main app.
			ClientViewController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
        e.printStackTrace();
		}
	}
    public Stage getPrimaryStage() {
        return primaryStage;
    }
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
