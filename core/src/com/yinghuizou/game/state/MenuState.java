package com.yinghuizou.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.yinghuizou.game.Choices;

/**
 * Created by yinghuizou on 5/30/17.
 */

public class MenuState extends  state {

    private Texture backGround;
    private BitmapFont FontName;


    public MenuState(GameStateManager gsm) {
        super(gsm);
        backGround = new Texture("full-backgroundcopy2.png");
        FontName = new BitmapFont();
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.pop();
            gsm.push(new playState(gsm));
        }

    }

    @Override
    public void update(float dt) {

        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        //Open the box
        sb.begin();
        //start from the 0,0 to draw the image
        sb.draw(backGround,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        sb.end();

    }

    @Override
    public void dispose() {
        //Call it when you want to move Menu to next state
        //Make both go away to save the space
        backGround.dispose();

    }
}
