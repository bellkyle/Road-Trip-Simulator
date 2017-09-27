

public class Car
{
   private String description;
   private int x;
   private int y;
   GasTank gasTank;
   Engine engine;
   public Car(String description, int fuelCapacity, Engine engine)
   {
      if(description.length() == 0)
         this.description = "Generic Car";
      else
         this.description = description;
      if(engine == null)
         this.engine = new Engine("", 0, 0);
      else
         this.engine = engine;
      gasTank = new GasTank(fuelCapacity);
   }
   public String getDescription()
   {
      //formating the gas level to have two decimals
      String level = String.format("%.2f", gasTank.getLevel());
      String fullDescription = description + " (engine: " + engine.getDescription() + "), fuel: "
             + level + "/" + gasTank.getCapacity() + ", location: (" + x + "," + y + ")";

      return fullDescription;
   }
   public int getX()
   {
      return x;
   }
   public int getY()
   {
      return y;
   }
   public double getFuelLevel()
   {
      return gasTank.getLevel();
   }
   public int getMPG()
   {
      return engine.getMpg();
   }
   public void fillUp()
   {
      gasTank.setLevel(gasTank.getCapacity());
   }
   public int getMaxSpeed()
   {
      return engine.getMaxSpeed();
   }
   public double drive(int distance, double xRatio, double yRatio)
   {
      //if statement to tell if there is enough gas to go the distance
      if((distance/engine.getMpg()) > gasTank.getLevel())
         distance = (int)gasTank.getLevel() * engine.getMpg();
      double distanceDrove = 0;
      double totalDistance = 0;
      double gasUsed = 0;
      double newX = x;
      double newY = y;
      //loop to change the x and y incrementally until they reach the distance or run out of gas
      while(totalDistance < distance && gasTank.getLevel() > 0)
      {
         distanceDrove = 0;
         gasUsed = 0;
         distanceDrove = Math.sqrt((xRatio)*(xRatio) + (yRatio)*(yRatio));
         //if statement to tell if the distance drove in this loop is is greater than the distance parameter when added up
         if(distanceDrove > (distance - totalDistance))
         {
            //y-intercept
            double b;
            //slope of the line
            double slope = yRatio/xRatio;
            distanceDrove = distance - totalDistance;
            b = newY - slope * newX;
            //while loop to increment the x and y locations in order to get the correct distance
            while((Math.sqrt(((newX) - x)*((newX) - x) + ((newY) - y)*((newY) - y))) < distanceDrove)
            {
               //checking to see if the x ration is positive or negative, if  negative subtract if positive add to x
               if(xRatio < 0)
                  newX += -0.1;
               else
                  newX += 0.1;
               //calculating the new y value with equation y = mx + b
               newY = slope * newX + b;
            }
         }
         else
         {
            newX += xRatio;
            newY += yRatio;
         }
         gasUsed = distanceDrove/engine.getMpg();
         gasTank.setLevel(gasTank.getLevel() - gasUsed);
         totalDistance += distanceDrove;
         this.x = (int)newX;
         this.y = (int)newY;
      }
      //if statement for the case when it runs out of gas
      if(gasTank.getLevel() <= 0)
         System.out.printf("Ran out of gas after driving %.2f miles\n", totalDistance);
      return totalDistance;
   }
}
