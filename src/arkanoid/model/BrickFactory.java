package arkanoid.model;
/**
 * Fabriks-Klasse welche für die Erstellung von Ziegelelementen konzipiert ist.
 */
public class BrickFactory {
	/**
	 * Rückgabemethode für einen Ziegel.
	 * 
	 * @param brickType Name des zu erstellenden Ziegels.
	 * @param x X-Position des Ziegels.
	 * @param y Y-Position des Ziegels.
	 * 
	 * @return ZiegelObjekt
	 */
	   public Brick getBrick(String brickType, int x, int y){
	      if(brickType == null){
	         return null;
	      }		
	      if(brickType.equalsIgnoreCase("SINGLEBRICK")){
	          return new SingleBrick(x, y);
	      } else if(brickType.equalsIgnoreCase("MULTIBRICK")){
	    	  return new MultiBrick(x, y);
	      } else if(brickType.equalsIgnoreCase("SPECIALBRICK")){
	    	  return new SingleBrick(x, y);
	      }
	      return null;
	   }
}
