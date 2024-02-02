package com.erpproject.sixbeam.pd.controller;

import com.erpproject.sixbeam.pd.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/pd/Order")
@Controller
@Slf4j
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
}
