package store.observer;

import store.domain.Product;

public interface Observer {
    void update (Product product);
}
