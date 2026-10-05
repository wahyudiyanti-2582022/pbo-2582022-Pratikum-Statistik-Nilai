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

    }
}



