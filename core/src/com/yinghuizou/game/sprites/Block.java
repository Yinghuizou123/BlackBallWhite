package com.yinghuizou.game.sprites;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by yinghuizou on 6/2/17.
 */

public class Block {
    private Texture blackimage;
    private Texture whiteimage;
    private Vector2 posblock1;
    private Vector2 posblock2;
    private Vector2 posblock3;
    private Random rand;
    private Vector2 posblock4;
    private Sound sound;

   private Rectangle bound1,bound2,bound3,bound4,bound5;


    private static final int FLUCATION =200;

    private static final int BlockGAP =100;

    private int LOWESTOPENING;

    public Block(float x){


        blackimage = new Texture("aa.jpg");
        whiteimage = new Texture( "White.png");

        rand = new Random();

        int number = 0;

        posblock1 = new Vector2(x,number = 60 + (int)(Math.random() * (210 - 60 + 1)));
        posblock2 = new Vector2(x,270);
        posblock3 = new Vector2(x,0);
        //60,60
        bound1 = new Rectangle(posblock1.x, posblock1.y, 60,60);


        bound2 = new Rectangle(posblock2.x, posblock2.y+10,50,30);
        bound3= new Rectangle(posblock3.x, posblock3.y,50,20);


        bound4 = new Rectangle(posblock1.x+80, posblock1.y+30, 25,25);
        bound5 = new Rectangle(posblock1.x+90 ,125, 30,50);


    }


    public Texture getBlackimage() {
        return blackimage;
    }

    public Vector2 getPosblock1() {
        return posblock1;
    }

    public Texture gettube2() {
        return whiteimage;
    }

    public Vector2 getpostube2() {
        return posblock2;
    }

    public Vector2 getpostube3() {
        return posblock3;
    }





    public void reposition(float x){

        posblock1.set(x,60 + (int)(Math.random() * ((210 - 60) + 1)));
        posblock2.set(x,270);
        posblock3.set(x,0);
        bound1.setPosition(posblock1.x, posblock1.y);

        bound2.setPosition(posblock2.x, posblock2.y+10);
        bound3.setPosition(posblock3.x, posblock3.y);
        bound4.setPosition(posblock1.x+80, posblock1.y+30);
        bound5.setPosition(posblock1.x+90 ,125);


    }

    public boolean collides(Rectangle player){
        return player.overlaps(bound1);



    }
    public boolean secondcollisdes(Rectangle player){
        return player.overlaps(bound2) || player.overlaps(bound3)|| player.overlaps(bound4) || player.overlaps(bound5) ;



    }
    public void dispose(){
        blackimage.dispose();
        whiteimage.dispose();


    }

}
