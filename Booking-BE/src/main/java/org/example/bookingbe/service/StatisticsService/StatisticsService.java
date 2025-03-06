package org.example.bookingbe.service.StatisticsService;

import org.example.bookingbe.dto.RevenueStatsDTO;
import org.example.bookingbe.repository.BookingRepo.IBookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
public class StatisticsService {

    @Autowired
    private IBookingRepo bookingRepo;

    public RevenueStatsDTO getRevenueStats(String period) {
        LocalDate startDate, endDate = LocalDate.now();
        
        switch (period) {
            case "quarter":
                startDate = getQuarterStartDate(endDate);
                break;
            case "year":
                startDate = endDate.with(TemporalAdjusters.firstDayOfYear());
                break;
            default:
                startDate = endDate.with(TemporalAdjusters.firstDayOfMonth());
        }

        Double totalRevenue = bookingRepo.getTotalRevenue(startDate, endDate);
        Long totalBookings = bookingRepo.getTotalBookings(startDate, endDate);

        // Kiểm tra giá trị null
        totalRevenue = (totalRevenue != null) ? totalRevenue : 0.0;
        totalBookings = (totalBookings != null) ? totalBookings : 0L;

        // Lấy phòng phổ biến
        List<Object[]> popularRooms = bookingRepo.getPopularRooms();
        String popularRoom = (popularRooms != null && !popularRooms.isEmpty() && popularRooms.get(0).length > 0)
                ? popularRooms.get(0)[0].toString()
                : "N/A";

        return new RevenueStatsDTO(totalRevenue, totalBookings, popularRoom);
    }

    private LocalDate getQuarterStartDate(LocalDate date) {
        int currentMonth = date.getMonthValue();
        Month startMonth;

        if (currentMonth <= 3) {
            startMonth = Month.JANUARY;
        } else if (currentMonth <= 6) {
            startMonth = Month.APRIL;
        } else if (currentMonth <= 9) {
            startMonth = Month.JULY;
        } else {
            startMonth = Month.OCTOBER;
        }

        return LocalDate.of(date.getYear(), startMonth, 1);
    }
}
