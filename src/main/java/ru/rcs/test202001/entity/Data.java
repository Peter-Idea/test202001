package ru.rcs.test202001.entity;


public class Data {
    private String row;
    private String col;
    private Long val;

    public Data(String row, String col, Long val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public Long getVal() {
        return val;
    }

    public void setVal(Long val) {
        this.val = val;
    }
}
