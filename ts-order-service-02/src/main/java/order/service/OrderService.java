package order.service;

import edu.fudan.common.entity.Seat;
import edu.fudan.common.util.Response;
import order.entity.Order;
import order.entity.OrderAlterInfo;
import order.entity.OrderInfo;
import org.springframework.http.HttpHeaders;

import java.util.Date;

/**
 * @author fdse
 */
public interface OrderService {

    ;

    Response getOrderById(String orderId , HttpHeaders headers);

    Response checkSecurityAboutOrder(Date checkDate, String accountId, HttpHeaders headers);

    void initOrder(Order order, HttpHeaders headers);

    Response deleteOrder(String orderId, HttpHeaders headers);

    Response getSoldTickets(Seat seatRequest, HttpHeaders headers);

    Response addNewOrder(Order order, HttpHeaders headers);

    Response updateOrder(Order order, HttpHeaders headers);
}
