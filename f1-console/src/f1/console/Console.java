package f1.console;

import java.util.List;

import f1.core.FileInputTeam;
import f1.core.FileInputPilot;
import f1.core.FileInputSeason;
import f1.core.FileInputRace;
import f1.core.FileInputSTP;
import f1.core.Team;
import f1.core.Pilot;
import f1.core.Season;
import f1.core.SeasonTeamPilot;
import f1.core.Race;

public class Console {

	public static void main(String[] args) {
		List<Team> lTeam = FileInputTeam.mapFileToTeamList("C:/Mydoc/Git/f1/f1-console/resources/teamList.txt");
		List<Pilot> lPilot = FileInputPilot.mapFileToPilotList("C:/Mydoc/Git/f1/f1-console/resources/pilotList.txt");
		List<Season> lSeason = FileInputSeason
				.mapFileToSeasonList("C:/Mydoc/Git/f1/f1-console/resources/seasonList.txt");
		List<Race> lRace = FileInputRace.mapFileToRaceList("C:/Mydoc/Git/f1/f1-console/resources/raceList.txt");
		List<SeasonTeamPilot> lSTP = FileInputSTP
				.mapFileToSTPList("C:/Mydoc/Git/f1/f1-console/resources/idSTPList.txt");
	}

}