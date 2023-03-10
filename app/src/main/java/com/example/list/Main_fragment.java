package com.example.list;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main_fragment extends Fragment {

    private final static String TAG = "ContentFragment";
    private Context context;
    public Main_fragment() {
        super(R.layout.fragment_main_fragment);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView text = (TextView) view.findViewById(R.id.Name_cafe);
        String str = getResources().getString(R.string.app_name);
        text.setText(str);

        ImageView image = (ImageView) view.findViewById(R.id.Pizza_main);
        Drawable draw = getResources().getDrawable(R.drawable.pizza_main_screen);
        image.setImageDrawable(draw);

        image = (ImageView) view.findViewById(R.id.Sushi_main);
        draw = getResources().getDrawable(R.drawable.sushi_main_screen);
        image.setImageDrawable(draw);

        Button button1 = view.findViewById(R.id.Profile);
        button1.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view, Profile_fragment.class, null).commit();
        });

        Button button2 = view.findViewById(R.id.Menu);
        button2.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view, Menu_fragment.class, null).commit();
        });

        Button button3 = view.findViewById(R.id.Basket);
        button3.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view, Basket_fragment.class, null).commit();
        });
    }
}