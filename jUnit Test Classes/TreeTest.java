import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.Test;

/**
 * A class to test the Tree class.
 * 
 * @author Filip de Figueiredo, Benji Weichman, Reese Wilkin. 
 * @date November 12th, 2014
 */

public class TreeTest {

	/**
	 * test tree initialization with a good name
	 */
	
	@Test
	public void testGoodName() {
		Tree tree = new Tree("testy");
		assertTrue(tree.getName().equals("testy"));
	}

	/**
	 * test tree initialization with a null name
	 */
	
	@Test
	public void testNullName() {
		Tree tree = new Tree(null);
		assertEquals(tree.getName(), "unnamed tree");
	}

	/**
	 * test tree initialization with an empty name
	 */
	
	@Test
	public void testEmptyName() {
		Tree tree = new Tree("");
		assertEquals(tree.getName(), "unnamed tree");
	}

	/**
	 * test initializing a tree with a valid date range
	 */
	
	@Test
	public void testGoodDateRange() {
		GregorianCalendar[] goodRange = {new GregorianCalendar(), new GregorianCalendar()};		
		Tree tree = new Tree("testTree", goodRange);

		Field field;
		
		try {
			field = tree.getClass().getDeclaredField("bloomRanges");
			field.setAccessible(true);
			ArrayList<GregorianCalendar[]> rangeList = (ArrayList<GregorianCalendar[]>) field.get(tree);	
			assertEquals(rangeList.size(), 1);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {}
	}
	
	
	/**
	 * test initializing tree with a null date range
	 */
	
	@Test
	public void testNullDateRange() {
		GregorianCalendar[] nullRange = null;
		Tree tree = new Tree("testTree", nullRange);

		Field field;
		
		try {
			field = tree.getClass().getDeclaredField("bloomRanges");
			field.setAccessible(true);
			ArrayList<GregorianCalendar[]> rangeList = (ArrayList<GregorianCalendar[]>) field.get(tree);	
			assertEquals(rangeList.size(), 0);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {}
	}	
	
	/**
	 * test initializing tree with a date range with too few bounds
	 */
	
	@Test
	public void testShortDateRange() {
		GregorianCalendar[] shortRange = {new GregorianCalendar()};
		Tree tree = new Tree("testTree", shortRange);

		Field field; 
		
		try {
			field = tree.getClass().getDeclaredField("bloomRanges");
			field.setAccessible(true);
			ArrayList<GregorianCalendar[]> rangeList = (ArrayList<GregorianCalendar[]>) field.get(tree);	
			assertEquals(rangeList.size(), 0);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {}
	}
	
	/**
	 * test initializing tree with a date range with too many bounds
	 */
	
	@Test
	public void testLongDateRange() {
		GregorianCalendar[] longRange = {new GregorianCalendar(), new GregorianCalendar(), new GregorianCalendar()};
		Tree tree = new Tree("testTree", longRange);

		Field field;
		
		try {
			field = tree.getClass().getDeclaredField("bloomRanges");
			field.setAccessible(true);
			ArrayList<GregorianCalendar[]> rangeList = (ArrayList<GregorianCalendar[]>) field.get(tree);	
			assertEquals(rangeList.size(), 0);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {}
	}

	/**
	 * test initializing tree with a date range with the bounds flipped
	 */
	
	@Test
	public void testBackwardsDateRange() {
		GregorianCalendar[] backwardsRange = {new GregorianCalendar(1001, GregorianCalendar.JANUARY, 0), new GregorianCalendar(1000, GregorianCalendar.JANUARY, 0)};
		Tree tree = new Tree("testTree", backwardsRange);

		Field field;
		
		try {
			field = tree.getClass().getDeclaredField("bloomRanges");
			field.setAccessible(true);
			ArrayList<GregorianCalendar[]> rangeList = (ArrayList<GregorianCalendar[]>) field.get(tree);	
			assertEquals(rangeList.size(), 0);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {}
	}
	
	/**
	 * test that a tree flowers when it ought to
	 */
	
	@Test
	public void testFloweringTrue(){
		GregorianCalendar[] goodRange = {new GregorianCalendar(1000, GregorianCalendar.JANUARY, 0), new GregorianCalendar(10000, GregorianCalendar.JANUARY, 0)};
		Tree tree = new Tree("testTree", goodRange);
		
		assertTrue(tree.isFlowering());
	}
	
	/**
	 * test that a tree does not flower when it shouldn't
	 */
	
	@Test
	public void testFloweringFalse(){
		GregorianCalendar[] goodRange = {new GregorianCalendar(1000, GregorianCalendar.JANUARY, 0), new GregorianCalendar(1001, GregorianCalendar.JANUARY, 0)};
		Tree tree = new Tree("testTree", goodRange);
		assertFalse(tree.isFlowering());
	}
	
	/**
	 * test that a tree does not flower when it has no flowering date ranges
	 */
	
	@Test
	public void testFloweringNoRanges(){
		Tree tree = new Tree("testTree");
		assertFalse(tree.isFlowering());
	}
	
	
}


