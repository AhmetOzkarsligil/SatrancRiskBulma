package controller.vektor;

import model.tahta.Konum;
import model.tahta.Tahta;

public class GuneyDoguL2 implements Yon {
/**
 * 
 *  Guney de 1 , Dogu da 2 birim hareket eden vektor
 *  
 *  (-1,+2)
 * 
 */
	@Override
	public Konum konumaGit(int x, int y, Tahta tahta) {
		
		y +=2;
		
		if(tahta.tahtaSýnýrKontrol(new Konum(--x,y)))
			return  new Konum(x,y);
		
		return null;
	}

}
