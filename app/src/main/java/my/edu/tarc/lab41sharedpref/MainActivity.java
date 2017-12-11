package my.edu.tarc.lab41sharedpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imageViewProfile;
    TextView textViewName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imageViewProfile = (ImageView)findViewById(R.id.imageViewProfile);
        textViewName = (TextView)findViewById(R.id.textViewName);
    }

    @Override
    protected void onResume(){

        super.onResume();
        loadPref();
    }

    private void loadPref() {
        SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String name = mySharedPreferences.getString("name_text", getString(R.string.pref_default_display_name));
        String gender = mySharedPreferences.getString("gender_list", getString(R.string.pref_title_gender));

        if(gender.equals("Male")){
            textViewName.setText(getResources().getString(R.string.your_name)+"Mr. ");
            imageViewProfile.setImageResource(R.drawable.male);
        }
        else if(gender.equals("Female")){
            textViewName.setText(getResources().getString(R.string.your_name)+"Ms. ");
            imageViewProfile.setImageResource(R.drawable.female);
        }
        else {
            imageViewProfile.setImageResource(R.drawable.profile);
            textViewName.setText(getResources().getString(R.string.your_name));
        }
        textViewName.append(name);
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
            startActivity(new Intent(this,SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
