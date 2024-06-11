package other.controller;

import edu.fudan.common.entity.Seat;
import edu.fudan.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import other.entity.Order;
import other.entity.QueryInfo;
import other.service.OrderOtherService;

import static org.springframework.http.ResponseEntity.ok;

/**
 * @author fdse
 */
@RestController
@RequestMapping("/api/v1/orderOtherService02")
public class OrderOtherController {

    @Autowired
    private OrderOtherService orderService;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderOtherController.class);

    @GetMapping(path = "/welcome")
    public String home() {
        return "Welcome to [ Order Other Service ] !";
    }

    /***************************For Normal Use***************************/

    @PostMapping(value = "/orderOther/tickets")
    public HttpEntity getTicketListByDateAndTripId(@RequestBody Seat seatRequest, @RequestHeader HttpHeaders headers) {
        OrderOtherController.LOGGER.info("[getSoldTickets][Get Sold Ticket][Travel Date: {}]", seatRequest.getTravelDate().toString());
        return ok(orderService.getSoldTickets(seatRequest, headers));
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/orderOther/query")
    public HttpEntity queryOrders(@RequestBody QueryInfo qi,
                                  @RequestHeader HttpHeaders headers) {
        OrderOtherController.LOGGER.info("[queryOrders][Query Orders][for LoginId :{}]", qi.getLoginId());
        return ok(orderService.queryOrders(qi, qi.getLoginId(), headers));

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/orderOther/refresh")
    public HttpEntity queryOrdersForRefresh(@RequestBody QueryInfo qi,
                                            @RequestHeader HttpHeaders headers) {
        OrderOtherController.LOGGER.info("[queryOrdersForRefresh][Query Orders][for LoginId:{}]", qi.getLoginId());
        return ok(orderService.queryOrdersForRefresh(qi, qi.getLoginId(), headers));
    }


    @CrossOrigin(origins = "*")
    @GetMapping(path = "/orderOther/{travelDate}/{trainNumber}")
    public HttpEntity calculateSoldTicket(@PathVariable String travelDate, @PathVariable String trainNumber,
                                          @RequestHeader HttpHeaders headers) {
        OrderOtherController.LOGGER.info("[queryAlreadySoldOrders][Calculate Sold Tickets][Date: {} TrainNumber: {}]", travelDate, trainNumber);
        return ok(orderService.queryAlreadySoldOrders(StringUtils.String2Date(travelDate), trainNumber, headers));
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/orderOther/security/{checkDate}/{accountId}")
    public HttpEntity securityInfoCheck(@PathVariable String checkDate, @PathVariable String accountId,
                                        @RequestHeader HttpHeaders headers) {
        OrderOtherController.LOGGER.info("[checkSecurityAboutOrder][Security Info Get][CheckDate:{} , AccountId:{}]",checkDate,accountId);
        return ok(orderService.checkSecurityAboutOrder(StringUtils.String2Date(checkDate), accountId, headers));
    }


}
