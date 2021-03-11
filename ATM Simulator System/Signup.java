import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.lang.*;
public class Signup extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JRadioButton r1,r2,r3,r4,r5;
	JButton b;
	JComboBox c1,c2,c3;

	Random ran=new Random();
	long first4= (ran.nextLong() %9000L)+ 1000L;
	long first=Math.abs(first4);

	public Signup()
	{
		//frame head center
		setFont(new Font("system",Font.BOLD,22));
		//to get the head name of the frame we are doing this stuff
		Font f= getFont();
		FontMetrics fm= getFontMetrics(f);
		int x=fm.stringWidth("New Account Application Form");
		int y=fm.stringWidth(" ");
		int z=getWidth() -x;
		int w=z/y;
		String pad="";
		pad=String.format("%"+w+"s",pad);
		setTitle(pad+"New Account Application Form");

		//label setting
		l1=new JLabel("Application Form No: "+first);
		l1.setFont(new Font("Raleway",Font.BOLD,38));

		l2=new JLabel("Page1 : Personal Deatils");
		l2.setFont(new Font("Raleway",Font.BOLD,22));

		l3=new JLabel("Name : ");
		l3.setFont(new Font("Raleway",Font.BOLD,20));

		l4=new JLabel("Surname : ");
		l4.setFont(new Font("Raleway",Font.BOLD,20));

		l5=new JLabel("Date of Birth: ");
		l5.setFont(new Font("Raleway",Font.BOLD,20));

		l6=new JLabel("Gender: ");
		l6.setFont(new Font("Raleway",Font.BOLD,20));

		l7=new JLabel("Email Address: ");
		l7.setFont(new Font("Raleway",Font.BOLD,20));

		l8=new JLabel("Maritial Status : ");
		l8.setFont(new Font("Raleway",Font.BOLD,20));

		l9=new JLabel("Address : ");
		l9.setFont(new Font("Raleway",Font.BOLD,20));

		l10=new JLabel("City : ");
		l10.setFont(new Font("Raleway",Font.BOLD,20));

		l11=new JLabel("Pin Code : ");
		l11.setFont(new Font("Raleway",Font.BOLD,20));

		l12=new JLabel("State : ");
		l12.setFont(new Font("Raleway",Font.BOLD,20));

		l13=new JLabel("Date : ");
		l13.setFont(new Font("Raleway",Font.BOLD,14));

		l14=new JLabel("Month : ");
		l14.setFont(new Font("Raleway",Font.BOLD,14));

		l15=new JLabel("Year : ");
		l15.setFont(new Font("Raleway",Font.BOLD,14));

		t1=new JTextField();
		t1.setFont(new Font("Raleway",Font.BOLD,14));

		t2=new JTextField();
		t2.setFont(new Font("Raleway",Font.BOLD,14));

		t3=new JTextField();
		t3.setFont(new Font("Raleway",Font.BOLD,14));

		t4=new JTextField();
		t4.setFont(new Font("Raleway",Font.BOLD,14));

		t5=new JTextField();
		t5.setFont(new Font("Raleway",Font.BOLD,14));

		t6=new JTextField();
		t6.setFont(new Font("Raleway",Font.BOLD,14));

		t7=new JTextField();
		t7.setFont(new Font("Raleway",Font.BOLD,14));

		b=new JButton("Next ");
		b.setFont(new Font("Raleway",Font.BOLD,14));
		b.setBackground(Color.BLACK);
		b.setForeground(Color.WHITE);

		r1=new JRadioButton("Male");
		r1.setFont(new Font("Raleway",Font.BOLD,14));
		r1.setBackground(Color.WHITE);

		r2=new JRadioButton("Female");
		r2.setFont(new Font("Raleway",Font.BOLD,14));
		r2.setBackground(Color.WHITE);

		r3=new JRadioButton("Married");
		r3.setFont(new Font("Raleway",Font.BOLD,14));
		r3.setBackground(Color.WHITE);

		r4=new JRadioButton("Unmarried");
		r4.setFont(new Font("Raleway",Font.BOLD,14));
		r4.setBackground(Color.WHITE);

		r5=new JRadioButton("Other");
		r5.setFont(new Font("Raleway",Font.BOLD,14));
		r5.setBackground(Color.WHITE);

		String date[]= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
		c1=new JComboBox(date);
		c1.setBackground(Color.WHITE);

		String month[]= {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Octo","Nov","Dec"};
		c2=new JComboBox(month);
		c2.setBackground(Color.WHITE);

		String year[]= {"1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005"};
		c3=new JComboBox(year);
		c3.setBackground(Color.WHITE);

		setLayout(null);

		//setting bounds for labels
		l1.setBounds(140,20,600,40);
		add(l1);

		 l2.setBounds(290,70,600,30);
		 add(l2);

		l3.setBounds(100,140,100,30);
		add(l3);

		//textfield t1 bounds
		t1.setBounds(300,140,400,30);
		add(t1);

		//again labels
		l4.setBounds(100,190,200,30);
		add(l4);

		t2.setBounds(300,190,400,30);
		add(t2);

		l5.setBounds(100,240,200,30);
		add(l5);

		l13.setBounds(300,240,60,30);
		add(l13);

		c1.setBounds(340,240,60,30);
		add(c1);

		l14.setBounds(410,240,73,30);
		add(l14);

		c2.setBounds(460,240,100,30);
		add(c2);

		l15.setBounds(570,240,75,30);
		add(l15);

		c3.setBounds(610,240,90,30);
		add(c3);

		l6.setBounds(100,290,200,30);
		add(l6);

		r1.setBounds(300,290,60,30);
		add(r1);

		r2.setBounds(450,290,90,30);
		add(r2);

		l7.setBounds(100,340,200,30);
		add(l7);

		t3.setBounds(300,340,400,30);
		add(t3);

		l8.setBounds(100,390,200,30);
		add(l8);

		r3.setBounds(300,390,100,30);
		add(r3);

		r4.setBounds(450,390,100,30);
		add(r4);

		r5.setBounds(635,390,100,30);
		add(r5);

		l9.setBounds(100,440,200,30);
		add(l9);

		t4.setBounds(300,440,400,30);
		add(t4);

		l10.setBounds(100,490,200,30);
		add(l10);

		t5.setBounds(300,490,400,30);
		add(t5);

		l11.setBounds(100,540,200,30);
		add(l11);

		t6.setBounds(300,540,400,30);
		add(t6);

		l12.setBounds(100,590,200,30);
		add(l12);

		t7.setBounds(300,590,400,30);
		add(t7);

		b.setBounds(620,660,80,30);
		add(b);
		//adding action to button
		b.addActionListener(this);

		getContentPane().setBackground(Color.WHITE);
		setSize(850,850);
		setLocation(500,90);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String a=t1.getText();
		String b=t2.getText();

		//in ac,bc,cc we are fetching dd mm yy from choicebox c1,c2,c3
		//getSelectedIte will return object type so converted to string(type cast)
		String ac=(String)c1.getSelectedItem();
		String bc=(String)c2.getSelectedItem();
		String cc=(String)c3.getSelectedItem();

		String d=null;
		if(r1.isSelected())
		{
			d="Male";
		}
		else if(r2.isSelected())
		{
			d="Female";
		}

		//fetching name
		String e=t3.getText();
		String f=null;
		if(r3.isSelected())
		{
			f="Married";
		}
		else if(r4.isSelected())
		{
			f="Unmarried";
		}
		else if(r5.isSelected())
		{
			f="Other";
		}

		String g=t4.getText();
		String h=t5.getText();
		String i=t6.getText();
		String j=t7.getText();

		//console data check
		System.out.println("Name: "+a);
		System.out.println("Fname :"+b);
		System.out.println("Date : "+ac);
		System.out.println("Month : "+bc);
		System.out.println("Year : "+cc);
		System.out.println("Gender : "+d);
		System.out.println("email: "+e);
		System.out.println("Marritial : "+f);
		System.out.println("Address : "+g);
		System.out.println("City : "+h);
		System.out.println("Pincode : "+i);
		System.out.println("State : "+j);
		System.out.println("Form no: "+first);
		//done
			try {
				if(t6.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Fill all the required fields");
				}//if t6
				else
				{
					conn c1=new conn();
					//String q1="insert into signup values('"+a+"','"+b+"','"+ac+"','"+bc+"','"+cc+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+i+"','"+j+"','"+first+"')";
					String q1="insert into signup(formno,name,fname,dob,gender,email,marital,address,city,pincode,state) values('"+first+"','"+a+"','"+b+"','"+ac+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+i+"','"+j+"')";
					c1.s.executeUpdate(q1);

					new Signup2().setVisible(true);
					setVisible(false);
				}
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
	}
	public static void main(String[] args)
	{
		new Signup();

	}
}
