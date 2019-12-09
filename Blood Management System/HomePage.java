import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

class HomePage extends JFrame implements ActionListener{
    JLabel headLabel = new JLabel("HOME PAGE");
    JButton myProfileButton = new JButton("My Profile");
    JButton logOutButton = new JButton("Log out");
    JButton addRequest = new JButton("Add Request");
    JButton showRequests = new JButton("Show Requests");
    JPanel addRequestP = new JPanel();
    JPanel showRequestsP = new JPanel();
    boolean flag1 = true;
    boolean flag2 = true;
	

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

    String username;
    User user = new User();
    UserService us = new UserService();
    List<User> userList=new ArrayList<User>();
    Request req = new Request();
    RequestService rs = new RequestService();
    List<Request> reqList=new ArrayList<Request>();

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
    
    //Repeated label, text Field and Button
    JLabel theL = new JLabel("Access request by ID :");
    JTextField theT = new JTextField();
    JButton theB = new JButton("GO");



    public HomePage(){}
    
    public HomePage(String username){
        this.username=username;
        //Initialize Frame
        this.setSize(800,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Home Page");
        this.setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);

        //Profile Button
        myProfileButton.setBounds(5, 5, 100, 20);
        this.add(myProfileButton);
        myProfileButton.addActionListener(this);

        //Heading label
        headLabel.setBounds(350,5, 70,20);
        this.add(headLabel);

        //Log Out Button
        logOutButton.setBounds(680,5,100,20);
        this.add(logOutButton);
        logOutButton.addActionListener(this);

        //Add Request Button
        addRequest.setBounds(40,500,150,20);
        this.add(addRequest);
        addRequest.addActionListener(this);

        //Show Requests Button
        showRequests.setBounds(200,500,150,20);
        this.add(showRequests);
        showRequests.addActionListener(this);

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




    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==addRequest){
            addRequestP.setVisible(true);
            showRequestsP.setVisible(false);
            clearFields();
            
            if(flag1){
                flag1=false;
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
            if(flag2){
                flag2=false;
                //setting the headers
                theL.setBounds(350, 1, 150, 40);
                theT.setBounds(480, 10, 100, 20);
                theB.setBounds(600, 10, 80, 20);
                showId.setBounds(10, 40, 40, 20);
                showFullname.setBounds(40, 40, 100, 20);
                showLocation.setBounds(120, 40, 100, 20);
                showBg.setBounds(200, 40, 100, 20);
                showBq.setBounds(280, 40, 100, 20);
                showContact.setBounds(380, 40, 100, 20);
                showDate.setBounds(480, 40, 100, 20);
                showHospital.setBounds(550, 40, 100, 20);
                showUsername.setBounds(630, 40, 100, 20);

                showRequestsP.add(theL);
                showRequestsP.add(theT);
                showRequestsP.add(theB);
                showRequestsP.add(showId);
                showRequestsP.add(showFullname);
                showRequestsP.add(showLocation);
                showRequestsP.add(showBg);
                showRequestsP.add(showBq);
                showRequestsP.add(showContact);
                showRequestsP.add(showDate);
                showRequestsP.add(showHospital);
                showRequestsP.add(showUsername);

                theB.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent b){
                        RequestService rs=new RequestService();
                        if(theT.getText().equals("")){
                            JOptionPane.showMessageDialog(showRequestsP, "Enter the desired request id","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        else if(rs.getIdValidation(Integer.parseInt(theT.getText()))){
                            JOptionPane.showMessageDialog(showRequestsP, "ID does not exist","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            new RequestAndDonor(Integer.parseInt(theT.getText()),username);
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