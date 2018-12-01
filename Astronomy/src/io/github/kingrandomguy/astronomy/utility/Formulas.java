package io.github.kingrandomguy.astronomy.utility;

import io.github.kingrandomguy.astronomy.units.*;

public class Formulas {
	/**
	 * Given the angular size and distance to an object, compute the linear size
	 * @return a Length object with the linear size and units of input distance
	 */
	public static Length smallAngleFormula(Angle angle, Length distance) {
		Angle inRadians = angle.convert(AngleUnit.RADIAN);
		double size = (distance.getValue()*Math.tan(inRadians.getValue()));
		Length linearSize = new Length(size, distance.getUnit());
		return linearSize.convert(distance.getUnit());
	}
	/**
	 * Given the parallax angle of an object, get the distance to the object in PARSECS
	 * @param angle Angle object representing the parallax angle, any unit
	 * @return Length object representing the distance to object in parsecs
	 */
	public static Length parallax(Angle parallax) {
		Angle inArcseconds = parallax.convert(AngleUnit.ARCSECOND);
		Length distance = new Length(1/inArcseconds.getValue(), LengthUnit.PARSEC);
		return distance;
	}
	/**
	 * Given the distance to an object, get the parallax angle of the object in ARCSECONDS
	 * @param distance Length object representing the distance to the object, any unit
	 * @return Angle object representing the parallax of the object in arcseconds
	 */
	public static Angle parallax(Length distance) {
		Length inParsecs = distance.convert(LengthUnit.PARSEC);
		Angle parallax = new Angle(1/inParsecs.getValue(), AngleUnit.ARCSECOND);
		return parallax;
	}
	/**
	 * Given the apparent and absolute magnitudes of an object, get the distance to the object in PARSECS
	 * @param apparentMag ApparentMagnitude object representing the Apparent Magnitude of the object.
	 * @param absoluteMag AbsoluteMagnitude object representing the Absolute Magnitude of the object.
	 * @return Length object representing the distance to the object in parsecs
	 */
	public static Length distanceMod(ApparentMagnitude apparentMag, AbsoluteMagnitude absoluteMag) {
		double mod = apparentMag.getValue()-absoluteMag.getValue();
		double dist = Math.pow(10, mod/5 + 1);
		Length distance = new Length(dist, LengthUnit.PARSEC);
		return distance;
	}
	/**
	 * Given the absolute magnitude of an object and the distance of the object, get the apparent magnitude of the object
	 * @param absoluteMag AbsoluteMagnitude object representing the absolute magnitude of the object
	 * @param distance Length object representing the distance to the object
	 * @return ApparentMagnitude object representing the apparent magnitude of the object
	 */
	public static ApparentMagnitude distanceMod(AbsoluteMagnitude absoluteMag, Length distance) {
		Length inParsecs = distance.convert(LengthUnit.PARSEC);
		double logPart = 5*Math.log(inParsecs.getValue())-5;
		double mag = logPart+absoluteMag.getValue();
		ApparentMagnitude magnitude = new ApparentMagnitude(mag);
		return magnitude;
	}
	/**
	 * Given the apparent magnitude of an object and the distance of the object, get the absolute magnitude of the object
	 * @param apparentMag ApparentMagnitude object representing the apparent magnitude of the object
	 * @param distance Length object representing the distance to the object
	 * @return AbsoluteMagnitude object representing the absolute magnitude of the object
	 */
	public static AbsoluteMagnitude distanceMod(ApparentMagnitude apparentMag, Length distance) {
		Length inParsecs = distance.convert(LengthUnit.PARSEC);
		double logPart = 5*Math.log(inParsecs.getValue())-5;
		double mag = apparentMag.getValue()-logPart;
		AbsoluteMagnitude magnitude = new AbsoluteMagnitude(mag);
		return magnitude;
	}
	/**
	 * Given the luminosity of an object, get the absolute magnitude of the object
	 * @param luminosity Luminosity object representing the luminosity of an object
	 * @return AbsoluteMagnitude object representing the absolute magnitude of the object
	 */
	public static AbsoluteMagnitude getAbsMag(Luminosity luminosity) {
		luminosity = luminosity.convert(LuminosityUnit.SOLAR_LUMINOSITY);
		double mag = 4.83 - 2.5* Math.log10(luminosity.getValue());
		AbsoluteMagnitude magnitude = new AbsoluteMagnitude(mag);
		return magnitude;
	}
}
