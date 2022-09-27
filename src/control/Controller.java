/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.DAO;
import model.Akun;
import model.Departemen;
import model.Karyawan;

/**
 *
 * @author A412DA
 */
public class Controller {
       private DAO dao = new DAO();
       
    public void insertDepartemen(Departemen P)
    {
        dao.makeConnection();
        dao.insertDepartemen(P);
        dao.closeConnection();
    }
    
    public void showDepartemen()
    {
        dao.makeConnection();
        dao.showDepartemen();
        dao.closeConnection();
    }
    
    public void updateDepartemen(Departemen P)
    {
        dao.makeConnection();
        dao.updateDepartemen(P);
        dao.closeConnection();
    }
    
    public void deleteDepartemen(String kode)
    {
        dao.makeConnection();
        dao.deleteDepartemen(kode);
        dao.closeConnection();
    }
    
    public Departemen searchDepartemen(String kode)
    {
        Departemen temp = new Departemen();
        dao.makeConnection();
        temp = dao.searchDepartemen(kode);
        dao.closeConnection();
        return temp;
    }
        
    
    public Akun searchAkun(String username, String password)
    {
        Akun temp = null;
        dao.makeConnection();
        temp = dao.searchAkun(username, password);
        dao.closeConnection();
        return temp;
    }
    

    
    public void insertKaryawan(Karyawan P)
    {
        dao.makeConnection();
        dao.insertKaryawan(P);
        dao.closeConnection();
    }
    
    public void showKaryawan()
    {
        dao.makeConnection();
        dao.showKaryawan();
        dao.closeConnection();
    }
    
    public void updateKaryawan(Karyawan P)
    {
        dao.makeConnection();
        dao.closeConnection();
    }
    
    public void deleteKaryawan(String kode)
    {
        dao.makeConnection();
        dao.deleteKaryawan(kode);
        dao.closeConnection();
    }
    
    public Karyawan searchKaryawan(String kode)
    {
        Karyawan k = new Karyawan();
        dao.makeConnection();
        k = dao.searchKaryawan(kode);
        dao.closeConnection();
        return k;
    }
    public void searchKaryawanByDepartemen(String kode)
    {
       dao.makeConnection();
       dao.searchKaryawanByDepartemen(kode);
       dao.closeConnection();
    }
}
