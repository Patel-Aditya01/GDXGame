package com.pateladitya;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Player extends Sprite {
    public enum State{
        IDLE,
        RUNNING,
        JUMPING,
        FALLING
    }

    public State state;
    private TextureAtlas atlas;
    private Animation<TextureAtlas.AtlasRegion> idle;
    private Animation<TextureAtlas.AtlasRegion> run;
    private Animation<TextureAtlas.AtlasRegion> jump;
    private Animation<TextureAtlas.AtlasRegion> fall;

    public Player(){
        this.state = State.IDLE;
        atlas = new TextureAtlas(Gdx.files.internal("atlas/Player Atlas.atlas"));
        idle = new Animation<>(0.1f, atlas.findRegions("idle"));
        run = new Animation<>(0.75f, atlas.findRegions("run"));
        jump = new Animation<>(0.1f, atlas.findRegions("jump"));
        fall = new Animation<>(0.1f, atlas.findRegions("fall"));
    }
}
