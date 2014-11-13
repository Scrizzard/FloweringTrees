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
		setName(name);
		bloomRanges = new ArrayList<GregorianCalendar[]>();
	}
	
	/**
	 * Tree constructor, takes in a name and a range. Creates a new tree with that range.
	 * @param name- the new tree's name
	 */
	public Tree(String name, GregorianCalendar[] range){
		setName(name);
		bloomRanges = new ArrayList<GregorianCalendar[]>();
		addBloomRange(range);
	}
	
	/**
	 * Add a new blooming period for this tree
	 * @param range- a 2-tuple of dates between which the tree blooms
	 */
	public void addBloomRange(GregorianCalendar[] range){
		if(range == null || range.length != 2){
			System.out.println("error in Tree#addBloomRange: new range must be a length 2 array");
	
		}else if(range[0].compareTo(range[1]) > 0){
			System.out.println("error in Tree#addBloomRange: earlier date must be first");
		}else{
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
	
	private void setName(String name){
		
		if(name != null && name.length() > 0){
			this.name = name;
		}
		else{
			System.out.println("warning: tree name should be non-null and non-empty");
			System.out.println("         naming your tree 'unnamed tree'");
			this.name = "unnamed tree";
		}
	}
}
