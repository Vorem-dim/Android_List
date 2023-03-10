package com.example.list;

import android.database.DataSetObserver;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Basket_fragment extends Fragment {
    ArrayList<Field> field = new ArrayList<>();
    ListView list;

    public Basket_fragment() {
        super(R.layout.fragment_basket_fragment);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_basket_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        for (int i = 0; i < 200; i++)
            field.add(new Field(String.valueOf(i), R.mipmap.ic_launcher_round));

        list = view.findViewById(R.id.List);

        MyListAdapter adapter = new MyListAdapter(getContext(), R.layout.list_item, field);

        list.setAdapter(adapter);

        AdapterView.OnItemClickListener ItemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Field select = (Field) parent.getItemAtPosition(position);
                Toast.makeText(getContext(), select.getText(), Toast.LENGTH_LONG).show();
                Log.i("TAG", select.getText());
            }
        };
        list.setOnItemClickListener(ItemListener);
    }
}