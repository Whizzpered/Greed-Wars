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
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.objects.Entity;

/**
 *
 * @author Whizzpered
 */
public class GameStage extends Stage {

    private OrthographicCamera cam;
    AssetManager asset;
    private TextureAtlas atlas;

    public Array<Entity> getEntities() {
        Array<Entity> ge = new Array<Entity>();

        for (Actor a : getActors()) {
            if (a instanceof Entity) {
                ge.add((Entity) a);
            }
        }
        return ge;
    }

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
        initScene();
    }

    @Override
    public void act() {
        
    }
    
    private void initScene() {
        addActor(new Entity(60, 60, 30, 30));
        this.getEntities().get(0).setSprite();
        this.addListener(this.getEntities().get(0).getListeners().first());
    }

    private void initAssets() {
        asset = new AssetManager();
        asset.load("tex.pack", TextureAtlas.class);
        asset.finishLoading();
        atlas = asset.get("tex.pack");
    }

    private void initCam() {
        cam = new OrthographicCamera();
        cam.setToOrtho(true);
        getViewport().setCamera(cam);
    }

}
