package control;

import connection.DbConnection;
import model.Karyawan;
import model.Departemen;
import dao.KaryawanDAO;

/**
 *
 * @author Alfons
 */
public class KaryawanControl {
    private KaryawanDAO mDao = new KaryawanDAO();

    
    public void insertKaryawan(Karyawan P)
    {
        mDao.insertKaryawan(P);
    }
    
    public void showKaryawan()
    {
        mDao.showKaryawan();
    }
    
    public void updateKaryawan(Karyawan P)
    {
        mDao.updateKaryawan(P);
        P.showKaryawan();
    }
    
    public void deleteKaryawan(String kode)
    {
        mDao.deleteKaryawan(kode);
    }
    
    public Karyawan searchKaryawan(String kode)
    {
        return mDao.searchKaryawan(kode);
    }
    public void searchKaryawanByDepartemen(String kode)
    {
       mDao.searchKaryawanByDepartemen(kode);
    }
}
