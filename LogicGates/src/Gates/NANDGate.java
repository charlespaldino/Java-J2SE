package Gates;

import Gates.Core.TwoToOneLogicGate;

public class NANDGate extends TwoToOneLogicGate{


	@Override
	public void compute() 
	{
		output_connectors.get(0).setValue(!(input_connectors.get(0).getValue() && input_connectors.get(1).getValue()));
	}
}
