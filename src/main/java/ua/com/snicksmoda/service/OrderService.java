package ua.com.snicksmoda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.snicksmoda.entity.Orders;
import ua.com.snicksmoda.repository.OrdersRepository;

@Service
public class OrderService {

    @Autowired
    OrdersRepository ordersRepository;

    @Transactional
    public Long addOrder(Orders orders) {
        ordersRepository.save(orders);
        return orders.getIdOrders();
    }
}
