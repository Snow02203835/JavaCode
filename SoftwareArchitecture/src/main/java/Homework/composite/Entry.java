package Homework.composite;

import javax.swing.*;

public abstract class Entry {
     public abstract String getName();
     public abstract int getSize();
     protected JTextArea area;

     public Entry add(Entry entry) throws FileTreatmentException {
         throw new FileTreatmentException();
     }
     public void printList() {
         printList("");
     }
     protected abstract void printList(String prefix);
     public String toString() {						// �ִ������ʽ
         return getName() + " (" + getSize() + ")\n";
     }
} 
