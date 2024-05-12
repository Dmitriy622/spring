package org.example.service;

import jakarta.annotation.PostConstruct;
import org.example.model.Item;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StockroomService {
    private final Map<Long, Item> stockroom = new HashMap<>();

    public Item getById(long id) {
        return stockroom.get(id);
    }

    @PostConstruct
    public void postConstruct() {
        List<String> items = List.of("Ноутбук", "Мышь", "Смарт-часы", "Смартфон");
        for (int i = 0; i < items.size(); i++) {
            long id = i + 1;
            Item item = new Item(id, items.get(i));
            stockroom.put(id, item);
        }
    }
}
