package com.codegym.cinema.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.codegym.cinema.config.PaypalPaymentIntent;
import com.codegym.cinema.config.PaypalPaymentMethod;
import com.codegym.cinema.dto.MovieTicketToSendMailDto;
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
    public void sendMailPaymentSuccessful(List<MovieTicketToSendMailDto> movieTicketToSendMailDto) throws MessagingException, UnsupportedEncodingException {

        String subject = "Thông tin đặt vé xem phim tại A03Cinema";
        String mailContent = "";

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setTo(movieTicketToSendMailDto.get(0).getEmail());
        helper.setFrom("leconghaufake4@gmail.com", "A03Cinema");
        helper.setSubject(subject);
        mailContent = "<p sytle='color:red;'>Xin chào " + movieTicketToSendMailDto.get(0).getUsername() + " ,<p>" + "<p> Thông tin đặt vé của bạn:</p>";
        for(int i=0;i<movieTicketToSendMailDto.size(); i++){
            mailContent += "<b>Mã vé: "+movieTicketToSendMailDto.get(i).getTicketId() +"</b>" +

                    "<div style=\"top: 0px;width: 100%;background-color: #f1f1f1;padding: 10px;margin-bottom: 15px;\">" +
                    "<section style=\"clear: both;min-height: 0;box-sizing: border-box;margin: 0;width: 100%;display: inline-block;\">" +
                    "<div class=\"row\">" +
                    "<div class=\"col-12\" style=\"text-align: center\">" +
                    "<img src="+ movieTicketToSendMailDto.get(i).getPosterMovie()+">" +
                    "</div>" +
                    "<div class=\"col-12\">" +
                    "<div class=\"ticket-detail\">" +
                    "<h2 class=\"ticket-title\" style=\"text-transform: uppercase!important;\">" + movieTicketToSendMailDto.get(i).getMovieName() + "</h2>" +
                    "<div class=\"ticket-info\">" +
                    "<p>" +
                    "<b>Rạp: &nbsp;</b>" +
                    "A032I1&nbsp; | PHÒNG CHIẾU: " + movieTicketToSendMailDto.get(i).getRoomName() + "&nbsp;" +
                    "</p>" +
                    "<p>" +
                    "<b>Suất chiếu: &nbsp;</b>" +
                    movieTicketToSendMailDto.get(i).getShowTime() + " | "+movieTicketToSendMailDto.get(i).getShowDate()  +
                    "</p>" +
                    "<p>" +
                    "<b>Loại chiếu:  &nbsp;</b>" +
                    movieTicketToSendMailDto.get(i).getProjectionName() +
                    "</p>" +
                    "<p>" +
                    "<b>Ghế:  &nbsp;</b>" +
                    movieTicketToSendMailDto.get(i).getSeatRow()+""+movieTicketToSendMailDto.get(i).getSeatColumn() +
                    "</p>" +
                    "</div>" +
                    "<div>" +
                    "<p>" +
                    "<b style=\"size: 30px\">Tổng: &nbsp;</b>" +
                    "<span style=\"size: 30px; color: red\">" + movieTicketToSendMailDto.get(i).getTicketPrice() +
                    "</p>" +
                    "</div>" +
                    "</div>" +
                    "</div>" +
                    "</div>" +
                    "</section>" +
                    "</div>"
            ;
        }

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
