package Homework.factory.card;

import Homework.factory.framework.Product;

public class CreditCard extends Product {
    private final String owner;
    public CreditCard(String owner){
        this.owner = owner;
        this.name = "信用卡";
        System.out.println("创建了" + this.owner + "的" + this.name);
    }
    public String getOwner(){
        return owner;
    }

    @Override
    public void use() {
        System.out.println("使用了" + this.owner + "的" + this.name);
    }
}
