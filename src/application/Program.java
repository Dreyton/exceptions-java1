package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.ReservationException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			var dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			System.out.print("Room number:");
			Integer roomNumber = sc.nextInt();
			sc.nextLine();

			System.out.print("Check-in date(dd/MM/yyyy):");
			LocalDate checkin = LocalDate.parse(sc.nextLine(), dtf);

			System.out.print("Check-out date(dd/MM/yyyy):");
			LocalDate checkout = LocalDate.parse(sc.nextLine(), dtf);

			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reservation);

			System.out.println("Enter data to update the reservation:");

			System.out.print("Check-in date(dd/MM/yyyy):");
			checkin = LocalDate.parse(sc.nextLine(), dtf);

			System.out.print("Check-out date(dd/MM/yyyy):");
			checkout = LocalDate.parse(sc.nextLine(), dtf);

			reservation.updateDates(checkin, checkout);
		}catch (ReservationException e) {
			System.out.println(e.getMessage());
		}  
		catch (InputMismatchException e) {
			System.out.println("Type a number for room number!!!!!!");
		}catch (RuntimeException e) {
			System.out.println("Error");
		} finally {
			sc.close();
		}

	}

}




