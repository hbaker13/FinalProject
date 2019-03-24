package com.example.finalproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

class FunFactAdapter extends RecyclerView.Adapter<FunFactAdapter.FunFactViewHolder>  {

    private GradientDrawable mGradientDrawable;
    private ArrayList<FunFact> mFunFactData;
    private Context mContext;

    FunFactAdapter(Context context, ArrayList<FunFact> funFactData) {
        this.mFunFactData = funFactData;
        this.mContext = context;

        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        Drawable drawable = ContextCompat.getDrawable
                (mContext,R.drawable.img_badminton);
        if(drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }


    @Override
    public FunFactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FunFactViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.list_item_facts, parent, false), mGradientDrawable);
    }

    @Override
    public void onBindViewHolder(FunFactViewHolder holder, int position) {

        FunFact currentFunFact = mFunFactData.get(position);

        holder.bindTo(currentFunFact);

    }


    @Override
    public int getItemCount() {
        return mFunFactData.size();
    }


    static class FunFactViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mFunFactImage;
        private Context mContext;
        private FunFact mCurrentFunFact;
        private GradientDrawable mGradientDrawable;

        FunFactViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitle);
            mFunFactImage = (ImageView)itemView.findViewById(R.id.funfactImage);

            mContext = context;
            mGradientDrawable = gradientDrawable;

            itemView.setOnClickListener(this);
        }

        void bindTo(FunFact currentFunFact){
            mTitleText.setText(currentFunFact.getTitle());
            mInfoText.setText(currentFunFact.getInfo());

            mCurrentFunFact = currentFunFact;



            Glide.with(mContext).load(currentFunFact.
                    getImageResource()).placeholder(mGradientDrawable).into(mFunFactImage);
        }

        @Override
        public void onClick(View view) {

            Intent detailIntent = FunFact.starter(mContext, mCurrentFunFact.getTitle(),
                    mCurrentFunFact.getImageResource());

            mContext.startActivity(detailIntent);
        }
    }
}