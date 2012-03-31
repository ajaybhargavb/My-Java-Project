
/**
 * This is a program to get a graph and solve it using certain Algorithms.
 */


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.util.TreeSet;
import java.util.Vector;
import java.util.HashSet;
import java.net.URL;
import javax.sound.sampled.*;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
//import javax.media.j3d.Sound;


class bpanel extends JPanel
{
	JButton kru=new JButton("Kruskal");
	JButton dij=new JButton("Dijkstra");
	JButton bfs=new JButton("BFS");
	JButton dfs=new JButton("DFS");
	JButton done=new JButton("Done Adding Nodes");

	public bpanel()
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 4;
		this.add(done, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		this.add(kru, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		this.add(dij, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		this.add(bfs, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 2;
		c.gridwidth = 1;
		this.add(dfs, c);
	}
}



class Kruskal extends JPanel implements ActionListener{
	 int flag=0,flag1=0,flag2=0,flag3=1,flag4=0,flag5=0,flag6=0,flag7=0,myflag=0,nd1,nd2,tcost,src1,src2;
	 public static int flag8=0;
	 Point[] p=new Point[20];
	 int count=0,non;
		JMenuBar menu;
		JMenu file,edit,help;
		JMenuItem fnew,fsave,fopen,fexit,eundo,eredo,esound,son,soff,htopics,habout;
     MouseHandler mouseHandler = new MouseHandler();
     Point p1 = new Point(195,370);
     Point p2 = new Point();
	 public int[][] nm,knm;
	 String str,str1,str2;
	 JLabel ti = new JLabel("DRAW THE GRAPH BELOW",JLabel.CENTER);
	 bpanel bp = new bpanel();
	 Clip clip;
	 AudioInputStream audioIn;
	 URL url;

    public Kruskal(){
        this.setPreferredSize(new Dimension(500, 400));
        this.addMouseListener(mouseHandler);
        this.setLayout(new BorderLayout());
        this.add(ti,BorderLayout.NORTH);
        this.add(bp,BorderLayout.SOUTH);
        bp.done.addActionListener(this);
        bp.done.setActionCommand("done");
        bp.kru.addActionListener(this);
        bp.kru.setActionCommand("kru");
        bp.kru.setEnabled(false);
        bp.dij.addActionListener(this);
        bp.dij.setActionCommand("dij");
        bp.dij.setEnabled(false);
        bp.bfs.addActionListener(this);
        bp.bfs.setActionCommand("bfs");
        bp.bfs.setEnabled(false);
        bp.dfs.addActionListener(this);
        bp.dfs.setActionCommand("dfs");
        bp.dfs.setEnabled(false);


        }


    public void actionPerformed(ActionEvent e)
	{
	if(e.getActionCommand()=="done")
	{
	if(flag1==0)
	{
	if(bp.done.isEnabled())
	{
		flag2=1;
		flag3=0;
		non=count;
		nm=new int[non][non];
		knm=new int[non][non];
		int i,j;
		for(i=0;i<non;i++)
		for(j=0;j<non;j++)
		nm[i][j]=999;
		bp.done.setText("Done Drawing Edges");

		JOptionPane.showMessageDialog(null,"No. of Nodes is "+non);
	}
	}
	if(flag1==1)
	{
	if(bp.done.isEnabled())
	{
		flag3=1;
		bp.done.setEnabled(false);
		bp.kru.setEnabled(true);
		bp.dij.setEnabled(true);
		bp.bfs.setEnabled(true);
		bp.dfs.setEnabled(true);
	}
	}
	}
	if(e.getActionCommand()=="kru")
	{
		Kruskal1 k1=new Kruskal1(nm,non);
		knm=k1.bb;
		tcost=k1.total;
		try
			{
				url = this.getClass().getClassLoader().getResource("SOUND528.wav");
				audioIn = AudioSystem.getAudioInputStream(url);
			    clip = AudioSystem.getClip();
			   	clip.open(audioIn);
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			if(flag8%2==0)
			{
			clip.stop();
            clip.start();
			}

		krframe krf = new krframe(new JFrame(),"Kruskal Solution",knm,non,p,tcost);
	}
	if(e.getActionCommand()=="dij")
	{
		int sorc,desti;
		int[] dijks;
		int mind;
		try
			{
				url = this.getClass().getClassLoader().getResource("message.wav");
				//sound14,sond19
				audioIn = AudioSystem.getAudioInputStream(url);
			    clip = AudioSystem.getClip();
			   	clip.open(audioIn);
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			if(flag8%2==0)
			{
			clip.stop();
            clip.start();
			}
		String sss=JOptionPane.showInputDialog("Enter the Source Node : ");
		sorc=Integer.parseInt(sss);
		if((sorc>non)||(sorc<=0))
		{
		while((sorc>non)||(sorc<=0))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Valid Source Node!");
		sss=JOptionPane.showInputDialog("Enter the Source Node : ");
		sorc=Integer.parseInt(sss);
		}
		}
		try
			{
				url = this.getClass().getClassLoader().getResource("message.wav");
				audioIn = AudioSystem.getAudioInputStream(url);
			    clip = AudioSystem.getClip();
			   	clip.open(audioIn);
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			if(flag8%2==0)
			{
			clip.stop();
            clip.start();
			}
		String ccc=JOptionPane.showInputDialog("Enter the Destination Node : ");
		desti=Integer.parseInt(ccc);
		if((desti>non)||(desti<=0))
		{
		while((desti>non)||(desti<=0))
		{
		JOptionPane.showMessageDialog(null,"Please Enter Valid Destination Node!");
		ccc=JOptionPane.showInputDialog("Enter the Destination Node : ");
		desti=Integer.parseInt(ccc);
		}
		}
				try
			{
				url = this.getClass().getClassLoader().getResource("SOUND528.wav");
				audioIn = AudioSystem.getAudioInputStream(url);
			    clip = AudioSystem.getClip();
			   	clip.open(audioIn);
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			if(flag8%2==0)
			{
			clip.stop();
            clip.start();
			}

		Dijkstra di = new Dijkstra(non,nm,sorc,desti);
		dijks=di.dijk;
		mind=di.min;
		dikframe dik = new dikframe(new JFrame(),"Solution",dijks,mind,p,non,nm);
	}

	if(e.getActionCommand()=="dfs")
	{
			Graph g1= new Graph(nm,non);
			try
			{
				url = this.getClass().getClassLoader().getResource("message.wav");
				audioIn = AudioSystem.getAudioInputStream(url);
			    clip = AudioSystem.getClip();
			   	clip.open(audioIn);
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			if(flag8%2==0)
			{
			clip.stop();
            clip.start();
			}
			str1=JOptionPane.showInputDialog("Enter the Source Vertex ");
			src1=Integer.parseInt(str1);
			if((src1>non)||(src1<=0))
			{
			while((src1>non)||(src1<=0))
			{
			JOptionPane.showMessageDialog(null,"Please Enter Valid Source Vertex");
			str1=JOptionPane.showInputDialog("Enter the Source Vertex ");
			src1=Integer.parseInt(str1);
			}
			}
					try
			{
				url = this.getClass().getClassLoader().getResource("SOUND528.wav");
				audioIn = AudioSystem.getAudioInputStream(url);
			    clip = AudioSystem.getClip();
			   	clip.open(audioIn);
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			if(flag8%2==0)
			{
			clip.stop();
            clip.start();
			}

			g1.dfs(src1);


	}

if(e.getActionCommand()=="bfs")
	{
			bfsGraph g11= new bfsGraph(nm,non);
			try
			{
				url = this.getClass().getClassLoader().getResource("message.wav");
				audioIn = AudioSystem.getAudioInputStream(url);
			    clip = AudioSystem.getClip();
			   	clip.open(audioIn);
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			if(flag8%2==0)
			{
			clip.stop();
            clip.start();
			}
			str2=JOptionPane.showInputDialog("Enter the Source Vertex ");
			src2=Integer.parseInt(str2);
			if((src2>non)||(src2<=0))
			{
			while((src2>non)||(src2<=0))
			{
			JOptionPane.showMessageDialog(null,"Please Enter Valid Source Vertex");
			str2=JOptionPane.showInputDialog("Enter the Source Vertex ");
			src2=Integer.parseInt(str2);
			}
			}
					try
			{
				url = this.getClass().getClassLoader().getResource("SOUND528.wav");
				audioIn = AudioSystem.getAudioInputStream(url);
			    clip = AudioSystem.getClip();
			   	clip.open(audioIn);
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			if(flag8%2==0)
			{
			clip.stop();
            clip.start();
			}

			g11.bfs(src2);


     }
}


    protected void paintComponent(Graphics g) {
        Graphics2D g2=(Graphics2D)g;
        RenderingHints renderHints =new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHints(renderHints);
        if(flag2==0)
        {
        if(flag==1)
        {
        super.paintComponent(g);
        flag=2;
	    }


		if(myflag==0)
		{
		//System.out.println("yes drawing");
	    Ellipse2D c=new Ellipse2D.Double(p1.x-10,p1.y-10,20,20);
	    g2.draw(c);
	    String co=Integer.toString(count);
	    g2.setPaint(new GradientPaint(0, 0, Color.ORANGE, 50, 25, Color.YELLOW, true));
	    g2.fill(c);
	    g2.setPaint(Color.BLACK);
	    g2.drawString(co,p1.x-5,p1.y+5);
		}
		}
		if(flag3==0)
		{
			Line2D l=new Line2D.Double(p[nd1-1].x, p[nd1-1].y, p[nd2-1].x, p[nd2-1].y);
			g2.setStroke(new BasicStroke(1));
			g2.draw(l);
			g2.setPaint(Color.BLUE);
			g2.drawString(str,(p[nd1-1].x+p[nd2-1].x)/2,(p[nd1-1].y+p[nd2-1].y)/2);
			flag4=0;
			flag5=0;
		}
    }


    private class MouseHandler extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            if(flag2==0)
            {
			p1 = e.getPoint();
						p2=e.getPoint();
						myflag=0;
						//System.out.println("non is"+count);
			for(int i=0;i<count;i++)
				{
				//System.out.println("ya going into this loop");
					Ellipse2D qq=new Ellipse2D.Double(p[i].x-10,p[i].y-10,20,20);
					if(qq.contains(p2))
					{
						JOptionPane.showMessageDialog(null,"Avoid Drawing on Existent Nodes!");
						myflag=1;
						}
				}
				if(myflag==0)
				{
				try
			{
				url = this.getClass().getClassLoader().getResource("WATER.wav");
				audioIn = AudioSystem.getAudioInputStream(url);
			    clip = AudioSystem.getClip();
			   	clip.open(audioIn);
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			if(flag8%2==0)
			{
			clip.stop();
            clip.start();
			}
            p[count]=e.getPoint();
            count++;
            flag++;
            repaint();
			}
			}
			if(flag3==0)
			{
				flag1=1;
				p2=e.getPoint();
				int i;
				for(i=0;i<non&&flag4==0;i++)
				{
					Ellipse2D qq=new Ellipse2D.Double(p[i].x-10,p[i].y-10,20,20);
					if(qq.contains(p2))
					{
						nd1=i+1;
						flag4=1;
					}
				}
				if(flag4==2)
				{
				for(i=0;i<non&&flag5==0;i++)
				{
					Ellipse2D qq=new Ellipse2D.Double(p[i].x-10,p[i].y-10,20,20);
					if(qq.contains(p2))
					{
						nd2=i+1;
						if(nd2!=nd1)
						flag5=1;
					}
				}
				if(flag5==1)
				{
				if(nm[nd1-1][nd2-1]==999)
				{
				try
			{
				url = this.getClass().getClassLoader().getResource("message.wav");
				audioIn = AudioSystem.getAudioInputStream(url);
			    clip = AudioSystem.getClip();
			   	clip.open(audioIn);
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			if(flag8%2==0)
			{
			clip.stop();
            clip.start();
			}
				str=JOptionPane.showInputDialog("Enter the Weight of "+nd1+" - "+nd2+" : ");
				if((Integer.parseInt(str))<=0)
				{
				while((Integer.parseInt(str)<=0))
				{
				JOptionPane.showMessageDialog(null,"Invalid Edge, Enter Again!");
				str=JOptionPane.showInputDialog("Enter the Weight of "+nd1+" - "+nd2+" : ");
				}
				}
				repaint();
				nm[nd1-1][nd2-1]=Integer.parseInt(str);
				nm[nd2-1][nd1-1]=Integer.parseInt(str);
				flag6=1;
				}
				else
				{
					flag4=0;
					flag5=0;
					JOptionPane.showMessageDialog(null,"Edge cannot be changed");
				}
				}
				}

				if(flag4==1)
				flag4=2;
			}
        }
    }

}


class krpanel extends JPanel
{
	int[][] zcc;
	int zdd;
	Point[] zee;
	int ztc;
	JLabel l1=new JLabel("The Solution(MST)..Using Kruskal Algorithm is  ... ");

	krpanel(int[][] ycc,int ydd,Point[] yee,int tc)
	{

	this.setPreferredSize(new Dimension(500, 400));
	this.add(l1);
	zcc=ycc;
	zdd=ydd;
	zee=yee;
	ztc=tc;
	}



	    protected void paintComponent(Graphics g) {
	          Graphics2D g2=(Graphics2D)g;
	          RenderingHints renderHints =new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	          g2.setRenderingHints(renderHints);
			  super.paintComponent(g);
	          for(int i=0;i<zdd;i++)
	          {
			  Ellipse2D c=new Ellipse2D.Double(zee[i].x-10,zee[i].y-10,20,20);
	  	   	  g2.draw(c);
	  		  String co=Integer.toString(i+1);
	  		  g2.setPaint(new GradientPaint(0, 0, Color.ORANGE, 50, 25, Color.YELLOW, true));
	  		  g2.fill(c);
	  		  g2.setPaint(Color.BLACK);
	  	      g2.drawString(co,zee[i].x-5,zee[i].y+5);
	  		  }
	  		  for(int i=0;i<zdd;i++)
	  		  for(int j=0;j<zdd;j++)
	  		  if(i<j)
				  if(zcc[i][j]!=999)
				  {
					  g2.setPaint(Color.BLACK);
					  Line2D l=new Line2D.Double(zee[i].x, zee[i].y, zee[j].x, zee[j].y);
					  g2.setStroke(new BasicStroke(1));
					  g2.draw(l);
					  g2.setPaint(Color.BLUE);
					  g2.drawString(Integer.toString(zcc[i][j]),(zee[i].x+zee[j].x)/2,(zee[i].y+zee[j].y)/2);
				  }
				  g2.drawString("The Minimum Cost is "+ztc,175,350);
	}
}

class menuFrame extends JDialog
{
JMenuBar menu;
		JMenu file,edit,help;
		JMenuItem fnew,fsave,fopen,fexit,eundo,eredo,esound,son,soff,htopics,habout;

menuFrame()
{
 menu=new JMenuBar();
			file=new JMenu("File"); fnew=new JMenuItem("New			Ctrl+N");fsave=new JMenuItem("Save 			Ctrl+S");fopen=new JMenuItem("Open 			Ctrl+O"); fexit=new JMenuItem("Exit");
			edit=new JMenu("Edit"); eundo=new JMenuItem("Undo 		Ctrl+Z"); eredo=new JMenuItem("Redo			Ctrl+R");esound=new JMenuItem("Sound");son= new JCheckBoxMenuItem("ON");soff= new JCheckBoxMenuItem("OFF");
                  help=new JMenu("Help"); htopics=new JMenuItem("Help Topics");habout=new JMenuItem("About");
			file.add(fnew);file.add(fsave);file.add(fopen);file.add(fexit);


			edit.add(eundo);edit.add(eredo);edit.add(esound);
			help.add(htopics);help.add(habout);
			menu.add(file);menu.add(edit);menu.add(help);
esound.add(son);esound.add(soff);
	setJMenuBar(menu);

}


}

class krframe extends JDialog
{
	int[][] xcc;
	int xdd;
	Point[] xee;
	int xtt;


  public krframe(final JFrame frame, String str,int[][] cc,int dd,Point[] ee,int tt){
  super(frame,str);
	xcc=cc;
	xdd=dd;
	xee=ee;
	xtt=tt;
	krpanel krp = new krpanel(xcc,xdd,xee,xtt);


  this.add(krp);
  this.setVisible(true);
  this.setResizable(false);
  this.pack();
  addWindowListener(new WindowAdapter(){
  public void windowClosing(WindowEvent evt){
  frame.dispose();
  }
  });
  }
}



  public class mst extends JDialog
  {
		JMenuBar menu;
		JMenu file,edit,help;
		JMenuItem fnew,fsave,fopen,fexit,eundo,eredo,esound,son,soff,htopics,habout;
		public static int hflag=0;
		int newflag=0,bb;

  public mst(final JFrame frame, String str){

 super(frame,str);
 menu=new JMenuBar();
		newflag=0;
			file=new JMenu("File");
			fnew=new JMenuItem("New");
			fsave=new JMenuItem("Save");
			fexit=new JMenuItem("Exit");
			edit=new JMenu("Edit");
			esound=new JCheckBoxMenuItem("Sound",true);
            help=new JMenu("Help");
            htopics=new JMenuItem("Help Topics");
            habout=new JMenuItem("About");
			file.add(fnew);
			file.add(fsave);
			file.add(fexit);
			edit.add(esound);
			help.add(htopics);
			help.add(habout);
			menu.add(file);
			menu.add(edit);
			menu.add(help);

	setJMenuBar(menu);

		 fnew.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent a)
		  {
		  if(newflag==0)
						{
						newflag=1;

		  bb=JOptionPane.showConfirmDialog(null, "Are you sure you want to create a new Graph?", "Alert!",JOptionPane.YES_NO_OPTION);
			  if(bb==JOptionPane.YES_OPTION)
			  {
		  frame.dispose();
		  mst fr = new mst(new JFrame(),"MST USING KRUSKAL");
		  Kruskal k = new Kruskal();
		  fr.add(k);
		  fr.setResizable(false);
		  fr.pack();
  		  fr.setVisible(true);
		  }
		  }
		  else
		  {
		  newflag=0;
		  }

		  }
		  });

		  fsave.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent a)
		  {
			  try
			  {
			  String str1 = JOptionPane.showInputDialog(null,"Enter the file name : ");
			   captureScreen(str1);
		   	  }
		   	  catch(Exception ex)
		   	  {
				  System.out.println("EXCEPTION"+ex.getMessage());
			  }
		  }
	  });

		  esound.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent a)
		  {
				Kruskal.flag8++;
		  }
	  });


		  fexit.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent a)
		  {
			  int aa;
			  aa=JOptionPane.showConfirmDialog(null, "Confirm Quit ? ", "Alert",JOptionPane.YES_NO_OPTION);
			  if(aa==JOptionPane.YES_OPTION)
			  System.exit(0);
		  }
	  });

	  		  htopics.addActionListener(new ActionListener(){
	  		  public void actionPerformed(ActionEvent a)
		  {
			  helpfr hfr = new helpfr(new JFrame(),"ABOUT ALGORITHMS USED");
			  hflag=1;
			  help h=new help();
			  hfr.add(h);
			  hfr.setResizable(false);
			  hfr.pack();
  			  hfr.setVisible(true);
		  }
	  });

	  			  habout.addActionListener(new ActionListener(){
	  	  		  public void actionPerformed(ActionEvent a)
	  		  {
	  			  helpfr hfr = new helpfr(new JFrame(),"ABOUT GRAPH MINIMIZATION TOOL");
	  			  hflag=2;
	  			  help h=new help();
	  			  hfr.add(h);
	  			  hfr.setResizable(false);
	  			  hfr.pack();
	    		  hfr.setVisible(true);
	  		  }
	  });
  addWindowListener(new WindowAdapter(){
  public void windowClosing(WindowEvent evt){
  int aa;
  aa=JOptionPane.showConfirmDialog(null, "Confirm Quit ? ", "Alert",JOptionPane.YES_NO_OPTION);
  if(aa==JOptionPane.YES_OPTION)
  System.exit(0);
  }
  });
}

		public void captureScreen(String fileName) throws Exception
	  {
		  				Point pt = new Point(this.getLocation());
		  			   Rectangle screenRectangle = new Rectangle(pt.x,pt.y+70,500,320);
		  			   Robot robot = new Robot();
		  			   BufferedImage image = robot.createScreenCapture(screenRectangle);
		     		   ImageIO.write(image, "png", new File(fileName+".png"));
	  }



    public static void main(String[] args) {
        try
        {
        mst fr = new mst(new JFrame(),"GRAPH MINIMIZATION AND SOLVING TOOL");
		JOptionPane.showMessageDialog(null,"Step 1: Click anywhere on the frame to add nodes\nStep2: Click any two node continuously to add Edges");
        Kruskal k = new Kruskal();
		fr.add(k);
		fr.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		fr.setResizable(false);
		fr.pack();
  		fr.setVisible(true);
        }
		catch(IllegalArgumentException e){
		System.exit(0);
  		}
	}
}

class help extends JPanel implements ActionListener
{
	JLabel l1=new JLabel("HELP TOPICS",JLabel.CENTER);
	JLabel l2=new JLabel("GRAPH MINIMIZATION AND SOLVING TOOL",JLabel.CENTER);
	JTextArea t1 = new JTextArea();

public help()
{
if(mst.hflag==1)
{
this.setPreferredSize(new Dimension(500, 400));
this.setLayout(new BorderLayout());
this.add(l1,BorderLayout.NORTH);
Font font = new Font("Serif", Font.ITALIC, 14);
t1.setFont(font);
t1.setText("KRUSKAL ALGORITHM : ");
t1.append("\nKruskal's algorithm is an algorithm in graph theory that finds a minimum spanning tree for a connected weighted graph. This means it finds a subset of the edges that forms a tree that includes every vertex, where the total weight of all the edges in the tree is minimized. If the graph is not connected, then it finds a minimum spanning forest (a minimum spanning tree for each connected component). Kruskal's algorithm is an example of a greedy algorithm.");
t1.append("\nDIJKSTRA ALGORITHM : ");
t1.append("\nDijkstra's algorithm is a graph search algorithm that solves the single-source shortest path problem for a graph with nonnegative edge path costs, producing a shortest path tree.It can be used for finding costs of shortest paths from a single vertex to a single destination vertex.");
t1.append("\nBREADTH FIRST SEARCH : ");
t1.append("\nbreadth-first search (BFS) is a graph search algorithm that begins at the root node and explores all the neighboring nodes. Then for each of those nearest nodes, it explores their unexplored neighbor nodes, and so on, until it finds the goal.");
t1.append("\nDEPTH FIRST SEARCH : ");
t1.append("\nDepth-first search (DFS) is an algorithm for traversing or searching a tree, tree structure, or graph. One starts at the root (selecting some node as the root in the graph case) and explores as far as possible along each branch before backtracking.");
t1.setEditable(false);
t1.setLineWrap(true);
t1.setBackground (this.getBackground());
//this.add(l1);
this.add(t1);
}

if(mst.hflag==2)
{
this.setPreferredSize(new Dimension(300, 270));
this.setLayout(new BorderLayout());
this.add(l2,BorderLayout.NORTH);
Font font = new Font("Times New Roman", Font.ITALIC, 14);
t1.setFont(font);
t1.setText("\nThis tool is used to draw a graph with GUI and       implement certain algorithms on them");
t1.append("\n\nAlgorithms Used : Kruskal, Dijkstra, BFS, DFS ");
t1.append("\n\nIt can also save the graph for future reference");
t1.append("\n\nDeveloped By : ");
t1.append("\nAjay Bhargav\nemail: ajaybhargavb@gmail.com");
t1.append("\n\nCopyrights © 2011 \nAll Rights Reserved");
t1.setEditable(false);
t1.setLineWrap(true);
t1.setBackground (this.getBackground());
this.add(t1);
}
}

public void actionPerformed(ActionEvent a){}

}

class helpfr extends JDialog
{
	public helpfr(final JFrame frame, String str){
	super(frame,str);
	addWindowListener(new WindowAdapter(){
  	public void windowClosing(WindowEvent evt){
  	frame.dispose();
  }
  });
}
}


class dikframe extends JDialog
{

	public dikframe(final JFrame frame, String str,int[] dks,int mn,Point[] po,int nn,int[][] am)
	{
		super(frame,str);
		dpanel dp = new dpanel(dks,mn,po,nn,am);
		this.add(dp);
		this.setVisible(true);
		this.setResizable(false);
		this.pack();
		addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent evt){
  		frame.dispose();
	}
});
}
}

class dpanel extends JPanel
{
	Point[] pp;
	int no,min;
	int[] diks;
	int[][] adm;
	JLabel l1 = new JLabel("The Solution using Dijkstra Algorithm is .. ",JLabel.CENTER);
	public dpanel(int[] dikst,int mm,Point[] ppp,int nod,int[][] adjm)
	{
		pp=ppp;
		no=nod;
		diks=dikst;
		adm=adjm;
		min=mm;
		for(int i=0;i<diks.length;i++)
		//System.out.println(diks[i]);
		this.setPreferredSize(new Dimension(500, 400));
		this.add(l1);
	}

			  protected void paintComponent(Graphics g) {
	          Graphics2D g2=(Graphics2D)g;
	          RenderingHints renderHints =new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	          g2.setRenderingHints(renderHints);
			  super.paintComponent(g);
			  for(int i=0;i<diks.length;i++)
			  {

			  Ellipse2D c=new Ellipse2D.Double(pp[diks[i]-1].x-10,pp[diks[i]-1].y-10,20,20);
	  	   	  g2.draw(c);
	  		  String co=Integer.toString(diks[i]);
	  		  g2.setPaint(new GradientPaint(0, 0, Color.ORANGE, 50, 25, Color.YELLOW, true));
	  		  g2.fill(c);
	  		  g2.setPaint(Color.BLACK);
	  	      g2.drawString(co,pp[diks[i]-1].x-5,pp[diks[i]-1].y+5);
			  }

			  for(int i=0;i<diks.length-1;i++)
			  {
				g2.setPaint(Color.BLACK);
				Line2D l=new Line2D.Double(pp[diks[i]-1].x, pp[diks[i]-1].y, pp[diks[i+1]-1].x, pp[diks[i+1]-1].y);
				g2.setStroke(new BasicStroke(1));
				g2.draw(l);
				g2.setPaint(Color.BLUE);
				g2.drawString(Integer.toString(adm[diks[i]-1][diks[i+1]-1]),(pp[diks[i]-1].x+pp[diks[i+1]-1].x)/2,(pp[diks[i]-1].y+pp[diks[i+1]-1].y)/2);
			  }
			  g2.drawString("The Path is ",185,320);
			  int j=0;
			  for(int i=0;i<diks.length;i++)
			  {
			  g2.drawString(diks[i]+" ",260+j,320);
			  j=j+10;
		  	  }
			  g2.drawString("The Cost Incurred is "+min,175,350);
		  }
}


/*
 * Kruskal Implementation
 */



class Edge implements Comparable<Edge>
{
    String vertexA, vertexB;
    int weight;

    public Edge(String vertexA, String vertexB, int weight)
    {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.weight = weight;
    }
    public String getVertexA()
    {
        return vertexA;
    }
    public String getVertexB()
    {
        return vertexB;
    }
    public int getWeight()
    {
        return weight;
    }
    @Override
    public String toString()
    {
        return "(" + vertexA + ", " + vertexB + ") : Weight = " + weight;
    }
    public int compareTo(Edge edge)
    {
        return (this.weight < edge.weight) ? -1: 1;
    }
}
class KruskalEdges
{
    Vector<HashSet<String>> vertexGroups = new Vector<HashSet<String>>();
    TreeSet<Edge> kruskalEdges = new TreeSet<Edge>();

    public TreeSet<Edge> getEdges()
    {
        return kruskalEdges;
    }
    HashSet<String> getVertexGroup(String vertex)
    {
        for (HashSet<String> vertexGroup : vertexGroups) {
            if (vertexGroup.contains(vertex)) {
                return vertexGroup;
            }
        }
        return null;
    }


    public void insertEdge(Edge edge)
    {
        String vertexA = edge.getVertexA();
        String vertexB = edge.getVertexB();

        HashSet<String> vertexGroupA = getVertexGroup(vertexA);
        HashSet<String> vertexGroupB = getVertexGroup(vertexB);

        if (vertexGroupA == null) {
            kruskalEdges.add(edge);
            if (vertexGroupB == null) {
                HashSet<String> htNewVertexGroup = new HashSet<String>();
                htNewVertexGroup.add(vertexA);
                htNewVertexGroup.add(vertexB);
                vertexGroups.add(htNewVertexGroup);
            }
            else {
                vertexGroupB.add(vertexA);
            }
        }
        else {
            if (vertexGroupB == null) {
                vertexGroupA.add(vertexB);
                kruskalEdges.add(edge);
            }
            else if (vertexGroupA != vertexGroupB) {
                vertexGroupA.addAll(vertexGroupB);
                vertexGroups.remove(vertexGroupB);
                kruskalEdges.add(edge);
            }
        }
    }
}



class Kruskal1
{
 int[][] bb;
 int total=0,nd1,nd2;

 public Kruskal1(int[][] aa,int nn)
 {
	 bb=new int[nn][nn];
	 for(int i=0;i<nn;i++)
	 for(int j=0;j<nn;j++)
		bb[i][j]=999;
        TreeSet<Edge> edges = new TreeSet<Edge>();

for(int i=0;i<nn;i++)
for(int j=0;j<nn;j++)
if(i<j)
{
if(aa[i][j]!=999)
{
	edges.add(new Edge(Integer.toString(i+1),Integer.toString(j+1),aa[i][j]));
}
}

        //System.out.println("Graph");
        KruskalEdges vv = new KruskalEdges();

        for (Edge edge : edges) {
            //System.out.println(edge);
            vv.insertEdge(edge);
        }

        //System.out.println("Kruskal algorithm");
        for (Edge edge : vv.getEdges()) {
            //System.out.println(edge);
            nd1=Integer.parseInt(edge.getVertexA());
            nd2=Integer.parseInt(edge.getVertexB());
			bb[nd1-1][nd2-1]=bb[nd2-1][nd1-1]=edge.getWeight();
            total += edge.getWeight();
        }
        //System.out.println("Total weight is " + total);
       /* for(int i=0;i<nn;i++)
        {
		for(int j=0;j<nn;j++)
		{
			System.out.print(bb[i][j]);
			System.out.print("\t");
		}
		System.out.print("\n");
		}*/
    }
}


/*
 * DFS Implementation
 */

class StackX
   {
   private final int SIZE = 20;
   private int[] st;
   private int top;

   public StackX()           // constructor
      {
      st = new int[SIZE];    // make array
      top = -1;
      }

   public void push(int j)   // put item on stack
      { st[++top] = j; }

   public int pop()          // take item off stack
      { return st[top--]; }

   public int peek()         // peek at top of stack
      { return st[top]; }

   public boolean isEmpty()  // true if nothing on stack
      { return (top == -1); }

   }  // end class StackX


class Vertex
   {
   public int label;        // label (e.g. 'A')
   public boolean wasVisited;

   public Vertex(int lab)   // constructor
      {
      label = lab;
      wasVisited = false;
      }

   }  // end class Vertex


class Graph
   {
 int MAX_VERTS;
int i=0;
int dfsList[];
int matflag[][];
char c[];
int charflag;
   private Vertex vertexList[]; // list of vertices
   private int adjMat[][];      // adjacency matrix
   private int nVerts;          // current number of vertices
   private StackX theStack;

   public Graph(int [][] aa, int non)               // constructor
      {
	//MAX_VERTS=non;
	MAX_VERTS=20;
      vertexList = new Vertex[MAX_VERTS];
                                          // adjacency matrix
      adjMat = new int[MAX_VERTS][MAX_VERTS];
	dfsList = new int[MAX_VERTS*3];
	charflag=0;
      nVerts = 0;
	c= new char[MAX_VERTS*3];
	matflag= new int[MAX_VERTS][MAX_VERTS];
	for(int y=0; y<MAX_VERTS; y++)      // set adjacency
         for(int x=0; x<MAX_VERTS; x++)   //    matrix to 0
      	matflag[x][y]=0;
	for(int y=0; y<MAX_VERTS; y++)      // set adjacency
         for(int x=0; x<MAX_VERTS; x++)   //    matrix to 0
            adjMat[x][y] = 0;

      theStack = new StackX();
	//System.out.println(non);
	for(int z=0;z<non;z++)
		addVertex(z);
	for(int y=0;y<non;y++)
		for(int x=0;x<non;x++)
	{
	if((aa[y][x]!=999)&&(matflag[x][y]==0)&&(matflag[y][x]==0))
	{
	matflag[x][y]=1;
	matflag[y][x]=1;
	//System.out.println("Adding vertex "+(x+1)+" to "+(y+1));
	addEdge(x,y);
	}
	}


      }  // end constructor


   public void addVertex(int lab)
      {
      vertexList[nVerts++] = new Vertex(lab);
      }

   public void addEdge(int start, int end)
      {
      adjMat[start][end] = 1;
      adjMat[end][start] = 1;
      }

   public void displayVertex(int v)
      {
	  try
	  {
//System.out.print(vertexList[v].label+1);
	dfsList[i]=vertexList[v].label+1;

if (dfsList[i] >= 0 && dfsList[i] <= 9) {

 c[i] = Character.forDigit(dfsList[i], 10);
	i++;
c[i]='-';
	i++;
c[i]='>';
}
	i++;

int temp=i;
	if(temp>=nVerts*3)
		{
		temp--;
		temp--;
		while(temp<MAX_VERTS*3)
		{
			c[temp]=' ';
			temp++;
		}
		}
String values = new String(c);
//System.out.println(values.length());

	if(i>=nVerts*3)
		{
		JOptionPane.showMessageDialog(null,"DFS would be: "+values);
		}
		}
		catch(Exception de)
		{JOptionPane.showMessageDialog(null,"Sorry, DFS not possible for this Graph.");}
      }

   public void dfs(int src1)  // depth-first search
      {
	src1=src1-1;
                    // begin at vertex 0
      vertexList[src1].wasVisited = true;  // mark it
      displayVertex(src1);                 // display it
      theStack.push(src1);                 // push it

      while( !theStack.isEmpty() )      // until stack empty,
         {
         int v = getAdjUnvisitedVertex( theStack.peek() );
         if(v == -1)                    // if no such vertex,
            theStack.pop();
         else                           // if it exists,
            {
            vertexList[v].wasVisited = true;  // mark it
            displayVertex(v);                 // display it
            theStack.push(v);                 // push it
            }
         }  // end while
if(i<nVerts*3)
JOptionPane.showMessageDialog(null,"Sorry, DFS not possible for this Graph.");

      for(int j=0; j<nVerts; j++)          // reset flags
         vertexList[j].wasVisited = false;
      }  // end dfs

   public int getAdjUnvisitedVertex(int v)
      {
      for(int j=0; j<nVerts; j++)
         if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
            return j;
      return -1;
      }  // end getAdjUnvisitedVertex()

   }  // end class Graph




/*
 * BFS Implementation
 */


class Queue
   {
   private final int SIZE = 20;
   private int[] queArray;
   private int front;
   private int rear;

   public Queue()            // constructor
      {
      queArray = new int[SIZE];
      front = 0;
      rear = -1;
      }

   public void insert(int j) // put item at rear of queue
      {
      if(rear == SIZE-1)
         rear = -1;
      queArray[++rear] = j;
      }

   public int remove()       // take item from front of queue
      {
      int temp = queArray[front++];
      if(front == SIZE)
         front = 0;
      return temp;
      }

   public boolean isEmpty()  // true if queue is empty
      {
      return ( rear+1==front || (front+SIZE-1==rear) );
      }

   }  // end class Queue

class bfsVertex
   {
   public int label;        // label (e.g. 'A')
   public boolean wasVisited;

   public bfsVertex(int lab)   // constructor
      {
      label = lab;
      wasVisited = false;
      }

   }  // end class Vertex

class bfsGraph
   {
   int MAX_VERTS;
   int i=0;
int bfsList[];
int matflag[][];
char c[];
int charflag;
   private bfsVertex vertexList[]; // list of vertices
   private int adjMat[][];      // adjacency matrix
   private int nVerts;          // current number of vertices
   private Queue theQueue;

   public bfsGraph(int [][]aa,int non)               // constructor
      {
	//MAX_VERTS=non;
	MAX_VERTS=20;
      vertexList = new bfsVertex[MAX_VERTS];
                                          // adjacency matrix
      adjMat = new int[MAX_VERTS][MAX_VERTS];
bfsList = new int[MAX_VERTS*3];
charflag=0;
      nVerts = 0;
c= new char[MAX_VERTS*3];
	matflag= new int[MAX_VERTS][MAX_VERTS];
	for(int j=0; j<MAX_VERTS; j++)      // set adjacency
         for(int k=0; k<MAX_VERTS; k++)   //    matrix to 0
      	matflag[j][k]=0;

      for(int j=0; j<MAX_VERTS; j++)      // set adjacency
         for(int k=0; k<MAX_VERTS; k++)   //    matrix to 0
            adjMat[j][k] = 0;
      theQueue = new Queue();
		//System.out.println(non);
for(int z=0;z<non;z++)
		addVertex(z);
	for(int y=0;y<non;y++)
		for(int x=0;x<non;x++)
	{
	if((aa[y][x]!=999)&&(matflag[x][y]==0)&&(matflag[y][x]==0))
	{
	matflag[x][y]=1;
	matflag[y][x]=1;
	//System.out.println("Adding vertex "+(x+1)+" to "+(y+1));
	addEdge(x,y);
	}
	}



      }  // end constructor

   public void addVertex(int lab)
      {
      vertexList[nVerts++] = new bfsVertex(lab);
      }

   public void addEdge(int start, int end)
      {
      adjMat[start][end] = 1;
      adjMat[end][start] = 1;
      }

   public void displayVertex(int v)
      {
//System.out.print(vertexList[v].label+1);
try
{
	bfsList[i]=vertexList[v].label+1;

if (bfsList[i] >= 0 && bfsList[i] <= 9) {

 c[i] = Character.forDigit(bfsList[i], 10);
	i++;
c[i]='-';
	i++;
c[i]='>';
}
	i++;

int temp=i;
	if(temp>=nVerts*3)
		{
		temp--;
		temp--;
		while(temp<MAX_VERTS*3)
		{
			c[temp]=' ';
			temp++;
		}
		}
String values = new String(c);
//System.out.println(values.length());
	if(i>=nVerts*3)
		{
		JOptionPane.showMessageDialog(null,"BFS would be: "+values);
		}
}
catch(Exception be)
{JOptionPane.showMessageDialog(null,"Sorry, BFS not possible for this Graph.");}
      }

   public void bfs(int src2)                   // breadth-first search
      {
	src2=src2-1;
         // begin at vertex 0
      vertexList[src2].wasVisited = true; // mark it
      displayVertex(src2);                // display it
      theQueue.insert(src2);              // insert at tail
      int v2;

      while( !theQueue.isEmpty() )     // until queue empty,
         {
         int v1 = theQueue.remove();   // remove vertex at head
         // until it has no unvisited neighbors
         while( (v2=getAdjUnvisitedVertex(v1)) != -1 )
            {                                  // get one,
            vertexList[v2].wasVisited = true;  // mark it
            displayVertex(v2);                 // display it
            theQueue.insert(v2);               // insert it
            }   // end while
         }  // end while(queue not empty)
if(i<nVerts*3)
JOptionPane.showMessageDialog(null,"Sorry, BFS not possible for this Graph.");
      // queue is empty, so we're done
      for(int j=0; j<nVerts; j++)             // reset flags
         vertexList[j].wasVisited = false;
      }  // end bfs()

   // returns an unvisited vertex adj to v
   public int getAdjUnvisitedVertex(int v)
      {
      for(int j=0; j<nVerts; j++)
         if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
            return j;
      return -1;
      }  // end getAdjUnvisitedVertex()
   }  // end class bfsGraph



/*
 * Dijkstra Implementation
 */



   class Vertex1 implements Comparable<Vertex1>
   {
       public final String name;
       public Edge1[] adjacencies;
       public double minDistance = Double.POSITIVE_INFINITY;
       public Vertex1 previous;
       public Vertex1(String argName) { name = argName; }
       public String toString() { return name; }
       public int compareTo(Vertex1 other)
       {
           return Double.compare(minDistance, other.minDistance);
       }

	}

	class Edge1
	{
	    public final Vertex1 target;
	    public final int weight;
	    public Edge1(Vertex1 argTarget, int argWeight)
	    { target = argTarget; weight = argWeight; }
	}

	class Dijkstra
	{
	    public static void computePaths(Vertex1 source)
	    {
	        source.minDistance = 0.;
	        PriorityQueue<Vertex1> vertexQueue = new PriorityQueue<Vertex1>();
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty()) {
		    Vertex1 u = vertexQueue.poll();

	            for (Edge1 e : u.adjacencies)
	            {
	                Vertex1 v2 = e.target;
	                int weight = e.weight;
	                int distanceThroughU = (int)u.minDistance + weight;
			if (distanceThroughU < v2.minDistance) {
			    vertexQueue.remove(v2);

			    v2.minDistance = distanceThroughU ;
			    v2.previous = u;
			    vertexQueue.add(v2);

			}

	            }
	        }
	    }


	    public static ArrayList<Vertex1> getShortestPathTo(Vertex1 target)
	    {
	        ArrayList<Vertex1> path = new ArrayList<Vertex1>();
	        for (Vertex1 vertex = target; vertex != null; vertex = vertex.previous)
	            path.add(vertex);

	        Collections.reverse(path);
	        return path;
	    }

	    String[] dijs;
	    String[] temp2;
	    public static int[] dijk;
	    public static int min;

	    Dijkstra(int non,int[][] adj,int src,int dest)
	    {
			Vertex1[] v = new Vertex1[non];
			for(int i=0;i<non;i++)
			v[i] = new Vertex1(Integer.toString(i+1));

Edge1[] temp;
List<Edge1> ed = new ArrayList<Edge1>();
int k=0;
for(int i=0;i<non;i++)
{k=0;
ed.clear();
for(int j=0;j<non;j++)
{
if(adj[i][j]!=999)
{

ed.add(new Edge1(v[j],adj[i][j]));
k++;
}
}
temp = new Edge1[ed.size()];
v[i].adjacencies = ed.toArray(temp);
//System.out.println(ed.size());
}
		Vertex1[] vertices = new Vertex1[non];
		for(int i=0;i<non;i++)
		vertices[i] = v[i];


	        computePaths(v[src-1]);
		ArrayList<Vertex1> path = getShortestPathTo(v[dest-1]);
		//JOptionPane.showMessageDialog(null,"The path is "+path+". The Min Distance is "+v[dest-1].minDistance);
		dijk = new int[path.size()];
		Vertex1[] ver = new Vertex1[path.size()];
		ver=path.toArray(new Vertex1[path.size()]);
		for(int i=0;i<path.size();i++)
			dijk[i] = Integer.parseInt(ver[i].name);
		min = (int)v[dest-1].minDistance;
	}
	}

   /*<applet code=mst.java width=500 height=400>
</applet>*/
