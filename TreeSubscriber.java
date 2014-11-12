import java.util.ArrayList;

public class TreeSubscriber {

	TreeCollector collector;
	
	/**
	 * TreeSubscriber constructor creates a new TreeSubscriber from a TreeCollector.
	 * 
	 * @param treeCollect TreeCollector object from which to create the TreeSubscriber.
	 */
	
	TreeSubscriber(TreeCollector treeCollect){
		collector = treeCollect;
	}
	
	/**
	 * Prints the names of the trees that are currently blooming.
	 */
	public void printBloomingTrees(){
		collector.queryTrees();
		ArrayList<String> blooming = collector.getBloomingTreeNames();
		System.out.println("Currently blooming trees: ");
		for(int i = 0 ; i < blooming.size() ; i++){
			System.out.println(blooming.get(i));
		}	
	}

}
