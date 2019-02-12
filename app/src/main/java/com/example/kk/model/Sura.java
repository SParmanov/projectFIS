package com.example.kk.model;

public class Sura {

    public static final byte FROM_MEDINA = 0;
    public static final byte FROM_MEKKE = 1;

    private String content;
    private String title;
    private int number;
    private byte type; //Where Medina or Mekka

    public Sura(String content, String title, Integer number, byte type) {
        this.content = content;
        this.title = title;
        this.number = number;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public Integer getNumber() {
        return number;
    }

    public byte getType() {
        return type;
    }
}
