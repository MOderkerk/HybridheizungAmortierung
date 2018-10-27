package de.oderkerk.hybridheizungamortisierung.rechner;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RechnerTest {

	Rechner rechner;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPreis1kwhHeizoel() throws Exception {
		rechner = new Rechner();
		float result = rechner.getPreis1kwhHeizoel(80f);
		assertEquals(0, Float.compare(result, 0.07692307692307692307692307692308f));

	}

	@Test
	public void testGetPrimaerenergieBedarf() throws Exception {
		rechner = new Rechner();
		float result = rechner.getPrimaerenergieBedarf(1);
		assertEquals(0, Float.compare(result, 10.4f));
	}

	@Test
	public void testGetHeizkosten() throws Exception {
		rechner = new Rechner();
		float result = rechner.getHeizkosten(1, 0.08f);
		assertEquals(0, Float.compare(result, 0.08f));
	}

	@Test
	public void testGetWaermepumpenKosten() throws Exception {
		rechner = new Rechner();
		float result = rechner.getWaermepumpenKosten(1f, 0.26f);
		assertEquals(0, Float.compare(result, 0.06933334f));
	}

	@Test
	public void testGetOelheizungKosten() throws Exception {
		rechner = new Rechner();
		float result = rechner.getOelheizungKosten(1, 0.08f);
		assertEquals(0, Float.compare(result, 0.072f));
	}

}
