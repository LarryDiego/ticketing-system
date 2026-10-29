package com.dev.larry.bookingservice.controller;

import com.dev.larry.bookingservice.request.BookingRequest;
import com.dev.larry.bookingservice.response.BookingResponse;
import com.dev.larry.bookingservice.service.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public BookingResponse createBooking(@RequestBody BookingRequest request) {
        return bookingService.createBooking(request);
    }
}
