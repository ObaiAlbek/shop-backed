package com.obai.shop.main;

import java.time.LocalDate;

import com.obai.shop.model.Adresse;
import com.obai.shop.model.Privatkunde;
import com.obai.shop.model.Produkt;
import com.obai.shop.model.Rechnung;
import com.obai.shop.model.Rechnungsposition;
import com.obai.shop.model.Rechnungsstatus;

public class Main {

	public static void main(String[] args) {

	    Privatkunde obai = new Privatkunde();
	    obai.setVorname("Obai");
	    obai.setNachname("Albek");
	    obai.setAnschrift(new Adresse(null, "Gärtnerstraße", "25", "68169", "Mannheim"));

	    Produkt laptop = new Produkt();
	    laptop.setBezeichnung("MacBook");
	    laptop.setPreis(2000.0);

	    Rechnung rechnung = new Rechnung();
	    rechnung.setKunde(obai);
	    rechnung.setRechnungsDatum(LocalDate.now());
	    rechnung.setStatus(Rechnungsstatus.OFFEN);

	    Rechnungsposition pos1 = new Rechnungsposition();
	    pos1.setProdukt(laptop);
	    pos1.setMenge(1);
	    pos1.setEinzelPreis(2000.0);

	    rechnung.addPosition(pos1);

	   // rechnungRepository.save(rechnung);
	}

}
