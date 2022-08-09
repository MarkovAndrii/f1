package f1.core;

import java.util.List;

public class Season {
	private String idSeason;
	private int yearSeason;
	private List<SeasonTeamPilot> stpList;

	public void setIdSeason(String is) {
		idSeason = is;
	}

	public String getIdSeason() {
		return idSeason;
	}

	public void setYearSeason(int ys) {
		yearSeason = ys;
	}

	public void setSTPList(List<SeasonTeamPilot> stpl) {
		stpList = stpl;
	}

	public static SeasonTeamPilot findSeasonSTP(String idS, List<SeasonTeamPilot> sL) {
		for (SeasonTeamPilot resultList : sL) { // перебираем все елементи из SeasonTeamPilot в списке sL
			if (resultList.getIdSeason().equals(idS)) { // сравниваем знач.IdSeason в SeasonTeamPilot со
														// знач.idSeason в Season
				return resultList;
			}
		}
		return null;
	}
}