package Homework.decorator.example;

public class SideBorder extends Border {
    private final char borderChar;
    public SideBorder(Display display, char ch) {
        super(display);
        this.borderChar = ch;
    }
    public int getColumns() {                       // ����Ҫ�ټ��σ������ߵ�װ���ַ�
        return 1 + display.getColumns() + 1;
    }
    public int getRows() {                          // ����ͬ���ݵ�����
        return display.getRows();
    }
    public String getRowText(int row) {
        return borderChar + display.getRowText(row) + borderChar;
    }
}

