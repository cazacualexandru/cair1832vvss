package note.model;

import java.util.Comparator;

public class Corigent implements Comparable<Corigent>{
	private String numeElev;
	private int nrMaterii;
	/**
	 * @return the numeElev
	 */
	
	public Corigent(String numeElev, int nrMaterii) {
		this.numeElev = numeElev;
		this.nrMaterii = nrMaterii;
	}
	
	
	public String getNumeElev() {
		return numeElev;
	}
	/**
	 * @param numeElev the numeElev to set
	 */
	public void setNumeElev(String numeElev) {
		this.numeElev = numeElev;
	}
	/**
	 * @return the nrMaterii
	 */
	public int getNrMaterii() {
		return nrMaterii;
	}
	/**
	 * @param nrMaterii the nrMaterii to set
	 */
	public void setNrMaterii(int nrMaterii) {
		this.nrMaterii = nrMaterii;
	}

	public String toString() {
		return numeElev + " -> " + nrMaterii;
	}

	public int compareTo(Corigent c)
	{
		if (this.getNrMaterii() < c.getNrMaterii())
		{
			return 1;
		}
		if (this.getNrMaterii() < c.getNrMaterii())
		{
			return -1;
		}
		return getNumeElev().compareTo(c.getNumeElev());
	}
}
