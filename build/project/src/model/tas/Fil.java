package model.tas;

import controller.vektor.GuneyBati;
import controller.vektor.GuneyDogu;
import controller.vektor.KuzeyBat�;
import controller.vektor.KuzeyDogu;
import controller.vektor.Yon;
import controller.vektor.Vektor;
import model.enums.Renk;
import model.enums.Tas;
import model.tahta.Konum;
import model.tahta.Tahta;

public class Fil extends SatrancTasi{

	/*
	 * tehtitEdilenKonum fonksiyonu i�erisinde kullan�lacakt�r ancak her tehtitEdilenKonum fonksiyonu
	 * �a�r�ld���nda yeniden de�i�ken olu�turulup sonras�nda garbage collector taraf�ndan silinme i�lemi olmas�n
	 * diye burada tan�mlanm��t�r.
	 */
	SatrancTasi geciciTas; 
	
	Konum yeniKonum;
	
	//VektorEski vektor = new VektorEski();
	

	public Fil(Renk renk, Konum konum, Tahta tahta,int puan) {
		super(renk, konum,tahta,puan);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "f";
	}
	
	
	
	
	/*
	 *	 
	 *  Factory design pattern ile Tas Fabrikasi tarafindan �retilen Fil nesnesinin konumuna 
	 *  strategy design pattern ile olu�turulan a�a��da �retilen  vekt�rler eklenerek ve bu vekt�rerin y�n� boyunca tehtitleri
	 *  sorgulanarak Fil tasinin tehit edebilece�i yeni konumlar bulunmu�tur. Bulunan bu konumlarda da rakip renkten
	 *  bir tas var ise tehtitAlani dizisine kay�t edilmi�tir...
	 *   
	 */
	@Override
	public void tehtitEdilenKonum(boolean [][] tehtitAlani) {
		// TODO Auto-generated method stub
		
		yeniKonum = new Konum(getKonum().getSatir(), getKonum().getSutun());
		

		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new KuzeyDogu())), tehtitAlani);
		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new KuzeyBat�())), tehtitAlani);
		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new GuneyDogu())), tehtitAlani);
				
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new GuneyBati())), tehtitAlani);
		
	}

}
