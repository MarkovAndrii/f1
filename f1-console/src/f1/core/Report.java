package f1.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Report {
	public static void outputInfo(List<Season> ls) {
		for (Season newS : ls) {
			System.out.println(newS.getYearSeason());
			for (SeasonTeamPilot ttn : newS.getSTPList()) {
				System.out.println("    " + ttn.getTeamInfo().getTeamName() + " - " + ttn.getPilotInfo().getPilotName()
						+ " " + ttn.getPilotInfo().getPilotSurname());
			}
			System.out.println();
		}
	}

	public static HashMap<String, Integer> seasonResult(Season currentSeason) { // для текущего(одного) сезона считаем
																				// таблицу результатов по каждому пилоту
		HashMap<String, Integer> idPilotPoints = new HashMap<>();
		for (Race currentRace : currentSeason.getRaceList()) {
			for (RaceResult currentRR : currentRace.getRRList()) {
				if (idPilotPoints.containsKey(currentRR.getIdPilot())) { // проверить на наличие конкреного ключа
																			// значение idPilot
					int currentValue = idPilotPoints.get(currentRR.getIdPilot());
					if (currentRR.getFastLap()) { // проверка на бистр.круг
						currentValue = currentValue + 1;
					}
					int newValue = currentRR.getScore().getPoint();
					currentValue = currentValue + newValue;
					idPilotPoints.put(currentRR.getIdPilot(), currentValue);

				} else {
					idPilotPoints.put(currentRR.getIdPilot(), currentRR.getScore().getPoint()); // записать в map
																								// новую парю
																								// ключ+значение
				}
			}
		}
		return idPilotPoints;
	}

	public static void sortedResult(HashMap<String, Integer> seasonResult, Season currentSeason) { // сортируем таблицу
		// результатов seasonResult
		HashMap<String, Integer> newM = new HashMap<>();
		for (SeasonTeamPilot pilotInfo : currentSeason.getSTPList()) {
			String pilotNS = pilotInfo.getPilotInfo().getPilotName() + " " + pilotInfo.getPilotInfo().getPilotSurname();
			int points = seasonResult.getOrDefault(pilotInfo.getPilotInfo().getIdPilot(), 0);
			newM.put(pilotNS, points);

		}

		List<Entry<String, Integer>> finalResult = newM.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).toList();
		System.out.println(currentSeason.getYearSeason());
		for (Entry<String, Integer> elem : finalResult) {

			System.out.println(elem.getKey() + "\t\t" + elem.getValue());
		}
	}

	public static void sortedResult2(HashMap<String, Integer> seasonResult, Season currentSeason) { // сортируем таблицу
		// результатов seasonResult
		List<ReportItem> exp = new ArrayList<ReportItem>(); // exp
		for (SeasonTeamPilot pilotInfo : currentSeason.getSTPList()) {
			String pilotNS = pilotInfo.getPilotInfo().getPilotName() + " " + pilotInfo.getPilotInfo().getPilotSurname();
			int points = seasonResult.getOrDefault(pilotInfo.getPilotInfo().getIdPilot(), 0);
			ReportItem newO = new ReportItem();
			newO.pilotNameSur = pilotNS;
			newO.totalPoints = points;
			newO.teamName = pilotInfo.getTeamInfo().getTeamName();
			exp.add(newO);

		}

		List<ReportItem> finalResult = exp.stream() // лист переводим в стрим
				.sorted(Comparator.<ReportItem>comparingInt(o -> o.totalPoints).reversed()).toList();
		System.out.println(currentSeason.getYearSeason());
		for (ReportItem elem : finalResult) {

			System.out.println(elem.pilotNameSur +" ("+ elem.teamName +")"+ "\t\t" + elem.totalPoints);
		}
	}

	public static int compareByPoints(ReportItem ri) {
		return ri.totalPoints;
	}
}

class ReportItem {
	String pilotNameSur;
	int totalPoints;
	String teamName;

}