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

public class Vezir extends SatrancTasi {

	
	Konum yeniKonum;

	public Vezir(Renk renk, Konum konum, Tahta tahta,int puan) {
		super(renk, konum,tahta,puan);
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "v";
	}
	
	/*
	 *	 
	 *  Factory design pattern ile Tas Fabrikasi tarafindan �retilen Vezir nesnesinin konumuna 
	 *  strategy design pattern ile olu�turulan a�a��da �retilen  vekt�rler eklenerek ve bu vekt�rerin y�n� boyunca tehtitleri
	 *  sorgulanarak Vezir tasinin tehit edebilece�i yeni konumlar bulunmu�tur. Bulunan bu konumlarda da rakip renkten
	 *  bir tas var ise tehtitAlani dizisine kay�t edilmi�tir...
	 *   
	 */
	@Override
	public void tehtitEdilenKonum(boolean [][] tehtitAlani) {
	
		yeniKonum = new Konum(getKonum().getSatir(), getKonum().getSutun());
		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new KuzeyDogu())), tehtitAlani);
		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new KuzeyBat�())), tehtitAlani);
		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new GuneyDogu())), tehtitAlani);
				
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new GuneyBati())), tehtitAlani);
		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new Kuzey())), tehtitAlani);
		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new Guney())), tehtitAlani);
		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new Dogu())), tehtitAlani);
		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new Bati())), tehtitAlani);
		
		
	}
	
	
}
