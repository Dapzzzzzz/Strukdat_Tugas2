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