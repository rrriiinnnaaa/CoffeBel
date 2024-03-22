package com.example.coffe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.coffe.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private Button btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        btnEnter = findViewById(R.id.btnEnter);
        btnEnter.setOnClickListener(this::GetStarted);


    }

    private void GetStarted(View view) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

    }
    public Fragment getItem(int position)
    {

        if(position == 0)
        {
            Home tab1 = new Home();
            return tab1;
        }
        if(position == 1)
        {
            Dashboard tab2 = new Dashboard();
            return tab2;
        }
        if(position == 2)
        {
            Notifications tab3 = new Notifications();
            return tab3;
        }
        if(position == 3)
        {
            Four tab4 = new Four();
            return tab4;
        }
        return null;
    }
}