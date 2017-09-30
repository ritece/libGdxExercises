package com.udacity.gamedev.rectangularflower;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * TODO: Start Here
 *
 * In this exercise, we're going to draw a flower using only rectangles! We've already started off
 * with a green rectline for the stem. First you'll draw a couple leaves using rotated rectangles.
 *
 * Then you'll draw the head of the flower by drawing a a bunch of rotated squares!
 */

public class RectangularFlower extends ApplicationAdapter {

    ShapeRenderer shapeRenderer;

    @Override
    public void create () {
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void dispose() {
        super.dispose();
        shapeRenderer.dispose();
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        int screenHeight = Gdx.graphics.getHeight();
        int screenWidth  = Gdx.graphics.getWidth();

        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.GREEN);

        //stem
        int stemHeight = screenHeight/2;
        int stemThickness = 20;
        shapeRenderer.rectLine(screenWidth/2, 0, screenWidth/2, stemHeight, stemThickness);


        // TODO: Draw two leaves on the stem
        int leaf1_x = screenWidth/2;
        int leaf1_y = stemHeight/2;

        int leaf2_x = screenWidth/2-stemThickness;
        int leaf2_y = stemHeight/2;

        //thickness grows to the left, so if something is given to be drawn at a particular point say, (x,y) with thickness 't'
        //then it goes from x-t to x.  not x to x+t
        shapeRenderer.rect(leaf1_x, leaf1_y, 0, 0, 20, 50, 1, 1, 315);
        shapeRenderer.rect(leaf2_x, leaf2_y, 0, 0, 20, 50, 1, 1, 45);


        // TODO: Set the active color to yellow
        shapeRenderer.setColor(Color.YELLOW);

        // TODO: Use a loop to draw 20 of these petals in a circle

        float petalAngle = 45.0f;
        for(int petal = 0; petal < 20; petal++)
             shapeRenderer.rect(screenWidth/2, screenHeight/2, 0, 0, 80, 80, 1, 1, petal*(360/20));

        shapeRenderer.end();
    }
}
