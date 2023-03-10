package com.example.list;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Profile_fragment extends Fragment {

    public Profile_fragment() {
        super(R.layout.fragment_profile_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView text =  view.findViewById(R.id.Name_LogIn);
        String str = getResources().getString(R.string.app_name);
        text.setText(str);

        ImageView image = (ImageView) view.findViewById(R.id.Pizza_LogIn);
        Drawable draw = getResources().getDrawable(R.drawable.pizza_main_screen);
        image.setImageDrawable(draw);

        image = (ImageView) view.findViewById(R.id.Sushi_LogIn);
        draw = getResources().getDrawable(R.drawable.sushi_main_screen);
        image.setImageDrawable(draw);

        Button button = (Button) getView().findViewById(R.id.Profile_button);
        button.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view, Main_fragment.class, null).commit();
        });
    }
}