package program;

import java.util.Date;
import java.util.concurrent.TimeUnit;

//DateOperation
public class DateOperation {

	
	public  static long convertDate(Date date) {
		if(date==null) {
			return 0;
		}else{
			long d = date.toInstant().toEpochMilli() / 1000;
			  return d;
		}
		  
	}
	
	  public static boolean compareDates(Date startDate, Date endDate){

	        //means startDate is bigger than endDate
	        if(startDate.compareTo(endDate)==1){
	            return false;
	        }else {
	        	return true;
	        }
	    }	 
	  public static long getDateDiff(Date date1, Date date2) {
		  
		    long diffInMillies = date2.getTime() - date1.getTime();
		    return TimeUnit.DAYS.convert(diffInMillies,TimeUnit.MILLISECONDS);
		}
	  public static Date addDays(Date date, int days) {
		  long time =date.getTime()+(days*24*60*60*1000);
		  Date newDate= new Date(time);
		return newDate;
	  }
	  
}
