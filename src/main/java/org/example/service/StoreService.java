package org.example.service;

import org.example.component.Cart;
import org.example.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {
    private final Cart cart;
    private final StockroomService stockroomService;

    public StoreService(Cart cart, StockroomService stockroomService) {
        this.cart = cart;
        this.stockroomService = stockroomService;
    }

    public void add(List<Long> ids) {
        cart.add(ids);
    }

    public List<Item> get() {
        return cart.getIds().stream()
                .map(stockroomService::getById)
                .collect(Collectors.toList());
    }
}
