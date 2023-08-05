package com.example.demo.listener;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order_Detail;
import com.example.demo.repository.OrderRepository;

import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Service
class ContextWrapper {

    @Setter
    @Getter
    private static ApplicationContext context;

    @Autowired
    public ContextWrapper(ApplicationContext ac) {
        setContext(ac);
    }

}

@Component
public class MyEntityListener {
    // @Autowired
    // public OrderRepository orderRepository;

    // @Autowired
    // public void init(@Lazy OrderRepository service) {
    // this.orderRepository = service;
    // }

    @PrePersist
    public void onPrePersist(Order_Detail order) {
        // Do something before the entity is persisted.
        // int id = getRepo().findAll().stream().sorted().findFirst().get().getId();
        // int id = order.getOrder().getId();
        System.out.println(">>>>>>>>id:");

    }
    // private OrderRepository getRepo(){
    // return
    // ContextWrapper.getContext().getBean("OrđeRepository",OrderRepository.class);
    // }
}
