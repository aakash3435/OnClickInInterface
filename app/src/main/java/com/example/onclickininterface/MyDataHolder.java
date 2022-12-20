package com.example.onclickininterface;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyDataHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    public MyDataHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image);
    }

    public void bind(int pos, MainActivity.ItemClickListenr listenr){
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listenr.profile();
            }
        });
    }
}
