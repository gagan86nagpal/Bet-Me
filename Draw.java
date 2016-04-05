import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.Random;

import javax.swing.JFrame;
public class Draw extends JPanel
{
	int x1=250,x2=250,x3=250,y1=250,y2=280,y3=310;
	boolean flag=false;
	void move()
	{
		while(x1<1310&&x2<1310&&x3<1310)
		{
			x1+=10+(Math.random()*5);
			x2+=10+(Math.random()*5);
			x3+=10+(Math.random()*5);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.repaint();
		}
		flag=true;
		this.repaint();
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g2.draw(new Line2D.Float(1310, 2,1310,700));
		//g.drawLine(1310, 2, 1310, 700);
		g.setColor(Color.black);
		g.fillRect(x1, y1, 20, 20);
		g.fillRect(x2, y2, 20, 20);
		g.fillRect(x3, y3, 20, 20);
		if(flag)
		{
			g.setColor(Color.RED);
			if(x1>x2&&x1>x3)
			{
				g.fillRect(x1, y1, 20, 20);
			}
			else if(x2>x1&&x2>x3)
			{
				g.fillRect(x2, y2, 20, 20);
			}
			else
			{
				g.fillRect(x3, y3, 20, 20);
			}
		}
	}
}
class Start
{
	public static void main(String [] arg)
	{
		JFrame f=new JFrame("Main Page");
		Draw d=new Draw();
		//more m =new more();
		f.getContentPane().add(d, BorderLayout.CENTER);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setSize(1366, 720);
		f.setVisible(true);
		d.move();
	}
}
