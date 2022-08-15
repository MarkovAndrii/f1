package f1.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputRaceResult {
	public static RaceResult mapStringToRaceResult(String rrSplit) { // метод mapStringToRace отделяет поля
		String[] rrFields = rrSplit.split(",");
		RaceResult rr = new RaceResult();
		rr.setIdSeason(rrFields[0]);
		rr.setIdTrack(rrFields[1]);
		rr.setIdPilot(rrFields[2]);
		rr.setPlace(Integer.parseInt(rrFields[3]));
		rr.setFastLap(rrFields[4].equals("1"));
		return rr;
	}

	public static List<RaceResult> mapFileToRaceResult(String pathToFile) { // метод mapFileToRaceResult читает данние
																			// из
		// файла
		ArrayList<RaceResult> alRR = new ArrayList<>();
		try {
			File file = new File(pathToFile);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				RaceResult ee = mapStringToRaceResult(line);
				alRR.add(ee);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return alRR;

	}
}
