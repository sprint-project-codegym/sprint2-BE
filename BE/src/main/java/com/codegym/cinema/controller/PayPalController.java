package com.codegym.cinema.controller;

import com.codegym.cinema.config.PaypalPaymentIntent;
import com.codegym.cinema.config.PaypalPaymentMethod;
import com.codegym.cinema.dto.LinkDTO;
import com.codegym.cinema.dto.PaypalDTO;
import com.codegym.cinema.entity.MovieTicket;
import com.codegym.cinema.payload.response.MessageResponse;
import com.codegym.cinema.service.PaypalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import java.io.UnsupportedEncodingException;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping("/api/payment")
public class PayPalController {
    public static final String URL_PAYPAL_SUCCESS = "pay/success";
    public static final String URL_PAYPAL_CANCEL = "pay/cancel";
    private Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private PaypalService paypalService;

    @PostMapping("/pay")
    public ResponseEntity<LinkDTO> pay(@RequestBody PaypalDTO paypalDTO, HttpServletRequest request ){
        String cancelUrl = "http://localhost:4200";
        String successUrl = "http://localhost:4200";

        try {
            System.err.println("PRICE : " + paypalDTO.getPrice()); //test
            Payment payment = paypalService.createPayment(
                    Math.round(paypalDTO.getPrice()/23000 * 100.0) / 100.0,
                    "USD",
                    PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale,
                    "payment description",
                    cancelUrl,
                    successUrl);
            for(Links links : payment.getLinks()){
                if(links.getRel().equals("approval_url")){
                    System.err.println(payment.getLinks());
                    LinkDTO linkDTO = new LinkDTO(links.getHref());

                    return new ResponseEntity<>(linkDTO, HttpStatus.OK) ;
                }
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping(URL_PAYPAL_CANCEL)
    public String cancelPay(){
        return "http://localhost:4200";
    }
    @GetMapping(URL_PAYPAL_SUCCESS)
    public ResponseEntity<Void> successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){
        try {
            System.err.println("SUCCESS");
            Payment payment = paypalService.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                System.out.println("successful");
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/successful")
    public ResponseEntity<?> sendMailSuccessful(@RequestBody MovieTicket movieTicket) throws MessagingException, UnsupportedEncodingException {
        paypalService.sendMailPaymentSuccessful(movieTicket);

        return ResponseEntity.ok(new MessageResponse("Đã gửi thông tin vé về email"));
    }
}
