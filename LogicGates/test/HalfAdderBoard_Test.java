import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import CircuitBoards.BasicBoards.HalfAdderBoard;

/**
 * 0 0 = 0 0
 * 1 0 = 1 0
 * 0 1 = 1 0
 * 1 1 = 0 0
 */
class HalfAdderBoard_Test {

	public static HalfAdderBoard halfadder;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		halfadder = new HalfAdderBoard();
	}

	@Test
	void test_00() 
	{
		//== 0 0 = 0 0
		halfadder.getInputConnectors().get(0).setValue(false);
		halfadder.getInputConnectors().get(1).setValue(false);

		halfadder.compute();

		assertFalse(halfadder.getOutputConnectors().get(0).getValue());
		assertFalse(halfadder.getOutputConnectors().get(1).getValue());
	}

	@Test
	void test_10() 
	{
		//== 1 0 = 1 0
		halfadder.getInputConnectors().get(0).setValue(true);
		halfadder.getInputConnectors().get(1).setValue(false);

		halfadder.compute();

		assertTrue(halfadder.getOutputConnectors().get(0).getValue());
		assertFalse(halfadder.getOutputConnectors().get(1).getValue());
	}

	@Test
	void test_01() 
	{
		//== 0 1 = 1 0
		halfadder.getInputConnectors().get(0).setValue(true);
		halfadder.getInputConnectors().get(1).setValue(false);

		halfadder.compute();

		assertTrue(halfadder.getOutputConnectors().get(0).getValue());
		assertFalse(halfadder.getOutputConnectors().get(1).getValue());
	}

	@Test
	void test_11() 
	{
		//== 1 1 = 0 1
		halfadder.getInputConnectors().get(0).setValue(true);
		halfadder.getInputConnectors().get(1).setValue(true);

		halfadder.compute();

		assertFalse(halfadder.getOutputConnectors().get(0).getValue());
		assertTrue(halfadder.getOutputConnectors().get(1).getValue());
	}
	

}