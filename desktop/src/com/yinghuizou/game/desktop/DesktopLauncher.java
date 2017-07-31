package com.yinghuizou.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.yinghuizou.game.Choices;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Choices.WIDTH;
		config.height= Choices.HEIGHT;
		config.title = Choices.TITLE;
		new LwjglApplication(new Choices(), config);
	}
}
