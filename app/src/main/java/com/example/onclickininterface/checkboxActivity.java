package com.example.onclickininterface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class checkboxActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        recyclerView = findViewById(R.id.recveiw);
        recyclerView.setHasFixedSize(true);
        MyAdapter adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);

    }
}
class MyAdapter extends RecyclerView.Adapter<MyAdapter.exViewHolder>{


    int pos = -1;

    @NonNull
    @Override
    public exViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new exViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull exViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if(position==pos){
            holder.checkBox.setChecked(true);

        }else
            holder.checkBox.setChecked(false);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos = position;
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class exViewHolder extends RecyclerView.ViewHolder {
        RadioButton checkBox;
        public exViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkbox);
        }
        //ksdjfisdifjs
    }
}