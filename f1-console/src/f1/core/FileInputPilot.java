package f1.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputPilot {
	public static Pilot mapStringToPilot(String pilotSplit) { // метод mapStringToPilot отделяет поля
		String[] pilotFields = pilotSplit.split(",");
		Pilot p = new Pilot();
		p.setIdPilot(pilotFields[0]);
		p.setPilotName(pilotFields[1]);
		p.setPilotSurname(pilotFields[2]);
		p.setPilotNation(pilotFields[3]);
		p.setPilotAge(pilotFields[4]);
		p.setStartDate(Integer.parseInt(pilotFields[5]));
		return p;
	}

	public static List<Pilot> mapFileToPilotList(String pathToFile) { // метод mapFileToPilotList читает данние из файла
		ArrayList<Pilot> alPilot = new ArrayList<>();
		try {
			File file = new File(pathToFile);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				Pilot b = mapStringToPilot(line);
				alPilot.add(b);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return alPilot;

	}
}