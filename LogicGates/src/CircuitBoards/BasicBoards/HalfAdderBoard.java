package CircuitBoards.BasicBoards;

import CircuitBoards.CircuitBoard;
import Connectors.Connector;
import Gates.ANDGate;
import Gates.XORGate;


/**
 * 0 0 = 0 0
 * 1 0 = 1 0
 * 0 1 = 1 0
 * 1 1 = 0 0
 */
public class HalfAdderBoard extends CircuitBoard 
{
	
	public HalfAdderBoard() 
	{
		setName("Half Adder");
		
		Connector input_a = new Connector("H_A");
		Connector input_b = new Connector("H_B");
		Connector output_sum = new Connector("H_Sum");
		Connector output_carry = new Connector("H_Cout");
		
		input_connectors.add(0, input_a);
		input_connectors.add(1, input_b);
		
		output_connectors.add(0, output_sum);
		output_connectors.add(1, output_carry);
		
		XORGate first_gate = new XORGate();
		ANDGate second_gate = new ANDGate();
		
		input_gates.add(0, first_gate);
		input_gates.add(1, second_gate);
		
		output_gates.add(0, first_gate);
		output_gates.add(1, second_gate);	
		
		synchronizeConnectors();
	}

	@Override
	public void synchronizeConnectors() 
	{
		XORGate first_gate = (XORGate) input_gates.get(0);
		ANDGate second_gate = (ANDGate) input_gates.get(1);

		first_gate.setInputConnector(0, input_connectors.get(0));
		first_gate.setInputConnector(1, input_connectors.get(1));
		first_gate.setOutputConnector(0, output_connectors.get(0));
		
		second_gate.setInputConnector(0, input_connectors.get(0));
		second_gate.setInputConnector(1, input_connectors.get(1));
		second_gate.setOutputConnector(0, output_connectors.get(1));
		
	}

}
