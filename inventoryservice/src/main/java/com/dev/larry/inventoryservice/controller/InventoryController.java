package com.dev.larry.inventoryservice.controller;

import com.dev.larry.inventoryservice.response.EventInventoryResponse;
import com.dev.larry.inventoryservice.response.VenueInventoryResponse;
import com.dev.larry.inventoryservice.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventories")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/events")
    public List<EventInventoryResponse> inventoryGetAllEvents() {
        return inventoryService.getAllEvents();
    }

    @GetMapping("/venues/{venueId}")
    public VenueInventoryResponse inventoryByVenueId(@PathVariable("venueId") Long venueId) {
        return inventoryService.getVenueInformation(venueId);
    }

    @GetMapping("/events/{eventId}")
    public EventInventoryResponse inventoryForEvent(@PathVariable Long eventId) {
        return inventoryService.getEventInventory(eventId);
    }
}
