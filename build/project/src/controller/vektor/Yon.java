package controller.vektor;

import model.tahta.Konum;
import model.tahta.Tahta;

public interface Yon {
	
	
	
	
	/*
	 * konumaGit fonksiyonu gidilmesi istenilen yer satran� tahtas�n�n s�n�rlar� i�ersindeyse 
	 * o konuma gidiyor de�ilse null de�erini d�nd�r�yor.
	 */
	public Konum konumaGit(int x,int y,Tahta tahta);
}
