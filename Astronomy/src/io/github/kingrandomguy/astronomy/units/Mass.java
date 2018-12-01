package io.github.kingrandomguy.astronomy.units;

import java.util.EnumMap;
import java.util.HashMap;

import io.github.kingrandomguy.astronomy.utility.Utility;

public class Mass {
	//Use map to store conversions to kilograms (SI unit)
	public static final EnumMap<MassUnit, Double> conversions = new EnumMap<MassUnit, Double>(MassUnit.class) {
		{
			put(MassUnit.KILOGRAM, (double) 1);
			put(MassUnit.SOLAR_MASS, (double) 1.98855E30);
			put(MassUnit.SHORT_TON, (double) 907.1847);
			put(MassUnit.TONNE, (double) 1000);
			put(MassUnit.ATOMIC_MASS_UNIT, 1.660539040E-27);
			put(MassUnit.GRAM, .001);
			put(MassUnit.POUND, 0.45359237);
			put(MassUnit.OUNCE, 0.45359237/16);
			put(MassUnit.JUPITER_MASS, 1.8982E27);
		}
	};

	//Instance variables
	private double value;
	private MassUnit unit;
	/**
	 * Constructs a Mass object, the following example has a measurement of 3 kilograms
	 * @param value value of the measurement i.e. 3
	 * @param unit unit of the measurement i.e. MassUnit.KILOGRAM
	 * 
	 */
	public Mass(double value, MassUnit unit) {
		this.value = value;
		this.unit = unit;
	}
	/**
	 * Used to get the value of measurement
	 * @return length of measurement i.e. 3
	 */
	public double getValue() {
		return value;
	}
	/**
	 * Used to get the unit of measurement
	 * @return unit of measurement i.e. kilogram
	 */
	public MassUnit getUnit() {
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
	 * @return Length object of equivalent value in meters
	 */
	public Mass convert(MassUnit newUnit) {
		if(unit==newUnit) {
			return this;
		}
		double newValue = value*conversions.get(unit)/conversions.get(newUnit);
		return new Mass(newValue, newUnit);
	}
}
