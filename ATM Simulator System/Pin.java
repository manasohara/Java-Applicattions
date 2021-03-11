import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Pin extends JFrame implements ActionListener
{
    JPasswordField t1,t2,t3;
    JButton b1,b2;
    JLabel l1,l2,l3,l4;
    Pin()
    {
        //frame head center
        setFont(new Font("system",Font.BOLD,22));
        //to get the head name of the frame we are doing this stuff
        Font f= getFont();
        FontMetrics fm= getFontMetrics(f);
        int x=fm.stringWidth("Pin CHNAGE");
        int y=fm.stringWidth(" ");
        int z=getWidth() -x;
        int w=z/y;
        String pad="";
        pad=String.format("%"+w+"s",pad);
        setTitle(pad+"Pin CHANGE");

        Font lf=new Font("System",Font.BOLD,22);
        //labels---------------------------------------
        l1=new JLabel("CHANGE YOUR PIN");
        l1.setFont(lf);
        l1.setBounds(220, 130, 800, 60);
        add(l1);

        l2=new JLabel("Current PIN: ");
        l2.setFont(lf);
        l2.setBounds(100, 240, 150, 40);
        add(l2);

        l3=new JLabel("New PIN : ");
        l3.setFont(lf);
        l3.setBounds(100, 300, 150, 40);
        add(l3);

        l4=new JLabel("Re-enter new PIN :");
        l4.setFont(lf);
        l4.setBounds(100, 360, 200, 40);
        add(l4);

        //done-------------------------------------------

        //Passwords-------------------------------------

        Font pf=new Font("Raleway",Font.BOLD,22);

        t1=new JPasswordField();
        t1.setFont(pf);
        t1.setBounds(310, 240, 360, 40);
        add(t1);

        t2=new JPasswordField();
        t2.setFont(pf);
        t2.setBounds(310, 300, 360, 40);
        add(t2);

        t3=new JPasswordField();
        t3.setFont(pf);
        t3.setBounds(310, 360, 360, 40);
        add(t3);

        //done----------------------------------------

        //Buttons------------------------------

        b1=new JButton("Save");
        b1.setFont(new Font("System",Font.BOLD,18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(260, 450, 125, 50);
        add(b1);
        b1.addActionListener(this);

        b2=new JButton("Back");
        b2.setFont(new Font("System",Font.BOLD,18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(415, 450, 125, 50);
        add(b2);
        b2.addActionListener(this);

        //done-------------------------------
        setLayout(null);
        setSize(900,800);
        setVisible(true);
    }//constructor
    public static void main(String[] args)
    {
        new Pin().setVisible(true);
    }//main
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
          String a=t1.getText() ;
          String b=t2.getText();
          String c=t3.getText();
          if(ae.getSource() == b1)
          {
              if(t1.getText().equals(""))
              {
                  JOptionPane.showMessageDialog(null,"Please enter your current PIN");
              }
              if(t2.getText().equals(""))
              {
                  JOptionPane.showMessageDialog(null,"Please enter your new PIN");
              }
              if(t3.getText().equals(""))
              {
                  JOptionPane.showMessageDialog(null,"Please Re-enter your new PIN");
              }
              if(t2.getText().equals(t3.getText()))
              {
                  conn c1=new conn();
                  String q1="update bank set pin='"+b+"' where pin='"+a+"' ";
                  c1.s.executeUpdate(q1);
                  String q2="update login set pin='"+b+"' where pin='"+a+"' ";
                  c1.s.executeUpdate(q2);
                  String q3="update signup3 set pin='"+b+"' where pin='"+a+"' ";
                  c1.s.executeUpdate(q3);
                  JOptionPane.showMessageDialog(null, "PIN changed successfully");
                  new Transactions().setVisible(true);
                  setVisible(false);
              }
              else
              {
                  JOptionPane.showMessageDialog(null,"PIN entered doesn't match");
              }
          }
          if(ae.getSource()==b2)
          {
              new Transactions().setVisible(true);
              setVisible(false);
          }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
