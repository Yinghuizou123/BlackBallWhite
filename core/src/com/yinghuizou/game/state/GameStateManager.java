package com.yinghuizou.game.state;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by yinghuizou on 5/30/17.
 */

public class GameStateManager {

    //Create stack of state to store all the state together
    private Stack<state> states ;

    public GameStateManager(){

        states = new Stack<state>();

    }

    //add state in to states
    public void push (state state){

        states.push(state);

    }
    // remove an state from state
    public void pop(){

        states.pop().dispose();

    }


    //We want to remove a state and add a state
    public void set(state state){
        states.pop().dispose();
        states.push(state);
    }

    //Update the most top of the states
    public void update (float dt){

        states.peek().update(dt);
    }

    //render the most top of the states

    public void render(SpriteBatch sb ){

        states.peek().render(sb);
    }






}
