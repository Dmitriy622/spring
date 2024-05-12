package org.example.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@SessionScope
public class Cart {
    private final List<Long> ids = new ArrayList<>();

    public void add(List<Long> ids) {
        this.ids.addAll(ids);
    }

    public List<Long> getIds() {
        return Collections.unmodifiableList(ids);
    }


}
