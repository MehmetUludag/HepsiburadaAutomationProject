Hepsiburada Test Automation Spec
================================

This is an executable specification file. This file follows markdown syntax. Every heading in this file denotes a scenario. Every bulleted point denotes a step.
To execute this specification, use `mvn test`


Senaryo 1
---------
* Hepsiburada web sayfası açılır
* Arama kutusunda bir ürün aratılır
* Rastgele bir ürünün detay sayfasına geçilir
* Değerlendirmeler tab’ine geçiş yapılır ve buradan Sırala : En Yeni Değerlendirme seçilir.
* Bir yorum beğenilir ve teşekkür yazısı kontrol edilir

Senaryo 2
---------
* Hepsiburada web sayfası açılır
* Arama kutusunda bir ürün aratılır
* Rastgele bir ürünün detay sayfasına geçilir
* Seçilen ürün en uygun fiyatlı satıcıdan sepete eklenir

Senaryo 3
---------
* Hepsiburada web sayfası açılır
* Arama kutusunda bir ürün aratılır
* Rastgele bir ürünün detay sayfasına geçilir
* Sepete eklenen ürünün fiyat bilgisi kontrol edilir