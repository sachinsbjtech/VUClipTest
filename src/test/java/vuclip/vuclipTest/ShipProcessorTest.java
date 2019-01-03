package vuclip.vuclipTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import vuclip.processor.ShipProcessor;

public class ShipProcessorTest {

	@Test
	public void testLoadShipOnGrid() {
		ShipProcessor processor = new ShipProcessor();
		assertEquals(5,processor.loadShipOnGrid());
	}

	@Test
	public void testAreAllShipsSinked() {
		ShipProcessor processor = new ShipProcessor();
		assertTrue(processor.AreAllShipsSinked());
	}

}
