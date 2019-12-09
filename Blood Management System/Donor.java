public class Donor{
    String fullname,bg,contact;
    int id;
    public Donor(){}
    //setter methods
    public void setFullname(String fullname){
        this.fullname=fullname;
    }
    public void setBg(String bg){
        this.bg=bg;
    }
    public void setContact(String contact){
        this.contact=contact;
    }
    public void setId(int id){
        this.id=id;
    }
    //getter methods
    public String getFullname(){
        return fullname;
    }
    public String getBg(){
        return bg;
    }
    public String getContact(){
        return contact;
    }
    public int getId(){
        return id;
    }
}