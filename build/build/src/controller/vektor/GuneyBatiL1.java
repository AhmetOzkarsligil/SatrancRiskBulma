package controller.vektor;

import model.tahta.Konum;
import model.tahta.Tahta;

public class GuneyBatiL1 implements Yon {
/**
 * 
 *  Atin yaptiði L hareketinin 
 *	Güney yönünde 2  bati yönünde 1 birim olanýný temsil etmektedir.
 *	
 *	Konum(x,y) + GuneyBatiL2 (-2,-1)
 * 
 */
	@Override
	public Konum konumaGit(int x, int y, Tahta tahta) {
		// TODO Auto-generated method stub
		
		x -=2;
		
		if(tahta.tahtaSýnýrKontrol(new Konum(x,--y)))
			return  new Konum(x,y);
		
		return null;
	}

}
