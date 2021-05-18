package Homework.prototype;

import java.util.ArrayList;
import java.util.List;

public class Clone implements Cloneable {
    private int value;
    private List<String> names;

    @Override
    public Clone clone() throws CloneNotSupportedException{
        super.clone();
        Clone clone = new Clone();
        clone.value = this.value;
        // 浅克隆 shallow clone
        clone.names = this.names;
        // 深克隆 deep clone
        clone.names = new ArrayList<>(this.names.size());
        clone.names.addAll(this.names);
        return clone;
    }

    public void addName(String str){
        if(names == null){
            names = new ArrayList<>();
        }
        names.add(str);
    }

    public void updateName(int index, String str){
        if ((index >= 0 && index < this.names.size())){
            names.set(index, str);
        }
    }

    public String getName(int index){
        if(index >= 0 && index < this.names.size()){
            return names.get(index);
        }
        return null;
    }
}
