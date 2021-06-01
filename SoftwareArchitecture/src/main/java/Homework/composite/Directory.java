package Homework.composite;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
 
public class Directory extends Entry { 
    private final String name;
    private final List<Entry> entries;
    public Directory(String name, JTextArea area) {
        this.name = name;
        this.area = area;
        entries = new ArrayList<>();
    } 
    public String getName() {
        return name; 
    } 
    public int getSize() {
        int size = 0;
        for (Entry directory : entries){
            size += directory.getSize();
        }
        return size; 
    }

    public Directory insideSubDirectory(String dir){
        for (Entry entry : entries){
            if(entry instanceof Directory && dir.equals(entry.getName())){
                return (Directory) entry;
            }
        }
        return null;
    }
    
    public Entry add(Entry entry) {
        entries.add(entry); 
        return this; 
    } 
    protected void printList(String prefix) {
        if (name == null){
            return;
        }
        area.append(prefix + "/" + this);
        for (Entry entry : entries){
            entry.printList(prefix + "/" + name);
        }
    } 
} 


