package controller.vektor;

import model.tahta.Konum;
import model.tahta.Tahta;

public class KuzeyBat� implements Yon {
	@Override
	public Konum konumaGit(int x, int y,Tahta tahta) {
		
		
		
		if(tahta.tahtaS�n�rKontrol(new Konum( ++x, --y)))
			return new Konum( x, y);
		
		return null; // s�n�r�n d���nda ise yeni konum null olarak d�nmektedir.
		
	}

}
