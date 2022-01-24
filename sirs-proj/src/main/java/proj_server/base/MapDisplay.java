package proj_server.base;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import proj_server.entities.Entity;

public class MapDisplay extends Canvas {
	private static final long serialVersionUID = 1L;
	
	private static final int SCALE = 15; // At least 5
	private static final int ENTITY_MARGIN = (int) Math.floor(SCALE * 0.15);
	private static final int SV_MARGIN = ENTITY_MARGIN * 2;
	private static final int ENTITY_LENGTH = SCALE - 2 * ENTITY_MARGIN;
	
	private static final int ROAD_STRIPES_HALF_WIDTH = 1;
	private static final int ROAD_STRIPES_MARGIN = (int) Math.floor(SCALE * 0.3);
	private static final int ROAD_STRIPES_LENGTH = SCALE - 2 * ROAD_STRIPES_MARGIN;
	
	private static final Color ROAD_COLOR = Color.BLACK;
	private static final Color ROAD_MARGIN_COLOR = Color.LIGHT_GRAY;
	private static final Color ROAD_STRIPES_COLOR = Color.WHITE;
	
	private static final Color SV_COLOR = Color.BLUE;
	private static final Color A_RSU_COLOR = Color.GREEN;
	private static final Color NA_RSU_COLOR = Color.RED;
	private static final Color UNKNOWN_ENTITY_COLOR = Color.DARK_GRAY;
	
	private int _width;
	private int _height;
	
	private Road _map;
	private int _mapWidth;
	private int _mapHeight;
	
	private JFrame _frame;	
	private Graphics _graphics;
	private BufferStrategy _bufferStrategy;
	
	public MapDisplay(Road map, int mapWidth, int mapHeight) {
		_map = map;
		_mapWidth = mapWidth;
		_mapHeight = mapHeight;
		
		_width = mapWidth * SCALE;
		_height = mapHeight * SCALE;
		
		Dimension size = new Dimension(_width, _height);
		setPreferredSize(size);

		_frame = new JFrame("SIRS Project Simulator");
		_frame.setVisible(true);		
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setResizable(false);
		_frame.add(this);
		_frame.pack();
        _frame.setLocationRelativeTo(null);
        _frame.setAlwaysOnTop(true);
        
        createBufferStrategy(2);
        _bufferStrategy = getBufferStrategy();
        _graphics = _bufferStrategy.getDrawGraphics();
        
        new Thread(() -> {
    		while (true) {
    			render();		
    			try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					System.out.println("Map-drawing thread interrupted.");
					_graphics.dispose();
					_frame.dispose();
					return;
				}
    		}
    	}).start();
	}
	
	public void render() {
		paintRoad();
		paintEntities();
		_bufferStrategy.show();
	}
	
	public void paintRoad() {
		for (int x = 0; x < _mapWidth; x ++) {
			paintSquare(x, 0, ROAD_MARGIN_COLOR);
			for (int y = 1; y < _mapHeight - 1; y ++)
				paintSquare(x, y, ROAD_COLOR);
			paintSquare(x, _mapHeight - 1, ROAD_MARGIN_COLOR);
		}
		
		_graphics.setColor(ROAD_STRIPES_COLOR);
		for (int x = 0; x < _mapWidth; x ++)
			for (int y = 2; y < _mapHeight - 1; y ++)
				_graphics.fillRect(
					x * SCALE + ROAD_STRIPES_MARGIN,
					y * SCALE - ROAD_STRIPES_HALF_WIDTH,
					ROAD_STRIPES_LENGTH,
					2 * ROAD_STRIPES_HALF_WIDTH
				);
	}
	
	public void paintEntities() {
		for (int x = 0; x < _mapWidth; x ++)
			for (int y = 0; y < _mapHeight; y ++) {
				Entity entity = _map.getEntityOrNull(x, y);
				if (entity != null)					
					paintEntity(x, y, entity.getType());
			}
	}
	
	public void paintEntity(int x, int y, String type) {
		_graphics.setColor(entityTypeToColor(type));
		int margin = entityTypeToMargin(type);
		_graphics.fillRect(
			x * SCALE + ENTITY_MARGIN,
			y * SCALE + margin,
			ENTITY_LENGTH,
			SCALE - 2 * margin
		);
		
	}
	
	public void paintSquare(int mapX, int mapY, Color color) {
		_graphics.setColor(color);
		_graphics.fillRect(mapX * SCALE, mapY * SCALE, SCALE, SCALE);
	}
	
	private Color entityTypeToColor(String type) {
		switch (type) {
			case "SV":
				return SV_COLOR;
			case "A-RSU":
				return A_RSU_COLOR;
			case "NA-RSU":
				return NA_RSU_COLOR;
			default:
				return UNKNOWN_ENTITY_COLOR;
		}
	}
	
	private int entityTypeToMargin(String type) {
		switch (type) {
			case "SV":
				return SV_MARGIN;
			default:
				return ENTITY_MARGIN;
		}
	}
}
