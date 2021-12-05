package controller.vektor;

import model.tahta.Konum;
import model.tahta.Tahta;

/**
 * 
 *  Atin yaptiði L hareketinin 
 *	Güney yönünde 1  bati yönünde 2 birim olanýný temsil etmektedir.
 *	
 *	Konum(x,y) + GuneyBatiL2 (-1,-2)
 * 
 */

public class GuneyBatiL2 implements Yon {
	

	
	@Override
	public Konum konumaGit(int x, int y, Tahta tahta) {
		
		y -=2;
		
		if(tahta.tahtaSýnýrKontrol(new Konum(--x,y)))
			return  new Konum(x,y);
		
		return null;
	}

}
