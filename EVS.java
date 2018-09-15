import java.awt.*; 
import java.awt.event.*;  
import javax.swing.*; 
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.text.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.Calendar;

class EVS extends Thread implements ActionListener{
	
	JFrame f;
	JDialog jd1,jd2,jd3,jd4,jds;
	JPanel mainPanel,title,p1,p11,p12,p13,p2,p21,p3,p31,p32,p33,p34,p35,p36,p4,p5,p51,p52,p53,p54,p6,p61,p62,p63,p7,p71,p72,p73,p74,p75,p76,p8,p81,p82,p83,p84,p85,p86,p87,p9,p91,p92,p93;
	JLabel mainLable,l1,l10,l11,l12,l13,l20,l21,l22,l23,l24,l25,l26,l27,l30,l31,l32,l33,l34,l35,l40,l41,l42,l43,l44,l45,l51,l52,l53,l54,l61,l62,l70,l71,l72,l73,l74,l75,l80,l81,l82,l83,l84,l85,l86,l90,l91,l92,l93,l94;
	JTextField tf1,tf3,tf4;
	JPasswordField tf2;
	JTextArea help;
	JButton jb11,jb12,jb21,jb22,jb31,jb32,jb41,jb51,jb61,jb62,jb71,jb72,jb81,jb82,jb91,jb92,sb;
	String AID,ANAME,ARATINA,ATHUMB,VID,VANO,VENO,VTIME,PARTY,VNAME,VRATINA,VTHUMB,VIDTYPE,VAGE,PNAME;
	JTable t1,t2,t3;
	int chk1A=0,chk2A=0,ALOGIN=0,APIN=0,VPIN,PCODE=0,CNO=0,VOTERLASTID=0,VOTEDLASTID=0,chkLogin=0;
	byte[] img;
	JCheckBox cb1,cb2,cb3,cb4,cb5,cb6;
	JToolBar bar;
	JButton bb1,bb2,bb3,bb4,next,prev;
	JProgressBar jp1,jp2,jp31,jp32;
	
	String VOTINGDATE="01-June-2016";
	int EVSSTATUS=100;
	
	//connection details
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		ResultSetMetaData md;
	
	
	public EVS(){
		
		connect();
		f=new JFrame("E-Voting Software");
		
		//titled
		
		title=new JPanel();
		l1=new JLabel("<html><p style='color: GRAY; font-size: 40px; width: 1100px; background-color:#00FFFF ; text-align:center;'>E-Voting Software</p></html>");
		title.add(l1);
		
		JPanel top=new JPanel(new BorderLayout());
		//top.add(title,BorderLayout.SOUTH);
		
		
		Font font = new Font("TimesRoman", Font.PLAIN, 25);
		Font font1 = new Font("TimesRoman", Font.PLAIN, 20);
		
		//---
		
		
		//jtoolbar ----
		
		bar = new JToolBar();
		
		next=new JButton();
		prev=new JButton();
		
		bb1=new JButton("Home");
		bb2=new JButton("System Status");
		bb3=new JButton("Help");
		bb4=new JButton("Authority Login");
		
		bb1.addActionListener(this);
		bb2.addActionListener(this);
		bb3.addActionListener(this);
		bb4.addActionListener(this);
		
		//button design
		bb1.setBackground(Color.orange);
		bb1.setForeground(Color.white);
		bb1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		bb1.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        bb1.setBackground(Color.GREEN);
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        bb1.setBackground(Color.ORANGE);
    }
	});
	
		bb2.setBackground(Color.orange);
		bb2.setForeground(Color.white);
		bb2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		bb2.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        bb2.setBackground(Color.GREEN);
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        bb2.setBackground(Color.ORANGE);
    }
	});
	
		bb3.setBackground(Color.orange);
		bb3.setForeground(Color.white);
		bb3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		bb3.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        bb3.setBackground(Color.GREEN);
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        bb3.setBackground(Color.ORANGE);
    }
	});
	
		bb4.setBackground(Color.orange);
		bb4.setForeground(Color.white);
		bb4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		bb4.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        bb4.setBackground(Color.GREEN);
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        bb4.setBackground(Color.ORANGE);
    }
	});
	
	//----------
		
		next.setIcon(new ImageIcon(new ImageIcon("Images/next.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		prev.setIcon(new ImageIcon(new ImageIcon("Images/prev.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
		
		next.addActionListener(this);
		prev.addActionListener(this);
		
		bar.add(next);
		bar.add(bb1);
		bar.add(bb2);
		bar.add(bb3);
		bar.add(bb4);
		bar.add(prev);
		
		bb1.setVisible(false);
		bb2.setVisible(false);
		bb3.setVisible(false);
		bb4.setVisible(false);
		prev.setVisible(false);
		
		bar.setFloatable( false);
		
		

		
		//-----------
		
		//dilag 1
		
		jd1=new JDialog(f,"Authority Login");
		jd1.setLayout(new BorderLayout());
		p1=new JPanel();
		p11=new JPanel();
		p12=new JPanel();
		p13=new JPanel();
		
		l10=new JLabel("<html><p style='color: RED; font-size: 20px; text-align: center; width: 500px; background-color:WHITE;'>Enter Login ID and Password.</p></html>");
		
		l11=new JLabel("Enter User ID: ");
		tf1= new JTextField();
		l12=new JLabel("Enter Password: ");
		tf2= new JPasswordField();
		tf2.setEchoChar('*');
		jb11=new JButton("Next");
		jb11.addActionListener(this);
		
		jb11.setBackground(Color.ORANGE);
		jb11.setForeground(Color.white);
		jb11.setFont(new Font("Arial", Font.PLAIN, 20));
		jb11.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		jb11.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent evt) {
        jb11.setBackground(Color.GREEN);
		}

		public void mouseExited(java.awt.event.MouseEvent evt) {
        jb11.setBackground(Color.ORANGE);
		}
		});
		
		l11.setFont(font);
		l12.setFont(font);
		 
		tf1.setFont(font);
		tf2.setFont(font);
		
		
		p11.add(l11);
		p11.add(tf1);
		
		p12.add(l12);
		p12.add(tf2);
	
		p11.setLayout(new GridLayout(1,2));
		p11.setBorder(new EmptyBorder(30, 0, 30, 0));
		
		p12.setLayout(new GridLayout(1,2));
		p12.setBorder(new EmptyBorder(30, 0, 30, 0));
		
		p13.add(p11);
		p13.add(p12);
		p13.setLayout(new GridLayout(2,1));
		p13.setBorder(new EmptyBorder(50, 10, 50, 10));
		
		//p1.add(l10,BorderLayout.NORTH);
		//p1.add(p13,BorderLayout.CENTER);
		//p1.add(jb11,BorderLayout.SOUTH);
		
		jd1.add(l10,BorderLayout.NORTH);
		jd1.add(p13,BorderLayout.CENTER);
		jd1.add(jb11,BorderLayout.SOUTH);
		
		jd1.setResizable(false);
		//jd1.setVisible(true);
		jd1.setSize(600,400);
		jd1.setLocationRelativeTo(f);
		
		//-----
		
		//Jdilog 2

		jd2=new JDialog(f,"Authority Login");
		
		p2=new JPanel();
		p21=new JPanel();
		
		l20=new JLabel("<html><p style='color: RED; font-size: 20px; text-align: center; width: 500px; background-color:WHITE;'>Yout Details</p></html>");
		
		jb21=new JButton("Back");
		jb22=new JButton("Next Step");
		jb21.addActionListener(this);
		jb22.addActionListener(this);
		
		jb21.setBackground(Color.ORANGE);
		jb21.setForeground(Color.white);
		jb21.setFont(new Font("Arial", Font.PLAIN, 20));
		jb21.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jb22.setBackground(Color.ORANGE);
		jb22.setForeground(Color.white);
		jb22.setFont(new Font("Arial", Font.PLAIN, 20));
		jb22.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		jb21.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent evt) {
        jb21.setBackground(Color.GREEN);
		}

		public void mouseExited(java.awt.event.MouseEvent evt) {
        jb21.setBackground(Color.ORANGE);
		}
		});
		
		jb22.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent evt) {
        jb22.setBackground(Color.GREEN);
		}

		public void mouseExited(java.awt.event.MouseEvent evt) {
        jb22.setBackground(Color.ORANGE);
		}
		});
		
		p21.add(jb21);
		p21.add(jb22);
		p21.setLayout(new GridLayout(1,2));
		
		jd2.add(l20,BorderLayout.NORTH);
		jd2.add(p21,BorderLayout.SOUTH);
		
		//jd2.setResizable(false);
		//jd2.setVisible(true);
		jd2.setVisible(false);
		
		
		//-----
		
		//jdilog 3
		
		jd2.dispose();
		jd3=new JDialog(f,"Authority Login");
		
		p3=new JPanel();
		p31=new JPanel();
		p32=new JPanel();
		p33=new JPanel();
		p34=new JPanel();
		p35=new JPanel();
		p36=new JPanel();
		
		l30=new JLabel("<html><p style='color: RED; font-size: 20px; text-align: center; width:500px;background-color:WHITE; '>Thumb and Ratina Scan</p></html>");
		l31=new JLabel("Thumb Scan: ");
		l32=new JLabel("Scaning");
		l33=new JLabel("Ratina Scan: ");
		l34=new JLabel("Scaning");
		
		l31.setFont(font);
		l32.setFont(font);
		l33.setFont(font);
		l34.setFont(font);
		
		//process panel
		jp31=new JProgressBar(0,100);
		jp31.setValue(0);
		jp31.setStringPainted(true);
		jp32=new JProgressBar(0,100);
		jp32.setValue(0);
		jp32.setStringPainted(true);
		
		//----
		
		
		jb31=new JButton("Back");
		jb32=new JButton("Next Step");
		jb31.addActionListener(this);
		jb32.addActionListener(this);
		jb32.setEnabled(false);
		
		//button color
		//31
		jb31.setBackground(Color.ORANGE);
		jb31.setForeground(Color.white);
		jb31.setFont(new Font("Arial", Font.PLAIN, 20));
		jb31.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		jb31.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent evt) {
        jb31.setBackground(Color.GREEN);
		}

		public void mouseExited(java.awt.event.MouseEvent evt) {
        jb31.setBackground(Color.ORANGE);
		}
		});
		
		//32
		jb32.setBackground(Color.ORANGE);
		jb32.setForeground(Color.white);
		jb32.setFont(new Font("Arial", Font.PLAIN, 20));
		jb32.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		jb32.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent evt) {
        jb32.setBackground(Color.GREEN);
		}

		public void mouseExited(java.awt.event.MouseEvent evt) {
        jb32.setBackground(Color.ORANGE);
		}
		});
	
		//----
		
		p31.add(jb31);
		p31.add(jb32);
		p31.setLayout(new GridLayout(1,2));
		
		p32.add(l31);
		p32.add(l32);
		p33.add(l33);
		p33.add(l34);
		p32.setLayout(new GridLayout(1,2));
		p33.setLayout(new GridLayout(1,2));
		p34.add(p32);
		p34.add(jp31);
		p34.add(new JLabel(""));
		p34.add(p33);
		p34.add(jp32);
		p34.setLayout(new GridLayout(5,1));
		
		
		
		p34.setBorder(new EmptyBorder(50, 20, 50, 20));
		
		jd3.add(l30,BorderLayout.NORTH);
		jd3.add(p34,BorderLayout.CENTER);
		jd3.add(p31,BorderLayout.SOUTH);
		
		jd3.setResizable(false);
		jd3.setSize(600,400);
		jd3.setLocationRelativeTo(f);
		
		jd3.setVisible(false);
		//----
		
		//jdilog 4

		jd3.dispose();
		jd4=new JDialog(f,"Authority Login");
		
		l40=new JLabel("<html><p style='color: RED; font-size: 20px; text-align: center; width:500px;background-color:WHITE; '>Access Success</p></html>");
		
		p4=new JPanel();
		l41=new JLabel("");
		l42=new JLabel("You are logged-in as an Admin.");
		l43=new JLabel("");
		l44=new JLabel("(If you need any help, click on Help Button.)");
		
		l45=new JLabel("Thank You");
		
		l41.setFont(font);
		l42.setFont(font);
		l43.setFont(font);
		l44.setFont(font1);
		l45.setFont(font);
		
		
		jb41=new JButton("Finish");
		jb41.addActionListener(this);
		
		jb41.setBackground(Color.ORANGE);
		jb41.setForeground(Color.white);
		jb41.setFont(new Font("Arial", Font.PLAIN, 20));
		jb41.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		jb41.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent evt) {
        jb41.setBackground(Color.GREEN);
		}

		public void mouseExited(java.awt.event.MouseEvent evt) {
        jb41.setBackground(Color.ORANGE);
		}
		});
		
		p4.add(l41);
		p4.add(l42);
		p4.add(l43);
		p4.add(l44);
		p4.add(l45);
		
		p4.setBackground(Color.WHITE);
		
		
		p4.setLayout(new GridLayout(5,1));
		p4.setBorder(new EmptyBorder(30, 30, 30, 30));
		
		jd4.add(l40,BorderLayout.NORTH);
		jd4.add(p4,BorderLayout.CENTER);
		jd4.add(jb41,BorderLayout.SOUTH);
		jd4.setResizable(false);
		//jd4.setVisible(true);
		jd4.setVisible(false);
		jd4.setSize(600,400);
		jd4.setLocationRelativeTo(f);
		
		//---
		
		//voter panel...
		//panel 5
		
		p5=new JPanel();
		p51=new JPanel();
		p52=new JPanel();
		p53=new JPanel();
		p54=new JPanel();
		
		l51=new JLabel("Enter Aadhaar Number:- ");
		tf3= new JTextField();
		l52=new JLabel("<html><p style='color: RED; font-size: 15px; text-align: center; width: 200px;'>OR</p></html>");
		l53=new JLabel("Enter Enrolment Number:-");
		tf4= new JTextField();
		jb51=new JButton("Next Step");
		jb51.addActionListener(this);
		
		//button color
		jb51.setBackground(Color.ORANGE);
		jb51.setForeground(Color.white);
		jb51.setFont(new Font("Arial", Font.PLAIN, 20));
		jb51.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		jb51.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent evt) {
        jb51.setBackground(Color.GREEN);
		}

		public void mouseExited(java.awt.event.MouseEvent evt) {
        jb51.setBackground(Color.ORANGE);
		}
		});
		//----
		
		p53.add(l51);
		p53.add(tf3);
		p53.setLayout(new GridLayout(1,2));
		
		p54.add(l53);
		p54.add(tf4);
		p54.setLayout(new GridLayout(1,2));
		
		p51.add(p53);
		p51.add(l52);
		p51.add(p54);
		
		p51.setLayout(new GridLayout(3,1));
		p51.setBorder(new EmptyBorder(100, 20, 100, 20));
	
		l54=new JLabel("<html><p style='color: RED; font-size: 25px; text-align: center; width: 700px; background-color:WHITE;'>Enter Voter ID</p></html>");

		p52.setLayout(new BorderLayout());
		p52.add(l54,BorderLayout.NORTH);
		p52.add(p51,BorderLayout.CENTER);
		p52.add(jb51,BorderLayout.SOUTH);
		
		p52.setBorder(new EmptyBorder(20, 20, 20, 20));
		p5.add(p52);
		//p5.setBorder(new MatteBorder(220, 250, 220, 250, Color.GRAY));  //Color.decode("#FF6600"), Color.decode("#00FF00")
		//p5.setPreferredSize(new Dimension (100,100));
		
		f.add(p5);
		
		l51.setFont(font);
		l52.setFont(font);
		l53.setFont(font);
		tf3.setFont(font);
		tf4.setFont(font);
		
		p5.setVisible(false);
		
		//-----
		
		//Panel 6
		
		p6=new JPanel();
		p61=new JPanel();
		p62=new JPanel();
		p63=new JPanel();
		
		p6.setLayout(new BorderLayout());
		
		l61=new JLabel("<html><p style='color: RED; font-size: 25px; text-align: center; width:750px; background-color: WHITE;'>Your Details</p></html>");
		jb61=new JButton("Back");
		jb62=new JButton("Next Step");
		jb61.addActionListener(this);
		jb62.addActionListener(this);
		
		//button color
		//61
		jb61.setBackground(Color.ORANGE);
		jb61.setForeground(Color.white);
		jb61.setFont(new Font("Arial", Font.PLAIN, 20));
		jb61.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		jb61.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent evt) {
        jb61.setBackground(Color.GREEN);
		}

		public void mouseExited(java.awt.event.MouseEvent evt) {
        jb61.setBackground(Color.ORANGE);
		}
		});
		
		//62
		jb62.setBackground(Color.ORANGE);
		jb62.setForeground(Color.white);
		jb62.setFont(new Font("Arial", Font.PLAIN, 20));
		jb62.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		jb62.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent evt) {
        jb62.setBackground(Color.GREEN);
		}

		public void mouseExited(java.awt.event.MouseEvent evt) {
        jb62.setBackground(Color.ORANGE);
		}
		});
	
		//----
		
		p61.add(jb61);
		p61.add(jb62);
		p61.setLayout(new GridLayout(1,2));
		
		p63.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		//go to action 
		
		//-----------
		
		//panel 7
		
		p7=new JPanel();
		p71=new JPanel();
		p72=new JPanel();
		p73=new JPanel();
		p74=new JPanel();
		p75=new JPanel();
		p76=new JPanel();
		
		l70=new JLabel("<html><p style='color: RED; font-size: 25px; text-align: center; width:750px;background-color:WHITE; '>Thumb and Ratina Scan</p></html>");
		l71=new JLabel("Thumb Scan: ");
		l72=new JLabel("Scaning");
		l73=new JLabel("Ratina Scan: ");
		l74=new JLabel("Scaning");
		
		l71.setFont(font);
		l72.setFont(font);
		l73.setFont(font);
		l74.setFont(font);
		
		//process panel
		jp1=new JProgressBar(0,100);
		jp1.setValue(0);
		jp1.setStringPainted(true);
		jp2=new JProgressBar(0,100);
		jp2.setValue(0);
		jp2.setStringPainted(true);
		
		//----
		
		
		jb71=new JButton("Back");
		jb72=new JButton("Next Step");
		jb71.addActionListener(this);
		jb72.addActionListener(this);
		jb72.setEnabled(false);
		
		//button color
		//71
		jb71.setBackground(Color.ORANGE);
		jb71.setForeground(Color.white);
		jb71.setFont(new Font("Arial", Font.PLAIN, 20));
		jb71.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		jb71.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent evt) {
        jb71.setBackground(Color.GREEN);
		}

		public void mouseExited(java.awt.event.MouseEvent evt) {
        jb71.setBackground(Color.ORANGE);
		}
		});
		
		//72
		jb72.setBackground(Color.ORANGE);
		jb72.setForeground(Color.white);
		jb72.setFont(new Font("Arial", Font.PLAIN, 20));
		jb72.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		jb72.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent evt) {
        jb72.setBackground(Color.GREEN);
		}

		public void mouseExited(java.awt.event.MouseEvent evt) {
        jb72.setBackground(Color.ORANGE);
		}
		});
	
		//----
		
		p71.add(jb71);
		p71.add(jb72);
		p71.setLayout(new GridLayout(1,2));
		
		p72.add(l71);
		p72.add(l72);
		p73.add(l73);
		p73.add(l74);
		p72.setLayout(new GridLayout(1,2));
		p73.setLayout(new GridLayout(1,2));
		p74.add(p72);
		p74.add(jp1);
		p74.add(new JLabel(""));
		p74.add(p73);
		p74.add(jp2);
		p74.setLayout(new GridLayout(5,1));
		
		
		
		p74.setBorder(new EmptyBorder(50, 20, 50, 20));
		
		p7.setLayout(new BorderLayout());
		
		p7.add(l70,BorderLayout.NORTH);
		p7.add(p74,BorderLayout.CENTER);
		p7.add(p71,BorderLayout.SOUTH);
		
		//p7.setBorder(new MatteBorder(250, 300, 250, 300, Color.GRAY));
		//p7.setPreferredSize(new Dimension (100,100));
		
		p7.setBorder(new EmptyBorder(20, 20, 20, 20));
		p7.setVisible(false);
		
		
		//----
		
		//panel 8----
		
		p8=new JPanel();
		p81=new JPanel();
		p82=new JPanel();
		p83=new JPanel();
		p84=new JPanel();
		p85=new JPanel();
		p86=new JPanel();
		p87=new JPanel();
		
		l80=new JLabel("<html><p style='color: RED; font-size: 20px; text-align: center; width:750px; background-color:WHITE; '>Select A Party for Vote</p></html>");
		
		jb81=new JButton("Back");
		jb82=new JButton("Next Step");
		
		p81.add(jb81);
		jb81.addActionListener(this);
		p81.add(jb82);
		jb82.addActionListener(this);
		jb82.setEnabled(false);
		p81.setLayout(new GridLayout(1,2));
		
		//button color
		//81
		jb81.setBackground(Color.ORANGE);
		jb81.setForeground(Color.white);
		jb81.setFont(new Font("Arial", Font.PLAIN, 20));
		jb81.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		jb81.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent evt) {
        jb81.setBackground(Color.GREEN);
		}

		public void mouseExited(java.awt.event.MouseEvent evt) {
        jb81.setBackground(Color.ORANGE);
		}
		});
		
		//82
		jb82.setBackground(Color.ORANGE);
		jb82.setForeground(Color.white);
		jb82.setFont(new Font("Arial", Font.PLAIN, 20));
		jb82.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		jb82.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent evt) {
        jb82.setBackground(Color.GREEN);
		}

		public void mouseExited(java.awt.event.MouseEvent evt) {
        jb82.setBackground(Color.ORANGE);
		}
		});
		//------
		
	Border border = BorderFactory.createLineBorder(Color.RED, 2);

		
		l81=new JLabel();
		l81.setIcon(new ImageIcon(new ImageIcon("party01.jpg").getImage().getScaledInstance(500, 100, Image.SCALE_DEFAULT)));
		
		l82=new JLabel();
		l82.setIcon(new ImageIcon(new ImageIcon("party02.jpg").getImage().getScaledInstance(500, 100, Image.SCALE_DEFAULT)));
		
		l83=new JLabel();
		l83.setIcon(new ImageIcon(new ImageIcon("party03.jpg").getImage().getScaledInstance(500, 100, Image.SCALE_DEFAULT)));
		
		l84=new JLabel();
		l84.setIcon(new ImageIcon(new ImageIcon("party04.jpg").getImage().getScaledInstance(500, 100, Image.SCALE_DEFAULT)));
		
		l85=new JLabel();
		l85.setIcon(new ImageIcon(new ImageIcon("party04.jpg").getImage().getScaledInstance(500, 100, Image.SCALE_DEFAULT)));

		
		ButtonGroup cbg = new ButtonGroup();
	
		 cb1 = new JCheckBox();
		 cb2 = new JCheckBox();
		 cb3 = new JCheckBox();
		 cb4 = new JCheckBox();
		 cb5 = new JCheckBox();
		
		//cb1.setBounds(100,100,100,100);
		cb1.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		cb1.addActionListener(this);
		cb2.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		cb2.addActionListener(this);
		cb3.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		cb3.addActionListener(this);
		cb4.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		cb4.addActionListener(this);
		cb5.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		cb5.addActionListener(this);
		
		cbg.add(cb1);
		cbg.add(cb2);
		cbg.add(cb3);
		cbg.add(cb4);
		cbg.add(cb5);
		
		
		
		//cb1.setMinimumSize(new Dimension(100,100));
		
		p83.setLayout(new BorderLayout());
		p84.setLayout(new BorderLayout());
		p85.setLayout(new BorderLayout());
		p86.setLayout(new BorderLayout());
		p87.setLayout(new BorderLayout());
		
		p83.add(l81,BorderLayout.CENTER);
		p83.add(cb1,BorderLayout.EAST);
		p83.setBorder(border);
		
		p84.add(l82,BorderLayout.CENTER);
		p84.add(cb2,BorderLayout.EAST);
		p84.setBorder(border);
		
		p85.add(l83,BorderLayout.CENTER);
		p85.add(cb3,BorderLayout.EAST);
		p85.setBorder(border);
		
		p86.add(l84,BorderLayout.CENTER);
		p86.add(cb4,BorderLayout.EAST);
		p86.setBorder(border);
		
		p87.add(l85,BorderLayout.CENTER);
		p87.add(cb5,BorderLayout.EAST);
		p87.setBorder(border);
		
		p82.add(p83);
		p82.add(p84);
		p82.add(p85);
		p82.add(p86);
		//p82.add(p87);
		
		p82.setLayout(new GridLayout(4,1));
		p82.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		p8.setLayout(new BorderLayout());
		p8.add(p82,BorderLayout.CENTER);
		p8.add(p81,BorderLayout.SOUTH);
		p8.add(l80,BorderLayout.NORTH);
		p8.setBorder(new EmptyBorder(10, 10, 10, 10));
		 
		//p8.setBorder(new MatteBorder(50, 250, 50, 250, Color.GRAY));
		//p8.setPreferredSize(new Dimension (200,400));
		
		p8.setVisible(false);
	
		//----------
		
		//panel 9----
		
		p9=new JPanel();
		p91=new JPanel();
		p92=new JPanel();
		p93=new JPanel();
		
		l90=new JLabel("<html><p style='color: RED; font-size: 25px; text-align: center; width:750px; background-color: WHITE; '>Successfully Voted</p></html>");
		
		l91=new JLabel("");
		l92=new JLabel("");
		l93=new JLabel("( Click on Finish button if you have voted correctly else for changing your opinions, click on Edit Vote option)");
		l94=new JLabel("Voting is your Right. If you know anyone who has not come for voting then ask him/her for voting. -Thank You");
		l91.setFont(font);
		l92.setFont(font);
		l93.setFont(font1);
		l94.setFont(font1);
		
		
		jb91=new JButton("Edit Vote");
		jb92=new JButton("Finish");
		
		
		p91.add(jb91);
		p91.add(jb92);
		jb91.addActionListener(this);
		jb92.addActionListener(this);
		p91.setLayout(new GridLayout(1,2));
		
		//button color
		//91
		jb91.setBackground(Color.ORANGE);
		jb91.setForeground(Color.white);
		jb91.setFont(new Font("Arial", Font.PLAIN, 20));
		jb91.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		jb91.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent evt) {
        jb91.setBackground(Color.GREEN);
		}

		public void mouseExited(java.awt.event.MouseEvent evt) {
        jb91.setBackground(Color.ORANGE);
		}
		});
		
		//92
		jb92.setBackground(Color.ORANGE);
		jb92.setForeground(Color.white);
		jb92.setFont(new Font("Arial", Font.PLAIN, 20));
		jb92.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		jb92.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent evt) {
        jb92.setBackground(Color.GREEN);
		}

		public void mouseExited(java.awt.event.MouseEvent evt) {
        jb92.setBackground(Color.ORANGE);
		}
		});
		//------
		
		p92.add(l91);
		p92.add(l92);
		p92.add(l93);
		p92.add(l94);
		p92.setLayout(new GridLayout(4,1));
		
		p92.setBackground(Color.WHITE);
		p92.setBorder(new EmptyBorder(100, 40, 100, 40));
		
		p93.setLayout(new BorderLayout());
		p93.add(l90,BorderLayout.NORTH);
		p93.add(p92,BorderLayout.CENTER);
		p93.add(p91,BorderLayout.SOUTH);
		p93.setBorder(new EmptyBorder(20, 20, 20, 20));
		p9.add(p93);
		//p9.setBorder(new MatteBorder(200, 250, 200, 250, Color.GRAY));
		p9.setVisible(false);
		//p9.setPreferredSize(new Dimension (100,100));
		
		//----------
		
		//Frame effects...
		
		
		JLabel f1=new JLabel(new ImageIcon(new ImageIcon("Images/f1.jpg").getImage().getScaledInstance(1400, 100, Image.SCALE_DEFAULT)));
		JLabel f2=new JLabel(new ImageIcon(new ImageIcon("Images/f2.jpg").getImage().getScaledInstance(1400, 100, Image.SCALE_DEFAULT)));
		JLabel f3=new JLabel(new ImageIcon(new ImageIcon("Images/f3.jpg").getImage().getScaledInstance(200, 520, Image.SCALE_DEFAULT)));
		JLabel f4=new JLabel(new ImageIcon(new ImageIcon("Images/f4.jpg").getImage().getScaledInstance(200, 520, Image.SCALE_DEFAULT)));
		
		JPanel upper= new JPanel();
		upper.setLayout(new BorderLayout());
		upper.add(bar,BorderLayout.NORTH);
		upper.add(f1,BorderLayout.CENTER);
		
		mainPanel=new JPanel();
		mainLable= new JLabel(new ImageIcon(new ImageIcon("Images/vote.jpg").getImage().getScaledInstance(1100, 500, Image.SCALE_DEFAULT)));
		mainPanel.add(mainLable);
		
		f.add(upper,BorderLayout.NORTH);
		f.add(f2,BorderLayout.SOUTH);
		f.add(f3,BorderLayout.WEST);
		f.add(mainPanel);
		f.add(f4,BorderLayout.EAST);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		//f.setSize(800,600);
		f.setExtendedState(6);
		f.setResizable(false);
		//----
		
		
	}

 
	
public void actionPerformed(ActionEvent e){
	
	if(e.getSource()==jb11){
		String PASS="";
		String fn="",mn="",ln="",gn="",s="",d="",al1="",al2="",as="",ad="",rat="",thu="",addr="";
		int ap=0,cn=0,chkId=0;
		System.out.println("Button 1");
		
		AID= tf1.getText();					//ABCD1234ABCD
		//AID="ABCD1234ABCD";
		String NPASS= tf2.getText();
		//String NPASS="12345";
		System.out.println(AID+NPASS);
		
		
		try{
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("select PASS from Authority where ID='"+AID+"'");
			
			if (!myRs.isBeforeFirst() ) {
			chkId=0;
			}
			
			while(myRs.next()){
				PASS= myRs.getString("PASS");
				System.out.println(PASS);
				chkId=1;
			}
			
			
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		if(chkId==1){
			
		if(NPASS.equals(PASS)){
			jd1.dispose();
			jd2.setVisible(true);
			System.out.println("Equals");
			
			//table for 2nd jdilog
			try{
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("select * from Authority where ID='"+AID+"'");
			md=myRs.getMetaData();
			int columnCount = md.getColumnCount();
			
			while(myRs.next()){
				fn= myRs.getString("FNAME");
				mn= myRs.getString("MNAME");
				ln= myRs.getString("MNAME");
				gn= myRs.getString("GNAME");
				s= myRs.getString("SEX");
				d= myRs.getString("DOB");
				al1= myRs.getString("ALINE1");
				al2= myRs.getString("ALINE2");
				as= myRs.getString("ASTATE");
				ad= myRs.getString("ADIST");
				ap= myRs.getInt("APIN");
				rat= myRs.getString("RATINA");
				thu= myRs.getString("THUMB");
				cn= myRs.getInt("CNO");
				//System.out.println(fn+mn+ln+gn+s+d+al1+al2+as+ad+ap+rat+thu+cn);
			}
	
			}
			catch(Exception ex){
			System.out.println(ex);
			}
			
			
			ANAME=fn+" "+mn+" "+ln;
			ARATINA=rat;
			ATHUMB=thu;
			addr=al1+" "+al2;
			APIN=ap;
			CNO= cn;
			
			String col[]={"Name","Details"};
			String row[][]={{"Name",ANAME},{"Guardian Name",gn},{"SEX",s},{"DOB",d},{"Address",addr},{"State",as},{"Dist",ad},{"Pin",""+ap},{"Center No.",""+cn}};
			t1=new JTable(row,col);
			
			t1.setFont(new Font("Serif", Font.PLAIN, 20));
			t1.setRowHeight(30);
			t1.setEnabled(false);
			t1.setBorder(new EmptyBorder(10, 10, 10, 10));
			
			jd2.add(t1,BorderLayout.CENTER);
			jd2.setSize(600,400);
			jd2.setLocationRelativeTo(f);
			
			
		}
		else{
			System.out.println("not Equals");
			JOptionPane.showMessageDialog(f, "ID and Password not match","", JOptionPane.ERROR_MESSAGE);
		}
		
		}
		else{
			System.out.println("Id not found");
			JOptionPane.showMessageDialog(f, "ID is Incorrect.","ID not found", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	if(e.getSource()==jb21){
		jd2.dispose();
		jd1.setVisible(true);
	}
		if(e.getSource()==jb22){
			System.out.println("Button 2");
			
			String s1="ABCD1234ABCD";
			String s2="EFGH5678EFGH";
			
			jd2.dispose();
			jd3.setVisible(true);
			
			int valr=0,valt=0;
		while(valt<=100){
		jp31.setValue(valt);
		//System.out.println(valt);
		valt=valt+1;
		//try{Thread.sleep(50);}catch(Exception e){}
		}
		while(valr<=100){
		jp32.setValue(valr);
		//System.out.println(valr);
		valr=valr+1;
		//try{Thread.sleep(50);}catch(Exception e){}
		}
				
				if(s1.equals(ARATINA)){
					l32.setText("OK");
				chk1A=1;
				}
             
				if(s2.equals(ATHUMB)){
					l34.setText("OK");
				chk2A=1;
				}
				
				if(chk1A==1&&chk2A==1){
				jb32.setEnabled(true);
				
				}
				else{
					JOptionPane.showMessageDialog(f, " Ratina OR Thumb not Match","", JOptionPane.ERROR_MESSAGE);
					l32.setText("Scaning");
					chk1A=0;
					l34.setText("Scaning");
					chk2A=0;
				}

		
	}
	if(e.getSource()==jb31){
		
		jd3.dispose();
		jd2.setVisible(true);
		
	}
	
		if(e.getSource()==jb32){
		System.out.println("Button 3");
		jd3.dispose();
		jd4.setVisible(true);
		jb41.setVisible(false);
		
		try{
			myStmt = myConn.createStatement();
			
			int x = myStmt.executeUpdate("update Authority set CHECKLOGIN= "+1+" where ID='"+AID+"'");
			System.out.println(x);
			if(x>0){
				jb41.setVisible(true);
				l41.setText("Mr./Mrs. "+ANAME);
				l43.setText("You center number is "+CNO);
			}
			
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		
		
	}
		if(e.getSource()==jb41){
		System.out.println("Button 4");
		jd4.dispose();
		
		bb4.setText("Authority Logout");
		chkLogin=1;
		
		mainPanel.setVisible(false);
		f.add(p5);
		p5.setVisible(true);
	}
	
		if(e.getSource()==jb51){
			
			
		String fn="",mn="",ln="",gn="",s="",d1="",al1="",al2="",as="",ad="",rat="",thu="",addr="",elig="";
		int ap=0,lid=0;
		Date d=null;
		int error=0;
		
		Blob blob=null;
		String row[][]=null;
		System.out.println("Button 5");
		String ano=tf3.getText();
		//String eno=tf4.getText();
		String eno="12345678123456";
		System.out.println("ano= "+ano);
		System.out.println("eno= "+eno);

		
		if(ano.equals("")&&eno.equals("")){
			JOptionPane.showMessageDialog(f, "ANO or ENO should not be Empty","Error", JOptionPane.ERROR_MESSAGE);
		}
		
		else if(ano.equals("")){
			if(eno.length()!=14){
			JOptionPane.showMessageDialog(f, "Enrolment number must be 14 digit long.","Error", JOptionPane.ERROR_MESSAGE);
			error=1;
			}else{
			VID=eno;
			VIDTYPE="ENO";
			}
		}
		
		else if(eno.equals("")){
			if(ano.length()!=12){
			JOptionPane.showMessageDialog(f, "Aadhaar number must be 12 digit long.","Error", JOptionPane.ERROR_MESSAGE);
			error=1;
			}else{
			VID=ano;
			VIDTYPE="ANO";
			}
		}
		
		else{
			if(ano.length()!=12){
			JOptionPane.showMessageDialog(f, "Aadhaar number must be 12 digit long.","Error", JOptionPane.ERROR_MESSAGE);
			error=1;
			}else{
			VID=ano;
			VIDTYPE="ANO";
			}
		}
		System.out.println("vid= "+VID);
		
		if(VID!=null&&error!=1){
		
		try{
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery("select * from Voters where "+VIDTYPE+"='"+VID+"'");
			
			if (!myRs.isBeforeFirst() ) { 
			System.out.println("No data"); 
			JOptionPane.showMessageDialog(f, "No Data Found on Given Voter ID","No Data Found", JOptionPane.ERROR_MESSAGE);
			}
			else{
			
			while(myRs.next()){
				lid=myRs.getInt("ID");
				fn= myRs.getString("FNAME");
				mn= myRs.getString("MNAME");
				ln= myRs.getString("MNAME");
				gn= myRs.getString("GNAME");
				s= myRs.getString("SEX");
				d1= myRs.getString("DOB");
				d = myRs.getDate("DOB");
				blob = myRs.getBlob("PHOTO");
				al1= myRs.getString("ALINE1");
				al2= myRs.getString("ALINE2");
				as= myRs.getString("ASTATE");
				ad= myRs.getString("ADIST");
				ap= myRs.getInt("APIN");
				rat= myRs.getString("RATINA");
				thu= myRs.getString("THUMB");
				elig= myRs.getString("ELIGIBLE");
				
				//System.out.println(VOTINGDATE);
				 
			
			}
			
			DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
			String date = df.format(d);
			
			//System.out.println(date);
			//System.out.println(VOTINGDATE);
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMMM-yyyy");
			java.util.Date date1 = sdf1.parse(VOTINGDATE);
			java.sql.Date sqlStartDate = new Date(date1.getTime()); 
			//System.out.println(sqlStartDate);
			
			//long diff =((sqlStartDate.getTime() - d.getTime()) / 24 * 60 * 60 * 1000);
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(d);
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(sqlStartDate);
			
			int VAGE=cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
			//System.out.println(VAGE);
		if(VAGE>=18){
			
			if(elig.equals("1")){
				
			
			VNAME=fn+" "+mn+" "+ln;
			VRATINA=rat;
			VTHUMB=thu;
			VPIN=ap;
			addr=al1+" "+al2;
			VOTERLASTID=lid;
			
			System.out.println(VOTERLASTID);
			
			String col1[]={"Name","Details"};
			String row1[][]={{"Name",VNAME},{"Guardian Name",gn},{"SEX",s},{"DOB",date},{"Address",al1},{"",al2},{"State",as},{"Dist",ad},{"Pin",""+ap}};
			t2=new JTable(row1,col1);
			t2.setFont(new Font("Serif", Font.PLAIN, 20));
			t2.setRowHeight(30);
			t2.setEnabled(false);
			//t2.setMinimumSize(new Dimension(600,200));
			
			l62=new JLabel();
			l62.setIcon(new ImageIcon("photo.jpg"));
			 
			
			p62.setLayout(new BorderLayout());
			p62.add(l62,BorderLayout.NORTH);
			//p62.add(p61,BorderLayout.SOUTH);
			
			p63.setLayout(new BorderLayout());
			p63.add(t2,BorderLayout.CENTER);
			p63.add(p62,BorderLayout.EAST);
			
			p6.add(l61,BorderLayout.NORTH);
			p6.add(p63,BorderLayout.CENTER);
			p6.add(p61,BorderLayout.SOUTH);
			p6.setBorder(new EmptyBorder(20, 20, 20, 20));
			
			p5.setVisible(false);
				p6.setVisible(true);
			}
			else if(elig.equals("2")){
				System.out.println("Already Voted"); 
				JOptionPane.showMessageDialog(f, "You are already voted.","Already Voted", JOptionPane.ERROR_MESSAGE);
			}
			else{
				System.out.println("Not Eligible"); 
				JOptionPane.showMessageDialog(f, "You are not eligible for voting.","No Eligible", JOptionPane.ERROR_MESSAGE);
			}
		}
		else{
			System.out.println("Age <18 "); 
				JOptionPane.showMessageDialog(f, "Your age are not Eligible for voting.","No Eligible", JOptionPane.ERROR_MESSAGE);
		}
			
			}
			}
			catch(Exception ex){
			System.out.println(ex);
			}
		}
			
			//p6.setBorder(new MatteBorder(150, 300, 150, 300, Color.GRAY));
			p6.setPreferredSize(new Dimension (200,100));
			//p6.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
			f.add(p6);
			
	}
	if(e.getSource()==jb61){
		System.out.println("bution 61");
		p6.setVisible(false);
		p5.setVisible(true);
		
	}
	if(e.getSource()==jb62){
		p6.setVisible(false);
		p7.setVisible(true);
		f.add(p7);
		System.out.println("bution 62");
		
		int chk1V=0,chk2V=0;
		String s1="4321ABCD1234";
		String s2="5678dcba8765";
		System.out.println(VTHUMB+s2);
		System.out.println(VRATINA+s1);
		
		int valr=0,valt=0;
		while(valt<=100){
		jp1.setValue(valt);
		//System.out.println(valt);
		valt=valt+1;
		//try{Thread.sleep(50);}catch(Exception e){}
		}
		while(valr<=100){
		jp2.setValue(valr);
		//System.out.println(valr);
		valr=valr+1;
		//try{Thread.sleep(50);}catch(Exception e){}
		}
		
		
		
			if(s1.equals(VRATINA)){
					l72.setText("OK");
				chk1V=1;
				}
             
				if(s2.equals(VTHUMB)){
					l74.setText("OK");
				chk2V=1;
				}
				
				if(chk1V==1&&chk2V==1){
				jb72.setEnabled(true);
				
				
				}
				else{
					JOptionPane.showMessageDialog(f, " Ratina OR Thumb not Match","", JOptionPane.ERROR_MESSAGE);
					l72.setText("Not Match");
					chk1V=0;
					l74.setText("Not Match");
					chk2V=0;
				}
		
		
		
	}
	if(e.getSource()==jb71){
		System.out.println("bution 71");
		p6.setVisible(true);
		p7.setVisible(false);
		
	}
	if(e.getSource()==jb72){
		System.out.println("bution 72");
		
		p7.setVisible(false);
		f.add(p8);
		p8.setVisible(true);
		
	}
	if(e.getSource()==cb1){
		System.out.println("bution cb1");
		cb1.setIcon(new ImageIcon(new ImageIcon("Images/chk2.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		cb2.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		cb3.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		cb4.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		//cb5.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		PCODE=1;
		PNAME="Party 1";
		jb82.setEnabled(true);
	}
	if(e.getSource()==cb2){
		System.out.println("bution cb2");
		cb1.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		cb2.setIcon(new ImageIcon(new ImageIcon("Images/chk2.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		cb3.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		cb4.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		//cb5.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		PCODE=2;
		PNAME="Party 2";
		jb82.setEnabled(true);
	}
	if(e.getSource()==cb3){
		System.out.println("bution cb3");
		cb1.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		cb2.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		cb3.setIcon(new ImageIcon(new ImageIcon("Images/chk2.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		cb4.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		//cb5.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		PCODE=3;
		PNAME="Party 3";
		jb82.setEnabled(true);

	}
	if(e.getSource()==cb4){
		System.out.println("bution cb4");
		cb1.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		cb2.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		cb3.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		cb4.setIcon(new ImageIcon(new ImageIcon("Images/chk2.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		//cb5.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		PCODE=4;
		PNAME="Party 4";
		jb82.setEnabled(true);
	}
	/*if(e.getSource()==cb5){
		System.out.println("bution cb5");
		cb1.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		cb2.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		cb3.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		cb4.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		cb5.setIcon(new ImageIcon(new ImageIcon("Images/chk2.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		PCODE=5;
		PNAME="Party 5";
		jb82.setEnabled(true);
		
	}*/
	if(e.getSource()==jb81){
		System.out.println("bution 81");
		p7.setVisible(true);
		p8.setVisible(false);
	}
	if(e.getSource()==jb82){
		System.out.println("bution 82");
		
		int x=0,y=0,lvid=0;
		
		try{
			myStmt = myConn.createStatement();
			
			x = myStmt.executeUpdate("insert into Voted (VID,VID_TYPE,VPIN,APIN,CNO,PARTY_NAME,PARTY_CODE) values ("+VID+","+"'"+VIDTYPE+"'"+","+VPIN+","+APIN+","+CNO+","+"'"+PNAME+"'"+","+PCODE+")");
			System.out.println(x);
			
			ResultSet getKeyRs = myStmt.executeQuery("SELECT LAST_INSERT_ID()");
                if (getKeyRs != null) {
                   if (getKeyRs.next()) {
                       lvid=getKeyRs.getInt(1);
                    }
                    getKeyRs.close();
                }
			
			y = myStmt.executeUpdate("update Voters set ELIGIBLE= "+2+" where "+VIDTYPE+"='"+VID+"'");
			System.out.println(y);
			
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		
		
		
			if(x==1&&y==1){
				System.out.println("Voted = "+lvid);
				
		l91.setText("Mr./Mrs. "+VNAME+", Thank You for Voting.");
		
		l92.setText("Your vote has been submitted for "+PNAME+".");
		VOTEDLASTID=lvid;
		f.add(p9);
		p9.setVisible(true);
		p8.setVisible(false);
			}
			else{
				System.out.println("Some Problems");
				JOptionPane.showMessageDialog(f, "System Error.","Error", JOptionPane.ERROR_MESSAGE);
				EVSSTATUS=EVSSTATUS-10;
			}
		
	}
	if(e.getSource()==jb91){
		System.out.println("bution 91");
		int x=0,y=0;
		
		try{
			myStmt = myConn.createStatement();
			
			y = myStmt.executeUpdate("update Voters set ELIGIBLE= "+1+" where ID='"+VOTERLASTID+"'");
			System.out.println(y);
			
			x = myStmt.executeUpdate("DELETE FROM Voted "+"where VNO='"+VOTEDLASTID+"'");
			System.out.println(x);
			System.out.println(VOTEDLASTID);
			
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		if(x==1&&y==1){
			p8.setVisible(true);
			p9.setVisible(false);
		}
		else{
				System.out.println("Some Problems");
				JOptionPane.showMessageDialog(f, "System Error.","Error", JOptionPane.ERROR_MESSAGE);
				EVSSTATUS=EVSSTATUS-10;
			}
		
	}
	if(e.getSource()==jb92){
		System.out.println("button 92");
		newVote();
		
		
	}
	if(e.getSource()==bb1){
		if(chkLogin==1){
		newVote();
		}
		else{
			JOptionPane.showMessageDialog(f, "You are not login. Please login as an Authority.","Login Please", JOptionPane.ERROR_MESSAGE);
		}
	}
	if(e.getSource()==bb2){
		System.out.println("System Ststus");
		systemStatus();
	}
	if(e.getSource()==bb3){
		System.out.println("help");
		helpFile();
	}
	if(e.getSource()==bb4){
		if(chkLogin==0){
			jd1.setVisible(true);
		}
		else{
			authorityLogout();
			
		}
		
	}
	
	
	if(e.getSource()==next){
		System.out.println("next");
		
		next.setVisible(false);
		bb1.setVisible(true);
		bb2.setVisible(true);
		bb3.setVisible(true);
		bb4.setVisible(true);
		prev.setVisible(true);
	}
	if(e.getSource()==prev){
		System.out.println("prev");
		
		bb1.setVisible(false);
		bb2.setVisible(false);
		bb3.setVisible(false);
		bb4.setVisible(false);
		prev.setVisible(false);
		next.setVisible(true);
	}
	if(e.getSource()==sb){
		jds.dispose();
	}
}


void connect(){
		String url="jdbc:mysql://localhost:3306/Voting?autoReconnect=true&useSSL=false";
		String user="root";
		String pass="kapil123";
		/*
		String url="jdbc:mysql://sql6.freesqldatabase.com:3306/sql6127791?autoReconnect=true&useSSL=false";
		String user="sql6127791";
		String pass="mYFbBZ6iBj";
		*/
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			myConn= DriverManager.getConnection(url,user,pass);
			}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	
void newVote(){
	String VID="",VANO="",VENO="",VTIME="",PARTY="",VNAME="",VRATINA="",VTHUMB="",VIDTYPE="",VAGE="",PNAME="";
	
	int VPIN,PCODE=0,CNO=0,VOTERLASTID=0,VOTEDLASTID=0;
	
		cb1.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		cb2.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		cb3.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		cb4.setIcon(new ImageIcon(new ImageIcon("Images/chk1.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		
		p6.setVisible(false);
		p7.setVisible(false);
		p8.setVisible(false);
		p9.setVisible(false);
		p5.setVisible(true);
}

void authorityLogout(){
	int x=0;
	chkLogin=0;
	
	try{
			myStmt = myConn.createStatement();
			
			x = myStmt.executeUpdate("update Authority set CHECKLOGIN= "+0+" where ID='"+AID+"'");
			System.out.println(x);
			System.out.println(AID);
			
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	if(x>0){
		
	String AID="",ANAME="",ARATINA="",ATHUMB="";
	int chk1A=0,chk2A=0,ALOGIN=0,APIN=0;
	
	jd1.setVisible(false);
	jd2.setVisible(false);
	jd3.setVisible(false);
	jd4.setVisible(false);
	p5.setVisible(false);
	p6.setVisible(false);
	p7.setVisible(false);
	p8.setVisible(false);
	p9.setVisible(false);
	bb4.setText("Authority Login");
	f.add(mainPanel);
	mainPanel.setVisible(true);
	
	tf1.setText("");
	tf2.setText("");
	}
}

void helpFile(){
	help=new JTextArea();
	Font font2 = new Font("TimesRoman", Font.PLAIN, 20);
	help.setFont(font2);
	//help.setLineWrap(true);
	help.setEditable(false);
	
	JScrollPane hsp=new JScrollPane(help);
	JDialog jdh=new JDialog();
	JLabel hl=new JLabel("<html><p style='color: RED; font-size: 20px; text-align: center; width:800px; background-color: WHITE;'>Help Document</p></html>");
	try {
String textLine;
FileReader fr = new FileReader("help.txt");
BufferedReader reader = new BufferedReader(fr);
         while((textLine=reader.readLine())!=null){
             help.read(reader,null);
         } 
}
catch (Exception ex) {
System.out.println(ex);
}
	
	jdh.add(hl,BorderLayout.NORTH);
	jdh.add(hsp,BorderLayout.CENTER);
	
	jdh.setVisible(true);
	jdh.setSize(1000,550);
	jdh.setLocationRelativeTo(f);
	
}

void systemStatus(){
	
	jds=new JDialog();
	JPanel sp=new JPanel();
	JPanel sp1=new JPanel();
	JPanel sp2=new JPanel();
	JPanel sp3=new JPanel();
	JPanel sp4=new JPanel();
	sp1.setLayout(new BorderLayout());
	sp2.setLayout(new BorderLayout());
	sp3.setLayout(new BorderLayout());
	sp4.setLayout(new BorderLayout());
	
	sb=new JButton("Close");
	sb.addActionListener(this);
	
	sb.setBackground(Color.ORANGE);
		sb.setForeground(Color.white);
		sb.setFont(new Font("Arial", Font.PLAIN, 20));
		sb.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		sb.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mouseEntered(java.awt.event.MouseEvent evt) {
        sb.setBackground(Color.GREEN);
		}

		public void mouseExited(java.awt.event.MouseEvent evt) {
        sb.setBackground(Color.ORANGE);
		}
		});
	
	Font font3 = new Font("TimesRoman", Font.PLAIN, 25);
	
	JLabel sl0=new JLabel("<html><p style='color: RED; font-size: 20px; text-align: center; width:500px; background-color: WHITE;'>System Status</p></html>");
	
	JLabel sl1=new JLabel("Authority Login :-");
	JLabel sl2=new JLabel("");
	JLabel sl3=new JLabel("System Status :-");
	JLabel sl4=new JLabel("");
	JLabel sl5=new JLabel("Network Status :-");
	JLabel sl6=new JLabel("");
	JLabel sl7=new JLabel("Power Status :-");
	JLabel sl8=new JLabel("");
	JLabel sl9=new JLabel("(If system status is less then 80% then Restart EVS.)");	
	
	sl1.setFont(font3);
	sl2.setFont(font3);
	sl3.setFont(font3);
	sl4.setFont(font3);
	sl5.setFont(font3);
	sl6.setFont(font3);
	sl7.setFont(font3);
	sl8.setFont(font3);
	sl9.setFont(font3);
	
	if(chkLogin==1){
		sl2.setText("Logged In");
	}
	else{
		sl2.setText("Logged Out");
	}
	
	sl4.setText(EVSSTATUS+"%");
	sl6.setText("100%");
	sl8.setText("80%");
	
	
	sp1.add(sl1,BorderLayout.CENTER);
	sp1.add(sl2,BorderLayout.EAST);
	sp2.add(sl3,BorderLayout.CENTER);
	sp2.add(sl4,BorderLayout.EAST);
	sp3.add(sl5,BorderLayout.CENTER);
	sp3.add(sl6,BorderLayout.EAST);
	sp4.add(sl7,BorderLayout.CENTER);
	sp4.add(sl8,BorderLayout.EAST);
	
	sp.add(sp1);
	sp.add(sp2);
	sp.add(sp3);
	sp.add(sp4);
	sp.add(sl0);
	sp.setLayout(new GridLayout(5,1));
	
	sp.setBorder(new EmptyBorder(20, 20, 20, 20));
	
	jds.add(sl0,BorderLayout.NORTH);
	jds.add(sp,BorderLayout.CENTER);
	jds.add(sb,BorderLayout.SOUTH);
	
	jds.setVisible(true);
	jds.setSize(600,400);
	jds.setLocationRelativeTo(f);
	
}
	
public static void main(String s[]){
	new EVS();
}
}