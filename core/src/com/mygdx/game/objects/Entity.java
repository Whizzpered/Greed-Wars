/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.game.GameStage;

/**
 *
 * @author Whizzpered
 */
public class Entity extends Actor {

    Vector2 position, velocity;
    private Sprite sprite;
    Color c;
    Circle cl;

    @Override
    public GameStage getStage() {
        return (GameStage) (super.getStage());
    }

    public Entity(float x, float y, int width, int height) {
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        cl = new Circle();
        setWidth(width);
        setHeight(height);
        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int we) {
                action();
                Gdx.app.log("Unit", "Work");
                return true;
            }
        });
    }

    public void setSprite() {
        setName("astronaut");
        sprite = getStage().getAtlas().createSprite("astronaut");
        sprite.rotate(180);
    }

    @Override
    public float getX() {
        return position.x;
    }

    @Override
    public float getY() {
        return position.y;
    }

    @Override
    public void act(float delta) {
        cl.set(getX(), getY(), getWidth());
        position.add(velocity.cpy().scl(delta));

        if (position.x < 0) {
            position.x = 0;
        }

        if (position.x > this.getStage().getWidth() - getWidth()) {
            position.x = this.getStage().getWidth() - getWidth();
        }

    }

    public void action() {
        position.y = 200;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        batch.begin();
        sprite.setCenterX(getX());
        sprite.setCenterY(getY());
        sprite.draw(batch);
        batch.end();
        batch.begin();
    }
}
