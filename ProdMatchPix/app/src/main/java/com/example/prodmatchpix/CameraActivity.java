package com.example.prodmatchpix;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class CameraActivity extends AppCompatActivity {

   private Button camera_button;

   private ImageView [] the_images;
   private Bitmap [] stored_images;

   private final int ARRAY_SIZE = 6;
   private int index = 0;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_camera);

      the_images = new ImageView[ARRAY_SIZE];
      stored_images = new Bitmap[ARRAY_SIZE];

      if(ContextCompat.checkSelfPermission(CameraActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
      {
         ActivityCompat.requestPermissions(CameraActivity.this, new String[]{Manifest.permission.CAMERA},100);
      }

      camera_button = findViewById(R.id.test_button);

      the_images[0] = findViewById(R.id.pic_button_0);
   //   the_buttons[0].setTag(1);

      the_images[1] = findViewById(R.id.pic_button_1);
//      im_1.setTag(1);

      the_images[2] = findViewById(R.id.pic_button_2);
  //    im_2.setTag(1);

      the_images[3] = findViewById(R.id.pic_button_3);
  //    im_3.setTag(1);

      the_images[4] = findViewById(R.id.pic_button_4);
  //    im_4.setTag(1);

      the_images[5] = findViewById(R.id.pic_button_5);
   //   im_5.setTag(1);

      camera_button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            //open the camera
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 100);
         }
      });


   } // end onCreate

   @Override
   public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
   {
      if(requestCode == 100)
      {
         if(index == 6)
            index = 0;

         // get the captured image
         Bitmap captureImage = (Bitmap) data.getExtras().get("data");

         // set the image to the image view
         the_images[index].setImageBitmap(captureImage);
         stored_images[index] = captureImage;

         index++;
      }
   }
}
