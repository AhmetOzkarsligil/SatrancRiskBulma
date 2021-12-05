package controller.vektor;

import model.tahta.Konum;
import model.tahta.Tahta;

/**
 * 
 *  Kuzey de 1 , Bat� da 2 birim hareket eden vektor
 *  
 *  (1,-2)
 * 
 */

public class KuzeyBatilL2 implements Yon {

	@Override
	public Konum konumaGit(int x, int y, Tahta tahta) {

		y -=2;
		
		if(tahta.tahtaS�n�rKontrol(new Konum(++x,y)))
			return  new Konum(x,y);
		
		return null;
		
	}

}
