package com.example.finalproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

class MenuAdapter extends AdapterView<MenuAdapter.MenuViewHolder>  {

    private GradientDrawable mGradientDrawable;
    private ArrayList<Menu> mMenuData;
    private Context mContext;

    MenuAdapter(Context context, ArrayList<Menu> menuData) {
        super();
        this.mMenuData = menuData;
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
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MenuViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.list_item_menu, parent, false), mGradientDrawable);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {

        Menu currentMenu = mMenuData.get(position);

        holder.bindTo(currentMenu);

    }


    @Override
    public int getItemCount() {
        return mMenuData.size();
    }


    static class MenuViewHolder implements OnClickListener, Adapter {

        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mMenuImage;
        private Context mContext;
        private Menu mCurrentMenu;
        private GradientDrawable mGradientDrawable;

        MenuViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitle);
            mMenuImage = (ImageView)itemView.findViewById(R.id.menuImage);

            mContext = context;
            mGradientDrawable = gradientDrawable;

            itemView.setOnClickListener(this);
        }

        void bindTo(Menu currentSport){
            mTitleText.setText(currentSport.getTitle());
            mInfoText.setText(currentSport.getInfo());

            mCurrentMenu = currentSport;



            Glide.with(mContext).load(currentSport.
                    getImageResource()).placeholder(mGradientDrawable).into(mMenuImage);
        }

        @Override
        public void onClick(View view) {

            Intent detailIntent = Menu.starter(mContext, mCurrentMenu.getTitle(),
                    mCurrentMenu.getImageResource());

            mContext.startActivity(detailIntent);
        }
    }
}