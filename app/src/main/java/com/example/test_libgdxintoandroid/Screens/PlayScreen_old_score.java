package com.example.test_libgdxintoandroid.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.example.test_libgdxintoandroid.MyGdxGame;
import com.example.test_libgdxintoandroid.Scenes.Hud;
/*import com.example.test_libgdxintoandroid.Sprites.MyGdx;
import com.example.test_libgdxintoandroid.Tools.B2WorldCreator;
import com.example.test_libgdxintoandroid.Tools.WorldContactListener;*/

//import com.example.test_libgdxintoandroid.Sprites.Enemies.Enemy;

/**
 * Created by brentaureli on 8/14/15.
 */
public class PlayScreen_old_score implements Screen{
    //Reference to our Game, used to set Screens
    private MyGdxGame game;

    /*private TextureAtlas atlas;
    public static boolean alreadyDestroyed = false;*/

    //basic playscreen variables
    private OrthographicCamera gamecam;
    private Viewport gamePort;

    private Hud hud;

    //Tiled map variables
/*****************************************/// TUTORIEL PART 5 //
    /*private TmxMapLoader maploader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;*/
    /**
     * @param game***************************************/// TUTORIEL PART 5 //

    //Box2d variables
    /*private World world;
    private Box2DDebugRenderer b2dr;
    private B2WorldCreator creator;*/

    //sprites
    //private MyGdx player;

    //private Music music;

    // private Array<Item> items;
    //private LinkedBlockingQueue<ItemDef> itemsToSpawn;


    public PlayScreen_old_score(MyGdxGame game){
        //atlas = new TextureAtlas("Mario_and_Enemies.pack");
        this.game = game;

        //create cam used to follow mario through cam world
        gamecam = new OrthographicCamera();

        //create a FitViewport to maintain virtual aspect ratio despite screen size
        gamePort = new FitViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, gamecam);
        //gamePort = new FitViewport(MyGdxGame.V_WIDTH / MyGdxGame.PPM, MyGdxGame.V_HEIGHT / MyGdxGame.PPM, gamecam);
        //gamePort = new FitViewport(800, 480, gamecam);

        //create our game HUD for scores/timers/level info
        hud = new Hud(game.batch);

        //Load our map and setup our map renderer
        /*****************************************/// TUTORIEL PART 5 /
        /*maploader = new TmxMapLoader();
        map = maploader.load("level1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);*/
        /*****************************************/// TUTORIEL PART 5 /
        //renderer = new OrthogonalTiledMapRenderer(map, 1  / MyGdxGame.PPM);

        //initially set our gamcam to be centered correctly at the start of of map
        /*****************************************/// TUTORIEL PART 5 /
        //gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);
        /*****************************************/// TUTORIEL PART 5 /

        //create our Box2D world, setting no gravity in X, -10 gravity in Y, and allow bodies to sleep
        /*world = new World(new Vector2(0, -10), true);
        //allows for debug lines of our box2d world.
        b2dr = new Box2DDebugRenderer();

        creator = new B2WorldCreator(this);

        //create mario in our game world
        //player = new MyGdx(this);

        world.setContactListener(new WorldContactListener());*/

        /*music = MyGdxGame.manager.get("audio/music/mario_music.ogg", Music.class);
        music.setLooping(true);
        music.setVolume(0.3f);
        music.play();*/

        /*items = new Array<Item>();
        itemsToSpawn = new LinkedBlockingQueue<ItemDef>();*/


    }

    /*public void spawnItem(ItemDef idef){
        itemsToSpawn.add(idef);
    }*/


    public void handleSpawningItems(){
    /*    if(!itemsToSpawn.isEmpty()){
            ItemDef idef = itemsToSpawn.poll();
            if(idef.type == Mushroom.class){
                items.add(new Mushroom(this, idef.position.x, idef.position.y));
            }
        }*/
    }


    /*public TextureAtlas getAtlas(){
        return atlas;
    }*/

    @Override
    public void show() {
    }

    public void handleInput(float dt){
        /*****************************************/// TUTORIEL PART 5 /
            /*if (Gdx.input.isTouched(Input.Keys.UP)) {
                gamecam.position.x += 100 * dt;
            }*/
        /*****************************************/// TUTORIEL PART 5 /


        //control our player using immediate impulses
        /*if(player.currentState != MyGdx.State.DEAD) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.UP))
                player.jump();
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.b2body.getLinearVelocity().x <= 2)
                player.b2body.applyLinearImpulse(new Vector2(0.1f, 0), player.b2body.getWorldCenter(), true);
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.b2body.getLinearVelocity().x >= -2)
                player.b2body.applyLinearImpulse(new Vector2(-0.1f, 0), player.b2body.getWorldCenter(), true);
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
                player.fire();
        }*/

    }

    public void update(float dt){
        //handle user input first
        /*****************************************/// TUTORIEL PART 5 /
        //handleInput(dt);
        /*****************************************/// TUTORIEL PART 5 /

        //handleSpawningItems();

        //takes 1 step in the physics simulation(60 times per second)
        //world.step(1 / 60f, 6, 2);

        //player.update(dt);
        /*for(Enemy enemy : creator.getEnemies()) {
            enemy.update(dt);
            if(enemy.getX() < player.getX() + 224 / MyGdxGame.PPM) {
                enemy.b2body.setActive(true);
            }
        }*/

        /*for(Item item : items)
            item.update(dt);*/

        //hud.update(dt);

        //attach our gamecam to our players.x coordinate
        /*if(player.currentState != MyGdx.State.DEAD) {
            gamecam.position.x = player.b2body.getPosition().x;
        }*/

        //update our gamecam with correct coordinates after changes
        /*****************************************/// TUTORIEL PART 5 /
        //gamecam.update();
        /*****************************************/// TUTORIEL PART 5 /
        //tell our renderer to draw only what our camera can see in our game world.
        /*****************************************/// TUTORIEL PART 5 /
        //renderer.setView(gamecam);
        /*****************************************/// TUTORIEL PART 5 /

    }


    @Override
    public void render(float delta) {
        //separate our update logic from render
        /*****************************************/// TUTORIEL PART 5 /
        //update(delta);
        /*****************************************/// TUTORIEL PART 5 /

        //Clear the game screen with Black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //render our game map
        /*****************************************/// TUTORIEL PART 5 /
        //renderer.render();
        /*****************************************/// TUTORIEL PART 5 /

        //renderer our Box2DDebugLines
        //b2dr.render(world, gamecam.combined);

        //player.draw(game.batch);
        /*for (Enemy enemy : creator.getEnemies())
            enemy.draw(game.batch);
        for (Item item : items)
            item.draw(game.batch);*/

        //Set our batch to now draw what the Hud camera sees.
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
/*
        if(gameOver()){
            game.setScreen(new GameOverScreen(game));
            dispose();
        }*/

    }
/*
    public boolean gameOver(){
        if(player.currentState == MyGdx.State.DEAD && player.getStateTimer() > 3){
            return true;
        }
        return false;
    }*/

    @Override
    public void resize(int width, int height) {
        //updated our game viewport
        gamePort.update(width,height);

    }

    /*public TiledMap getMap(){
        return map;
    }
    public World getWorld(){
        return world;
    }*/

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        //dispose of all our opened resources
        /*map.dispose();
        renderer.dispose();
        world.dispose();
        b2dr.dispose();
        hud.dispose();*/
    }

   /* public Hud getHud(){ return hud; }
}*/

}