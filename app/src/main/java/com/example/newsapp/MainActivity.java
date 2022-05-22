package com.example.newsapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager vp;
    TabLayout tl;
    TabItem home,sport,health,science,entertaintment,technology;
    ImageButton filter;
    AlertDialog.Builder ab;
    AlertDialog ad;
    Button apply;
    ImageButton cancel;
    RadioGroup rg;
     Home home_frag=new Home();
     sport sport_frag=new sport();
    health health_frag=new health();
    science science_frag=new science();
    technology technology_frag=new technology();
    entertaintment entertaintment_fra=new entertaintment();
     Bundle b=new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp=findViewById(R.id.vp);
        tl=findViewById(R.id.tl);
        home=findViewById(R.id.home_tab);
        sport=findViewById(R.id.sports_tab);
        health=findViewById(R.id.health_tab);
        science=findViewById(R.id.science_tab);
        entertaintment=findViewById(R.id.entertaintment_tab);
        technology=findViewById(R.id.technology_tab);
        filter=findViewById(R.id.filter_btn);


        ScreenSlidePagerAdapter sa=new ScreenSlidePagerAdapter(getSupportFragmentManager());
        vp.setAdapter(sa);
        tl.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(vp));
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tl));
        b.putString("country","in");
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View vv;
                vv= LayoutInflater.from(MainActivity.this).inflate(R.layout.selectcountry,null);
                ad=new AlertDialog.Builder(MainActivity.this).setCancelable(false).setView(vv).create();
                ad.show();
                 apply=vv.findViewById(R.id.apply_btn);
                cancel=vv.findViewById(R.id.cancel_btn);
                 rg=vv.findViewById(R.id.rg);

                 cancel.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         ad.dismiss();
                     }
                 });

                apply.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ad.dismiss();
                        int id=rg.getCheckedRadioButtonId();
                        Log.d("AWAA","id=="+id);
                        switch (id){
                            case R.id.ca:
                                b.putString("country","ca");
                                break;
                            case R.id.ae:
                                b.putString("country","ae");
                                break;
                            case R.id.at:
                                b.putString("country","at");
                                Log.d("AWAA","id===="+R.id.at);
                                break;
                            case R.id.ve:
                                b.putString("country","ve");
                                break;
                            case R.id.ar:
                                b.putString("country","ar");
                                break;
                            case R.id.be:
                                b.putString("country","be");
                                break;
                            case R.id.br:
                                b.putString("country","br");
                                break;
                            case R.id.ch:
                                b.putString("country","ch");
                                break;
                            case R.id.us:
                                b.putString("country","us");
                                break;
                            default:
                                b.putString("country","in");
                                break;
                        }
                    }
                });
            }
        });
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Log.d("AWAA","bundle checj=="+b.getString("country"));

            switch (position){
                case 0:
                    home_frag.setArguments(b);
                    return home_frag;

                case 1:
                    sport_frag.setArguments(b);
                    return sport_frag;

                case 2:
                    health_frag.setArguments(b);
                    return health_frag;

                case 3:
                    science_frag.setArguments(b);
                    return science_frag;

                case 4:
                    entertaintment_fra.setArguments(b);
                    return entertaintment_fra;

                case 5:
                    technology_frag.setArguments(b);
                    return technology_frag;

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 6;
        }
    }
}