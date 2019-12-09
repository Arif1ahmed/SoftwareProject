
public class User{
    String username,password,fullname,contact,dob,bg,email,gender,admin;

    public User(){}

    public User(String[] s){
        this.fullname=s[0];
        this.username=s[1];
        this.password=s[2];
        this.contact=s[3];
        this.bg=s[4];
        this.dob=s[5];
        this.gender=s[6];
        this.email=s[7];
        this.admin=s[8];
    }

    public User(String fullname, String username, String password, String contact, String bg, String dob, String gender, String email,String admin){
        this.username=username;
        this.password=password;
        this.fullname=fullname;
        this.contact=contact;
        this.dob=dob;
        this.bg=bg;
        this.email=email;
        this.gender=gender;
        this.admin=admin;
    }

    //setter methods
    public void setUsername(String username){
        this.username=username;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setFullname(String fullname){
        this.fullname=fullname;
    }
    public void setContact(String contact){
        this.contact=contact;
    }
    public void setDob(String dob){
        this.dob=dob;
    }
    public void setBg(String bg){
        this.bg=bg;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public void setAdmin(String admin){
        this.admin=admin;
    }

    //getter methods
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getFullname(){
        return fullname;
    }
    public String getContact(){
        return contact;
    }
    public String getDob(){
        return dob;
    }
    public String getBg(){
        return bg;
    }
    public String getEmail(){
        return email;
    }
    public String getGender(){
        return gender;
    }
    public String getAdmin(){
        return admin;
    }
}