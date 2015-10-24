package com.yuanjue.plane;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.yuanjue.util.GameUtil;

public class Plane extends GameObject {
	private boolean left,up,right,down;
	private boolean live = true;
	
	public void draw(Graphics g){
		if(live){
			g.drawImage(imgplane,(int)x,(int)y,null);
			move();
		}
		
	}

	public Plane(String imgpath, double x, double y) {
		this.imgplane = GameUtil.getImage(imgpath);
		this.width = imgplane.getWidth(null);
		this.height = imgplane.getHeight(null);
		this.x = x;
		this.y = y;
	}
	
	public Plane(){}
	
	//“∆∂ØπÊ‘Ú
	public void move(){
		if(left){
			x -= speed;
		}
		if(right){
			x += speed;
		}
		if(up){
			y -= speed;
		}
		if(down){
			y += speed;
		}
	}
	
	public void addDirection(KeyEvent e){
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		default:
			break;
		}
	}
	
	public void minusDirection(KeyEvent e){
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		default:
			break;
		}
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}
}
