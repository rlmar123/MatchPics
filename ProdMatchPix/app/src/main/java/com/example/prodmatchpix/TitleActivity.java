package com.example.prodmatchpix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class TitleActivity extends AppCompatActivity {

   private TextView fadingTextView;
   private Button start_button;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_title);


      fadingTextView = (TextView) findViewById(R.id.the_text);
//      start_button = (Button) findViewById(R.id.start_button);
      fadingTextView.setText("MovieMatch!");

      Animation aniFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim);
      fadingTextView.startAnimation(aniFade);

      Handler handler = new Handler();

      handler.postDelayed(new Runnable() {
         @Override
         public void run()
         {
            Intent camera_intent = new Intent(TitleActivity.this, CameraActivity.class);
            startActivity(camera_intent);

            //kills previous activity
            finish();
         }
      }, 5000);
   }
}
