package com.codegym.cinema.repository;

import com.codegym.cinema.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {

    // NgaLT get all booked ticket
//    @Query(value = "select user.user_id, ticket.time_create, ticket.ticket_status, movie_ticket.ticket_price, movie.movie_name " +
//            "from user " +
//            "inner join ticket on user.user_id = ticket.user_id " +
//            "inner join movie_ticket on ticket.movie_ticket_id = movie_ticket.movie_ticket_id " +
//            "inner join movie on movie_ticket.movie_id = movie.movie_id", nativeQuery = true )
//    @Query(value = "select * from ticket where ticket.ticket_status in ("+"'Đã nhận vé'"+","+"'Đợi nhận vé'"+")", nativeQuery = true )
//    Page<Ticket> findAllBookedTicket(Pageable pageable);

    @Query(value = "select * from ticket where user_id=? and ticket.ticket_status_id in ("+"'1'"+","+"'2'"+") order by ticket.time_create ASC", nativeQuery = true )
    Page<Ticket> findAllBookedTicket(Pageable pageable,Integer userId);

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

    /**
     * author : NhungHTC
     * function : saveTicket()
     *
     * @param ticketId       : id of MovieTicket
     * @param seatId         : id of a Seat
     * @param userId         : id of a User
     * @param ticketStatusId : id of a TicketStatus
     * @param timeCreate     : create Ticket time
     */

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ticket(movie_ticket_id, seat_id, user_id, ticket_status_id,time_create) " +
            "VALUES (?1, ?2, ?3,'1',?4) ",
            nativeQuery = true)
    void saveTicket(Integer movieTicketId, Integer seatId, Integer userId, String timeCreate);

    //creatTicket()
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO ticket(ticket.movie_ticket_id, ticket.seat_id, ticket.user_id, ticket.time_create, ticket.ticket_status_id)\n" +
            "VALUE (?1,?2,?3,?4,?5)", nativeQuery = true)
    void createTicket(Integer movieTicketId, Integer seatId, Integer userId, String timeCreate, Integer ticketStatusId);

    //PhuocDD
    @Query(value = "select ticket.* from ticket \n" +
            "inner join movie_ticket on ticket.movie_ticket_id = movie_ticket.movie_ticket_id\n" +
            "inner join movie on movie_ticket.movie_id = movie.movie_id\n" +
            "inner join show_time on movie_ticket.show_time_id = show_time.show_time_id\n" +
            "inner join room on movie_ticket.room_id = room.room_id\n" +
            "inner join `user` on ticket.user_id = `user`.user_id\n" +
            "inner join seat on ticket.seat_id = seat.seat_id\n" +
            "inner join `row` on seat.row_id = `row`.row_id\n" +
            "inner join `column` on seat.column_id = `column`.column_id\n" +
            "where ticket.ticket_id = ?1", nativeQuery = true)
    Ticket findTicketByTicketId(Integer id);

}
