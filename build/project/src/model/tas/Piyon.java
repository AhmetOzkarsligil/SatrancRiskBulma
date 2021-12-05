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
 * @author Ahmet OZKARSLIGÝL
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
	 * Tehtit edilen konumlar bulunurken renk bilgisine göre
	 * piyonun hareket yönü deðiþeceði için renkIslem deðiþkeni tanýmlanmýþtýr. 
	 * Bu sayade tehtitEdilenKonum fonksiyonu içerisinde daha az condition yazýlmýþtýr. 
	 */
	int renkIslem  = getRenk()== Renk.BEYAZ ? 1 : (getRenk() == Renk.SIYAH  ? -1  : 0);

	
	
	/*
	 * tehtitEdilenKonum fonksiyonu içerisinde kullanýlacaktýr ancak her tehtitEdilenKonum fonksiyonu
	 * çaðrýldýðýnda yeniden deðiþken oluþturulup sonrasýnda garbage collector tarafýndan silinme iþlemi olmasýn
	 * diye burada tanýmlanmýþtýr.
	 */
	SatrancTasi geciciTas; 
	int satir,sutun; 	

	
	

	
	/*
	 *  Piyon taþýnýn yapabileceði hamleler dikkate alýnarak, 
	 *  bu hamleler sonunucunda tehtit altýnda tutulan taþlar bulunarak tehtitAlaný dizisine kayýt edilmektedir.
	 *  
	 *  Fonksiyona satranç tahtasý boyutunda, boolean dizi adresi gönderilerek dizinin içeriði deðiþtirilmektedir.
	 */
	@Override
	public void tehtitEdilenKonum( boolean [][] tehtitAlani) {
		
		
		/*
		 *  Beyaz renk piyonlar için kuzeyDoðu yönüne doðru, Siyah renk piyonlar için  güneyBatý yönüne doðru
		 *  bir adým çapraz hareket yönünde gidildiðinde oluþan durumlarýn kontrolü yapýlmaktadýr.
		 */
		satir = getKonum().getSatir() + renkIslem;
		sutun = getKonum().getSutun() + renkIslem;
		konumTehtitAlgila(new Konum(satir,sutun), tehtitAlani);
		
		
		
		
		/*
		/*
		 *  Beyaz renk piyonlar için kuzeyBatý yönüne doðru, Siyah renk piyonlar için  güneyDoðu yönüne doðru
		 *  bir adým çapraz hareket yönünde gidildiðinde oluþan durumlarýn kontrolü yapýlmaktadýr.
		 */
		
		sutun =  getKonum().getSutun() - renkIslem;
		konumTehtitAlgila(new Konum(satir,sutun), tehtitAlani);
		
		
	}

	// algoritmalarý grupla tek adým çaprazý þah ve piyon ortak
	// çapraz vezir - fil ortak
	// kale düz sonsuz 
	// strateji design pattern
	/*
	 * 6, 4
		5, 5
		4, 2
		4, 4
		3, 3
	 */
	
		
}
