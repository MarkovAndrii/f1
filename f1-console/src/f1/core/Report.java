package f1.core;

import java.util.List;

public class Report {
	public static void outputInfo(List<Season> ls) { // аргумент j определяет входную инф.
		for (Season newS : ls) {
			System.out.println(newS.getYearSeason());
			for (SeasonTeamPilot ttn : newS.getSTPList()) {
				System.out.println("    " + ttn.getTeamInfo().getTeamName() + " - " + ttn.getPilotInfo().getPilotName()
						+ " " + ttn.getPilotInfo().getPilotSurname());
			}
		}
	}
}
