package screens;

import game.EatFishAndAI;
import graphics.gui.buttons.Button;
import graphics.gui.buttons.ButtonAction;
import graphics.gui.buttons.ButtonAction.TYPE;
import graphics.gui.buttons.ButtonListener;
import graphics.gui.buttons.ModifyPlayerButton;
import graphics.gui.buttons.AddPlayerButton;
import graphics.gui.buttons.StartGameButton;
import ai.AIConfiguration;
import assets.Assets;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import configuration.GameConfiguration;

public class ConfigureScreen extends AbstractScreen {

	private final GlyphLayout layout;
	private final String topLabel = "Add players and connect their AI to begin!";

	GameConfiguration conf;
	float top = EatFishAndAI.HEIGHT, bottom = 0, left = 0,
			right = EatFishAndAI.WIDTH, centerX = EatFishAndAI.WIDTH / 2,
			centerY = EatFishAndAI.HEIGHT / 2;
	float aiButtonX = EatFishAndAI.WIDTH / 4;

	float spacing = 55f;
	float topMargin = EatFishAndAI.HEIGHT / 6;

	int loadedAIS = 0;

	Button addPlayerButton;
	Button startGameButton;

	public ConfigureScreen(Game game) {
		super(game);
		conf = new GameConfiguration();
		conf.aiconf = new AIConfiguration();

		layout = new GlyphLayout(Assets.font30, topLabel);

		addPlayerButton = new AddPlayerButton(aiButtonX - AddPlayerButton.WIDTH
				/ 2, top - topMargin - 1 * spacing - AddPlayerButton.HEIGHT / 2);

		addPlayerButton.setButtonListener(new ButtonListener() {

			@Override
			public void handle(ButtonAction ba) {
				if (ba.type == TYPE.RELEASE) {
					conf.aiconf.prompt();
				}
			}
		});

		startGameButton = new StartGameButton(centerX - StartGameButton.WIDTH
				/ 2, centerY / 2);

		startGameButton.setButtonListener(new ButtonListener() {

			@Override
			public void handle(ButtonAction ba) {
				if (ba.type == TYPE.RELEASE) {
					game.setScreen(new PlayScreen(game, conf));
				}
			}
		});
	}

	@Override
	public void show() {
		setBackground(Assets.bg);
		getGameContext().spawn(addPlayerButton);
		getGameContext().spawn(startGameButton);
	}

	@Override
	protected void update(float delta) {
		if (conf.aiconf.getAIs().size() != loadedAIS) {
			loadedAIS = conf.aiconf.getAIs().size();
			addPlayerButton.setY(addPlayerButton.getY() - spacing);

			ModifyPlayerButton modifyPlayerButton = new ModifyPlayerButton(
					aiButtonX - ModifyPlayerButton.WIDTH / 2, top - topMargin
							- loadedAIS * spacing - ModifyPlayerButton.HEIGHT
							/ 2, conf.aiconf.getAIs()
							.get(conf.aiconf.getAIs().size() - 1).newInstance()
							.getClass().getName());

			modifyPlayerButton.setButtonListener(new ButtonListener() {

				@Override
				public void handle(ButtonAction ba) {
					// TODO
				}
			});

			getGameContext().spawn(modifyPlayerButton);
		}
	}

	@Override
	protected void drawScreen(SpriteBatch batch) {
		Assets.font30.draw(batch, layout, centerX - layout.width / 2, top
				- topMargin + layout.height);
	}

}