package ir.saaz742.saaz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri myPhoneNumber = Uri.parse("tel:1234512345");

        Button callMeButton = findViewById(R.id.button);
        callMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, myPhoneNumber);
                startActivity(intent);
            }
        });

        SwitchMaterial darkModeSwitch = findViewById(R.id.switch1);
        darkModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                else
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });

    }
}