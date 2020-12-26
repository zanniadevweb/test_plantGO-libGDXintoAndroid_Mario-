package com.example.test_libgdxintoandroid.Sprites.Ennemies;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.example.test_libgdxintoandroid.Screens.PlayScreen;
import com.example.test_libgdxintoandroid.Sprites.MyGdx;

/**
 * Created by brentaureli on 9/14/15.
 */
public abstract class Ennemy extends Sprite {
    protected World world;
    protected PlayScreen screen;
    public Body b2body;
    //public Vector2 velocity;

    public Ennemy(PlayScreen screen, float x, float y){
        this.world = screen.getWorld();
        this.screen = screen;
        setPosition(x, y);
        defineEnnemy();
        /*velocity = new Vector2(-1, -2);
        b2body.setActive(false);*/
    }

    protected abstract void defineEnnemy();
    //public abstract void update(float dt);
    public abstract void hitOnHead(MyGdx mario);
    /*public abstract void hitByEnemy(Ennemy enemy);

    public void reverseVelocity(boolean x, boolean y){
        if(x)
            velocity.x = -velocity.x;
        if(y)
            velocity.y = -velocity.y;

           */
}
