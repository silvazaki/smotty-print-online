package com.starcom.smotty;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class TransaksiFragment extends Fragment {


    public TransaksiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transaksi, container, false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs);


        tabLayout.addTab(tabLayout.newTab().setText("Terkirim"));
        tabLayout.addTab(tabLayout.newTab().setText("Berhasil"));


        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);





        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);


        final PagerAdapter adapter = new PagerAdapter(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        viewPager.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {


            @Override


            public void onTabSelected(TabLayout.Tab tab) {


                viewPager.setCurrentItem(tab.getPosition());


            }





            @Override


            public void onTabUnselected(TabLayout.Tab tab) {





            }





            @Override


            public void onTabReselected(TabLayout.Tab tab) {





            }


        });

        return view;
    }
}

class PagerAdapter extends FragmentStatePagerAdapter {


    int mNumOfTabs;


    public PagerAdapter(FragmentManager fm, int NumOfTabs) {


        super(fm);


        this.mNumOfTabs = NumOfTabs;


    }


    @Override


    public Fragment getItem(int position) {


        switch (position) {


            case 0:


                OneFragment tab1 = new OneFragment();


                return tab1;


            case 1:


                TwoFragment tab2 = new TwoFragment();


                return tab2;


            default:


                return null;


        }


    }


    @Override


    public int getCount() {


        return mNumOfTabs;


    }
}
