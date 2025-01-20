## Hepsiburada Ui ve Api Otomasyon

### Proje Hakkında:

Hepsiburada web sitesinde 3 adet happy path senaryosu otomatize edilmiştir.
Örnek bir api servisinden get ve post servislerinin otomasyonu yazılmıştır.
 
---

### Kullanılan Teknolojiler:

- **Selenium:** Web test otomasyon toolu olarak kullanıldı.
- **Java:** Temel programlama dili olarak tercih edildi.
- **Gauge:** BDD (Davranış Odaklı Geliştirme) çerçevesi olarak kullanıldı.
- **POM Tasarım Deseni:** Kodun yeniden kullanılabilirliğini ve sürdürülebilirliğini artırmak için uygulandı.
- **Git:** Sürüm kontrolü ve işbirlikçi geliştirme için entegre edildi.
- **GaugeReport:** Ayrıntılı test yürütme raporları ve analizler için kullanıldı.

---

### Gereklilikler ve Bağımlılıklar:

- **Java (22)**
- **Maven** (Bağımlılık yönetimi için)
- **Git** (Sürüm kontrolü için)
- **Tarayıcılar:** Chrome, Firefox

---

### Sorun Giderme İpuçları:

- **Java Sürüm Hatası:**  Java (22) yüklü olduğundan emin olun.
- **Bağımlılık Hatası:** mvn clean install komutunu çalıştırarak eksik bağımlılıkları yükleyin.
- **Tarayıcı Uyumsuzluğu:** Kullanılan tarayıcı ve sürümün uyumlu olduğundan emin olun.

---

### Sonuçları İnceleyin:

Test çalıştırıldıktan sonra sonuç ve raporları görmek için:
- `reports/html-report/index.html` dosyasını tarayıcıda açılarak test sonuçları görüntülenebilir.

---