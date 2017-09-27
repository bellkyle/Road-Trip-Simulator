//Creates and test the functionally of a GUI with the program
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Assignment5 {

	public static void main( String[] args)
	{
		String carDescription =
			JOptionPane.showInputDialog("Enter the description of the car");	
		String tankCapacity;
		int tank = -1;
		while(tank < 0)
		{
			tankCapacity = JOptionPane.showInputDialog("Enter tank capacity");
			try {
				tank = Integer.parseInt(tankCapacity);
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting");
				return;
			}
		}
		
		String engineDescription =
			JOptionPane.showInputDialog("Enter engine description");
		
		String mpg;
		int milesPG = -1;
		while(milesPG < 0)
		{
			mpg = JOptionPane.showInputDialog("Enter the miles per gallon");
			try {
				milesPG = Integer.parseInt(mpg);
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting");
				return;
			}
		}
		
		String maxSpeed;
		int speed = -1;
		while(speed < 0)
		{
			maxSpeed = JOptionPane.showInputDialog("Enter the max speed");
			try {
				speed = Integer.parseInt(maxSpeed);
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting");
				return;
			}
		}
		
		Engine engine = new Engine(engineDescription, milesPG, speed);
		
		Car car1 = new Car(carDescription, tank, engine);
		
		JOptionPane.showMessageDialog(null, car1.getDescription());
		car1.fillUp();
		
		String numLegs;
		int legs = -1;
		while(legs < 0)
		{
			numLegs = JOptionPane.showInputDialog("Enter the number of legs");
			try {
				legs = Integer.parseInt(numLegs);
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting");
				return;
			}
		}
		
		int[] d = new int[legs];
		int[] x = new int[legs];
		int[] y = new int[legs];
		
		for(int i = 0; i < legs; i++)
		{
			String distanceMessage = "Enter the distance for leg " + (i + 1);
			String xRatioMessage = "Enter the x ratio for leg " + (i + 1);
			String yRatioMessage = "Enter the y ratio for leg " + (i + 1);
			
			String distance;
			d[i] = -1;
			while(d[i] < 0)
			{
				distance = JOptionPane.showInputDialog(distanceMessage);
				try {
					d[i] = Integer.parseInt(distance);
				} catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting");
					return;
				}
			}
			
			String xRatio =
				JOptionPane.showInputDialog(xRatioMessage);
			try {
				x[i] = Integer.parseInt(xRatio);
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting");
				return;
			}
			
			String yRatio =
				JOptionPane.showInputDialog(yRatioMessage);
			try {
				y[i] = Integer.parseInt(yRatio);
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting");
				return;
			}
			
			
		}
	
		DrivePanel panel = new DrivePanel(legs);
		JFrame application = new JFrame();
		int[] xPos = new int[legs];
		int[] yPos = new int[legs];
		for(int i = 0; i < legs; i++)
		{
			car1.drive(d[i], x[i], y[i]);
			xPos[i] = car1.getX();
			yPos[i] = car1.getY();
				
		}
		panel.setXY(xPos, yPos);
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.setSize(600, 600);
		application.setVisible(true);
	}
}
