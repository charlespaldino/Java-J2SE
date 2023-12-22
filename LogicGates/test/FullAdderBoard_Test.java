import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import CircuitBoards.BasicBoards.FullAdderBoard;

/**
 * 0 0 0 = 0 0
 * 1 0 0 = 1 0
 * 0 1 0 = 1 0
 * 1 1 0 = 0 1
 * 0 0 1 = 1 0
 * 1 0 1 = 0 1
 * 0 1 1 = 0 1
 * 1 1 1 = 1 1
 */
class FullAdderBoard_Test {

	public static FullAdderBoard fulladder;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		fulladder = new FullAdderBoard();
	}


	@Test
	void test_000() 
	{
		//0 0 0 = 0 0
		fulladder.getInputConnectors().get(0).setValue(false);
		fulladder.getInputConnectors().get(1).setValue(false);
		fulladder.getInputConnectors().get(2).setValue(false);

		fulladder.compute();

		assertFalse(fulladder.getOutputConnectors().get(0).getValue());
		assertFalse(fulladder.getOutputConnectors().get(1).getValue());
	}


	@Test
	void test_100() 
	{
		//1 0 0 = 1 0
		fulladder.getInputConnectors().get(0).setValue(true);
		fulladder.getInputConnectors().get(1).setValue(false);
		fulladder.getInputConnectors().get(2).setValue(false);

		fulladder.compute();

		assertTrue(fulladder.getOutputConnectors().get(0).getValue());
		assertFalse(fulladder.getOutputConnectors().get(1).getValue());
	}

	@Test
	void test_010() 
	{
		//0 0 1 = 1 0
		fulladder.getInputConnectors().get(0).setValue(false);
		fulladder.getInputConnectors().get(1).setValue(false);
		fulladder.getInputConnectors().get(2).setValue(true);

		fulladder.compute();

		assertTrue(fulladder.getOutputConnectors().get(0).getValue());
		assertFalse(fulladder.getOutputConnectors().get(1).getValue());
	}

	@Test
	void test_110() 
	{
		//1 1 0 = 0 1
		fulladder.getInputConnectors().get(0).setValue(true);
		fulladder.getInputConnectors().get(1).setValue(true);
		fulladder.getInputConnectors().get(2).setValue(false);

		fulladder.compute();

		assertFalse(fulladder.getOutputConnectors().get(0).getValue());
		assertTrue(fulladder.getOutputConnectors().get(1).getValue());
	}

	@Test
	void test_001() 
	{
		//0 0 1 = 1 0
		fulladder.getInputConnectors().get(0).setValue(false);
		fulladder.getInputConnectors().get(1).setValue(false);
		fulladder.getInputConnectors().get(2).setValue(true);

		fulladder.compute();

		assertTrue(fulladder.getOutputConnectors().get(0).getValue());
		assertFalse(fulladder.getOutputConnectors().get(1).getValue());
	}

	@Test
	void test_101() 
	{
		//1 0 1 = 0 1
		fulladder.getInputConnectors().get(0).setValue(true);
		fulladder.getInputConnectors().get(1).setValue(false);
		fulladder.getInputConnectors().get(2).setValue(true);

		fulladder.compute();

		assertFalse(fulladder.getOutputConnectors().get(0).getValue());
		assertTrue(fulladder.getOutputConnectors().get(1).getValue());
	}

	@Test
	void test_011() 
	{
		//0 1 1 = 0 1
		fulladder.getInputConnectors().get(0).setValue(false);
		fulladder.getInputConnectors().get(1).setValue(true);
		fulladder.getInputConnectors().get(2).setValue(true);

		fulladder.compute();

		assertFalse(fulladder.getOutputConnectors().get(0).getValue());
		assertTrue(fulladder.getOutputConnectors().get(1).getValue());
	}

	@Test
	void test_111() 
	{
		//1 1 1 = 1 1
		fulladder.getInputConnectors().get(0).setValue(true);
		fulladder.getInputConnectors().get(1).setValue(true);
		fulladder.getInputConnectors().get(2).setValue(true);

		fulladder.compute();

		assertTrue(fulladder.getOutputConnectors().get(0).getValue());
		assertTrue(fulladder.getOutputConnectors().get(1).getValue());
	}


}
