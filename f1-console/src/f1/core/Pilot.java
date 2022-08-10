package f1.core;

public class Pilot {
	private String idPilot;
	private String pilotName;
	private String pilotSurname;
	private String pilotNation;
	private String pilotAge;
	private int startDate;

	public void setIdPilot(String ip) {
		idPilot = ip;
	}
	public String getIdPilot() {
		return idPilot;
	}

	public void setPilotName(String pn) {
		pilotName = pn;
	}
	public String getPilotName() {
		return pilotName;
	}

	public void setPilotSurname(String ps) {
		pilotSurname = ps;
	}
	public String getPilotSurname() {
		return pilotSurname;
	}

	public void setPilotNation(String pnat) {
		pilotNation = pnat;
	}

	public void setPilotAge(String pa) {
		pilotAge = pa;
	}

	public void setStartDate(int sd) {
		startDate = sd;
	}
}