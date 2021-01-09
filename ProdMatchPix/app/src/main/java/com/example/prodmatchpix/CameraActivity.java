package com.example.prodmatchpix;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CameraActivity extends AppCompatActivity {

   private ImageView [] the_images;

   private ArrayList<String> night_king;
   private ArrayList<String> darth_vader;
   private ArrayList<String> the_joker;
   private ArrayList<String> agent_smith;


   private final int ARRAY_SIZE = 4;
   private int index = 0;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_camera);

      the_images = new ImageView[ARRAY_SIZE];

      if(ContextCompat.checkSelfPermission(CameraActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
      {
         ActivityCompat.requestPermissions(CameraActivity.this, new String[]{Manifest.permission.CAMERA},100);
      }


      the_images[0] = findViewById(R.id.pic_button_0);
      the_images[1] = findViewById(R.id.pic_button_1);
      the_images[2] = findViewById(R.id.pic_button_2);
      the_images[3] = findViewById(R.id.pic_button_3);

      the_images[0].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"night king",Toast.LENGTH_LONG).show();

            nightKingImages();
            nextIntent(night_king);

         }
      });

      the_images[1].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"vader images passed !!!!",Toast.LENGTH_LONG).show();

            darthVaderImages();
            nextIntent(darth_vader);

         }
      });

      the_images[2].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"joker",Toast.LENGTH_LONG).show();
            nextIntent(null);

         }
      });

      the_images[3].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"smith",Toast.LENGTH_LONG).show();
            nextIntent(null);

         }
      });

   } // end onCreate

   private void nextIntent(ArrayList<String> the_array_list)
   {
      ArrayList <String> inteny_array = the_array_list;

      Intent intent = new Intent(CameraActivity.this, MainActivity.class);
      intent.putStringArrayListExtra("ARRAY", inteny_array);
      startActivity(intent);

      //kills previous activity
      finish();
   }

   private void nightKingImages()
   {
      night_king = new ArrayList<>();

      night_king.add("https://i.pinimg.com/originals/9f/d6/c9/9fd6c90880a70e8f035f9438cc5ebfcc.png");
      night_king.add("https://i.pinimg.com/564x/61/93/10/619310c9dc117e7395c6cd6570de3825--fantasy-creatures-mythical-creatures.jpg");
      night_king.add("https://endgameofthrones.files.wordpress.com/2015/06/ice_dragon_by_ironshod.jpg");
      night_king.add("https://media.vanityfair.com/photos/5cc652251d6b8739f44c2c3d/2:3/w_640,h_960,c_limit/arya-kills-the-night-king.jpg");
      night_king.add("https://thumbs.worthpoint.com/zoom/images4/1/0217/16/white-walker-figure-game-thrones-dark_1_9bea091726499fa14d1386db97ac8283.jpg");
      night_king.add("https://pbs.twimg.com/media/Efp7qdLWoAExhT6.jpg");

   }

   private void darthVaderImages()
   {
      darth_vader = new ArrayList<>();

      darth_vader.add("https://i.pinimg.com/originals/93/8b/aa/938baa3827baa626932ea43e30f38bad.jpg");
      darth_vader.add("https://i.pinimg.com/originals/40/32/0a/40320a152f589f158e040a1330ca25c1.jpg");
      darth_vader.add("https://i.pinimg.com/originals/26/77/f0/2677f034c4b14ccb92fd202bd5ca0142.jpg");
      darth_vader.add("https://assets.catawiki.nl/assets/2018/11/19/2/b/5/2b504e0f-3f12-49fb-9baf-f5bbac954706.jpg");
      darth_vader.add("https://as1.ftcdn.net/jpg/02/98/94/30/500_F_298943057_SB3Nr8jZ5v2zlYsNkBf4fp54UAjrk3d2.jpg");
      darth_vader.add("https://c4.wallpaperflare.com/wallpaper/866/389/184/star-wars-darth-vader-minimalism-lightsaber-wallpaper-preview.jpg");
   }

   private void theJokerImages()
   {

   }

   private void agentSmithImages()
   {

   }


}
