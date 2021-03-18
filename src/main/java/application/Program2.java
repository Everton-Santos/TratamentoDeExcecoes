package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program2 {

	public static void main(String[] args)  {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	
		
		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			sc.nextLine();
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf1.parse(sc.next());
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf1.parse(sc.next());
			 
			
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf1.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf1.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
		} catch (DomainException e) {
			System.err.println("Erro in reservation: " + e.getMessage());
		} catch (ParseException e) {
			System.err.println("Invalid date format");
		} catch (InputMismatchException e) {
			System.err.println("Invalid Room number format");
		} finally {
			sc.close();
		}
		

	}

}
