package controllers;


import java.math.BigDecimal;
import java.util.List;

import models.Analitikamagacinskekartice;
import models.Prometnidokument;
import models.Roba;
import models.Robnakartica;
import models.Stavkadokumenta;
import play.mvc.Controller;
import play.mvc.With;

//@With(Security.class)
public class Stavkedokumenta extends Controller{
	
	public static void read() {
		
		List<Stavkadokumenta> stavkeDok = Stavkadokumenta.findAll();
		
		render(stavkeDok);
	}
	
	public static void crete(int kolicina, String cena, String vrednost, Analitikamagacinskekartice analitikamagacinskekartice, Roba roba, Prometnidokument prometnidokument) {
		
		Stavkadokumenta stavkadokumenta = new Stavkadokumenta(kolicina, Double.valueOf(cena), Double.valueOf(vrednost), analitikamagacinskekartice, roba, prometnidokument);
		stavkadokumenta.save();
	}
	
	public static void update(Long id, int kolicina, String cena, String vrednost, Analitikamagacinskekartice analitikamagacinskekartice, Roba roba, Prometnidokument prometnidokument) {
		
		Stavkadokumenta s = Stavkadokumenta.findById(id);
		s.kolicina = kolicina;
		s.cena = Double.valueOf(cena);
		s.vrednost  = Double.valueOf(vrednost);
		s.analitikaMagacinskeKartice = analitikamagacinskekartice;
		s.roba = roba;
		s.prometniDokument = prometnidokument;
		s.save();
		
		read();
		
	}
	
	public static void delete(Long id){
		Stavkadokumenta stavkadok = Stavkadokumenta.findById(id);
    	stavkadok.delete();
    	
    	read();
	}

	public static void filter(){
	
	}

}
