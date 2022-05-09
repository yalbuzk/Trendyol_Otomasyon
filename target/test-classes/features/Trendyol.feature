Feature: Web Test Otomasyon Proje - 2

  Scenario: Trendyol sepetteki ürünün silinmesinin test edilmesi
    Given www.trendyol.com sitesine giris yapilir.
    When Urun arama alanina masa ustu bilgisayar yazilir.
    And Bir urun secilir.
    And Sepete ekle butonuna tiklanir.
    And Sepetim tiklanir.
    And Sepetteki urun adinin dogru oldugu tespit edilir.
    And Cop Sepeti butonuna basilir.
    And Acilan Pop-up da sil butonuna basilir.
    And Daha sonra Sepetim tiklanir.
    Then Sepette ilgili urunun bulunmadigi kontrol edilir.