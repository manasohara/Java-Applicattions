import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.lang.*;
public class Signup3 extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JRadioButton r1,r2,r3,r4;
    JButton b1,b2;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JTextField t1;
    Signup3()
    {
        //frame head center
		setFont(new Font("system",Font.BOLD,22));
		//to get the head name of the frame we are doing this stuff
		Font f= getFont();
		FontMetrics fm= getFontMetrics(f);
		int x=fm.stringWidth("New Account Application Form -Page 3");
		int y=fm.stringWidth(" ");
		int z=getWidth() -x;
		int w=z/y;
		String pad="";
		pad=String.format("%"+w+"s",pad);
		setTitle(pad+"New Account Application Form -Page 3");
		//done

        //labels-----------------------------------------------------
        l1=new JLabel("Page 3 : Account Details: ");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280, 50, 400, 40);
        add(l1);

        l2=new JLabel("Account type: ");
        l2.setFont(new Font("Raleway",Font.BOLD,18));
        l2.setBounds(100, 140, 200, 30);
        add(l2);

        l3=new JLabel("Card no: ");
        l3.setFont(new Font("Raleway",Font.BOLD,18));
        l3.setBounds(100, 300, 200, 30);
        add(l3);

        l4=new JLabel("XXXX-XXXX-XXXX-4184");
        l4.setFont(new Font("Raleway",Font.BOLD,18));
        l4.setBounds(330, 300, 250, 30);
        add(l4);

        l5=new JLabel("Enter your 16-digit card no: ");
        l5.setFont(new Font("Raleway",Font.BOLD,12));
        l5.setBounds(100, 330, 200, 20);
        add(l5);

        l6=new JLabel("It would apper on ATM card /cheque book and statements ");
        l6.setFont(new Font("Raleway",Font.BOLD,12));
        l6.setBounds(330, 330, 500, 20);
        add(l6);

        l7=new JLabel("PIN: ");
        l7.setFont(new Font("Raleway",Font.BOLD,18));
        l7.setBounds(100, 370, 200, 30);
        add(l7);

        l8=new JLabel("XXXX");
        l8.setFont(new Font("Raleway",Font.BOLD,18));
        l8.setBounds(330, 370, 200, 30);
        add(l8);

        l9=new JLabel("(4-digit Password :)");
        l9.setFont(new Font("Raleway",Font.BOLD,18));
        l9.setBounds(100, 400, 200, 20);
        add(l9);

        l10=new JLabel("Services Required");
        l10.setFont(new Font("Raleway",Font.BOLD,18));
        l10.setBounds(100, 450, 200, 30);
        add(l10);

        l11=new JLabel("Form no: ");
        l11.setFont(new Font("Raleway",Font.BOLD,14));
        l11.setBounds(700, 10, 70, 30);
        add(l11);
        //----------------label done

        //------------Buttons-----------------------------------------------------
        b1=new JButton("Submit");
		b1.setFont(new Font("Raleway",Font.BOLD,14));
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
        b1.setBounds(300, 700, 100, 30);
        add(b1);

        b2=new JButton("Cancel");
		b2.setFont(new Font("Raleway",Font.BOLD,14));
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
        b2.setBounds(420, 700, 100, 30);
        add(b2);
        //---------------------buttons done

        //-----------------CheckBoxes------------------------------------------
        Font fnt1=new Font("Raleway",Font.BOLD,16);

        c1=new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(fnt1);
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(fnt1);
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(fnt1);
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4=new JCheckBox("Email Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(fnt1);
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5=new JCheckBox("Cheque book");
        c5.setBackground(Color.WHITE);
        c5.setFont(fnt1);
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(fnt1);
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7=new JCheckBox("I agree to all terms* ",true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,680,600,20);
        add(c7);
        //----------------Checkbox done

        //--------------RadioButtons------------------------------------
        r1=new JRadioButton("Savings account");
        r1.setFont(fnt1);
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 150, 30);
        add(r1);

        r2=new JRadioButton("Fixed Deposit account");
        r2.setFont(fnt1);
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 300, 30);
        add(r2);

        r3=new JRadioButton("Current account");
        r3.setFont(fnt1);
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 250, 30);
        add(r3);

        r4=new JRadioButton("Recurring Deposit account");
        r4.setFont(fnt1);
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 30);
        add(r4);

        //--------------------Radio done

        //-----------------TextField-----------------------
        t1=new JTextField();
        t1.setFont(new Font("Raleway",Font.BOLD,12));
        t1.setBounds(770, 10, 40, 30);
        add(t1);
        //------------------------TextField done
        //---------****FRAME****--------
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(850,850);
        setVisible(true);

    }//constructor
    public static void main(String[] args)
    {
        new Signup3();
    }
    public void actionPerformed(ActionEvent ae)
    {
        String a=null;
        if(r1.isSelected())
        {
            a="Saving Account";
        }
        else if(r2.isSelected())
        {
            a="FD Account";
        }
        else if(r3.isSelected())
        {
            a="Current Account";
        }
        else if(r4.isSelected())
        {
            a="Recurring Deposit Account";
        }

        // Randoms no. are generated for atm card no and pin
        Random ran=new Random();
        long first7= (ran.nextLong() % 90000000L) + 4622442200000000L; //16 digits
        long first8=Math.abs(first7);//to not getting -tive only +tive
        long first3= (ran.nextLong() % 9000L) + 1000L; //pin
        long first4=Math.abs(first3); //+

        String b="";
        if(c1.isSelected())
        {
            b+=" ATM card";
        }
        else if(c2.isSelected())
        {
            b+=" Internet Banking";
        }
        else if(c3.isSelected())
        {
            b+=" Mobile Banking";
        }
        else if(c4.isSelected())
        {
            b+=" Email Alerts";
        }
        else if(c5.isSelected())
        {
            b+=" Cheque Book";
        }
        else if(c6.isSelected())
        {
            b+=" E-Statement";
        }

        String c=t1.getText();

        try
        {
            if(ae.getSource()==b1)
            {
                if(b.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Fill all the fields");
                }
                else
                {
                    conn c1=new conn();
                    String q1="insert into signup3(formno,atype,cardno,pin,facility) values('"+c+"','"+a+"','"+first8+"','"+first4+"','"+b+"')";
                    String q2="insert into login(formno,cardno,pin) values('"+c+"','"+first8+"','"+first4+"')";
                    String q3="insert into bank(pin,date,mode,amount) values('"+first4+"',null,null,'0')";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    c1.s.executeUpdate(q3);
                    JOptionPane.showMessageDialog(null,"Card Number : "+first8+"\n PIN: "+first4);
                    new Deposit().setVisible(true);
                    setVisible(false);
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        if(ae.getSource()==b2)
        {
            setVisible(false);
        }
    }
}
