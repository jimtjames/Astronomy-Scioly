package io.github.kingrandomguy.astronomy;

import io.github.kingrandomguy.astronomy.units.*;
import io.github.kingrandomguy.astronomy.utility.Formulas;

public class Main {
	public static void main(String[] args) {
		Length pc = new Length(1, LengthUnit.METER);
		System.out.println(pc);
		System.out.println(pc.convert(LengthUnit.PARSEC));
		Length jupiterDistance = new Length(9.9675178649E-5, LengthUnit.LIGHT_YEAR);
		Angle jupiterAngularSize = new Angle(31.2, AngleUnit.ARCSECOND);
		System.out.println(Formulas.smallAngleFormula(jupiterAngularSize, jupiterDistance));
	}
}
