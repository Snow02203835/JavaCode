package Homework.factory.phone;

public class Huawei implements Factory {
    @Override
    public Product create(String series) {
        return new Phone("华为", series);
    }
}
