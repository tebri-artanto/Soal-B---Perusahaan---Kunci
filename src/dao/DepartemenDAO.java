package dao;


import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Departemen;

public class DepartemenDAO {
    private DbConnection dbcon = new DbConnection();
    private Connection con;
        
        
    //Create
    public void insertDepartemen(Departemen p)
    {
        con = dbcon.makeConnection();
        String sql = "INSERT INTO Departemen(kodeDepartemen, namaDepartemen, jumlahKaryawan) VALUES "
                + "('" + p.getKodeDepartemen() + "','" + p.getNamaDepartemen()+"','"+p.getJumlahKaryawan()+"')";
        System.out.println("Adding Departemen");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Adding " + result + " Departemen\n");
        }catch(Exception e)
        {
            System.out.println("Error Adding Departemen");
            System.out.println(e);
        }
        dbcon.closeConnection();
    }

    //Read
    public void showDepartemen()
    {
        con = dbcon.makeConnection();
        String sql = "SELECT * FROM Departemen";
        System.out.println("Mengambil data Departemen\n");
        //List<Departemen> list = new ArrayList();
        try{
           Statement statement = con.createStatement();
           ResultSet rs = statement.executeQuery(sql);
           
           if(rs != null)
           {
               while(rs.next())
               {
                   Departemen p = new Departemen(rs.getString("kodeDepartemen"),rs.getString("namaDepartemen"), rs.getInt("jumlahKaryawan"));
                   p.showData();
               }
           }
           rs.close();
           statement.close();
        }catch(Exception e)
        {
            System.out.println("Error reading data Departemen\n");
        }
        dbcon.closeConnection();
       // return list;
    }

    //Update
   public void updateDepartemen(Departemen P)
   {
       con = dbcon.makeConnection();

       String sql = "UPDATE Departemen SET namaDepartemen = '"+ P.getNamaDepartemen() +"',jumlahKaryawan = '"+P.getJumlahKaryawan()
               +"' WHERE kodeDepartemen  = '" + P.getKodeDepartemen() + "'";
       System.out.println("Updating Departemen");
       try{
           Statement statement = con.createStatement();
           int result = statement.executeUpdate(sql);
           System.out.println("Edited " + result + "Departemen\n");
       }catch(Exception e)
       {
           System.out.println("Error editing Departemen");
           System.out.println(e);
       }
       dbcon.closeConnection();
   }

   //Delete
   public void deleteDepartemen(String kodeDepartemen)
   {
       con = dbcon.makeConnection();

       String sql = "DELETE * FROM Departemen WHERE kodeDepartemen ='" + kodeDepartemen + "'";
       System.out.println("Deleting Departemen");
       
       try{
           Statement statement = con.createStatement();
           int result = statement.executeUpdate(sql);
           System.out.println("Success Deleting "+result+" Departemen\n");
       }catch(Exception e)
       {
           System.out.println("Error Deleting Departemen");
           System.out.println("Success Deleting Departemen");
       }
       dbcon.closeConnection();
   }

   //Search
   public Departemen searchDepartemen(String kode)
   {
       con = dbcon.makeConnection();
        String sql = "SELECT * FROM Departemen WHERE kodeDepartemen ='" + kode + "' or namaDepartemen = '" + kode + "'";
        System.out.println("Searching Departemen");
         
        Departemen p = null;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("Searching "+kode+"\n");
            if(rs != null)
            {
                while(rs.next())
                {
                    p = new Departemen(
                            rs.getString("kodeDepartemen"),
                            rs.getString("namaDepartemen"),
                            Integer.parseInt(rs.getString("jumlahKaryawan"))
                    );
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e)
        {
            System.out.println("Error searching data Departemen");
            System.out.println(p);
        }  
        dbcon.closeConnection();
        return p;
    }

    
}
