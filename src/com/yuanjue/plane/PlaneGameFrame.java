package com.yuanjue.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.yuanjue.util.GameUtil;
import com.yuanjue.util.MyFrame;

public class PlaneGameFrame extends MyFrame {
	private static final long serialVersionUID = 1L;
	
	Image bg = GameUtil.getImage("images/bg.jpg");
	Plane p = new Plane("images/plane.png",50,50);
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();	//泛型未学，暂不加。
	
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		for(int i=0;i<bulletList.size();i++){
			Bullet b = bulletList.get(i);
			b.draw(g);
			//检测与飞机的碰撞
			boolean peng = b.getRect().intersects(p.getRect());
			if(peng){
				//飞机死掉
				p.setLive(false);
			}
		}
		if(false == p.isLive()){
			this.printInfo(g,"Game Over", 40);
		}
	}
	
	public void printInfo(Graphics g,String str,int size){
		Color c = g.getColor();
		g.setColor(Color.white);
		Font font = new Font("Microsoft YaHei UI",Font.PLAIN,size);
		g.setFont(font);
		g.drawString(str, 100, 200);
		g.setColor(c);
	}
	
	//重写父类
	public void launchFrame(){
		super.launchFrame();
		//增加键盘的监听
		addKeyListener(new keyMonitor());
		//生成一堆子弹
		for(int i=0;i<50;i++){
			Bullet b = new Bullet();
			bulletList.add(b);
		}
	}
	
	//定义为内部类，可以方便的使用外部类的普通属性
	class keyMonitor extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			p.addDirection(e);
		}
		@Override
		public void keyReleased(KeyEvent e) {
			p.minusDirection(e);
		}
	}
	
	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
	}
}
