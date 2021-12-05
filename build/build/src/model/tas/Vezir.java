package model.tas;

import controller.vektor.Bati;
import controller.vektor.Dogu;
import controller.vektor.Guney;
import controller.vektor.GuneyBati;
import controller.vektor.GuneyDogu;
import controller.vektor.Kuzey;
import controller.vektor.KuzeyBatý;
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
	 *  Factory design pattern ile Tas Fabrikasi tarafindan üretilen Vezir nesnesinin konumuna 
	 *  strategy design pattern ile oluþturulan aþaðýda üretilen  vektörler eklenerek ve bu vektörerin yönü boyunca tehtitleri
	 *  sorgulanarak Vezir tasinin tehit edebileceði yeni konumlar bulunmuþtur. Bulunan bu konumlarda da rakip renkten
	 *  bir tas var ise tehtitAlani dizisine kayýt edilmiþtir...
	 *   
	 */
	@Override
	public void tehtitEdilenKonum(boolean [][] tehtitAlani) {
	
		yeniKonum = new Konum(getKonum().getSatir(), getKonum().getSutun());
		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new KuzeyDogu())), tehtitAlani);
		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new KuzeyBatý())), tehtitAlani);
		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new GuneyDogu())), tehtitAlani);
				
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new GuneyBati())), tehtitAlani);
		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new Kuzey())), tehtitAlani);
		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new Guney())), tehtitAlani);
		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new Dogu())), tehtitAlani);
		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new Bati())), tehtitAlani);
		
		
	}
	
	
}
