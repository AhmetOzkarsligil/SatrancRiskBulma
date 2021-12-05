package model.tas;

import controller.vektor.GuneyBatiL1;
import controller.vektor.GuneyBatiL2;
import controller.vektor.GuneyBati;
import controller.vektor.GuneyDogu;
import controller.vektor.GuneyDoguL1;
import controller.vektor.GuneyDoguL2;
import controller.vektor.KuzeyBatiL1;
import controller.vektor.KuzeyBatilL2;
import controller.vektor.KuzeyBatý;
import controller.vektor.KuzeyDogu;
import controller.vektor.KuzeyDoguL1;
import controller.vektor.KuzeyDoguL2;
import controller.vektor.Vektor;


import model.enums.Renk;
import model.enums.Tas;
import model.tahta.Konum;
import model.tahta.Tahta;

public class At extends SatrancTasi {

	int satir,sutun;

	public At(Renk renk, Konum konum, Tahta tahta,int puan) {
		super(renk, konum,tahta,puan);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "a";
	}

	
	/*
	 * 
	 *  Factory design pattern ile Tas Fabrikasi tarafindan üretilen At nesnesinin konumuna 
	 *  strategy design pattern ile oluþturulan aþaðýda üretilen  vektörler eklenerek 
	 *  At tasinin tehit edebileceði yeni konumlar bulunmuþtur. Bulunan bu konumlarda da rakip renkten bir tas var ise
	 *  tehtitAlani dizisine kayýt edilmiþtir...
	 *   
	 *   
	 */
	@Override
	public void tehtitEdilenKonum(boolean [][] tehtitAlani) {
		// TODO Auto-generated method stub


		
		konumTehtitAlgila( new Vektor(new KuzeyBatiL1()).konumaGit(getKonum().getSatir(),getKonum().getSutun(),getTahta()), tehtitAlani);
		
		konumTehtitAlgila( new Vektor(new KuzeyDoguL1()).konumaGit(getKonum().getSatir(),getKonum().getSutun(),getTahta()), tehtitAlani);
		
		konumTehtitAlgila( new Vektor(new GuneyBatiL1()).konumaGit(getKonum().getSatir(), getKonum().getSutun(), getTahta()), tehtitAlani);
		
		konumTehtitAlgila( new Vektor(new GuneyDoguL1()).konumaGit(getKonum().getSatir(), getKonum().getSutun(), getTahta()), tehtitAlani);
		
		
		konumTehtitAlgila( new Vektor(new KuzeyBatilL2()).konumaGit(getKonum().getSatir(),getKonum().getSutun(),getTahta()), tehtitAlani);
		
		konumTehtitAlgila( new Vektor(new KuzeyDoguL2()).konumaGit(getKonum().getSatir(),getKonum().getSutun(),getTahta()), tehtitAlani);
		
		konumTehtitAlgila( new Vektor(new GuneyBatiL2()).konumaGit(getKonum().getSatir(), getKonum().getSutun(), getTahta()), tehtitAlani);
		
		konumTehtitAlgila( new Vektor(new GuneyDoguL2()).konumaGit(getKonum().getSatir(), getKonum().getSutun(), getTahta()), tehtitAlani);
		
	}
	
}
