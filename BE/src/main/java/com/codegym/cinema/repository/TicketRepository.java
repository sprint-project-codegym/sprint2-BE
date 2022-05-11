package com.codegym.cinema.repository;

import com.codegym.cinema.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    @Query(value = "SELECT * " +
            "FROM ticket WHERE ticket.ticket_status_id = 1 GROUP BY ticket_id limit ?1, 5", nativeQuery = true)
    List<Ticket> findAllByBookedTicket(int index);

    @Query(value = "SELECT * " +
            "FROM ticket WHERE ticket.ticket_status_id = 1 GROUP BY ticket_id", nativeQuery = true)
    List<Ticket> findAllByBookedTicketNoPage();

    @Query(value = "SELECT * " +
            "FROM ticket WHERE ticket_status_id = 1 AND ticket_id = ?1", nativeQuery = true)
    Page<Ticket> searchByTicketId(Integer ticketId, Pageable pageable);

    @Query(value = "SELECT * " +
            "FROM ticket WHERE ticket_status_id = 1 AND user_id = ?1", nativeQuery = true)
    Page<Ticket> searchByUserId(Integer userId, Pageable pageable);

    @Query(value = "SELECT * " +
            "FROM ticket " +
            "INNER JOIN `user` ON `user`.user_id = ticket.user_id " +
            "WHERE ticket_status_id = 1 AND `user`.id_card LIKE concat('%',?1,'%')", nativeQuery = true)
    Page<Ticket> searchByIdCard(String idCard, Pageable pageable);

    @Query(value = "SELECT * " +
            "FROM ticket " +
            "INNER JOIN `user` ON `user`.user_id = ticket.user_id " +
            "WHERE ticket_status_id = 1 AND `user`.phone LIKE concat('%',?1,'%')", nativeQuery = true)
    Page<Ticket> searchByPhone(String phone, Pageable pageable);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "UPDATE ticket " +
            "SET ticket.ticket_status_id = 2 " +
            "WHERE ticket.ticket_id = ?1", nativeQuery = true)
    void receiveBookedTicket(Integer ticketId);
}
