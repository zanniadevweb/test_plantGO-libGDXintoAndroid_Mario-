package com.example.test_libgdxintoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.example.test_libgdxintoandroid.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) { // On sait que le bouton active cette méthode grâce au "OnClick paramétéré à 'SendMessage' dans les propriétés de cet élément dans 'activity_main.xml' "
        Intent intent = new Intent(MainActivity.this, AndroidLauncher.class);
        new DelayAction(5); // Il semble que ça crashe si on ne met pas un délai avant d'exécuter le processus (logique car on passe d'un système à un autre)
        MainActivity.this.startActivity(intent);
    }
}
