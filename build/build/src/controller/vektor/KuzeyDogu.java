package controller.vektor;

import model.tahta.Konum;
import model.tahta.Tahta;

public class KuzeyDogu implements Yon{
	
	@Override
	public Konum konumaGit(int x, int y,Tahta tahta) {

		if(tahta.tahtaSınırKontrol(new Konum( ++x, ++y)))
			return new Konum( x, y);
		
		return null;
		
	}

}
