package com.asem.market;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AddProduct extends AppCompatActivity {

    static int SELECT_PHOTO = 1;
    static ImageView choseImage;
    static Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        FloatingActionButton doneFab = (FloatingActionButton) findViewById(R.id.done_fab);
        ImageView choseImage = (ImageView) findViewById(R.id.chose_image);

        // Chose Image from the gallery
        choseImage.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, SELECT_PHOTO);
            }
        }));

        // Save the new product
        doneFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inputActivity = new Intent(AddProduct.this, MainActivity.class);
                startActivity(inputActivity);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SELECT_PHOTO && requestCode == RESULT_OK && data != null && data.getData() != null) {
            uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                choseImage.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}