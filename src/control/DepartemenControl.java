package control;

import connection.DbConnection;
import dao.DepartemenDAO; // dao biasanya menjadi objek yang dipanggil fungsinya
import model.Departemen;  // model biasanya menjadi parameter 
import java.util.List;

public class DepartemenControl {
    private DepartemenDAO pDAO =  new DepartemenDAO();    
    private DbConnection dCon = new DbConnection();
    
    public void insertDepartemen(Departemen P)
    {
        pDAO.insertDepartemen(P);
    }
    
    public void showDepartemen()
    {
        pDAO.showDepartemen();
    }
    
    public void updateDepartemen(Departemen P)
    {
        pDAO.updateDepartemen(P);
    }
    
    public void deleteDepartemen(String kode)
    {
        pDAO.deleteDepartemen(kode);
    }
    
    public Departemen searchDepartemen(String kode)
    {
       return pDAO.searchDepartemen(kode);
    }
    
    
}
