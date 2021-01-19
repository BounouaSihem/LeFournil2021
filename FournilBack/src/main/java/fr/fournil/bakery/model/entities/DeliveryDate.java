package fr.fournil.bakery.model.entities;


import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;


public class DeliveryDate {
	Calendar calendar = Calendar.getInstance();
	// Dates de livraison 
	public static final  int mardi=Calendar.TUESDAY ; 
	public static final  int jeudi=Calendar.THURSDAY ;
	public static final  int vendredi=Calendar.FRIDAY ;
	
	//public static final  DayOfWeek mardi=DayOfWeek.TUESDAY ;
	//public static final  DayOfWeek jeudi=DayOfWeek.THURSDAY;
	//public static final  DayOfWeek vendredi=DayOfWeek.FRIDAY;
    
}