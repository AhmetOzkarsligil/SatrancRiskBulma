package model.sonuc;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

public class SonucTableView {
	
	private  SimpleStringProperty 	path;
	private  SimpleFloatProperty	beyazSonuc;
	private  SimpleFloatProperty	siyahSonuc;
	
	
	public SonucTableView(String path, Float siyahSonuc, Float beyazSonuc) {
		this.path = new SimpleStringProperty(path);
		this.beyazSonuc = new SimpleFloatProperty(beyazSonuc);
		this.siyahSonuc = new SimpleFloatProperty(siyahSonuc);
	}



	public String getPath() {
		return path.get();
	}




	public void setPath(String path) {
		this.path = new SimpleStringProperty(path);
	}


	public Float getBeyazSonuc() {
		return beyazSonuc.get();
	}


	public void setBeyazSonuc(Float beyazSonuc) {
		this.beyazSonuc = new SimpleFloatProperty(beyazSonuc);
	}


	public Float getSiyahSonuc() {
		return siyahSonuc.get();
	}


	public void setSiyahSonuc(Float siyahSonuc) {
		this.siyahSonuc = new SimpleFloatProperty(siyahSonuc);
	}

	
	/*
	@Override
	public String toString() {
		
		return path +"\t\t" + "Siyah : " + 
				siyahSonuc + "\t\t" + "Beyaz : " + beyazSonuc;
		
	}
*/
}
