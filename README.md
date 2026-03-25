# Sistem Laundry Sederhana Berbasis OOP (Java)
**Nama:** Daffa Rifqi As Shidiq

**NRP:** 5027251038

## Deskripsi Kasus

Pada tugas ini, saya membuat program sederhana bertema **sistem laundry** menggunakan bahasa pemrograman **Java** dengan menerapkan konsep **Object-Oriented Programming (OOP)**.
Saya memilih case ini karena melihat sg teman saya "Sakti" yang kesal karena bajunya selalu tertukar saat laundry, ga cuma satu kali tetapi sudah belasan kali.Maka dari itu saya membuat program sistem laundry untuk mengurangi resiko baju tertukar

---

## Class Diagram
ini adalah class diagram yang dibuat menggunakan mermaid.ai
<img width="7366" height="3180" alt="mermaid-ai-diagram" src="https://github.com/user-attachments/assets/f39c8836-1b9f-470b-9c4c-d5d40afc8fed" />


---

## Kode Program Java
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
<img width="1920" height="1140" alt="Screenshot 2026-03-25 150030" src="https://github.com/user-attachments/assets/f20c4914-fee9-496f-94c0-0ccf22372c30" />


## Input Pesanan
<img width="1920" height="1140" alt="Screenshot 2026-03-25 150123" src="https://github.com/user-attachments/assets/fd596e00-5634-4eba-8708-e2cc154f2563" />

## Riwayat Laundry
<img width="1920" height="1140" alt="Screenshot 2026-03-25 150137" src="https://github.com/user-attachments/assets/1ddad07d-bf2a-429f-9058-bd37180a695b" />

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

---

### 2. Abstraction
Konsep abstraction diterapkan dengan menggunakan **abstract class** bernama `PesananLaundry`.

```java
abstract class PesananLaundry
```

Di dalamnya terdapat method abstrak:

```java
abstract double harga();
```

Method ini nantinya diisi secara berbeda oleh class turunan karena tiap layanan memiliki harga yang berbeda-beda.

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

## Keunikan

Menurut saya, Keunikan yang terdapat dalam program ini mungkin dibagian diskonnya karena jika laundry diatas 5 kg akan dapat diskon 10%/kg nya. Case ini juga lumayan unik karena berfokus pada solusi baju anti tertukar.
