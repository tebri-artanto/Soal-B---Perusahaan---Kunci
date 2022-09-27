package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Akun model dan Control
import model.Departemen;
import control.DepartemenControl;
import model.Karyawan;
import control.KaryawanControl;
import model.Akun;
import control.AkunControl;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
       int pilMenu;
       //Departemen
        String kodeDepartemen, namaDepartemen;
       int kuotaKaryawan;
       String kode, namaKaryawan;
       //Controller
       DepartemenControl pc = new DepartemenControl();
       KaryawanControl mc = new KaryawanControl();
       Departemen departemen = new Departemen();
       Karyawan karyawan = new Karyawan();
       login();
       do{  
            System.out.println("=======================================");
            System.out.println("========= PERUSAHAAN JAYA ==========");
            System.out.println("========== YOGYAKARTA =================");
            System.out.println("=== 1. INSERT Data Departemen       ========");
            System.out.println("=== 2. UPDATE Data Departemen       ========");
            System.out.println("=== 3. DELETE Data Departemen       ========");
            System.out.println("=== 4. SHOW Data Departemen         ========");
            System.out.println("=== 5. INSERT Data Karyawan   ========");
            System.out.println("=== 6. UPDATE Data Karyawan   ========");
            System.out.println("=== 7. DELETE Data Karyawan   ========");
            System.out.println("=== 8. SHOW Data Karyawan   ========");
            System.out.println("=== 9. SHOW Data Karyawan By Departemen ====");
            System.out.println("=== 0. Exit                    ========");
            System.out.print("Pilihan Menu : "); pilMenu =  Integer.parseInt(br.readLine());
            switch(pilMenu)
            {
                case 1 :
                    System.out.println("============ INSERT DEPARTEMEN ==================");
                    System.out.println("Masukan Kode Departemen : "); kodeDepartemen = br.readLine();
                    System.out.println("Masukan Nama Departemen : "); namaDepartemen = br.readLine();
                    System.out.println("Masukan Kuota Karyawan  "); kuotaKaryawan = Integer.parseInt(br.readLine());
                    departemen = new Departemen(kodeDepartemen, namaDepartemen, kuotaKaryawan);
                    pc.insertDepartemen(departemen);
                    System.out.println("=======================================");
                    showDepartemen();
                    break;
                case 2 :
                    System.out.println("============ UPDATE DEPARTEMEN ===================");
                    System.out.println("Masukan Kode Departemen Yang ingin diUpdate : "); kodeDepartemen = br.readLine();
                    System.out.println("Data Baru : ");
                    System.out.println("Masukan Nama Departemen : "); namaDepartemen = br.readLine();
                    System.out.println("Masukan Kuota Karyawan  "); kuotaKaryawan = Integer.parseInt(br.readLine());
                    departemen = new Departemen(kodeDepartemen, namaDepartemen, kuotaKaryawan);
                    pc.updateDepartemen(departemen);
                    showDepartemen();
                    break;
                case 3 :
                    System.out.println("============ DELETE ==================");
                    System.out.println("Masukan Kode Departemen yang ingin diDelete : "); kodeDepartemen = br.readLine();
                    pc.deleteDepartemen(kodeDepartemen);
                    showDepartemen();
                    break;
                case 4 :
                    System.out.println("============= DATA DEPARTEMEN ==============");
                    pc.showDepartemen();
                    System.out.println("=======================================");
                    break;
                case 5 :
                    System.out.println("============ INSERT KARYAWAN ==================");
                    System.out.println("Masukan kode karyawan : "); kode = br.readLine();
                    System.out.println("Masukan Nama  : "); namaKaryawan = br.readLine();
                    System.out.println("Masukan Departemen : "); namaDepartemen = br.readLine();
                    System.out.println("=======================================");
                    departemen = pc.searchDepartemen(namaDepartemen); 
                    karyawan = new Karyawan(kode,namaKaryawan , departemen);
                    mc.insertKaryawan(karyawan);
                    mc.showKaryawan();
                    break;
                case 6 :
                    System.out.println("============ UPDATE KARYAWAN ===================");
                    System.out.println("Masukan kode karyawan Yang ingin diUpdate : "); kode = br.readLine();
                    System.out.println("Data Baru : ");
                    System.out.println("Karyawan pindah ke Departemen Apa? (kode/nama departemen) : "); kodeDepartemen=br.readLine();
//                    System.out.println("Masukan Kuota Karyawan  "); kuotaKaryawan = Integer.parseInt(br.readLine())
                    Karyawan temp = mc.searchKaryawan(kode);
                    String nama = temp.getNamaKaryawan();
                    System.out.println("Testing : " +nama);
                    departemen = pc.searchDepartemen(kodeDepartemen);
                    karyawan = new Karyawan(kode,nama, departemen);
                    mc.updateKaryawan(karyawan);
                    
                    
                    break;
                case 7:
                    System.out.println("============ DELETE KARYAWAN ==================");
                    System.out.println("Masukan kode karyawan yang ingin diDelete : "); kode = br.readLine();
                    mc.deleteKaryawan(kode);
                    mc.showKaryawan();
                    break;
                case 8:
                    System.out.println("=========== SHOW SELURUH DATA KARYAWAN ============");
                     mc.showKaryawan();
                    System.out.println("=======================================");
                    break;
                case 9:
                    System.out.println("=================================");
                    System.out.println("Masukin kode Departemen : "); kodeDepartemen = br.readLine();
                    mc.searchKaryawanByDepartemen(kodeDepartemen);
                    break;
                   
                case 0 :

                    break;
                default :
                    System.out.println("Menu yang dipilih tidak ada !!!");
                    break;
            }
          System.out.println("Press Any Key To Continue...");
          new java.util.Scanner(System.in).nextLine();
        }while(pilMenu !=0);
    }
    
    static void showDepartemen()
    {
        DepartemenControl pc = new  DepartemenControl();
        System.out.println("========= HASIL =========");
        pc.showDepartemen();
        System.out.println("=========================");
    }
    
        static void showKaryawan()
    {
        KaryawanControl mc = new  KaryawanControl();
        System.out.println("========= HASIL =========");
        mc.showKaryawan();
        System.out.println("=========================");
    }
   
    static void login() throws IOException
    {
        AkunControl ac = new AkunControl();
        String username, password;
        Akun akun = null;
        do{
            System.out.println("Username : ");username = br.readLine();
            System.out.println("Password : ");password = br.readLine();
            akun = ac.searchAkun(username, password);
            if(akun==null)
            {
                System.out.println("Akun tidak ditemukan!!");
            }
        }while(akun==null);
    }
    
}   


