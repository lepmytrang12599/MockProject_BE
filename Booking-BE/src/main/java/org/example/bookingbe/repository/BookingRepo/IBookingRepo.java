package org.example.bookingbe.repository.BookingRepo;

import java.time.LocalDate;
import java.util.List;

import org.example.bookingbe.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingRepo extends JpaRepository<Booking, Long> {

  @Query("SELECT SUM(b.price) FROM Booking b WHERE b.bookingDate BETWEEN :startDate AND :endDate")
    Double getTotalRevenue(LocalDate startDate, LocalDate endDate);

    @Query("SELECT COUNT(b) FROM Booking b WHERE b.bookingDate BETWEEN :startDate AND :endDate")
    Long getTotalBookings(LocalDate startDate, LocalDate endDate);

    @Query("SELECT b.roomType, COUNT(b) FROM Booking b GROUP BY b.roomType ORDER BY COUNT(b) DESC")
    List<Object[]> getPopularRooms();
}
