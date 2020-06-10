import java.util.Optional;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

/**
 * Esta clase representa el concepto matematico que intervalos. Es decir
 * representa todos los valores entre uno y otro. Con esto luego puedes
 * preguntar si un valor est�n dentro de un intervalo o no.
 */
public class Intervalo {

	private int _min;
	private int _max;

	public Intervalo(int min, int max) {
		if (min > max) {
			throw new IllegalArgumentException("valor min " + min + " no deberia ser mayor a valor max " + max);
		}
		_min = min;
		_max = max;
	} 
	/**
	 * Este metodo aplica el operador a todos los elementos comprendidos en un intervalo
	 * Si el operador es de suma, suma todos los elementos y lanza un resultado
	 * @param totalInicial
	 * @param op
	 * @return int totalInicial
	 */

	public int reduce(int totalInicial, BinaryOperator<Integer> op) {
		if (_max == _min) {
			return totalInicial;
		}

		for (int i = _min; i <= _max; i++) {
			totalInicial = op.apply(totalInicial, i); // Aplico la operacion
		}

		return totalInicial;
	}
	/**
	 * 
	 * @return la sumatoria de todos los elementos comprendidos en un intervalo
	 */

	public int sumatoria() {

		return this.reduce(0, (x1, x2) -> x1 + x2);
	}
	/**
	 * 
	 * @return el producto de todos los elementos comprendidos en un intervalo
	 */

	public int producto() {
		return this.reduce(1, (x1, x2) -> x1 * x2);
	}
	/**
	 * 
	 * @return la sumatoria de todos los elementos comprendidos en un intervalo pero aplicando lambda stream de JAVA 8
	 */
	public int sumatoriaStream() {
		IntStream intervalo = IntStream.range(_min, _max);
		return intervalo.reduce(0, (a, b) -> a + b);
	}

	public int productoStream() {
		IntStream intervalo = IntStream.range(_min, _max);
		return intervalo.reduce(1, (a, b) -> a * b);
	}
	/**
	 * 
	 * @return el producto de todos los elementos comprendidos en un intervalo pero aplicando lambda stream de JAVA 8
	 */

	/**
	 * @returns true si num esta entre el valor minimo y maximo (incluyendo esos
	 *          valores)
	 */
	public boolean dentro(int num) {
		if (num >= _min && num <= _max) {
			return true;
		}

		return false;
	} 

	/**
	 * 
	 * @return el valor minimo del intervalo
	 */

	public int getMin() {
		return _min;
	}
	/**
	 * 
	 * @return el valor maximo del intervalo
	 */
	public int getMax() {
		return _max;
	}
	/**
	 * 
	 * @return la diferencia entre el maximo y el minimo
	 */
	public int diferencia() {
		return _max - _min;
	}
	
}
