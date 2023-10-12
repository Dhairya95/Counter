package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.*;

public class MyGdxGame extends ApplicationAdapter {

    private Viewport viewport;
    private Stage stage;
    private Skin skin;
    private int pokemonCounter = 0, itemCounter = 0, cashCounter = 0;
    private SpriteBatch batch;
    private BitmapFont pokemonBitmapFont, itemBitmapFont, cashBitmapFont;

    @Override
    public void create() {

        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("neon-ui.json"));
        stage = new Stage(viewport, batch);
        Gdx.input.setInputProcessor(stage);

        Button pokemonButton = new TextButton("Pokemon", skin, "default");
        pokemonButton.setBounds(Gdx.graphics.getWidth() * 0.1f, Gdx.graphics.getHeight() * 0.1f, 100, 50);
        pokemonButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                pokemonCounter++;
                System.out.println("Pokemon Count : " + pokemonCounter);
            }
        });
        pokemonBitmapFont = new BitmapFont();

        Button itemButton = new TextButton("Item", skin, "default");
        itemButton.setBounds(Gdx.graphics.getWidth() * 0.4f, Gdx.graphics.getHeight() * 0.1f, 100, 50);
        itemButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                itemCounter++;
                System.out.println("Item Count : " + itemCounter);
            }
        });
        itemBitmapFont = new BitmapFont();

        Button cashButton = new TextButton("Cash", skin, "default");
        cashButton.setBounds(Gdx.graphics.getWidth() * 0.7f, Gdx.graphics.getHeight() * 0.1f, 100, 50);
        cashButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                cashCounter++;
                System.out.println("Cash Count : " + cashCounter);
            }
        });
        cashBitmapFont = new BitmapFont();

        stage.addActor(pokemonButton);
        stage.addActor(itemButton);
        stage.addActor(cashButton);

    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);

        viewport.apply();

        batch.begin();
        pokemonBitmapFont.draw(batch, "Pokemon Count : " + pokemonCounter, 200, 400);
        itemBitmapFont.draw(batch, "Item Count : " + itemCounter, 200, 300);
        cashBitmapFont.draw(batch, "Cash Count : " + cashCounter, 200, 200);
        batch.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        viewport.update(width, height, true);
        stage.getViewport().update(width, height, true);
        stage.getViewport().apply();
    }

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
        skin.dispose();
    }
}
