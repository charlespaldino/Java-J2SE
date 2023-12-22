package Gates.Core;

import Connectors.Connector;

public abstract class OneToOneLogicGate extends ManyToOneLogicGate
{
	public OneToOneLogicGate()
	{	
		super(new Connector(), new Connector());
	}
}
