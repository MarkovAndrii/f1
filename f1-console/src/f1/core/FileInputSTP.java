package f1.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputSTP {
	public static SeasonTeamPilot mapStringToSTP(String stpSplit) { // метод mapStringToSTP отделяет поля
		String[] stpFields = stpSplit.split(",");
		SeasonTeamPilot stp = new SeasonTeamPilot();
		stp.setIdSeason(stpFields[0]);
		stp.setIdTeam(stpFields[1]);
		stp.setIdPilot(stpFields[2]);
		return stp;
	}

	public static List<SeasonTeamPilot> mapFileToSTPList(String pathToFile) { // метод mapFileToSTPList читает данние из
																				// файла
		ArrayList<SeasonTeamPilot> alSTP = new ArrayList<>();
		try {
			File file = new File(pathToFile);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				SeasonTeamPilot ee = mapStringToSTP(line);
				alSTP.add(ee);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return alSTP;

	}
}