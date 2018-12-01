package io.github.kingrandomguy.astronomy.objects;

import io.github.kingrandomguy.astronomy.units.*;

public class Star extends StellarObject {
	private Temperature temperature;
	private Length radius;
	private Mass mass;
	public Star(ApparentMagnitude apparentMag, AbsoluteMagnitude absoluteMag, Length distance, Temperature temperature, Length radius, Mass mass) {
		super(apparentMag, absoluteMag, distance);
		this.temperature = temperature;
		this.radius = radius;
		this.mass = mass;
	}
	
}
