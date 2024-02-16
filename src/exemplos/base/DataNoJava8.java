package exemplos.base;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DataNoJava8 {
	
	public static void main(String[] args) {
		
		// falta de intuitividade
		Date date = new Date();
		System.out.println(date);
		System.out.println(date.getMonth());
		
		// objetos pesados
		Calendar instance = Calendar.getInstance();
		System.out.println(instance);
		
		localDate();
		
		//localDateTime();
		
		//time();
		
		//periods();
		
		//enums();
		
		// para saber mais:
		
		//https://www.baeldung.com/java-8-date-time-intro
		
	}

	private static void enums() {
		// enuns
		DayOfWeek sexta = DayOfWeek.FRIDAY;
		System.out.println(sexta);
		
		DayOfWeek segunda = DayOfWeek.MONDAY;
		System.out.println(segunda);
	}

	private static void periods() {
		// Period
		LocalDate dataInicial = LocalDate.parse("2007-05-10");
		System.out.println(dataInicial);
		
		LocalDate dataMaisCincoDias = dataInicial.plus(Period.ofDays(5));
		System.out.println(dataMaisCincoDias);
		
		int diferencaEntreAsDatas = Period.between(dataInicial, dataMaisCincoDias).getDays();
		System.out.println(diferencaEntreAsDatas);
	}

	private static void time() {
		// LocalTime
		LocalTime horaDeAgora = LocalTime.now();
		System.out.println(horaDeAgora);
		
		LocalTime horaParametrizada = LocalTime.of(6, 30);
		System.out.println(horaParametrizada);
		
		LocalTime horaComMaisUmaHora = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);
		System.out.println(horaComMaisUmaHora);
		
		int horaEmNumerico = LocalTime.parse("06:30").getHour();
		System.out.println(horaEmNumerico);
		
		boolean vemAntes = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"));
		System.out.println(vemAntes);
		
		LocalTime horaMaxima = LocalTime.MAX;
		System.out.println(horaMaxima);
		
		LocalTime seisEMeia = LocalTime.parse("06:30");
		System.out.println(seisEMeia);
	}

	private static void localDateTime() {
		// LocalDateTime 
		System.out.println(LocalDateTime.now());
		LocalDateTime dataEHora = LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);
		System.out.println(dataEHora);
		
		LocalDateTime dataEHora2 = LocalDateTime.parse("2015-02-20T06:30:00");
		System.out.println(dataEHora2);
		
		LocalDateTime menosDuasHoras = dataEHora2.minusHours(2);
		System.out.println(menosDuasHoras);
	}

	private static void localDate() {
		// LocalDate e principais metodos estaticos
		LocalDate agora = LocalDate.now();
		System.out.println(agora);
		
		LocalDate dataParametrizada = LocalDate.of(2015, 02, 20);
		System.out.println(dataParametrizada);
				
		LocalDate outraDataParametrizada = LocalDate.parse("2015-02-20");
		System.out.println(outraDataParametrizada);
		
		// excelentes metodos uteis
		DayOfWeek diaDaSemana = LocalDate.parse("2016-06-12").getDayOfWeek();
		System.out.println(diaDaSemana);
		
		int diaDoMes = LocalDate.parse("2016-06-12").getDayOfMonth();
		System.out.println(diaDoMes);
		
		LocalDate dataMaisUmDia = LocalDate.of(2015, 02, 20).plusDays(1);
		System.out.println(dataMaisUmDia);
		
		LocalDate dataMenosUmMes = LocalDate.parse("2015-02-20").minus(1, ChronoUnit.MONTHS);
		System.out.println(dataMenosUmMes);
		
		boolean anoBissexto = LocalDate.now().isLeapYear();
		System.out.println(anoBissexto);
		
		boolean notBefore = LocalDate.parse("2016-06-12").isBefore(LocalDate.parse("2016-06-11"));
		System.out.println(notBefore);
	}

}
