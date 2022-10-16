package com.example.login_chat.fragment.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.login_chat.R;
import com.example.login_chat.adapter.listview.ChatListAdapter;


public class ChatFragment extends Fragment {

    private RecyclerView chat_list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_caht, container, false);
        initView(view);
        return view;
    }

    private void initView(View view){

        requireActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        requireActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//实现状态栏图标和文字颜色为暗色

        chat_list = view.findViewById(R.id.chat_list);

        chat_list.setLayoutManager(new LinearLayoutManager(requireContext()));
        chat_list.setAdapter(new ChatListAdapter());
    }
}