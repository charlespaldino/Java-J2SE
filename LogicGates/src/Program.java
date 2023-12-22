import CircuitBoards.BasicBoards.Addition8BitBoard;

public class Program {

	public static void main(String[] args) 
	{
		String input = "00000011";
		System.out.println(Integer.parseInt(input, 2));
		
		//Manual testing here
		
		Addition8BitBoard adder = new Addition8BitBoard();
		
		
		adder.getInputConnectors().get(0).setValue(true); //A1
		adder.getInputConnectors().get(1).setValue(false); //B1
		adder.getInputConnectors().get(2).setValue(true); //A2
		adder.getInputConnectors().get(3).setValue(true); //B2
		adder.getInputConnectors().get(4).setValue(true); //A3
		adder.getInputConnectors().get(5).setValue(false); //B3
		adder.getInputConnectors().get(6).setValue(true); //A4
		adder.getInputConnectors().get(7).setValue(true); //B4
		adder.getInputConnectors().get(8).setValue(false); //A5
		adder.getInputConnectors().get(9).setValue(false); //B5
		adder.getInputConnectors().get(10).setValue(false); //A6
		adder.getInputConnectors().get(11).setValue(false); //B6
		adder.getInputConnectors().get(12).setValue(true); //A7
		adder.getInputConnectors().get(13).setValue(true); //B7
		adder.getInputConnectors().get(14).setValue(false); //A8
		adder.getInputConnectors().get(15).setValue(false); //B8
		
		adder.compute();
		
		for(int x = 0; x < 9; x++)
		{
			//System.out.println("S"+(x+1)+": " + adder.getOutputConnectors().get(x).getValue());	
		}
		
		for(int x = 0; x < 9; x++)
		{
			//System.out.print(adder.getOutputConnectors().get(x).getValue() ? "1" : "0");	
		}
		System.out.println();
		for(int x = 7; x >= 0; x--)
		{
			System.out.print(adder.getOutputConnectors().get(x).getValue() ? "1" : "0");	
		}
		System.out.println();
		System.out.println("OverFlow: " +(adder.getOutputConnectors().get(8).getValue() ? "1" : "0"));
	}

}
