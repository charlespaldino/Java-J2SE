package CircuitBoards.BasicBoards;

import java.util.List;

import CircuitBoards.CircuitBoard;
import Connectors.Connector;
import Gates.ORGate;


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
public class FullAdderBoard extends CircuitBoard 
{
	public FullAdderBoard(){this("Full Adder");}

	public FullAdderBoard(String name) 
	{
		setName(name);
		Connector a = new Connector(name+"_A");
		Connector b = new Connector(name+"_B");
		Connector carry_in = new Connector(name+"_Cin");
		
		Connector first_output = new Connector(name+"_Sum");
		Connector second_output = new Connector(name+"_Cout");
		
		input_connectors.add(0, a);
		input_connectors.add(1, b);
		input_connectors.add(2, carry_in);
		
		output_connectors.add(0, first_output);
		output_connectors.add(1, second_output);
		
		HalfAdderBoard first_halfadder = new HalfAdderBoard();
		first_halfadder.setName(name + "_HA1");
		internal_boards.add(0,first_halfadder);
		computation_mapping.addLast(first_halfadder);
		
		HalfAdderBoard second_halfadder = new HalfAdderBoard();	
		second_halfadder.setName(name+ "_HA2");
		internal_boards.add(second_halfadder);
		computation_mapping.addLast(second_halfadder);
		
		ORGate or_gate = new ORGate();
		computation_mapping.addLast(or_gate);
		output_gates.add(or_gate);
		
		synchronizeConnectors();
	}
	
	@Override
	public void synchronizeConnectors() 
	{
		ORGate or_gate = (ORGate) output_gates.get(0);
		HalfAdderBoard first_halfadder = (HalfAdderBoard) internal_boards.get(0);
		List<Connector> ha1_in_connectors = first_halfadder.getInputConnectors();
		List<Connector> ha1_out_connectors = first_halfadder.getOutputConnectors();
		
		ha1_in_connectors.set(0, input_connectors.get(0)); //A
		ha1_in_connectors.set(1, input_connectors.get(1)); //B		
		first_halfadder.synchronizeConnectors();
		
		HalfAdderBoard second_halfadder = (HalfAdderBoard) internal_boards.get(1);
		List<Connector> ha2_in_connectors = second_halfadder.getInputConnectors();
		List<Connector> ha2_out_connectors = second_halfadder.getOutputConnectors();
		
		ha2_in_connectors.set(0, input_connectors.get(2)); //Carry In
		ha2_in_connectors.set(1, ha1_out_connectors.get(0)); // First SUM out	
		second_halfadder.getOutputConnectors().set(0, output_connectors.get(0)); //Board SUM out
		//second_halfadder.getOutputConnectors().set(1, or_gate.getInputConnectors()); //Cout into OR 
		
		second_halfadder.synchronizeConnectors();
		
		or_gate.setInputConnector(0, ha1_out_connectors.get(1)); //First Half Carry Out
		or_gate.setInputConnector(1, ha2_out_connectors.get(1)); //Second Half Carry Out
		or_gate.setOutputConnector(0, output_connectors.get(1)); //Board Carry Out		

	}

}
