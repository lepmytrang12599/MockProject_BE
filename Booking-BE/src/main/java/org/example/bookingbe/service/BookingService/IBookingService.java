package org.example.bookingbe.service.BookingService;

import org.example.bookingbe.model.Booking;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IBookingService {
    Booking saveBooking(Booking booking);
    List<Booking> getAllBookings();
    Optional<Booking> getBookingById(Long id);
    void deleteBooking(Long id);
    List<Booking> findBookingsByDateRange(LocalDateTime start, LocalDateTime end);
    
}
