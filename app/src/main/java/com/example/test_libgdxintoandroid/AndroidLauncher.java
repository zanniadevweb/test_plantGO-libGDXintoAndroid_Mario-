package com.example.test_libgdxintoandroid;

import android.content.Intent;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;

public class AndroidLauncher extends AndroidApplication {
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        initialize(new MyGdxGame(), config);
    }

    //@Override
    public void onStartActivityA() {
        Intent intent = new Intent(AndroidLauncher.this, MainActivity.class);
        new DelayAction(5); // Il semble que ça crashe si on ne met pas un délai avant d'exécuter le processus (logique car on passe d'un système à un autre)
        AndroidLauncher.this.startActivity(intent);
    }

}
