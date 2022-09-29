package chpt3;

//Ex3_14.java
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;
public class Ex3_14 {

	public static void main(String[] args){
		//Date���÷�
		Date d=new Date();
		System.out.println("���ڵ�ʱ���ǣ�"+d);
		
		//Calendar���÷�
		Calendar c = Calendar.getInstance();  
		System.out.println("������:"+c.get(Calendar.YEAR )+"��"+c.get(Calendar.MONTH)+"��"+c.get(Calendar.DATE)+"��");
		System.out.println("�����ڽ������ǵ�"+c.get(Calendar.DAY_OF_YEAR)+"��");//������һ������һ�����ǵڼ���
		
		//GregorianCalendar���÷�
		GregorianCalendar ca = new GregorianCalendar();
		System.out.println("Gregorianʱ���ǣ�"+ca.getTime());
		
		//SimpleDateFormat���÷�
		SimpleDateFormat myFormat=new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
		System.out.println("��ʽ��ʱ�䣺"+myFormat.format(new Date()));
	
		//clock��ʹ�� 
		final Clock clock = Clock.systemUTC();
		System.out.println( "Clock��õĵ�ǰʱ�䣺"+clock.instant() );
		
		//Localdate��Localtime��ʹ��
		final LocalDate date = LocalDate.now();
		final LocalDate dateFromClock = LocalDate.now( clock );
		//��ȡ��ǰ����        
		System.out.println( "Localdate��õ�ǰ���ڣ�"+date );
		System.out.println( "Localdate��Clock��õĵ�ǰʱ�䣺"+dateFromClock );
		        
		// ��ȡ��ǰʱ��
		final LocalTime time = LocalTime.now();
		final LocalTime timeFromClock = LocalTime.now( clock );
		        
		System.out.println( "Localtime��õ�ǰʱ�䣺"+time );
		System.out.println("Localtime��Clock��õĵ�ǰʱ�䣺"+timeFromClock );
	    
		// Localdatetime��ʹ��
		final LocalDateTime datetime = LocalDateTime.now();
		final LocalDateTime datetimeFromClock = LocalDateTime.now( clock );
		System.out.println( "Localdatetime��õ�ǰʱ�䣺"+datetime );
		System.out.println( "Localdatetime��Clock��õĵ�ǰʱ�䣺"+datetimeFromClock );
		
		//ZonedDateTime��ʹ��
		final ZonedDateTime zonedDatetime = ZonedDateTime.now();
		final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now( clock );
		final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now( ZoneId.of( "America/Los_Angeles" ) );
		        
		System.out.println("��ǰʱ��ʱ�䣺" +zonedDatetime );
		System.out.println( "��Clock��õĵ�ǰʱ��ʱ�䣺"+zonedDatetimeFromClock );
		System.out.println( "����Los_Angelesʱ�䣺"+zonedDatetimeFromZone );
	}
}
