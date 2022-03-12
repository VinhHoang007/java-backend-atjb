package training.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import training.entities.Pet;

public class IOService {
	public static final String path = "pets.txt";

	public void savePest(List<Pet> pets) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(path, false);
			for (Pet fw : pets) {
				writer.write(fw.getType() + ",");
				writer.write(fw.getName() + ",");
				writer.write(fw.getAge()+"\n");

			}
			System.out.println("Save Success!!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Save Fail");
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public List<Pet> getPets() {
		List<Pet> pets = new ArrayList<Pet>();
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.isEmpty()) {
					continue;
				}
				String[] data = line.split(",");
				pets.add(new Pet(data[0], data[1], Integer.parseInt(data[2])));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pets;
	}
}
