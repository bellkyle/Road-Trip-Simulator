
public class Engine
{
   private String engineType;
   private int mpg;
   private int maxSpeed;
   public Engine(String engineType, int mpg, int maxSpeed)
   {
      if(engineType.length() == 0)
         this.engineType = "Generic engine";
      else
         this.engineType = engineType;

      if(mpg < 0)
         this.mpg = 0;
      else
         this.mpg = mpg;

      if(maxSpeed < 0)
         this.maxSpeed = 0;
      else
         this.maxSpeed = maxSpeed;

   }
   public String getDescription()
   {
      String description;
      description = engineType + " (MPG: " + mpg + ", Max speed: " + maxSpeed + ")";
      return description;
   }
   public int getMpg()
   {
      return this.mpg;
   }
   public int getMaxSpeed()
   {
      return this.maxSpeed;
   }

}
