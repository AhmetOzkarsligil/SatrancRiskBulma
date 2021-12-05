package controller.vektor;

import model.tahta.Konum;
import model.tahta.Tahta;

public interface Yon {
	
	
	
	
	/*
	 * konumaGit fonksiyonu gidilmesi istenilen yer satranç tahtasýnýn sýnýrlarý içersindeyse 
	 * o konuma gidiyor deðilse null deðerini döndürüyor.
	 */
	public Konum konumaGit(int x,int y,Tahta tahta);
}
