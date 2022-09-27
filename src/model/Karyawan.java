package model;

public class Karyawan {
 private String kodeKaryawan;
 private String namaKaryawan;
 private Departemen departemen;
 
    public Karyawan()
    {    }

    public Karyawan(String kodeKaryawan, String namaKaryawan, Departemen departemen) {
        this.kodeKaryawan = kodeKaryawan;
        this.namaKaryawan = namaKaryawan;
        this.departemen = departemen; // Asosiasi one - Many
    }

    public String getKodeKaryawan() {
        return kodeKaryawan;
    }

    public void setKodeKaryawan(String kodeKaryawan) {
        this.kodeKaryawan = kodeKaryawan;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    public Departemen getDepartemen() {
        return departemen;
    }

    public void setDepartemen(Departemen departemen) {
        this.departemen = departemen;
    }
    
    public void showKaryawan()
    {
        System.out.println("--------------------------------");
        System.out.println("NPM     : "+kodeKaryawan);
        System.out.println("Nama    : "+namaKaryawan);
        System.out.println("Departemen   : "+departemen.getNamaDepartemen()+"("+departemen.getKodeDepartemen()+")\n");
        
    }
    
    public void showKaryawanByDepartemen()
    {
        System.out.println("| "+kodeKaryawan + "|"+namaKaryawan + "|");
    }
 
 
}
