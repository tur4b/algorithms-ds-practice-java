package com.problem.tree.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Room implements Comparable<Room> {

    private int number;

    private BigDecimal length;
    private BigDecimal width;
    private Room enteredFrom;

    private byte windowCount;

    
    public Room(int number, BigDecimal length, BigDecimal width, byte windowCount) {
        this(number, length, width, null, windowCount);
    }

    public Room(int number, BigDecimal length, BigDecimal width, Room enteredFrom, byte windowCount) {
        this.number = number;
        this.length = length;
        this.width = width;
        this.enteredFrom = enteredFrom;
        this.windowCount = windowCount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public Room getEnteredFrom() {
        return enteredFrom;
    }

    public void setEnteredFrom(Room enteredFrom) {
        this.enteredFrom = enteredFrom;
    }

    public byte getWindowCount() {
        return windowCount;
    }

    public void setWindowCount(byte windowCount) {
        this.windowCount = windowCount;
    }

    public BigDecimal area() {
        return width.multiply(length).setScale(2, RoundingMode.CEILING);
    }

    @Override
    public int compareTo(Room o) {
        if(this.number == o.number) {
           return this.area().compareTo(o.area());
        }
        else if(this.number > o.number) {
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Room [number=" + number + ", area=" + area() + "m2" + "]";
    }

    
    
}
