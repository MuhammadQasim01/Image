package com.example.emmy.image;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mNames= new ArrayList<>();
    private ArrayList<String>mImageUrls=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initImageBitmaps();
    }

    private void initImageBitmaps()
    {
        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Rose");
        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Rose");
        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Rose");
        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Rose");
        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Rose");
        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Rose");




        initRecyclerView();


    }

    private void initRecyclerView(){
        RecyclerView recyclerView=findViewById(R.id.RecyclerView);
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(this,mNames,mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
