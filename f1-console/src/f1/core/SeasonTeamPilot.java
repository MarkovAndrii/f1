package f1.core;

import java.util.ArrayList;
import java.util.List;

public class SeasonTeamPilot {
	private String idSeason;
	private String idTeam;
	private String idPilot;
	private Team teamInfo;
	private Pilot pilotInfo;

	public void setIdSeason(String ids) {
		idSeason = ids;
	}

	public String getIdSeason() {
		return idSeason;
	}

	public void setIdTeam(String idt) {
		idTeam = idt;
	}
	public String getIdTeam() {
		return idTeam;
	}

	public void setIdPilot(String idp) {
		idPilot = idp;
	}
	public String getIdPilot() {
		return idPilot;
	}
	public void setTeamInfo(Team tInfo) {
		teamInfo = tInfo;
	}
	public Team getTeamInfo() {
		return teamInfo;
	}
	public void setPilotInfo(Pilot pInfo) {
		pilotInfo = pInfo;
	}
	public Pilot getPilotInfo() {
		return pilotInfo;
	}

	public static Team findTeam(String tn, List<Team> teamL) {
		for (Team tt : teamL) {
			if (tt.getIdTeam().equals(tn)) {
				return tt;
			}
		}
		return null;
	}

	public static Pilot findPilot(String pn, List<Pilot> pilotL) {
		for (Pilot pp : pilotL) {
			if (pp.getIdPilot().equals(pn)) {
				return pp;
			}
		}
		return null;
	}
}