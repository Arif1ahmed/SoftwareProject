
import java.sql.*;
import java.util.*;

public class DonorRepository{
    Connection con;
    Statement stm;
    ResultSet rs;
    Donor don=new Donor();
    List<Donor> donList = new ArrayList<Donor>();
    public DonorRepository(){
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodlobby","root","");
            stm=con.createStatement();
        }catch(SQLException r){
            System.out.println(r);
        }
    }

    public boolean insertDonorToDb(Donor don){
        int i=0;
        try{
            i=stm.executeUpdate("INSERT INTO donors(id,fullname,bg,contact) VALUES('"+don.getId()+"','"+don.getFullname()+"','"+don.getBg()+"','"+don.getContact()+"')");
        }catch(SQLException e){
            System.out.println(e);
        }
        if(i==1){
            return true;
        }
        else{
            return false;
        }
    }

    public List<Donor> getDonorsById(int id){
    
        try{
            rs=stm.executeQuery("SELECT * FROM donors WHERE id="+"'"+id+"'");
            while(rs.next()){
                don = new Donor();
                don.setId(Integer.parseInt(rs.getString("id")));
                don.setFullname(rs.getString("fullname"));
                don.setBg(rs.getString("bg"));
                don.setContact(rs.getString("contact"));
                donList.add(don);
            }
            return donList;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
}