
import java.sql.*;
import java.util.*;

public class UserRepository{
    Connection con;
    Statement stm;
    ResultSet rs;
    User user=new User();
    List<User> userList = new ArrayList<User>();
    public UserRepository(){
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodlobby","root","");
            stm=con.createStatement();
        }catch(SQLException r){
            System.out.println(r);
        }
    }

    public boolean insertUserToDb(User user){
        int i=0;
        try{
            i=stm.executeUpdate("INSERT INTO users(username,password,fullname,contact,dob,bg,email,gender,admin) VALUES('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getFullname()+"','"+user.getContact()+"','"+user.getDob()+"','"+user.getBg()+"','"+user.getEmail()+"','"+user.getGender()+"','"+user.getAdmin()+"')");
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

    public boolean updateToDb(User user){
        int i=0;
        try{
            i=stm.executeUpdate("UPDATE users SET fullname='"+user.getFullname()+"',contact='"+user.getContact()+"',dob='"+user.getDob()+"',gender='"+user.getGender()+"',bg='"+user.getBg()+"',email='"+user.getEmail()+"' WHERE username="+"'"+user.getUsername()+"'");
            
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

    public boolean updatePassFromDb(String username, String password){
        int i=0;
        try{
            i=stm.executeUpdate("UPDATE users SET password='"+password+"' WHERE username="+"'"+username+"'");
            
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

    public User getUserFromDb(String username){
    
        try{
            rs=stm.executeQuery("SELECT * FROM users WHERE username="+"'"+username+"'");
            if(rs.next()){
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFullname(rs.getString("fullname"));
                user.setContact(rs.getString("contact"));
                user.setDob(rs.getString("dob"));
                user.setBg(rs.getString("bg"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setAdmin(rs.getString("admin"));
                return user;
            }
            else{
                return null;
            }
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
                
            return null;

    }

    public List<User> getAllUser(){
    
        try{
            rs=stm.executeQuery("SELECT * FROM users");
            while(rs.next()){
                user=new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFullname(rs.getString("fullname"));
                user.setContact(rs.getString("contact"));
                user.setDob(rs.getString("dob"));
                user.setBg(rs.getString("bg"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setAdmin(rs.getString("admin"));
                userList.add(user);
                
            }
            return userList;
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        
        
            return null;
        
        
    }
    public boolean loginValidation(String username,String password){
        try{
            rs=stm.executeQuery("SELECT * FROM users WHERE username='"+username+"' AND password='"+password+"'");
            
            if(rs.next()){
                return true;
            }
        }catch(SQLException d){
            System.out.println(d);
        }
        return false;
    }
    public boolean userValidation(String username){
        try{
            rs=stm.executeQuery("SELECT * FROM users WHERE username='"+username+"'");
            if(rs.next()){
                return true;
            }
        }catch(SQLException d){
            System.out.println(d);
        }
        return false;
    }
    public boolean removeFromDb(String username){
        int i=0;
        try{
            i=stm.executeUpdate("DELETE FROM users WHERE username='"+username+"'");
            
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

    public boolean addAdmin(String username){
        int i=0;
        try{
            i=stm.executeUpdate("UPDATE users SET admin='yes' WHERE username='"+username+"'");
            
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

    public boolean removeAdmin(String username){
        int i=0;
        try{
            i=stm.executeUpdate("UPDATE users SET admin='no' WHERE username='"+username+"'");
            
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