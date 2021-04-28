import java.util.*;
/**
 * 
 * @author Berhanu Belihu
 *
 */
public class Town implements Comparable<Town>
{
   private String name;
   private Map<Town, Integer> adjacentTowns;
  
   private LinkedList<Town> shortestPath;
   private Integer distance;

   public Town()
   {
       super();
       this.adjacentTowns = new HashMap<Town, Integer>();
       this.shortestPath = new LinkedList<Town>();
       this.distance = Integer.MAX_VALUE;
   }
   /**
    * Constructor requires town's name 
    */
   public Town(String name)
   {
       this.name = name;
       this.adjacentTowns = new HashMap<Town, Integer>();
       this.shortestPath = new LinkedList<Town>();
       this.distance = Integer.MAX_VALUE;
   }

   public Town(String name, Map<Town, Integer> adjacentTowns)
   {
       this.name = name;
       this.adjacentTowns = adjacentTowns;
       this.shortestPath = new LinkedList<Town>();
       this.distance = Integer.MAX_VALUE;
   }
/**
 * 
 * @return town's name 
 */
   public String getName()
   {
       return name;
   }

   /**
    * 
    * @return
    */
   public Map<Town, Integer> getAdjacentTowns()
   {
       return adjacentTowns;
   }
  /**
   * 
   * @param name
   */
   public void setName(String name)
   {
       this.name = name;
   }
/**
 * 
 * @param AdjTowns
 */
   public void setAdjTowns(Map<Town, Integer> AdjTowns)
   {
       this.adjacentTowns = AdjTowns;
   }

   /**
    * 
    */
   public String toString()
   {
       return "Town{" + "Name=" + name + ", AdjTowns=" + adjacentTowns.values() + "}";
   }

   /**compareTo in interface java.lang .comparable<Town>
    * return 0 if the names are equal, a positive or negative number if the names are not equal
    */
   public int compareTo(Town other)
   {
       if (name.compareToIgnoreCase(other.name) < 0)
           return -1;
       else if (name.compareToIgnoreCase(other.name) > 0)
           return 1;
       else
           return 0;
   }

   public void addAdjacentTown(Town destinationTown, int distance)
   {
       this.adjacentTowns.put(destinationTown, distance);
   }
/**
 * 
 * @return the shortes path
 */
   public LinkedList<Town> getShortestPath()
   {
       return shortestPath;
   }

   public void setDistance(int distance)
   {
       this.distance = distance;
   }
/**
 * 
 * @return the Distance
 */
   public int getDistance()
   {
       return distance;
   }
/**
 * sets the shortes path
 * @param shortestPath
 */
   public void setShortestPath(LinkedList<Town> shortestPath)
   {
       this.shortestPath = shortestPath;
   }
}