package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import javafx.beans.value.ObservableValue;

import model.enums.Renk;

import model.sonuc.SonucTableView;

import model.tahta.Konum;
import model.tahta.Tahta;
import model.tas.TasFabrikasi;



public class SatrancRiskUygulamasiController extends Application {

	@FXML
    private Button btnGozAt;

    @FXML
    private Button btnKaydet;
    
    @FXML
    private TextField txtPath;
    
    @FXML
    private TextArea textArea;
    
    @FXML
    private TableView<SonucTableView> tableView;
    
    @FXML
    private TableColumn<SonucTableView, String> tableCol_FileName;

    @FXML
    private TableColumn<SonucTableView, Float> tableCol_ResBlack;

    @FXML
    private TableColumn<SonucTableView, Float> tableCol_ResWhite;
    
    private	TasFabrikasi tasFabrikasi;
    private String temp="";
    private Renk renk;
	
    private Tahta 	tahta;
    private boolean [][] tehtitAlani;
    
	private File file;
	private List resultlist = new ArrayList();
	private ObservableList<SonucTableView> resultObsList;
	
	private  String filePath="";
  @FXML
    public void initialize() {
	  
	  tableCol_FileName.setCellValueFactory(new PropertyValueFactory<SonucTableView, String>("path"));
	  tableCol_ResBlack.setCellValueFactory(new PropertyValueFactory<SonucTableView, Float>("siyahSonuc"));
	  tableCol_ResWhite.setCellValueFactory(new PropertyValueFactory<SonucTableView, Float>("beyazSonuc"));
	  
	  TableColumn tableCol_Result = new TableColumn("Sonuc");
	  tableCol_Result.getColumns().addAll(tableCol_ResBlack, tableCol_ResWhite);
	  tableView.getColumns().setAll(tableCol_FileName,tableCol_Result);
	  tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	  
	  tasFabrikasi = new TasFabrikasi();
	  tahta = new Tahta(8,8);
       
	  file =null;
	  txtPath.textProperty().addListener((observable, oldValue, newValue) -> {
		  	filePath = newValue;
		  	System.err.println(filePath);
		});
	  
	
	  
    }

  
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
	}
	
	
    @FXML
    void btnGozAt_Click(ActionEvent event) {
    	
    	Stage stage = (Stage)btnGozAt.getScene().getWindow();
    
    	 FileChooser fileChooser = new FileChooser();
         fileChooser.setTitle("Satranc Tahta Dosyasini Secin");
         fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
         
         file = fileChooser.showOpenDialog(stage);
		
         if (file != null) {
            
			txtPath.setText(file.getAbsolutePath());
			
			fileToTable(file.getAbsoluteFile(),tahta);
         }
		
         setTextAreafromTable(tahta);
    }
    

    
    /*
     * txtPath text fieldina girilen veya goz at dan se�ilen dosya ya g�re 
     * Sonucu hesaplar ve tabe view da g�r�nt�ler.
     * 
     * text field a yaz�lan dosya yolunun do�ru girilece�i varsay�lm��t�r. Bu kontroller yapilmami�tir.
     */
    @FXML
    void btnRiskHesapla_Click(ActionEvent event) {
    	
    	//Sadece board1 i se�tikten sonra board2-3-4 ler daha rahat se�ilsin, 
    	//h�zl�ca de�i�tirilsin diye eklenmi�tir...
    	if(txtPath != null) {
    		file = new File(filePath);
    		fileToTable(file.getAbsoluteFile(),tahta);
			setTextAreafromTable(tahta);
    		
    	}
    	
    	tehtitAlani =  new boolean[tahta.getSatir()][tahta.getSutun()];
    	tehtitAlaniBelirle(tehtitAlani);
    	
    	
    	
    	
    	 resultlist.add(new SonucTableView(file.getName().toString(), 
    			 			sonucHesapla(tehtitAlani, tahta,Renk.SIYAH), 
							  sonucHesapla(tehtitAlani, tahta,Renk.BEYAZ)));
    	 
    	 resultObsList = FXCollections.observableList(resultlist);
    	 tableView.setItems(resultObsList);
    
    }

    /*
     * Program s�resince elde edilen table view da g�r�nt�lenen sonu�lar�
     * Mail de g�nderilen sonuclar.txt i�eri�iyle ayn� olucak �ekilde 
     * istenilen konuma kay�t etmektedir.
     */
    @FXML
    void btnKaydet_onClick(ActionEvent event) {
    	
    	///System.out.println(resultlist.get(0));
    	
    	if(resultObsList == null) {
    		System.err.println("l�tfen once g�z at dan dosya se�in sonra da ekleyin");
    		
    		Alert alert = new Alert(AlertType.WARNING);
	    	alert.setTitle("Uyari !");
	    	alert.setHeaderText("Sonuc bulunamadi");
	    	alert.setContentText("Oncelikle dosya secin ve risk hesaplay�n sonra kaydet butonuna basin");
	
	    	alert.showAndWait();
    		
    	}
    		else
    	{
    	  	String sonuclar="";
        	
        	Stage stage = (Stage)btnKaydet.getScene().getWindow();
            
       	 	FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Sonuclari Kayit Etmek �stediginiz Yeri Secin");
            fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
            fileChooser.setInitialFileName("sonuclar");
            
            file = fileChooser.showSaveDialog(stage);
    		
            if (file != null) {
            	
            	try {
        			
            		BufferedWriter buffWriter = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            		buffWriter.write("Tahta Dosya Ad�" + "\t\t" + "Sonu�lar" +"\n");

            		for (SonucTableView sonuc : resultObsList) {
            			buffWriter.write(sonuc.getPath() + "\t\t" + "Siyah:" 
            								+ sonuc.getSiyahSonuc() +"\t\t" + 
            									"Beyaz:" + sonuc.getBeyazSonuc() + "\n");
            		}
            		
            		buffWriter.close();
        		} catch (IOException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
            }
    	}
    }
    
    /*
     * Bu fonksiyon sadece g�r�nt�leme ama�l� yap�lm��t�r.
     * Gelen tahta i�erisindeki ta�lar�n isim konum renk bilgisini yazd�r�lmas�n� sa�lar.
     * 
     */
    void setTextAreafromTable(Tahta tahta) {
    	
    	String tempNumerics="";
    	String tempWords ="";
    	
    	for ( int i = 8 - 1; i > -1; i--) {
			for (int j = 0; j < 8; j++) {
				if(tahta.getKare()[i][j] != null) {
					
					tempNumerics +=tahta.getKare()[i][j].getKonum() +" "+ tahta.getKare()[i][j] + "" +tahta.getKare()[i][j].getRenk().etiket + "\t\t";
					
					tempWords +=tahta.getKare()[i][j].getKonum().konumDonustur() +" "+ tahta.getKare()[i][j] + "" +tahta.getKare()[i][j].getRenk().etiket + "\t\t";
					
					System.out.print( tahta.getKare()[i][j].getKonum() +" "+ tahta.getKare()[i][j] + "" +tahta.getKare()[i][j].getRenk().etiket + "\t") ;
				}
					
				else
				{
					System.out.print("("+i+" , "+j+")" + " --\t") ;
					
					tempNumerics += "("+i+" , "+j+")" + " --" + "\t\t";
					
					tempWords += "(" + (i + 1) + " , " + (char) (j+'a') + ")" +" --"+"\t\t";
				}
				
			}
			tempNumerics +="\n";
			tempWords +="\n";
			System.out.println();
		}
    	textArea.setText(tempNumerics + "\n\n" + tempWords);
    }
    
    
/*
 *  Se�ilen dosya i�erisinden �ekilen ta� isimlerine g�re Fabrika tasar�m deseni kullan�larak satran� ta�lar� �retilir.
 *  �retilen ta�lar parametre olarak gelen tahta nesnesi i�erisine yerle�tirilir.
 * 
 *  Fonksiyona ta�lar�n bilgisini i�eren dosya bilgisi gelir , Ta�lar �retilir ve gelen tahta de�i�kenine kay�t edilir.
 */   
    void fileToTable(File file, Tahta tahta ) {
    	
    	int i,j;
    	
    	Scanner okuyucu;
		try {
			okuyucu = new Scanner(file);
		
			// dizinin 0,0 indexli eleman� 1a ( .txt de yer alan boardun sol alt�ndaki index ) ' a e�it olacak �ekilde aktar�lmaktad�r.
			for ( i = tahta.getKare().length - 1; i > -1; i--) { 
				for (j = 0; j < tahta.getKare()[i].length; j++) {
					
					if (okuyucu.hasNext())
						temp = okuyucu.next();
					else
						break;
						tahta.getKare()[i][j] = tasFabrikasi.tasUret(temp.charAt(0), getRenk(temp.charAt(1)), new Konum(i,j),tahta); 
				}
			}
			
		}  catch (FileNotFoundException e){
            System.out.println("-> Arad���n�z Dosyaya Ula�amad�m.\n-> Hata Mesaj�m: "+ e.getMessage());
        }
        catch (IOException e){
            System.out.println("-> Arad���n�z Dosya �zerinde Veri Okuyam�yorum.\n-> Hata Mesaj�m: "+ e.getMessage());
        }
        finally {
            System.out.println("-----------------------\n");
        }
    }
    
    
/*
 * 
 * Satran� tahtas�ndaki ta�lar�n di�er hangi ta� konumlar�n� tehtit etti�ini bularak 
 * Parametre olarak g�nderilen tehtitAlani dizisine kay�t eder. 
 * 
 * Ta�lar tehtitEdilenKonum fonksiyonunun i�erisinde controller.vektor paketiyle olu�turulan
 * strateji tasar�m desenini kullanarak tehtit edilen konumlar bulunmaktad�r.
 * 
 */
    void tehtitAlaniBelirle(boolean [][] tehtitAlani){
    	
    	if(tehtitAlani.length == tahta.getSatir() && tehtitAlani[0].length == tahta.getSutun()) {
    		
    		for (int i = tahta.getKare().length - 1; i > -1; i--) { // normal dizi �ekimi i�in d�ng�y� standart haline getir
    			//for ( i = 0; i < board.length ; i++) {	
    				for (int j = 0; j < tahta.getKare()[i].length; j++) {
    					
    					
    					if(tahta.getKare()[i][j] != null)
    						tahta.getKare()[i][j].tehtitEdilenKonum(tehtitAlani);
    				}
    				
    			}
    	}
    	
    }
    
 
    /*
     * Fonksiyona satran� tahtasi, tehtit alanlar�n� ve hesaplanmas� istenen ta� rengi g�nderilir.
     * Fonksiyondan Sonu� bilgisi geri d�ner.
     */
	public float sonucHesapla(boolean [][] tehtitAlani, Tahta tahta, Renk renk) {
		float sonucBeyaz=0, sonucSiyah=0;
		
		for (int i = tehtitAlani.length - 1; i > -1 ; i--) {
			for (int j = 0; j < tehtitAlani.length; j++) {
				
				if(tehtitAlani[i][j]) {
					//System.out.println(tahta.getKare()[i][j].getPuan()); 
					
					if( tahta.getKare()[i][j].getRenk() == Renk.BEYAZ )
						sonucBeyaz+= (float) tahta.getKare()[i][j].getPuan() / 2.0;
					else
						sonucSiyah+= (float) tahta.getKare()[i][j].getPuan() / 2.0;
				}
				
				else if(!tehtitAlani[i][j] && tahta.tasKontrol(new Konum(i,j))) {
					
					if(tahta.getKare()[i][j].getRenk() == Renk.BEYAZ)
						sonucBeyaz+= tahta.getKare()[i][j].getPuan();
					else
						sonucSiyah+= tahta.getKare()[i][j].getPuan();
				}
			}
		}
			if(Renk.BEYAZ == renk)
				return sonucBeyaz;
			else
				return sonucSiyah;
	}
    
	public	Renk getRenk(char renkEtiketi) {
		
		return charCompare(renkEtiketi,'b')  ? Renk.BEYAZ :((charCompare(renkEtiketi,'s'))  ? Renk.SIYAH : null);	
		
	}
	
	public	boolean charCompare(char c1, char c2) {
		if(c1 - c2 == 0 )
			return true;
		return false;
	}
}