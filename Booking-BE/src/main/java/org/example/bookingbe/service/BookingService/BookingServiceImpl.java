package org.example.bookingbe.service.BookingService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.example.bookingbe.model.Booking;
import org.example.bookingbe.repository.BookingRepo.IBookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements IBookingService {

    @Autowired
    private IBookingRepo bookingRepo;

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    @Override
    public Optional<Booking> getBookingById(Long id) {
        return bookingRepo.findById(id);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepo.deleteById(id);
    }

    @Override
    public List<Booking> findBookingsByDateRange(LocalDateTime start, LocalDateTime end) {
        return bookingRepo.findBookingsByDateRange(start, end);
    }
}
