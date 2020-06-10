import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//Clase Test
class IntervaloTest {
	private Intervalo _prueba;
	private Intervalo _prueba1;
	
	
	@BeforeEach
	void setUp() throws Exception {
		_prueba=new Intervalo(1,10);
		_prueba1=new Intervalo(2,11);
		
	}

	@Test
	void testReduce() {
			assertEquals(55,_prueba.reduce(0, (x1, x2) -> x1 + x2));
	}
	void testSumatoria() {
		assertEquals(45,_prueba.sumatoria());
		
		
	}
	@Test
	void testProducto() {
		assertEquals(3628800,_prueba.producto());
		
	}
	@Test
	void testDentro() {
		assertTrue(!_prueba.dentro(25));
		assertTrue(_prueba.dentro(2));
		
	}
	void testSumatoriaStream() {
		assertEquals(45,_prueba.sumatoriaStream());
		
	}
	@Test
	void testProductoStream() {
		assertEquals(36288000,_prueba.productoStream());
		
	}
	
	@Test
	void testMin() {
		assertEquals(1,_prueba.getMin());
		
	}
	@Test
	void testMax() {
		assertEquals(10,_prueba.getMax());
		
	}
	
	@Test
	void testDiferencia() {
		assertEquals(9,_prueba.diferencia());
		
	}
	
	
}
