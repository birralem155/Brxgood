/**This is class Road. It can repersent the edges of a graph of Town. The class must implement comparable 
 * @author Berhanu
 *
 */
public class Road implements Comparable<Road>
{
  
   private Town source;
   private Town destination;
   private int degree;
   private String name;
  
   /**
    * Constructor
    * @param source
    * @param destination
    * @param degree
    * @param name
    */
   public Road(Town source, Town destination,int degree, String name)
   {
       this.source = source;
       this.destination = destination;
       this.degree = 1;
       this.name = name;      
   }
  /**
   * Constructor with weight preset at1
   * @param source
   * @param destination
   * @param name
   */
   public Road(Town source, Town destination, String name)
   {
       this.source = source;
       this.destination =destination;
       this.degree = 1;
       this.name = name;      
   }
/**
 * 
 * @return the first town on the road
 */
   public Town getSource()
   {
       return source;
   }
/**
 * 
 * @return the second town on the road
 */
   public Town getDestination()
   {
       return destination;
   }
 /**
  *  
  * @return
  */
   public int getDegree()
   {
       return degree;
   }
 /**
  *  
  * @return the name of the road
  */
   public String getName()
   {
       return name;
   }
 /**
  *  sets the source
  * @param source
  */
   // setter for the data field endPoint1
   public void setSource(Town source)
   {
       this.source = source;
   }
/**
 * 
 * @param destination
 */
   public void setDestination(Town destination)
   {
       this.destination= destination;
   }  
/**
 * 
 * @param distance
 */
   public void setDegree(int degree)
   {
       this.degree = degree;
   }
  /**
   * 
   * @param name of the road
   */
   public void setName(String name)
   {
       this.name = name;
   }

   /**
    * to sting method 
    */
   public String toString()
   {
       return "Road{" + "source" + source.getName() + ", destination=" + destination.getName() + ", Name=" + name + ", degree=" + degree + '}';
   }
  
   /**compare to in interface java. lang comparable<Road>
    * 
    */
   public int compareTo(Road other)
   {
       if (this.degree < (other.degree))
           return -1;
       else if (this.degree > (other.degree))
           return 1;
       else
           return 0;
   }
/**
 * 
 * @param sourceVertex
 * @return true only if the edge contains the given town 
 */
   public boolean contains(Town sourceVertex)
   {
       return (source.compareTo(sourceVertex) == 0 || destination.compareTo(sourceVertex) == 0);
   }
} 
