import java.util.ArrayList;
import java.util.Observable;

/**
 * A Class that checks a list of trees to see if they are in bloom. 
 * Updates its observers about bloom changes.
 * 
 * @author Filip de Figueiredo, Benji Weichman, Reese Wilkin. 
 * @date November 12th, 2014
 */
public class TreeCollector extends Observable{
	private ArrayList<Tree> observedTrees;
	private ArrayList<String> bloomingTrees;
	
	/**
	 * Checks to see which trees are in bloom.
	 * Updates the bloomingTrees list, and 
	 * notifies all its observers about the new
	 * bloom list.
	 */
	public void queryTrees() {
		bloomingTrees.clear();
		for(Tree q : observedTrees){
			if(q.isFlowering()){
				bloomingTrees.add(q.getName());
			}
		}
		setChanged();
		this.notifyObservers(bloomingTrees);
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
	}
	/**
	 * Removes the input tree from the observedTree list.
	 * @param oldTree to be removed from the list
	 */
	public void removeTree(Tree oldTree) {
		observedTrees.remove(oldTree);
	}
}
