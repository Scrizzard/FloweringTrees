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

	private ArrayList<String> bloomingTrees;
	private String name;
	
	/**
	 * TreeSubscriber constructor creates a new TreeSubscriber from a TreeCollector.
	 * 
	 * @param treeCollect TreeCollector object from which to create the TreeSubscriber.
	 */
	
	public TreeSubscriber(String name){
		bloomingTrees = new ArrayList<String>();
		this.name = name;
	}
	
	/**
	 * Prints the names of the trees that are currently blooming.
	 */
	public void printBloomingTrees(){
		System.out.println(name + " knows these trees are blooming: ");
		for(int i = 0 ; i < bloomingTrees.size() ; i++){
			System.out.println("  " + bloomingTrees.get(i));
		}	
	}
	
	/** Updates the bloomingTrees known to this observer.
	 */
	public void update(Observable self, Object bloomingTrees) {
		this.bloomingTrees = (ArrayList<String>) bloomingTrees;
	}

	/**
	 * accessor for the list of currently blooming tree names
	 * @return list of names of blooming trees
	 */
	public ArrayList<String> getBloomingTrees(){
		return bloomingTrees;
	}
}
