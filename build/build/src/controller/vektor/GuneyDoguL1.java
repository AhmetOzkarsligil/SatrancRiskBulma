package controller.vektor;

import model.tahta.Konum;
import model.tahta.Tahta;

public class GuneyDoguL1 implements Yon {


/**
 * 
 *  Guney de 2 , Dogu da 1 birim hareket eden vektor
 *  
 *  (-2,+1)
 * 
*/
	@Override
	public Konum konumaGit(int x, int y, Tahta tahta) {
		
		x -=2;
		
		if(tahta.tahtaSýnýrKontrol(new Konum(x,++y)))
			return  new Konum(x,y);
		
		return null;
	}

}
