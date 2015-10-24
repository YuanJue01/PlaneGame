package com.yuanjue.plane;

import java.awt.Color;
import java.awt.Graphics;
import com.yuanjue.util.Constant;

public class Bullet extends GameObject {
	double degree;
	
	public Bullet(){
		width = 10;
		height = 10;
		degree = Math.random()*Math.PI*2;
		x = Constant.WIDTH/2;
		y = Constant.HEIGHT/2;
	}
	
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, width, height);
		
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		if (y>Constant.HEIGHT-height || y<30) {
			degree = -degree;
		}
		if (x<0 || x>Constant.WIDTH-width) {
			degree = Math.PI-degree;
		}
		
		g.setColor(c);
	}
}
