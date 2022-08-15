package f1.core;

import java.util.ArrayList;
import java.util.List;

public class Season {
	private String idSeason;
	private int yearSeason;
	private List<SeasonTeamPilot> stpList;
	private List<Race> raceList;

	public void setIdSeason(String is) {
		idSeason = is;
	}

	public String getIdSeason() {
		return idSeason;
	}

	public void setYearSeason(int ys) {
		yearSeason = ys;
	}

	public int getYearSeason() {
		return yearSeason;
	}

	public void setSTPList(List<SeasonTeamPilot> stpl) {
		stpList = stpl;
	}

	public List<SeasonTeamPilot> getSTPList() {
		return stpList;
	}

	public void setRaceList(List<Race> raceL) {
		raceList = raceL;
	}

	public List<Race> getRaceList() {
		return raceList;
	}

	public static List<SeasonTeamPilot> findSeasonSTP(String idS, List<SeasonTeamPilot> sL) { // находим соотв.значения
																								// IdSeason
		List<SeasonTeamPilot> resList = new ArrayList<SeasonTeamPilot>();
		for (SeasonTeamPilot elem : sL) { // перебираем все елементи из SeasonTeamPilot в списке sL
			if (elem.getIdSeason().equals(idS)) { // сравниваем знач.IdSeason у SeasonTeamPilot со
													// знач.idSeason в Season
				resList.add(elem);
			}
		}
		return resList;
	}

	public static List<Race> findSeasonRace(String sr, List<Race> rL) {
		List<Race> resList = new ArrayList<Race>();
		for (Race elem : rL) { // перебираем все елементи из Race в списке rL
			if (elem.getIdSeason().equals(sr)) { // сравниваем знач.IdSeason у Race со знач.idSeason в Season
				resList.add(elem);
			}
		}
		return resList;
	}
}