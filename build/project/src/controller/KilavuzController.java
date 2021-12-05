/**
 * 
 */
package controller;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * @author Ahmet
 *
 */

public class KilavuzController implements Initializable { 

    @FXML
    private ImageView imageView;

    @FXML
    private GridPane rootGridPane;
    
    @FXML
    private Label lblAciklama;
    
    @FXML
    private Label lblTitle;
    
    File [] fotoDizi;
    

    IntegerProperty intProperty = new SimpleIntegerProperty(0);
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		// TODO Auto-generated method stub
		//File folder = new File("src/images/userGuide"); 
		File folder = new File( getClass().getResource("/images/userGuide").getPath() ) ; 
		
		
		fotoDizi =folder.listFiles(); 
		
		lblAciklama.setTextFill(Color.web("#FFF"));
		    
	    intProperty.set(0);
	    
  	  	Image img =  new Image(fotoDizi[0].toURI().toString());
  	  	imageView.setImage(img);
  	  	lblAciklama.setText("Okun G�sterdi�i butona t�klayarak uygulama aray�z�n� a��n");
  	  	lblTitle.setText("Ad�m : 1"+ " Baslangic");
  	  	
		final ChangeListener changeListener = new ChangeListener() {
		      @Override
		      public void changed(ObservableValue observableValue, Object oldValue,
		          Object newValue) {
		    	 
		    	//  System.out.println("oldValue:"+ oldValue + ", newValue = " + newValue);
		
		    	  switch (Integer.parseInt( newValue.toString()) ) {
		    	  
	
					case 0:
						lblTitle.setText("Adim : 1"+ " Baslangic");
						lblAciklama.setText("Okun G�sterdi�i butona t�klayarak uygulama aray�z�n� a��n");
						break;
					
					case 1:
						lblTitle.setText("Ad�m : 2" + " Dosya Secimi");
						lblAciklama.setText("Okun G�sterdi�i 'Goz At' butonuna t�klayarak satran� tahta  "
								+ "dosyas�n� bilgisayar�n�zdan se�in ");
						break;
					
					case 2:
						lblTitle.setText("Ad�m : 3" + " Goruntuleme");
						lblAciklama.setText("Okun g�sterdi�i alanda Se�ilen dosya i�ersindeki ta�lar konumlar�yla birlikte g�r�nt�lenmektedir ");
						break;
					
					case 3:
						lblTitle.setText("Ad�m : 4" +  " Risk Hesaplama");
						lblAciklama.setText("Okun g�sterdi�i 'Risk Hesapla' isimli butona t�klayarak se�ilen tahtan�n riski hesaplan�r ve a�a��daki tabloya aktar�l�r");
						break;
					
					case 4:
						lblTitle.setText("Ad�m : 5" +  " Sonuc Goruntuleme");
						lblAciklama.setText("Okun G�sterdi�i tabloda sonuclar g�r�nt�lenmektedir.");
						break;
						
					case 5:
						lblTitle.setText("Ad�m : 6" +  " Kaydet");
						lblAciklama.setText("Okun G�sterdi�i 'Kaydet' butonuna t�klayarak tabloda yer alan sonu�lar� bilgisayar�n�za kay�t edebilirsiniz.");
						break;
						
					default:
						break;
					}
		    	  
		      }
		    };
		   
		    intProperty.addListener(changeListener);
		    
	}

	
    @FXML
    void btnBack(ActionEvent event) {
 
    	
    	int index=intProperty.get();
        
        if(intProperty.get() != 0) {
        	
        	intProperty.set( --index );
        	intProperty.set(index % fotoDizi.length);
        }
        else
        	intProperty.set(fotoDizi.length - 1);
        
      	Image img =  new Image(fotoDizi[intProperty.get()].toURI().toString());
      	imageView.setImage(img);
        
    }

    @FXML
    void btnNext(ActionEvent event) {
    	
    	int index=intProperty.get();
    	
    	if(intProperty.get() != fotoDizi.length)
    		 intProperty.set( ++index );
    	
    	
    	intProperty.set(index % fotoDizi.length);
    	 
	 	Image img =  new Image(fotoDizi[intProperty.get()].toURI().toString());
		imageView.setImage(img);
		
    	 
    }
    

	
}



