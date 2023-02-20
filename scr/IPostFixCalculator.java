package scr;
/**
 * @author Seccion 40
 */
public interface IPostFixCalculator<T> {

	public int Calculate(java.util.ArrayList<T> postfix_expression, String type) throws Exception;
}