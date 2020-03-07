package com.arayeh.hampa.fragments.profile;

import android.graphics.Rect;
import android.os.Bundle;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.FragmentTransaction;
import antistatic.spinnerwheel.AbstractWheel;
import antistatic.spinnerwheel.adapters.NumericWheelAdapter;

import com.arayeh.hampa.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ProfileFragment extends Fragment {
    private FrameLayout mBtnBabyStatus;
    private NestedScrollView nestedScrollView;
    private LinearLayout linearLayout;
    private int childrenY;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_profile, container, false);
        nestedScrollView=view.findViewById(R.id.nested);
        linearLayout=view.findViewById(R.id.temp);
        final AbstractWheel mins = (AbstractWheel) view.findViewById(R.id.mins);
        NumericWheelAdapter minAdapter = new NumericWheelAdapter(getContext(), 1, 41, "%02d");
        minAdapter.setItemResource(R.layout.wheel_text_centered_dark_back);
        minAdapter.setItemTextResource(R.id.text);
        mins.setViewAdapter(minAdapter);
        loadBabyFragment();
        loadFoodFragment();
        loadMomFragment();
        loadChartFragment();
        loadProductListFragment();
      //  findViewById(R.id.recycler_view).setFocusable(false);
      //  nestedScrollView.findViewById(R.id.temp).requestFocus();
        mBtnBabyStatus = view.findViewById(R.id.btnBabyStatus);
      // final FloatingActionButton fab1 = (FloatingActionButton) view.findViewById(R.id.fab1);
        final FloatingActionButton fab2 = (FloatingActionButton) view.findViewById(R.id.fab2);
        final FloatingActionButton fab3 = (FloatingActionButton) view.findViewById(R.id.fab3);
        final Rect bounds = new Rect();
        nestedScrollView.getChildAt(0).getHitRect(bounds);

        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {


                Rect scrollBounds = new Rect(scrollX,scrollY,
                        scrollY + nestedScrollView.getWidth(), scrollY + nestedScrollView.getHeight());

                if(Rect.intersects(scrollBounds, bounds))
                {
                    Toast.makeText(getContext(),"huihuiu",Toast.LENGTH_LONG).show();
                    //is  visible
                }
                if ((scrollY > oldScrollY)||scrollY==oldScrollY) {
                 //   fab1.hide();
                    fab2.hide();
                    fab3.hide();
                } else {
                  //  fab1.show();
                    fab2.show();
                    fab3.show();
                }
            }
        });

        mBtnBabyStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadBabyStatusFragment();

            }
        });
//        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
//        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
//        final CollapsingToolbarLayout collapsingToolbar =
//                (CollapsingToolbarLayout) view.findViewById(R.id.toolbar_layout);
        return view;
    }

    private void loadBabyStatusFragment() {
        BabyStatusFragment myf = new BabyStatusFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        myf.show(getChildFragmentManager(), "");
//        transaction.addToBackStack("Pregnancy");
//        //  transaction.disallowAddToBackStack();
//        transaction.commit();
    }
    private void loadProductListFragment() {
        ProductListFragment myf = new ProductListFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentFive, myf);
        transaction.addToBackStack("Pregnancy");
        //  transaction.disallowAddToBackStack();
        transaction.commit();
    }
    private void loadBabyFragment() {
        BabyFragment myf = new BabyFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        //  transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragmnetOne, myf);
        transaction.addToBackStack("Pregnancy");
        //  transaction.disallowAddToBackStack();
        transaction.commit();
    }

    private void loadMomFragment() {
        BabyFragment myf = new BabyFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        //  transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragmentTwo, myf);
        transaction.addToBackStack("Pregnancy");
        //  transaction.disallowAddToBackStack();
        transaction.commit();
    }

    private void loadFoodFragment() {
        BabyFragment myf = new BabyFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        //  transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragmentThree, myf);
        transaction.addToBackStack("Pregnancy");
        //  transaction.disallowAddToBackStack();
        transaction.commit();
    }

    private void loadChartFragment() {
        BabyFragment myf = new BabyFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        //  transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragmentFour, myf);
        transaction.addToBackStack("Pregnancy");
        //  transaction.disallowAddToBackStack();
        transaction.commit();
    }
//        @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        //getMenuInflater().inflate(R.menu.menu_scrolling, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

}
