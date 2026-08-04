package com.pateladitya;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class GDXWindow extends ApplicationAdapter {

    public TextureAtlas atlas;
    public SpriteBatch batch;
    public Animation<TextureAtlas.AtlasRegion> animation;
    public Sprite player;
    public float stateTime;

    @Override
    public void create() {
        stateTime = 0;
        atlas = new TextureAtlas(Gdx.files.internal("atlas/Player Atlas.atlas"));
        batch = new SpriteBatch();
        animation = new Animation<>(0.1f, atlas.findRegions("run_left"), Animation.PlayMode.LOOP);
        player = new Sprite(animation.getKeyFrame(0).getTexture());
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stateTime += Gdx.graphics.getDeltaTime();
        batch.begin();
        player.draw(batch);
        player.setRegion(animation.getKeyFrame(stateTime));
        player.flip(true, false);
        player.setBounds(0, 0, 100, 150);
        batch.end();
    }
// Test
    @Override
    public void dispose() {
        atlas.dispose();
        batch.dispose();
    }
}
