package com.example.newsapp.adapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;
import com.example.newsapp.modelclasses.Article;
import com.example.newsapp.modelclasses.Root;
import com.example.newsapp.webview;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class newslistadapter extends RecyclerView.Adapter<newslistadapter.ViewHolder> {
ArrayList<Article> list;
Context context;


    public newslistadapter(ArrayList<Article> listt, Context context){
        list=listt;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      View  view= LayoutInflater.from(context)
                .inflate(R.layout.news_card, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.getMainheading().setText(""+list.get(holder.getAdapterPosition()).getTitle());
        holder.getDescription().setText(""+list.get(holder.getAdapterPosition()).getDescription());
        holder.getAuthor().setText(""+list.get(holder.getAdapterPosition()).getAuthor());
        holder.getDate().setText(""+list.get(holder.getAdapterPosition()).getPublishedAt());
        Glide.with(context).load(list.get(holder.getAdapterPosition()).getUrlToImage()).into(holder.getImg());
        holder.getCv().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, webview.class);
                i.putExtra("url",list.get(holder.getAdapterPosition()).getUrl()+"");
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mainheading,description,author,date;
        MaterialCardView cv;
        ImageView img;

        public ViewHolder(View view) {
            super(view);

            mainheading=view.findViewById(R.id.heading_text);
            description=view.findViewById(R.id.description_text);
            author=view.findViewById(R.id.author_name);
            date=view.findViewById(R.id.date);
            img=view.findViewById(R.id.img);
            cv=view.findViewById(R.id.cardid);

        }
public MaterialCardView getCv(){return cv;}
        public TextView getMainheading() {
            return mainheading;
        }

        public TextView getDescription() {
            return description;
        }

        public TextView getAuthor() {
            return author;
        }

        public TextView getDate() {
            return date;
        }

        public ImageView getImg() {
            return img;
        }
    }
}