package com.ranag.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class HowMake extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_make);




        TextView toltaxt = findViewById(R.id.toltaxt);
        Intent i = getIntent();
        String textoftoolname = i.getStringExtra("toltaxt");
        toltaxt.setText(textoftoolname);
        String link=i.getStringExtra("ylink");

        String[] hindiarrhm = i.getStringArrayExtra("hindiarrhmn");
        String[] arrhm=i.getStringArrayExtra("arrhmn");

        TextView watchtext=findViewById(R.id.watchtext);
        TextView linktext=findViewById(R.id.videolink);

        SharedPreferences sharedPreferences=getSharedPreferences("language",MODE_PRIVATE);
       boolean res= sharedPreferences.getBoolean("type",false);

       if(res){
           ArrayList<String> arrayList1=new ArrayList<>();
           Collections.addAll(arrayList1,hindiarrhm);
           ListView listView=findViewById(R.id.makinglist);
           ArrayList<HashMap<String,String >> a=new ArrayList<>();
           for (int j=0;j<arrayList1.size();j++){
               String value=arrayList1.get(j).toString();
               HashMap<String ,String>map=new HashMap<>();
               map.put("value",value);
               map.put("step","Step "+(j+1)+" -");
               a.add(map);
               String[] from={"value","step"};
               int[] to={R.id.textmm,R.id.textstep};
               SimpleAdapter simpleAdapter=new SimpleAdapter(getApplicationContext(),a,R.layout.customlist,from,to);
               listView.setAdapter(simpleAdapter);

           }
           watchtext.setText("यूट्यूब पर वीडियो देखें ");
           linktext.setText("क्लिक करें");
       }else {
           ArrayList<String> arrayList1=new ArrayList<>();
           Collections.addAll(arrayList1,arrhm);
           ListView listView=findViewById(R.id.makinglist);
           ArrayList<HashMap<String,String >> a=new ArrayList<>();
           for (int j=0;j<arrayList1.size();j++){
               String value=arrayList1.get(j).toString();
               HashMap<String ,String>map=new HashMap<>();
               map.put("value",value);
               map.put("step","Step "+(j+1)+" -");
               a.add(map);
               String[] from={"value","step"};
               int[] to={R.id.textmm,R.id.textstep};
               SimpleAdapter simpleAdapter=new SimpleAdapter(getApplicationContext(),a,R.layout.customlist,from,to);
               listView.setAdapter(simpleAdapter);


           }
           watchtext.setText("Watch Video on Youtube");
           linktext.setText("Click here");



//           List list1=Arrays.asList(arrhm);
//           ListView listView=findViewById(R.id.makinglist);
//           ArrayAdapter adapter1=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList1);
//           listView.setAdapter(adapter1);
       }
        CardView linkcard=findViewById(R.id.cardlink);

            // Internet connection is available
            // You can perform network-related tasks here
            linkcard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (NetworkUtils.isNetworkAvailable(getApplicationContext())) {
                    Intent intent1=new Intent(HowMake.this,WebView.class);
                    intent1.putExtra("link",link);
                    startActivity(intent1);
                    } else {
                        Toast.makeText(getApplicationContext(), "Please turn on  internet Conection", Toast.LENGTH_SHORT).show();
                    }
                }
            });





        ImageView gohome=findViewById(R.id.gohomehm);
        gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HowMake.this,MainActivity.class));
            }
        });









    }
}