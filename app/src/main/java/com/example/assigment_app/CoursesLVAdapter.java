package com.example.assigment_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CoursesLVAdapter extends ArrayAdapter<Datamodel> {

    // constructor for our list view adapter.
    public CoursesLVAdapter(@NonNull Context context, ArrayList<Datamodel> dataModalArrayList) {
        super(context, 0, dataModalArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // below line is use to inflate the
        // layout for our item of list view.
        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.purchase, parent, false);
        }

        // after inflating an item of listview item
        // we are getting data from array list inside
        // our modal class.
        Datamodel dataModal = getItem(position);

        // initializing our UI components of list view item.
        TextView nameTV = listitemView.findViewById(R.id.idTVtext);
        ImageView courseIV = listitemView.findViewById(R.id.idIVimage);
        TextView priceTv = listitemView.findViewById(R.id.idTVtext1);

        // after initializing our items we are
        // setting data to our view.
        // below line is use to set data to our text view.
        nameTV.setText(dataModal.getName());
        priceTv.setText(dataModal.getPrice());

        // in below line we are using Picasso to
        // load image from URL in our Image VIew.
        Picasso.get().load(dataModal.getImgUrl()).into(courseIV);

        // below line is use to add item click listener
        // for our item of list view.
        listitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on the item click on our list view.
                // we are displaying a toast message.
                Toast.makeText(getContext(), "Item added to cart : " + dataModal.getName(), Toast.LENGTH_SHORT).show();
                Intent checkout = new Intent(getContext(),checkout.class);
                checkout.putExtra("name",dataModal.getName());
                checkout.putExtra("price",dataModal.getPrice());
                checkout.putExtra("url",dataModal.getImgUrl());
                getContext().startActivity(checkout);;
            }
        });
        return listitemView;
    }
}
