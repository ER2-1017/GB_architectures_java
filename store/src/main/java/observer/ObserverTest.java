package store.observer;

import store.domain.Category;
import store.domain.Product;

public class ObserverTest {
    public static void main(String[] args) {

        NotificationImpl notificationImpl = new NotificationImpl();

        InterestedUser firstUser = new InterestedUser("firstUser");
        firstUser.addCategoryOfInterest(Category.berries);
        firstUser.addCategoryOfInterest(Category.dairy_products);
        notificationImpl.addObserver(firstUser);

        InterestedUser secondUser = new InterestedUser("secondUser");
        secondUser.addCategoryOfInterest(Category.meat);
        notificationImpl.addObserver(secondUser);

        InterestedUser thirdUser = new InterestedUser("thirdUser");
        thirdUser.addCategoryOfInterest(Category.berries);
        thirdUser.addCategoryOfInterest(Category.meat);
        notificationImpl.addObserver(thirdUser);

        notificationImpl.addProduct
                (new Product(99L, "Aubergine", 120.0, Category.berries));

        notificationImpl.addProduct
                (new Product(137L, "Apples", 89.0, Category.dairy_products));

        notificationImpl.addProduct
                (new Product(159L, "Sweets", 250.0, Category.meat));

    }
}
