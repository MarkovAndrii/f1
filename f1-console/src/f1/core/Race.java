package f1.core;

public class Race {
	private String idRace;
	private String gpName;
	private String trackName;
	private String country;
	private int trackLength;

	public void setIdRace(String ir) {
		idRace = ir;
	}

	public void setGpName(String gpn) {
		gpName = gpn;
	}

	public void setTrackName(String tn) {
		trackName = tn;
	}

	public void setCountry(String c) {
		country = c;
	}

	public void setTrackLength(int tl) {
		trackLength = tl;
	}
}