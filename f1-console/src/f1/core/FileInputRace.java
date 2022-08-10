package f1.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputRace {
	public static Race mapStringToRace(String stpSplit) { // метод mapStringToRace отделяет поля
		String[] stpFields = stpSplit.split(",");
		Race stp = new Race();
		stp.setIdSeason(stpFields[0]);
		stp.setIdTrack(stpFields[1]);
		return stp;
	}

	public static List<Race> mapFileToRaceList(String pathToFile) { // метод mapFileToRaceList читает данние из
																	// файла
		ArrayList<Race> alRace = new ArrayList<>();
		try {
			File file = new File(pathToFile);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				Race ee = mapStringToRace(line);
				alRace.add(ee);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return alRace;

	}
}
