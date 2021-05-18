package Homework.factory.card;

import Homework.factory.framework.Factory;
import Homework.factory.framework.Product;

import java.util.ArrayList;
import java.util.List;

public class IDCardFactory extends Factory {
    private List<String> owners;

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        if (owners == null){
            owners = new ArrayList<>();
        }
        owners.add(product.getName());
    }

    public List<String> getOwners(){
        return this.owners;
    }
}
