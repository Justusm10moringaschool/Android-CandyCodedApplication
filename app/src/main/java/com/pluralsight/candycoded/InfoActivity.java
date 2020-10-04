package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.net.URI;

public class InfoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);


    }

    // *** Task 2 to launch the google Maps Activity

    public void createMapIntent(View view) {
        Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW,
            Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801"));
        mapIntent.setPackage("com.google.android.apps.maps");

        if (mapIntent.resolveActivity(getPackageManager()) != null){
            startActivity(mapIntent);
        }

    }


    // *** close to launch google maps activity + in textview xml we added android:cliackable true and android:onclick create map intent

    // *** task 3 to Launch phone Activity

    public void createPhoneIntent(View view){
         Intent phoneIntent = new Intent(android.content.Intent.ACTION_DIAL);
         phoneIntent.setData(Uri.parse("tel:0123456789"));
         startActivity(phoneIntent);

    }

    // ***
}
