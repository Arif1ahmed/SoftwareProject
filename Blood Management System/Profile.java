
import javax.swing. * ;
import java.awt. * ;
import java.awt.event. * ;
  
class Profile extends JFrame implements ActionListener{

	JLabel username = new JLabel();
	JLabel contact = new JLabel();
	JLabel bg = new JLabel();
	JLabel dob = new JLabel();
	JLabel eid = new JLabel();
	JLabel myAcc = new JLabel();
	JLabel fullName= new JLabel();
	JLabel gender= new JLabel();
	
	//output label
	JLabel ousername = new JLabel();
	JLabel ocontact = new JLabel();
	JLabel obg = new JLabel();
	JLabel odob = new JLabel();
	JLabel oeid = new JLabel();
	JLabel ofullName= new JLabel();
	JLabel ogender= new JLabel();

	
    JButton home = new JButton("Home");
	JButton logout = new JButton("Logout");
	JButton edit = new JButton("Edit Profile");

	String xusername;
	User user = new User();
	UserService us = new UserService();

	public Profile(){}
    public Profile(String xusername){
		this.xusername=xusername;
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("My Account");
		this.setSize(900, 800);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		
		myAcc.setText("My Account");
		myAcc.setFont(new Font("Serif", Font.BOLD, 35));
  
     	username.setText("Username : ");
		contact.setText("Contact : ");
		//bg.setText("Blood Group : ");
		dob.setText("Date of Birth : ");
		eid.setText("Email id : ");
		fullName.setText("Full Name : ");
		gender.setText("Gender : ");
	
		myAcc.setBounds(380, 5, 250, 90);
		fullName.setBounds(100, 100, 90, 30);
		username.setBounds(100, 150, 90, 30);
		contact.setBounds(100, 200, 90, 30);
		bg.setBounds(100, 250, 90, 30);
		dob.setBounds(100, 300, 90, 30);
		eid.setBounds(100, 350, 90, 30);
		gender.setBounds(100, 400, 90, 30);
		
		//output label
		ofullName.setBounds(200, 100, 90, 30);
		ousername.setBounds(200, 150, 90, 30);
		ocontact.setBounds(200, 200, 90, 30);
		obg.setBounds(200, 250, 90, 30);
		odob.setBounds(200, 300, 90, 30);
		oeid.setBounds(200, 350, 150, 30);
		ogender.setBounds(200, 400, 90, 30);
		
        this.add(username);
		this.add(contact);
		this.add(bg);
		this.add(dob);
		this.add(eid);
		this.add(myAcc);
		this.add(fullName);
		this.add(gender);

		user = us.getUserByUsername(xusername);

		ofullName.setText(user.getFullname());
		ocontact.setText(user.getContact());
		ousername.setText(user.getUsername());
		obg.setText(user.getBg());
		oeid.setText(user.getEmail());
		ogender.setText(user.getGender());
		odob.setText(user.getGender());

	
	//output
		this.add(ousername);
		this.add(ocontact);
		this.add(obg);
		this.add(odob);
		this.add(oeid);
		this.add(ofullName);
		this.add(ogender);

		home.setBounds(700, 650, 150, 30);
		logout.setBounds(700, 600, 150, 30);
		edit.setBounds(700, 700, 150, 30);



		home.addActionListener(this);
		this.add(home);

		logout.addActionListener(this);
		this.add(logout);
		
		edit.addActionListener(this);
		this.add(edit);
		
		
		

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == home){
			User u = new User();
				UserService us = new UserService();
				u = us.getUserByUsername(xusername);
				if(u.getAdmin().equals("yes")){
					new AdminHomePage(xusername);
					this.dispose();
				}
				else{
					new HomePage(xusername);
					this.dispose();
				}
		}

		else if (e.getSource() == logout){
			Login l = new Login();
			l.setVisible(true);
			this.dispose();
		}
		
		else if(e.getSource() == edit){
			EditProfile ep = new EditProfile(xusername);
			ep.setVisible(true);
			this.dispose();
		}
		
	}
	
}
		
		
		