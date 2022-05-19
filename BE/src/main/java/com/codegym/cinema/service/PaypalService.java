package com.codegym.cinema.service;

import com.codegym.cinema.config.PaypalPaymentIntent;
import com.codegym.cinema.config.PaypalPaymentMethod;
import com.codegym.cinema.dto.MovieTicketToSendMailDto;
import com.codegym.cinema.entity.MovieTicket;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface PaypalService {
    Payment executePayment(String paymentId, String payerId) throws PayPalRESTException;
    Payment createPayment(
            Double total,
            String currency,
            PaypalPaymentMethod method,
            PaypalPaymentIntent intent,
            String description,
            String cancelUrl,
            String successUrl) throws PayPalRESTException;
    void sendMailPaymentSuccessful(List<MovieTicketToSendMailDto> movieTicketToSendMailDto) throws MessagingException, UnsupportedEncodingException;
}
