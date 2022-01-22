package Proj.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class MapDisplay extends Canvas {
	private static final long serialVersionUID = 1L;
	
	private static final int SCALE = 15;
	private int _width;
	private int _height;
	
	private Map _map;
	private int _mapWidth;
	private int _mapHeight;
	
	private JFrame _frame;	
	private Graphics _graphics;
	private BufferStrategy _bufferStrategy;
	
	public MapDisplay(Map map, int mapWidth, int mapHeight) {
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
		for (int x = 0; x < _mapWidth; x ++)
			for (int y = 0; y < _mapHeight; y ++)
				paintSquare(x, y, entityToColor(x, y));
		_bufferStrategy.show();
	}
	
	public void paintSquare(int mapX, int mapY, Color color) {
		_graphics.setColor(color);
		_graphics.fillRect(mapX * SCALE, mapY * SCALE, SCALE, SCALE);
	}
	
	private Color entityToColor(int x, int y) {
		Entity entity = _map.getEntityOrNull(x, y);
		
		if (entity == null) {
			if (y == 0 || y == _mapHeight - 1)
				return Color.LIGHT_GRAY;
			else
				return Color.BLACK;
		}
		
		switch (entity.getType()) {
			case "SV":
				return Color.BLUE;
			case "A-RSU":
				return Color.GREEN;
			case "NA-RSU":
				return Color.RED;
			default:
				return Color.DARK_GRAY;
		}
	}
}
