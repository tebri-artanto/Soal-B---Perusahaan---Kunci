package dao;

import model.Karyawan;
import model.Departemen;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class KaryawanDAO {
    private DbConnection dbcon = new DbConnection();
    private Connection con;
    
    public void insertKaryawan(Karyawan m)
    {
        con = dbcon.makeConnection();
        String sql = "INSERT into Karyawan(kodeKaryawan, namaKaryawan, kodeDepartemen) VALUES"
                + "('" + m.getKodeKaryawan()+"','"+ m.getNamaKaryawan()+"','"+ m.getDepartemen().getKodeDepartemen() + "')";
        System.out.println("Adding Karyawan");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Adding " + result + " Karyawan\n");            
        }catch(Exception e)
        {
            System.out.println("Error Adding Karyawan");
            System.out.println(e);
        }
        dbcon.closeConnection();
    }
    
    public void showKaryawan()
    {
        con = dbcon.makeConnection();
//        String sql = "SELECT m.*,p.* FROM Karyawan as m JOIN Departemen as p ON m.kodeDepartemen = p.kodeDepartemen";
          String sql = "SELECT Karyawan.kodeKaryawan, Karyawan.namaKaryawan, Karyawan.kodeDepartemen, Departemen.namaDepartemen,"
                  + " Departemen.jumlahKaryawan FROM Departemen INNER JOIN "
                  + "Karyawan ON Departemen.[kodeDepartemen] = Karyawan.[kodeDepartemen]";

        System.out.println("Mengambil data Karyawan\n");
        //List<Departemen> list = new ArrayList();
        try{
           Statement statement = con.createStatement();
           ResultSet rs = statement.executeQuery(sql);
           
           if(rs != null)
           {
               while(rs.next())
               {
                   Departemen p = new Departemen(rs.getString("kodeDepartemen"),
                           rs.getString("namaDepartemen"), 
                           Integer.parseInt(rs.getString("jumlahKaryawan"))
                   );
                   Karyawan m = new Karyawan(rs.getString("kodeKaryawan"),rs.getString("namaKaryawan"), p);
                   m.showKaryawan();
               }
           }
           rs.close();
           statement.close();
        }catch(Exception e)
        {
            System.out.println("Error reading data Karyawan\n");
        }
        dbcon.closeConnection();        
    }
    
    public void updateKaryawan(Karyawan m)
    {
        con = dbcon.makeConnection();

       String sql = "UPDATE Karyawan SET namaKaryawan = '"+ m.getNamaKaryawan()+"',kodeDepartemen = '"+m.getDepartemen().getKodeDepartemen()
               +"' WHERE kodeKaryawan  = '" + m.getKodeKaryawan()+ "'";
       System.out.println("Updating Karyawan");
       try{
           Statement statement = con.createStatement();
           int result = statement.executeUpdate(sql);
           System.out.println("Edited " + result + "Karyawan\n");
       }catch(Exception e)
       {
           System.out.println("Error editing Karyawan");
           System.out.println(e);
       }
       dbcon.closeConnection();       
    }
    
    public void deleteKaryawan(String kodeKaryawan)
    {
       con = dbcon.makeConnection();

       String sql = "DELETE * FROM Karyawan WHERE kodeKaryawan ='" +kodeKaryawan + "'";
       System.out.println("Deleting Karyawan");
       
       try{
           Statement statement = con.createStatement();
           int result = statement.executeUpdate(sql);
           System.out.println("Success Deleting "+result+" Karyawan\n");
       }catch(Exception e)
       {
           System.out.println("Error Deleting Karyawan");
           System.out.println("Success Deleting Karyawan");
       }
       dbcon.closeConnection();        
    }
    
       public Karyawan searchKaryawan(String kode)
   {
        con = dbcon.makeConnection();
        String sql = "SELECT Karyawan.kodeKaryawan, Karyawan.namaKaryawan, Karyawan.kodeDepartemen, Departemen.namaDepartemen,"
                  + " Departemen.jumlahKaryawan FROM Departemen INNER JOIN "
                  + " Karyawan ON Departemen.[kodeDepartemen] = Karyawan.[kodeDepartemen]"
                  + " WHERE kodeKaryawan = '"+ kode +"'" ;
        System.out.println("Searching Karyawan");
        Departemen p = null;
        Karyawan m = null;
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
                            rs.getInt("jumlahKaryawan")
                    );
                    
                    m = new Karyawan(
                            rs.getString("kodeKaryawan"),
                            rs.getString("namaKaryawan"),
                            p);
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e)
        {
            System.out.println("Error searching data  Karyawan");
            System.out.println(m);
        }  
        dbcon.closeConnection();
        return m;
    }
       
    public void searchKaryawanByDepartemen(String kode)
    {
        con = dbcon.makeConnection();
        String sql = "SELECT Karyawan.kodeKaryawan, Karyawan.namaKaryawan, Karyawan.kodeDepartemen, Departemen.namaDepartemen,"
                  + " Departemen.jumlahKaryawan FROM Departemen INNER JOIN "
                  + " Karyawan ON Departemen.[kodeDepartemen] = Karyawan.[kodeDepartemen]"
                  + " WHERE kodeDepartemen = '"+ kode +"'" ;

        Departemen p = null;
        Karyawan m = null;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs !=null)
            {
                while(rs.next())
                {
                    p = new Departemen(rs.getString("kodeDepartemen"),rs.getString("namaDepartemen"), rs.getInt("jumlahKaryawan"));
                    m = new Karyawan(rs.getString("kodeKaryawan"), rs.getString("namaKaryawan"), p);
                    m.showKaryawanByDepartemen();
                }
            }
        rs.close();
        statement.close();
        }catch(Exception e)
        {
            System.out.println("Error searching data Karyawan By Departemen");
            System.out.println(e);
        }  
        dbcon.closeConnection();
       // return p;
    }
}
