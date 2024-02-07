package com.example.demo.controller;

import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Ticket> getTicketById(@PathVariable Long id) {
        return ticketRepository.findById(id);
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @PutMapping("/{id}")
    public Ticket updateTicket(@PathVariable Long id, @RequestBody Ticket updatedTicket) {
        return ticketRepository.findById(id)
                .map(ticket -> {
                    // Update fields as needed
                    ticket.setTicketNumber(updatedTicket.getTicketNumber());
                    ticket.setMovieName(updatedTicket.getMovieName());
                    ticket.setCustomerName(updatedTicket.getCustomerName());
                    ticket.setSeatNumber(updatedTicket.getSeatNumber());
                    // Update more fields as needed
                    return ticketRepository.save(ticket);
                })
                .orElseGet(() -> {
                    updatedTicket.setId(id);
                    return ticketRepository.save(updatedTicket);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id) {
        ticketRepository.deleteById(id);
    }
}