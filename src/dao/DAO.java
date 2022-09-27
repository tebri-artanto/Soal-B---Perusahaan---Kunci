package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Akun;
import model.Departemen;
import model.Karyawan;

public class DAO {
    public static Connection con;    
    public String URL  = "jdbc:ucanaccess://";
//    public static final String PATH = "D:\\99999 On Progress\\Persiapan Asisten Dosen\\3 Latihan\\Latihan Kelas A\\Soal B - Perusahaan - Kunci/src/dataOP.accdb";
    String currentDir = System.getProperty("user.dir");   
    public String PATH = currentDir + "/src/dataOP.accdb";  
    
    
    
    //Connection
    public Connection makeConnection()
    {
        System.out.println("Opening Database...");
        try{
            con = DriverManager.getConnection(URL+PATH);
            System.out.println("Success (Opening Database)!");
        }catch(Exception e)
        {
            System.out.println("Error Opening Database...");
            System.out.println(e);
        }
        return  con;    
    }
    
    public void closeConnection()
    {
        System.out.println("Closing Database...");
        try{
            con.close();
            System.out.println("Success (Closing Database)!!");
        }catch(Exception e)
        {
            System.out.println("Error Closing Database...");
            System.out.println(e);
        }
    }
    
    //DAO untuk Departemen
    public void insertDepartemen(Departemen p)
    {

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
        
    }
        
          //Read
    public void showDepartemen()
    {
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
       // return list;
    }

    //Update
   public void updateDepartemen(Departemen P)
   {

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
   }

   //Delete
   public void deleteDepartemen(String kodeDepartemen)
   {

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
   }

   //Search
   public Departemen searchDepartemen(String kode)
   {
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
        return p;
    }
    //DAO untuk Login
  
     public Akun searchAkun(String username, String password)
    {     
        String sql = "SELECT * FROM Akun where username = '"+ username +"' and password = '"+ password +"'";
        
        System.out.println("Searching Akun Staff");
        
        Akun as = null;

        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("Sukses Akses Database");
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
        return as;
    }
    //DAO untuk Karyawan
    public void insertKaryawan(Karyawan m)
    {
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
    }
    
    public void showKaryawan()
    {
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
    }
    
    public void updateKaryawan(Karyawan m)
    {

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
    }
    
    public void deleteKaryawan(String kodeKaryawan)
    {

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
    }
    
       public Karyawan searchKaryawan(String kode)
   {
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
        return m;
    }
       
    public void searchKaryawanByDepartemen(String kode)
    {
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
       // return p;
    }
    

    
}
