package com.example.list;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Menu_fragment extends Fragment {
    ArrayList<Field> field = new ArrayList<Field>();

    public Menu_fragment() {
        super(R.layout.fragment_menu_fragment);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        for (int i = 0; i < 200; i++)
            field.add(new Field(String.valueOf(i), R.mipmap.ic_launcher_round));

        RecyclerView list = view.findViewById(R.id.Recycler);

        RecycleAdapter.OnClickListener clickListener = new RecycleAdapter.OnClickListener() {
            @Override
            public void OnClick(Field field, int position) {
                Toast.makeText(getContext(), field.getText(), Toast.LENGTH_LONG).show();
                Log.i("TAG", field.getText());
            }
        };

        RecycleAdapter adapter = new RecycleAdapter(getContext(), field, clickListener);

        list.setAdapter(adapter);
    }
}