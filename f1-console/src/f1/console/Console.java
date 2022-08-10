package f1.console;

import java.util.List;

import f1.core.FileInputTeam;
import f1.core.FileInputPilot;
import f1.core.FileInputRace;
import f1.core.FileInputSeason;
import f1.core.FileInputTrack;
import f1.core.FileInputSTP;
import f1.core.Team;
import f1.core.Pilot;
import f1.core.Race;
import f1.core.Season;
import f1.core.SeasonTeamPilot;
import f1.core.Track;
import f1.core.Report;

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

		buildStructure(lTeam, lPilot, lSeason, lSTP, lRace);
		Report.outputInfo(lSeason);

	}

	private static void buildStructure(List<Team> lTeam, List<Pilot> lPilot, List<Season> lSeason,
			List<SeasonTeamPilot> lSTP, List<Race> lRace) {
		for (Season es : lSeason) { // для каждого елемента es типа Season из списка lSeason
			List<SeasonTeamPilot> hh = Season.findSeasonSTP(es.getIdSeason(), lSTP); // находим SeasonTeamPilot текущего
																						// Seson
			es.setSTPList(hh); // поомещаем внутрь текущего Season список его SeasonTeamPilot
		}
		for (Season es : lSeason) { // для каждого елемента es типа Season из списка lSeason
			List<Race> jj = Season.findSeasonRace(es.getIdSeason(), lRace); // находим Race текущего Seson
			es.setRaceList(jj); // поомещаем внутрь текущего Season список его Race
		}
		for (SeasonTeamPilot ess : lSTP) {
			Team top = SeasonTeamPilot.findTeam(ess.getIdTeam(), lTeam);
			Pilot gr = SeasonTeamPilot.findPilot(ess.getIdPilot(), lPilot);
			ess.setTeamInfo(top);
			ess.setPilotInfo(gr);
		}
		// for() {

		// }
	}
}