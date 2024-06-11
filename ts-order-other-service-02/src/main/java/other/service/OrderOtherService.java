package other.service;


import edu.fudan.common.entity.Seat;
import edu.fudan.common.util.Response;
import org.springframework.http.HttpHeaders;
import other.entity.Order;
import other.entity.OrderAlterInfo;
import other.entity.QueryInfo;

import java.util.Date;

/**
 * @author fdse
 */
public interface OrderOtherService {

    Response getSoldTickets(Seat seatRequest, HttpHeaders headers);

    Response queryOrders(QueryInfo qi, String accountId, HttpHeaders headers);

    Response queryOrdersForRefresh(QueryInfo qi, String accountId, HttpHeaders headers);


    Response queryAlreadySoldOrders(Date travelDate, String trainNumber, HttpHeaders headers);

    Response checkSecurityAboutOrder(Date checkDate, String accountId, HttpHeaders headers);

    void initOrder(Order order, HttpHeaders headers);
}
