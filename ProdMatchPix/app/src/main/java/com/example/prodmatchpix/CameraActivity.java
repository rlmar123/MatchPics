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

            theJokerImages();
            nextIntent(the_joker);

         }
      });

      the_images[3].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"smith",Toast.LENGTH_LONG).show();

            agentSmithImages();
            nextIntent(agent_smith);

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
      night_king.add("https://i.pinimg.com/originals/c3/ce/ee/c3ceeed00946bcb9593b6bad1d119a05.jpg");
      night_king.add("https://pbs.twimg.com/media/Efp7qdLWoAExhT6.jpg");

      // back of card and final images
      night_king.add("https://i.pinimg.com/originals/56/81/01/568101f22c536628a9d81d70e88d56e5.jpg");
      night_king.add("https://i.pinimg.com/originals/69/a0/2e/69a02e323c6d27d35dd12d82e593e992.jpg");
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

      // back of card and final images
      darth_vader.add("https://www.disneyexperience.com/news/wp-content/uploads/2020/01/swpc_darkside-back.jpg");
      darth_vader.add("https://cdna.artstation.com/p/assets/covers/images/014/072/332/large/andreas-bazylewski-mg-5602w.jpg?1542325280");
   }

   private void theJokerImages()
   {
      the_joker = new ArrayList<>();

      the_joker.add("https://i.pinimg.com/originals/cc/79/c8/cc79c8bf4a681ca31db4fe1b57fb600a.jpg");
      the_joker.add("https://static.wikia.nocookie.net/batman/images/f/f9/Heath_Ledger_as_the_Joker.JPG/revision/latest?cb=20090903145508");
      the_joker.add("https://img.artpal.com/52599/68-18-1-29-21-47-18m.jpg");
      the_joker.add("https://i.pinimg.com/736x/e8/bf/2d/e8bf2d0357dbc88b0e65ad90304affaf.jpg");
      the_joker.add("https://static.wikia.nocookie.net/great-characters/images/b/b7/Joker_%28Batman_1989%29.png/revision/latest?cb=20200411140124");
      the_joker.add("https://img.mensxp.com/media/content/2020/May/Sacrifices-Heath-Ledger-Made-To-Become-The-Joker600_5eaff513cf8ce_600x900.jpeg");

      // back of card and final images
      the_joker.add("https://i.pinimg.com/originals/86/0f/85/860f85a3d92be8fe5735be34ab72bda2.jpg");
      the_joker.add("https://images-na.ssl-images-amazon.com/images/I/61B3hio353L._AC_SL1031_.jpg");
   }

   private void agentSmithImages()
   {
      agent_smith = new ArrayList<>();

      agent_smith.add("https://i.pinimg.com/236x/02/64/f8/0264f889036562dc6f5ff31b5343850d--agent-smith-greatest-villains.jpg");
      agent_smith.add("https://i.pinimg.com/originals/f3/fa/d9/f3fad92b5085821ac68f99119c1bbf27.jpg");
      agent_smith.add("https://lthumb.lisimg.com/771/9762771.jpg?width=411&sharpen=true");
      agent_smith.add("https://i.pinimg.com/originals/af/71/bf/af71bf6fad19226f8a08e710e03f7d07.jpg");
      agent_smith.add("https://i.pinimg.com/236x/36/65/8c/36658ce63cebf1ab876ad26f58c67682--matrix-quotes-agent-smith.jpg");
      agent_smith.add("https://static.wikia.nocookie.net/matrix/images/4/4d/Agent-smith-the-matrix-movie-hd-wallpaper-2880x1800-4710.png/revision/latest?cb=20140504013834");

      // back of card and final images
      agent_smith.add("https://static.wikia.nocookie.net/matrix/images/b/b7/MatrixDigitalRain.PNG/revision/latest?cb=20080915035642");
      agent_smith.add("https://e7.pngegg.com/pngimages/793/314/png-clipart-the-matrix-path-of-neo-agent-smith-trinity-morpheus-matrix-software-black-film-thumbnail.png");

   }


}
