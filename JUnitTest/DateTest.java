package JUnitTest;

import static org.junit.Assert.*;
import java.util.GregorianCalendar;
import java.util.Calendar;

import java.util.Date;

import org.junit.Test;

import program.DateOperation;

public class DateTest {

	private final Date afterDate = new GregorianCalendar(2021, Calendar.FEBRUARY, 11).getTime();
    private final Date beforeDate = new GregorianCalendar(2021, Calendar.FEBRUARY, 6).getTime();
    private final DateOperation dto = new DateOperation();
    
    //Test successful!
	@Test
	public void testDateConvert() {
		
		/*
		 * converting to epochmili/1000
		 */
		long res=dto.convertDate( afterDate);
		long res2=dto.convertDate(beforeDate);
		assertEquals(1612990800,res);
		assertEquals(1612558800,res2);
	}
	
	//Test successful!
	@Test
	public void testDateCompare() {
		
		/*
		 * compareDates(beforeDate, afterDate) must return "true" because beforeDate occurs before afterDate;
		 * compareDates(date, date2) must return "false" because afterDate occurs after beforeDate;
		 * simply: if(firstParameter>secondParameter) return true;
		 * if(firstParameter<secondParameter) return false;
		 */
		boolean res=dto.compareDates(beforeDate, afterDate);
		boolean res2=dto.compareDates(afterDate, beforeDate);
		assertEquals(false,res2);
		assertEquals(true,res);

	}
	
	//Test successful!
	@Test
	public void testDateDifference() {
		
		long res =dto.getDateDiff(beforeDate,afterDate);
		assertEquals(5, res);
	}
	


	
}
