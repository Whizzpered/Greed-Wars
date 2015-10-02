/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 *
 * @author Whizzpered
 */
public class GameStage extends Stage {

    
    private OrthographicCamera cam;
    AssetManager asset;
    private TextureAtlas atlas;

    public TextureAtlas getAtlas() {
        return atlas;
    }

    public GameStage(Viewport vp) {
        super(vp);
        initialize();
    }

    public void initialize() {
        initAssets();
        initCam();
    }

    private void initAssets() {
        asset = new AssetManager();
        asset.load("tex.pack", TextureAtlas.class);
        asset.finishLoading();
        atlas = asset.get("tex.pack");
    }

    public void initCam() {
        cam = new OrthographicCamera();
        cam.setToOrtho(true);
        getViewport().setCamera(cam);
    }

}
