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

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

public class MainActivity extends AppCompatActivity {

   private final int ARRAY_SIZE = 12;
   private int index = 0;
   private Bitmap bitmapImage = null;
   // Data Structures
   private ImageView[] memory_images;
   private ArrayList<ImageView> comparison_list;
   private HashMap<ImageView, String>the_map;
   private ArrayList<String> url_strings;

   // for the timer
   private static final long START_TIME = 15000;
   private CountDownTimer countDownTimer;
   private TextView countdown_text;

   private Button timer_button;
   private Button reset_button;
   private boolean reset;
   private long timeLeft = START_TIME;

   private TextView timer_text;
   private TextView score_text;

   // final images
   private String last_image;
   private String final_images;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      // receive data from previous intent
      Intent receive_intent = getIntent();
      url_strings = receive_intent.getStringArrayListExtra("ARRAY");

      // data structures are initialized
      memory_images = new ImageView[ARRAY_SIZE];
      the_map = new HashMap<>();
      comparison_list = new ArrayList<>();

      countdown_text = findViewById(R.id.timer_text);
      timer_button = findViewById(R.id.time_button);
      reset_button = findViewById(R.id.reset_button);

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

      // get back of card images and final image
      final_images = url_strings.get(7);
      url_strings.remove(7);

      last_image = url_strings.get(6);
      url_strings.remove(6);

      Collections.shuffle(url_strings); //
      for(int i = 0; i < url_strings.size(); i++)
         the_map.put(memory_images[i], url_strings.get(i)); //

      Collections.shuffle(url_strings); //
      for(int i = 0; i < url_strings.size(); i++)
         the_map.put(memory_images[i + 6], url_strings.get(i)); //


      // load back card images
      for(int i = 0; i < memory_images.length; i++)
      {
         Picasso.get().load(last_image).into(memory_images[i]);
      }
// THIS WORKS !!!!!!!!!!
      Picasso.get()
              .load("https://cdna.artstation.com/p/assets/covers/images/014/072/332/large/andreas-bazylewski-mg-5602w.jpg?1542325280")
              .into(new Target() {
                 @Override
                 public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                    bitmapImage = bitmap;

                 }

                 @Override
                 public void onBitmapFailed(Exception e, Drawable errorDrawable) {

                 }


                 @Override
                 public void onPrepareLoad(Drawable placeHolderDrawable) {

                 }
              });

      memory_images[0].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_1",Toast.LENGTH_LONG).show();
            changeImage(memory_images[0]);
           // memory_images[0].setImageBitmap(bitmapImage);
         }
      });

      memory_images[1].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_2",Toast.LENGTH_LONG).show();
            changeImage(memory_images[1]);
          //  memory_images[1].setImageBitmap(bitmapImage);
         }
      });

      memory_images[2].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_2",Toast.LENGTH_LONG).show();
            changeImage(memory_images[2]);
        //    memory_images[2].setImageBitmap(bitmapImage);
         }
      });

      memory_images[3].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_3",Toast.LENGTH_LONG).show();
            changeImage(memory_images[3]);


         //   memory_images[3].setImageBitmap(bitmapImage);
         }
      });

      memory_images[4].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_4",Toast.LENGTH_LONG).show();
            changeImage(memory_images[4]);

         //   memory_images[4].setImageBitmap(bitmapImage);
         }
      });

      memory_images[5].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_5",Toast.LENGTH_LONG).show();
            changeImage(memory_images[5]);

            // memory_images[5].setImageBitmap(bitmapImage);
         }
      });

      memory_images[6].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_6",Toast.LENGTH_LONG).show();
            changeImage(memory_images[6]);

            //  memory_images[6].setImageBitmap(bitmapImage);
         }
      });

      memory_images[7].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_7",Toast.LENGTH_LONG).show();
            changeImage(memory_images[7]);

            // memory_images[7].setImageBitmap(bitmapImage);
         }
      });

      memory_images[8].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_8",Toast.LENGTH_LONG).show();
            changeImage(memory_images[8]);

            // memory_images[8].setImageBitmap(bitmapImage);
         }
      });

      memory_images[9].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_9",Toast.LENGTH_LONG).show();
            changeImage(memory_images[9]);

            // memory_images[9].setImageBitmap(bitmapImage);
         }
      });

      memory_images[10].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_10",Toast.LENGTH_LONG).show();
            changeImage(memory_images[10]);

          //  memory_images[10].setImageBitmap(bitmapImage);
         }
      });

      memory_images[11].setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"im_11",Toast.LENGTH_LONG).show();
            changeImage(memory_images[11]);

           // memory_images[11].setImageBitmap(bitmapImage);
         }
      });

      timer_button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

            if(reset)
            {
               pauseTImer();
            }

            else
            {
               startTImer();
            }


         }
      });

      reset_button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

            resetTimer();
         }
      });

      updateCountdown();


   } // end onCreate

   private void changeImage(ImageView image)
   {
      if(image.getTag().equals(1))
      {
         String temp_url = the_map.get(image); // BITMAP
         Picasso.get().load(temp_url).into(image);
         image.setTag(2);

         // add button to arraylist for comparison
         comparison_list.add(image);
         Toast.makeText(getApplicationContext(),"Button added",Toast.LENGTH_LONG).show();


         if(comparison_list.size() == 2)
         {

            String test_one = the_map.get(comparison_list.get(0));
            String test_two = the_map.get(comparison_list.get(1));


            if(Objects.equals(test_one, test_two)) // strings are equal
            {
               // set Images on the screen
               Picasso.get().load(final_images).into(comparison_list.get(0));
               Picasso.get().load(final_images).into(comparison_list.get(1));

               // replace the images in the map for both matching buttpns
               the_map.replace(comparison_list.get(0),last_image);
               the_map.replace(comparison_list.get(1), last_image);

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

               Picasso.get().load(last_image).into(comparison_list.get(0));
               Picasso.get().load(last_image).into(comparison_list.get(1));

               comparison_list.get(0).setTag(1);
               comparison_list.get(1).setTag(1);
               comparison_list.clear();
                }
           }, 250);

               Toast.makeText(getApplicationContext(),"DO NOT Match and CLEARED !!!!",Toast.LENGTH_LONG).show();
            }
         }

      } // outer if

      // go back to green back
      else if(image.getTag().equals(2))
      {
         Picasso.get().load(last_image).into(image);
         image.setTag(1);

         //remove button from arraylist
         int index = comparison_list.indexOf(image);
         comparison_list.remove(index);

         Toast.makeText(getApplicationContext(),"Button removed " + comparison_list.size(),Toast.LENGTH_LONG).show();
      }

   }






   private void pauseTImer()
   {
      countDownTimer.cancel();
      reset = false;
      timer_button.setText("STart");
      reset_button.setVisibility(View.VISIBLE);


   }

   private void resetTimer()
   {
      timeLeft = START_TIME;
      updateCountdown();
      reset_button.setVisibility(View.INVISIBLE);
      timer_button.setVisibility(View.VISIBLE);

   }

   private void startTImer()
   {
      countDownTimer = new CountDownTimer(timeLeft, 1000)
      {
         @Override
         public void onTick(long millisUntilFinish)
         {
            timeLeft = millisUntilFinish;
            updateCountdown();
         }

         @Override
         public void onFinish()
         {
            reset = false;
            timer_button.setText("STyrt");
            timer_button.setVisibility(View.INVISIBLE);
            reset_button.setVisibility(View.VISIBLE);
         }

      }.start();

      reset = true;
      timer_button.setText("pause");
      reset_button.setVisibility(View.INVISIBLE);
   }

   private void updateCountdown()
   {
      int munutes = (int) (timeLeft / 1000) / 60;
      int seconds = (int) (timeLeft / 1000) % 60;

      String time_left_format = String.format(Locale.getDefault(),"%02d:%02d", munutes, seconds);
      countdown_text.setText(time_left_format);
   }

} // end MainActivity





