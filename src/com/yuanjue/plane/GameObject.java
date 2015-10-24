package com.yuanjue.plane;

import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	Image imgplane;
	double x,y;
	int speed = 3;
	int width,height;
	
	public GameObject(){
		
	}
	
	public GameObject(Image imgplane, double x, double y, int speed, int width,int height) {
		super();
		this.imgplane = imgplane;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}

	public Rectangle getRect(){
		return new Rectangle((int)x,(int)y,width,height);
	}
	
}