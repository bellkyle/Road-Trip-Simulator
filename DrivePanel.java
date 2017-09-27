import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Graphics;

public class DrivePanel extends JPanel {
	private int[] xPos;
	private int[] yPos;
	private int size;
	
	public DrivePanel(int size)
	{
		this.size = size;
		xPos = new int[this.size];
		yPos = new int[this.size];
		
	}

	public void setXY(int[] x, int[] y)
	{
		this.xPos = x;
		this.yPos = y;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		
		g.drawLine(0, height, xPos[0], (height - yPos[0]));
		g.drawString("(" + xPos[0] + ", " + yPos[0] + ")", xPos[0] + 10, height - yPos[0]);
		for(int i = 1; i < this.size; i++)
		{
			g.drawLine(xPos[i - 1], height - yPos[i - 1], xPos[i], height - yPos[i]);
			g.drawString("(" + xPos[i] + ", " + yPos[i] + ")", xPos[i] + 10, height - yPos[i]);
		}
	}
}
