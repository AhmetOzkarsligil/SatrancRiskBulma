/**
 * 
 */
package model.tahta;

import model.tas.SatrancTasi;





/**
 * Bu s�n�f satran� tahtas�n�, �zelliklerini 
 * ve kontrollerini i�ermektedir.
 * 
 * 
 * @author Ahmet OZKARSLIG�L
 *
 */
public class Tahta {
	
	private int satir;
	private int sutun;
	


	private SatrancTasi [][] kare;
	
	public Tahta(int satir, int sutun) {
		if (satir < 1 || sutun < 1){
		//	throw new BoardException("Error creating board: thre must be at least 1 row and 1 column");
		}
		this.satir = satir;
		this.sutun = sutun;
		kare = new SatrancTasi[satir][sutun];
	}
	

	
	
	/*
	 * Tas var ise true, tas yok ise false de�eri d�nd�rmektedir.
	 *  
	 *  tasKontrol fonksiyonu ile paremetre olarak g�nderilen konumda
	 *  herhangi bir ta��n olup olmad� kontrol edilmektedir.
	 * 
	 */
	public boolean tasKontrol(Konum konum) {
		
		return kare[konum.getSatir()][konum.getSutun()]	!= null;
	}
	
	/*
	public boolean rakipTas(Konum konum) {
		
		if(tasKontrol(konum) && kare[konum.getSatir()][konum.getSutun()].getRenk() !=  ) {
			
		}
		
		
	}
*/
	
	/*
	 *  Parametre olarak al�nan konumun Satran� Tahtas�n�n s�n�rlar� i�erisinde olup olmad���n�n kontrol�n� sa�lamaktad�r.
	 *  Konum tahta s�n�r�n�n d���nda ise false, i�ersinde ise true de�eri d�nmektedir.
	 * 
	 */
	public boolean tahtaS�n�rKontrol(Konum konum) {
		
		if (konum == null)
			return false;
			
		return  (konum.getSatir() > -1 && konum.getSatir() < satir )
				&&					  
				(konum.getSutun() > -1 && konum.getSutun() < sutun);
		
		
	}
	
	
	
	
	
	
	public int getSatir() {
		return satir;
	}

	public void setSatir(int satir) {
		this.satir = satir;
	}

	public int getSutun() {
		return sutun;
	}

	public void setSutun(int sutun) {
		this.sutun = sutun;
	}

	public SatrancTasi[][] getKare() {
		return kare;
	}
	
	
	
}
