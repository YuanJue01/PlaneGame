package com.yuanjue.plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Plane
{
	Image img;
	double x,y;
	
	public void draw(Graphics g)
	{
		g.drawImage(img, (int)x, (int)y, null);
	}

	public void move(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
		case 37:
			x -= 10;
			break;
		case 38:
			y -= 10;
			break;
		case 39:
			x += 10;
			break;
		case 40:
			y += 10;
			break;
		default:
			break;
		}
	}
	public Plane(){}
	public Plane(Image img, double x, double y)
	{
		this.img = img;
		this.x = x;
		this.y = y;
	}
	
}
