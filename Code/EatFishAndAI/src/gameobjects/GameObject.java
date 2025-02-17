package gameobjects;

import gamecontext.GameContext;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameObject {

	public float getX();

	public void setX(float x);

	public float getCenterX();

	public float getY();

	public void setY(float y);

	public float getCenterY();

	public float getVelocityX();

	public float getVelocityY();

	public void setVelocityX(float velx);

	public void setVelocityY(float vely);

	public void setMaxSpeed(float speed);

	public float getMaxSpeed();

	public float getWidth();

	public void setWidth(float width);

	public float getHeight();

	public void setHeight(float height);

	public void setScale(float scale);

	public float getScale();

	public void draw(SpriteBatch batch);

	public void update(float delta);

	public void setSprite(Sprite sprite);

	public Sprite getSprite();

	public void onSpawn();

	public void onDespawn();

	public void destroy();

	public void setGameContext(GameContext gameContext);

	public boolean contains(float x, float y);

	public boolean intersects(GameObject other);

	public float distanceTo(GameObject other);

	public float distanceTo(float x, float y);

	public float angleTo(GameObject other);

	public float angleTo(float x, float y);

	public void moveTowards(GameObject other);

	public void moveTowards(float x, float y);

	public void moveFrom(GameObject other);

	public void moveFrom(float x, float y);

	public void setRotation(float rot);

	public float getRotation();

	public boolean isAlive();

	public void dispose();

}
