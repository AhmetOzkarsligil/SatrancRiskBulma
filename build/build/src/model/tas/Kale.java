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

public class Kale extends SatrancTasi{

	Konum yeniKonum;



	public Kale(Renk renk, Konum konum, Tahta tahta,int puan) {
		super(renk, konum,tahta,puan);
	}
	
	@Override
	public String toString() {
		return "k";
	}
	
/*
 *	 
 *  Factory design pattern ile Tas Fabrikasi tarafindan üretilen Kale nesnesinin konumuna 
 *  strategy design pattern ile oluþturulan aþaðýda üretilen  vektörler eklenerek ve bu vektörerin yönü boyunca tehtitleri
 *  sorgulanarak Kale tasinin tehit edebileceði yeni konumlar bulunmuþtur. Bulunan bu konumlarda da rakip renkten
 *  bir tas var ise tehtitAlani dizisine kayýt edilmiþtir...
 *   
 */
	@Override
	public void tehtitEdilenKonum(boolean [][] tehtitAlani) {
		// TODO Auto-generated method stub
		

		
		yeniKonum = new Konum(getKonum().getSatir(), getKonum().getSutun());
		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new Kuzey())), tehtitAlani);
		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new Guney())), tehtitAlani);
		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new Dogu())), tehtitAlani);
		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new Bati())), tehtitAlani);
		
		
	}


}
