package order.controller;


import edu.fudan.common.entity.Seat;
import edu.fudan.common.util.StringUtils;
import order.entity.Order;
import order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

/**
 * @author fdse
 */
@RestController
@RequestMapping("/api/v1/orderservice02")
public class OrderController {

    @Autowired
    private OrderService orderService;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @GetMapping(path = "/welcome")
    public String home() {
        return "Welcome to [ Order Service ] !";
    }

    /***************************For Normal Use***************************/

    @PostMapping(value = "/order/tickets")
    public HttpEntity getTicketListByDateAndTripId(@RequestBody Seat seatRequest, @RequestHeader HttpHeaders headers) {
        OrderController.LOGGER.info("[getSoldTickets][Get Sold Ticket][Travel Date: {}]", seatRequest.getTravelDate().toString());
        return ok(orderService.getSoldTickets(seatRequest, headers));
    }


    @CrossOrigin(origins = "*")
    @GetMapping(path = "/order/{orderId}")
    public HttpEntity getOrderById(@PathVariable String orderId, @RequestHeader HttpHeaders headers) {
        OrderController.LOGGER.info("[getOrderById][Get Order By Id][OrderId: {}]", orderId);
        // Order
        return ok(orderService.getOrderById(orderId, headers));
    }


    @CrossOrigin(origins = "*")
    @GetMapping(path = "/order/security/{checkDate}/{accountId}")
    public HttpEntity securityInfoCheck(@PathVariable String checkDate, @PathVariable String accountId,
                                        @RequestHeader HttpHeaders headers) {
        OrderController.LOGGER.info("[checkSecurityAboutOrder][Security Info Get][AccountId:{}]", accountId);
        return ok(orderService.checkSecurityAboutOrder(StringUtils.String2Date(checkDate), accountId, headers));
    }



    @CrossOrigin(origins = "*")
    @PutMapping(path = "/order/admin")
    public HttpEntity updateOrder(@RequestBody Order order, @RequestHeader HttpHeaders headers) {
        // Order
        OrderController.LOGGER.info("[updateOrder][Update Order][OrderId: {}]", order.getId());
        return ok(orderService.updateOrder(order, headers));
    }


    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "/order/{orderId}")
    public HttpEntity deleteOrder(@PathVariable String orderId, @RequestHeader HttpHeaders headers) {
        OrderController.LOGGER.info("[deleteOrder][Delete Order][OrderId: {}]", orderId);
        // Order
        return ok(orderService.deleteOrder(orderId, headers));
    }


}
