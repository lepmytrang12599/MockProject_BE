package org.example.bookingbe.service.StatisticsService;

import org.example.bookingbe.repository.BookingRepo.IBookingRepo;
import java.util.*;
import java.time.LocalDate;

public class StatisticsService {
    private final IBookingRepo bookingRepo;

    public StatisticsService(IBookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    public Double getTotalRevenue(LocalDate startDate, LocalDate endDate) {
        return bookingRepo.getTotalRevenue(startDate, endDate);
    }

    public Long getTotalBookings(LocalDate startDate, LocalDate endDate) {
        return bookingRepo.getTotalBookings(startDate, endDate);
    }

    public List<Object[]> getPopularRooms() {
        return bookingRepo.getPopularRooms();
    }  
}
