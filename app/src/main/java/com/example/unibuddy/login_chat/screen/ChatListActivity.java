package com.example.login_chat.screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.login_chat.R;
import com.example.login_chat.adapter.listview.ChatListAdapter;

/**
 * 搜索框功能
 * 消息列表功能
 *      显示未读消息条数
 *      最新消息
 *      该消息时间
 *      该消息的联系人,头像
 */

public class ChatListActivity extends AppCompatActivity {

    private RecyclerView chat_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);
        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//实现状态栏图标和文字颜色为暗色
        initView();
    }

    private void initView(){
        chat_list = findViewById(R.id.chat_list);

        chat_list.setLayoutManager(new LinearLayoutManager(this));
        chat_list.setAdapter(new ChatListAdapter());
    }
}