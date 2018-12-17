package com.example.emmy.image;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> mImageNames= new ArrayList<>();
    private ArrayList<String> mImage= new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<String> mImageNames, ArrayList<String> mImage) {
        this.mImageNames = mImageNames;
        this.mImage = mImage;
        this.mContext = mContext;
    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent , int ViewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        ViewHolder Holder=new ViewHolder(view);
        return Holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG,"onBindViewHolder: Called.");
        Glide.with(mContext)
                .asBitmap()
                .load(mImage.get(position))
                .into(holder.image);
        holder.imagename.setText(mImageNames.get(position));
        holder.parntlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked on:" +mImageNames.get(position));
                Toast.makeText(mContext, mImageNames.get(position),Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView imagename;
        RelativeLayout parntlayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image =itemView.findViewById(R.id.Image);
            imagename=itemView.findViewById(R.id.image_name);
            parntlayout=itemView.findViewById(R.id.parent_layout);
        }
    }
}
