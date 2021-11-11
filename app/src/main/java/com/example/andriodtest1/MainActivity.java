package com.example.andriodtest1;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.andriodtest1.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import androidx.appcompat.app.AlertDialog;
import android.widget.Toast;
import android.Manifest;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        builder=new AlertDialog.Builder(MainActivity.this);
        AlertDialog alertDialog=builder.create();
        alertDialog.setTitle("Permission check");

        int REQUEST_CODE = 2;
        if (PermissionUtility.HasPermisson(this, Manifest.permission.INTERNET)) {
            //如果已经拥有改权限
            Log.i("request","own");
            alertDialog.setMessage("already has internet permission");
        } else {
            //没有改权限，需要进行请求
            PermissionUtility.RequestPermission(this, Manifest.permission.INTERNET, REQUEST_CODE);
            alertDialog.setMessage("INTERNET permission requested.");
        }
        alertDialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }


    /** Called when the user touches the button */
    public void btnTest_Click(View view) {

        // Do something in response to button click
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(R.string.dialog1_message)
                .setTitle(R.string.dialog1_title);
       AlertDialog dialog = builder.create();
       dialog.show();

    }

    /** Called when the user touches the button */
    public void btnToast_Click(View view) {

        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

}