package com.arayeh.hampa.adapters;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.arayeh.hampa.R;
import com.arayeh.hampa.interfaces.SelectItemClick;
import com.arayeh.hampa.models.Community;
import com.arayeh.hampa.models.ContextItem;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class CommunityListAdapter extends RecyclerView.Adapter<CommunityListAdapter.MyViewHolder>  {
    private List<Community> mDataset;
    private SelectItemClick caller;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView header;
        public TextView memberNumber;
        public ImageView imgView;

        public MyViewHolder(View v) {
            super(v);
            header = (TextView) itemView.findViewById(R.id.txtCommunityName);
            imgView = itemView.findViewById(R.id.imgCommunity);
            memberNumber = itemView.findViewById(R.id.txtMemberNumber);
        }
    }

    public CommunityListAdapter(List<Community> myDataset, SelectItemClick caller) {
        this.mDataset = myDataset;
        this.caller=caller;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CommunityListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.community_item, parent, false);
        final MyViewHolder pvh = new MyViewHolder(v);
        pvh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                caller.onItemClick(0,pvh.getAdapterPosition());
            }
        });


        return pvh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        viewHolder.header.setText(mDataset.get(i).getComminityName());
        viewHolder.memberNumber.setText(String.valueOf(mDataset.get(i).getMemberNumber()));
        viewHolder.imgView.setImageResource(mDataset.get(i).getImageView());
        // personViewHolder.imgView.setImageResource(mDataset.get(i).get);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}