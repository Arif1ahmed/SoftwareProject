import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;


class RequestAndDonor extends JFrame implements ActionListener{
    JButton beADonor = new JButton("Be A Donor");
    JLabel header = new JLabel("Request");
    JLabel header2 = new JLabel("Donors");
    JLabel test = new JLabel();
    DonorService ds = new DonorService();
    Donor don = new Donor();
    List<Donor> donList = new ArrayList<Donor>();
    String username;
    UserService us = new UserService();
    User user = new User();
    int id;
    Request req = new Request();
    RequestService rs = new RequestService();

    //Requests labels
    JLabel hId = new JLabel("ID");
    JLabel dId = new JLabel();
    JLabel hFullname = new JLabel("Full Name");
    JLabel dFullname = new JLabel();
    JLabel hHospital = new JLabel("Hospital");
    JLabel dHospital = new JLabel();
    JLabel hLocation = new JLabel("Location");
    JLabel dLocation = new JLabel();
    JLabel hBg = new JLabel("Blood Group");
    JLabel dBg = new JLabel();
    JLabel hBq = new JLabel("Blood Quantity");
    JLabel dBq = new JLabel();
    JLabel hContact = new JLabel("Contact");
    JLabel dContact = new JLabel();
    JLabel hDate = new JLabel("Date");
    JLabel dDate = new JLabel();
    JLabel hUsername = new JLabel("Username");
    JLabel dUsername = new JLabel();

    //Donor Labels
    JLabel hdId = new JLabel("ID");
    JLabel hdFullname = new JLabel("Full Name");
    JLabel hdBg = new JLabel("Blood Group");
    JLabel hdContact = new JLabel("Contact");
    

    
    public RequestAndDonor(int id, String username){
        this.username=username;
        this.id=id;
        
        this.setSize(900,700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Donors");
        this.setLayout(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        header.setBounds(350, 5, 100, 30);
        header.setFont(new Font("Serif", Font.BOLD, 20));
        this.add(header);
        header2.setBounds(350, 160, 100, 30);
        header2.setFont(new Font("Serif", Font.BOLD, 20));
        this.add(header2);


        beADonor.setBounds(720, 10, 100, 20);
        this.add(beADonor);
        beADonor.addActionListener(this);
        
        //Request Display
        hId.setBounds(10, 40, 40, 20);
        hFullname.setBounds(40, 40, 100, 20);
        hLocation.setBounds(150, 40, 100, 20);
        hBg.setBounds(220, 40, 100, 20);
        hBq.setBounds(320, 40, 100, 20);
        hContact.setBounds(420, 40, 100, 20);
		hHospital.setBounds(550, 40, 100, 20);
        hDate.setBounds(680, 40, 100, 20);
        hUsername.setBounds(780, 40, 100, 20);

        this.add(hId);
        this.add(hFullname);
        this.add(hHospital);
        this.add(hLocation);
        this.add(hBg);
        this.add(hBq);
        this.add(hContact);
        this.add(hDate);
        this.add(hUsername);

        dId.setBounds(10, 100, 20, 20);
        dFullname.setBounds(40, 100, 100, 20);
        dLocation.setBounds(150, 100, 100, 20);
        dBg.setBounds(230, 100, 20, 20);
        dBq.setBounds(330, 100, 20, 20);
        dContact.setBounds(420, 100, 100, 20);
		dHospital.setBounds(550, 100, 100, 20);
        dDate.setBounds(650, 100, 100, 20);
        dUsername.setBounds(780, 100, 100, 20);

        req = rs.getRequestById(id);

        dId.setText(String.valueOf(req.getId()));
        dFullname.setText(req.getFullname());
        dHospital.setText(req.getHospital());
        dLocation.setText(req.getLocation());
        dBg.setText(req.getBg());
        dBq.setText(req.getBq());
        dContact.setText(req.getContact());
        dDate.setText(req.getDate());
        dUsername.setText(req.getUsername());

        this.add(dId);
        this.add(dFullname);
        this.add(dHospital);
        this.add(dLocation);
        this.add(dBg);
        this.add(dBq);
        this.add(dContact);
        this.add(dDate);
        this.add(dUsername);

        hdId.setBounds(100, 200, 100, 20);
        hdFullname.setBounds(250, 200, 100, 20);
        hdBg.setBounds(400, 200, 100, 20);
        hdContact.setBounds(550, 200, 100, 20);

        this.add(hdId);
        this.add(hdFullname);
        this.add(hdBg);
        this.add(hdContact);

        donList = ds.loadAllDonorsById(id);
        if(donList!=null){
            int y=50;
            for (Donor d:donList){
                JLabel ddId = new JLabel(String.valueOf(d.getId()));
                JLabel ddFullname = new JLabel(d.getFullname());
                JLabel ddBg = new JLabel(d.getBg());
                JLabel ddContact = new JLabel(d.getContact());
				
				y+=20;	
				
                ddId.setBounds(100, y+200, 20, 20);
                ddFullname.setBounds(250, y+200, 100, 20);
                ddBg.setBounds(400, y+200, 50, 20);
                ddContact.setBounds(550, y+200, 100, 20);

                this.add(ddId);
                this.add(ddFullname);
                this.add(ddBg);
                this.add(ddContact);

                ddId=ddFullname=ddBg=ddContact=null;

            }
            y=0;
            donList.clear();
        }
        // else{
        //     JOptionPane.showMessageDialog(showRequestsP, "Data not found","Error",JOptionPane.ERROR_MESSAGE);
        // }


    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==beADonor){    
            user=us.getUserByUsername(username);
            don=new Donor();
            don.setId(id);
            don.setBg(user.getBg());
            don.setFullname(user.getFullname());
            don.setContact(user.getContact());
            if(ds.addNewDonor(don)){
                JOptionPane.showMessageDialog(this, "Donor Registered.", "Notification", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        }
    }
}