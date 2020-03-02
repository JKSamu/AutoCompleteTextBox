package com.samu.autocompletetextbox;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AutoCompleteTextView textView = findViewById(R.id.autoCompleteTextView);
        // Get the string array
        String[] countries = getResources().getStringArray(R.array.country_array);
        // Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);
        textView.setAdapter(adapter);

        final MultiAutoCompleteTextView multiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteTextView);
        multiAutoCompleteTextView.setAdapter(adapter);

        multiAutoCompleteTextView.setThreshold(1);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        Button button2 = findViewById(R.id.button2);
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               String text = "Entered text:" + " " + multiAutoCompleteTextView.getText();
                                               Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                                           }
                                       });

        };


                Button button = findViewById(R.id.button);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //String text = getString(R.string.entered_text) + " " + textView.getText();

                    Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_SHORT).show();
                }
            });
        }


        final CheckedTextView checkedTextView = findViewById(R.id.checkedTextView);

        if (checkedTextView != null) {
            checkedTextView.setChecked(false);
            checkedTextView.setCheckMarkDrawable(android.R.drawable.checkbox_off_background);

            checkedTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkedTextView.setChecked(!checkedTextView.isChecked());
                    checkedTextView.setCheckMarkDrawable(checkedTextView.isChecked() ? android.R.drawable.checkbox_on_background : android.R.drawable.checkbox_off_background);

                    String msg = getString(R.string.pre_msg) + " " + (checkedTextView.isChecked() ? getString(R.string.checked) : getString(R.string.unchecked));
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}











