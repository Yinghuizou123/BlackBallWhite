package com.yinghuizou.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by yinghuizou on 5/31/17.
 */

public class Ball {
    //Hold the position
    private static final int GRAVITY = -15;
    private Vector3 position;
    private Vector3 velocity;
    private Texture bird;
    private int movement = 80;
    private Rectangle bound;
    private Sound sound;
    private Music music;

    public Ball(int x, int y){
        //It give the position  of the bird
        //according to x and y
        position = new Vector3(x,y,0);
        velocity = new Vector3(0,0,0);
        bird = new Texture("head.jpg");

        //20, 20
        bound = new Rectangle (x,y,20,20);
        sound= Gdx.audio.newSound(Gdx.files.internal("gamejump.wav"));


    }

    public void update(float dt){
        //add the gravity to the y axis to make object fall down
        if(position.y>0) {
            //add gravituy to velocity for y axis
            velocity.add(0, GRAVITY, 0);
        }
        //multiply everythings by delta time??
        velocity.scl(dt);
        //  position.add(movement*dt*60). it will make 60 more faster frame time
        position.add(movement*dt*(1),velocity.y,0);


       if(position.y<0){
           position.y=0;

       }

       if(position.y>280){

           position.y=280;
       }

        velocity.scl(1/dt);
        bound.setPosition(position.x,position.y);



    }
    public void jump(){

        velocity.y= 250;
        sound.play(0.15f);



    }
    public Rectangle getBound(){
        return bound;
    }

    public void dispose(){
        bird.dispose();

    }


    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return bird;
    }



   public int setmovement(int speed){

       return movement += speed;

   }
    public int setmovement2(int speed){

        return movement = speed;

    }
    public void setmovement3(){

       movement = 0;

    }


    public int speed(){

       return movement;
   }


}
