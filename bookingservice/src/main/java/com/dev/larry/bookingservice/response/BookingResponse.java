package com.dev.larry.bookingservice.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {

    private Long bookingId;
    private Long userId;
    private Long eventId;
    private Long ticketCount;
    private Long ticketPrice;
}
