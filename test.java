import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class test {

	@Test
	void testErrorFormat() {
		 Assert.fail("Echec ignoré"); 
	}
	@Test
	void testErrorPrice() {
		 Assert.fail("Le format d'un prix est incorrect"); 
	}
	
	@Test
	void testErrorClient() {
		
		 Assert.fail("Un client n'existe pas !"); 
	}
	
	void testMultiplication() {
		
		double result = (2 * 2.5);
		assertEquals(result, 5.00);
		
	}
	void testAddition() {
		
		double result = (15.75 +5);
		assertEquals(result, 20.75);
		
	
}

}
