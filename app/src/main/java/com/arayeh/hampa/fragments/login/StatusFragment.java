package com.arayeh.hampa.fragments.login;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.arayeh.hampa.MainActivity;
import com.arayeh.hampa.R;

import androidx.fragment.app.Fragment;
import antistatic.spinnerwheel.AbstractWheel;
import antistatic.spinnerwheel.WheelVerticalView;
import antistatic.spinnerwheel.adapters.AbstractWheelTextAdapter;


public class StatusFragment extends Fragment {
    private WheelVerticalView wheelVerticalView;
    private Button mBtnAccept;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_status, container, false);
        mBtnAccept = view.findViewById(R.id.btnAccept);
        final AbstractWheel country = (AbstractWheel) view.findViewById(R.id.day);
        country.setVisibleItems(3);
        country.setViewAdapter(new StatusAdapter(getContext()));

        mBtnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity activity = getActivity();

                if (activity instanceof MainActivity) {
                    MainActivity myactivity = (MainActivity) activity;
                    if (country.getCurrentItem() == 0) {
                        myactivity.loadPregnancyTimeFragment();
                    } else {
                        myactivity.loadPregnancyTimeFragment();
                    }
                }
            }
        });

        return view;
    }

    private class StatusAdapter extends AbstractWheelTextAdapter {
        // Countries names
        private String stats[] =
                new String[]{"باردار", "دارای فرزند"};
        // Countries flags
        private int flags[] =
                new int[]{R.drawable.ic_comment, R.drawable.ic_more};

        /**
         * Constructor
         */
        protected StatusAdapter(Context context) {
            super(context, R.layout.status_item, NO_RESOURCE);

            setItemTextResource(R.id.txtStatus);
        }

        @Override
        public View getItem(int index, View cachedView, ViewGroup parent, int currentItemIdx) {
            View view = super.getItem(index, cachedView, parent, currentItemIdx);
            ImageView img = (ImageView) view.findViewById(R.id.flag);
            img.setImageResource(flags[index]);
            return view;
        }

        @Override
        public int getItemsCount() {
            return stats.length;
        }

        @Override
        protected CharSequence getItemText(int index) {

            return stats[index];
        }
    }

}
