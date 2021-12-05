/**
 * 
 */
package model.tas;

import model.enums.Renk;
import model.enums.Tas;
import model.tahta.Konum;
import model.tahta.Tahta;

/**
 * @author Ahmet
 *
 */
public class TasFabrikasi {

	/*
	 * Factory Desing Pattern in üretici sýnýfý 
	 * Dosyadan gelen etiket bilgilerine göre uygun taþýn üretilmesi için oluþturulmuþtur.
	 * 
	 */
	
	public SatrancTasi tasUret(char tasEtiketi, Renk renk , Konum konum, Tahta tahta ) {
		
		if(charCompare(tasEtiketi, Tas.BOSKARE.etiket)  || charCompare(renk.etiket, Renk.YOK.etiket) 
				|| 	tasEtiketi == 0 || renk == null ) 
		{	
			return null;
		}
		
		if( charCompare(tasEtiketi, Tas.PIYON.etiket)  ) {
			
			return new Piyon(renk,konum,tahta,Tas.PIYON.puan);
			
		}
			
		else if( charCompare(tasEtiketi, Tas.FIL.etiket) ) {
			return new Fil(renk,konum,tahta,Tas.FIL.puan);
		}
		
		
		else if( charCompare(tasEtiketi, Tas.AT.etiket)  ) {

			return new At(renk,konum,tahta,Tas.AT.puan);
			
		}
			
		else if( charCompare(tasEtiketi, Tas.KALE.etiket) ) {
			return new Kale(renk,konum,tahta,Tas.KALE.puan);
		}
		else if( charCompare(tasEtiketi, Tas.VEZIR.etiket)  ) {
			
			return new Vezir(renk,konum,tahta,Tas.VEZIR.puan);
			
		}
			
		else if( charCompare(tasEtiketi, Tas.SAH.etiket) ) {
			return new Sah(renk,konum,tahta,Tas.SAH.puan);
		}
		
		return null;
		
	}
	
	
	
	
	public  boolean charCompare(char c1, char c2) {
		if(c1 - c2 == 0 )
			return true;
		return false;
	}
	
	

}



