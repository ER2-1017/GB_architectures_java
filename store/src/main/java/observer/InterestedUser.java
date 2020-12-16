package tore.observer;

import store.domain.Category;
import store.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class InterestedUser implements Observer{

    private String name;

    private List<Category> categoryOfInterest = new ArrayList<Category>();

    public InterestedUser(String name) {
        this.name = name;
    }

    @Override
    public void update(Product product) {
        for (Category c : categoryOfInterest){
            if (product.getCategory().equals(c)){
                System.out.println
                        ("Notification for user " + name +
                                " : store has received a new product in category(ies) "
                                + product.getCategory());
                System.out.println("_______________");
            }
        }
    }

    public void addCategoryOfInterest(Category category){
        categoryOfInterest.add(category);
    }
}
