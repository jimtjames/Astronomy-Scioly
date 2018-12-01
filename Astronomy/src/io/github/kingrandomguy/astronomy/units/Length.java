package io.github.kingrandomguy.astronomy.units;

import java.util.EnumMap;
import java.util.HashMap;

import io.github.kingrandomguy.astronomy.utility.Utility;

public class Length {
	//Use map to store conversions to meters (SI unit)
	public static final EnumMap<LengthUnit, Double> conversions = new EnumMap<LengthUnit, Double>(LengthUnit.class) {
		{
			put(LengthUnit.LIGHT_YEAR, (double) 9460730472580800L);
			put(LengthUnit.ASTRONOMICAL_UNIT, (double) 149597870700L);
			put(LengthUnit.PARSEC, (double) (149597870700L * 648000/Math.PI));
			put(LengthUnit.KILOPARSEC, (double) (1000*149597870700L * 648000/Math.PI));
			put(LengthUnit.MEGAPARSEC, (double) (1000000*149597870700L * 648000/Math.PI));
			put(LengthUnit.GIGAPARSEC, (double) (1000000000*149597870700L * 648000/Math.PI));
			put(LengthUnit.KILOMETER, (double) 1000);
			put(LengthUnit.METER, (double) 1);
			put(LengthUnit.MILE, (double) 1609.344);
			put(LengthUnit.FOOT, (double) .3048);
			put(LengthUnit.YARD, (double) 3*.3048);
			put(LengthUnit.SOLAR_RADIUS, (double) 6.957E8);
		}
	};

	//Instance variables
	private double value;
	private LengthUnit unit;
	/**
	 * Constructs a Length object, the following example has a measurement of 1 meter
	 * @param value value of the measurement i.e. 1
	 * @param unit unit of the measurement i.e. LengthUnit.METER
	 * 
	 */
	public Length(double value, LengthUnit unit) {
		this.value = value;
		this.unit = unit;
	}
	/**
	 * Used to get the value of measurement
	 * @return length of measurement i.e. 1
	 */
	public double getValue() {
		return value;
	}
	/**
	 * Used to get the unit of measurement
	 * @return unit of measurement i.e. meter
	 */
	public LengthUnit getUnit() {
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
	 * @return Length object of equivalent value
	 */
	public Length convert(LengthUnit newUnit) {
		if(unit==newUnit) {
			return this;
		}
		double newValue = value*conversions.get(unit)/conversions.get(newUnit);
		return new Length(newValue, newUnit);
	}
}
