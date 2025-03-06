package org.example.bookingbe.dto;

public class RevenueStatsDTO {
    private Double totalRevenue;
    private Long totalBookings;
    private String popularRoom;

    // Constructor
    public RevenueStatsDTO(Double totalRevenue, Long totalBookings, String popularRoom) {
        this.totalRevenue = totalRevenue;
        this.totalBookings = totalBookings;
        this.popularRoom = popularRoom;
    }

    // Getters & Setters
    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public Long getTotalBookings() {
        return totalBookings;
    }

    public void setTotalBookings(Long totalBookings) {
        this.totalBookings = totalBookings;
    }

    public String getPopularRoom() {
        return popularRoom;
    }

    public void setPopularRoom(String popularRoom) {
        this.popularRoom = popularRoom;
    }
}
