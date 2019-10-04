package openfloodai.github.io.openfloodai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    private boolean isDark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.changeTheme:
            {
               PreferenceManager
                        .getDefaultSharedPreferences(this)
                        .edit()
                        .putBoolean("theme", !isDark)
                        .apply();
                recreate();
                break;
            }

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu1) {

        MenuItem darkIcon = menu1.findItem(R.id.changeTheme);

        darkIcon.setIcon(isDark ? R.drawable.ic_theme_night : R.drawable.ic_theme_day);


        return true;

    }


    @Override
    public void setTheme(int resId) {
        isDark = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("theme",false);
        if(isDark)
        super.setTheme(R.style.AppThemeDark);
        else
            super.setTheme(R.style.AppTheme);
    }

    public void openLinkedIn(View view) {
      openUrl(Constants.LINKEDIN);
    }

    public void openFacebook(View view) {
        openUrl(Constants.FACEBOOK);

    }

    public void openTwitter(View view) {
        openUrl(Constants.TWITTER);

    }

    public void openGithub(View view) {
        openUrl(Constants.GITHUB);

    }

    private void openUrl(String url)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
}
