package controller.vektor;

import model.tahta.Konum;
import model.tahta.Tahta;

public class KuzeyBatiL1 implements Yon {

	
/**
 * 
 *  Kuzey de 2 , Batı da 1 birim hareket eden vektor
 *  
 *  (2,-1)
 * 
 */
	
	@Override
	public Konum konumaGit(int x, int y, Tahta tahta) {

		x +=2;
		
		if(tahta.tahtaSınırKontrol(new Konum(x,--y)))
			return  new Konum(x,y);
		
		return null;
	}

}
