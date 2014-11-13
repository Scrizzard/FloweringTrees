import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


/**
 * A class representing someone who is subscribed
 * to a TreeCollector.
 * 
 * @author Filip de Figueiredo, Benji Weichman, Reese Wilkin. 
 * @date November 12th, 2014
 */
public class TreeSubscriber implements Observer{

	private ArrayList<String> bloomingNames;
	private String name;
	
	/**
	 * TreeSubscriber constructor creates a new TreeSubscriber from a TreeCollector.
	 * 
	 * @param treeCollect TreeCollector object from which to create the TreeSubscriber.
	 */
	
	public TreeSubscriber(String name){
		bloomingNames = new ArrayList<String>();
		this.name = name;
	}
	
	/**
	 * Prints the names of the trees that are currently blooming.
	 */
	public void printBloomingTrees(){
		System.out.println(name + " knows these trees are blooming: ");
		for(int i = 0 ; i < bloomingNames.size() ; i++){
			System.out.println("  " + bloomingNames.get(i));
		}	
	}
	
	/** Updates the bloomingTrees known to this observer.
	 */
	public void update(Observable self, Object bloomingTrees) {
		this.bloomingNames = (ArrayList<String>) bloomingTrees;
	}

	/**
	 * accessor for the list of currently blooming tree names
	 * @return list of names of blooming trees
	 */
	public ArrayList<String> getBloomingTrees(){
		return bloomingNames;
	}
	
	public String getName(){
		return name;
	}
}
