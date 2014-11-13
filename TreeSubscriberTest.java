import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A class to test the TreeSubscriber class.
 * 
 * @author Filip de Figueiredo, Benji Weichman, Reese Wilkin. 
 * @date November 12th, 2014
 */
public class TreeSubscriberTest {
	private TreeSubscriber tester;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tester = new TreeSubscriber("Test");
	}

	/**
	 * Test method for {@link TreeSubscriber#TreeSubscriber(java.lang.String)}.
	 */
	@Test
	public void testTreeSubscriber() {
		assertNotNull(tester);
		assertSame("Test", tester.getName());
	}

	/**
	 * Test method for {@link TreeSubscriber#printBloomingTrees()}.
	 */
	@Test
	public void testPrintBloomingTrees() {
		try{
			tester.printBloomingTrees();
		}
		catch (NullPointerException e){
			fail("Attempted to print null");
		}
	}

	/**
	 * Test method for {@link TreeSubscriber#update(java.util.Observable, java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("Crabapple");
		testList.add("Bluemist");
		testList.add("Alpha");
		tester.update(new TreeCollector(), testList );
		assertEquals(testList, tester.getBloomingTrees());
	}

	/**
	 * Test method for {@link TreeSubscriber#getBloomingTrees()}.
	 */
	@Test
	public void testGetBloomingTrees() {
		assertNotNull(tester.getBloomingTrees());
		assertTrue(tester.getBloomingTrees().isEmpty());
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("Crabapple");
		testList.add("Bluemist");
		tester.update(new TreeCollector(), testList );
		assertEquals(testList, tester.getBloomingTrees());
		
	}

	/**
	 * Test method for {@link TreeSubscriber#getName()}.
	 */
	@Test
	public void testGetName() {
		assertSame("Test", tester.getName());
		TreeSubscriber second = new TreeSubscriber("samuel");
		assertSame("samuel", second.getName());
		assertNotSame("santa", second.getName());
		assertNotSame("santa", tester.getName());
	}
}
