package com.etc.icss.management;

import java.util.Scanner;

import com.etc.icss.data.Goods;

public class GoodsManagement {
	Goods[] gs = new Goods[20];
	Scanner sc = new Scanner(System.in);
	
	public void initGoodsInfo(){				//初始化商品信息
		Goods gs1 = new Goods();
		gs1.gNo = "01";
		gs1.gName = "addidas运动鞋";
		gs1.gPrice = 880.0;
		Goods gs2 = new Goods();
		gs2.gNo = "02";
		gs2.gName = "Kappa网球裙";
		gs2.gPrice = 200.0;
		Goods gs3 = new Goods();
		gs3.gNo = "03";
		gs3.gName = "网球拍";
		gs3.gPrice = 1000.0;
	}
}
