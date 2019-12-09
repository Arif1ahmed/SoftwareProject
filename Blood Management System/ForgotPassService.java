import java.util.*;

class ForgotPassService{
    ForgotPass fp;
    ForgotPassRepository fps = new ForgotPassRepository();
    public boolean addForgotPass(ForgotPass fp){
        return fps.insertForgotPassToDb(fp);
    }

    public ForgotPass getForgotPassByUsername(String username){
        fp = fps.getForgotPassFromDb(username);
        return fp;
    }

    public boolean removeForgotPass(String username){
        return fps.removeForgotPassFromDb(username);
    }


}