import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * A class representing a Tree that can flower within a Gregorian date.
 * @author Filip de Figueiredo, Benji Weichman, Reese Wilkin. 
 * @date November 12th, 2014
 */
public class Tree {

	/**
	 * bloomRanges- a list of 2-tuples describing blooming periods of this tree
	 * name-		the name of this tree
	 */
	private ArrayList<GregorianCalendar[]> bloomRanges;
	private String name;
	
	/**
	 * Tree constructor, takes in a name and creates a new tree
	 * @param name- the new tree's name
	 */
	public Tree(String name){
		this.name = name;
		bloomRanges = new ArrayList<GregorianCalendar[]>();
	}
	
	/**
	 * Tree constructor, takes in a name and a range. Ceates a new tree with that range.
	 * @param name- the new tree's name
	 */
	public Tree(String name,GregorianCalendar[] range){
		this.name = name;
		bloomRanges = new ArrayList<GregorianCalendar[]>();
		bloomRanges.add(range);
	}
	
	/**
	 * Add a new blooming period for this tree
	 * @param range- a 2-tuple of dates between which the tree blooms
	 */
	public void addBloomRange(GregorianCalendar[] range){
		if(range.length != 2){
			System.out.println("error in Tree#addBloomRange: new range must be a length 2 array");
		}
		else{
			bloomRanges.add(range);
		}
	}
	
	/**
	 * Determines whether the current date and time is within any blooming ranges
	 * @return true if the tree is blooming, false if not
	 */
	public boolean isFlowering(){
		
		GregorianCalendar now = new GregorianCalendar();
		
		for(GregorianCalendar[] range : bloomRanges){
			if (now.compareTo(range[0]) > 0 &&	now.compareTo(range[1]) < 0){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * accessor for name field
	 * @return the tree's name
	 */
	public String getName(){
		return name;
	}
	
	//test method
	public static void main(String[] args){
		Tree tree = new Tree("dogwood");
		
		GregorianCalendar[] range = new GregorianCalendar[2];
		range[0] = new GregorianCalendar(2000, GregorianCalendar.MAY, 17);
		range[1] = new GregorianCalendar(2050, GregorianCalendar.MAY, 17);

		tree.addBloomRange(range);
		System.out.println(tree.isFlowering());
	}
}
