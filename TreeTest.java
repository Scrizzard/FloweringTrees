import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.Test;


public class TreeTest {

	@Test
	public void testGoodName() {
		Tree tree = new Tree("testy");
		assertTrue(tree.getName().equals("testy"));
	}

	@Test
	public void testNullName() {
		Tree tree = new Tree(null);
		assertFalse(tree.getName() == null);
	}

	@Test
	public void testEmptyName() {
		Tree tree = new Tree("");
		assertFalse(tree.getName().equals(""));
	}

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
	
	@Test
	public void testFloweringTrue(){
		GregorianCalendar[] goodRange = {new GregorianCalendar(1000, GregorianCalendar.JANUARY, 0), new GregorianCalendar(10000, GregorianCalendar.JANUARY, 0)};
		Tree tree = new Tree("testTree", goodRange);
		
		assertTrue(tree.isFlowering());
	}
	
	@Test
	public void testFloweringFalse(){
		GregorianCalendar[] goodRange = {new GregorianCalendar(1000, GregorianCalendar.JANUARY, 0), new GregorianCalendar(1001, GregorianCalendar.JANUARY, 0)};
		Tree tree = new Tree("testTree", goodRange);
		assertFalse(tree.isFlowering());
	}
	
	@Test
	public void testFloweringNoRanges(){
		Tree tree = new Tree("testTree");
		assertFalse(tree.isFlowering());
	}
	
	
}


