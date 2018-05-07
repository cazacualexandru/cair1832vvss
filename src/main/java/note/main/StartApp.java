package note.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import note.model.Nota;
import note.utils.ClasaException;

import note.model.Corigent;
import note.model.Medie;

import note.controller.NoteController;

//functionalitati
//i.	 adaugarea unei note la o anumita materie (nr. matricol, materie, nota acordata); 
//ii.	 calcularea mediilor semestriale pentru fiecare elev (nume, nr. matricol), 
//iii.	 afisarea elevilor coringenti, ordonati descrescator dupa numarul de materii la care nu au promovat şi alfabetic dupa nume.


public class StartApp {

	/**
	 * @param args
	 * @throws ClasaException 
	 */
	public static void main(String[] args) throws ClasaException {
		 // TODO Auto-generated method stub
		NoteController ctrl = new NoteController();
		List<Medie> medii = new LinkedList<Medie>();
		List<Corigent> corigenti = new ArrayList<Corigent>();
		ctrl.readElevi(args[0]);
		ctrl.readNote(args[1]);
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		boolean gasit = false;
		while(!gasit) {
			System.out.println("1. Adaugare Nota");
			System.out.println("2. Calculeaza medii");
			System.out.println("3. Elevi corigenti");
			System.out.println("4. Iesire");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
		    try {
				int option = Integer.parseInt(br.readLine());
				switch(option) {
				case 1:
					System.out.println("numar matricol: ");
					int nrMatricol = Integer.parseInt(br.readLine());
					System.out.println("materie: ");
					String materie = br.readLine();
					System.out.println("nota: ");
					double not = Double.parseDouble(br.readLine());

					Nota nota = new Nota(nrMatricol, materie, not);
					ctrl.addNota(nota);
					break;
				case 2: medii = ctrl.calculeazaMedii();
						for(Medie medie:medii)
							System.out.println(medie);
						break;
				case 3: corigenti = ctrl.getCorigenti();
						for(Corigent corigent:corigenti)
							System.out.println(corigent);
						break;
				case 4: gasit = true;
					ctrl.exportData(args[1]);
						break;
				default: System.out.println("Introduceti o optiune valida!");
				}
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
