package com.pateladitya;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GDXWindow extends ApplicationAdapter {

    public TextureAtlas atlas;
    public SpriteBatch batch;
    public Animation<TextureAtlas.AtlasRegion> animation;
    public Sprite player;
    public float stateTime;
    public Viewport viewport;
    public OrthographicCamera camera;
    public TiledMap map;
    public TiledMapRenderer renderer;

    @Override
    public void create() {
        stateTime = 0;
        atlas = new TextureAtlas(Gdx.files.internal("atlas/Player Atlas.atlas"));
        batch = new SpriteBatch();
        animation = new Animation<>(0.1f, atlas.findRegions("run_left"), Animation.PlayMode.LOOP);
        player = new Sprite(animation.getKeyFrame(0).getTexture());
        camera = new OrthographicCamera();
        viewport = new FitViewport(16, 14, camera);
        map = new TmxMapLoader().load("map/level_tilemap.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1/16f);
    }

    @Override
    public void render() {
        ScreenUtils.clear(Color.DARK_GRAY);
        stateTime += Gdx.graphics.getDeltaTime();
        batch.begin();

//        player.draw(batch);
//        player.setRegion(animation.getKeyFrame(stateTime));
//        player.flip(true, false);
//        player.setBounds(0, 0, 100, 150);
        camera.update();
        renderer.setView(camera);
        renderer.render();

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        atlas.dispose();
        map.dispose();
        batch.dispose();
    }
}