package com.example.test_libgdxintoandroid.Sprites.TileObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.example.test_libgdxintoandroid.MyGdxGame;
import com.example.test_libgdxintoandroid.Scenes.Hud;
import com.example.test_libgdxintoandroid.Screens.PlayScreen;
import com.badlogic.gdx.physics.box2d.World;
import com.example.test_libgdxintoandroid.Screens.PlayScreen;
import com.example.test_libgdxintoandroid.Sprites.MyGdx;

/**
 * Created by brentaureli on 8/28/15.
 */

public class Brick extends InteractiveTileObject {
    public Brick(PlayScreen screen, Rectangle bounds){
        super(screen, bounds);
        fixture.setUserData(this);
        setCategoryFilter(MyGdxGame.BRICK_BIT);
    }

    @Override
    public void onHeadHit() {
        /*if(mario.isBig()) {
            setCategoryFilter(MarioBros.DESTROYED_BIT);
            getCell().setTile(null);
            Hud.addScore(200);
            MarioBros.manager.get("audio/sounds/breakblock.wav", Sound.class).play();
        }
        MarioBros.manager.get("audio/sounds/bump.wav", Sound.class).play();*/
        Gdx.app.log("brick", "Collision");
        setCategoryFilter(MyGdxGame.DESTROYED_BIT);
        getCell().setTile(null);
        Hud.addScore(200);
        MyGdxGame.manager.get("audio/sounds/breakblock.wav", Sound.class).play();
    }

}


/*
    @Override
    public void onHeadHit(Mario mario) {
        if(mario.isBig()) {
            setCategoryFilter(MarioBros.DESTROYED_BIT);
            getCell().setTile(null);
            Hud.addScore(200);
            MarioBros.manager.get("audio/sounds/breakblock.wav", Sound.class).play();
        }
        MarioBros.manager.get("audio/sounds/bump.wav", Sound.class).play();
    }
}*/
