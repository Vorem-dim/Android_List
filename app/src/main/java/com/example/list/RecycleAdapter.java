package com.example.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    interface OnClickListener {
        void OnClick(Field field, int position);
    }

    private final OnClickListener onClickListener;
    private final LayoutInflater inflater;
    private final List<Field> fields;

    public RecycleAdapter(Context context, List<Field> fields, OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.fields = fields;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycleAdapter.ViewHolder holder, int position) {
        Field field = fields.get(position);
        holder.image.setImageResource(field.getImage());
        holder.text.setText(field.getText());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.OnClick(field, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return fields.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView image;
        final TextView text;
        ViewHolder(View view){
            super(view);
            image = view.findViewById(R.id.images);
            text = view.findViewById(R.id.texts);
        }
    }
}
