import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WarungNasi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("SELAMAT DATANG DI WARUNG NASI DHOWI!");
        System.out.println("========================================");

        System.out.print("Masukkan nama Anda: ");
        String namaPelanggan = scanner.nextLine();
        System.out.println("========================================");
        System.out.println("Hallo, " + namaPelanggan + "!");

        String[] menuMakanan = {"Nasi Goreng Biasa", "Nasi Goreng Ayam", "Nasi Goreng Ati Ampela", "Nasi Goreng Seafood", "Nasi Goreng Bakso Sosis", 
                                "Mie Goreng Ayam", "Mie Goreng Bakso Sosis", "Mie Kwetiaw Ayam", "Mie Kwetiaw Bakso Sosis", "Mie Kwetiaw Seafood"};
        int[] hargaMakanan = {15000, 17000, 17000, 18000, 19000, 15000, 15000, 15000, 15000, 18000};

        String[] menuMinuman = {"Air Mineral", "Es Teh Manis", "Es Jeruk", "Kopi Hitam", "Teh Tarik"};
        int[] hargaMinuman = {3000, 5000, 5000, 4000, 4000};

        System.out.println("DAFTAR MENU MAKANAN:");
        for (int i = 0; i < menuMakanan.length; i++) {
            System.out.printf("%d. %-25s Rp %d\n", (i + 1), menuMakanan[i], hargaMakanan[i]);
        }

        System.out.println("\nDAFTAR MENU MINUMAN:");
        for (int i = 0; i < menuMinuman.length; i++) {
            System.out.printf("%d. %-25s Rp %d\n", (i + 1 + menuMakanan.length), menuMinuman[i], hargaMinuman[i]);
        }

        System.out.println("========================================");

        List<String> pesanan = new ArrayList<>();
        int totalPembelian = 0;

        boolean selesai = false;
        do {
            System.out.print("Pilih menu / masukkan nomor menu (0 untuk selesai): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            if (pilihan == 0) {
                selesai = true;
            } else if (pilihan > 0 && pilihan <= menuMakanan.length) {
                pesanan.add(menuMakanan[pilihan - 1]);
                totalPembelian += hargaMakanan[pilihan - 1];
                System.out.println("Anda memesan " + menuMakanan[pilihan - 1]);
            } else if (pilihan > menuMakanan.length && pilihan <= (menuMakanan.length + menuMinuman.length)) {
                pesanan.add(menuMinuman[pilihan - 1 - menuMakanan.length]);
                totalPembelian += hargaMinuman[pilihan - 1 - menuMakanan.length];
                System.out.println("Anda memesan " + menuMinuman[pilihan - 1 - menuMakanan.length]);
            } else {
                System.out.println("Menu tidak valid!");
            }

        } while (!selesai);

        System.out.println("\nRINGKASAN PESANAN:");
        for (String item : pesanan) {
            System.out.println("- " + item);
        }
        System.out.println("----------------------------------------");
        System.out.println("TOTAL PEMBELIAN: Rp " + totalPembelian);

        boolean valid = false;
        do {
            System.out.print("Masukkan jumlah uang: ");
            int uang = scanner.nextInt();

            if (uang >= totalPembelian) {
                int kembalian = uang - totalPembelian;
                System.out.println("TERIMA KASIH Sudah Membeli Makanan Di WARUNG NASI DHOWI!");
                System.out.println("Ini kembalian Anda: Rp " + kembalian);
                valid = true;
            } else {
                System.out.println("UANG ANDA KURANG!!!!");
            }
        } while (!valid);

        scanner.close();
    }
}
