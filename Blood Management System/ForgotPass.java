public class ForgotPass{
    String username,qsn,ans;

    public ForgotPass(){}

    //setter methods
    public void setUsername(String username){
        this.username = username;
    }
    public void setQsn(String qsn){
        this.qsn = qsn;
    }
    public void setAns(String ans){
        this.ans = ans;
    }

    //getter methods
    public String getUsername(){
        return username;
    }
    public String getQsn(){
        return qsn;
    }
    public String getAns(){
        return ans;
    }
}