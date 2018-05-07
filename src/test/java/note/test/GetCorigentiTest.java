package note.test;

import static org.junit.Assert.*;

import java.util.List;

import note.model.Corigent;
import note.model.Elev;
import note.model.Nota;

import org.junit.Before;
import org.junit.Test;

import note.utils.ClasaException;

import note.controller.NoteController;


public class GetCorigentiTest {
	
	private NoteController ctrl;

	@Before
	public void setUp() throws Exception {
		ctrl = new NoteController();
	}

	@Test
	public void test1() throws ClasaException {
		Elev e1 = new Elev(1, "Elev1");
		Elev e2 = new Elev(2, "Elev2");
		ctrl.addElev(e1);
		ctrl.addElev(e2);
		Nota n1 = new Nota(1,"Materie1", 10);
		Nota n2 = new Nota(1,"Materie1", 7);
		Nota n3 = new Nota(1,"Materie2", 10);
		Nota n4 = new Nota(1,"Materie2", 10);
		Nota n5 = new Nota(2,"Materie2", 4);
		Nota n6 = new Nota(2,"Materie2", 5);
		Nota n7 = new Nota(2,"Materie2", 6);
		Nota n8 = new Nota(2,"Materie1", 7);
		ctrl.addNota(n1);
		ctrl.addNota(n2);
		ctrl.addNota(n3);
		ctrl.addNota(n4);
		ctrl.addNota(n5);
		ctrl.addNota(n6);
		ctrl.addNota(n7);
		ctrl.addNota(n8);
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		List<Corigent> corigenti = ctrl.getCorigenti();
		assertEquals(corigenti.size(),0);
	}

	
	@Test
	public void test2() throws ClasaException {
		Elev e1 = new Elev(1, "Elev1");
		Elev e2 = new Elev(2, "Elev2");
		ctrl.addElev(e1);
		ctrl.addElev(e2);
		Nota n1 = new Nota(1,"Materie1", 10);
		Nota n2 = new Nota(1,"Materie1", 7);
		Nota n3 = new Nota(1,"Materie2", 10);
		Nota n4 = new Nota(1,"Materie2", 10);
		Nota n5 = new Nota(2,"Materie2", 4);
		Nota n6 = new Nota(2,"Materie2", 5);
		Nota n7 = new Nota(2,"Materie2", 3);
		Nota n8 = new Nota(2,"Materie1", 7);
		ctrl.addNota(n1);
		ctrl.addNota(n2);
		ctrl.addNota(n3);
		ctrl.addNota(n4);
		ctrl.addNota(n5);
		ctrl.addNota(n6);
		ctrl.addNota(n7);
		ctrl.addNota(n8);
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		List<Corigent> corigenti = ctrl.getCorigenti();
		assertEquals(corigenti.size(),1);
	}
	
	@Test
	public void test3() throws ClasaException {
		Elev e1 = new Elev(1, "Elev1");
		Elev e2 = new Elev(2, "Elev2");
		ctrl.addElev(e1);
		ctrl.addElev(e2);
		Nota n1 = new Nota(1,"Materie1", 1);
		Nota n2 = new Nota(1,"Materie1", 7);
		Nota n3 = new Nota(1,"Materie2", 10);
		Nota n4 = new Nota(1,"Materie2", 10);
		Nota n5 = new Nota(2,"Materie2", 4);
		Nota n6 = new Nota(2,"Materie2", 5);
		Nota n7 = new Nota(2,"Materie2", 3);
		Nota n8 = new Nota(2,"Materie1", 7);
		ctrl.addNota(n1);
		ctrl.addNota(n2);
		ctrl.addNota(n3);
		ctrl.addNota(n4);
		ctrl.addNota(n5);
		ctrl.addNota(n6);
		ctrl.addNota(n7);
		ctrl.addNota(n8);
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		List<Corigent> corigenti = ctrl.getCorigenti();
		assertEquals(corigenti.get(1).getNrMaterii(), corigenti.get(0).getNrMaterii());
	}
	
	@Test
	public void test4() throws ClasaException {
		Elev e1 = new Elev(1, "Elev1");
		Elev e2 = new Elev(2, "Elev2");
		Elev e3 = new Elev(3, "Elev3");
		Elev e4 = new Elev(4, "Elev");
		ctrl.addElev(e1);
		ctrl.addElev(e2);
		ctrl.addElev(e3);
		ctrl.addElev(e4);

		Nota n1 = new Nota(1,"Materie1", 1);
		Nota n2 = new Nota(1,"Materie1", 7);
		Nota n3 = new Nota(1,"Materie2", 10);
		Nota n4 = new Nota(1,"Materie2", 10);
		Nota n5 = new Nota(2,"Materie2", 4);
		Nota n6 = new Nota(2,"Materie2", 5);
		Nota n7 = new Nota(2,"Materie2", 3);
		Nota n8 = new Nota(2,"Materie1", 4);

		Nota n9 = new Nota(3,"Materie2", 3);
		Nota n10 = new Nota(3,"Materie1", 4);
		Nota n11 = new Nota(4,"Materie2", 10);
		Nota n12 = new Nota(4,"Materie1", 4);
		ctrl.addNota(n1);
		ctrl.addNota(n2);
		ctrl.addNota(n3);
		ctrl.addNota(n4);
		ctrl.addNota(n5);
		ctrl.addNota(n6);
		ctrl.addNota(n7);
		ctrl.addNota(n8);
		ctrl.addNota(n9);
		ctrl.addNota(n10);
		ctrl.addNota(n11);
		ctrl.addNota(n12);
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		List<Corigent> corigenti = ctrl.getCorigenti();
		assertEquals(corigenti.size(),4);
		assert(corigenti.get(0).getNrMaterii() >= corigenti.get(1).getNrMaterii());
		assert(corigenti.get(1).getNrMaterii() >= corigenti.get(2).getNrMaterii());
		assert(corigenti.get(2).getNrMaterii() == corigenti.get(3).getNrMaterii());
		assert(corigenti.get(1).getNumeElev().compareTo(corigenti.get(2).getNumeElev()) > 0);
	}
	
	@Test
	public void test5() throws ClasaException {
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		List<Corigent> corigenti = ctrl.getCorigenti();
		assertEquals(corigenti.size(),0);
	}
	
	@Test
	public void test6() throws ClasaException {
		//Elev e1 = new Elev(1, "Elev1");
		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		List<Corigent> corigenti = ctrl.getCorigenti();
		assertEquals(corigenti.size(),0);
	}
}
