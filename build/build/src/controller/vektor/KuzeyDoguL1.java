package controller.vektor;

import model.tahta.Konum;
import model.tahta.Tahta;

public class KuzeyDoguL1 implements Yon{

/**
 * 
 *  Kuzey de 2 , Dogu da 1 birim hareket eden vektor
 *  
 *  (2,1)
 * 
 */
	
	@Override
	public Konum konumaGit(int x, int y, Tahta tahta) {
		// TODO Auto-generated method stub
		
		x +=2;
			
		if(tahta.tahtaSýnýrKontrol(new Konum(x,++y)))
			return  new Konum(x,y);
		
		return null;
		
	}


	
	
}
