package com.example.test_libgdxintoandroid.Sprites.Ennemies;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Array;
import com.example.test_libgdxintoandroid.MyGdxGame;
import com.example.test_libgdxintoandroid.Screens.PlayScreen;
import  com.example.test_libgdxintoandroid.Sprites.MyGdx;

/**
 * Created by brentaureli on 9/14/15.
 */
public class Goomba extends Ennemy
{
    private float stateTime;
    private Animation<TextureRegion> walkAnimation;
    private Array<TextureRegion> frames;
    private TextureRegion goombaStand;
    private boolean setToDestroy;
    private boolean destroyed;
    //float angle;

    public Goomba(PlayScreen screen, float x, float y) {
        super(screen, x, y);
        frames = new Array<TextureRegion>();
        for(int frame = 0; frame < 2; frame++) {
            frames.add(new TextureRegion(screen.getAtlas().findRegion("goomba"), frame*16, 0, 16, 16));
        }
        walkAnimation = new Animation(0.4f, frames);
        stateTime = 0;

        setBounds(getX(), getY(), 16 / MyGdxGame.PPM, 16 / MyGdxGame.PPM);
        setToDestroy = false;
        destroyed = false;
        //angle = 0;
    }

    public void update(float dt){
        stateTime += dt;
        if(setToDestroy && !destroyed){
            world.destroyBody(b2body);
            destroyed = true;
            setRegion(new TextureRegion(screen.getAtlas().findRegion("goomba"), 32, 0, 16, 16));
            stateTime = 0;
        }
        else if(!destroyed) {
            b2body.setLinearVelocity(velocity);
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
            setRegion(walkAnimation.getKeyFrame(stateTime, true));
        }
    }

    @Override
    protected void defineEnnemy() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(getX(), getY());
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(6 / MyGdxGame.PPM);

        fdef.filter.categoryBits = MyGdxGame.ENNEMY_BIT;
        fdef.filter.maskBits = MyGdxGame.GROUND_BIT |
                MyGdxGame.COIN_BIT |
                MyGdxGame.BRICK_BIT |
                MyGdxGame.ENNEMY_BIT |
                MyGdxGame.OBJECT_BIT |
                MyGdxGame.MARIO_BIT;

        fdef.shape = shape;
        b2body.createFixture(fdef).setUserData(this);

        //Create the Head here:
        PolygonShape head = new PolygonShape();
        Vector2[] vertice = new Vector2[4];
        vertice[0] = new Vector2(-5, 8).scl(1 / MyGdxGame.PPM);
        vertice[1] = new Vector2(5, 8).scl(1 / MyGdxGame.PPM);
        vertice[2] = new Vector2(-3, 3).scl(1 / MyGdxGame.PPM);
        vertice[3] = new Vector2(3, 3).scl(1 / MyGdxGame.PPM);
        head.set(vertice);

        fdef.shape = head;
        fdef.restitution = 0.5f;
        fdef.filter.categoryBits = MyGdxGame.ENNEMY_HEAD_BIT;
        b2body.createFixture(fdef).setUserData(this);
    }

    public void draw(Batch batch){
        if(!destroyed || stateTime < 1)
            super.draw(batch);
    }

    @Override
    public void hitOnHead(MyGdx mario) {
        setToDestroy = true;
        MyGdxGame.manager.get("audio/sounds/stomp.wav", Sound.class).play();
    }

   /*@Override
    public void hitByEnemy(Enemy enemy) {
        if(enemy instanceof Turtle && ((Turtle) enemy).currentState == Turtle.State.MOVING_SHELL)
            setToDestroy = true;
        else
            reverseVelocity(true, false);
    }*/
}
