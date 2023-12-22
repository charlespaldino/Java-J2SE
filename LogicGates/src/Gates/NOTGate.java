package Gates;

import Gates.Core.OneToOneLogicGate;

public class NOTGate extends OneToOneLogicGate
{
	@Override
	public void compute() 
	{
		output_connectors.get(0).setValue(!input_connectors.get(0).getValue());		
	}

}
