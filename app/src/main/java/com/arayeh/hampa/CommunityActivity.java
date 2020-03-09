package com.arayeh.hampa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import com.arayeh.hampa.adapters.CommunityListAdapter;
import com.arayeh.hampa.adapters.MessageAdapter;
import com.arayeh.hampa.models.Message;

import java.util.ArrayList;
import java.util.List;

public class CommunityActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MessageAdapter messageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);
        recyclerView = findViewById(R.id.rcv_message);
        layoutManager= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        List<Message> messages=new ArrayList<>();
        messages.add(new Message("سلام، حالتون خوله بچه ها؟"));
        messages.add(new Message("من امروز نیستم"));
        messages.add(new Message("نمی دونم کجا رفته؟"));
        messages.add(new Message("چی شده"));
        messages.add(new Message("یکم دیر لود شد"));
        messageAdapter =new MessageAdapter(messages);
        recyclerView.setAdapter(messageAdapter);

    }
}
