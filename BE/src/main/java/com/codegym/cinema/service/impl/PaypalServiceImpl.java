package com.codegym.cinema.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.codegym.cinema.config.PaypalPaymentIntent;
import com.codegym.cinema.config.PaypalPaymentMethod;
import com.codegym.cinema.entity.MovieTicket;
import com.codegym.cinema.entity.Ticket;
import com.codegym.cinema.service.PaypalService;
import com.paypal.api.payments.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class PaypalServiceImpl implements PaypalService {
    @Autowired
    private APIContext apiContext;

    @Autowired
    JavaMailSender javaMailSender;
    @Override
    public Payment createPayment(
            Double total,
            String currency,
            PaypalPaymentMethod method,
            PaypalPaymentIntent intent,
            String description,
            String cancelUrl,
            String successUrl) throws PayPalRESTException{
        Amount amount = new Amount();
        amount.setCurrency(currency);
        amount.setTotal(String.valueOf(total));
        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setAmount(amount);
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);
        Payer payer = new Payer();
        payer.setPaymentMethod(method.toString());
        Payment payment = new Payment();
        payment.setIntent(intent.toString());
        payment.setPayer(payer);
        payment.setTransactions(transactions);
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(cancelUrl);
        redirectUrls.setReturnUrl(successUrl);
        payment.setRedirectUrls(redirectUrls);
        apiContext.setMaskRequestId(true);
        return payment.create(apiContext);
    }

    @Override
    public void sendMailPaymentSuccessful(MovieTicket movieTicket) throws MessagingException, UnsupportedEncodingException {
        List<Ticket> tickets = new ArrayList<>();
        tickets.addAll(movieTicket.getTicketSet());

        String subject = "Thông tin đặt vé xem phim tại A03Cinema";
        String mailContent = "";

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setTo(tickets.get(0).getUser().getEmail());
        helper.setFrom("leconghaufake4@gmail.com", "A03Cinema");
        helper.setSubject(subject);
        mailContent = "<p sytle='color:red;'>Xin chào " + tickets.get(0).getUser().getName() + " ,<p>" + "<p> Thông tin đặt vé của bạn:</p>" +
                "<p>Tên phim: "+movieTicket.getMovie().getMovieName() +"</p>" +
                "<p>Thời gian: "+movieTicket.getShowTime().getShowTime() + " Ngày: "+movieTicket.getShowDate() +"</p>" +
                "<p>Ghế: "+tickets.get(0).getSeat().getRow().getRowName()+""+tickets.get(0).getSeat().getColumn().getColumnName()+"</p>" +
                "<p>Gía tiền: "+movieTicket.getTicketPrice()+"</p>"
        ;
        helper.setText(mailContent, true);
        javaMailSender.send(message);
    }

    @Override
    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
        Payment payment = new Payment();
        payment.setId(paymentId);
        PaymentExecution paymentExecute = new PaymentExecution();
        paymentExecute.setPayerId(payerId);
        return payment.execute(apiContext, paymentExecute);
    }
}
