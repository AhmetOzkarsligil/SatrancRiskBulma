package model.tas;

import controller.vektor.Bati;
import controller.vektor.Dogu;
import controller.vektor.Guney;
import controller.vektor.GuneyBati;
import controller.vektor.GuneyDogu;
import controller.vektor.Kuzey;
import controller.vektor.KuzeyBat�;
import controller.vektor.KuzeyDogu;
import controller.vektor.Vektor;
import model.enums.Renk;
import model.enums.Tas;
import model.tahta.Konum;
import model.tahta.Tahta;

public class Sah extends SatrancTasi{

	
	

	public Sah(Renk renk, Konum konum, Tahta tahta,int puan) {
		super(renk, konum,tahta,puan);
	}
	
/*
 * 
 *  Factory design pattern ile Tas Fabrikasi tarafindan �retilen Sah nesnesinin konumuna 
 *  strategy design pattern ile olu�turulan a�a��da �retilen  vekt�rler eklenerek 
 *  Sah tasinin tehit edebilece�i yeni konumlar bulunmu�tur. Bulunan bu konumlarda da rakip renkten bir tas var ise
 *  tehtitAlani dizisine kay�t edilmi�tir...
 *   
 *   
 */
	@Override
	public void tehtitEdilenKonum(boolean [][] tehtitAlani) {
		// TODO Auto-generated method stub
		

		
		konumTehtitAlgila( new Vektor(new Kuzey()).konumaGit(getKonum().getSatir(),getKonum().getSutun(),getTahta()), tehtitAlani);
		
		konumTehtitAlgila( new Vektor(new Guney()).konumaGit(getKonum().getSatir(), getKonum().getSutun(), getTahta()), tehtitAlani);
		
		konumTehtitAlgila( new Vektor(new Dogu()).konumaGit(getKonum().getSatir(), getKonum().getSutun(), getTahta()), tehtitAlani);
		
		konumTehtitAlgila( new Vektor(new Bati()).konumaGit(getKonum().getSatir(), getKonum().getSutun(), getTahta()), tehtitAlani);
		
		
		konumTehtitAlgila( new Vektor(new KuzeyBat�()).konumaGit(getKonum().getSatir(),getKonum().getSutun(),getTahta()), tehtitAlani);
		
		konumTehtitAlgila( new Vektor(new KuzeyDogu()).konumaGit(getKonum().getSatir(),getKonum().getSutun(),getTahta()), tehtitAlani);
		
		konumTehtitAlgila( new Vektor(new GuneyBati()).konumaGit(getKonum().getSatir(), getKonum().getSutun(), getTahta()), tehtitAlani);
		
		konumTehtitAlgila( new Vektor(new GuneyDogu()).konumaGit(getKonum().getSatir(), getKonum().getSutun(), getTahta()), tehtitAlani);
		
				
	}
	
	@Override
	public String toString() {
		return "s";
	}
	
}
