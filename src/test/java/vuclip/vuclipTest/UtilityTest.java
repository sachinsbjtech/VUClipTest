package vuclip.vuclipTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import vuclip.domainObjects.IShip;
import vuclip.processor.IShipUtility;
import vuclip.processor.ShipUtility;

@RunWith(MockitoJUnitRunner.class)
public class UtilityTest {
	private IShipUtility utility = null;
	
	@Before
	public void initialize() {
		utility = new ShipUtility();
		//MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddShipVertically() {
		ThreadLocalRandom threadLocalRandom = mock(ThreadLocalRandom.class);
		when(threadLocalRandom.nextInt(anyInt(), anyInt())).thenReturn((int)1);
		IShip cruiserIShip = TestConfiguration.createShip();
		List<String> shipLocation = utility.addShip(cruiserIShip);
		assertTrue(!shipLocation.isEmpty());
		assertEquals( 3, shipLocation.size() );
		
	}
	
	@Test
	public void testAddShipHorizontally() {
		ThreadLocalRandom threadLocalRandom = mock(ThreadLocalRandom.class);
		when(threadLocalRandom.nextInt(anyInt(), anyInt())).thenReturn(2);
		IShip cruiserIShip = TestConfiguration.createShip();
		List<String> shipLocation = utility.addShip(cruiserIShip);
		assertTrue(!shipLocation.isEmpty());
		assertEquals( 3, shipLocation.size() );
	}


	@Test
	public void testReturnColumnIndex() {
		assertEquals(0,utility.returnColumnIndex('A'));
		assertEquals(1,utility.returnColumnIndex('B'));
		assertEquals(2,utility.returnColumnIndex('C'));
		assertEquals(3,utility.returnColumnIndex('D'));
		assertEquals(4,utility.returnColumnIndex('E'));
		assertEquals(5,utility.returnColumnIndex('F'));
		assertEquals(6,utility.returnColumnIndex('G'));
		assertEquals(7,utility.returnColumnIndex('H'));
		assertEquals(8,utility.returnColumnIndex('I'));
		assertEquals(9,utility.returnColumnIndex('J'));
	}

}
