
import java.sql.*;
import java.util.*;

public class RequestRepository{
    Connection con;
    Statement stm;
    ResultSet rs;
    Request req=new Request();
    List<Request> reqList = new ArrayList<Request>();
    public RequestRepository(){
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodlobby","root","");
            stm=con.createStatement();
        }catch(SQLException r){
            System.out.println(r);
        }
    }

    public boolean insertRequestToDb(Request req){
        int i=0;
        try{
            i=stm.executeUpdate("INSERT INTO requests(fullname,hospital,location,bg,bq,contact,date,username) VALUES('"+req.getFullname()+"','"+req.getHospital()+"','"+req.getLocation()+"','"+req.getBg()+"','"+req.getBq()+"','"+req.getContact()+"','"+req.getDate()+"','"+req.getUsername()+"')");
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

    public Request getRequestFromDb(int id){
    
        try{
            rs=stm.executeQuery("SELECT * FROM requests WHERE id="+"'"+id+"'");
            if(rs.next()){
                req.setId(Integer.parseInt(rs.getString("id")));
                req.setFullname(rs.getString("fullname"));
                req.setHospital(rs.getString("hospital"));
                req.setLocation(rs.getString("location"));
                req.setBg(rs.getString("bg"));
                req.setBq(rs.getString("bq"));
                req.setContact(rs.getString("contact"));
                req.setDate(rs.getString("date"));
                req.setUsername(rs.getString("username"));
                return req;
            }
            else{
                return null;
            }
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
                
            return null;

    }

    public boolean removeFromDb(int id){
        int i=0;
        try{
            i=stm.executeUpdate("DELETE FROM requests WHERE id="+"'"+id+"'");
            
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

    public List<Request> getAllRequest(){
    
        try{
            rs=stm.executeQuery("SELECT * FROM requests");
            while(rs.next()){
                req = new Request();
                req.setId(Integer.parseInt(rs.getString("id")));
                req.setFullname(rs.getString("fullname"));
                req.setHospital(rs.getString("hospital"));
                req.setLocation(rs.getString("location"));
                req.setBg(rs.getString("bg"));
                req.setBq(rs.getString("bq"));
                req.setContact(rs.getString("contact"));
                req.setDate(rs.getString("date"));
                req.setUsername(rs.getString("username"));
                reqList.add(req);
            }
            //System.out.println(userList);
            return reqList;
        }catch(SQLException e){
            System.out.println(e);    
            return null;
        }
    }

    public boolean requestValidation(int id){
        try{
            rs=stm.executeQuery("SELECT * FROM requests WHERE id='"+id+"'");
            if(rs.next()){
                return false;
            }
        }catch(SQLException d){
            System.out.println(d);
        }
        return true;
    }
}