import java.util.ArrayList;
import java.util.Observable;

/**
 * Observable class that holds a list of trees and checks if they are in bloom. 
 * Updates its observers about bloom changes.
 * 
 * @author Filip de Figueiredo, Benji Weichman, Reese Wilkin. 
 * @date November 12th, 2014
 */
public class TreeCollector extends Observable{
	private ArrayList<Tree> observedTrees;
	private ArrayList<String> bloomingNames;
	
	/**
	 * Construct a new TreeCollector
	 */
	public TreeCollector(){
		observedTrees = new ArrayList<Tree>();
		bloomingNames = new ArrayList<String>();
	}
	
	/**
	 * If any blooming changes have occurred among the observed trees, notify all subscribers
	 */
	public void queryTrees() {
		ArrayList<String> oldBlooming = new ArrayList<String>(bloomingNames);
		bloomingNames.clear();
		for(Tree tree : observedTrees){
			if(tree.isFlowering()){
				bloomingNames.add(tree.getName());
			}
		}
		
		if(!bloomingNames.equals(oldBlooming)){
			setChanged();
			notifyObservers(bloomingNames);
			clearChanged();
		}
	}
	
	/**
	 * Returns the currently blooming trees known by this collector.
	 * @return list of currently blooming trees.
	 */
	public ArrayList<String> getBloomingNames() {
		return bloomingNames;
	}
	
	/**
	 * Add the input tree to the observedTree list
	 * @param newTree to be added to the list.
	 */
	public void addTree(Tree newTree){
		observedTrees.add(newTree);
		queryTrees();
	}
	
	/**
	 * Removes the input tree from the observedTree list.
	 * @param oldTree to be removed from the list
	 */
	public void removeTree(Tree oldTree) {
		observedTrees.remove(oldTree);
		queryTrees();
	}
}
