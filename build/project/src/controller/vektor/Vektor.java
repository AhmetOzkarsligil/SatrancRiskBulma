package controller.vektor;


import model.tahta.Konum;
import model.tahta.Tahta;

/**
*
* @author Ahmet OZKARSLIGÝL
*
*/

/**
 * 
 *  Bu sýnýf 2 boyutlu kartezyen koordinat sistemi üzerindeki Vektorleri temsil etmektedir.
 *  
 *  Satranç taþlarý için belirlenen hareketleri tanýmlamaktadýr.
 *  
 *  Satranç tahtasý kartezyen koordinat sistemi olarak kabul edilmiþtir. 
 *  
 *  Sýnýf içerisindeki fonksiyonlara taþlarýn konumu parametre olarak gönderilmelidir.
 *  Taþlarýn konumu vektörlerin baþlangýç noktasý ve koordinat sistemininin orijini olarak atanmaktadýr. 
 *  
 *  Fonksiyonlarda belirlenen vektörler taþlarýn konumlarýna eklenerek 
 *  Taþlarýn yeni konumlarý oluþturulmaktadýr. 
 * 
 *
 */

/**
 * 
 *	Strateji tasarým deseni kullanýlarak Vektor sýnýfý oluþuturulmuþtur. 
 * 	Vektor sýnýfýndan nesne üretirken istenilen yönde vektörün üretilebilinmektedir.
 *  
 *  Bu sýnýf satranç taþlarýnýn istenilen konumlara hareket etmesinde kullanýlmaktadýr.
 *  Bu sayade hareket etme ihtimali olan yerler belirlenmektedir.
 * 
 *	Strateji tasarým deseninin context sýnýfý olarak düþünülebilir.	
 *
 */



public class Vektor {

	
	private Yon yon;
	
	public Vektor() {}
	public Vektor(Yon yon) {
		this.yon = yon;
	}
	
	public Konum konumaGit(int x,int y, Tahta tahta) {
		
			return yon.konumaGit(x, y,tahta);
		
		
	}
	
	
}


