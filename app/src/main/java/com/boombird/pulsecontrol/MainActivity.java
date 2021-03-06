package com.boombird.pulsecontrol;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.boombird.pulsecontrol.PNLControl.BasePNLControl;
import com.boombird.pulsecontrol.PNLControl.PNLControlBuilder;

public class MainActivity extends Activity
{
    private static final String CLASS = MainActivity.class.getSimpleName();

    BasePNLControl nlpc;

    private void init()
    {
        Log.i(CLASS, "initializing");

        // create a CControl
        nlpc = PNLControlBuilder.getInstance(this.getContentResolver());

        // debug info
        TextView view = (TextView) findViewById(R.id.textView);
        view.setText("inEmulator: " + PNLControlBuilder.inEmulator() + ", " +
                             "Build.Product: " + Build.PRODUCT);

        // set the initial toggle state
        Switch mySwitch = (Switch) findViewById(R.id.switch1);
        mySwitch.setChecked(nlpc.isEnabled());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    protected void onResume()
    {
        super.onResume();

        Log.i(CLASS, "onResume()");

        init();
    }

    public void onPNLToggle(View view)
    {
        nlpc.toggle();

        String text = "Pulse Notification Light " + (nlpc.isEnabled() ? "ENABLED" : "DISABLED");
        this.showSimpleToast(text);
    }

    private void showSimpleToast(String text)
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // TODO: check of hij ook echt uit/aan gaat
    // TODO: app maken die elke twee seconden een pulse geeft
}
