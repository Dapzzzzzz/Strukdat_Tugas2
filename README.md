# Sistem Laundry Sederhana Berbasis OOP (Java)

## Deskripsi Kasus

Pada tugas ini, saya membuat program sederhana bertema **sistem laundry** menggunakan bahasa pemrograman **Java** dengan menerapkan konsep **Object-Oriented Programming (OOP)**.
Saya memilih case ini karena melihat sg teman saya "Sakti" yang kesal karena bajunya selalu tertukar saat laundry, ga cuma satu kali tetapi sudah belasan kali.Maka dari itu saya membuat program sistem laundry untuk mengurangi resiko baju tertukar

---

## Fitur Program

Beberapa fitur yang ada pada program ini antara lain:

- Menambahkan pesanan laundry baru
- Menyimpan data pelanggan dan pesanan
- Menampilkan daftar / riwayat laundry
- Menghitung total biaya secara otomatis
- Mendukung dua jenis layanan laundry
- Memberikan diskon otomatis untuk berat tertentu

---

## Class Diagram


---

## Kode Program Java

### File: `App.java`

```java
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PesananLaundry[] daftar = new PesananLaundry[100];
        int totalPesanan = 0;

        while (true) {
            System.out.println("\n");
            System.out.println("  ██╗      █████╗ ██╗   ██╗███╗   ██╗██████╗ ██████╗ ██╗   ██╗");
            System.out.println("  ██║     ██╔══██╗██║   ██║████╗  ██║██╔══██╗██╔══██╗╚██╗ ██╔╝");
            System.out.println("  ██║     ███████║██║   ██║██╔██╗ ██║██║  ██║██████╔╝ ╚████╔╝ ");
            System.out.println("  ██║     ██╔══██║██║   ██║██║╚██╗██║██║  ██║██╔══██╗  ╚██╔╝  ");
            System.out.println("  ███████╗██║  ██║╚██████╔╝██║ ╚████║██████╔╝██║  ██║   ██║   ");
            System.out.println("  ╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═══╝╚═════╝ ╚═╝  ╚═╝   ╚═╝   ");
            System.out.println("================================================================");
            System.out.println(" [1] Tambah Pesanan | [2] Riwayat Laundry | [0] Keluar");
            System.out.print(" Pilih menu > ");
            
            int menu = sc.nextInt();
            sc.nextLine(); 

            if (menu == 1) {
                System.out.print("Nama Pelanggan    : "); String nama = sc.nextLine();
                System.out.print("Alamat Pelanggan  : "); String alamat = sc.nextLine();
                System.out.print("Ciri/Isi Barang   : "); String ket = sc.nextLine();
                System.out.print("Berat (kg)        : "); double berat = sc.nextDouble();
                System.out.print("Berapa Hari       : "); int hari = sc.nextInt();
                System.out.print("Layanan (1. Lipat / 2. Setrika): "); int tipe = sc.nextInt();
                sc.nextLine(); 

                String id = "L" + (totalPesanan + 1);

                if (tipe == 1) {
                    daftar[totalPesanan] = new CuciLipat(id, nama, alamat, ket, berat, hari);
                } else {
                    daftar[totalPesanan] = new CuciSetrika(id, nama, alamat, ket, berat, hari);
                }
                
                totalPesanan++;
                System.out.println("\n>>> BERHASIL! ID PESANAN: " + id);

            } else if (menu == 2) {
                System.out.println("\n--- DATA RIWAYAT LAUNDRY ---");
                for (int i = 0; i < totalPesanan; i++) {
                    PesananLaundry p = daftar[i];
                    System.out.println("ID: " + p.getID());
                    System.out.println("Nama: " + p.getNama());
                    System.out.println("Alamat: " + p.getAlamat());
                    System.out.println("Ciri Barang: " + p.getKeterangan());
                    System.out.println("Waktu: " + p.getHari() + " Hari");
                    System.out.println("Tagihan: Rp " + p.totalBayar());
                    System.out.println("----------------------------");
                }

            } else if (menu == 0) {
                break;
            }
        }
        sc.close();
    }
}

abstract class PesananLaundry {
    private String id, nama, alamat, keterangan;
    private double berat;
    private int hari;

    public PesananLaundry(String id, String nama, String alamat, String keterangan, double berat, int hari) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.keterangan = keterangan;
        this.berat = berat;
        this.hari = hari;
    }

    public String getID(){
        return id;
    }
    public String getNama(){
        return nama;
    }
    public String getAlamat(){
        return alamat;
    }
    public String getKeterangan(){
        return keterangan;
    }
    public double getBerat(){
        return berat;
    }
    public int getHari() {
        return hari; 
    }

    abstract double harga();

    public double totalBayar() {
        double hargaAwal = harga();
        if (berat > 5) {
            hargaAwal = hargaAwal * 0.9; 
        }
        return this.berat * hargaAwal;
    }
}

class CuciLipat extends PesananLaundry {
    public CuciLipat(String id, String nama, String alamat, String keterangan, double berat, int hari) {
        super(id, nama, alamat, keterangan, berat, hari);
    }

    @Override
    double harga() {
        if (getHari() < 3) {
            return 7000;
        } else {
            return 5000;
        }
    }
}

class CuciSetrika extends PesananLaundry {
    public CuciSetrika(String id, String nama, String alamat, String keterangan, double berat, int hari) {
        super(id, nama, alamat, keterangan, berat, hari);
    }

    @Override
    double harga() {
        if (getHari() < 3) {
            return 10000;
        } else {
            return 7000;
        }
    }
}
```

---

## Screenshot Output


## Tampilan Menu
![Menu](img/menu.png)

## Input Pesanan
![Input](img/input.png)

## Riwayat Laundry
![Riwayat](img/riwayat.png)

---

## Prinsip OOP yang Diterapkan

Pada program ini, saya menerapkan beberapa konsep dasar dari **Object-Oriented Programming (OOP)**, yaitu:

### 1. Encapsulation
Encapsulation terlihat pada class `PesananLaundry`, di mana data seperti `id`, `nama`, `alamat`, `keterangan`, `berat`, dan `hari` dibuat dengan akses **private**.

```java
private String id, nama, alamat, keterangan;
private double berat;
private int hari;
```

Data tersebut tidak bisa diakses langsung dari luar class, tetapi diambil melalui method getter seperti `getNama()`, `getAlamat()`, dan lain-lain.

Tujuannya agar data lebih aman dan lebih terkontrol.

---

### 2. Abstraction
Konsep abstraction diterapkan dengan menggunakan **abstract class** bernama `PesananLaundry`.

```java
abstract class PesananLaundry
```

Class ini berfungsi sebagai gambaran umum dari semua jenis pesanan laundry.

Di dalamnya terdapat method abstrak:

```java
abstract double harga();
```

Method ini nantinya diisi secara berbeda oleh class turunan karena tiap layanan memiliki aturan harga yang berbeda.

---

### 3. Inheritance
Konsep inheritance diterapkan pada class:

- `CuciLipat`
- `CuciSetrika`

Kedua class tersebut mewarisi atribut dan method dari class `PesananLaundry`.

```java
class CuciLipat extends PesananLaundry
class CuciSetrika extends PesananLaundry
```

Dengan inheritance, saya tidak perlu menulis ulang data dan fungsi dasar yang sebenarnya sama pada setiap jenis layanan.

---

### 4. Polymorphism
Polymorphism terlihat saat objek `CuciLipat` atau `CuciSetrika` dimasukkan ke dalam array bertipe `PesananLaundry`.

```java
PesananLaundry[] daftar = new PesananLaundry[100];
```

Contohnya:

```java
daftar[totalPesanan] = new CuciLipat(...);
daftar[totalPesanan] = new CuciSetrika(...);
```

Walaupun tipe array-nya sama, method yang dijalankan tetap menyesuaikan dengan objek aslinya.  
Misalnya saat memanggil:

```java
p.totalBayar();
```

harga yang dihitung akan berbeda tergantung apakah objek tersebut `CuciLipat` atau `CuciSetrika`.

---

## Keunikan Program

Menurut saya, yang membedakan program ini dari program individu lain adalah:

### 1. Studi kasusnya dekat dengan kehidupan sehari-hari
Saya memilih tema laundry karena merupakan permasalahan yang sederhana, realistis, dan mudah dibayangkan penerapannya dalam kehidupan nyata.

Jadi program ini tidak hanya sekadar latihan coding, tetapi juga bisa menggambarkan sistem usaha kecil secara sederhana.

---

### 2. Sudah ada logika bisnis sederhana
Program ini tidak hanya mencatat data pelanggan, tetapi juga memiliki logika perhitungan harga berdasarkan:

- jenis layanan,
- waktu pengerjaan,
- berat pakaian,
- dan diskon otomatis.

Artinya, program ini sudah lebih dari sekadar input-output biasa.

---

### 3. Struktur class dibuat cukup rapi
Saya mencoba membedakan antara class induk dan class turunan agar struktur program lebih jelas dan mudah dikembangkan lagi.

Misalnya, jika ke depannya ingin ditambah fitur seperti:

- laundry express,
- dry cleaning,
- cuci sepatu,

maka program ini masih cukup mudah untuk dikembangkan.

---

### 4. Tampilan terminal dibuat lebih menarik
Program ini juga saya buat dengan tampilan terminal yang lebih menarik menggunakan judul ASCII sederhana agar tidak terlalu polos saat dijalankan.

Hal ini memang sederhana, tetapi bisa memberi kesan bahwa program dibuat dengan lebih niat dan lebih enak dilihat.

---

## Cara Menjalankan Program

1. Pastikan Java sudah terinstall di laptop/PC.
2. Simpan kode dengan nama `App.java`
3. Compile program dengan perintah:

```bash
javac App.java
```

4. Jalankan program:

```bash
java App
```

---

## Kesimpulan

Program ini dibuat sebagai implementasi sederhana dari konsep **Object-Oriented Programming (OOP)** menggunakan studi kasus laundry.

Melalui program ini, saya belajar bagaimana membuat class, inheritance, abstract class, serta bagaimana menerapkan polymorphism dan encapsulation dalam program Java.

Walaupun masih sederhana, program ini sudah cukup untuk menggambarkan bagaimana OOP bisa digunakan untuk menyelesaikan permasalahan yang dekat dengan kehidupan sehari-hari.

Ke depannya, program ini masih bisa dikembangkan lagi agar menjadi sistem laundry yang lebih lengkap dan lebih interaktif.

---

## Identitas

**Nama:** [Isi Nama Kamu]  
**NRP / Kelas:** [Isi NRP dan Kelas]  
**Mata Kuliah:** Pemrograman Berorientasi Objek
