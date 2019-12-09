public class Request{
    //id	fullname	hospital	location	bg	bq	contact	date	username
    int id;
    String fullname,hospital,location,bg,bq,contact,date,username;

    public Request(){}
    
    //setter methods
    public void setId(int id){
        this.id=id;
    }
    public void setFullname(String fullname){
        this.fullname=fullname;
    }
    public void setHospital(String hospital){
        this.hospital=hospital;
    }
    public void setLocation(String location){
        this.location=location;
    }
    public void setBg(String bg){
        this.bg=bg;
    }
    public void setBq(String bq){
        this.bq=bq;
    }
    public void setContact(String contact){
        this.contact=contact;
    }
    public void setDate(String date){
        this.date=date;
    }
    public void setUsername(String username){
        this.username=username;
    }

    //getter methods
    public int getId(){
        return id;
    }
    public String getFullname(){
        return fullname;
    }
    public String getHospital(){
        return hospital;
    }
    public String getLocation(){
        return location;
    }
    public String getBg(){
        return bg;
    }
    public String getBq(){
        return bq;
    }
    public String getContact(){
        return contact;
    }
    public String getDate(){
        return date;
    }
    public String getUsername(){
        return username;
    }

}