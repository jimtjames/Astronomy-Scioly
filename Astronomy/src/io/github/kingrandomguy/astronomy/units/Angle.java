package io.github.kingrandomguy.astronomy.units;

import java.util.EnumMap;

import io.github.kingrandomguy.astronomy.utility.Utility;

public class Angle {
	//Use map to store conversions to radians (SI unit)
	public static final EnumMap<AngleUnit, Double> conversions = new EnumMap<AngleUnit, Double>(AngleUnit.class) {
		{
			put(AngleUnit.RADIAN, (double) 1);
			put(AngleUnit.DEGREE, (double) Math.PI/180);
			put(AngleUnit.ARCMINUTE, (double) Math.PI/180/60);
			put(AngleUnit.ARCSECOND, (double) Math.PI/180/60/60);
		}
	};

	//Instance variables
	private double value;
	private AngleUnit unit;
	/**
	 * Constructs an Angle object, the following example has a measurement of 2 radians
	 * @param value value of the measurement i.e. 2
	 * @param unit unit of the measurement i.e. AngleUnit.RADIAN
	 * 
	 */
	public Angle(double value, AngleUnit unit) {
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
	 * @return unit of measurement i.e. radian
	 */
	public AngleUnit getUnit() {
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
	 * @return Angle object of equivalent value
	 */
	public Angle convert(AngleUnit newUnit) {
		if(unit==newUnit) {
			return this;
		}
		double newValue = value*conversions.get(unit)/conversions.get(newUnit);
		return new Angle(newValue, newUnit);
	}
}
