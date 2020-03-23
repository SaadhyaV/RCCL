package com.avps.cruisetest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.avps.Cruise.Application;
import com.avps.Cruise.Dao.CruiseRepository;
import com.avps.Cruise.Entity.Cruise;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CruiseRepositoryTest {

	@Autowired
	private CruiseRepository cruiseRepo;

	@Test
	public void findAllCruises() {
		// cruiseRepo.findByState(state);
		List<Cruise> all = cruiseRepo.findAll();
		for (Cruise cruise : all) {
			System.out.println(cruise);
		}
	}

	// @Test
	// public void findByState() {
	// Cruise s = cruiseRepo.findByState("Florida");
	// System.out.println("find by state: " + s);
	// }

	@Test
	public void findByDate() {
		String sdate = "Sat Apr 25 00:00:00 EDT 2020";
		// Sun Mar 22 03:20:27 EDT 2020
		SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

		try {
			Date parsedDate = sdf.parse(sdate);
			Cruise sd = cruiseRepo.findByCruiseDate(parsedDate);
			System.out.println("find by date: " + sd);
			System.out.println("parsed date: " + parsedDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void findAll() throws ParseException {
		String sDate = "Sun Mar 29 00:00:00 EDT 2020";
		SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		Date cruiseDate = sdf.parse(sDate);
		System.out.println("find all attributes: "
				+ cruiseRepo.findByStateAndDestinationAndCruiseDate("Georgia", "Asia", cruiseDate));
	}

}
