package model.enums;

/*
 * 
 * 	Satranç Taşlarının kısa isimleri etiket değişkeninde, 
 * 	puanları da puan isimli değişkeninde saklanmaktadır.
 * 
 */

public enum Tas{

	PIYON('p',1),
    KALE('k',5),
    FIL('f',3),
    AT('a',3),
    VEZIR('v',9),
    SAH('s',100),
    BOSKARE('-',0);
	
    public final char etiket;
    public final int puan;
    
    private Tas(char etiket, int puan) {
        this.etiket = etiket;
        this.puan = puan;
    }
    
}
