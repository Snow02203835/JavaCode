package Homework.decorator.example;

public class StringDisplay extends Display {
    private final String string;
    public StringDisplay(String string) {
        this.string = string;
    }
    public int getColumns() {                       // ����
        return string.getBytes().length;
    }
    public int getRows() {
        return 1;
    }
    public String getRowText(int row) {
        if (row == 0) {
            return string;
        } else {
            return null;
        }
    }
}

