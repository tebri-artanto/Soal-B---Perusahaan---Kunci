package control;

import model.Akun;
import dao.AkunDAO;
/**
 *
 * @author Alfons
 */

public class AkunControl {
    private AkunDAO aDAO = new AkunDAO();
    
    public Akun searchAkun(String username, String password)
    {
        Akun akuncustomer= null;
        akuncustomer = aDAO.searchAkun(username, password);
        return akuncustomer;            
    }
}
