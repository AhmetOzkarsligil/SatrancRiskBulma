/**
 * 
 */
package model.tahta;

import model.tas.SatrancTasi;





/**
 * Bu sýnýf satranç tahtasýný, özelliklerini 
 * ve kontrollerini içermektedir.
 * 
 * 
 * @author Ahmet OZKARSLIGÝL
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
	 * Tas var ise true, tas yok ise false deðeri döndürmektedir.
	 *  
	 *  tasKontrol fonksiyonu ile paremetre olarak gönderilen konumda
	 *  herhangi bir taþýn olup olmadý kontrol edilmektedir.
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
	 *  Parametre olarak alýnan konumun Satranç Tahtasýnýn sýnýrlarý içerisinde olup olmadýðýnýn kontrolünü saðlamaktadýr.
	 *  Konum tahta sýnýrýnýn dýþýnda ise false, içersinde ise true deðeri dönmektedir.
	 * 
	 */
	public boolean tahtaSýnýrKontrol(Konum konum) {
		
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
