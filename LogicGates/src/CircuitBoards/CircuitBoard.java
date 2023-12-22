package CircuitBoards;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Connectors.Connector;
import Gates.Core.LogicGate;
import Integration.IComputational;

public abstract class CircuitBoard implements IComputational {

	//https://www.101computing.net/digital-padlock-using-logic-gates/ ADD THIS
	
	//TODO for testing = need string to binary converter
	
	private String Name;
	
	protected List<LogicGate> input_gates = new ArrayList<LogicGate>();
	protected List<LogicGate> output_gates = new ArrayList<LogicGate>();
	
	protected List<Connector> input_connectors = new ArrayList<Connector>();
	protected List<Connector> output_connectors = new ArrayList<Connector>();
	
	protected List<CircuitBoard> internal_boards = new ArrayList<CircuitBoard>();
	
	protected LinkedList<IComputational> computation_mapping = new LinkedList<IComputational>();
	
	public List<LogicGate> getInputGates() {
		return input_gates;
	}

	public void setInputGates(List<LogicGate> input_gates) {
		this.input_gates = input_gates;
	}
	
	public List<LogicGate> getOutputGates() {
		return output_gates;
	}

	public void setOutputGates(List<LogicGate> output_gates) {
		this.output_gates = output_gates;
	}
	
	public List<Connector> getInputConnectors() {
		return input_connectors;
	}

	public void setInputConnectors(List<Connector> input_connectors) {
		this.input_connectors = input_connectors;
	}

	public List<Connector> getOutputConnectors() {
		return output_connectors;
	}

	public void setOutputConnectors(List<Connector> output_connectors) {
		this.output_connectors = output_connectors;
	}

	public List<CircuitBoard> getInternalBoards() {
		return internal_boards;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	/**
	 * Hands each input gate their value, then tells them to compute.
	 */
	public void compute()
	{
		if(computation_mapping.isEmpty())
		{
			input_gates.forEach(gate -> 
			{
			    gate.compute();
			});
			
			return;
		}
		
		computation_mapping.forEach(computational -> 
		{
			computational.compute();
			System.out.print("");
		});
		
	}
	
	/**
	 * This should reconnect and ensure all connectors are correct.
	 */
	public abstract void synchronizeConnectors();
	


 
}
