package f1.core;

public class Pilot {
	private String idPilot;
	private String pilotName;
	private String pilotSurname;
	private String pilotNation;
	private String pilotAge;
	private int dataOfJoiningTeam;

	public void setIdPilot(String ip) {
		idPilot = ip;
	}
	public String getIdPilot() {
		return idPilot;
	}

	public void setPilotName(String pn) {
		pilotName = pn;
	}

	public void setPilotSurname(String ps) {
		pilotSurname = ps;
	}

	public void setPilotNation(String pnat) {
		pilotNation = pnat;
	}

	public void setPilotAge(String pa) {
		pilotAge = pa;
	}

	public void setDataOfJoiningTeam(int dojt) {
		dataOfJoiningTeam = dojt;
	}
}