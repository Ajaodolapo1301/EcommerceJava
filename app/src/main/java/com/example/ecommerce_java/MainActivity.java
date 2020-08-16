package com.example.ecommerce_java;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.ecommerce_java.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
  private  DrawerLayout drawerLayout;

  private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        activityMainBinding  = DataBindingUtil.setContentView(this, R.layout.activity_main);

        drawerLayout = activityMainBinding.drawerLayout;
       actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

       drawerLayout.addDrawerListener(actionBarDrawerToggle);
       actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return  true;
        }

        int menuItemThatWasSelected = item.getItemId();

        if (menuItemThatWasSelected == R.id.cart) {
            Context context = MainActivity.this;
            Toast.makeText(context, "Cart clicked", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        getMenuInflater().inflate(R.menu.cart, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
