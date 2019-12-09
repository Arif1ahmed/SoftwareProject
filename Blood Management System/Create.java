import javax.swing. * ;
import javax.swing.text.DefaultStyledDocument.ElementSpec;

import java.awt. * ;
import java.awt.event. * ;
  
class Create extends JFrame implements ActionListener{

	JLabel lb_uname = new JLabel();
	JLabel lb_pass = new JLabel();
	JLabel lb_conPass = new JLabel();
	JLabel lb_bgroup = new JLabel();
	JLabel label5 = new JLabel();
	JLabel lb_dob = new JLabel();
	JLabel lb_secQues = new JLabel();
	JLabel lb_eid = new JLabel();
	JLabel label9 = new JLabel();
	JLabel lb_header= new JLabel();
	JLabel lb_fname= new JLabel();
	JLabel lb_ansQ= new JLabel();
	JLabel lb_gend= new JLabel();
	JLabel lb_contact= new JLabel();
	JLabel error = new JLabel("");

	
	JTextField tx_uname = new JTextField(15);
	JPasswordField tx_pass = new JPasswordField(15);
	JPasswordField tx_cont = new JPasswordField(15);
	JTextField tx_fname = new JTextField(15);
	JTextField tx_ansQ = new JTextField(15);
	JTextField tx_eid = new JTextField(15);
	JTextField tx_contact = new JTextField(15);
   
    JButton submit = new JButton("Submit");
    JButton cancel = new JButton("Cancel");
 
    JComboBox<String> group=new JComboBox<String>(new String[]{"--","A+","A-","B+","B-","AB+","AB-","O+","O-"});
    JComboBox<String> year=new JComboBox<String>(new String[]{"Year","1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960","1961","1962","1963","1964","1965","1966","1967","1968","1969","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010",});
    JComboBox<String> day=new JComboBox<String>(new String[]{"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"});
    JComboBox<String> month=new JComboBox<String>(new String[]{"Month","January","February","March","April","May","June","July","August","September","October","November","December"});
    JComboBox<String> question=new JComboBox<String>(new String[]{"Choose a Security Question","What was your childhood nickname?","What is the name of your best friend?","What is the name of your favourite teacher?","What school did you attend for sixth grade?","In what city were you born?","What is your home town?"});
    
    JRadioButton jrb1=new JRadioButton("Male");
    JRadioButton jrb2=new JRadioButton("Female");
    ButtonGroup bgr=new ButtonGroup();
 
 
    public Create(){

		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Create Your New Account Here");
		this.setSize(900, 800);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
  
     	lb_uname.setText("Username : ");
		lb_pass.setText("Password : "); 
		lb_conPass.setText("Confirm Password : ");
		lb_bgroup.setText("Blood Group : ");
		lb_dob.setText("Date of Birth : ");
		lb_secQues.setText("Security Question : ");
		lb_eid.setText("Email id : ");
		lb_header.setText("Create Account");
		lb_header.setFont(new Font("Serif", Font.BOLD, 35));
		lb_fname.setText("Full Name : ");
		lb_ansQ.setText("Answer Question : ");
		lb_gend.setText("Gender : ");
		lb_contact.setText("Contact : ");
	
		lb_header.setBounds(380, 5, 250, 90);
		lb_fname.setBounds(308, 100, 90, 30);
		lb_uname.setBounds(308, 150, 90, 30);
		lb_pass.setBounds(308, 200, 90, 30);
		lb_conPass.setBounds(250, 250, 150, 30);
		lb_bgroup.setBounds(300, 300, 90, 30);
		lb_dob.setBounds(300, 350, 90, 30);
		lb_secQues.setBounds(265, 450, 120, 30);
		lb_eid.setBounds(325, 550, 90, 30);
		lb_ansQ.setBounds(270, 500, 110, 30);
		lb_gend.setBounds(308, 400, 90, 30);
		lb_contact.setBounds(308, 600, 90, 30);
		error.setBounds(320, 700, 100, 20);
		
		submit.setBounds(500, 650, 100, 30);
		cancel.setBounds(320, 650, 100, 30);
	  
	
		tx_uname.setBounds(400, 150, 200, 30);
		tx_pass.setBounds(400, 200, 200, 30);
		tx_cont.setBounds(400, 250, 200, 30);
		tx_eid.setBounds(400, 550, 200, 30);
		tx_fname.setBounds(400, 100, 200, 30);
		tx_ansQ.setBounds(400, 500, 275, 30);
		tx_contact.setBounds(400, 600, 150, 30);
		
		group.setBounds(480, 304, 50, 25);
		year.setBounds(400,350, 60, 30);
		month.setBounds(470, 350, 60, 30);
		day.setBounds(540, 350, 60, 30);
		question.setBounds(400, 450, 275, 30);

		jrb1.setBounds(400,400,100,30);
        jrb2.setBounds(500,400,100,30);
	  
		
        this.add(lb_fname);
		this.add(lb_uname);
		this.add(lb_conPass);
		this.add(lb_bgroup);
		this.add(lb_dob);
		this.add(lb_gend);
		this.add(lb_pass);
		this.add(lb_secQues);
		this.add(lb_ansQ);
		this.add(lb_eid);
		this.add(lb_header);
		this.add(lb_contact);
		this.add(error);


		this.add(tx_uname);
		this.add(tx_pass);
		this.add(tx_cont);
		this.add(tx_eid);
		this.add(tx_fname);
		this.add(tx_ansQ);
		this.add(tx_contact);
		
		submit.addActionListener(this);
		this.add(submit);
		cancel.addActionListener(this);
		this.add(cancel);
		
		this.add(group);
		this.add(month);
		this.add(day);
		this.add(year);
		this.add(question);

		year.addActionListener(this);
		month.addActionListener(this);
		day.addActionListener(this);

		this.add(jrb1);
        this.add(jrb2);
		
		bgr.add(jrb1);
		bgr.add(jrb2);
		
	}
    public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit){
			if(emptyCheck()){
				JOptionPane.showMessageDialog(this, "Incomplete Information", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else if(passCheck()){
				JOptionPane.showMessageDialog(this, "Passwords Don't Match", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else if(usernameCheck()){
				JOptionPane.showMessageDialog(this, "Username Has Already Been Taken", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else{
				UserService us=new UserService();
				ForgotPassService fps=new ForgotPassService();
				String sDate,sMonth,sYear,sDob;
				sDate = (String)day.getSelectedItem();
				sMonth = (String)month.getSelectedItem();
				sYear = (String)year.getSelectedItem();
				sDob = sDate+"-"+sMonth+"-"+sYear;
				String bgGender="";
				if(jrb1.isSelected()==true){
					bgGender="Male";
				}
				else if(jrb2.isSelected()==true){
					bgGender="Female";
				}
				String bloodGroup = String.valueOf(group.getSelectedItem());
				User user=new User(new String[]{tx_fname.getText(),tx_uname.getText(),tx_pass.getText(),tx_contact.getText(),bloodGroup,sDob,bgGender,tx_eid.getText(),"no"});
				ForgotPass fp = new ForgotPass();
				fp.setUsername(tx_uname.getText());
				fp.setQsn((String)question.getSelectedItem());
				fp.setAns(tx_ansQ.getText());
				if(us.addNewUser(user) && fps.addForgotPass(fp)){
					JOptionPane.showMessageDialog(this, "User Registered.", "Notification", JOptionPane.INFORMATION_MESSAGE);
					Login lo = new Login();
					lo.setVisible(true);
					this.dispose();
				}
			}
		}
		else if (e.getSource()== cancel){
			Login l = new Login();
			l.setVisible(true);
			this.dispose();
		}
	}

	public boolean emptyCheck(){
		if(tx_fname.getText()=="" || tx_uname.getText()=="" || tx_pass.getText()== "" || tx_cont.getText()=="" || String.valueOf(group.getSelectedItem())=="--" || (String)day.getSelectedItem()=="Day" || (String)month.getSelectedItem()=="Month" || (String)year.getSelectedItem()=="Year" ||  jrb1.isSelected()==false && jrb2.isSelected()==false || (String)question.getSelectedItem()=="Choose a Security Question" || tx_ansQ.getText()=="" || tx_eid.getText()=="" || tx_contact.getText()==""){
			return true;
		}
		else
			return false;
	}
	public boolean passCheck(){
		if(tx_pass.getText().equals(tx_cont.getText())){
			return false;
		}
		else{
			return true;
		}
	}
	public boolean usernameCheck(){
		CreateService cs = new CreateService();
		if(cs.checkUsername(tx_uname.getText())){
			return true;
		}
		else
			return false;
	}
}