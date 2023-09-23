package com.ranag.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ActionTypes;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.interfaces.TouchListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    ImageView logout;
    Button vegbtn,nonvegbtn,hindivegbtn,hindinonvegbtn;
    Toolbar toolbar;
    TextView vegr,nonvegr,breakfast,typesfood;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        vegr=findViewById(R.id.vefr);
        nonvegr=findViewById(R.id.nonvegr);
        breakfast=findViewById(R.id.breakfast);
        typesfood=findViewById(R.id.typefood);

        logout=findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putBoolean("check",false);
                editor.apply();
                startActivity(new Intent(MainActivity.this,Login.class));
            }
        });
       SharedPreferences sharedPreferences=getSharedPreferences("language",MODE_PRIVATE);
       boolean result=sharedPreferences.getBoolean("type",false);
        if(!result){
            vegr.setText("Vegetarian Recipes");
            nonvegr.setText("Non-Vegetarian Recipes");
            TextView option=findViewById(R.id.option);
            TextView clickany=findViewById(R.id.clickany);
            option.setText("Option");
            clickany.setText("Click any");
            toolbar.setTitle("Food Recipies");
            breakfast.setText("Breakfast Recipes");
            typesfood.setText("Types of Food");

            ImageSlider imageSliderofVeg=findViewById(R.id.imagesliderofveg);
            ArrayList<SlideModel> list=new ArrayList<>();
            list.add(new SlideModel(R.drawable.img,"Rajasthani Kadhi Pakoda Recipe", ScaleTypes.FIT));
            list.add(new SlideModel(R.drawable.img_1,"Bengali-Style Chanar Dalna Recipe", ScaleTypes.FIT));
            list.add(new SlideModel(R.drawable.img_2,"Aloo Pyaaz Pakora Recipe", ScaleTypes.FIT));
            list.add(new SlideModel(R.drawable.img_3,"Air Fryer Baby Corn Fritters (Desi Style) Recipe", ScaleTypes.FIT));
            imageSliderofVeg.setImageList(list);


            ImageSlider imageSliderofNonVeg=findViewById(R.id.imagesliderofnonveg);
            ArrayList<SlideModel> listNonveg=new ArrayList<>();
            listNonveg.add(new SlideModel(R.drawable.img_4,"Grilled Chicken Escalope with Fresh Salsa", ScaleTypes.FIT));
            listNonveg.add(new SlideModel(R.drawable.img_5,"Pina Colada Pork Ribs", ScaleTypes.FIT));
            listNonveg.add(new SlideModel(R.drawable.img_6,"Malabar Fish Biryani", ScaleTypes.FIT));
            listNonveg.add(new SlideModel(R.drawable.img_7,"Chicken 65", ScaleTypes.FIT));
            imageSliderofNonVeg.setImageList(listNonveg);

            ImageSlider imageSliderofBreakfast=findViewById(R.id.imagesliderofbreakfast);
            ArrayList<SlideModel> listBreakfast=new ArrayList<>();
            listBreakfast.add(new SlideModel(R.drawable.butternoodles,"Butter Garlic Pan-Fried Noodles Recipe",ScaleTypes.FIT));
            listBreakfast.add(new SlideModel(R.drawable.bastedeggs,"Basted Eggs Recipe",ScaleTypes.FIT));
            listBreakfast.add(new SlideModel(R.drawable.moonddaltoast,"Moong Dal Toast Recipe",ScaleTypes.FIT));
            listBreakfast.add(new SlideModel(R.drawable.bananakheer,"Banana Kheer Recipe",ScaleTypes.FIT));
            imageSliderofBreakfast.setImageList(listBreakfast);
        }else {
            vegr.setText("शाकाहारी भोजन");
            nonvegr.setText("मांसाहारी भोजन");
            TextView option=findViewById(R.id.option);
            TextView clickany=findViewById(R.id.clickany);
            option.setText("क्लिक करें");
            clickany.setText("किसी पर ");
            toolbar.setTitle("भोजन विधि");
            breakfast.setText("नाश्ता भोजन");
            typesfood.setText("भोजन के प्रकार");

            ImageSlider imageSliderofVeg=findViewById(R.id.imagesliderofveg);
            ArrayList<SlideModel> list=new ArrayList<>();
            list.add(new SlideModel(R.drawable.img,"राजस्थानी कढ़ी पकोड़ा", ScaleTypes.FIT));
            list.add(new SlideModel(R.drawable.img_1,"बंगाली स्टाइल चनर दालना", ScaleTypes.FIT));
            list.add(new SlideModel(R.drawable.img_2,"आलू प्याज़ पकौड़ा", ScaleTypes.FIT));
            list.add(new SlideModel(R.drawable.img_3,"एयर फ्रायर बेबी कॉर्न फ्रिटर्स (देसी स्टाइल) ", ScaleTypes.FIT));
            imageSliderofVeg.setImageList(list);


            ImageSlider imageSliderofNonVeg=findViewById(R.id.imagesliderofnonveg);
            ArrayList<SlideModel> listNonveg=new ArrayList<>();
            listNonveg.add(new SlideModel(R.drawable.img_4,"ताजा साल्सा के साथ ग्रिल्ड चिकन एस्केलोप", ScaleTypes.FIT));
            listNonveg.add(new SlideModel(R.drawable.img_5,"पिना कोलाडा पोर्क पसलियों", ScaleTypes.FIT));
            listNonveg.add(new SlideModel(R.drawable.img_6,"मालाबार मछली बिरयानी", ScaleTypes.FIT));
            listNonveg.add(new SlideModel(R.drawable.img_7,"चिकन 65", ScaleTypes.FIT));
            imageSliderofNonVeg.setImageList(listNonveg);

            ImageSlider imageSliderofBreakfast=findViewById(R.id.imagesliderofbreakfast);
            ArrayList<SlideModel> listBreakfast=new ArrayList<>();
            listBreakfast.add(new SlideModel(R.drawable.butternoodles,"बटर लहसुन पैन-फ्राइड नूडल्स रेसिपी",ScaleTypes.FIT));
            listBreakfast.add(new SlideModel(R.drawable.bastedeggs,"भुने हुए अंडे की रेसिपी",ScaleTypes.FIT));
            listBreakfast.add(new SlideModel(R.drawable.moonddaltoast,"मूंग दाल टोस्ट रेसिपी",ScaleTypes.FIT));
            listBreakfast.add(new SlideModel(R.drawable.bananakheer,"केले की खीर रेसिपी",ScaleTypes.FIT));
            imageSliderofBreakfast.setImageList(listBreakfast);

        }

        //click button

//        vegbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this,VegFood.class));
//
//            }
//        });
//        nonvegbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this,Nonveg.class));
//            }
//        });

        ImageSlider imageSliderofNonVeg=findViewById(R.id.imagesliderofnonveg);
        imageSliderofNonVeg.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {
                startActivity(new Intent(MainActivity.this,Nonveg.class));
            }

            @Override
            public void doubleClick(int i) {

            }
        });

        ImageSlider imageSliderofVeg=findViewById(R.id.imagesliderofveg);
        imageSliderofVeg.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {
                startActivity(new Intent(MainActivity.this,VegFood.class));
            }

            @Override
            public void doubleClick(int i) {

            }
        });

        ImageSlider imageSliderofBreakfast=findViewById(R.id.imagesliderofbreakfast);
        imageSliderofBreakfast.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {
                startActivity(new Intent(MainActivity.this,Breakfast.class));

            }

            @Override
            public void doubleClick(int i) {

            }
        });




    }


    @Override
    public void onBackPressed() {

            finishAffinity();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.language,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       int id=item.getItemId();
       if (id==R.id.hindi){
           SharedPreferences sharedPreferences=getSharedPreferences("language",MODE_PRIVATE);
           SharedPreferences.Editor editor=sharedPreferences.edit();
           editor.putBoolean("type",true);
           editor.apply();
           startActivity(new Intent(MainActivity.this,MainActivity.class));
       }else {
           SharedPreferences sharedPreferences=getSharedPreferences("language",MODE_PRIVATE);
           SharedPreferences.Editor editor=sharedPreferences.edit();
           editor.putBoolean("type",false);
           editor.apply();
           startActivity(new Intent(MainActivity.this,MainActivity.class));
       }
        return true;
    }
}