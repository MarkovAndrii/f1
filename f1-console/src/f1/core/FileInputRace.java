package f1.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputRace {
	public static Race mapStringToRace(String raceSplit) { // метод mapStringToRace отделяет поля
		String[] raceFields = raceSplit.split(",");
		Race r = new Race();
		r.setIdRace(raceFields[0]);
		r.setGpName(raceFields[1]);
		r.setTrackName(raceFields[2]);
		r.setCountry(raceFields[3]);
		r.setTrackLength(Integer.parseInt(raceFields[4]));
		return r;
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
				Race d = mapStringToRace(line);
				alRace.add(d);
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