public class CreateService{
    UserRepository urp=new UserRepository();
    public CreateService(){

    }
    public boolean checkUsername(String username){
        return urp.userValidation(username);
    }
}