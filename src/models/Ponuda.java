package models;

import java.io.Serializable;

public class Ponuda implements Serializable {

	private String opis_sobe;
	private String usluge_sobe;
	private String usluge_bazena;
	private String usluge_saune;
	private String usluge_dorucka;
	private String usluge_rucka;
	
	
	public String getOpis_sobe() {
		return opis_sobe;
	}
	public void setOpis_sobe(String opis_sobe) {
		this.opis_sobe = opis_sobe;
	}
	public String getUsluge_sobe() {
		return usluge_sobe;
	}
	public void setUsluge_sobe(String usluge_sobe) {
		this.usluge_sobe = usluge_sobe;
	}
	public String getUsluge_bazena() {
		return usluge_bazena;
	}
	public void setUsluge_bazena(String usluge_bazena) {
		this.usluge_bazena = usluge_bazena;
	}
	public String getUsluge_saune() {
		return usluge_saune;
	}
	public void setUsluge_saune(String usluge_saune) {
		this.usluge_saune = usluge_saune;
	}
	public String getUsluge_dorucka() {
		return usluge_dorucka;
	}
	public void setUsluge_dorucka(String usluge_dorucka) {
		this.usluge_dorucka = usluge_dorucka;
	}
	public String getUsluge_rucka() {
		return usluge_rucka;
	}
	public void setUsluge_rucka(String usluge_rucka) {
		this.usluge_rucka = usluge_rucka;
	}
}
