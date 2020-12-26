package com.example.test_libgdxintoandroid.Tools;

//import com.example.test_libgdxintoandroid.Sprites.Ennemies.Enemy;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.example.test_libgdxintoandroid.MyGdxGame;
import com.example.test_libgdxintoandroid.Sprites.Ennemies.Ennemy;
import com.example.test_libgdxintoandroid.Sprites.MyGdx;
import com.example.test_libgdxintoandroid.Sprites.TileObjects.InteractiveTileObject;


/**
 * Created by brentaureli on 9/4/15.
 */
public class WorldContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();

        int cDef = fixA.getFilterData().categoryBits | fixB.getFilterData().categoryBits;

        if(fixA.getUserData() == "head" ||fixB.getUserData() == "head") {
            Fixture head = fixA.getUserData() == "head" ? fixA : fixB;
            Fixture object = head == fixA ? fixB : fixA;

            if (object.getUserData() != null && InteractiveTileObject.class.isAssignableFrom(object.getUserData().getClass())) {
                ((InteractiveTileObject) object.getUserData()).onHeadHit();
            }
        }

        switch (cDef){
            /*case MyGdxGame.MARIO_HEAD_BIT | MyGdxGame.BRICK_BIT:
            case MyGdxGame.MARIO_HEAD_BIT | MyGdxGame.COIN_BIT:
                if(fixA.getFilterData().categoryBits == MyGdxGame.MARIO_HEAD_BIT)
                    ((InteractiveTileObject) fixB.getUserData()).onHeadHit((Mario) fixA.getUserData());
                else
                    ((InteractiveTileObject) fixA.getUserData()).onHeadHit((Mario) fixB.getUserData());
                break;*/
            case MyGdxGame.ENNEMY_HEAD_BIT | MyGdxGame.MARIO_BIT:
                if(fixA.getFilterData().categoryBits == MyGdxGame.ENNEMY_HEAD_BIT)
                    ((Ennemy)fixA.getUserData()).hitOnHead((MyGdx) fixB.getUserData());
                else
                    ((Ennemy)fixB.getUserData()).hitOnHead((MyGdx) fixA.getUserData());
                //break;
            /*case MyGdxGame.ENNEMY_BIT | MyGdxGame.OBJECT_BIT:
                if(fixA.getFilterData().categoryBits == MyGdxGame.ENNEMY_HEAD_BIT)
                    ((Ennemy)fixA.getUserData()).reverseVelocity(true, false);
                else
                    ((Ennemy)fixB.getUserData()).reverseVelocity(true, false);
                break;
            case MyGdxGame.MARIO_BIT | MyGdxGame.ENNEMY_BIT:
                if(fixA.getFilterData().categoryBits == MyGdxGame.MARIO_BIT)
                    ((MyGdx) fixA.getUserData()).hit((Ennemy)fixB.getUserData());
                else
                    ((MyGdx) fixB.getUserData()).hit((Ennemy)fixA.getUserData());
                break;
            case MyGdxGame.ENNEMY_BIT | MyGdxGame.ENNEMY_BIT:
                ((Ennemy)fixA.getUserData()).hitByEnemy((Ennemy)fixB.getUserData());
                ((Ennemy)fixB.getUserData()).hitByEnemy((Ennemy)fixA.getUserData());
                break;*/
            /*case MyGdxGame.ITEM_BIT | MyGdxGame.OBJECT_BIT:
                if(fixA.getFilterData().categoryBits == MyGdxGame.ITEM_BIT)
                    ((Item)fixA.getUserData()).reverseVelocity(true, false);
                else
                    ((Item)fixB.getUserData()).reverseVelocity(true, false);
                break;
            case MyGdxGame.ITEM_BIT | MyGdxGame.MARIO_BIT:
                if(fixA.getFilterData().categoryBits == MyGdxGame.ITEM_BIT)
                    ((Item)fixA.getUserData()).use((MyGdx) fixB.getUserData());
                else
                    ((Item)fixB.getUserData()).use((MyGdx) fixA.getUserData());
                break;
            case MyGdxGame.FIREBALL_BIT | MyGdxGame.OBJECT_BIT:
                if(fixA.getFilterData().categoryBits == MyGdxGame.FIREBALL_BIT)
                    ((FireBall)fixA.getUserData()).setToDestroy();
                else
                    ((FireBall)fixB.getUserData()).setToDestroy();
                break;*/
    }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }

}