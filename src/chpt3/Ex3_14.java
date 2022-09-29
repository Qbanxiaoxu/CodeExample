package chpt3;

//Ex3_14.java
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;
public class Ex3_14 {

	public static void main(String[] args){
		//Date的用法
		Date d=new Date();
		System.out.println("现在的时间是："+d);
		
		//Calendar的用法
		Calendar c = Calendar.getInstance();  
		System.out.println("今天是:"+c.get(Calendar.YEAR )+"年"+c.get(Calendar.MONTH)+"月"+c.get(Calendar.DATE)+"日");
		System.out.println("今天在今年中是第"+c.get(Calendar.DAY_OF_YEAR)+"天");//返回这一天在这一年中是第几天
		
		//GregorianCalendar的用法
		GregorianCalendar ca = new GregorianCalendar();
		System.out.println("Gregorian时间是："+ca.getTime());
		
		//SimpleDateFormat的用法
		SimpleDateFormat myFormat=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		System.out.println("格式化时间："+myFormat.format(new Date()));
	
		//clock的使用 
		final Clock clock = Clock.systemUTC();
		System.out.println( "Clock获得的当前时间："+clock.instant() );
		
		//Localdate和Localtime的使用
		final LocalDate date = LocalDate.now();
		final LocalDate dateFromClock = LocalDate.now( clock );
		//获取当前日期        
		System.out.println( "Localdate获得当前日期："+date );
		System.out.println( "Localdate从Clock获得的当前时间："+dateFromClock );
		        
		// 获取当前时间
		final LocalTime time = LocalTime.now();
		final LocalTime timeFromClock = LocalTime.now( clock );
		        
		System.out.println( "Localtime获得当前时间："+time );
		System.out.println("Localtime从Clock获得的当前时间："+timeFromClock );
	    
		// Localdatetime的使用
		final LocalDateTime datetime = LocalDateTime.now();
		final LocalDateTime datetimeFromClock = LocalDateTime.now( clock );
		System.out.println( "Localdatetime获得当前时间："+datetime );
		System.out.println( "Localdatetime从Clock获得的当前时间："+datetimeFromClock );
		
		//ZonedDateTime的使用
		final ZonedDateTime zonedDatetime = ZonedDateTime.now();
		final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now( clock );
		final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now( ZoneId.of( "America/Los_Angeles" ) );
		        
		System.out.println("当前时区时间：" +zonedDatetime );
		System.out.println( "从Clock获得的当前时区时间："+zonedDatetimeFromClock );
		System.out.println( "美国Los_Angeles时间："+zonedDatetimeFromZone );
	}
}
