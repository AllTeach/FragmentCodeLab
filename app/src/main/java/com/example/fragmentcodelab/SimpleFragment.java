package com.example.fragmentcodelab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleFragment extends Fragment {

    private static final int YES = 0;
    private static final int NO = 1;

    public SimpleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment.

        final View rootView =
                inflater.inflate(R.layout.fragment_simple, container, false);
        final RadioGroup radioGroup = rootView.findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            View radioButton = radioGroup.findViewById(checkedId);
            int index = radioGroup.indexOfChild(radioButton);
            TextView textView =
                    rootView.findViewById(R.id.fragment_header);
            switch (index) {
                case YES: // User chose "Yes."
                  //  textView.setText(R.string.yes_message);
                    Toast.makeText(getContext(),"Like!",Toast.LENGTH_SHORT).show();
                    break;
                case NO: // User chose "No."
              //      textView.setText(R.string.no_message);
                    Toast.makeText(getContext(),"Not Quite!",Toast.LENGTH_SHORT).show();
                    break;
                default: // No choice made.
                    // Do nothing.
                    break;
            }
        });

    // Return the View for the fragment's UI.
        return rootView;
    }
}