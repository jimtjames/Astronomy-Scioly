package io.github.kingrandomguy.astronomy.units;

public class ApparentMagnitude {
	private double value;
	public ApparentMagnitude(double value) {
		this.value = value;
	}
	/**
	 * Used to get the numerical data 
	 * @return value representing apparent magnitude
	 */
	public double getValue() {
		return value;
	}
	@Override
	public String toString() {
		return "Apparent Magnitude: " + value;
	}
}
