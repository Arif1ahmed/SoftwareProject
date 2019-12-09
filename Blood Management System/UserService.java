import java.util.*;

public class UserService{

    User user = new User();
    List<User> userList=new ArrayList<User>();
    UserRepository urp=new UserRepository();
    
    public boolean addNewUser(User user){
        return urp.insertUserToDb(user);
    }
    public boolean editUser(User user){
        return urp.updateToDb(user);
    }
    public boolean removeUserByUsername(String username){
        return urp.removeFromDb(username);
    }

    public User getUserByUsername(String username){
        user = urp.getUserFromDb(username);
        return user;
    }
    public List<User> loadAllUser(){
        userList = urp.getAllUser();
        return userList;
    }

    public boolean getUserValidation(String username){
        return urp.userValidation(username);
    }

    public boolean addUserAsAdmin(String username){
        return urp.addAdmin(username);
    }

    public boolean removeUserAsAdmin(String username){
        return urp.removeAdmin(username);
    }

    public boolean updatePass(String username, String password){
        return urp.updatePassFromDb(username,password);
    }

}