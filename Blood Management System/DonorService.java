import java.util.*;

public class DonorService{

    Donor don;
    List<Donor> donList=new ArrayList<Donor>();
    DonorRepository drp=new DonorRepository();
    
    public boolean addNewDonor(Donor don){
        return drp.insertDonorToDb(don);
    }

    public List<Donor> loadAllDonorsById(int id){
        donList = drp.getDonorsById(id);
        return donList;
    }
}