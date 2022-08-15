package f1.core;

import java.util.ArrayList;
import java.util.List;

public class Race {
	private String idSeason;
	private String idTrack;
	private Track trackInfo;
	private List<RaceResult> rrList;

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

	public void setTrackInfo(Track trackI) {
		trackInfo = trackI;
	}

	public void setRRList(List<RaceResult> rrL) {
		rrList = rrL;
	}
	public List<RaceResult> getRRList(){
		return rrList;
	}

	public static Track findTrack(String tn, List<Track> trackL) {
		for (Track tr : trackL) {
			if (tr.getIdTrack().equals(tn)) {
				return tr;
			}
		}
		return null;
	}

	public static List<RaceResult> findRaceRS(String idSeason, String idTrack, List<RaceResult> rrL) {
		List<RaceResult> resList = new ArrayList<RaceResult>();
		for (RaceResult elem : rrL) { // перебираем все елементи из RaceResult в списке rrL
			if (elem.getIdSeason().equals(idSeason) && elem.getIdTrack().equals(idTrack)) {
				resList.add(elem);
			}
		}
		return resList;
	}
}
