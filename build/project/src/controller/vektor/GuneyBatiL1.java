package controller.vektor;

import model.tahta.Konum;
import model.tahta.Tahta;

public class GuneyBatiL1 implements Yon {
/**
 * 
 *  Atin yapti�i L hareketinin 
 *	G�ney y�n�nde 2  bati y�n�nde 1 birim olan�n� temsil etmektedir.
 *	
 *	Konum(x,y) + GuneyBatiL2 (-2,-1)
 * 
 */
	@Override
	public Konum konumaGit(int x, int y, Tahta tahta) {
		// TODO Auto-generated method stub
		
		x -=2;
		
		if(tahta.tahtaS�n�rKontrol(new Konum(x,--y)))
			return  new Konum(x,y);
		
		return null;
	}

}
