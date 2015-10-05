package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class MyGdxGame extends ApplicationAdapter {

    private GameStage game;
    private MenuStage menu;

    @Override
    public void create() {
        game = new GameStage(new StretchViewport(320, 480));
        Gdx.input.setInputProcessor(game);
    }

    @Override
    public void resize(int width, int height) {
        game.getViewport().update(width, height, true);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.act();
        game.draw();
    }

    @Override
    public void dispose() {
        game.dispose();
        super.dispose();
    }
}
