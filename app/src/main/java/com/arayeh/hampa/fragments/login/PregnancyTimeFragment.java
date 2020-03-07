package com.arayeh.hampa.fragments.login;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.arayeh.hampa.MainActivity;
import com.arayeh.hampa.R;
import com.arayeh.hampa.adapters.CustomNumericWheelAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import antistatic.spinnerwheel.AbstractWheel;
import antistatic.spinnerwheel.AbstractWheelView;
import antistatic.spinnerwheel.OnWheelChangedListener;
import antistatic.spinnerwheel.OnWheelClickedListener;
import antistatic.spinnerwheel.OnWheelScrollListener;
import antistatic.spinnerwheel.WheelVerticalView;
import antistatic.spinnerwheel.adapters.NumericWheelAdapter;


public class PregnancyTimeFragment extends Fragment {
    private AppCompatButton btnOK;
    private boolean timeChanged = false;
    private boolean timeScrolled = false;
  //  private TextView tv;
    public WheelVerticalView wheel_hour;
    public WheelVerticalView wheel_min;
    private WheelVerticalView wheel_date;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pregnancy_time, container, false);
        btnOK = view.findViewById(R.id.btnOK);

        initReferences(view);
        initListeners();
        initViews();
        bind();

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity activity = getActivity();
                if (activity instanceof MainActivity) {
                    MainActivity myactivity = (MainActivity) activity;
                    myactivity.loadLastPeriodTimeFragment();
                }
            }
        });

        return view;
    }

    private String[] get3CharYears() {
        String[] years = new String[2];
        for (int i = 0; i < years.length; i++) {
            years[i] = String.valueOf(i + 1398);
        }
        return years;
    }

    private String[] get3CharMonth() {
        String[] months = new String[12];
        for (int i = 0; i < months.length; i++) {
            months[i] = String.valueOf(i + 1);
        }
        return months;
    }

    private String[] get3CharDay() {
        String[] days = new String[31];
        for (int i = 0; i < days.length; i++) {
            days[i] = String.valueOf(i + 1);
        }
        return days;
    }

    private void bind() {
        wheel_date.setViewAdapter(new CustomNumericWheelAdapter(getContext(),
                0,
                Integer.MAX_VALUE - 2,// in fact, the largest accept max value is MAX_VALUE - 2, but it is enough for finite scroll.
                new NumericWheelAdapter.IntParamFunction<String>() {
                    Date mDate = new Date();
                    SimpleDateFormat mSimpleDateFormatHalf = new SimpleDateFormat("MM.dd", Locale.US);
                    SimpleDateFormat mSimpleDateFormatFull =
                            new SimpleDateFormat("yyyy.MM.dd", Locale.US);

                    @Override
                    public String apply(int i) {
                        // set current time
                        mDate.setTime(TimeUnit.DAYS.toMillis(i));
                        if (mDate.getYear() == 2016) {
                            return mSimpleDateFormatHalf.format(mDate);
                        }
                        return mSimpleDateFormatFull.format(mDate);
                    }
                }));
        wheel_hour.setViewAdapter(new CustomNumericWheelAdapter(getContext(), 1, 12,"%02d"));
        wheel_min.setViewAdapter(new CustomNumericWheelAdapter(getContext(), 1, 31, "%02d"));
        wheel_date.setViewAdapter(new CustomNumericWheelAdapter(getContext(), 1397, 1398));

        // set current time
        Calendar c = Calendar.getInstance();
        int curHours = c.get(Calendar.HOUR_OF_DAY);
        int curMinutes = c.get(Calendar.MINUTE);

       // wheel_date.setCurrentItem((int) TimeUnit.MILLISECONDS.toDays(c.getTimeInMillis()));
        wheel_hour.setCurrentItem(curHours);
        wheel_min.setCurrentItem(curMinutes);

//        mPicker.setCurrentHour(curHours);
//        mPicker.setCurrentMinute(curMinutes);
    }

    private void initReferences(View view) {
      // tv = (TextView) view.findViewById(R.id.tv);

        wheel_date = (WheelVerticalView) view.findViewById(R.id.wheel_date);

        wheel_hour = (WheelVerticalView) view.findViewById(R.id.wheel_hour);

        wheel_min = (WheelVerticalView) view.findViewById(R.id.wheel_min);

        //mPicker = (TimePicker) findViewById(R.id.time);
    }

    private void initViews() {
        initWheelsStyle();

       // mPicker.setIs24HourView(true);
    }

    private void initWheelsStyle() {
//        initWheelStyle(wheel_date);
//        wheel_date.setCyclic(false);
        initWheelStyle(wheel_date);
        initWheelStyle(wheel_hour);
        initWheelStyle(wheel_min);
    }

    private void initWheelStyle(AbstractWheelView wheel) {
        wheel.setCyclic(true);
        wheel.setVisibleItems(10);
        wheel.setActiveCoeff(0.8f);
        wheel.setPassiveCoeff(0.6f);

        // test
        wheel.setSelectionDivider(new ColorDrawable(Color.BLACK));
    }

    private void initListeners() {
        // add listeners
        addChangingListener(wheel_min, "min");
        addChangingListener(wheel_hour, "hour");
        addChangingListener(wheel_date, "year");

        OnWheelChangedListener wheelListener = new OnWheelChangedListener() {
            public void onChanged(AbstractWheel wheel, int oldValue, int newValue) {
                if (!timeScrolled) {
                    timeChanged = true;
                   // mPicker.setCurrentHour(wheel_hour.getCurrentItem());
                  //  mPicker.setCurrentMinute(wheel_min.getCurrentItem());
                    timeChanged = false;
                }
            }
        };
        wheel_hour.addChangingListener(wheelListener);
        wheel_min.addChangingListener(wheelListener);

        OnWheelClickedListener click = new OnWheelClickedListener() {
            public void onItemClicked(AbstractWheel wheel, int itemIndex) {
                wheel.setCurrentItem(itemIndex, true);
            }
        };
        wheel_date.addClickingListener(click);
        wheel_hour.addClickingListener(click);
        wheel_min.addClickingListener(click);

        OnWheelScrollListener scrollListener = new OnWheelScrollListener() {
            public void onScrollingStarted(AbstractWheel wheel) {
                timeScrolled = true;
            }

            public void onScrollingFinished(AbstractWheel wheel) {
                timeScrolled = false;
                timeChanged = true;
              //  mPicker.setCurrentHour(wheel_hour.getCurrentItem());
             //   mPicker.setCurrentMinute(wheel_min.getCurrentItem());
                timeChanged = false;
            }
        };

        wheel_hour.addScrollingListener(scrollListener);
        wheel_min.addScrollingListener(scrollListener);
        wheel_date.addScrollingListener(scrollListener);

//        mPicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//                if (!timeChanged) {
//                    wheel_hour.setCurrentItem(hourOfDay, true);
//                    wheel_min.setCurrentItem(minute, true);
//                }
//            }
//        });

//        tv.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                // test edge
////                wheel_date.setCurrentItem(0);
////                wheel_date.invalidateItemsLayout(false);
////                //wheel_date.setCurrentItem(Integer.MAX_VALUE - 2);
////            }
////        });
    }

    /**
     * Adds changing listener for spinnerwheel that updates the spinnerwheel label
     *
     * @param wheel the spinnerwheel
     * @param label the spinnerwheel label
     */
    private void addChangingListener(final AbstractWheel wheel, final String label) {
        wheel.addChangingListener(new OnWheelChangedListener() {
            public void onChanged(AbstractWheel wheel, int oldValue, int newValue) {
                //spinnerwheel.setLabel(newValue != 1 ? label + "s" : label);
            }
        });
    }
}
