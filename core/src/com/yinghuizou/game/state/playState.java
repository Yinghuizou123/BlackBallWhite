package com.yinghuizou.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Timer;
import com.yinghuizou.game.Choices;
import com.yinghuizou.game.sprites.Ball;
import com.yinghuizou.game.sprites.Block;


import java.util.Random;
import java.util.TimerTask;

/**
 * Created by yinghuizou on 5/31/17.
 */

public class playState extends  state {

    private Ball ball;
    private Texture bg;
    private int scorenumber,highscore;
    private String Score;
    private BitmapFont FontName;

    private static final int BLOCKSPACE =125;
    private static final int BLOCKCOUNT =4;
    private static final int BLOCKWEIGHT =120;
    private Array<Block> blocks;

    private  Random random = new Random();
    private Sound hit;
    private Sound sound;
    private Sound sound2;

    private Timer timer;
    private int time;
    private int life;
    private boolean determind ;
    private Preferences prefs;
    private int x, y;




    public playState(GameStateManager gsm) {
        super(gsm);
        x = 5;
        y = 6;
        ball = new Ball(-200,100);
        bg = new Texture(("full-background.png"));
        camera.setToOrtho(false, Choices.WIDTH/2,Choices.HEIGHT/2);
        scorenumber = 0;
        Score = "Score : ";
        FontName = new BitmapFont();
        time = 60;
        life = 100;
        sound= Gdx.audio.newSound(Gdx.files.internal("point.wav"));
        sound2 = Gdx.audio.newSound(Gdx.files.internal("lost.wav"));
        determind = true;
        prefs   = Gdx.app.getPreferences("My Preferences");

       blocks = new Array<Block>();
        for (int i = 0; i < BLOCKCOUNT; i ++){
          blocks.add(new Block(i *(125)+ BLOCKWEIGHT));

        }


        TimerTask  task  = new TimerTask()
        {
            @Override
            public void run() {
               time--;
                if(ball.speed()<181) {



                   ball.setmovement(1);
                }
                if(ball.speed() ==180){
                   ball.setmovement2(180) ;
                }

            }
        };
        java.util.Timer time  = new java.util.Timer();
        time.scheduleAtFixedRate(task,1000,1000);
        this.highscore = prefs.getInteger("highscore",0);

    }







    @Override
    public void handleInput() {

        if(Gdx.input.justTouched()){

            ball.jump();

        }


    }



    @Override
    public void update(float dt) {
        handleInput();
        ball.update(dt);

        camera.position.x = ball.getPosition().x+80;

        for(int i = 0; i < blocks.size ; i ++){


            Block blo= blocks.get(i);
            //if the block is not in the scene

                if(camera.position.x-(camera.viewportWidth)/2>blo.getPosblock1().x+100){
                    //reposition all the blo in the tubes
               blo.reposition(blo.getPosblock1().x+(80 + BLOCKSPACE * BLOCKCOUNT));



            }

            if(blo.collides(ball.getBound())){
                if(determind)
               sound.play(0.1f);



            if(determind  == true) {
              scorenumber += random.nextInt(3);
          }


            }

             if(blo.secondcollisdes(ball.getBound())){

                       life=0;
                 if(gameover()){

                     determind = false;

                 }

                if(scorenumber> highscore){

                    prefs.putInteger("highscore",scorenumber);
                    prefs.flush();


                }



            }



        }
        camera.update();


    }




    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(camera.combined);
        sb.begin();

        sb.draw(bg, (camera.position.x- (camera.viewportWidth)/2)-10,-40,500,500);


      sb.draw(ball.getTexture(), ball.getPosition().x, ball.getPosition().y,20,20);

        FontName.setColor(Color.BLACK);



        for (Block blo : blocks) {

            sb.draw(blo.gettube2(),blo.getpostube2().x,blo.getpostube2().y+10,50,30);
            sb.draw(blo.getBlackimage(), blo.getPosblock1().x, blo.getPosblock1().y,60,60);
          sb.draw(blo.gettube2(),blo.getpostube3().x,blo.getpostube3().y,50,20);


            Random random = new  Random();

            sb.draw(blo.gettube2(),blo.getPosblock1().x+80,blo.getPosblock1().y+30,25,25);

            sb.draw(blo.gettube2(),blo.getPosblock1().x+90,100 + (int)(Math.random() * (150 - 100 + 1)),30,30);

        }


        FontName.draw(sb, "Current Score: ", ball.getPosition().x-130,270);
        FontName.setColor(Color.RED);



        FontName.setColor(Color.BLACK);



        FontName.draw(sb, Integer.toString(scorenumber), ball.getPosition().x-30,270);




if(gameover()) {

    FontName.setColor(Color.WHITE);

    FontName.draw(sb, "GAME OVER CLICK TO START NEW GAME", ball.getPosition().x - 40, 170);
    FontName.draw(sb, "Highest Score = ", ball.getPosition().x + 30, 130);
    FontName.draw(sb, "SCORE = ", ball.getPosition().x + 30, 100);
    FontName.draw(sb, Integer.toString(prefs.getInteger("highscore")), ball.getPosition().x + 140, 130);
    FontName.draw(sb, Integer.toString(scorenumber), ball.getPosition().x + 100, 100);

    ball.setmovement3();


    if(x<y) {

        sound2.play();
        x=10;
    }

    if (Gdx.input.justTouched()) {
        gsm.pop();
        gsm.push(new playState(gsm));
    }



    }


        sb.end();

    }



    public boolean gameover(){


        return life <=0;



    }

    @Override
    public void dispose() {
        bg.dispose();
        ball.dispose();
        for(Block blo: blocks){
            blo.dispose();

        }



    }




}
