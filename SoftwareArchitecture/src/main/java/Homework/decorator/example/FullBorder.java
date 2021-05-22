package Homework.decorator.example;

public class FullBorder extends Border {
    public FullBorder(Display display) {
        super(display);
    }
    public int getColumns() {                   // �����������������������ߵ�װ���ַ�
        return 1 + display.getColumns() + 1;
    }
    public int getRows() {                      // �������������������µ�װ���ַ�
        return 1 + display.getRows() + 1;
    }
    public String getRowText(int row) {
        if (row == 0) {
            return "+" + makeLine(display.getColumns()) + "+";
        } else if (row == display.getRows() + 1) {
            return "+" + makeLine(display.getColumns()) + "+";
        } else {
            return "|" + display.getRowText(row - 1) + "|";
        }
    }
    private String makeLine(int count) {
        return String.valueOf('-').repeat(Math.max(0, count));
    }
}

