import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Deposit extends JFrame implements ActionListener
{
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    Deposit()
    {
        //frame head center
        setFont(new Font("system",Font.BOLD,22));
        //to get the head name of the frame we are doing this stuff
        Font f= getFont();
        FontMetrics fm= getFontMetrics(f);
        int x=fm.stringWidth("Deposit");
        int y=fm.stringWidth(" ");
        int z=getWidth() -x;
        int w=z/y;
        String pad="";
        pad=String.format("%"+w+"s",pad);
        setTitle(pad+"Deposit");
        //done

        //labels-------------------
        Font lfont=new Font("System",Font.BOLD,24);
         l1=new JLabel("Enter amount you want");
         l1.setFont(lfont);
         l1.setBounds(240, 150, 800, 60);
         add(l1);

         l2=new JLabel("To deposit");
         l2.setFont(lfont);
         l2.setBounds(290, 210, 800, 60);
         add(l2);

         l3=new JLabel("Enter PIN");
         l3.setFont(new Font("System",Font.BOLD,18));
         l3.setBounds(520, 10, 120, 30);
         add(l3);
         //done---------------------

         //tf-----------------

         Font tfont=new Font("Raleway",Font.BOLD,18);
         t1=new JTextField();
         t1.setFont(new Font("Raleway",Font.BOLD,18));
         t1.setBounds(250, 300, 300, 50);
         add(t1);

         t2=new JTextField();
         t2.setFont(new Font("System",Font.BOLD,20));
         t2.setBounds(620, 10, 140, 30);
         add(t2);

         //done---------------------

         //Button--------------------
         b1=new JButton("Deposit");
         b1.setFont(new Font("System",Font.BOLD,18));
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         b1.setBounds(260, 380, 125, 50);
         add(b1);
         b1.addActionListener(this);

         b2=new JButton("Back");
         b2.setFont(new Font("System",Font.BOLD,18));
         b2.setBackground(Color.BLACK);
         b2.setForeground(Color.WHITE);
         b2.setBounds(415, 380, 125, 50);
         add(b2);
         b2.addActionListener(this);

         b3=new JButton("Exit");
         b3.setFont(new Font("System",Font.BOLD,18));
         b3.setBackground(Color.BLACK);
         b3.setForeground(Color.WHITE);
         b3.setBounds(300,550,200,50);
         add(b3);
         b3.addActionListener(this);

         //done---------------------
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
		 setSize(800,900);
		 setVisible(true);

    }
    public static void main(String[] args) {
		new Deposit();
    }
    public void actionPerformed(ActionEvent ae)
    {
        try {
            String a=t1.getText();
            String b=t2.getText();
            if(ae.getSource()==b1)
            {
                if(t1.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Plaese enter the amount to deposit");
                }
                else
                {
                    conn c1=new conn();
                    ResultSet rs=c1.s.executeQuery("select * from bank where pin='"+b+"' ");
                    String balance;
                    if(rs.next())
                    {
                        String pin1=rs.getString("pin");
                        balance=rs.getString("amount");
                        System.out.println("Balance :"+balance);
                        System.out.println("Pin: "+pin1);
                        double b1=Double.parseDouble(balance);
                        double d=Double.parseDouble(a);
                        b1+=d;
                        String bal=Double.toString(b1);
                        String q1="update bank set amount='"+bal+"' where pin='"+pin1+"'";
                        //String q1="insert into bank values('"+pin+"',null,null,'"+bal+"')";
                        System.out.println("Updated Sucessfully!!");
                        c1.s.executeUpdate(q1);
                    }
                    JOptionPane.showMessageDialog(null, "Rs."+a+" deposited sucessfully");
                    new Transactions().setVisible(true);
                    setVisible(false);
                }
            }
            else if(ae.getSource()==b2)
            {
               	new Transactions().setVisible(true);
                setVisible(false);
            }
            else if(ae.getSource()==b3)
            {
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
