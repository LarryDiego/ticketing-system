package com.dev.larry.bookingservice.service;

import com.dev.larry.bookingservice.client.InventoryServiceClient;
import com.dev.larry.bookingservice.entity.Customer;
import com.dev.larry.bookingservice.repository.CustomerRepository;
import com.dev.larry.bookingservice.request.BookingRequest;
import com.dev.larry.bookingservice.response.BookingResponse;
import com.dev.larry.bookingservice.response.InventoryResponse;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final CustomerRepository customerRepository;
    private final InventoryServiceClient inventoryServiceClient;

    public BookingService(CustomerRepository customerRepository, InventoryServiceClient inventoryServiceClient) {
        this.customerRepository = customerRepository;
        this.inventoryServiceClient = inventoryServiceClient;
    }

    public BookingResponse createBooking(BookingRequest request) {
        final Customer customer = customerRepository.findById(request.getUserId()).orElse(null);

        if (customer == null) {
            throw new RuntimeException("User not found");
        }

        final InventoryResponse inventoryResponse = inventoryServiceClient.getInventory(request.getEventId());

        if (inventoryResponse.getCapacity() < request.getTicketCount()) {
            throw new RuntimeException("Not enough invenotry");
        }

        return BookingResponse.builder().build();
    }
}
