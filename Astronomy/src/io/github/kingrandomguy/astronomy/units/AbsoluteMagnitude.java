package io.github.kingrandomguy.astronomy.units;

public class AbsoluteMagnitude {
	private double value;
	public AbsoluteMagnitude(double value) {
		this.value = value;
	}
	/**
	 * Used to get the numerical data 
	 * @return value representing absolute magnitude
	 */
	public double getValue() {
		return value;
	}
	@Override
	public String toString() {
		return "Absolute Magnitude: " + value;
	}
}
