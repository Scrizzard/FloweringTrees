import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Observer;

public class TestClass {

	public static void main(String[] args){
		ArrayList<Tree> trees = setUpTrees();
		ArrayList<TreeSubscriber> subscribers = setUpSubscribers();
		TreeCollector collector = setUpCollector(trees, subscribers);
		runSimulation(collector, subscribers);
	}

	private static ArrayList<Tree> setUpTrees() {
		ArrayList<Tree> trees = new ArrayList<Tree>();

		GregorianCalendar[] juneRange = {new GregorianCalendar(2014, GregorianCalendar.JUNE, 0), new GregorianCalendar(2014, GregorianCalendar.JUNE, 30)};
		Tree juneTree = new Tree("june tree", juneRange);
		trees.add(juneTree);

		GregorianCalendar[] novemberRange = {new GregorianCalendar(2014, GregorianCalendar.NOVEMBER, 0), new GregorianCalendar(2014, GregorianCalendar.NOVEMBER, 30)};		
		Tree novemberTree = new Tree("november tree", novemberRange);
		trees.add(novemberTree);
		
		Tree neverTree = new Tree("never tree");
		trees.add(neverTree);
		
		GregorianCalendar[] alwaysRange = {new GregorianCalendar(1000, GregorianCalendar.JANUARY, 0), new GregorianCalendar(10000, GregorianCalendar.JANUARY, 0)};		
		Tree alwaysTree = new Tree("always tree", alwaysRange);
		trees.add(alwaysTree);
		
		return trees;
	}
	
	private static ArrayList<TreeSubscriber> setUpSubscribers(){
		ArrayList<TreeSubscriber> subscribers = new ArrayList<TreeSubscriber>();
		
		TreeSubscriber redBug = new TreeSubscriber("red bug");
		subscribers.add(redBug);
		TreeSubscriber blueBug = new TreeSubscriber("blue bug");
		subscribers.add(blueBug);
		
		return subscribers;
	}
	
	private static TreeCollector setUpCollector(ArrayList<Tree> trees, ArrayList<TreeSubscriber> subscribers){
		TreeCollector collector = new TreeCollector();
		
		for(TreeSubscriber subscriber : subscribers){
			collector.addObserver(subscriber);
		}
		
		for(Tree tree : trees){
			collector.addTree(tree);
		}
		
		return collector;
	}
	
	private static void runSimulation(TreeCollector collector, ArrayList<TreeSubscriber> subscribers){
		System.out.println("In this simulation, the observable instance will update its attached observers every ten seconds.");
		while(true){
			collector.queryTrees();
			for(TreeSubscriber subscriber : subscribers){
				subscriber.printBloomingTrees();
			}
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {}
			
		}
	}
	
}
