import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JTextField tf1;
	JPasswordField pf2;
	JButton b1,b2,b3;

	Login()
	{
		setFont(new Font("serif",Font.BOLD,22));
		//to get the head name of the frame we are doing this stuff
		Font f= getFont();
		FontMetrics fm= getFontMetrics(f);
		int x=fm.stringWidth("Automated Teller Machine");
		int y=fm.stringWidth(" ");
		int z=getWidth() -x;
		int w=z/y;
		String pad="";
		pad=String.format("%"+w+"s",pad);
		setTitle(pad+"Automated Teller Machine");
		//done alignment

		//labels--------------------
		l1=new JLabel("Welcome to ATM");
		l1.setFont(new Font("Osward",Font.BOLD,38));
		l1.setBounds(175,50,450,200);
		add(l1);

		l2=new JLabel("Card no: ");
		l2.setFont(new Font("Raleway",Font.BOLD,28));
		l2.setBounds(	125,150,375,200);
		add(l2);

		l3=new JLabel("PIN: ");
		l3.setFont(new Font("Raleway",Font.BOLD,28));
		l3.setBounds(125,225,375,200);
		add(l3);
		//done-----------------------

		//tf-------------------------
		tf1=new JTextField(15);
		tf1.setFont(new Font("Arial",Font.BOLD,14));
		tf1.setBounds(300,235,230,30);
		add(tf1);
		//done-----------------------

		//pf-----------------------
		pf2= new JPasswordField();
		pf2.setFont(new Font("Arial",Font.BOLD,14));
		pf2.setBounds(300,310,230,30);
		add(pf2);
		//done-----------------------

		//buttons---------------------
		b1=new JButton("Sign in");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Arial",Font.BOLD,14));
		b1.setBounds(300,400,100,30);
		add(b1);
		b1.addActionListener(this);

		b2=new JButton("Clear");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Arial",Font.BOLD,14));
		b2.setBounds(430,400,100,30);
		add(b2);
		b2.addActionListener(this);

		b3=new JButton("Sign up");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Arial",Font.BOLD,14));
		b3.setBounds(300,450,230,30);
		add(b3);
		b3.addActionListener(this);
		//done-----------------------

		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setSize(750,750);
		setLocation(500,200);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			conn c1=new conn();
			String a=tf1.getText();
			String b=pf2.getText();
			String q="select * from login where cardno= '"+a+"' and pin='"+b+"'";
			ResultSet rs=c1.s.executeQuery(q);
			if(ae.getSource()==b1)
			{
				if(rs.next())
				{
					new Transactions().setVisible(true);
					System.out.println("Logged In Successfully!!");
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Incorrect card no. or password");
				}
			}//if 1
			else if(ae.getSource() ==b2)
			{
				tf1.setText("");
				pf2.setText("");
			}//if2
			else if(ae.getSource()==b3)
			{
				new Signup().setVisible(true);
				setVisible(false);
			}
		} //try
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String[] args)
	{
		new Login();
	}
}
