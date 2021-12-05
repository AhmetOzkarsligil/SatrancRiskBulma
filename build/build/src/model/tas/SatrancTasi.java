/**
 * 
 */
package model.tas;

import controller.vektor.Vektor;
import model.enums.Renk;
import model.enums.Tas;
import model.tahta.Konum;
import model.tahta.Tahta;

/**
 * 
 * Tüm Satranç taþlarýnýn üst sýnýfý olarak tasarlanmýþtýr.
 * 
 * 
 * 
 * @author Ahmet Özkarsligil
 */
public abstract class SatrancTasi {
	
	private Tahta tahta;
	private Konum	konum;
	private Renk	renk;
	private int		puan;
	


	private boolean tehtitDurumu ;
	
	
	public SatrancTasi( Renk renk,Konum konum,Tahta tahta,int puan ) {
		this.konum = konum;
		this.renk = renk;
		this.tahta = tahta;
		this.puan = puan;
	}



	public abstract void tehtitEdilenKonum(boolean [][] tehtitAlani);
	
	
	/*
	 * 
	 *  Parametre olarak gelen konumdaki taþýn
	 *  tehtitAltýnda olup olmadýðý kontrol edilir ve 
	 *  
	 *  Parametre olarak alýnan dizinin,
	 *  tehtit altýnda bulunan taþýn konumu ile ayný indeksine true deðeri atanýr.
	 *  
	 *  
	 *  
	 */
	protected void konumTehtitAlgila(Konum konum, boolean [][] tehtitAlani ) {
		
		try {
		
			if(konum != null) {
				
				int satir = konum.getSatir();
				int sutun = konum.getSutun();
				
				SatrancTasi geciciTas = null;
				
					if(getTahta().tahtaSýnýrKontrol(konum)) 
						geciciTas =  (getTahta().getKare()[satir][sutun]);
					
					if( geciciTas != null  && geciciTas.getRenk() != getRenk())	
						tehtitAlani[satir][sutun] = true;	
				
			}
		
		} catch (Exception e) {
			System.err.println (e);
			// TODO: handle exception
		}
		
	}
	
	
	/*
	 *  Parametre olarak gelen konumu vektorun baþlangýç noktasý
	 * 	Parametre olarak gelen vektorun yonu boyunca satranç tahtasýnda bulunan ilk taþýn kontrolü saðlanýr 
	 *  Konumu bulunan taþýn rengi rakip renk ise bu konum bilgisi geri dondürülür
	 */
	protected Konum	yonBoyuncaTehtitSorgula(Konum konum, Vektor vektor)
	{
		//while( getTahta().tahtaSýnýrKontrol(konum) && !getTahta().tasKontrol(konum) ) 
			//konum = vektor.konumaGit(konum.getSatir(), konum.getSutun());
		
		while( getTahta().tahtaSýnýrKontrol(konum) ) {
			
				konum = vektor.konumaGit(konum.getSatir(), konum.getSutun(),getTahta());			
				
			if(konum != null )	
				if( getTahta().tasKontrol(konum)  )
					return konum;
					
		}
		return konum;
		
	}
	
	
	public Tahta getTahta() {
		return tahta;
	}

	public Renk getRenk() {
		return renk;
	}

	public Konum getKonum() {
		return konum;
	}

	public void setKonum(Konum konum) {
		this.konum = konum;
	}
		
	
	public int getPuan() {
		return puan;
	}

	
	
}
