package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		var dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Room number:");
		Integer roomNumber = sc.nextInt();
		sc.nextLine();

		System.out.print("Check-in date(dd/MM/yyyy):");
		LocalDate checkin = LocalDate.parse(sc.nextLine(), dtf);

		System.out.print("Check-out date(dd/MM/yyyy):");
		LocalDate checkout = LocalDate.parse(sc.nextLine(), dtf);

		if (checkout.isAfter(checkin)) {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reservation);

			System.out.println("Enter data to update the reservation:");

			System.out.print("Check-in date(dd/MM/yyyy):");
			checkin = LocalDate.parse(sc.nextLine(), dtf);

			System.out.print("Check-out date(dd/MM/yyyy):");
			checkout = LocalDate.parse(sc.nextLine(), dtf);

			String erro = reservation.updateDates(checkin, checkout);
			if(erro == null)
				System.out.println(reservation);
			else
				System.out.println(erro);

		} else {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}

		sc.close();
	}

}
