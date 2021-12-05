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
 * T�m Satran� ta�lar�n�n �st s�n�f� olarak tasarlanm��t�r.
 * 
 * 
 * 
 * @author Ahmet �zkarsligil
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
	 *  Parametre olarak gelen konumdaki ta��n
	 *  tehtitAlt�nda olup olmad��� kontrol edilir ve 
	 *  
	 *  Parametre olarak al�nan dizinin,
	 *  tehtit alt�nda bulunan ta��n konumu ile ayn� indeksine true de�eri atan�r.
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
				
					if(getTahta().tahtaS�n�rKontrol(konum)) 
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
	 *  Parametre olarak gelen konumu vektorun ba�lang�� noktas�
	 * 	Parametre olarak gelen vektorun yonu boyunca satran� tahtas�nda bulunan ilk ta��n kontrol� sa�lan�r 
	 *  Konumu bulunan ta��n rengi rakip renk ise bu konum bilgisi geri dond�r�l�r
	 */
	protected Konum	yonBoyuncaTehtitSorgula(Konum konum, Vektor vektor)
	{
		//while( getTahta().tahtaS�n�rKontrol(konum) && !getTahta().tasKontrol(konum) ) 
			//konum = vektor.konumaGit(konum.getSatir(), konum.getSutun());
		
		while( getTahta().tahtaS�n�rKontrol(konum) ) {
			
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
