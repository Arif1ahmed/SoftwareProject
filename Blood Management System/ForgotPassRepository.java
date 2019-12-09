import java.sql.*;
import java.util.*;

public class ForgotPassRepository{
    Connection con;
    Statement stm;
    ResultSet rs;
    ForgotPass fp = new ForgotPass();
    List<ForgotPass> fpList = new ArrayList<ForgotPass>();
    public ForgotPassRepository(){
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodlobby","root","");
            stm=con.createStatement();
        }catch(SQLException r){
            System.out.println(r);
        }
    }

    public boolean insertForgotPassToDb(ForgotPass fp){
        int i=0;
        try{
            i=stm.executeUpdate("INSERT INTO forgotpass(username,qsn,ans) VALUES('"+fp.getUsername()+"','"+fp.getQsn()+"','"+fp.getAns()+"')");
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

    public ForgotPass getForgotPassFromDb(String username){
    
        try{
            rs=stm.executeQuery("SELECT * FROM forgotpass WHERE username='"+username+"'");
            if(rs.next()){
                fp.setUsername(rs.getString("username"));
                fp.setQsn(rs.getString("qsn"));
                fp.setAns(rs.getString("ans"));
                return fp;
            }
            else{
                return null;
            }
            
            
        }catch(SQLException d){
            System.out.println(d);
        }
                
            return null;

    }

    public boolean removeForgotPassFromDb(String username){
        int i=0;
        try{
            i=stm.executeUpdate("DELETE FROM forgotpass WHERE username='"+username+"'");
            
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
    
}