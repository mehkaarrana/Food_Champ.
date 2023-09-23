package com.ranag.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adept extends RecyclerView.Adapter<Adept.ViewHolder> {
    Context context;
    ArrayList<Mdclass> arrayList;

    public Adept(Context context, ArrayList<Mdclass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public Adept.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Adept.ViewHolder holder, int position) {
        SharedPreferences sharedPreferences= context.getSharedPreferences("language",Context.MODE_PRIVATE);
        boolean result=sharedPreferences.getBoolean("type",false);
        if(result){
            holder.time.setText(arrayList.get(position).time+" मिनट");
            holder.namefood.setText(arrayList.get(position).getHindiname());
            holder.totaltime.setText(" कुल समय ");
            holder.imagefood.setImageResource(arrayList.get(position).getImageid());
        }else {
        holder.time.setText(arrayList.get(position).time+" mins");
        holder.imagefood.setImageResource(arrayList.get(position).getImageid());
        holder.namefood.setText(arrayList.get(position).getName());
        }
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,RecipesSteps.class);
                i.putExtra("ids",arrayList.get(position).getImageid());
                i.putExtra("foodname",arrayList.get(position).getName());
                i.putExtra("title",arrayList.get(position).getTitle());
                i.putExtra("arr",arrayList.get(position).getArr());
                i.putExtra("hindifoodname",arrayList.get(position).getHindiname());
                i.putExtra("hindititle",arrayList.get(position).getHindititle());
                i.putExtra("hindiarr",arrayList.get(position).getHindiarr());
                i.putExtra("arrhm",arrayList.get(position).getHmarr());
                i.putExtra("hindiarrhm",arrayList.get(position).getHindihmarr());
                i.putExtra("vlink",arrayList.get(position).getLink());
                context.startActivity(i);
            }
        });






    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagefood;
        LinearLayout layout;
        TextView time,namefood,totaltime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagefood=itemView.findViewById(R.id.imageoffood);
            namefood=itemView.findViewById(R.id.nameoffood);
            time=itemView.findViewById(R.id.time);
            layout=itemView.findViewById(R.id.linerlayout);
            totaltime=itemView.findViewById(R.id.totaltime);
        }
    }
}
