package controller;
	
import java.io.File;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private double x, y;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
			
			//Parent root = FXMLLoader.load(getClass().getResource("uygulama.view.Home.fxml"));
			
			Scene scene = new Scene(root,1200,800);
			scene.getStylesheets().add(getClass().getResource("/view/style.css").toExternalForm());
			primaryStage.setScene(scene);
			
			
			
			//primaryStage.initStyle(StageStyle.UNDECORATED);
			
			primaryStage.initStyle(StageStyle.UNDECORATED);
			
		     root.setOnMousePressed(event -> {
		            x = event.getSceneX();
		            y = event.getSceneY();
		        });
		     
	        root.setOnMouseDragged(event -> {

	            primaryStage.setX(event.getScreenX() - x);
	            primaryStage.setY(event.getScreenY() - y);

	        });
			
	    
	
			
			primaryStage.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
