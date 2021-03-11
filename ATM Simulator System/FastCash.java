import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class FastCash extends JFrame implements ActionListener
{
    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    JTextField t1;
    FastCash()
    {
        setFont(new Font("System",Font.BOLD,22));
        Font f=getFont();
        FontMetrics fm=getFontMetrics(f);
        int x=fm.stringWidth("Fast Cash");
        int y=fm.stringWidth(" ");
        int z=getWidth()-(4*x);
        int w=z/y;
        String pad="";
        pad=String.format("%"+w+"s",pad);
        setTitle(pad+"Fast Cash");

        //labels-------------
        l1=new JLabel("Select withdrwal amount: ");
        l1.setFont(new Font("System",Font.BOLD,30));
        l1.setBounds(160,100,400,50);
        add(l1);

        l2=new JLabel("Enter Pin :");
        l2.setFont(new Font("System",Font.BOLD,16));
        l2.setBounds(550, 10, 200, 40);
        add(l2);

        //done-------------------

        //tf------------------
        t1=new JTextField();
        t1.setFont(new Font("System",Font.BOLD,16));
        t1.setBounds(650, 10, 100, 40);
        add(t1);

        //done----------------------

        //buttons---------------
        Font bfont=new Font("System",Font.BOLD,18);

        b1=new JButton("Rs.100");
        b1.setFont(bfont);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(100, 200, 200, 40);
        add(b1);

        b2=new JButton("Rs.500");
        b2.setFont(bfont);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(400,200,200,40);
        add(b2);

        b3=new JButton("Rs.1000");
        b3.addActionListener(this);
        b3.setFont(bfont);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(100,300,200,40);
        add(b3);

        b4=new JButton("Rs.2000");
        b4.addActionListener(this);
        b4.setFont(bfont);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(400, 300, 200, 40);
        add(b4);

        b5=new JButton("Rs.5000");
        b5.addActionListener(this);
        b5.setFont(bfont);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setBounds(100, 400, 200, 40);
        add(b5);

        b6=new JButton("Rs.10000");
        b6.addActionListener(this);
        b6.setFont(bfont);
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setBounds(400, 400, 200, 40);
        add(b6);

        b7=new JButton("Back");
        b7.addActionListener(this);
        b7.setFont(bfont);
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.setBounds(100,500,200,40);
        add(b7);

        b8=new JButton("Exit");
        b8.addActionListener(this);
        b8.setFont(bfont);
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        b8.setBounds(400, 500, 200, 40);
        add(b8);

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(800,900);
        setVisible(true);
        setLocation(500,90);
    }//constructor
    public static void main(String[] args)
    {
		new FastCash().setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            String a=t1.getText();
            String balance;
            if(ae.getSource()==b1)
            {
                conn c1=new conn();
                ResultSet rs=c1.s.executeQuery("select * from bank where pin='"+a+"' ");
                if(rs.next())
                {
                    String pin1=rs.getString("pin");
					balance=rs.getString("amount");
					System.out.println("Balance :"+balance);
					System.out.println("Pin: "+pin1);
					double b1=Double.parseDouble(balance);
					double d=100;
					b1-=d;
					String bal=Double.toString(b1);
					String q1="update bank set amount='"+bal+"' where pin='"+pin1+"'";
					//String q1="insert into bank values('"+pin+"',null,null,'"+bal+"')";
					System.out.println("Updated Sucessfully!!");
                    c1.s.executeUpdate(q1);
                }
                JOptionPane.showMessageDialog(null, "Rs.100 debited successfully");
                new Transactions().setVisible(true);
                setVisible(false);
            }
            if(ae.getSource()==b2)
            {
                conn c1=new conn();
				ResultSet rs=c1.s.executeQuery("select * from bank where pin='"+a+"' ");
				if(rs.next())
				{
					String pin1=rs.getString("pin");
					balance=rs.getString("amount");
					System.out.println("Balance :"+balance);
					System.out.println("Pin: "+pin1);
					double b1=Double.parseDouble(balance);
					double d=500;
					b1-=d;
					String bal=Double.toString(b1);
					String q1="update bank set amount='"+bal+"' where pin='"+pin1+"'";
					//String q1="insert into bank values('"+pin+"',null,null,'"+bal+"')";
					System.out.println("Updated Sucessfully!!");
                    c1.s.executeUpdate(q1);
           		}
			}
           	if(ae.getSource()==b3)
            {
            	conn c1=new conn();
			    ResultSet rs=c1.s.executeQuery("select * from bank where pin='"+a+"' ");
			    if(rs.next())
			    {
					String pin1=rs.getString("pin");
					balance=rs.getString("amount");
					System.out.println("Balance :"+balance);
					System.out.println("Pin: "+pin1);
					double b1=Double.parseDouble(balance);
					double d=1000;
					b1-=d;
					String bal=Double.toString(b1);
					String q1="update bank set amount='"+bal+"' where pin='"+pin1+"'";
					//String q1="insert into bank values('"+pin+"',null,null,'"+bal+"')";
					System.out.println("Updated Sucessfully!!");
                   	c1.s.executeUpdate(q1);
            	}
			}
            if(ae.getSource()==b4)
           	{
            	conn c1=new conn();
			    ResultSet rs=c1.s.executeQuery("select * from bank where pin='"+a+"' ");
			    if(rs.next())
			    {
			    	String pin1=rs.getString("pin");
			   		balance=rs.getString("amount");
			   		System.out.println("Balance :"+balance);
			   		System.out.println("Pin: "+pin1);
			   		double b1=Double.parseDouble(balance);
			   		double d=2000;
			   		b1-=d;
			   		String bal=Double.toString(b1);
			   		String q1="update bank set amount='"+bal+"' where pin='"+pin1+"'";
			   		//String q1="insert into bank values('"+pin+"',null,null,'"+bal+"')";
			   		System.out.println("Updated Sucessfully!!");
                    c1.s.executeUpdate(q1);
				}
            }
            if(ae.getSource()==b5)
            {
                conn c1=new conn();
				ResultSet rs=c1.s.executeQuery("select * from bank where pin='"+a+"' ");
				if(rs.next())
				{
					String pin1=rs.getString("pin");
					balance=rs.getString("amount");
					System.out.println("Balance :"+balance);
					System.out.println("Pin: "+pin1);
					double b1=Double.parseDouble(balance);
					double d=5000;
					b1-=d;
					String bal=Double.toString(b1);
					String q1="update bank set amount='"+bal+"' where pin='"+pin1+"'";
					//String q1="insert into bank values('"+pin+"',null,null,'"+bal+"')";
					System.out.println("Updated Sucessfully!!");
                    c1.s.executeUpdate(q1);
				}
            }
            if(ae.getSource()==b6)
            {
                conn c1=new conn();
				ResultSet rs=c1.s.executeQuery("select * from bank where pin='"+a+"' ");
				if(rs.next())
				{
					String pin1=rs.getString("pin");
					balance=rs.getString("amount");
					System.out.println("Balance :"+balance);
					System.out.println("Pin: "+pin1);
					double b1=Double.parseDouble(balance);
					double d=10000;
					b1-=d;
					String bal=Double.toString(b1);
					String q1="update bank set amount='"+bal+"' where pin='"+pin1+"'";
					//String q1="insert into bank values('"+pin+"',null,null,'"+bal+"')";
					System.out.println("Updated Sucessfully!!");
                    c1.s.executeUpdate(q1);
				}
            }
            if(ae.getSource()==b7)
            {
                System.out.println("Back pressed!!");
                new Transactions().setVisible(true);
                setVisible(false);
            }
            if(ae.getSource()==b8)
            {
                System.exit(0);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}