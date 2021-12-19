package com.example.fragmentcodelab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private boolean isFragmentDisplayed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initViews();
    }

    private void initViews() {
        mButton = findViewById(R.id.button);

    }

    public void openFragment(View view) {
        if(isFragmentDisplayed) {
            closeFragment();
            return;
        }

        // Get the FragmentManager and start a transaction.
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();

        // Add fragment to the back stack
        // back button triggers fragment transaction
        fragmentTransaction.add(R.id.fragment_container,
                SimpleFragment.class,null)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();


        // Update the Button text.
        mButton.setText("close fragment");
    // Set boolean flag to indicate fragment is open.
        isFragmentDisplayed = true;

    }
    public void closeFragment() {
        // Get the FragmentManager.
        FragmentManager fragmentManager = getSupportFragmentManager();
        // Check to see if the fragment is already showing.
        SimpleFragment simpleFragment = (SimpleFragment) fragmentManager
                .findFragmentById(R.id.fragment_container);
        if (simpleFragment != null) {
            // Create and commit the transaction to remove the fragment.
            FragmentTransaction fragmentTransaction =
                    fragmentManager.beginTransaction();
            fragmentTransaction.remove(simpleFragment).commit();



        }
        // Update the Button text.
        mButton.setText("open fragment");
        // Set boolean flag to indicate fragment is closed.
        isFragmentDisplayed = false;
    }

    public void moveToAnotherExample(View view) {
        Intent intent = new Intent(this,AnotherFragmentExample.class);
        startActivity(intent);
    }

    public void moveToTabbedActivity(View view) {
        Intent intent = new Intent(this,TabFragmentActivity.class);
        startActivity(intent);
    }

    public void moveToSwipeActivity(View view)
    {
        Intent intent = new Intent(this,SwipeNavActivity.class);
        startActivity(intent);

    }
}