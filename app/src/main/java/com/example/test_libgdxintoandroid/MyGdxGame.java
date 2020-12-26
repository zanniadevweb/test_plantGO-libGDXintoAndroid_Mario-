package com.example.test_libgdxintoandroid;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.backends.lwjgl.audio.Ogg;
import com.badlogic.gdx.backends.lwjgl.audio.Wav;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.example.test_libgdxintoandroid.Screens.PlayScreen;
//import com.example.test_libgdxintoandroid.Screens.MenuScreen;

import java.util.HashMap;

public class MyGdxGame extends Game {

    public static final int V_WIDTH = 400;
    public static final int V_HEIGHT = 208;
    public static final float PPM = 100;

    public static final short GROUND_BIT = 1;
    public static final short MARIO_BIT = 2;
    public static final short BRICK_BIT = 4;
    public static final short COIN_BIT = 8;
    public static final short DESTROYED_BIT = 16;
    public static final short OBJECT_BIT = 32;
    public static final short ENNEMY_BIT = 64;

    public SpriteBatch batch;

    /* WARNING Using AssetManager in a static way can cause issues, especially on Android.
Instead you may want to pass around Assetmanager to those the classes that need it.
We will use it in the static context to save time for now. */
    public static AssetManager manager;

    @Override
    public void create () {
        batch = new SpriteBatch();
        manager = new AssetManager();
        manager.load("audio/music/mario_music.ogg", Music.class);
        manager.load("audio/sounds/coin.wav", Sound.class);
        manager.load("audio/sounds/bump.wav", Sound.class);
        manager.load("audio/sounds/breakblock.wav", Sound.class);
        /*manager.load("audio/sounds/powerup_spawn.wav", Sound.class);
        manager.load("audio/sounds/powerup.wav", Sound.class);
        manager.load("audio/sounds/powerdown.wav", Sound.class);
        manager.load("audio/sounds/stomp.wav", Sound.class);
        manager.load("audio/sounds/mariodie.wav", Sound.class);*/

        manager.finishLoading();

        setScreen(new PlayScreen(this));
    }

    @Override
    public void dispose() {
        super.dispose();
        manager.dispose();
        batch.dispose();
    }

    @Override
    public void render ()
    {
        super.render();
    }
}
