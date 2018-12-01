package io.github.kingrandomguy.astronomy.objects;

import io.github.kingrandomguy.astronomy.units.AbsoluteMagnitude;
import io.github.kingrandomguy.astronomy.units.ApparentMagnitude;
import io.github.kingrandomguy.astronomy.units.Length;

public abstract class StellarObject {
	private ApparentMagnitude apparentMag;
	private AbsoluteMagnitude absoluteMag;
	private Length distance;
	public StellarObject(ApparentMagnitude apparentMag, AbsoluteMagnitude absoluteMag, Length distance) {
		this.apparentMag = apparentMag;
		this.absoluteMag = absoluteMag;
		this.distance = distance;
	}
}
