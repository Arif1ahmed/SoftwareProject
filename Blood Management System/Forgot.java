
import javax.swing.*;
import java.awt.*;
import java.awt.event. * ;


class Forgot extends JFrame implements ActionListener{

      JLabel lb_header = new JLabel();
	
      JTextField tx_ansQ = new JTextField(15);
      
      JButton submit = new JButton("Submit");
      JButton cancel = new JButton("Cancel");

      JLabel question = new JLabel("");
      String username;

      public Forgot(){}

      public Forgot(String username){
         this.username = username;

         this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
         this.setTitle("Security Question");
         this.setSize(900, 700);
         this.getContentPane().setBackground(Color.LIGHT_GRAY);
         this.setLocationRelativeTo(null);
         this.setLayout(null);
         this.setResizable(false);
   
         lb_header.setText("Answer Security Question");
         lb_header.setFont(new Font("Serif", Font.BOLD, 35));
    
         lb_header.setBounds(290, 150, 350, 50);
      
         submit.setBounds(475, 400, 100, 30);
         cancel.setBounds(315, 400, 100, 30);
      
   
         tx_ansQ.setBounds(320, 300, 275, 30);
         question.setBounds(320, 250, 275, 30);

         this.add(lb_header);
         this.add(tx_ansQ);
         this.add(question);
         
         submit.addActionListener(this);
         this.add(submit);
         cancel.addActionListener(this);
         this.add(cancel);

         ForgotPassService fps = new ForgotPassService();
         ForgotPass fp = new ForgotPass();
         fp = fps.getForgotPassByUsername(username);
         question.setText(fp.getQsn());


      }
      public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submit){
               ForgotPassService ps = new ForgotPassService();
               ForgotPass f = new ForgotPass();
               f = ps.getForgotPassByUsername(username);
               String temp = f.getAns();
               if(temp.equals(tx_ansQ.getText())){
                  ResetPass rp = new ResetPass(username);
                  rp.setVisible(true);
                  this.dispose();
               }
               else{
                  JOptionPane.showMessageDialog(this, "Invalid Answer", "Error", JOptionPane.ERROR_MESSAGE);
               }
            }
            else if (e.getSource()== cancel){
               Login log = new Login();
               log.setVisible(true);
               this.dispose();
            }
            
         }
   }