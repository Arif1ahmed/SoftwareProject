import java.util.*;

public class RequestService{

    Request req;
    List<Request> reqList=new ArrayList<Request>();
    RequestRepository rrp=new RequestRepository();
    
    public boolean addNewRequest(Request req){
        return rrp.insertRequestToDb(req);
    }
    // public boolean editUser(User user){
    //     return urp.updateToDb(user);
    // }
    public boolean removeRequestById(int id){
        return rrp.removeFromDb(id);
    }

    public Request getRequestById(int id){
        req = rrp.getRequestFromDb(id);
        return req;
    }
    public List<Request> loadAllRequest(){
        reqList = rrp.getAllRequest();
        return reqList;
    }
    public boolean getIdValidation(int id){
        return rrp.requestValidation(id);
    }


}