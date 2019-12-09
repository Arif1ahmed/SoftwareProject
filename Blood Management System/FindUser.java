
import javax.swing.*;
import java.awt.*;
import java.awt.event. * ;


class FindUser extends JFrame implements ActionListener{

    JLabel lb_header = new JLabel();
    JLabel lb_uname = new JLabel();

	
    JTextField tx_uname = new JTextField(15);
      
    JButton search = new JButton("Search");
    JButton cancel = new JButton("Cancel");

    public FindUser(){

        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setTitle("Confirm Identity");
        this.setSize(900, 700);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);

        lb_header.setText("Confirm Identity");
        lb_header.setFont(new Font("Serif", Font.BOLD, 35));
        lb_uname.setText("Enter Username : "); 
    
        lb_header.setBounds(310, 150, 350, 50);
        lb_uname.setBounds(230, 290, 175, 50);
    
        search.setBounds(475, 400, 100, 30);
        cancel.setBounds(315, 400, 100, 30);
    
        tx_uname.setBounds(350, 300, 200, 30);
        this.add(lb_header);
        this.add(lb_uname);
           
        this.add(tx_uname);
        
        search.addActionListener(this);
        this.add(search);
        cancel.addActionListener(this);
        this.add(cancel);
    }
    public void actionPerformed(ActionEvent e) {
        String value1 = tx_uname.getText();
        if (e.getSource() == search) {  
            UserService us = new UserService();
            if (us.getUserValidation(value1)){
                Forgot page = new Forgot(value1);
                page.setVisible(true);
                this.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Invalid Username", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (e.getSource()== cancel){
                Login log = new Login();
                log.setVisible(true);
                this.dispose();
            }
    }
}
