package f1.console;

import java.util.HashMap;
import java.util.List;

import f1.core.FileInputTeam;
import f1.core.FileInputPilot;
import f1.core.FileInputRace;
import f1.core.FileInputRaceResult;
import f1.core.FileInputSeason;
import f1.core.FileInputTrack;
import f1.core.FileInputSTP;
import f1.core.FileInputScore;
import f1.core.Team;
import f1.core.Pilot;
import f1.core.Race;
import f1.core.RaceResult;
import f1.core.Season;
import f1.core.SeasonTeamPilot;
import f1.core.Track;
import f1.core.Report;
import f1.core.Score;

public class Console {

	public static void main(String[] args) {
		List<Team> lTeam = FileInputTeam.mapFileToTeamList("C:/Mydoc/Git/f1/f1-console/resources/teamList.txt");
		List<Pilot> lPilot = FileInputPilot.mapFileToPilotList("C:/Mydoc/Git/f1/f1-console/resources/pilotList.txt");
		List<Season> lSeason = FileInputSeason
				.mapFileToSeasonList("C:/Mydoc/Git/f1/f1-console/resources/seasonList.txt");
		List<Track> lTrack = FileInputTrack.mapFileToTrackList("C:/Mydoc/Git/f1/f1-console/resources/trackList.txt");
		List<SeasonTeamPilot> lSTP = FileInputSTP
				.mapFileToSTPList("C:/Mydoc/Git/f1/f1-console/resources/idSTPList.txt");
		List<Race> lRace = FileInputRace.mapFileToRaceList("C:/Mydoc/Git/f1/f1-console/resources/raceList.txt");
		List<RaceResult> lRaceResult = FileInputRaceResult
				.mapFileToRaceResult("C:/Mydoc/Git/f1/f1-console/resources/raceResult.txt");
		List<Score> lScore = FileInputScore.mapFileToScoreList("C:/Mydoc/Git/f1/f1-console/resources/scoreList.txt");

		buildStructure(lTeam, lPilot, lSeason, lTrack, lSTP, lRace, lRaceResult, lScore);
		Report.outputInfo(lSeason);
		HashMap<String, Integer> totalResult = Report.seasonResult(lSeason.get(0)); // для сезона 2020 - сохраняем
																					// результат в totalResult

		Report.sortedResult2(totalResult, lSeason.get(0));

	}

	private static void buildStructure(List<Team> lTeam, List<Pilot> lPilot, List<Season> lSeason, List<Track> lTrack,
			List<SeasonTeamPilot> lSTP, List<Race> lRace, List<RaceResult> lRaceResult, List<Score> lScore) {
		for (Season es : lSeason) { // для каждого елемента es типа Season из списка lSeason
			List<SeasonTeamPilot> hh = Season.findSeasonSTP(es.getIdSeason(), lSTP); // находим SeasonTeamPilot текущего
																						// Seson
			es.setSTPList(hh); // поомещаем внутрь текущего Season список его SeasonTeamPilot

			List<Race> jj = Season.findSeasonRace(es.getIdSeason(), lRace); // находим Race текущего Season
			es.setRaceList(jj); // поомещаем внутрь текущего Season список его Race
		}

		for (SeasonTeamPilot ess : lSTP) {
			Team top = SeasonTeamPilot.findTeam(ess.getIdTeam(), lTeam);
			Pilot gr = SeasonTeamPilot.findPilot(ess.getIdPilot(), lPilot);
			ess.setTeamInfo(top);
			ess.setPilotInfo(gr);
		}
		for (Race rt : lRace) {
			Track currentTrack = Race.findTrack(rt.getIdTrack(), lTrack);
			rt.setTrackInfo(currentTrack);

			List<RaceResult> currentRR = Race.findRaceRS(rt.getIdSeason(), rt.getIdTrack(), lRaceResult);
			rt.setRRList(currentRR);
		}
		for (RaceResult rr : lRaceResult) {
			Score currentS = RaceResult.findRSScore(rr.getPlace(), lScore);
			rr.setScore(currentS);
		}
	}
}