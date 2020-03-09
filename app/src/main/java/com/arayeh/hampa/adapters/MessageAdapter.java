package com.arayeh.hampa.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arayeh.hampa.R;
import com.arayeh.hampa.interfaces.SelectItemClick;
import com.arayeh.hampa.models.Community;
import com.arayeh.hampa.models.Message;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder> {
    private List<Message> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView text;

        public MyViewHolder(View v) {
            super(v);
            text = (TextView) itemView.findViewById(R.id.txtMessage);
        }
    }

    public MessageAdapter(List<Message> myDataset) {
        this.mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MessageAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        final MyViewHolder pvh = new MyViewHolder(v);


        return pvh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        viewHolder.text.setText(mDataset.get(i).getText());
        // personViewHolder.imgView.setImageResource(mDataset.get(i).get);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}