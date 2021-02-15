package chatting.application;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
public class Client extends JFrame implements ActionListener
{
	JPanel p1;
	JTextField t1;
	JButton b1;
	static JTextArea a1;
	static DataInputStream din;
	static DataOutputStream dout;
	static Socket s;
	public Client()
	{
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(7,94,84));
		p1.setBounds(0,0,450,70);
		add(p1);

		//back button
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("chatting/application/Icons/3.png"));
		Image i2=i1.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel l1=new JLabel(i3);
		l1.setBounds(5,17,30,30);
		p1.add(l1);
		l1.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me)
			{
				System.exit(0);
			}
		});

		//dp
		ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("chatting/application/Icons/2.png"));
		Image i5=i4.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
		ImageIcon i6= new ImageIcon(i5);
		JLabel l2=new JLabel(i6);
		l2.setBounds(40,05,60,60);
		p1.add(l2);

		//3 buttons
		//1
		ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("chatting/application/Icons/video.png"));
		Image i8=i7.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
		ImageIcon i9= new ImageIcon(i8);
		JLabel l5=new JLabel(i9);
		l5.setBounds(290,20,30,30);
		p1.add(l5);

		//2
		ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("chatting/application/Icons/phone.png"));
		Image i12=i11.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
		ImageIcon i13= new ImageIcon(i12);
		JLabel l6=new JLabel(i13);
		l6.setBounds(350,20,30,30);
		p1.add(l6);

		//3
		ImageIcon i14=new ImageIcon(ClassLoader.getSystemResource("chatting/application/Icons/3icon.png"));
		Image i15=i14.getImage().getScaledInstance(12,30,Image.SCALE_DEFAULT);
		ImageIcon i16= new ImageIcon(i15);
		JLabel l7=new JLabel(i16);
		l7.setBounds(410,20,12,30);
		p1.add(l7);

		//name
		JLabel l3=new JLabel("Kashmira");
		l3.setFont(new Font("SAN_SERIF",Font.BOLD,18));
		l3.setForeground(Color.WHITE);
		l3.setBounds(110,15,100,18);
		p1.add(l3);


		//status
		JLabel l4=new JLabel("Active Now");
		l4.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
		l4.setForeground(Color.WHITE);
		l4.setBounds(110,35,100,20);
		p1.add(l4);

		a1=new JTextArea();
		a1.setBounds(5,75,440,570);
		//a1.setBackground(Color.PINK);
		a1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
		a1.setEditable(false);
		a1.setLineWrap(true);
		a1.setWrapStyleWord(true);
		add(a1);

		//tf's
		t1=new JTextField();
		t1.setBounds(5,655,310,40);
		t1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
		add(t1);

		//button
		b1=new JButton("Send");
		b1.setBounds(320,655,120,40);
		b1.setBackground(new Color(7,94,84));
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
		add(b1);
		b1.addActionListener(this);


		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setSize(450,700);
		setLocation(900,10);
		setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		try{
				String s1=t1.getText();
				a1.setText(a1.getText()+"\n\t\t\t"+s1); //append kela
				dout.writeUTF(s1);
				t1.setText("");
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		new Client();

		try{
				s=new Socket("127.0.0.1",6001);
				din=new DataInputStream(s.getInputStream());
				dout=new DataOutputStream(s.getOutputStream());
				String msg_ip="";
				msg_ip=din.readUTF();
				a1.setText(a1.getText()+"\n"+msg_ip);
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}