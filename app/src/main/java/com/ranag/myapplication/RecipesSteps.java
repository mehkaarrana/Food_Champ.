package com.ranag.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipesSteps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_steps);
        ImageView imageView=findViewById(R.id.imageitemfood);
        TextView title=findViewById(R.id.title);
        TextView name=findViewById(R.id.titlename);
        Toolbar toolbar=findViewById(R.id.toolbarstep);
        setSupportActionBar(toolbar);
        Intent intent=getIntent();
      int id=  intent.getIntExtra("ids",0);
      String nameoffood=intent.getStringExtra("foodname");
      String titlecontant=intent.getStringExtra("title");
      String videolink=intent.getStringExtra("vlink");
      title.setText(titlecontant);
      name.setText(nameoffood+"-");
      imageView.setImageResource(id);
      String []arr=intent.getStringArrayExtra("arr");
        ArrayList arrayList=new ArrayList<>();
        List list= Arrays.asList(arr);
        ListView listView=findViewById(R.id.listview);
        TextView steps=findViewById(R.id.steps);
        steps.append(nameoffood);
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);


        ImageView btnopen=findViewById(R.id.listopen);
        ImageView btnoff=findViewById(R.id.listoof);
        TextView line=findViewById(R.id.line);



        btnopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.setVisibility(View.VISIBLE);
                btnoff.setVisibility(View.VISIBLE);
                btnopen.setVisibility(View.GONE);
                line.setVisibility(View.VISIBLE);

            }
        });
        btnoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.setVisibility(View.GONE);
                btnopen.setVisibility(View.VISIBLE);
                btnoff.setVisibility(View.GONE);
                line.setVisibility(View.GONE);
            }
        });

        String arrhm[]=intent.getStringArrayExtra("arrhm");
        String hindiarrhm[]=intent.getStringArrayExtra("hindiarrhm");
        TextView howmakefood=findViewById(R.id.howmake);
        howmakefood.append(" "+nameoffood);
        CardView next=findViewById(R.id.nextcard);


        Intent i=new Intent(getApplicationContext(),HowMake.class);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                     i.putExtra("toltaxt",howmakefood.getText().toString());
                     i.putExtra("arrhmn",arrhm);
                     i.putExtra("hindiarrhmn",hindiarrhm);
                     i.putExtra("ylink",videolink);
                     startActivity(i);
            }
        });





        SharedPreferences sharedPreferences=getSharedPreferences("language",MODE_PRIVATE);
        boolean result=sharedPreferences.getBoolean("type",false);
        if(result){
                   name.setText(intent.getStringExtra("hindifoodname"));
                   title.setText(intent.getStringExtra("hindititle"));
                   steps.setText(intent.getStringExtra("hindifoodname")+" की सामग्री");
                   String[] hindiarr=intent.getStringArrayExtra("hindiarr");
                   List list1=Arrays.asList(hindiarr);
                   ArrayAdapter adapter1=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,list1);
                   listView.setAdapter(adapter1);
                   howmakefood.setText(intent.getStringExtra("hindifoodname")+" कैसे बनायें");
                   toolbar.setTitle("भोजन बनाने के चरण");

               }else {
                   name.setText(nameoffood);
                   title.setText(titlecontant);
                   steps.setText("Ingredients of "+nameoffood);
                   ArrayAdapter adapter2=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,list);
                   listView.setAdapter(adapter2);
                   howmakefood.setText("How to Make "+nameoffood);
                   toolbar.setTitle("Making Steps of Recipes");

               }


        ImageView gohome=findViewById(R.id.gohomestep);
        gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RecipesSteps.this, MainActivity.class));
            }
        });


    }
}