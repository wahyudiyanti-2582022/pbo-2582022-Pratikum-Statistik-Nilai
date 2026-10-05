import java.util.ArrayList; //menyimpan banyak nilai dan ukurannya bisa bertambah secara dinamis.
import java.util.Collections; //untuk mengurutkan data
import java.util.Scanner; //untuk menerima input dari kyboard

public class StatistikNilai { // karena Karena public, class ini bisa diakses dari luar class

    static final int SELESAI = -1; // Membuat konstanta bernama SELESAI dengan nilai -1.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // untuk membaca input
        ArrayList<Integer> daftar = new ArrayList<>(); //Membuat ArrayList bernama daftar untuk menyimpan nilai mahasiswa.

        System.out.println("===== STATISTIK NILAI KELAS ====="); //judul program
        System.out.println("Ketik -1 kalau sudah selesai."); //-1 digunakan untuk mengakhiri input.

        //---membaca nilai---
        int nilai; //untuk menyimpan nilai yang dimasukkan user.
        do {
            // Nomor prompt diambil dari size() + 1, bukan pencacah terpisah.
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : "); //menampilakan prom misal nilai ke-1, dst
            nilai = input.nextInt(); //Membaca angka dari keyboard dan memasukkannya ke variabel nilai.

            if (nilai == SELESAI) { //Mengecek apakah user memasukkan -1.
                continue; // membuat program melewati sisa kode dalam putaran tersebut dan langsung menuju kondisi while.Karena nilainya -1, perulangan akhirnya berhenti.
            }
            if (nilai < 0 || nilai > 100) { // mengecek nilai apakah nilai berada di luar rentang 0-100
                System.out.println("  Ditolak, harus 0-100"); // Menampilkan pesan bahwa nilai tersebut tidak valid.
                continue; // Input yang salah tidak dimasukkan ke daftar.Program kembali ke awal perulangan untuk meminta input lagi.
            }
            daftar.add(nilai); //Menambahkan nilai yang valid ke dalam ArrayList.
        } while (nilai != SELESAI);

        System.out.println(); // hanya di gunakan untuk membuat satu baris kosong agar tampilan lebih rapih

        //---kasus tidak ada nilai sah--
        if (daftar.isEmpty()) { // Mengecek apakah daftar kosong.isEmpty() menghasilkan: true → tidak ada data. false → ada data.
            System.out.println("Tidak ada nilai yang dimasukkan."); //Menampilkan pesan bahwa tidak ada nilai yang dimasukkan.
            return;
        }

        // ---------- Jumlah & rata-rata ----------
        int jumlah = daftar.size(); // Menyimpan jumlah data dalam variabel jumlah. Contoh:daftar = [80, 75, 90, 85] maka:jumlah = 4
        int total = 0; // Membuat variabel total untuk menampung jumlah seluruh nilai. Dimulai dari 0 karena belum ada nilai yang dijumlahkan.
        for (int i = 0; i < jumlah; i++) { // membuat perulangan for
            total += daftar.get(i); // Mengambil nilai pada indeks i kemudian menambahkannya ke total.
        }
        double rataRata = (double) total / jumlah; // (double) digunakan supaya pembagian menghasilkan angka desimal.
        // ---------- Tertinggi & terendah (loop sendiri) ----------
        // Keduanya dimulai dari nilai pertama di daftar (daftar.get(0)),
        // bukan dari 0 atau 100. Kalau terendah dimulai dari 0, hasilnya
        // salah karena tidak ada nilai yang lebih kecil dari 0 (padahal 0
        // mungkin bukan nilai siapa pun). Dengan nilai pertama sebagai
        // awal, pembanding selalu berasal dari data yang benar-benar ada.
        int tertinggi = daftar.get(0);
        int terendah = daftar.get(0);
        for (int i = 1; i < jumlah; i++) {
            int n = daftar.get(i);
            if (n > tertinggi) {
                tertinggi = n;
            }
            if (n < terendah) {
                terendah = n;
            }
        }

        // ---------- Di atas rata-rata (putaran kedua) ----------
        // Tidak bisa dihitung di putaran pertama (saat membaca), karena
        // rata-rata baru diketahui setelah SEMUA nilai terbaca. Saat nilai
        // pertama dibaca, rata-ratanya belum ada untuk dibandingkan.
        // Maka perlu putaran kedua sesudah rata-rata diketahui.
        int diAtasRata = 0;
        for (int i = 0; i < jumlah; i++) {
            if (daftar.get(i) > rataRata) {
                diAtasRata++;
            }
        }
        // ---------- Distribusi grade ----------
        // Index: 0=A (90-100), 1=B (80-89), 2=C (70-79), 3=D (60-69), 4=E (<60)
        int[] jumlahGrade = new int[5];
        for (int i = 0; i < jumlah; i++) {
            int n = daftar.get(i);
            if (n >= 90) {
                jumlahGrade[0]++;
            } else if (n >= 80) {
                jumlahGrade[1]++;
            } else if (n >= 70) {
                jumlahGrade[2]++;
            } else if (n >= 60) {
                jumlahGrade[3]++;
            } else {
                jumlahGrade[4]++;
            }
        }
        String[] namaGrade = {"A", "B", "C", "D", "E"};
 
        // ---------- Daftar terurut dari salinan ----------
        ArrayList<Integer> terurut = new ArrayList<>(daftar);
        Collections.sort(terurut);
 
        // ---------- Cetak hasil ----------
        System.out.println("Nilai tersimpan : " + daftar);
        System.out.println("Jumlah          : " + jumlah);
        System.out.println("Rata-rata       : " + String.format("%.2f", rataRata));
        System.out.println("Tertinggi       : " + tertinggi);
        System.out.println("Terendah        : " + terendah);
        System.out.println("Di atas rata2   : " + diAtasRata + " orang");
 
        System.out.print("Distribusi      : ");
        for (int i = 0; i < jumlahGrade.length; i++) {
            System.out.print(namaGrade[i] + "=" + jumlahGrade[i]);
            if (i < jumlahGrade.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
 
        System.out.println("Terurut         : " + terurut);
        System.out.println("Urutan asli     : " + daftar);
    }
}
    }
}



