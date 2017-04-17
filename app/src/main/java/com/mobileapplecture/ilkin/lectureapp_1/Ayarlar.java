package com.mobileapplecture.ilkin.lectureapp_1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;


//This is just a test line to test github v2.1
public class Ayarlar extends AppCompatActivity {

    Spinner spin_difficulty;

    EditText txt_highest_score;
    EditText txt_friend_count;
    EditText txt_enemy_count;
    EditText txt_level;

    Button btn_inc_level;
    Button btn_dcr_level;
    Button btn_save;
    Button btn_load;

    public static final String myPref = "myPref";

    //default values
    public static final int default_difficulty = 0;
    public static final int default_highest_score = 100;
    public static final int default_friend_count = 10;
    public static final int default_enemy_count = 10;
    public static final int default_level_value = 1;

    // key values
    public static final String key_difficulty = "key_difficulty";
    public static final String key_highest_score = "key_score";
    public static final String key_friend_count = "key_friend";
    public static final String key_enemy_count = "key_enemy";
    public static final String key_level_value = "key_level";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayarlar);

        spin_difficulty = (Spinner) findViewById(R.id.spin_difficulty);
        txt_highest_score = (EditText) findViewById(R.id.txt_HighestScore);
        txt_friend_count = (EditText) findViewById(R.id.txt_friends);
        txt_enemy_count = (EditText) findViewById(R.id.txt_enemy);
        txt_level = (EditText) findViewById(R.id.txt_level);

        btn_inc_level = (Button) findViewById(R.id.btn_increase_level);
        btn_dcr_level = (Button) findViewById(R.id.btn_decrease_level);

        btn_save = (Button) findViewById(R.id.btn_save);
        btn_load = (Button) findViewById(R.id.btn_load);

        // ****initialize data from shared pref if available else load default***
        SharedPreferences sharedPref = getSharedPreferences(myPref, Context.MODE_PRIVATE);
        Log.e("Button", "Initialize");
        // reading values from shared preferences
        spin_difficulty.setSelection(sharedPref.getInt(key_difficulty, default_difficulty));
        txt_highest_score.setText(String.valueOf(sharedPref.getInt(key_highest_score, default_highest_score)));
        txt_friend_count.setText(String.valueOf(sharedPref.getInt(key_friend_count, default_friend_count)));
        txt_enemy_count.setText(String.valueOf(sharedPref.getInt(key_enemy_count, default_enemy_count)));
        txt_level.setText(String.valueOf(sharedPref.getInt(key_level_value, default_level_value)));


        btn_inc_level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cur_level = Integer.parseInt(String.valueOf(txt_level.getText()));

                if (cur_level == 100)
                    txt_level.setText(String.valueOf(cur_level));

                else
                    txt_level.setText(String.valueOf(cur_level + 1));
            }
        });

        btn_dcr_level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cur_level = Integer.parseInt(String.valueOf(txt_level.getText()));
                if (cur_level == 0) {
                    txt_level.setText(String.valueOf(cur_level));
                } else

                    txt_level.setText(String.valueOf(cur_level - 1));
            }
        });


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // TODO: suraya bi goz at

//                SharedPreferences sharedPref = getSharedPreferences(myPref, Context.MODE_PRIVATE);
                SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();

                // writing values to the shared preferences
                editor.putInt(key_difficulty, spin_difficulty.getSelectedItemPosition());
                editor.putInt(key_highest_score, Integer.parseInt(String.valueOf(txt_highest_score.getText())));
                editor.putInt(key_friend_count, Integer.parseInt(String.valueOf(txt_friend_count.getText())));
                editor.putInt(key_enemy_count, Integer.parseInt(String.valueOf(txt_enemy_count.getText())));
                editor.putInt(key_level_value, Integer.parseInt(String.valueOf(txt_level.getText())));

                /*apply() was added in 2.3, it commits without returning a boolean indicating success or failure.
                 commit() returns true if the save works, false otherwise.
                 apply() was added as the Android dev team noticed that almost no one took notice of the return value,
                 so apply is faster as it is asynchronous.*/

                editor.apply();

                Toast.makeText(Ayarlar.this, "Save successful", Toast.LENGTH_SHORT).show();
            }
        });


        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPref = getSharedPreferences(myPref, Context.MODE_PRIVATE);

                // reading values from shared preferences
                spin_difficulty.setSelection(sharedPref.getInt(key_difficulty, default_difficulty));
                txt_highest_score.setText(String.valueOf(sharedPref.getInt(key_highest_score, default_highest_score)));
                txt_friend_count.setText(String.valueOf(sharedPref.getInt(key_friend_count, default_friend_count)));
                txt_enemy_count.setText(String.valueOf(sharedPref.getInt(key_enemy_count, default_enemy_count)));
                txt_level.setText(String.valueOf(sharedPref.getInt(key_level_value, default_level_value)));
                Toast.makeText(Ayarlar.this, "Values successfully loaded", Toast.LENGTH_SHORT).show();
            }
        });


        txt_friend_count.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.e("Button", "start value: " + start + " ,before value: " + before + " ,count value: " + count);
                SharedPreferences sharedPref = getSharedPreferences(myPref, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                if (!String.valueOf(txt_friend_count.getText()).equals("")) {
                    editor.putInt(key_friend_count, Integer.parseInt(String.valueOf(txt_friend_count.getText())));
                    if (editor.commit()) {
                        Toast.makeText(Ayarlar.this, "Friend count was updated", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Ayarlar.this, "Can't update friend count", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
