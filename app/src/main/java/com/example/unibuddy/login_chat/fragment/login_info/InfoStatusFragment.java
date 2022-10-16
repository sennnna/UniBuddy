package com.example.login_chat.fragment.login_info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.login_chat.R;

public class InfoStatusFragment extends Fragment {


    private ImageView male_image,female_image;
    private ImageView dating_image,single_image,unknown_image;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_status,container,false);
        initView(view);
        return view;
    }

    private void initView(View view){
        male_image = view.findViewById(R.id.male_image);
        female_image = view.findViewById(R.id.female_image);
        dating_image = view.findViewById(R.id.dating_image);
        single_image = view.findViewById(R.id.single_image);
        unknown_image = view.findViewById(R.id.unknown_image);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        female_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                female_image.setImageResource(R.drawable.fmale_select);
                male_image.setImageResource(R.drawable.male);
            }
        });
        male_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male_image.setImageResource(R.drawable.male_select);
                female_image.setImageResource(R.drawable.fmale);
            }
        });

        dating_image.setOnClickListener(v -> {
            dating_image.setImageResource(R.drawable.dating_select);
            unknown_image.setImageResource(R.drawable.ic_unknown);
            single_image.setImageResource(R.drawable.single);
        });

        single_image.setOnClickListener(v -> {
            single_image.setImageResource(R.drawable.single_select);
            unknown_image.setImageResource(R.drawable.ic_unknown);
            dating_image.setImageResource(R.drawable.dating);
        });

        unknown_image.setOnClickListener(v -> {
            unknown_image.setImageResource(R.drawable.ic_unknown_select);
            dating_image.setImageResource(R.drawable.dating);
            single_image.setImageResource(R.drawable.single);
        });
    }
}
