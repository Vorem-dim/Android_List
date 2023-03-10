package com.example.list;

import android.widget.ImageView;
import android.widget.TextView;

public class Field {
    private int image;
    private String text;

    public Field(String text, int image) {
        this.image = image;
        this.text = text;
    }

    public int getImage() {
        return this.image;
    }

    public String getText() {
        return this.text;
    }
}
