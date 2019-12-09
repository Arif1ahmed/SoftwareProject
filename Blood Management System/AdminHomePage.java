import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

class AdminHomePage extends JFrame implements ActionListener{
    JLabel headLabel = new JLabel("ADMIN HOME PAGE");
    JButton myProfileButton = new JButton("My Profile");
    JButton logOutButton = new JButton("Log out");
    JButton addRequest = new JButton("Add Request");
    JButton showRequests = new JButton("Show Requests");
    JButton removeRequest = new JButton("Remove Request");
    JButton removeUser = new JButton("Remove User");
    JButton removeAdmin = new JButton("Remove Admin");
    JButton addAdmin = new JButton("Add Admin");
    JPanel addRequestP = new JPanel();
    JPanel showRequestsP = new JPanel();
    JPanel removeRequestP = new JPanel();
    JPanel removeUserP = new JPanel();
    JPanel removeAdminP = new JPanel();
    JPanel addAdminP = new JPanel();
    boolean addReqFlag = true;
    boolean showReqFlag = true;
    boolean removeReqFlag = true;
    boolean removeUserFlag = true;
    boolean removeAdminFlag = true;
    boolean addAdminFlag = true;
    
    //Required components declaration
    String username;
    User user = new User();
    UserService us = new UserService();
    List<User> userList=new ArrayList<User>();
    Request req = new Request();
    RequestService rs = new RequestService();
    List<Request> reqList=new ArrayList<Request>();

    //Add Requests Panel components
    JLabel fullNamePl = new JLabel("Full Name");
    JLabel hospitalPl = new JLabel("Hospital");
    JLabel locationPl = new JLabel("Location");
    JLabel bgPl = new JLabel("Blood Group");
    JLabel bqPl = new JLabel("Blood Quantity");
    JLabel contactPl = new JLabel("Contact");
    JLabel datePl = new JLabel("Date");
    JTextField fullNamePt = new JTextField();
    JTextField hospitalPt = new JTextField();
    JTextField locationPt = new JTextField();
	JComboBox<String> group=new JComboBox<String>(new String[]{"--","A+","A-","B+","B-","AB+","AB-","O+","O-"});
    JComboBox<String> quantity=new JComboBox<String>(new String[]{"--","1","2","3","4"});
    JTextField contactPt = new JTextField();
    JComboBox<String> year=new JComboBox<String>(new String[]{"Year","1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960","1961","1962","1963","1964","1965","1966","1967","1968","1969","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010",});
    JComboBox<String> day=new JComboBox<String>(new String[]{"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"});
    JComboBox<String> month=new JComboBox<String>(new String[]{"Month","January","February","March","April","May","June","July","August","September","October","November","December"});
    JButton addPb = new JButton("Add");

    //Show Requests Panel components
    JLabel showId = new JLabel("ID");
    JLabel showFullname = new JLabel("Full Name");
    JLabel showHospital = new JLabel("Hospital");
    JLabel showLocation = new JLabel("Location");
    JLabel showBg = new JLabel("Blood Group");
    JLabel showBq = new JLabel("Blood Quantity");
    JLabel showContact = new JLabel("Contact");
    JLabel showDate = new JLabel("Date");
    JLabel showUsername = new JLabel("Username");
    JLabel showL = new JLabel("Access request by ID :");
    JTextField showT = new JTextField();
    JButton showB = new JButton("GO");

    //remove Requests Panel components
    JLabel removeId = new JLabel("ID");
    JLabel removeFullname = new JLabel("Full Name");
    JLabel removeHospital = new JLabel("Hospital");
    JLabel removeLocation = new JLabel("Location");
    JLabel removeBg = new JLabel("Blood Group");
    JLabel removeBq = new JLabel("Blood Quantity");
    JLabel removeContact = new JLabel("Contact");
    JLabel removeDate = new JLabel("Date");
    JLabel removeUsername = new JLabel("Username");
    JLabel removeL = new JLabel("Remove request by ID :");
    JTextField removeT = new JTextField();
    JButton removeB = new JButton("GO");

    //Remove User Panel Compnonents
    JLabel uRemoveFullname = new JLabel("Full Name");
    JLabel uRemoveBg = new JLabel("Blood Group");
    JLabel uRemoveUsername = new JLabel("Username");
    JLabel uRemoveAdmin = new JLabel("Admin");
    JLabel uRemoveL = new JLabel("Enter Username:");
    JTextField uRemoveT = new JTextField();
    JButton uRemoveB = new JButton("GO");

    //Add Admin Panel Compnonents
    JLabel aAdminFullname = new JLabel("Full Name");
    JLabel aAdminBg = new JLabel("Blood Group");
    JLabel aAdminUsername = new JLabel("Username");
    JLabel aAdminAdmin = new JLabel("Admin");
    JLabel aAdminL = new JLabel("Enter Username:");
    JTextField aAdminT = new JTextField();
    JButton aAdminB = new JButton("GO");

    //remove Admin Panel Compnonents
    JLabel rAdminFullname = new JLabel("Full Name");
    JLabel rAdminBg = new JLabel("Blood Group");
    JLabel rAdminUsername = new JLabel("Username");
    JLabel rAdminAdmin = new JLabel("Admin");
    JLabel rAdminL = new JLabel("Enter Username:");
    JTextField rAdminT = new JTextField();
    JButton rAdminB = new JButton("GO");
 



    public AdminHomePage(){}
    
    public AdminHomePage(String username){
        this.username=username;
        //Initialize Frame
        this.setSize(800,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Admin Home Page");
        this.setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);

        //Profile Button
        myProfileButton.setBounds(5, 5, 100, 20);
        this.add(myProfileButton);
        myProfileButton.addActionListener(this);

        //Heading label
        headLabel.setBounds(350,5, 150,20);
        this.add(headLabel);

        //Log Out Button
        logOutButton.setBounds(680,5,100,20);
        this.add(logOutButton);
        logOutButton.addActionListener(this);

        //Add Request Button
        addRequest.setBounds(40,500,130,20);
        this.add(addRequest);
        addRequest.addActionListener(this);

        //Show Requests Button
        showRequests.setBounds(200,500,130,20);
        this.add(showRequests);
        showRequests.addActionListener(this);

        //Remove Requests Button
        removeRequest.setBounds(370, 500, 130, 20);
        this.add(removeRequest);
        removeRequest.addActionListener(this);

        //Remove Users Button
        removeUser.setBounds(530, 500, 130, 20);
        this.add(removeUser);
        removeUser.addActionListener(this);

        //Add Admin Button
        addAdmin.setBounds(150, 530, 130, 20);
        this.add(addAdmin);
        addAdmin.addActionListener(this);

        //remove Admin Button
        removeAdmin.setBounds(450, 530, 130, 20);
        this.add(removeAdmin);
        removeAdmin.addActionListener(this);


        //Intialize add Request Panel
        addRequestP.setBounds(40,50,700,430);
        addRequestP.setBackground(Color.LIGHT_GRAY);
        addRequestP.setLayout(null);
        this.add(addRequestP);
        addRequestP.setVisible(false);

        //Intialize show Requests Panel
        showRequestsP.setBounds(40,50,700,430);
        showRequestsP.setBackground(Color.LIGHT_GRAY);
        showRequestsP.setLayout(null);
        this.add(showRequestsP);
        showRequestsP.setVisible(false);

        //Intialize remove Requests Panel
        removeRequestP.setBounds(40,50,700,430);
        removeRequestP.setBackground(Color.LIGHT_GRAY);
        removeRequestP.setLayout(null);
        this.add(removeRequestP);
        removeRequestP.setVisible(false);

        //Intialize remove user Panel
        removeUserP.setBounds(40,50,700,430);
        removeUserP.setBackground(Color.LIGHT_GRAY);
        removeUserP.setLayout(null);
        this.add(removeUserP);
        removeUserP.setVisible(false);

        //Intialize Add Admin Panel
        addAdminP.setBounds(40,50,700,430);
        addAdminP.setBackground(Color.LIGHT_GRAY);
        addAdminP.setLayout(null);
        this.add(addAdminP);
        addAdminP.setVisible(false);

        //Intialize remove Admin Panel
        removeAdminP.setBounds(40,50,700,430);
        removeAdminP.setBackground(Color.LIGHT_GRAY);
        removeAdminP.setLayout(null);
        this.add(removeAdminP);
        removeAdminP.setVisible(false);





    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==addRequest){
            addRequestP.setVisible(true);
            showRequestsP.setVisible(false);
            removeRequestP.setVisible(false);
            removeUserP.setVisible(false);
            addAdminP.setVisible(false);
            removeAdminP.setVisible(false);

            clearFields();
            
            if(addReqFlag){
                addReqFlag=false;
                //add Request Panel components
                fullNamePl.setBounds(200, 10, 70, 20);
                addRequestP.add(fullNamePl);
                fullNamePt.setBounds(350, 10, 150, 20);
                addRequestP.add(fullNamePt);
                hospitalPl.setBounds(200, 40, 70, 20);
                addRequestP.add(hospitalPl);
                hospitalPt.setBounds(350, 40, 150, 20);
                addRequestP.add(hospitalPt);
                locationPl.setBounds(200, 70, 70, 20);
                addRequestP.add(locationPl);
                locationPt.setBounds(350, 70, 150, 20);
                addRequestP.add(locationPt);
                bgPl.setBounds(200, 100, 70, 20);
                addRequestP.add(bgPl);
                group.setBounds(350, 100, 50, 20);
                addRequestP.add(group);
                bqPl.setBounds(200, 130, 100, 20);
                addRequestP.add(bqPl);
                quantity.setBounds(350, 130, 50, 20);
                addRequestP.add(quantity);
                contactPl.setBounds(200, 160, 70, 20);
                addRequestP.add(contactPl);
                contactPt.setBounds(350, 160, 150, 20);
                addRequestP.add(contactPt);
                datePl.setBounds(200, 190, 70, 20);
                addRequestP.add(datePl);
                year.setBounds(350, 190, 60, 20);
                month.setBounds(430, 190, 60, 20);
                day.setBounds(510, 190, 60, 20);
                addRequestP.add(day);
                addRequestP.add(month);
                addRequestP.add(year);
                addPb.setBounds(300, 300, 100, 30);
                addRequestP.add(addPb);
                addPb.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent g) {
                    if(fullNamePt.getText()=="" || hospitalPt.getText()=="" || locationPt.getText()== "" || String.valueOf(group.getSelectedItem())=="--" || String.valueOf(quantity.getSelectedItem())=="--" || (String)day.getSelectedItem()=="Day" || (String)month.getSelectedItem()=="Month" || (String)year.getSelectedItem()=="Year" || contactPt.getText()==""){
                        JOptionPane.showMessageDialog(addRequestP, "Information Incomplete", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
                    }
                    else{    
                        Request red = new Request();
                        RequestService res = new RequestService();
                        red.setFullname(fullNamePt.getText());
                        red.setHospital(hospitalPt.getText());
                        red.setLocation(locationPt.getText());
                        red.setBg((String)group.getSelectedItem());
                        red.setBq((String)quantity.getSelectedItem());
                        red.setContact(contactPt.getText());
                        String sDate = (String)day.getSelectedItem();
                        String sMonth = (String)month.getSelectedItem();
                        String sYear = (String)year.getSelectedItem();
                        String sDob = sDate+"-"+sMonth+"-"+sYear;
                        red.setDate(sDob);
                        red.setUsername(username);
                        if(res.addNewRequest(red)){
                            JOptionPane.showMessageDialog(addRequestP, "Request Added", "Notification", JOptionPane.INFORMATION_MESSAGE);
                            pageReset();
                        }
                    }
                }
                });
            }
        }
        else if(e.getSource()==showRequests){
            addRequestP.setVisible(false);
            showRequestsP.setVisible(true);
            removeRequestP.setVisible(false);
            removeUserP.setVisible(false);
            addAdminP.setVisible(false);
            removeAdminP.setVisible(false);
            if(showReqFlag){
                showReqFlag=false;
                //setting the headers
                showL.setBounds(350, 1, 150, 40);
                showT.setBounds(480, 10, 100, 20);
                showB.setBounds(600, 10, 80, 20);
                showId.setBounds(10, 40, 40, 20);
                showFullname.setBounds(40, 40, 100, 20);
                showLocation.setBounds(120, 40, 100, 20);
                showBg.setBounds(200, 40, 100, 20);
                showBq.setBounds(280, 40, 100, 20);
                showContact.setBounds(380, 40, 100, 20);
                showDate.setBounds(480, 40, 100, 20);
                showHospital.setBounds(550, 40, 100, 20);
                showUsername.setBounds(630, 40, 100, 20);

                showRequestsP.add(showL);
                showRequestsP.add(showT);
                showRequestsP.add(showB);
                showRequestsP.add(showId);
                showRequestsP.add(showFullname);
                showRequestsP.add(showLocation);
                showRequestsP.add(showBg);
                showRequestsP.add(showBq);
                showRequestsP.add(showContact);
                showRequestsP.add(showDate);
                showRequestsP.add(showHospital);
                showRequestsP.add(showUsername);

                showB.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent b){
                        RequestService rs=new RequestService();
                        if(showT.getText().equals("")){
                            JOptionPane.showMessageDialog(showRequestsP, "Enter the desired request id","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        else if(rs.getIdValidation(Integer.parseInt(showT.getText()))){
                            JOptionPane.showMessageDialog(showRequestsP, "ID does not exist","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            new RequestAndDonor(Integer.parseInt(showT.getText()),username);
                        }
                    }
                }); 


                reqList = rs.loadAllRequest();
                if(reqList!=null){
                    int y=50;
                    for (Request r:reqList){
                        JLabel id = new JLabel(String.valueOf(r.getId()));
                        JLabel fullname = new JLabel(r.getFullname());
                        JLabel location = new JLabel(r.getLocation());
                        JLabel bg = new JLabel(r.getBg());
                        JLabel bq = new JLabel(r.getBq());
                        JLabel contact = new JLabel(r.getContact());
                        JLabel date = new JLabel(r.getDate());
                        JLabel hospital = new JLabel(r.getHospital());
                        JLabel username = new JLabel(r.getUsername());
                        
                        y+=20;

                        id.setBounds(10, y+10, 40, 20);
                        fullname.setBounds(40, y+10, 100, 20);
                        location.setBounds(120, y+10, 100, 20);
                        bg.setBounds(220, y+10, 30, 20);
                        bq.setBounds(300, y+10, 30,20);
                        contact.setBounds(380, y+10, 50,20);
                        date.setBounds(450, y+10, 100,20);
                        hospital.setBounds(550, y+10, 50,20);
                        username.setBounds(630, y+10, 50,20);

                        showRequestsP.add(id);
                        showRequestsP.add(fullname);
                        showRequestsP.add(location);
                        showRequestsP.add(bg);
                        showRequestsP.add(bq);
                        showRequestsP.add(contact);
                        showRequestsP.add(date);
                        showRequestsP.add(hospital);
                        showRequestsP.add(username);
                        
                        

                        id=fullname=location=bg=bq=contact=date=username=null;

                    }
                    y=0;
                    reqList.clear();
                }
                else{
                    JOptionPane.showMessageDialog(showRequestsP, "Data not found","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else if(e.getSource()==removeRequest){
            addRequestP.setVisible(false);
            showRequestsP.setVisible(false);
            removeRequestP.setVisible(true);
            removeUserP.setVisible(false);
            addAdminP.setVisible(false);
            removeAdminP.setVisible(false);
            if(removeReqFlag){
                removeReqFlag=false;
                //setting the headers
                removeL.setBounds(350, 1, 150, 40);
                removeT.setBounds(480, 10, 100, 20);
                removeB.setBounds(600, 10, 80, 20);
                removeId.setBounds(10, 40, 40, 20);
                removeFullname.setBounds(40, 40, 100, 20);
                removeLocation.setBounds(120, 40, 100, 20);
                removeBg.setBounds(200, 40, 100, 20);
                removeBq.setBounds(280, 40, 100, 20);
                removeContact.setBounds(380, 40, 100, 20);
                removeDate.setBounds(480, 40, 100, 20);
                removeHospital.setBounds(550, 40, 100, 20);
                removeUsername.setBounds(630, 40, 100, 20);

                removeRequestP.add(removeL);
                removeRequestP.add(removeT);
                removeRequestP.add(removeB);
                removeRequestP.add(removeId);
                removeRequestP.add(removeFullname);
                removeRequestP.add(removeLocation);
                removeRequestP.add(removeBg);
                removeRequestP.add(removeBq);
                removeRequestP.add(removeContact);
                removeRequestP.add(removeDate);
                removeRequestP.add(removeHospital);
                removeRequestP.add(removeUsername);

                removeB.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent p){
                        RequestService rs=new RequestService();
                        if(removeT.getText().equals("")){
                            JOptionPane.showMessageDialog(removeRequestP, "Enter the desired id","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        else if(rs.getIdValidation(Integer.parseInt(removeT.getText()))){
                            JOptionPane.showMessageDialog(removeRequestP, "ID does not exist","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            if(rs.removeRequestById(Integer.parseInt(removeT.getText()))){
                                JOptionPane.showMessageDialog(removeRequestP, "Request Removed","Information",JOptionPane.INFORMATION_MESSAGE);
                                pageReset();

                            }
                        }
                    }
                }); 

                reqList = rs.loadAllRequest();
                if(reqList!=null){
                    int y=50;
                    for (Request r:reqList){
                        JLabel id = new JLabel(String.valueOf(r.getId()));
                        JLabel fullname = new JLabel(r.getFullname());
                        JLabel location = new JLabel(r.getLocation());
                        JLabel bg = new JLabel(r.getBg());
                        JLabel bq = new JLabel(r.getBq());
                        JLabel contact = new JLabel(r.getContact());
                        JLabel date = new JLabel(r.getDate());
                        JLabel hospital = new JLabel(r.getHospital());
                        JLabel username = new JLabel(r.getUsername());
                        
                        y+=20;

                        id.setBounds(10, y+10, 40, 20);
                        fullname.setBounds(40, y+10, 100, 20);
                        location.setBounds(120, y+10, 100, 20);
                        bg.setBounds(220, y+10, 30, 20);
                        bq.setBounds(300, y+10, 30,20);
                        contact.setBounds(380, y+10, 50,20);
                        date.setBounds(450, y+10, 100,20);
                        hospital.setBounds(550, y+10, 50,20);
                        username.setBounds(630, y+10, 50,20);

                        removeRequestP.add(id);
                        removeRequestP.add(fullname);
                        removeRequestP.add(location);
                        removeRequestP.add(bg);
                        removeRequestP.add(bq);
                        removeRequestP.add(contact);
                        removeRequestP.add(date);
                        removeRequestP.add(hospital);
                        removeRequestP.add(username);
                        
                        

                        id=fullname=location=bg=bq=contact=date=username=null;

                    }
                    y=0;
                    reqList.clear();
                }
                else{
                    JOptionPane.showMessageDialog(removeRequestP, "Data not found","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else if(e.getSource()==myProfileButton){
            Profile p = new Profile(username);
            p.setVisible(true);
            this.dispose();
        }
        else if(e.getSource()==logOutButton){
            Login log = new Login();
            log.setVisible(true);
            this.dispose();
        }
        else if(e.getSource()==removeUser){
            addRequestP.setVisible(false);
            showRequestsP.setVisible(false);
            removeRequestP.setVisible(false);
            removeUserP.setVisible(true);
            addAdminP.setVisible(false);
            removeAdminP.setVisible(false);
            if(removeUserFlag){
                removeUserFlag=false;
                //setting the headers
                uRemoveL.setBounds(350, 1, 150, 40);
                uRemoveT.setBounds(480, 10, 100, 20);
                uRemoveB.setBounds(600, 10, 80, 20);
                uRemoveFullname.setBounds(50, 40, 150, 20);
                uRemoveBg.setBounds(200, 40, 100, 20);
                uRemoveUsername.setBounds(350, 40, 100, 20);
                uRemoveAdmin.setBounds(500, 40, 100, 20);

                removeUserP.add(uRemoveL);
                removeUserP.add(uRemoveT);
                removeUserP.add(uRemoveB);
                removeUserP.add(uRemoveFullname);
                removeUserP.add(uRemoveBg);
                removeUserP.add(uRemoveUsername);
                removeUserP.add(uRemoveAdmin);

                uRemoveB.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent z){
                        UserService us=new UserService();
                        ForgotPassService fps = new ForgotPassService();
                        if(uRemoveT.getText().equals("")){
                            JOptionPane.showMessageDialog(removeUserP, "Enter the desired username","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        else if(!us.getUserValidation(uRemoveT.getText())){
                            JOptionPane.showMessageDialog(removeUserP, "username does not exist","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            if(us.removeUserByUsername(uRemoveT.getText()) && fps.removeForgotPass(uRemoveT.getText())){
                                JOptionPane.showMessageDialog(removeUserP, "User Removed","Information",JOptionPane.INFORMATION_MESSAGE);
                                pageReset();

                            }
                        }
                    }
                }); 

                userList = us.loadAllUser();
                if(userList!=null){
                    int y=50;
                    for (User u:userList){
                        JLabel fullname = new JLabel(u.getFullname());
                        JLabel bg = new JLabel(u.getBg());
                        JLabel username = new JLabel(u.getUsername());
                        JLabel admin = new JLabel(u.getAdmin());
                        
                        y+=20;

                        fullname.setBounds(50, y+10, 100, 20);
                        bg.setBounds(200, y+10, 30, 20);
                        username.setBounds(350, y+10, 50,20);
                        admin.setBounds(500, y+10, 50, 20);

                        removeUserP.add(fullname);
                        removeUserP.add(bg);
                        removeUserP.add(username);
                        removeUserP.add(admin);
                        
                        

                        fullname=bg=username=admin=null;

                    }
                    y=0;
                    userList.clear();
                }
                else{
                    JOptionPane.showMessageDialog(removeUserP, "Data not found","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else if(e.getSource()==addAdmin){
            addRequestP.setVisible(false);
            showRequestsP.setVisible(false);
            removeRequestP.setVisible(false);
            removeUserP.setVisible(false);
            addAdminP.setVisible(true);
            removeAdminP.setVisible(false);
            if(addAdminFlag){
                addAdminFlag=false;
                //setting the headers
                aAdminL.setBounds(350, 1, 150, 40);
                aAdminT.setBounds(480, 10, 100, 20);
                aAdminB.setBounds(600, 10, 80, 20);
                aAdminFullname.setBounds(50, 40, 150, 20);
                aAdminBg.setBounds(200, 40, 100, 20);
                aAdminUsername.setBounds(350, 40, 100, 20);
                aAdminAdmin.setBounds(500, 40, 100, 20);

                addAdminP.add(aAdminL);
                addAdminP.add(aAdminT);
                addAdminP.add(aAdminB);
                addAdminP.add(aAdminFullname);
                addAdminP.add(aAdminBg);
                addAdminP.add(aAdminUsername);
                addAdminP.add(aAdminAdmin);

                aAdminB.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent f){
                        UserService us=new UserService();
                        if(aAdminT.getText().equals("")){
                            JOptionPane.showMessageDialog(addAdminP, "Enter the desired username","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        else if(!us.getUserValidation(aAdminT.getText())){
                            JOptionPane.showMessageDialog(addAdminP, "username does not exist","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            if(us.addUserAsAdmin(aAdminT.getText())){
                                JOptionPane.showMessageDialog(addAdminP, "Admin Added","Information",JOptionPane.INFORMATION_MESSAGE);
                                pageReset();

                            }
                        }
                    }
                }); 

                userList = us.loadAllUser();
                if(userList!=null){
                    int y=50;
                    for (User u:userList){
                        JLabel fullname = new JLabel(u.getFullname());
                        JLabel bg = new JLabel(u.getBg());
                        JLabel username = new JLabel(u.getUsername());
                        JLabel admin = new JLabel(u.getAdmin());
                        
                        y+=20;

                        fullname.setBounds(50, y+10, 100, 20);
                        bg.setBounds(200, y+10, 30, 20);
                        username.setBounds(350, y+10, 50,20);
                        admin.setBounds(500, y+10, 50, 20);

                        addAdminP.add(fullname);
                        addAdminP.add(bg);
                        addAdminP.add(username);
                        addAdminP.add(admin);
                        
                        

                        fullname=bg=username=admin=null;

                    }
                    y=0;
                    userList.clear();
                }
                else{
                    JOptionPane.showMessageDialog(addAdminP, "Data not found","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else if(e.getSource()==removeAdmin){
            addRequestP.setVisible(false);
            showRequestsP.setVisible(false);
            removeRequestP.setVisible(false);
            removeUserP.setVisible(false);
            addAdminP.setVisible(false);
            removeAdminP.setVisible(true);
            if(removeAdminFlag){
                removeAdminFlag=false;
                //setting the headers
                rAdminL.setBounds(350, 1, 150, 40);
                rAdminT.setBounds(480, 10, 100, 20);
                rAdminB.setBounds(600, 10, 80, 20);
                rAdminFullname.setBounds(50, 40, 150, 20);
                rAdminBg.setBounds(200, 40, 100, 20);
                rAdminUsername.setBounds(350, 40, 100, 20);
                rAdminAdmin.setBounds(500, 40, 100, 20);

                removeAdminP.add(rAdminL);
                removeAdminP.add(rAdminT);
                removeAdminP.add(rAdminB);
                removeAdminP.add(rAdminFullname);
                removeAdminP.add(rAdminBg);
                removeAdminP.add(rAdminUsername);
                removeAdminP.add(rAdminAdmin);

                rAdminB.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent o){
                        UserService us=new UserService();
                        if(rAdminT.getText().equals("")){
                            JOptionPane.showMessageDialog(removeAdminP, "Enter the desired username","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        else if(!us.getUserValidation(rAdminT.getText())){
                            JOptionPane.showMessageDialog(removeAdminP, "username does not exist","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            if(us.removeUserAsAdmin(rAdminT.getText())){
                                JOptionPane.showMessageDialog(removeAdminP, "Admin Removed","Information",JOptionPane.INFORMATION_MESSAGE);
                                pageReset();

                            }
                        }
                    }
                }); 

                userList = us.loadAllUser();
                if(userList!=null){
                    int y=50;
                    for (User u:userList){
                        JLabel fullname = new JLabel(u.getFullname());
                        JLabel bg = new JLabel(u.getBg());
                        JLabel username = new JLabel(u.getUsername());
                        JLabel admin = new JLabel(u.getAdmin());
                        
                        y+=20;

                        fullname.setBounds(50, y+10, 100, 20);
                        bg.setBounds(200, y+10, 30, 20);
                        username.setBounds(350, y+10, 50,20);
                        admin.setBounds(500, y+10, 50, 20);

                        removeAdminP.add(fullname);
                        removeAdminP.add(bg);
                        removeAdminP.add(username);
                        removeAdminP.add(admin);
                        
                        

                        fullname=bg=username=admin=null;

                    }
                    y=0;
                    userList.clear();
                }
                else{
                    JOptionPane.showMessageDialog(removeAdminP, "Data not found","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void clearFields(){
        fullNamePt.setText("");
        hospitalPt.setText("");
        locationPt.setText("");
        group.setSelectedIndex(0);;
        quantity.setSelectedIndex(0);
        contactPt.setText("");
        year.setSelectedIndex(0);
		month.setSelectedIndex(0);
		day.setSelectedIndex(0);
    }
    
    public void pageReset(){
        AdminHomePage ahp = new AdminHomePage(username);
        ahp.setVisible(true);
        this.dispose();
    }
}