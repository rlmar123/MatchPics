package com.example.prodmatchpix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class MainActivity extends AppCompatActivity {

   private  static final long START_TIME = 15000;

   private TextView timer_text;
   private TextView score_text;

   private final int ARRAY_SIZE = 12;
   private int index = 0;

   // Data Structures
   private ImageView[] memory_images;
   private ArrayList<ImageView> comparison_list;
   private HashMap<ImageView, Integer> the_map;
   private ArrayList<Integer> drawable_images;
   private String [] image_url;
   private ArrayList<String> game_images;

   // for the timer
   private CountDownTimer countDownTimer;
   private boolean reset;
   private long timeLeft = START_TIME;

   // FOR TEST ONLY !!!! DELETE WHEN DONE !!!
   private Button time_button;
   private Button reset_button;

   // test
   private String my_url = "https://i.pinimg.com/originals/9f/d6/c9/9fd6c90880a70e8f035f9438cc5ebfcc.png";

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      memory_images = new ImageView[ARRAY_SIZE];
      drawable_images = new ArrayList<>();
      the_map = new HashMap<>();
      comparison_list = new ArrayList<>();


      // add images to array list
  //    LoadImage loadImage = new LoadImage();
    //  for(int i = 0; i < 6; i++)
  //   loadImage.execute(my_url);

      drawable_images.add(R.drawable.girafee);
      drawable_images.add(R.drawable.horse);
      drawable_images.add(R.drawable.dragon);
      drawable_images.add(R.drawable.monkey);
      drawable_images.add(R.drawable.pony);
      drawable_images.add(R.drawable.tiger);

      Intent receive_intent = getIntent();
      game_images = receive_intent.getStringArrayListExtra("ARRAY");

      Log.d("from main","here" + "It works !!!!!!! " + game_images.get(5));

      memory_images[0] = findViewById(R.id.image_0);
      memory_images[0].setTag(1);

      memory_images[1] = findViewById(R.id.image_1);
      memory_images[1].setTag(1);

      memory_images[2] = findViewById(R.id.image_2);
      memory_images[2].setTag(1);

      memory_images[3] = findViewById(R.id.image_3);
      memory_images[3].setTag(1);

      memory_images[4] = findViewById(R.id.image_4);
      memory_images[4].setTag(1);

      memory_images[5] = findViewById(R.id.image_5);
      memory_images[5].setTag(1);

      memory_images[6] = findViewById(R.id.image_6);
      memory_images[6].setTag(1);

      memory_images[7] = findViewById(R.id.image_7);
      memory_images[7].setTag(1);

      memory_images[8] = findViewById(R.id.image_8);
      memory_images[8].setTag(1);

      memory_images[9] = findViewById(R.id.image_9);
      memory_images[9].setTag(1);

      memory_images[10] = findViewById(R.id.image_10);
      memory_images[10].setTag(1);

      memory_images[11] = findViewById(R.id.image_11);
      memory_images[11].setTag(1);

      Collections.shuffle(drawable_images);
      for(int i = 0; i < 6; i++)
         the_map.put(memory_images[i], drawable_images.get(i));

      Collections.shuffle(drawable_images);
      for(int i = 0; i < 6; i++)
         the_map.put(memory_images[i + 6], drawable_images.get(i));

      memory_images[0].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_1",Toast.LENGTH_LONG).show();
            changeImage(memory_images[0]);
         }
      });


      memory_images[1].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_2",Toast.LENGTH_LONG).show();
            changeImage(memory_images[1]);
            // add images to array list
        //    LoadImage loadImage = new LoadImage();
          //  loadImage.execute(my_url);

         }
      });

      memory_images[2].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_2",Toast.LENGTH_LONG).show();
            changeImage(memory_images[2]);
         }
      });

      memory_images[3].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_3",Toast.LENGTH_LONG).show();
            changeImage(memory_images[3]);
         }
      });

      memory_images[4].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_4",Toast.LENGTH_LONG).show();
            changeImage(memory_images[4]);
         }
      });

      memory_images[5].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_5",Toast.LENGTH_LONG).show();
            changeImage(memory_images[5]);
         }
      });

      memory_images[6].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_6",Toast.LENGTH_LONG).show();
            changeImage(memory_images[6]);
         }
      });

      memory_images[7].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_7",Toast.LENGTH_LONG).show();
            changeImage(memory_images[7]);
         }
      });

      memory_images[8].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_8",Toast.LENGTH_LONG).show();
            changeImage(memory_images[8]);
         }
      });

      memory_images[9].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_9",Toast.LENGTH_LONG).show();
            changeImage(memory_images[9]);
         }
      });

      memory_images[10].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_10",Toast.LENGTH_LONG).show();
            changeImage(memory_images[10]);
         }
      });

      memory_images[11].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_11",Toast.LENGTH_LONG).show();
            changeImage(memory_images[11]);
         }
      });



   } // end onCreate

   private void changeImage(ImageView image)
   {
      if(image.getTag().equals(1))
      {
         Integer temp = the_map.get(image);
         image.setImageResource(temp);
         image.setTag(2);

         // add button to arraylist for comparison
          comparison_list.add(image);
         Toast.makeText(getApplicationContext(),"Button added",Toast.LENGTH_LONG).show();


         if(comparison_list.size() == 2)
         {

            Integer test_one = the_map.get(comparison_list.get(0));
            Integer test_two = the_map.get(comparison_list.get(1));

            if(test_one == test_two)
            {
               comparison_list.get(0).setImageResource(R.drawable.ic_launcher_foreground);
               comparison_list.get(1).setImageResource(R.drawable.ic_launcher_foreground);

               comparison_list.get(0).setImageResource(R.drawable.ic_launcher_foreground);
               comparison_list.get(1).setImageResource(R.drawable.ic_launcher_foreground);

               // replace the images in the map for both matching buttpns
               the_map.replace(comparison_list.get(0), R.drawable.ic_launcher_foreground);
               the_map.replace(comparison_list.get(1), R.drawable.ic_launcher_foreground);

               comparison_list.get(0).setTag(1);
               comparison_list.get(1).setTag(1);

               comparison_list.get(0).setClickable(false);
               comparison_list.get(1).setClickable(false);

               // clear out all items
               comparison_list.clear();

               Toast.makeText(getApplicationContext(),"Match and REMOVED !!!!" + comparison_list.size(),Toast.LENGTH_LONG).show();
            }

            // Images do not match
            else
            {
               Handler handler = new Handler();

               handler.postDelayed(new Runnable() {
                  @Override
                  public void run() {

                     comparison_list.get(0).setImageResource(R.drawable.ic_launcher_background);
                     comparison_list.get(1).setImageResource(R.drawable.ic_launcher_background);

                     comparison_list.get(0).setTag(1);
                     comparison_list.get(1).setTag(1);
                     comparison_list.clear();
                  }
               }, 250);

               Toast.makeText(getApplicationContext(),"DO NOT Match and CLEARED !!!!",Toast.LENGTH_LONG).show();
            }
         }

      }
      // image cannot be seen
      else if(image.getTag().equals(2))
      {
         image.setImageResource(R.drawable.ic_launcher_background);
         image.setTag(1);

         //remove button from arraylist
         int index = comparison_list.indexOf(image);
         comparison_list.remove(index);

         Toast.makeText(getApplicationContext(),"Button removed " + comparison_list.size(),Toast.LENGTH_LONG).show();
      }

   }

   private class LoadImage extends AsyncTask<String, Void, Bitmap>
   {
      ImageView temp;
      public LoadImage()
      {
       //  this.temp = change_image;
      }

      @Override
      protected Bitmap doInBackground(String... strings) {
         String uriLink = strings[0];
         Bitmap bitmap = null;

         try {
            InputStream inputStream = new java.net.URL(uriLink).openStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
         } catch (IOException e) {
            e.printStackTrace();
         }

         return bitmap;
      }

      @Override
      protected void onPostExecute(Bitmap bitmap)
      {
         // store bitmap images here
         memory_images[1].setImageBitmap(bitmap);
      }

   } // end LosdImage

} // end MainActivity
