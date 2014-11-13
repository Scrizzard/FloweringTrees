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
	private ArrayList<String> bloomingTrees;
	
	/**
	 * Construct a new TreeCollector
	 */
	public TreeCollector(){
		observedTrees = new ArrayList<Tree>();
		bloomingTrees = new ArrayList<String>();
	}
	
	public void queryTrees() {
		ArrayList<String> oldBlooming = new ArrayList<String>(bloomingTrees);
		bloomingTrees.clear();
		for(Tree tree : observedTrees){
			if(tree.isFlowering()){
				bloomingTrees.add(tree.getName());
			}
		}
		
		if(!bloomingTrees.equals(oldBlooming)){
			setChanged();
			this.notifyObservers(bloomingTrees);
			clearChanged();
		}
	}
	
	/**
	 * Returns the currently blooming trees known by this collector.
	 * @return list of currently blooming trees.
	 */
	public ArrayList<String> getBloomingTreeNames() {
		return bloomingTrees;
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
