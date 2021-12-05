package model.tahta;


public class Konum {

	private int satir,sutun;
	
	public Konum() {}
		
	public Konum(int satir, int sutun) {
		this.satir = satir;
		this.sutun = sutun;
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

	
	@Override
	public String toString(){
		return "(" + satir + " , " + sutun + ")";
	}
	
	
	/*
	 * Satranc tahtasi matrisinin sutun isimleri karaktere dönüştürülmüştür. 
	 * (0,0) konumu 1a konumuna  
	 */
	public String konumDonustur(){
		return "(" + (satir + 1) + " , " + (char) (sutun+'a') + ")";
	}
	
}
