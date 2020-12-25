/*package com.example.test_libgdxintoandroid.Screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {
    private Stack<MenuState> states;

    public GameStateManager(){
        states = new Stack<>();
    }

    public void push(MenuState state){
        states.push(state);
    }

    public void pop(){
        states.pop();
    }

    public void set(MenuState state){
        states.pop();
        states.push(state);
    }

    public void update(float dt){
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }
}*/
