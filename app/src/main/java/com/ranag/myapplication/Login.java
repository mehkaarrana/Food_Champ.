package com.ranag.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.airbnb.lottie.LottieAnimationView;

public class Login extends AppCompatActivity {
    Button getstart;
    EditText name;
    Uri uri;
    LottieAnimationView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        view=findViewById(R.id.addimages);
        name=findViewById(R.id.edname);
        getstart=findViewById(R.id.getstartbtn);
        getstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().isEmpty()){
                    name.setError("Please fill your Name..");
                }else {
                    SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putBoolean("check",true);
                    editor.apply();
                    startActivity(new Intent(Login.this,MainActivity.class));
                }
            }
        });
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent getpic=new Intent(Intent.ACTION_PICK);
//                getpic.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(getpic,1);
//            }
//        });
    }

    @Override
    public void onBackPressed() {

        finishAffinity();
    }
    //    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(resultCode==RESULT_OK){
//            view.setImageURI(data.getData());
//            uri=data.getData();
//        }
//    }
}
