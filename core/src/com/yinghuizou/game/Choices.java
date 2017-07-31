package com.yinghuizou.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.org.apache.xpath.internal.operations.String;
import com.yinghuizou.game.state.GameStateManager;
import com.yinghuizou.game.state.MenuState;


//The Application run from here
public class Choices extends ApplicationAdapter {

	public static final int WIDTH = 950;

	public static final int HEIGHT = 600;

	public static final java.lang.String TITLE = "BLACK BALL WHITE";

	//Just like graphics in java eclipse
	private SpriteBatch batch;

	//create stack of states
	private GameStateManager gsm;



	private Music music;

	@Override
	public void create () {
		gsm = new GameStateManager();
		batch = new SpriteBatch();


		//Everythings start here
		// you create a menu state and add it to stack of gsm

		music = Gdx.audio.newMusic(Gdx.files.internal("BGM.mp3"));
		music.setLooping(true);
		music.setVolume(9.1f);
		music.play();

		gsm.push(new MenuState(gsm));



	}

	@Override
	public void render () {

		//update the most top of gsm
	  	gsm.update(Gdx.graphics.getDeltaTime());

		//render the most top of gsm to begin the game
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		super.dispose();

	}



}
