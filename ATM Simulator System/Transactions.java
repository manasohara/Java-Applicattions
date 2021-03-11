import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener
{
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    Transactions()
    {
		//frame head center
		setFont(new Font("system",Font.BOLD,22));
		//to get the head name of the frame we are doing this stuff
		Font f= getFont();
		FontMetrics fm= getFontMetrics(f);
		int x=fm.stringWidth("Transactions");
		int y=fm.stringWidth(" ");
		int z=getWidth() -x;
		int w=z/y;
		String pad="";
		pad=String.format("%"+w+"s",pad);
		setTitle(pad+"Transactions");
		//done

		//----------Label-------------------
		l1=new JLabel("Please select your transaction ");
		l1.setFont(new Font("System",Font.BOLD,24));
		l1.setBounds(130, 40, 500, 30);
		add(l1);
		//----------Label Done--------------

		//----------Button------------------
		Font bfont=new Font("System",Font.BOLD,18);
		b1=new JButton("Deposit");
		b1.addActionListener(this);
		b1.setFont(bfont);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(60,140,200,30);
		add(b1);

		b2=new JButton("Cash Withdrawl");
		b2.addActionListener(this);
		b2.setFont(bfont);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(350,140,200,30);
		add(b2);


		b3=new JButton("Fast Cash");
		b3.addActionListener(this);
		b3.setFont(bfont);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(60,240,200,30);
		add(b3);

		b4=new JButton("Mini Statement");
		b4.addActionListener(this);
		b4.setFont(bfont);
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		b4.setBounds(350,240,200,30);
		add(b4);

		b5=new JButton("Pin Change");
		b5.addActionListener(this);
		b5.setFont(bfont);
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		b5.setBounds(60,340,200,30);
		add(b5);

		b6=new JButton("Balance Enquiry");
		b6.addActionListener(this);
		b6.setFont(bfont);
		b6.setBackground(Color.BLACK);
		b6.setForeground(Color.WHITE);
		b6.setBounds(350,340,200,30);
		add(b6);

		b7=new JButton("Exit");
		b7.addActionListener(this);
		b7.setFont(bfont);
		b7.setBackground(Color.BLACK);
		b7.setForeground(Color.WHITE);
		b7.setBounds(200,420,200,30);
		add(b7);
		//----------JButton done-----------

		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setSize(600,600);
		setLocation(500,90);
		setVisible(true);
	}//constructor
	public static void main(String[] args)
	{
		new Transactions();
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			new Deposit().setVisible(true);
			setVisible(false);
			System.out.println("Deposit");
		}
			if(ae.getSource()==b2)
			{
				new Withdrwal().setVisible(true);
				System.out.println("Withdrwal");
				setVisible(false);
			}
			if(ae.getSource()==b3)
			{
				new FastCash().setVisible(true);
				System.out.println("FastCash");
				setVisible(false);
			}
			if(ae.getSource()==b4)
			{
				new Login().setVisible(true);
				System.out.println("Login");
				setVisible(false);
			}
			if(ae.getSource()==b5)
			{
				new Pin().setVisible(true);
				System.out.println("PIN");
				setVisible(true);
			}
			if(ae.getSource()==b6)
			{
				String pinn=JOptionPane.showInputDialog("Enter PIN");
				conn c1=new conn();
				try
				{
					ResultSet rs=c1.s.executeQuery("select amount from bank ORDER BY pin = '"+pinn+"' DESC LIMIT 1");
					if(rs.next())
					{
						String balance=rs.getString("amount");
						JOptionPane.showMessageDialog(null, "Your account balance is : "+balance);
					}
				}
				catch (Exception ex)
				{
					System.out.println(ex);
				}
				//System.out.println("Balance");
			}
			if(ae.getSource()==b7)
			{
				System.exit(0);
			}
		}
}
