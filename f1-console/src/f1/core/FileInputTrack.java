package f1.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputTrack {
	public static Track mapStringToTrack(String trackSplit) { // метод mapStringToTrack отделяет поля
		String[] trackFields = trackSplit.split(",");
		Track r = new Track();
		r.setIdTrack(trackFields[0]);
		r.setGpName(trackFields[1]);
		r.setTrackName(trackFields[2]);
		r.setCountry(trackFields[3]);
		r.setTrackLength(Integer.parseInt(trackFields[4]));
		return r;
	}

	public static List<Track> mapFileToTrackList(String pathToFile) { // метод mapFileToTrackList читает данние из
																	// файла
		ArrayList<Track> alTrack = new ArrayList<>();
		try {
			File file = new File(pathToFile);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				Track d = mapStringToTrack(line);
				alTrack.add(d);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return alTrack;

	}
}