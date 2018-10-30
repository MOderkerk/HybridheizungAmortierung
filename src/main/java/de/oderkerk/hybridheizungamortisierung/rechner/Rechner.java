package de.oderkerk.hybridheizungamortisierung.rechner;

/**
 * Calculations
 * 
 * @author Odin
 *
 */
public class Rechner {
//
	private final float heizoelKwH1L = 10.4f;

	/**
	 * Convert price of 100 L to 1 kwh
	 * 
	 * @param heizoelpreis100L
	 * @return heizoelpreis1kwh
	 */
	public float getPreis1kwhHeizoel(float heizoelpreis100L) {
		return (heizoelpreis100L / 100) / heizoelKwH1L;
	}

	/**
	 * Calculate Primary energy
	 * 
	 * @param jahresverbrauch
	 * @return prim�renergie
	 */
	public float getPrimaerenergieBedarf(float jahresverbrauch) {
		return jahresverbrauch * heizoelKwH1L;
	}

	/**
	 * Calculate fuel cost for year
	 * 
	 * @param primaerenergieBedarf
	 * @param heizoelpreis1kw
	 * @return kosten
	 */
	public float getHeizkosten(float primaerenergieBedarf, float heizoelpreis1kw) {
		return primaerenergieBedarf * heizoelpreis1kw;
	}

	/**
	 * Berechnung W�rmepumpenkosten
	 * 
	 * @param energiebedarf
	 * @param strompreis
	 * @return w�rmepumpenkosten
	 */
	public float getWaermepumpenKosten(float energiebedarf, float strompreis) {
		return ((energiebedarf * 0.8f) / 3) * strompreis;
	}

	/**
	 * get �lheizungskosten
	 * 
	 * @param energiebedarf
	 * @param heizoelpreis1kw
	 * @return �lheizungskosten
	 */
	public float getOelheizungKosten(float energiebedarf, float heizoelpreis1kw) {

		return ((energiebedarf * 0.9f)) * heizoelpreis1kw;
	}
}
