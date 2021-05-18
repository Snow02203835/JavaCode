package Homework.factory.card;

import Homework.factory.framework.Product;

public class IDCard extends Product {
    private final String owner;
    public IDCard(String owner){
        this.owner = owner;
        this.name = "身份证";
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
