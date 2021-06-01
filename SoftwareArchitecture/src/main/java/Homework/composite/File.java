package Homework.composite;

import javax.swing.*;

public class File extends Entry {
    private final String name;
    private final int size;
    public File(String name, int size, JTextArea area) {
        this.name = name;
        this.size = size;
        this.area = area;
    }
    public String getName() {
        return name;
    }
    public int getSize() {
        return size;
    }
    protected void printList(String prefix) {
        area.append(prefix + "/" + this);
    }
}
