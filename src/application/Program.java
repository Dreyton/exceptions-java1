package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		var dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Room number:");
		Integer roomNumber = sc.nextInt();
		sc.nextLine();

		System.out.print("Check-in date(dd/MM/yyyy):");
		LocalDate checkin = LocalDate.parse(sc.nextLine(), dtf);
	}

}
