package model.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import model.exceptions.ReservationException;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;

	public Reservation() {

	}

	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) throws ReservationException {
		if (!checkout.isAfter(checkin))
			throw new ReservationException("Error in reservation: Check-out date must be after check-in date");
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	public void updateDates(LocalDate checkin, LocalDate checkout) throws ReservationException {
		LocalDate now = LocalDate.now();// hoje

		if (checkin.isBefore(now) || checkout.isBefore(now))
			throw new ReservationException(
					"Error in reservation: Reservation dates for update must be future dates");
		if (!checkout.isAfter(checkin))
			throw new ReservationException("Error in reservation: Check-out date must be after check-in date");
		this.checkin = checkin;
		this.checkout = checkout;

	}

	public int duration() {
		return Period.between(checkin, checkout).getDays();
	}

	@Override
	public String toString() {
		// Reservation: Room 8021, check-in: 23/09/2019, check-out: 26/09/2019, 3 nights
		var dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return String.format("Reservation: Room %d, check-in: %s, check-out: %s, %d nights", roomNumber,
				checkin.format(dtf), checkout.format(dtf), duration());
	}

}
