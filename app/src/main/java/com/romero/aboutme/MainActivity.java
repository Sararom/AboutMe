package com.romero.aboutme;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    public void process(View v){
        Intent sendIntent = null, chooser =null;

        Uri imageUri = Uri.parse("android.resource://com.romero.aboutme/drawable/"+R.drawable.profilepic);


        sendIntent= new Intent(Intent.ACTION_SEND);
        sendIntent.setType("image/*");
        sendIntent.putExtra(Intent.EXTRA_STREAM,imageUri);
        sendIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Nombre: "+((TextView)findViewById(R.id.name)).getText().toString()+
                "\nTitulo: "+((TextView)findViewById(R.id.career)).getText().toString()+
                "\nFacebook: "+((TextView)findViewById(R.id.fbuser)).getText().toString()+
                "\nGithub: "+((TextView)findViewById(R.id.ghuser)).getText().toString()+
                "\nCelular: "+((TextView)findViewById(R.id.cellp)).getText().toString()+
                "\nEmail: "+((TextView)findViewById(R.id.emailt)).getText().toString());

        chooser=Intent.createChooser(sendIntent,"Share Aboutme");
        startActivity(chooser);
    }



}
