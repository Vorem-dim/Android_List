package com.example.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class MyListAdapter extends ArrayAdapter<Field> {
    private final LayoutInflater inflater;
    private final List<Field> fields;
    private int layout;

    public MyListAdapter(Context context, int resource, List<Field> fields) {
        super(context, resource, fields);
        this.fields = fields;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);

        ImageView image = view.findViewById(R.id.images);
        TextView text = view.findViewById(R.id.texts);

        Field field = fields.get(position);

        image.setImageResource(field.getImage());
        text.setText(field.getText());

        return view;
    }
}
