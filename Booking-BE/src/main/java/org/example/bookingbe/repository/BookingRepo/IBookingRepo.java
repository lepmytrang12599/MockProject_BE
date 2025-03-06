package org.example.bookingbe.repository.BookingRepo;

import org.example.bookingbe.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IBookingRepo extends JpaRepository<Booking, Long> {

    @Query("SELECT COALESCE(SUM(b.totalPrice), 0) FROM Booking b WHERE b.bookingDate BETWEEN :startDate AND :endDate")
    Double getTotalRevenue(LocalDate startDate, LocalDate endDate);

    @Query("SELECT COUNT(b.id) FROM Booking b WHERE b.bookingDate BETWEEN :startDate AND :endDate")
    Long getTotalBookings(LocalDate startDate, LocalDate endDate);

    @Query("SELECT r.name, COUNT(b.id) FROM Booking b JOIN b.room r GROUP BY r.name ORDER BY COUNT(b.id) DESC")
    List<Object[]> getPopularRooms();

    @Query("SELECT MONTH(b.bookingDate), SUM(b.totalPrice) FROM Booking b WHERE YEAR(b.bookingDate) = YEAR(CURRENT_DATE) GROUP BY MONTH(b.bookingDate)")
    List<Object[]> getRevenueByMonth();

    @Query("SELECT r.roomType, COUNT(b.id) FROM Booking b JOIN b.room r GROUP BY r.roomType")
    List<Object[]> getBookingRatesByRoomType();
    
   @Query("SELECT b FROM Booking b WHERE b.bookingDate BETWEEN :start AND :end")
List<Booking> findBookingsByDateRange(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

}
