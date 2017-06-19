package com.example.harishmurari.curries.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.harishmurari.curries.MyData;
import com.example.harishmurari.curries.R;

/**
 * Created by harishmurari on 6/7/2017.
 */

public class MainMenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_activity);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.main_menu_activity_listitem, MyData.mainmenuArray);

        GridView gridView = (GridView) findViewById(R.id.main_menu_list);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                launchSelectedActivity(position);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()) {
            case R.id.ic_action_shopping_cart:
                launchCartActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void launchCartActivity(){
        Intent i = new Intent(MainMenuActivity.this, CartActivity.class);
        startActivity(i);
    }

    public void launchSelectedActivity(int position) {
        Intent intent = null;
        switch (position) {
            case MyData.VEGETARIAN:
                intent = new Intent(MainMenuActivity.this, VegetarianActivity.class);
                break;
            case MyData.NON_VEGETARIAN:
                intent = new Intent(MainMenuActivity.this, NonVegetarianActivity.class);
                break;
            case MyData.WHITE_RICE:
                intent = new Intent(MainMenuActivity.this, WhiteRiceActivity.class);
                break;
            case MyData.LUNCH_BOX:
                intent = new Intent(MainMenuActivity.this, LunchBoxActivity.class);
                break;
        }
        startActivity(intent);
    }
}
