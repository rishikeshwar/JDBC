import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;

import java.applet.*;  

public class Billing extends Applet implements ItemListener,ActionListener {
	int Total=0,sz=0;
	double Tax=0,Bill;
	Choice c,c1,c2,c3,c4,c5,c6,c7;
	
	
	String s,size;
	int cash,i=101;
	CheckboxGroup g1;
	Checkbox cc1,cc2,cc3;
	Checkbox cv1,cv2,cv3,cv4,cn1,cn2,cn3,cn4,ec,d,d1,d2,d3;
	Checkbox dd1,dd2,dd3;
	Checkbox ddd1,ddd2,ddd3;

	TextField total,tax,bill,cashr,rcash;
	Button b1,b2,b3;
	Label l3;
	Label tot=new Label(""); 
	Label taxx=new Label(""); 
	Label billamt=new Label("");
	Label returnamt=new Label("");
	
	//Label background=new Label(new ImageIcon("Pizza.jpg"));

	
 public void init()
 { 
	 setSize(1920,1080);
	 setBackground(Color.cyan);
	 
	 Font myfont=new Font("a",Font.BOLD,40);
	 Font myfont1=new Font("a",Font.BOLD,20);
	 Font myfont2=new Font("a",Font.BOLD,35);
	 Font myfont3=new Font("a",Font.BOLD,20);
	 
	


	 
	 c=new Choice();
	 c.addItem("Select");
	 c.addItem("1");
	 c.addItem("2");
	 c1=new Choice();
	 c1.addItem("Select");
	 c1.addItem("1");
	 c1.addItem("2");
	 c2=new Choice();
	 c2.addItem("Select");
	 c2.addItem("1");
	 c2.addItem("2");
	 c3=new Choice();
	 c3.addItem("Select");
	 c3.addItem("1");
	 c3.addItem("2");
	 c4=new Choice();
	 c4.addItem("Select");
	 c4.addItem("1");
	 c4.addItem("2");
	 c5=new Choice();
	 c5.addItem("Select");
	 c5.addItem("1");
	 c5.addItem("2");
	 c6=new Choice();
	 c6.addItem("Select");
	 c6.addItem("1");
	 c6.addItem("2");
	 c7=new Choice();
	 c7.addItem("Select");
	 c7.addItem("1");
	 c7.addItem("2");
	 
	 setLayout(new GridLayout(15,6));
	 
	 add(new Label(" "));
	 add(new Label(" "));
	 Label l1=new Label("                PIZZA ");
	 Label l2=new Label("DEN ");
	 l1.setFont(myfont);
	 add(l1);
	 l2.setFont(myfont);
	 add(l2);
	 
	 Label l4=new Label("                       Bill No: ");
	 l4.setFont(myfont3);
	 add(l4);
	// add(new Label( "                                                   Bill No: "));
	 	 l3=new Label(i+" ");
		 l3.setFont(myfont3);

	 add(l3);
	 cv1=new Checkbox("Veggie Suprise" );
	 cv1.setFont(myfont1);
	 add(cv1);
	 c.setFont(myfont1);
	 add(c);
	 cv1.addItemListener(this);
	 add(cv1);
	 add(c);
	 add(new Label(" "));
	 add(new Label(" "));
	 add(new Label(" "));
	 add(new Label(" "));
	 cv2=new Checkbox("Panner Delight");
	 cv2.setFont(myfont1);

	 add(cv2);
	 c1.setFont(myfont1);
	 add(c1);
	 cv2.addItemListener(this);
	 add(cv2);
	 add(c1);
	 add(new Label(" ")); 
	 g1=new CheckboxGroup();
	 cc1=new Checkbox("Small",g1,true);
	 cc1.setFont(myfont3);

	 cc2=new Checkbox("Medium",g1,false);
	 cc2.setFont(myfont3);

	 cc3=new Checkbox("Large",g1,false);
	 cc3.setFont(myfont3);

	 add(cc1);
	 add(cc2);
	 add(cc3);
	 cc1.addItemListener(this);
	 cc2.addItemListener(this);
	 cc3.addItemListener(this);
	 cv3=new Checkbox("Country Feast");
	 cv3.setFont(myfont1);

	 add(cv3);
	 c2.setFont(myfont1);
	 add(c2);
	 cv3.addItemListener(this);
	 add(cv3);
	 c2.setFont(myfont1);

	 add(c2);
	 add(new Label(" "));
	 add(new Label(" "));
	 add(new Label(" "));
	 add(new Label(" "));
	 cv4=new Checkbox("Exotic");
	 cv4.setFont(myfont1);
	 add(cv4);
	 c3.setFont(myfont1);
	 
	 add(c3);
	 cv4.addItemListener(this);
	 add(cv4);
	 add(c3);
	 add(new Label(" "));
	 d=new Checkbox("Take Away");
	 d.setFont(myfont3);

	 add(d);
	 d.addItemListener(this);
	 add(d);
	 ec=new Checkbox("Extra Cheese" );
	 ec.setFont(myfont3);

	 add(ec);
	 ec.addItemListener(this);
	 add(ec);
	 add(new Label(" "));
	 add(new Label(" "));
	 add(new Label(" "));
	 add(new Label(" "));
	 add(new Label(" "));
	 add(new Label(" "));
	 add(new Label(" "));
	 cn1=new Checkbox("Tikka Treat");
	 cn1.setFont(myfont1);

	 add(cn1);
	 c4.setFont(myfont1);

	 add(c4);
	 cn1.addItemListener(this);
	 add(cn1);
	 add(c4);
	 add(new Label(" "));
	 
	 Label l5=new Label("Drinks");
	 l5.setFont(myfont2);

	 add(l5);
	 //add(new Label("Drinks"));
	 
	 Label l11=new Label("Milkshakes");
	 l11.setFont(myfont2);
	 add(l11);
	 
	 Label l12=new Label("Krushers");
	 l12.setFont(myfont2);
	 add(l12);
	 
	 //add(new Label(" "));
	 //add(new Label(" "));
	 cn2=new Checkbox("Chicken Italiano");
	 cn2.setFont(myfont1);

	 add(cn2);
	 c5.setFont(myfont1);

	 add(c5);
	 cn2.addItemListener(this);
	 add(cn2);
	 add(c5);
	 add(new Label(" "));
	 
	 d1=new Checkbox("Coke");
	 d1.setFont(myfont3);
	 add(d1);
	 d1.addItemListener(this);
	 add(d1);
	 
	 
	 dd1=new Checkbox("Chocolash");
	 dd1.setFont(myfont3);
	 add(dd1);
	 dd1.addItemListener(this);
	 add(dd1);
	 
	 
	 ddd1=new Checkbox("Cookies n Creme");
	 ddd1.setFont(myfont3);
	 add(ddd1);
	 ddd1.addItemListener(this);
	 add(ddd1);	 
	 
	 
	 //add(new Label(" "));
	// add(new Label(" "));
	 cn3=new Checkbox("Ultimate Chicken");
	 cn3.setFont(myfont1);

	 add(cn3);
	 c6.setFont(myfont1);

	 add(c6);
	 cn3.addItemListener(this);
	 add(cn3);
	 add(c6);
	 add(new Label(" "));
	 d2=new Checkbox("7up");
	 d2.setFont(myfont3);
	 add(d2);
	 d2.addItemListener(this);
	 add(d2);
	 
	 
	 dd2=new Checkbox("Strawberry Storm");
	 dd2.setFont(myfont3);
	 add(dd2);
	 dd2.addItemListener(this);
	 add(dd2);
	 
	 ddd2=new Checkbox("Choco-Peanut Bolt");
	 ddd2.setFont(myfont3);
	 add(ddd2);
	 ddd2.addItemListener(this);
	 add(ddd2);	 
	 
	 //add(new Label(" "));
	 //add(new Label(" "));
	 cn4=new Checkbox("Classic Chicken");
	 cn4.setFont(myfont1);

	 add(cn4);
	 c7.setFont(myfont1);

	 add(c7);
	 cn4.addItemListener(this);
	 add(cn4);
	 add(c7);
	 add(new Label(" "));
	 
	 
	 d3=new Checkbox("RedBull");
	 d3.setFont(myfont3);
	 add(d3);
	 d3.addItemListener(this);
	 add(d3);
	 
	 
	 dd3=new Checkbox("Alphonso Burst");
	 dd3.setFont(myfont3);
	 add(dd3);
	 dd3.addItemListener(this);
	 add(dd3);
	 
	 ddd3=new Checkbox("Cruchie Cornetto");
	 ddd3.setFont(myfont3);
	 add(ddd3);
	 ddd3.addItemListener(this);
	 add(ddd3);	 
	 
	 
	 //add(new Label(" "));
	 //add(new Label(" "));
	 add(new Label(" "));
	 add(new Label(" "));
	 add(new Label(" "));
	 add(new Label(" "));
	 add(new Label(" "));
	 add(new Label(" "));
	 
	 Label l6=new Label("                TOTAL: ");
	 l6.setFont(myfont2);

	 add(l6);

	 //add(new Label("Total"));
	 
	 tot.setFont(myfont2);
	 add(tot);
	 
	 //total=new TextField();
	 //add(total);
	 
	 
	 Label l7=new Label("                   Tax: ");
	 l7.setFont(myfont2);

	 add(l7);
	 //add(new Label("           Tax"));
	 
	 add(taxx);
	 taxx.setFont(myfont2);
	 //tax=new TextField();
	 //add(tax);
	 
	 
	 Label l8=new Label("       Bill Amount: ");
	 l8.setFont(myfont2);
	 add(l8);

	 //add(new Label("           Bill Amount"));
	 billamt.setFont(myfont2);
	 add(billamt);
	 //bill=new TextField();
	 //add(bill);
	 
	 add(new Label(" "));
	 add(new Label(" "));
	 add(new Label(" "));
	 add(new Label(" "));
	 add(new Label(" "));
	 add(new Label(" "));
	 
	 Label l9=new Label("       Cash Recieved: ");
	 l9.setFont(myfont3);
	 add(l9);
	 
	 //add(new Label("Cash Recieved"));
	 cashr=new TextField();
	 cashr.setFont(myfont2);
	 add(cashr);
	 cashr.addActionListener(this);
	 add(cashr);
	 add(new Label(" "));
	 add(new Label(" "));
	 b1=new Button("CONTINUE");
	 b1.setFont(myfont1);
	 add(b1);
	 b1.addActionListener(this);
	 add(b1);
	 b2=new Button("OK");
	 b2.setFont(myfont1);

	 add(b2);
	 b2.addActionListener(this);
	 add(b2);
	 
	 Label l10=new Label("           Return Cash: ");
	 l10.setFont(myfont3);
	 add(l10);
	 
	 //add(new Label("Return Cash"));
	 returnamt.setFont(myfont2);
	 add(returnamt);
	 //rcash=new TextField();
	 //add(rcash);
	 
	 //rcash.addActionListener(this);
	// add(rcash);
	 b3=new Button("Balance");
	 b3.setFont(myfont1);

	 add(b3);
	 b3.addActionListener(this);
	 add(b3);
	 add(new Label(" "));
	 add(new Label(" "));
	 add(new Label(" "));
 }
 
 public void itemStateChanged(ItemEvent e)
 {
	 int q;
	 if(e.getSource()==(cv1) || e.getSource()==c )
     {
		 if(cv1.getState()==true)
		   {
			 q=c.getSelectedIndex();
	         Total+=60*((q-1)+1);
	         //total.setText(Total+"");   
	 		 repaint();
		   }
		 else if(cv1.getState()==false)
		 {
			 q=c.getSelectedIndex();
	           Total-=60*((q-1)+1);
	         //total.setText(Total+""); 
	         repaint();
		 }
		  
     }	
 
	 if(e.getSource()==(cv2) || e.getSource()==c1 )
     {
		 if(cv2.getState()==true)
		   {
			 q=c1.getSelectedIndex();
	         Total+=65*((q-1)+1);
	         //total.setText(Total+"");   
	 		 repaint();
		   }
		 else if(cv2.getState()==false)
		 {
			 q=c1.getSelectedIndex();
	           Total-=65*((q-1)+1);
	         //total.setText(Total+""); 
	         repaint();
		 }
		  
     }	
	 
	 if(e.getSource()==(cv3) || e.getSource()==c2 )
     {
		 if(cv3.getState()==true)
		   {
			 q=c2.getSelectedIndex();
	         Total+=70*((q-1)+1);
	         //total.setText(Total+"");   
	 		 repaint();
		   }
		 else if(cv3.getState()==false)
		 {
			 q=c2.getSelectedIndex();
	           Total-=70*((q-1)+1);
	         //total.setText(Total+""); 
	         repaint();
		 }
		  
     }	
	 
	 if(e.getSource()==(cv4) || e.getSource()==c3 )
     {
		 if(cv4.getState()==true)
		   {
			 q=c3.getSelectedIndex();
	         Total+=75*((q-1)+1);
	         //total.setText(Total+"");   
	 		 repaint();
		   }
		 else if(cv4.getState()==false)
		 {
			 q=c3.getSelectedIndex();
	           Total-=75*((q-1)+1);
	         //total.setText(Total+""); 
	         repaint();
		 }
		  
     }	
	
	 if(e.getSource()==(cn1) || e.getSource()==c4 )
     {
		 if(cn1.getState()==true)
		   {
			 q=c4.getSelectedIndex();
	         Total+=80*((q-1)+1);
	         //total.setText(Total+"");   
	 		 repaint();
		   }
		 else if(cn1.getState()==false)
		 {
			 q=c4.getSelectedIndex();
	           Total-=80*((q-1)+1);
	         //total.setText(Total+""); 
	         repaint();
		 }
		  
     }	
	 if(e.getSource()==(cn2) || e.getSource()==c5 )
     {
		 if(cn2.getState()==true)
		   {
			 q=c5.getSelectedIndex();
	         Total+=85*((q-1)+1);
	         //total.setText(Total+"");   
	 		 repaint();
		   }
		 else if(cn2.getState()==false)
		 {
			 q=c5.getSelectedIndex();
	           Total-=85*((q-1)+1);
	         //total.setText(Total+""); 
	         repaint();
		 }
		  
     }	
	 if(e.getSource()==(cn3) || e.getSource()==c6 )
     {
		 if(cn3.getState()==true)
		   {
			 q=c6.getSelectedIndex();
	         Total+=90*((q-1)+1);
	         //total.setText(Total+"");   
	 		 repaint();
		   }
		 else if(cn3.getState()==false)
		 {
			 q=c6.getSelectedIndex();
	           Total-=90*((q-1)+1);
	         //total.setText(Total+""); 
	         repaint();
		 }
		  
     }	
	 if(e.getSource()==(cn4) || e.getSource()==c7 )
     {
		 if(cn4.getState()==true)
		   {
			 q=c7.getSelectedIndex();
	         Total+=95*((q-1)+1);
	         //total.setText(Total+"");   
	 		 repaint();
		   }
		 else if(cn4.getState()==false)
		 {
			 q=c7.getSelectedIndex();
	           Total-=95*((q-1)+1);
	         //total.setText(Total+""); 
	         repaint();
		 }
		  
     }	
	 if(e.getSource()==ec)
	 {
		 if(ec.getState()==true)
		 {
			 Total+=20;
			 repaint();
		 }
		 else if(ec.getState()==false)
		 {
			 Total-=20;
			 repaint();
		 }
	 }
	 
	 if(e.getSource()==d)
	 {
		 if(d.getState()==true)
		 {
			 Total+=100;
			 repaint();
		 }
		 else if(d.getState()==false)
		 {
			 Total-=100;
			 repaint();
		 }
	 }
	 
	 if(e.getSource()==d1)
	 {
		 if(d1.getState()==true)
		 {
			 Total+=30;
			 repaint();
		 }
		 else if(d1.getState()==false)
		 {
			 Total-=30;
			 repaint();
		 }
	 }
	 else if(e.getSource()==d2)
	 {
		 if(d2.getState()==true)
		 {
			 Total+=40;
			 repaint();
		 }
		 else if(d2.getState()==false)
		 {
			 Total-=40;
			 repaint();
		 }
	 }
	 else if(e.getSource()==d3)
	 {
		 if(d3.getState()==true)
		 {
			 Total+=100;
			 repaint();
		 }
		 else if(d3.getState()==false)
		 {
			 Total-=100;
			 repaint();
		 }
	 }
	 
	 
	 
	 
	 if(e.getSource()==dd1)
	 {
		 if(dd1.getState()==true)
		 {
			 Total+=70;
			 repaint();
		 }
		 else if(dd1.getState()==false)
		 {
			 Total-=70;
			 repaint();
		 }
	 }
	 else if(e.getSource()==dd2)
	 {
		 if(dd2.getState()==true)
		 {
			 Total+=80;
			 repaint();
		 }
		 else if(dd2.getState()==false)
		 {
			 Total-=80;
			 repaint();
		 }
	 }
	 else if(e.getSource()==dd3)
	 {
		 if(dd3.getState()==true)
		 {
			 Total+=90;
			 repaint();
		 }
		 else if(dd3.getState()==false)
		 {
			 Total-=90;
			 repaint();
		 }
	 }
	 
	 
	 
	 if(e.getSource()==ddd1)
	 {
		 if(ddd1.getState()==true)
		 {
			 Total+=100;
			 repaint();
		 }
		 else if(ddd1.getState()==false)
		 {
			 Total-=100;
			 repaint();
		 }
	 }
	 else if(e.getSource()==ddd2)
	 {
		 if(ddd2.getState()==true)
		 {
			 Total+=110;
			 repaint();
		 }
		 else if(ddd2.getState()==false)
		 {
			 Total-=110;
			 repaint();
		 }
	 }
	 else if(e.getSource()==ddd3)
	 {
		 if(ddd3.getState()==true)
		 {
			 Total+=120;
			 repaint();
		 }
		 else if(ddd3.getState()==false)
		 {
			 Total-=120;
			 repaint();
		 }
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 if(e.getSource()==cc1 || e.getSource()==cc2|| e.getSource()==cc3 )
	 {
		 size=g1.getSelectedCheckbox().getLabel();
		 if(size=="Small")
		 {
			 Total*=1;
			 repaint();
		 }
		 else if(size=="Medium")
		 {
			 Total/=1;
			 Total*=1.5;
			 repaint();
		 }
		  else if(size=="Large")
		 {
			  Total/=1;
			  Total*=2;
			  repaint();
		 }
	 }
	 
 }
 

public void paint(Graphics g)
{
	Tax=(12.5/100)*Total;
	tot.setText(Total+"");
	//total.setText(Total+"");
	taxx.setText(Tax+"");
	//tax.setText(Tax+"");
}

public void actionPerformed(ActionEvent e) {
	 if(e.getSource()==b2)
     {
    	 Bill=Total+Tax;
    	 billamt.setText(Bill+"");
    	 //bill.setText(Bill+"");
    	 repaint();
     }
     if(e.getSource()==b1)
     {
    	 Bill=Tax=Total=0;
    	 billamt.setText("");

    	 //bill.setText("");
    	 cv1.setState(false);
    	 cv2.setState(false);
    	 cv3.setState(false);
    	 cv4.setState(false);
    	 cn1.setState(false);
    	 cn2.setState(false);
    	 cn3.setState(false);
    	 cn4.setState(false);
    	 returnamt.setText("");
    	 //rcash.setText("");
    	 cashr.setText("");
    	 ec.setState(false);
    	 d.setState(false);
    	 d1.setState(false);
    	 d2.setState(false);
    	 d3.setState(false);
    	 dd1.setState(false);
    	 dd2.setState(false);
    	 dd3.setState(false);
    	 ddd1.setState(false);
    	 ddd2.setState(false);
    	 ddd3.setState(false);
    	 
    	 i++;
    	 l3.setText(i+"");
    	 repaint();
     }
     
     if(e.getSource()==b3)
     {
 			String sy=cashr.getText();
 			cash=Integer.parseInt(sy);
 			returnamt.setText((int)(cash-Bill)+"");
 		    //rcash.setText((int)(cash-Bill)+"");
 		    
 	}
 	 
     }
	
}





