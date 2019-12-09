import javax.swing.*;
import java.awt.*;
import java.awt.event. * ;


class ResetPass extends JFrame implements ActionListener{

    JLabel lb_header = new JLabel("");
    JLabel password = new JLabel("Enter Password");
    JLabel confirmPass = new JLabel("Confirm Password");
    JPasswordField pass = new JPasswordField();
    JPasswordField cpass = new JPasswordField();
    JButton submit = new JButton("Submit");
    JButton cancel = new JButton("Cancel");
    JLabel question = new JLabel("");
    String username;
    public ResetPass(){}
    public ResetPass(String username){
        this.username = username;
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setTitle("Reset Password");
        this.setSize(900, 700);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);

        lb_header.setText("Reset Password");
        lb_header.setFont(new Font("Serif", Font.BOLD, 35));
        lb_header.setBounds(310, 150, 350, 50);

        password.setBounds(290, 250, 150, 30);
        confirmPass.setBounds(290, 290, 150, 30);
        pass.setBounds(450, 250, 150, 30);
        cpass.setBounds(450, 290, 150, 30);
    
        submit.setBounds(475, 400, 100, 30);
        cancel.setBounds(315, 400, 100, 30);

        this.add(lb_header);
        this.add(password);
        this.add(confirmPass);
        this.add(pass);
        this.add(cpass);
        this.add(submit);
        this.add(cancel);

        submit.addActionListener(this);
        cancel.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submit){
            UserService us = new UserService();
            String value1 = pass.getText();
            String value2 = cpass.getText();
            if(value1.equals(value2)){
                us.updatePass(username, value1);
                JOptionPane.showMessageDialog(this, "Password Updated", "Information", JOptionPane.INFORMATION_MESSAGE);
                Login l = new Login();
                l.setVisible(true);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this, "Passwords Dont Match", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource()==cancel){
            Login log = new Login();
            log.setVisible(true);
            this.dispose();
        }

    }
}