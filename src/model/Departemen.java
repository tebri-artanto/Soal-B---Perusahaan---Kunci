package model;

public class Departemen {
    private String kodeDepartemen;
    private String namaDepartemen;
    private int jumlahKaryawan;
    
    public Departemen()
    {
        
    }
    public Departemen(String kodeDepartemen, String namaDepartemen, int jumlahKaryawan) {
        this.kodeDepartemen = kodeDepartemen;
        this.namaDepartemen = namaDepartemen;
        this.jumlahKaryawan = jumlahKaryawan;
    }

    public String getKodeDepartemen() {
        return kodeDepartemen;
    }

    public void setKodeDepartemen(String kodeDepartemen) {
        this.kodeDepartemen = kodeDepartemen;
    }

    public String getNamaDepartemen() {
        return namaDepartemen;
    }

    public void setNamaDepartemen(String namaDepartemen) {
        this.namaDepartemen = namaDepartemen;
    }

    public int getJumlahKaryawan() {
        return jumlahKaryawan;
    }

    public void setJumlahKaryawan(int jumlahKaryawan) {
        this.jumlahKaryawan = jumlahKaryawan;
    }
    
    public void showData()
    {
        System.out.println("Kode Departemen : "+kodeDepartemen);
        System.out.println("Nama Departemen : "+namaDepartemen);
        System.out.println("Jumlah Karyawan : "+jumlahKaryawan);
        System.out.println("\n");
    }
    
    
}
