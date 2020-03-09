package com.arayeh.hampa.fragments.community;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arayeh.hampa.CommunityActivity;
import com.arayeh.hampa.R;
import com.arayeh.hampa.adapters.CommunityListAdapter;
import com.arayeh.hampa.adapters.RecyclerViewAdapter;
import com.arayeh.hampa.interfaces.SelectItemClick;
import com.arayeh.hampa.models.Community;
import com.arayeh.hampa.models.ContentItem;

import java.util.ArrayList;
import java.util.List;


public class CommunityListFragment extends Fragment implements SelectItemClick {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CommunityListAdapter communityListAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_community_list, container, false);
        recyclerView = view.findViewById(R.id.rcv_community_list);
        layoutManager= new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        List<Community> contentItemList=new ArrayList<>();
        contentItemList.add(new Community("بارداری در سنین بالا", R.drawable.ic_baby));
        contentItemList.add(new Community("تغذیه در دوران بارداری", R.drawable.ic_baby_food));
        contentItemList.add(new Community("خواب مادر در بارداری", R.drawable.ic_baby_grow));
        contentItemList.add(new Community("مادران فرزند اولی", R.drawable.ic_baby_weight));
        contentItemList.add(new Community("فرزند پسر", R.drawable.ic_corona));
        contentItemList.add(new Community("فرزند دختر", R.drawable.ic_poodr));
        communityListAdapter=new CommunityListAdapter(contentItemList, this);
        recyclerView.setAdapter(communityListAdapter);
        return view;
    }


    @Override
    public void onItemClick(int groupID, int id) {
        Intent intent=new Intent(getActivity(), CommunityActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(int groupID, ContentItem contentItem) {

    }
}
