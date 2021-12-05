package controller.vektor;

import model.tahta.Konum;
import model.tahta.Tahta;

/**
 * 
 *  Atin yapti�i L hareketinin 
 *	G�ney y�n�nde 1  bati y�n�nde 2 birim olan�n� temsil etmektedir.
 *	
 *	Konum(x,y) + GuneyBatiL2 (-1,-2)
 * 
 */

public class GuneyBatiL2 implements Yon {
	

	
	@Override
	public Konum konumaGit(int x, int y, Tahta tahta) {
		
		y -=2;
		
		if(tahta.tahtaS�n�rKontrol(new Konum(--x,y)))
			return  new Konum(x,y);
		
		return null;
	}

}
