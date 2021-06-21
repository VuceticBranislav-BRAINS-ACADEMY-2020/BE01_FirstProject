package com.iktakademija.FirstProject.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyControlers {

	// http://localhost:8090/
	
	@RequestMapping("/")
	public String hello() {
		return "Moja prva aplikacija";
	}
	
	@RequestMapping("/hello")
	public String returnHello() {
		return "Hello world!";
	}
	
	// 2.1 Endpoint koji vraca "Hello yourName!"
	// putanja /greetings
	@RequestMapping("/greetings")
	public String returnGreetings() {
		return "Hello yourName!";
	}
	
	// 2.2 Endpoint koji vraca trenutni datum i vreme
	// putanja /date
	@RequestMapping("/date")
	public LocalDate returnDate() {	    
		LocalDate date = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		date.format(dtf);
		return date;
	}

	// 2.3 Endpoint koji vraca listu koja sadrzi imena clanova Vace porodice
	// putanja /family
	@RequestMapping("/family")
	public List<String> returnList() {
		List<String> list = new ArrayList<>();
		list.add("Item01");
		list.add("Item02");
		list.add("Item03");
		return list;
	}
	
	// 2.4 Endpoint koji vraca html stranicu sa imenima svih polaznika u grupi
	// sa naslovom Moja grupa. Imena su prikazana u okviru tabele
	// putanja /myclass
	@RequestMapping("/myclass")
	public String returnHtml() {
		// HTML text is plane String
		return "<html>"
		+ "<h1>Heading</h1><p>Paragraf text</p><tr>" 
		+ "<table>"
		+   "<thead>"
		+     "<tr>"
		+       "<th>Header</th>"
		+       "<th>Header</th>"
		+     "</tr>"
		+   "</thead>"
		+   "<tbody>"
		+     "<tr>"
		+       "<td>Petar</td>"
		+       "<td>Iva</td>"
		+     "</tr>"
		+     "<tr>"
		+       "<td>Petrovic</td>"
		+       "<td>Ivic</td>"
		+     "</tr>"
		+   "</tbody>"
		+ "</table>"
		+ "</html>";
	}

	// 3.1 Endpoint koji vraca niz celobrojnih vrednosti
	// putanja /array
	@RequestMapping("/array")
	public Integer[] returnArray() {
		Integer[] array = { 5, 6, 7 };
		return array;
	}

	// 3.2 Endpoint koji vraca sortiran niz celobrojnih vrednosti
	// putanja /sortarray
	@RequestMapping("/sortarray")
	public Integer[] returnSortedArray() {
		Integer[] array = { 5, 6, 7, 2, 1, 9, 3, 4 };
		Arrays.sort(array);
		return array;
	}
	
	// 3.3 Endpoint koji vraca minimalnu i maksimalnu vrednost iz niza celobrojnih vrednosti
	// putanja /minmax
	@RequestMapping("/minmax")
	public String returnMInMax() {
		Integer[] broj = { 5, 6, 7, 8, 6, 7, 5, 1, 6, 5 };
		Integer min, max;

		min = broj[0]; max = broj[0];
		for (Integer i = 1; i < broj.length; i++) {
			if (min > broj[i]) min = broj[i];
			if (max < broj[i]) max = broj[i];
		}
		System.out.println("LOG: Result displeyed to client.");
		return String.format("%d-%d", min, max);
	}
	
	// 3.4 Endpoint koji vraca sumu prvih n brojeva
	// putanja /sumaNiza
	@RequestMapping("/sumaNiza")
	public String returnSumaNiza() {
		Integer[] array = { 5, 6, 7, 8, 6, 7, 5, 1, 6, 5 };
		Integer sum = 0;

		for (Integer i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}
		System.out.println("LOG: Array calculated");
		return String.format("Suma: %d", sum);
	}
	
	// 3.5 Endpoint koji predstavlja englesko-srpski recnik i koji za rec na srpskom 
	// vrati odgovarajuci prevod na engleski jezik
	// putanja /recnik
	// DODATNO: ukoliko za trazenu rec ne postoji prevod, tada ispisati 
	// "Rec trazena_rec ne postoji u recniku.
	@RequestMapping(value = "/recnik/{input}", method = RequestMethod.GET)
	public String returnRecnik(@PathVariable("input") String rec) {
		switch (rec) {
		case "Back":
			return "Iza";			
		case "Front":
			return "Ispred";			
		default:
			return String.format("Rec %s nepostoji u recniku", rec);
		}		
	}
	
}
