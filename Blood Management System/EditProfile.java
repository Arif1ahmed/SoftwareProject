
import javax.swing. * ;
import java.awt. * ;
import java.awt.event. * ;
  
class EditProfile extends JFrame implements ActionListener{

	JLabel contact = new JLabel();
	JLabel bg = new JLabel();
	JLabel dob = new JLabel();
	JLabel eid = new JLabel();
	JLabel myAcc = new JLabel();
	JLabel fullName= new JLabel();
	JLabel gender= new JLabel();
	
	//output 
	JTextField ocontact = new JTextField();
	JTextField oeid = new JTextField();
	JTextField ofullName= new JTextField();
	JTextField ogender= new JTextField();
	

    JButton submit = new JButton("Submit");
	JButton cancel = new JButton("Cancel");
	
	String[] sGroup = new String[]{"--","A+","A-","B+","B-","AB+","AB-","O+","O-"};
	String[] sYear = new String[]{"Year","1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960","1961","1962","1963","1964","1965","1966","1967","1968","1969","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010"};
	String[] sDay = new String[]{"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String[] sMonth = new String[]{"Month","January","February","March","April","May","June","July","August","September","October","November","December"};

    JComboBox<String> group=new JComboBox<String>(sGroup);
    JComboBox<String> year=new JComboBox<String>(sYear);
    JComboBox<String> day=new JComboBox<String>(sDay);
    JComboBox<String> month=new JComboBox<String>(sMonth);
     
    JRadioButton jrb1=new JRadioButton("Male");
    JRadioButton jrb2=new JRadioButton("Female");
    ButtonGroup bgr=new ButtonGroup();
 
    String xusername;
	User user = new User();
	UserService us = new UserService();
	public EditProfile(){}

    public EditProfile(String xusername){
		this.xusername=xusername;
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("Edit Your Info Here");
		this.setSize(900, 800);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
  
     	
		contact.setText("Contact : ");
		bg.setText("Blood Group : ");
		dob.setText("Date of Birth : ");
		eid.setText("Email id : ");
		fullName.setText("Full Name : ");
		gender.setText("Gender : ");
	
		myAcc.setBounds(380, 5, 250, 90);
		fullName.setBounds(100, 150, 90, 30);
		contact.setBounds(100, 200, 90, 30);
		bg.setBounds(100, 250, 90, 30);
		dob.setBounds(100, 300, 90, 30);
		eid.setBounds(100, 350, 90, 30);
		gender.setBounds(100, 400, 90, 30);
		
		submit.setBounds(500, 650, 100, 30);
		cancel.setBounds(320, 650, 100, 30);
	  
	
		ofullName.setBounds(200, 150, 90, 30);
		ocontact.setBounds(200, 200, 90, 30);
		group.setBounds(200, 250, 90, 30);
		year.setBounds(200, 300, 60, 30);
		month.setBounds(270, 300, 60, 30);
		day.setBounds(340, 300, 60, 30);
		oeid.setBounds(200, 350, 150, 30);
		jrb1.setBounds(200, 400, 100, 30);
		jrb2.setBounds(300, 400, 100, 30);
		 
      
		this.add(contact);
		this.add(bg);
		this.add(dob);
		this.add(eid);
		this.add(myAcc);
		this.add(fullName);
		this.add(gender);


		//output
		this.add(ocontact);
		this.add(oeid);
		this.add(ofullName);
		this.add(ogender);
		this.add(group);
		
		submit.addActionListener(this);
		this.add(submit);
		cancel.addActionListener(this);
		this.add(cancel);
		
		this.add(group);
		this.add(month);
		this.add(day);
		this.add(year);
	
		year.addActionListener(this);
		month.addActionListener(this);
		day.addActionListener(this);

		this.add(jrb1);
		jrb1.addActionListener(this);
		this.add(jrb2);
		jrb2.addActionListener(this);
		
		bgr.add(jrb1);
		bgr.add(jrb2);

		//INITIALIZING THE FIELDS
		user = us.getUserByUsername(xusername);
		ofullName.setText(user.getFullname());
		ocontact.setText(user.getContact());
		String sG = user.getBg();
		int counter=0;
		int flag=0;
		for(String s:sGroup){
			if(s.equals(sG)){
				flag=counter;
			}
			counter++;
		}
		group.setSelectedIndex(flag);
		String sDob = user.getDob();
		int flag1,flag2,flag3,flag4;
		flag1=flag2=flag3=flag4=0;
		for(int i=0;i!=sDob.length();i++){
			if(sDob.charAt(i)=='-'){
				flag1=i;
				break;
			}
		}
		for(int i=flag1+1;i!=sDob.length();i++){
			if(sDob.charAt(i)=='-'){
				flag2=i;
				break;
			}
		}
		String fYear= sDob.substring(flag2+1, sDob.length());
		String fMonth = sDob.substring(flag1+1, flag2);
		String fDay = sDob.substring(0, flag1);
		int counter1,counter2,counter3,counter4,counter5,counter6;
		counter1=counter2=counter3=counter4=counter5=counter6=0;
		counter=0;
		for(String s:sYear){
			if(s.equals(fYear)){
				counter1=counter;
			}
			counter++;
		}
		year.setSelectedIndex(counter1);
		counter=0;
		for(String s:sMonth){
			if(s.equals(fMonth)){
				counter2=counter;
			}
			counter++;
		}
		month.setSelectedIndex(counter2);
		counter=0;
		for(String s:sDay){
			if(s.equals(fDay)){
				counter3=counter;
			}
			counter++;
		}
		day.setSelectedIndex(counter3);
		oeid.setText(user.getEmail());
		String sGender = user.getGender();
		if(sGender.equals("Male")){
			jrb1.setSelected(true);
		}
		else{
			jrb2.setSelected(true);
		}




		
	}
   public void actionPerformed(ActionEvent e) {
			if (e.getSource() == submit){
				if(emptyCheck()){
					JOptionPane.showMessageDialog(this, "Please enter all the fields", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else{
					user.setFullname(ofullName.getText());
					user.setContact(ocontact.getText());
					String sGroup = (String)group.getSelectedItem();
					user.setBg(sGroup);
					String sDate,sMonth,sYear,sDob;
					sDate = (String)day.getSelectedItem();
					sMonth = (String)month.getSelectedItem();
					sYear = (String)year.getSelectedItem();
					sDob = sDate+"-"+sMonth+"-"+sYear;
					user.setDob(sDob);
					user.setEmail(oeid.getText());
					String bgGender="";
					if(jrb1.isSelected()==true){
						bgGender="Male";
					}
					else if(jrb2.isSelected()==true){
						bgGender="Female";
					}
					user.setGender(bgGender);
					if(us.editUser(user)){
						JOptionPane.showMessageDialog(this, "User Updated.", "Notification", JOptionPane.INFORMATION_MESSAGE);
					}
					Profile pr = new Profile(xusername);
					pr.setVisible(true);
					this.dispose();
				}
				
			}
			else if (e.getSource()== cancel){
				Profile pro =new Profile(xusername);
				pro.setVisible(true);
				this.dispose();
			}
	}
	public boolean emptyCheck(){
		if(ofullName.getText()=="" ||  String.valueOf(group.getSelectedItem())=="--" || (String)day.getSelectedItem()=="Day" || (String)month.getSelectedItem()=="Month" || (String)year.getSelectedItem()=="Year" ||  jrb1.isSelected()==false && jrb2.isSelected()==false || oeid.getText()=="" || ocontact.getText()==""){
			return true;
		}
		else
			return false;
		public static void main(String[] arg){
		Login frame=new Login();
			 
	}
	}	 
}