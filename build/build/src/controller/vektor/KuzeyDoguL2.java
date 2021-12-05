package controller.vektor;

import model.tahta.Konum;
import model.tahta.Tahta;

/**
 * 
 *  Kuzey de 1 , Dogu da 2 birim hareket eden vektor
 *  
 *  (1,2)
 * 
 */

public class KuzeyDoguL2 implements Yon {

	@Override
	public Konum konumaGit(int x, int y, Tahta tahta) {
		
		y +=2;
			
		if(tahta.tahtaSýnýrKontrol(new Konum(++x,y)))
			return  new Konum(x,y);
		
		return null;
	}

}
