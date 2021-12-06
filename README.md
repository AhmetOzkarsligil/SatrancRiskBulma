# SatrancRiskBulma


## Derleme Kılavuzu

  Proje Eclipse editoründe yazılmıştır, Java SE 1.8 ve javafx-sdk-17.0.1 sürümleri ile derlendiğinde sorunsuzca çalışmaktadır.
  Derleme işleminde sorun ile karşılaşırsanız bile proje içerisinde ki "src" dizini içerisinden kodlar incelenebilir. 


## Kullanım Kilavuzu
  
  Bu kullanim kilavuzu yazilim içerisinde de görüntülenebilinmektedir. 
  
 
 ![Kullanim Kilavuzu 1](https://github.com/AhmetOzkarsligil/SatrancRiskBulma/blob/master/src/images/userGuide/0.jpg)
 
 Okun Gösterdiği butona tıklayarak uygulama arayüzünü açın
  
  
  
  
  ![Kullanim Kilavuzu 2](https://github.com/AhmetOzkarsligil/SatrancRiskBulma/blob/master/src/images/userGuide/1.jpg)
  
  Okun Gösterdiği "Goz At" butonuna tıklayarak satranç tahta dosyasını bilgisayarınızdan seçin 
	Buradaki text field a dosya yolunu yazabilirsiniz ancak dosya yolunun doğru girildiği varsayılmıştır. Bu kontroller yapılmamıştır.
  
  
  
 
 ![Kullanim Kilavuzu 3](https://github.com/AhmetOzkarsligil/SatrancRiskBulma/blob/master/src/images/userGuide/2.png)
  
  Okun gösterdiği alanda Seçilen dosya içersindeki taşlar konumlarıyla birlikte görüntülenmektedir
  
  


![Kullanim Kilavuzu 4](https://github.com/AhmetOzkarsligil/SatrancRiskBulma/blob/master/src/images/userGuide/3.jpg)
  
  Okun gösterdiği 'Risk Hesapla' isimli butona tıklayarak seçilen tahtanın riski hesaplanır ve aşağıdaki tabloya aktarılır.
  
  
  
 
 ![Kullanim Kilavuzu 4](https://github.com/AhmetOzkarsligil/SatrancRiskBulma/blob/master/src/images/userGuide/4.jpg)
  
  Okun Gösterdiği tabloda sonuclar görüntülenmektedir.
  
  
  
  
  ![Kullanim Kilavuzu 4](https://github.com/AhmetOzkarsligil/SatrancRiskBulma/blob/master/src/images/userGuide/5.jpg)
 
  Okun Gösterdiği 'Kaydet' butonuna tıklayarak tabloda yer alan sonuçları bilgisayarınıza kayıt edebilirsiniz.
  
### Yazilim İçeriği
   
   controller/SatrancRiskUygulamasiController sınıfında dosyadan çekilen taşlar etiketlerine göre src/model/tas içerisindeki SatrancTasi sınıfından  piyon,at,fil,kale,vezir ve şah sınıflarına ait taşlar TasFabrikasi sınıfındaki tasUret isimli factory methot ile üretmektedirler.
   
   Üretilen taşlar tehtitEdilenKonum fonksiyonunu Ovverride etmektedirler. Bu fonksiyon içerisinde controller.vektor paketi içerisinde oluşturulan vektorler kullanılmaktadır. 
Bu vektorler strateji tasarım deseni kullanılarak oluşturulmuştur. Örneğin kuzeydoğu yönündeki vektör Vezir, Fil ve şah için kullanılmıştır. Ayrıca SatrancTasi içerisindeki yonBoyuncaTehtitSorgula fonksiyonuna parametre hangi vektör gelirse o vektörün konumuna gidilmesi sağlanmıştır. 

Kod içerisinde yorum satırları bulunmaktadır ancak anlaşılmayan bir yer olduğunda benimle iletişime geçin lütfen.
   

Ayrıca bana gönderilen dosyadaki  "board1.txt" isimli Satranç tahtasindaki risk hesaplamasında 2b deki siyah atı - 4f de 
yer alan fil tehtit etmesine rağmen  "sonuçlar.txt"  klasöründe bu taşın risk puanının hesaplanmadiği gözlemlenmiştir. 
Bu uygulamada tüm taşlar kontrol edilmektedir bu yüzden board1.txt dosyasındaki  2b deki siyah atın da risk puanı 
hesaplanmaktadır. 
board1.txt		Siyah:135		değeri hatalıdır
board1.txt		Siyah:133.5		bu değer doğrudur.


