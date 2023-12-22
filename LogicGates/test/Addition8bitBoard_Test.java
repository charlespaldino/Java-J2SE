import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized.Parameters;

import CircuitBoards.BasicBoards.Addition8BitBoard;
import Connectors.Connector;

class Addition8bitBoard_Test {

	public static Addition8BitBoard add8bit_board;
	public static List<Connector>  output_connectors;
	public static List<Connector>  input_connectors;
	public static Random random;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		random = new Random();
		add8bit_board = new Addition8BitBoard();
		output_connectors = add8bit_board.getOutputConnectors();
		input_connectors = add8bit_board.getInputConnectors();
	}

	@BeforeEach
	void setUpBeforeEach() throws Exception 
	{
		random = new Random();
		for(Connector connector : input_connectors){connector.setValue(false);}	
	}



	@Test
	void BasicBitTest() 
	{
		input_connectors.get(0).setValue(true);
		input_connectors.get(1).setValue(true);
		add8bit_board.compute();

		assertFalse(output_connectors.get(0).getValue());
		assertTrue(output_connectors.get(1).getValue());

		input_connectors.get(0).setValue(true);
		input_connectors.get(1).setValue(false);
		add8bit_board.compute();

		assertTrue(output_connectors.get(0).getValue());
		assertFalse(output_connectors.get(1).getValue());

		input_connectors.get(0).setValue(false);
		input_connectors.get(1).setValue(true);
		add8bit_board.compute();

		assertTrue(output_connectors.get(0).getValue());
		assertFalse(output_connectors.get(1).getValue());

		input_connectors.get(0).setValue(false);
		input_connectors.get(1).setValue(false);
		add8bit_board.compute();

		assertFalse(output_connectors.get(0).getValue());
		assertFalse(output_connectors.get(1).getValue());

	}

	@RepeatedTest(10)
	public void Random10Test() 
	{
		boolean[] values = getTestInputs();
		StringBuilder input1 = new StringBuilder();
		StringBuilder input2 = new StringBuilder();
		StringBuilder output = new StringBuilder();

		inputBoardValues(input1,input2,values);

		add8bit_board.compute();

		getOutputValues(output);

		assertTrue(Integer.parseInt(input1.toString(),2)
				+ Integer.parseInt(input2.toString(),2)
				== Integer.parseInt(output.toString(),2));

	}

	@RepeatedTest(100)
	public void Random100Test() 
	{
		boolean[] values = getTestInputs();
		StringBuilder input1 = new StringBuilder();
		StringBuilder input2 = new StringBuilder();
		StringBuilder output = new StringBuilder();

		inputBoardValues(input1,input2,values);

		add8bit_board.compute();

		getOutputValues(output);

		assertTrue(Integer.parseInt(input1.toString(),2)
				+ Integer.parseInt(input2.toString(),2)
				== Integer.parseInt(output.toString(),2));
	}

	//==Helper Methods

	/**
	 * Inputs the values to the board, appending the input values to the appropriate input string.
	 */
	public static void inputBoardValues(StringBuilder input1, StringBuilder input2, boolean[] values)
	{
		//Add input values into the board.
		for(int x = 0; x < input_connectors.size(); x++)
		{
			input_connectors.get(x).setValue(values[x]);

			//Build input strings to check against.
			if(x % 2 == 0){input1.append(values[x] ? "1" : "0");}
			else {input2.append(values[x] ? "1" : "0");}
		}

		input1.reverse();
		input2.reverse();
	}

	/**
	 * Retrieves the output values and appends them to the output string.
	 */
	public static void getOutputValues(StringBuilder output)
	{
		for(Connector connector : output_connectors)
		{
			output.append(connector.getValue() ? "1" : "0");
		}

		output.reverse();
	}

	@Parameters
	public static boolean[] getTestInputs() 
	{
		return new boolean[] 
				{
						random.nextBoolean(), //A1
						random.nextBoolean(), //B1
						random.nextBoolean(), //A2
						random.nextBoolean(), //B2
						random.nextBoolean(), //A3
						random.nextBoolean(), //B3
						random.nextBoolean(), //A4
						random.nextBoolean(), //B4
						random.nextBoolean(), //A5
						random.nextBoolean(), //B5
						random.nextBoolean(), //A6
						random.nextBoolean(), //B6
						random.nextBoolean(), //A7
						random.nextBoolean(), //B7
						random.nextBoolean(), //A8
						random.nextBoolean() //B8	
				};
	}

}