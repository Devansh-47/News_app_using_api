package com.example.newsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.newsapp.adapter.newslistadapter;
import com.example.newsapp.apis.api_interface;
import com.example.newsapp.apis.apiclient;
import com.example.newsapp.modelclasses.Article;
import com.example.newsapp.modelclasses.Root;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link entertaintment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class entertaintment extends Fragment {
    ArrayList<Article> list;
    newslistadapter ad;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public entertaintment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment entertaintment.
     */
    // TODO: Rename and change types and number of parameters
    public static entertaintment newInstance(String param1, String param2) {
        entertaintment fragment = new entertaintment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_entertaintment, container, false);
        RecyclerView rv=view.findViewById(R.id.rv_entertain);
        Retrofit retrofit= apiclient.getRetrofit();
        api_interface apiInterface=retrofit.create(api_interface.class);
        list=new ArrayList<>();
        String country=getArguments().getString("country");
        Log.d("AWAA","c,enter=="+country);
        apiInterface.getheadlines(country,"entertainment","abcc7a0c4238489abe5bf52cdd5623f3",50).enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
               // Toast.makeText(getContext(), "sssss", Toast.LENGTH_SHORT).show();
                if(response.body()!=null){
                    Toast.makeText(getContext(), "sssss", Toast.LENGTH_SHORT).show();
                    if(response.body().getTotalResults()>0){
                        list.addAll(response.body().getArticles());
                        ad=new newslistadapter(list,getContext());
                        rv.setAdapter(ad);
                        rv.setLayoutManager(new LinearLayoutManager(getContext()));
                    }


                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Log.d("failure",t.getLocalizedMessage());
            }
        });
        return view;
    }
}