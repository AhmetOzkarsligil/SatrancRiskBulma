package controller.vektor;


import model.tahta.Konum;
import model.tahta.Tahta;

/**
*
* @author Ahmet OZKARSLIG�L
*
*/

/**
 * 
 *  Bu s�n�f 2 boyutlu kartezyen koordinat sistemi �zerindeki Vektorleri temsil etmektedir.
 *  
 *  Satran� ta�lar� i�in belirlenen hareketleri tan�mlamaktad�r.
 *  
 *  Satran� tahtas� kartezyen koordinat sistemi olarak kabul edilmi�tir. 
 *  
 *  S�n�f i�erisindeki fonksiyonlara ta�lar�n konumu parametre olarak g�nderilmelidir.
 *  Ta�lar�n konumu vekt�rlerin ba�lang�� noktas� ve koordinat sistemininin orijini olarak atanmaktad�r. 
 *  
 *  Fonksiyonlarda belirlenen vekt�rler ta�lar�n konumlar�na eklenerek 
 *  Ta�lar�n yeni konumlar� olu�turulmaktad�r. 
 * 
 *
 */

/**
 * 
 *	Strateji tasar�m deseni kullan�larak Vektor s�n�f� olu�uturulmu�tur. 
 * 	Vektor s�n�f�ndan nesne �retirken istenilen y�nde vekt�r�n �retilebilinmektedir.
 *  
 *  Bu s�n�f satran� ta�lar�n�n istenilen konumlara hareket etmesinde kullan�lmaktad�r.
 *  Bu sayade hareket etme ihtimali olan yerler belirlenmektedir.
 * 
 *	Strateji tasar�m deseninin context s�n�f� olarak d���n�lebilir.	
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


