import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/* <applet code="Mycalci" width="300" height="250"> </applet> */
public class Mycalci extends Applet implements Runnable{
Label l1,l2,l3;
TextField t1,t2;
Button b1,b2,b3,b4;
public void init()
{
l1=new Label("First number");
l2=new Label("Second number");
l3=new Label();
t1=new TextField();
t2=new TextField();
b1=new Button("Add");
b2=new Button("Sub");
b3=new Button("Mul");
b4=new Button("Div");
setLayout(null);
l1.setBounds(30,50,100,20);
l2.setBounds(30,100,100,20);
l3.setBounds(30,180,150,20);
t1.setBounds(150,50,100,20);
t2.setBounds(150,100,100,20);
b1.setBounds(20,150,60,20);
b2.setBounds(90,150,60,20);
b3.setBounds(160,150,60,20);
b4.setBounds(230,150,60,20);
add(t1);
add(t2);
add(l1);
add(l2);
add(b1);
add(b2);
add(b3);
add(b4);
add(l3);
b1.addActionListener(new MyHandler());
b2.addActionListener(new MyHandler1());
b3.addActionListener(new MyHandler2());
b4.addActionListener(new MyHandler3());
}
public class MyHandler implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
Double a,b,s;
a=Double.parseDouble(t1.getText());
b=Double.parseDouble(t2.getText());
s=a+b;
l3.setText("Sum is "+s);
}
}
public class MyHandler1 implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
Double a,b,s;
a=Double.parseDouble(t1.getText());
b=Double.parseDouble(t2.getText());
s=a-b;
l3.setText("Subtraction is "+s);
}
}
public class MyHandler2 implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
Double a,b,s;
a=Double.parseDouble(t1.getText());
b=Double.parseDouble(t2.getText());
s=a*b;
l3.setText("Mul. is "+s);
}
}
public class MyHandler3 implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
Double a,b,s;
a=Double.parseDouble(t1.getText());
b=Double.parseDouble(t2.getText());
s=a/b;
l3.setText("Div. is "+s);
}
}
Thread t3,t4;
public void start()
{
t3=new Thread(this);
t3.start();
}
public void run()
{
t4=Thread.currentThread();
while(t4==t3)
{
repaint();
try{
t4.sleep(1000);
}
catch(InterruptedException e)
{}
}
}
public void paint(Graphics g){
Calendar cal=new GregorianCalendar();
String hour=String.valueOf(cal.get(Calendar.HOUR));
String minute=String.valueOf(cal.get(Calendar.MINUTE));
String second=String.valueOf(cal.get(Calendar.SECOND));
g.drawString("GANAK YANTRA.         "+"Time: "+hour+":"+minute+":"+second,20,20);
}
}