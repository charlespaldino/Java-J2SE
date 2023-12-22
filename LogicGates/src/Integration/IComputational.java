package Integration;

/**
 * Used to iterate through both circuit boards and logic gates.
 */
public interface IComputational {

	/**
	 * Computes the current connector values and passes it onto the output connector.
	 */
	public abstract void compute();
}
