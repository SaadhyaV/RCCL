package com.avps.cruisetest;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.avps.Cruise.Application;
import com.avps.Cruise.Dao.CruiseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CruiseByDateTest {
	@Autowired
	private CruiseRepository cruiseRepo;

	@Test
	public void searchByDate() {
		System.out.println(cruiseRepo.findByCruiseDate(new Date()));

	}
}
