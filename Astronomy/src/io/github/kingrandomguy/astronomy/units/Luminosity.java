package io.github.kingrandomguy.astronomy.units;

import java.util.EnumMap;

import io.github.kingrandomguy.astronomy.utility.Utility;

public class Luminosity {
	//Use map to store conversions to watt (base unit)
	public static final EnumMap<LuminosityUnit, Double> conversions = new EnumMap<LuminosityUnit, Double>(LuminosityUnit.class) {
		{
			put(LuminosityUnit.WATT, (double) 1);
			put(LuminosityUnit.SOLAR_LUMINOSITY, 3.828E26);
			put(LuminosityUnit.LUMEN, (double) 97.962);
		}
	};

	//Instance variables
	private double value;
	private LuminosityUnit unit;
	/**
	 * Constructs an Luminosity object, the following example has a measurement of 2 watts
	 * @param value value of the measurement i.e. 2
	 * @param unit unit of the measurement i.e. LuminosityUnit.WATT
	 * 
	 */
	public Luminosity(double value, LuminosityUnit unit) {
		this.value = value;
		this.unit = unit;
	}
	/**
	 * Used to get the value of measurement
	 * @return length of measurement i.e. 2
	 */
	public double getValue() {
		return value;
	}
	/**
	 * Used to get the unit of measurement
	 * @return unit of measurement i.e. watt
	 */
	public LuminosityUnit getUnit() {
		return unit;
	}
	@Override
	public String toString() {
		String unitStr = Utility.properName(unit.toString());
		if(value!=1) {
			return value + " " + unitStr + 's';
		}
		return value + " " + unitStr;
	}
	/**
	 * Converts the length measurement to a different unit
	 * @return Luminosity object of equivalent value
	 */
	public Luminosity convert(LuminosityUnit newUnit) {
		if(unit==newUnit) {
			return this;
		}
		double newValue = value*conversions.get(unit)/conversions.get(newUnit);
		return new Luminosity(newValue, newUnit);
	}
}
