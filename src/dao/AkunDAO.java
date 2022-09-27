package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Akun;

/**
 *
 * @author Alfons
 */

public class AkunDAO {
    private DbConnection dbcon  = new DbConnection();
    private Connection con;
    
    //Search Akun sign in --> cari yang username & passwor sesuai
    public Akun searchAkun(String username, String password)
    {
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM Akun where username = '"+ username +"' and password = '"+ password +"'";
        
        System.out.println("Searching Akun Staff");
        
        Akun as = null;

        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs != null)
            {
                while(rs.next())
                {              
                   as = new Akun(
                            rs.getString("Username"),
                            rs.getString("Password"));     
                }
            }
            rs.close();
            statement.close();
                   }catch(Exception e)
        {
            System.out.println("Error searching data Staff");
            System.out.println(e);
        }
        dbcon.closeConnection();
        return as;
    }
    //Sign up --> INSERT 
    
}
