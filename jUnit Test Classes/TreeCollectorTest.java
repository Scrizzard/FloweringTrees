import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Observer;

import org.junit.Before;
import org.junit.Test;

public class TreeCollectorTest {

	TreeCollector collector;

	@Before
	public void setUp() throws Exception {
		collector = new TreeCollector();
	}

	/**
	 * access the names of blooming trees without ever querying the trees
	 */
	
	@Test
	public void testBloomingNoQuery() {
		assertEquals(collector.getBloomingNames().size(), 0);
	}
	
	/**
	 * access the names of blooming threes after querying, but without any trees
	 */
	
	@Test
	public void testBloomingNoTrees() {
		collector.queryTrees();
		assertEquals(collector.getBloomingNames().size(), 0);
	}

	/**
	 * assert that there are no observers before adding any
	 */
	
	@Test
	public void testZeroObservers() {
		assertEquals(collector.countObservers(), 0);
	}
	
	/**
	 * assert that there is one observer after adding one
	 */
	
	@Test
	public void testOneObserver() {
		TreeSubscriber subscriber = new TreeSubscriber("test");
		collector.addObserver(subscriber);
		assertEquals(collector.countObservers(), 1);
	}
	
	/**
	 * assert that there are zero trees before adding any
	 */
	
	@Test
	public void testZeroTree() {
	
	Field field; 
		
		try {
			field = collector.getClass().getDeclaredField("observedTrees");
			field.setAccessible(true);
			ArrayList<Tree> treeList = (ArrayList<Tree>) field.get(collector);	
			assertEquals(treeList.size(), 0);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {} 	
	}
	
	
	/**
	 * assert that there is one tree after adding one
	 */
	
	@Test
	public void testAddingTree() {
	
	collector.addTree(new Tree("test"));
	Field field; 
		
		try {
			field = collector.getClass().getDeclaredField("observedTrees");
			field.setAccessible(true);
			ArrayList<Tree> treeList = (ArrayList<Tree>) field.get(collector);	
			assertEquals(treeList.size(), 1);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {} 	
	}
	
	/**
	 * assert that there are no trees after adding and removing one
	 */
	
	@Test
	public void testRemovingTree() {
	
	Tree test = new Tree("test");
	collector.addTree(test);
	collector.removeTree(test);
	Field field;
		try {
			field = collector.getClass().getDeclaredField("observedTrees");
			field.setAccessible(true);
			ArrayList<Tree> treeList = (ArrayList<Tree>) field.get(collector);	
			assertEquals(treeList.size(), 0);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {} 	
	}
}