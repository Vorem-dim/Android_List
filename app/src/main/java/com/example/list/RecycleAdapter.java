package com.example.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Field> fields;

    public RecycleAdapter(Context context, List<Field> fields) {
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
        Field book = fields.get(position);
        holder.image.setImageResource(book.getImage());
        holder.text.setText(book.getText());
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
