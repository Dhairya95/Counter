package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    Stage stage;
    Skin skin;
    int pokemonCounter = 0, itemCounter = 0, cashCounter = 0;
    SpriteBatch batch;
    Button button1, button2, button3;
    BitmapFont bitmapFont1, bitmapFont2, bitmapFont3;

    @Override
    public void create() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("neon-ui.json"));

        button1 = new TextButton("Pokemon", skin, "default");
        button1.setBounds(50, 50, 100, 50);
        button1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                pokemonCounter++;
                System.out.println("Pokemon Count : " + pokemonCounter);
            }
        });

        button2 = new TextButton("Item", skin, "default");
        button2.setBounds(200, 50, 100, 50);
        button2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                itemCounter++;
                System.out.println("Item Count : " + itemCounter);
            }
        });

        button3 = new TextButton("Cash", skin, "default");
        button3.setBounds(350, 50, 100, 50);
        button3.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                cashCounter++;
                System.out.println("Cash Count : " + cashCounter);
            }
        });

        stage.addActor(button1);
        stage.addActor(button2);
        stage.addActor(button3);

        batch = new SpriteBatch();
        initializeFont();
    }

    private void initializeFont() {
        bitmapFont1 = new BitmapFont();
        bitmapFont2 = new BitmapFont();
        bitmapFont3 = new BitmapFont();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();
        bitmapFont1.draw(batch, "Pokemon Count : " + pokemonCounter, 200, 400);
        bitmapFont2.draw(batch, "Item Count : " + itemCounter, 200, 300);
        bitmapFont3.draw(batch, "Cash Count : " + cashCounter, 200, 200);
        batch.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        stage.getViewport().update(width, height);
        stage.getViewport().apply();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
