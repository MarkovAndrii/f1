package f1.core;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {
	private String idSeason;
	private String idTrack;
	private String idPilot;
	private int place;
	private boolean fastLap;
	private Score score;

	public void setIdSeason(String idS) {
		idSeason = idS;
	}

	public String getIdSeason() {
		return idSeason;
	}

	public void setIdTrack(String idT) {
		idTrack = idT;
	}

	public String getIdTrack() {
		return idTrack;
	}

	public void setIdPilot(String idP) {
		idPilot = idP;
	}

	public String getIdPilot() {
		return idPilot;
	}

	public void setPlace(int p) {
		place = p;
	}

	public int getPlace() {
		return place;
	}

	public void setFastLap(boolean fL) {
		fastLap = fL;
	}

	public boolean getFastLap() {
		return fastLap;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public Score getScore() {
		return score;
	}

	public static Score findRSScore(int place, List<Score> scoreList) {
		for (Score elem : scoreList) {
			if (elem.getPlace() == place) {
				return elem;
			}
		}
		return null;
	}
}
