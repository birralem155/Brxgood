import java.util.*;
import java.util.Map.Entry;
/**
 * 
 * @author User
 *
 */
public class TownGraph implements GraphInterface<Town, Road>
{
   private HashSet<Town> towns;
   private HashSet<Road> roads;

   public TownGraph()
   {
       towns = new HashSet<Town>();
       roads = new HashSet<Road>();
   }

   
    public Road getEdge(Town sourceVertex, Town destinationVertex)
   {
       for(Road road : roads)
       {
           if(((road.getSource().compareTo(sourceVertex) == 0) && (road.getDestination().compareTo(destinationVertex) == 0))
                   || ((road.getSource().compareTo(sourceVertex) == 0) && (road.getDestination().compareTo(destinationVertex) == 0)))
               return road;

       }
       return null;
   }

  /**
   * 
   */
   public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description)
   {
       Road road = new Road(sourceVertex, destinationVertex,weight, description);
       roads.add(road);
       sourceVertex.addAdjacentTown(destinationVertex, weight);
       destinationVertex.addAdjacentTown(sourceVertex, weight);

       return road;
   }

  
   public boolean addVertex(Town v)
   {
       return towns.add(v);
   }

  
   public boolean containsEdge(Town sourceVertex, Town destinationVertex)
   {
       for(Road road : roads)
       {
           if(road.contains(sourceVertex) && road.contains(destinationVertex))
               return true;

       }
       return false;
   }

   @Override
   public boolean containsVertex(Town v)
   {
       for(Town town : towns)
       {
           if(town.getName().compareToIgnoreCase(v.getName()) == 0)
               return true;
       }
      
       return false;
   }

   /**
    * 
    */
   public Set<Road> edgeSet()
   {
       return roads;
   }

   /**
    * 
    */
   public Set<Road> edgesOf(Town vertex)
   {
       Set<Road> res = new HashSet<Road>();
       for(Road road : this.roads)
       {
           if(road.contains(vertex))
               res.add(road);
       }
       return res;
   }

   
   public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description)
   {
       Road road = new Road(sourceVertex, destinationVertex,weight, description);
       roads.remove(road);
       return road;
   }

   
   public boolean removeVertex(Town v)
   {
       return towns.remove(v);
   }

   
   public Set<Town> vertexSet()
   {
       return towns;
   }

   
   public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex)
   {
       dijkstraShortestPath(sourceVertex);
      
       ArrayList<String> sp = new ArrayList<String>();
       LinkedList<Town> listOfTowns = destinationVertex.getShortestPath();
      
       for(int i = 0; i < listOfTowns.size(); i++)
       {
           sp.add(listOfTowns.get(i).toString());                  
       }
       sp.add(destinationVertex.toString());
      
       return sp;
   }

   
   public void dijkstraShortestPath(Town sourceVertex)
   {
       sourceVertex.setDistance(0);
       Set<Town> setOfTowns1 = new HashSet<>();
       Set<Town> setOfTowns2 = new HashSet<>();
       setOfTowns2.add(sourceVertex);

       while(setOfTowns2.size() != 0)
       {
           Town currentTown = getLowestDistanceTown(setOfTowns2);
           setOfTowns2.remove(currentTown);
          
           for(Entry<Town, Integer> entry : currentTown.getAdjacentTowns().entrySet())
           {
               Town adjTown = entry.getKey();
               Integer edgeWeight = entry.getValue();
              
               if(!setOfTowns1.contains(adjTown))
               {
                   findMinDistance(adjTown, edgeWeight, currentTown);
                   setOfTowns2.add(adjTown);
               }
           }
           setOfTowns1.add(currentTown);
       }
   }

   private static Town getLowestDistanceTown(Set<Town> setOfTowns)
   {
       Town lowDistanceTown = null;
       int lowDistance = Integer.MAX_VALUE;
       for(Town town : setOfTowns)
       {
           int townDistance = town.getDistance();
           if(townDistance < lowDistance)
           {
               lowDistance = townDistance;
               lowDistanceTown = town;
           }
       }
       return lowDistanceTown;
   }

   private static void findMinDistance(Town evaluationTown, Integer edgeWeigh, Town sourceTown)
   {
       Integer sourceTownDistance = sourceTown.getDistance();
       if(sourceTownDistance + edgeWeigh < evaluationTown.getDistance())
       {
           evaluationTown.setDistance(sourceTownDistance + edgeWeigh);
           LinkedList<Town> sp = new LinkedList<>(sourceTown.getShortestPath());
           sp.add(sourceTown);
           evaluationTown.setShortestPath(sp);
       }
   }
}