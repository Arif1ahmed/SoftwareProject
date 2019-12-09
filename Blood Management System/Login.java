import javax.swing. * ;
import java.awt. * ;
import java.awt.event.*;

class Login extends JFrame implements ActionListener {
	
	JLabel imgLabel;
	ImageIcon img;
	boolean clicked = false;

	JTextField tx_uname = new JTextField(15);
	JTextField tx_pass = new JPasswordField(15);

	JLabel lb_uname = new JLabel();
	JLabel lb_pass = new JLabel();
	JLabel lb_acc = new JLabel();
	JLabel lb_header = new JLabel();
	JLabel lb_subHeader = new JLabel();


	JButton login = new JButton("Login   ");
	JButton create = new JButton("Create New Account    ");
	JButton forgot = new JButton("Forgot password        ");
	public Login() {

		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Login Page");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lb_uname.setText("Username:");
		lb_pass.setText("Password:");
		lb_acc.setText("Don't have any account?");
		lb_header.setText("Blood Bank Community");
		lb_header.setFont(new Font("Serif", Font.BOLD, 30));
		lb_header.setForeground(Color.RED);
		lb_subHeader.setText(" AIUB");
		lb_subHeader.setFont(new Font("Serif", Font.BOLD, 75));

		lb_uname.setBounds(200, 250, 90, 30);
		lb_pass.setBounds(200, 300, 90, 30);
		lb_acc.setBounds(200, 400, 150, 30);
		lb_header.setBounds(300, 125, 400, 150);
		lb_subHeader.setBounds(350, 1, 400, 300);

		tx_uname.setBounds(300, 250, 200, 30);
		tx_pass.setBounds(300, 300, 200, 30);

		login.setBounds(450, 345, 150, 30);
		create.setBounds(350, 400, 150, 30);
		forgot.setBounds(250, 345, 150, 30);

		this.add(lb_uname);
		this.add(lb_pass);
		this.add(lb_acc);
		this.add(lb_header);
		this.add(lb_subHeader);

		this.add(tx_uname);
		this.add(tx_pass);

		this.add(login);
		this.add(create);
		this.add(forgot);

		login.addActionListener(this);
		create.addActionListener(this);
		forgot.addActionListener(this);
                

	}
	public void actionPerformed(ActionEvent ae) {

		String value1 = tx_uname.getText();
		String value2 = tx_pass.getText();

		if (ae.getSource() == login) { //login button
			LoginService ls=new LoginService();
			if (ls.getValidation(tx_uname.getText(),tx_pass.getText())) {
				User u = new User();
				UserService us = new UserService();
				u = us.getUserByUsername(tx_uname.getText());
				if(u.getAdmin().equals("yes")){
					new AdminHomePage(tx_uname.getText());
					this.dispose();
				}
				else{
					new HomePage(tx_uname.getText());
					this.dispose();
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Incorrect login or password", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if (ae.getSource() == create) { //Create account button
			Create cp = new Create();
			cp.setVisible(true);
			this.dispose();
		}
		else if(ae.getSource() == forgot){   //forgot password
			FindUser fp = new FindUser();
			fp.setVisible(true);
			this.dispose();
		}

	}
	public static void main(String[] arg){
		Login frame=new Login();
			 
	}

}
