/**
 * 
 */
package model.tas;

import model.enums.Renk;
import model.enums.Tas;
import model.tahta.Konum;
import model.tahta.Tahta;

/**
 *  
 * 
 * @author Ahmet OZKARSLIG�L
 *
 */
public class Piyon extends SatrancTasi {

	
	public Piyon(Renk renk, Konum konum, Tahta tahta,int puan) {
		super(renk, konum,tahta,puan);
	}
	
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "p";
	}
	
	
	/*
	 * Tehtit edilen konumlar bulunurken renk bilgisine g�re
	 * piyonun hareket y�n� de�i�ece�i i�in renkIslem de�i�keni tan�mlanm��t�r. 
	 * Bu sayade tehtitEdilenKonum fonksiyonu i�erisinde daha az condition yaz�lm��t�r. 
	 */
	int renkIslem  = getRenk()== Renk.BEYAZ ? 1 : (getRenk() == Renk.SIYAH  ? -1  : 0);

	
	
	/*
	 * tehtitEdilenKonum fonksiyonu i�erisinde kullan�lacakt�r ancak her tehtitEdilenKonum fonksiyonu
	 * �a�r�ld���nda yeniden de�i�ken olu�turulup sonras�nda garbage collector taraf�ndan silinme i�lemi olmas�n
	 * diye burada tan�mlanm��t�r.
	 */
	SatrancTasi geciciTas; 
	int satir,sutun; 	

	
	

	
	/*
	 *  Piyon ta��n�n yapabilece�i hamleler dikkate al�narak, 
	 *  bu hamleler sonunucunda tehtit alt�nda tutulan ta�lar bulunarak tehtitAlan� dizisine kay�t edilmektedir.
	 *  
	 *  Fonksiyona satran� tahtas� boyutunda, boolean dizi adresi g�nderilerek dizinin i�eri�i de�i�tirilmektedir.
	 */
	@Override
	public void tehtitEdilenKonum( boolean [][] tehtitAlani) {
		
		
		/*
		 *  Beyaz renk piyonlar i�in kuzeyDo�u y�n�ne do�ru, Siyah renk piyonlar i�in  g�neyBat� y�n�ne do�ru
		 *  bir ad�m �apraz hareket y�n�nde gidildi�inde olu�an durumlar�n kontrol� yap�lmaktad�r.
		 */
		satir = getKonum().getSatir() + renkIslem;
		sutun = getKonum().getSutun() + renkIslem;
		konumTehtitAlgila(new Konum(satir,sutun), tehtitAlani);
		
		
		
		
		/*
		/*
		 *  Beyaz renk piyonlar i�in kuzeyBat� y�n�ne do�ru, Siyah renk piyonlar i�in  g�neyDo�u y�n�ne do�ru
		 *  bir ad�m �apraz hareket y�n�nde gidildi�inde olu�an durumlar�n kontrol� yap�lmaktad�r.
		 */
		
		sutun =  getKonum().getSutun() - renkIslem;
		konumTehtitAlgila(new Konum(satir,sutun), tehtitAlani);
		
		
	}

	// algoritmalar� grupla tek ad�m �apraz� �ah ve piyon ortak
	// �apraz vezir - fil ortak
	// kale d�z sonsuz 
	// strateji design pattern
	/*
	 * 6, 4
		5, 5
		4, 2
		4, 4
		3, 3
	 */
	
		
}
