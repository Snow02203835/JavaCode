package Homework.builder;

public class Director {
    private Builder builder;
    public void setBuilder(Builder builder){
        this.builder = builder;
    }
    public Object construct(){
        builder.makeTitle("Greeting");
        builder.makeString("从早上到白天结束");
        builder.makeItems(new String[]{
                "早安!",
                "午安!"
        });
        builder.makeString("到了晚上");
        builder.makeItems(new String[]{
                "晚安!",
                "祝你有个好梦!",
                "再见!"
        });
        return builder.getResult();
    }
}
