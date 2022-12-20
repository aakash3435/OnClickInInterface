package com.example.onclickininterface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycleriew);

        recyclerView.setAdapter(new MyAdapter(new ItemClickListenr() {
            @Override
            public void Clicked(int pos) {
                Toast.makeText(getApplicationContext(), pos + "Ite d", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void profile() {
                Toast.makeText(getApplicationContext(),  "Profile", Toast.LENGTH_SHORT).show();
            }
        }));


    }

    class MyAdapter extends RecyclerView.Adapter<MyDataHolder> {
        ItemClickListenr listenr;

        public MyAdapter(ItemClickListenr listenr) {
            this.listenr = listenr;
        }

        @NonNull
        @Override
        public MyDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyDataHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false));
        }


        @Override
        public void onBindViewHolder(@NonNull MyDataHolder holder, int position) {
            ((MyDataHolder)holder).bind(position,listenr);

//            holder.imageView.setOnClickListener(view -> listenr.profile());
            holder.itemView.setOnClickListener(view -> listenr.Clicked(position));
        }

        @Override
        public int getItemCount() {
            return 10;
        }




    }

    interface ItemClickListenr {
        void Clicked(int pos);
        void profile();
    }


}