package model.tas;

import controller.vektor.GuneyBati;
import controller.vektor.GuneyDogu;
import controller.vektor.KuzeyBatı;
import controller.vektor.KuzeyDogu;
import controller.vektor.Yon;
import controller.vektor.Vektor;
import model.enums.Renk;
import model.enums.Tas;
import model.tahta.Konum;
import model.tahta.Tahta;

public class Fil extends SatrancTasi{

	/*
	 * tehtitEdilenKonum fonksiyonu içerisinde kullanılacaktır ancak her tehtitEdilenKonum fonksiyonu
	 * çağrıldığında yeniden değişken oluşturulup sonrasında garbage collector tarafından silinme işlemi olmasın
	 * diye burada tanımlanmıştır.
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
	 *  Factory design pattern ile Tas Fabrikasi tarafindan üretilen Fil nesnesinin konumuna 
	 *  strategy design pattern ile oluşturulan aşağıda üretilen  vektörler eklenerek ve bu vektörerin yönü boyunca tehtitleri
	 *  sorgulanarak Fil tasinin tehit edebileceği yeni konumlar bulunmuştur. Bulunan bu konumlarda da rakip renkten
	 *  bir tas var ise tehtitAlani dizisine kayıt edilmiştir...
	 *   
	 */
	@Override
	public void tehtitEdilenKonum(boolean [][] tehtitAlani) {
		// TODO Auto-generated method stub
		
		yeniKonum = new Konum(getKonum().getSatir(), getKonum().getSutun());
		

		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new KuzeyDogu())), tehtitAlani);
		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new KuzeyBatı())), tehtitAlani);
		
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new GuneyDogu())), tehtitAlani);
				
		konumTehtitAlgila(yonBoyuncaTehtitSorgula(yeniKonum, new Vektor(new GuneyBati())), tehtitAlani);
		
	}

}
