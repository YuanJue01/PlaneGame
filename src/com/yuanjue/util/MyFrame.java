package com.yuanjue.util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame
{
	/**
	 * @author ·����
	 * 2015��10��23������9:39:32
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ��˫���弼��������˸
	 */
	Image ImageBuffer = null;
	Graphics GraImage = null;
	public void update(Graphics g){		//����update��������ȡĬ�ϵĵ��ù���
		ImageBuffer = createImage(this.getWidth(), this.getHeight());	//����ͼ�λ�����
		GraImage = ImageBuffer.getGraphics();		//��ȡͼ�λ�������ͼ��������
		paint(GraImage);		//��paint�����б�д�Ļ�ͼ���̶�ͼ�λ�������ͼ
		GraImage.dispose();		//�ͷ�ͼ����������Դ
		g.drawImage(ImageBuffer, 0, 0, this);	//��ͼ�λ��������Ƶ���Ļ��
	}
	
	public void launchFrame()
	{
		setSize(Constant.WIDTH, Constant.HEIGHT);
		setLocation(100, 100);
		setVisible(true);
		
		new PaintThread().start();
		
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
	class PaintThread extends Thread
	{
		public void run()
		{
			while(true)
			{
				repaint();
				try{
					Thread.sleep(40);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
}
