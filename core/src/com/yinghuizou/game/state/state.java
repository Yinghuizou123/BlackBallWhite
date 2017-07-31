package com.yinghuizou.game.state;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by yinghuizou on 5/29/17.
 * This is abstract class, which talk about what method and variable should each of the
 * state class have
 */



public abstract  class state {
    //camera help to allocate position in the world
    public OrthographicCamera camera;

    //Position material  X, Y Z System
    public Vector3 mouse;

    //Manager a stack of state Together

    public GameStateManager gsm;


    //Constructor take in a game stackmanger because it want to be inside a stack
   // of state
    public state(GameStateManager gsm){
        this.gsm = gsm;
        this.camera = new OrthographicCamera();
        this.mouse = new Vector3();

    }
    //handle user input
    public abstract  void handleInput();
    //calculate the calculation
    public abstract  void update(float dt);
    //draw the image
    public abstract  void render (SpriteBatch sb);
    //dispose the not important stuff
    public abstract  void dispose();


}
