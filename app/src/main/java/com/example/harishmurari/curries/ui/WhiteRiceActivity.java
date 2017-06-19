package com.example.harishmurari.curries.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.widget.Toast;

import com.example.harishmurari.curries.MyData;
import com.example.harishmurari.curries.R;
import com.example.harishmurari.curries.adapters.Adapter;
import com.example.harishmurari.curries.model.CurryItem;

import java.util.ArrayList;

/**
 * Created by harishmurari on 6/7/2017.
 */

public class WhiteRiceActivity extends AppCompatActivity implements Adapter.OnSelectedCurry{

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<CurryItem> data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setTitle("White Rice");

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<>();
        for (int i = 0; i < MyData.whiteRiceArray.length; i++) {
            data.add(new CurryItem(
                    MyData.whiteRiceArray[i],
                    MyData.riceprice[i],
                    MyData.riceDrawableArray[i]
            ));
        }

        adapter = new Adapter(this, this, data);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClickedCurry(CurryItem data) {
        Toast.makeText(this, "selected : "+" name = " + data.getCurryName(), Toast.LENGTH_SHORT).show();
    }
}
