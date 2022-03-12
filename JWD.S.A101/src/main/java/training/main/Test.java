package training.main;

import java.util.ArrayList;
import java.util.List;

import training.entities.Pet;
import training.services.IOService;


public class Test {
	IOService iOService = new IOService();
	
	public static void main(String[] args) {
		
		Pet pt1 = new Pet("meo", "kiki", 1);
		Pet pt2 = new Pet("meo", "cucu", 2);
		Pet pt3 = new Pet("meo", "meo", 3);
		Pet pt4 = new Pet("cat", "mew mew", 1);
		
		List<Pet>lst = new ArrayList<Pet>();
		lst.add(pt1);
		lst.add(pt2);
		lst.add(pt3);
		lst.add(pt4);
		
		Test t = new Test();
		
		t.iOService.savePest(lst);
		List <Pet> lstPets = t.iOService.getPets();
		
		for (Pet pet : lstPets) {
			System.out.println(pet);
			new Pet().makeNoise(pet);
		}
		
		
	}
}
