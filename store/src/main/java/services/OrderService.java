package store.services;

import store.domain.Order;
import store.domain.OrderPosition;
import store.domain.User;
import store.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrderFromPositions(User user, List<OrderPosition> positions) {
        Order order = new Order();
        order.setPositions( new ArrayList<>());
        order.setUser(user);
        positions.stream().forEach(item -> {
            order.getPositions().add(item);
            item.setOrder(order);
        });
        positions.clear();
        return orderRepository.save(order);
    }
}
