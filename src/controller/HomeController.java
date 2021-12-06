package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import javafx.application.HostServices;

public class HomeController extends Application    {
	

    @FXML
    private Button btnCV;

    @FXML
    private Button btnGitLink;

    @FXML
    private Button btnKilavuz;

    @FXML
    private Button btnUygulama;

    @FXML
    private Button closeButton;
    
    @FXML
    private Label lblTitle;
    
    @FXML
    private Pane panelKilavuz;

    @FXML
    private Pane panelUygulama;

    @FXML
    private Pane panelAnaSayfa;
    
    @FXML
    private Button btnHome;
    
    @FXML
    private ImageView imageView_Pic;
    
    
    Pane newLoadedPane;
    Application app;
    
    private void initialize() {
		// TODO Auto-generated method stub
    	imageView_Pic.setImage(new Image(new File( getClass().getResource("/images/userGuide").getPath()).toURI().toString())); 
	}
    
    @FXML
    void exitClick(ActionEvent event) {
    	 
    	Stage stage = (Stage) closeButton.getScene().getWindow();
    	stage.close();
    	
    }
	
    @FXML
    void handleClicks(ActionEvent actionEvent) {
    	
    	
    	   if (actionEvent.getSource() == btnCV) {
    		   
			    try {
					
					HostServices hostServices = getHostServices();
					hostServices.showDocument(getClass().getResource("/view/CV_AOzkarsligil.pdf").toExternalForm());
					
				} catch (Exception e) {
					// TODO: handle exception
				}
		
           }
    	   
           if (actionEvent.getSource() == btnGitLink) {
            
      		  // lblTitle.setText("Git Link");
        	   
      		   Hyperlink link = new Hyperlink();
      		   link.setText("https://github.com/AhmetOzkarsligil/SatrancRiskBulma.git");
      		   
      		   HostServices hostServices = getHostServices();
      		   getHostServices().showDocument(link.getText());
      		   
           }
           
           // Kullanim Kilavuzu Sayfasi
           if (actionEvent.getSource() == btnKilavuz) {
        	   
        	   lblTitle.setText("Kullanma Kilavuzu");
        	   try {
        		   
	        		panelKilavuz.getChildren().clear();
					newLoadedPane = FXMLLoader.load(getClass().getResource("/view/Kilavuz.fxml"));
					panelKilavuz.getChildren().add(newLoadedPane);
					panelKilavuz.toFront();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	   			
   			
        	   
        	   
           }
           
           // Satranc Uygulama Sayfasi
           if(actionEvent.getSource()==btnUygulama)
           {
        	   lblTitle.setText("Satranc Risk Bulma Uygulamasi");
        	   try {
	
					panelUygulama.getChildren().clear();
					newLoadedPane = FXMLLoader.load(getClass().getResource("/view/SatrancRiskUygulamasi.fxml"));
					panelUygulama.getChildren().add(newLoadedPane);
					panelUygulama.toFront();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	   

           }
           
           // Ana Sayfa
           if(actionEvent.getSource()==btnHome)
           {
        	   lblTitle.setText("Ana Sayfa");
        	   panelAnaSayfa.toFront();
        	   

           }
          
    }

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}



	
}
