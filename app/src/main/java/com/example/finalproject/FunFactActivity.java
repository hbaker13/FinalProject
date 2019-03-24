package com.example.finalproject;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class FunFactActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<FunFact> mFunFactData;
    private FunFactAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funfact);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        mFunFactData = new ArrayList<>();

        mAdapter = new FunFactAdapter(this, mFunFactData);
        mRecyclerView.setAdapter(mAdapter);

        initializeData();

        int swipeDirs;
        if(gridColumnCount > 1){
            swipeDirs = 0;
        } else {
            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        }


        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback
                (ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN
                        | ItemTouchHelper.UP, swipeDirs) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {

                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                Collections.swap(mFunFactData, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                mFunFactData.remove(viewHolder.getAdapterPosition());

                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        helper.attachToRecyclerView(mRecyclerView);
    }

    private void initializeData() {
        String[] funFactList = getResources().getStringArray(R.array.funfact_titles);
        String[] funFactInfo = getResources().getStringArray(R.array.funfact_info);
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.funfact_images);
        mFunFactData.clear();


        for(int i=0; i<funFactList.length; i++){
            mFunFactData.add(new FunFact(funFactList[i], funFactInfo[i],
                    sportsImageResources.getResourceId(i,0)));
        }

        sportsImageResources.recycle();

        mAdapter.notifyDataSetChanged();
    }

    public void resetFunFacts(View view) {
        initializeData();
    }
}