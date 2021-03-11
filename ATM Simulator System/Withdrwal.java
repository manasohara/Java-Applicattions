import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Withdrwal extends JFrame implements ActionListener
{
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    Withdrwal()
    {
        //frame head center
        setFont(new Font("system",Font.BOLD,22));
        //to get the head name of the frame we are doing this stuff
        Font f= getFont();
        FontMetrics fm= getFontMetrics(f);
        int x=fm.stringWidth("Withdrawl");
        int y=fm.stringWidth(" ");
        int z=getWidth() -x;
        int w=z/y;
        String pad="";
        pad=String.format("%"+w+"s",pad);
        setTitle(pad+"Withdrawl");

        Font lfont=new Font("System",Font.BOLD,18);
        //labels---------------------------------------
        l1=new JLabel("Maximum Daily Withdrwal");
        l1.setFont(new Font("System",Font.BOLD,22));
        l1.setBounds(300,170,280,20);
        add(l1);

        l2=new JLabel("IS Rs.10000");
        l2.setFont(lfont);
        l2.setBounds(380, 200, 800, 60);
        add(l2);

        l3=new JLabel("Please enter your amount");
        l3.setFont(lfont);
        l3.setBounds(310,260,800,60);
        add(l3);

        l4=new JLabel("Enter pin:");
        l4.setFont(lfont);
        l4.setBounds(690,7,100,40);
        add(l4);
        //done---------------

        //textfields------------
        t2=new JTextField();
        t2.setFont(lfont);
        t2.setBounds(300,320,240,30);
        add(t2);

        t1=new JTextField();
        t1.setFont(lfont);
        t1.setBounds(790,10,90,30);
        add(t1);

        //done---------------------

        //Button--------------------
         b1=new JButton("Withdrwal");
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
         b2.setBounds(435, 380, 125, 50);
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
        setLayout(null);
        setSize(900, 800);
        setVisible(true);
    }//constructor
    public static void main(String[] args)
    {
        new Withdrwal().setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        try {
            String a=t2.getText();
            String b=t1.getText();
            if(ae.getSource()==b1)
            {
                if(t2.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Plaese enter the amount to withdrawl");
                }
                else if(t1.getText().equals(""))
				{
				    JOptionPane.showMessageDialog(null,"Plaese enter the PIN");
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
					    b1-=d;
					    String bal=Double.toString(b1);
					    String q1="update bank set amount='"+bal+"' where pin='"+pin1+"'";
					   	System.out.println("Updated Sucessfully!!");
					    c1.s.executeUpdate(q1);
					 }
					 JOptionPane.showMessageDialog(null, "Rs."+a+" withdrwal sucessfully");
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
