package com.yuanjue.plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.yuanjue.util.GameUtil;
import com.yuanjue.util.MyFrame;

public class PlaneGameFrame extends MyFrame
{
	/**
	 * @author 路锦博
	 * 2015年10月23日下午5:27:08
	 */
	private static final long serialVersionUID = 1L;
	Image bg = getImage("images/bg.jpg");
	Image planeImg = getImage("images/plane.png");
	
	Plane plane = new Plane(planeImg,50,50);
	@Override
	public void paint(Graphics g)
	{
		g.drawImage(bg, 0, 0, null);
		plane.draw(g);
	}
	public Image getImage(String imgPath)
	{
		return GameUtil.getImage(imgPath);
	}
	public static void main(String[] args)
	{
		new PlaneGameFrame().lauchFrame();;
	}
	
	public void lauchFrame()
	{
		super.lauchFrame();
		addKeyListener(new KeyMonitor());
	}
	
	class KeyMonitor extends KeyAdapter
	{

		@Override
		public void keyPressed(KeyEvent e)
		{
			System.out.println("按下："+e.getKeyCode());
			plane.move(e);
		}

		@Override
		public void keyReleased(KeyEvent e)
		{
			System.out.println("释放："+e.getKeyCode());
		}
		
	}
}
