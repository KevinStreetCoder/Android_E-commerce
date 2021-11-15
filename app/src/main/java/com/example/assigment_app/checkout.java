package com.example.assigment_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class checkout extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        btn = findViewById(R.id.button1);;
        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        String price = extras.getString("price");
        String url = extras.getString("url");
        TextView name1 = (TextView) findViewById(R.id.checkout);
        TextView price1 = (TextView) findViewById(R.id.checkout1);
        ImageView url1= (ImageView) findViewById(R.id.checkout2);
        name1.setText(name);
        price1.setText(price);
        Picasso.get().load(url).into(url1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(checkout.this,"Bought item",Toast.LENGTH_LONG).show();
            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.action_register:
                        Intent intentz = new Intent(getApplicationContext(),register.class);
                        startActivity(intentz);
                        break;
                    case R.id.action_purchase:
                        Intent intentzp = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intentzp);
                    case R.id.action_checkout:
                        break;
                    case R.id.action_logout:
                        Intent intent = new Intent(getApplicationContext(),signInActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.action_profile:
                        Intent intentp = new Intent(getApplicationContext(),profile.class);
                        startActivity(intentp);
                        break;
                }
                return true;
            }
        });
    }

}