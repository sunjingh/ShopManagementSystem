package com.etc.icss.management;

import java.util.Scanner;

import com.etc.icss.data.Manager;

public class Menu {
	CustManagement cmgt = new CustManagement();
	
	Scanner sc = new Scanner(System.in);
	
	public void showLoginMenu(){	//显示登录菜单

		cmgt.initCustomerInfo();	//初始化顾客列表
		String select;
		String magUser;
		String magPassword;
		Manager manager = new Manager();
		for(int i = 0;i<40;i++){
			System.out.print("* ");
		}
		System.out.print("\n");
		System.out.println("\t\t\t欢迎使用我行我素购物管理系统1.0版本\t\t\t\n\n\n");
		System.out.println("\t\t\t1.登录系统\n");
		System.out.println("\t\t\t2.更改管理员密码\n");
		System.out.println("\t\t\t3.退出\n");
		for(int i = 0;i<40;i++){
			System.out.print("* ");
		}
		System.out.print("\n");
		System.out.print("请选择，输入数字：");
		
		select = sc.next();
		switch(select){
		case "1":
			boolean flag;
			int count = 3;
			
			do{
				System.out.print("请输入管理员用户：");
				magUser = sc.next();
				System.out.print("请输入管理员密码：");
				magPassword = sc.next();
				count--;
				flag = manager.checkManager(magUser,magPassword);
				if(flag){
					//登陆系统成功
					showMainMenu();
					return ;
				}else{
					if(count == 0){
						System.out.println("谢谢使用！");
						System.exit(0);
					}else{
						System.out.println("密码错误！请重新输入！");
					}
				}
			}while(count!=0);
			break;
		case "2":
			String mName;
			String mPassword;
			System.out.println("请输入旧用户名:");
			mName=sc.next();
	  	  	System.out.println("请输入旧密码：");
	  	  	mPassword=sc.next();
	  	  	manager.updateManager(mName,mPassword);
	  	  	break;
		case "3":
			System.exit(0);
		}
	}
	
	public void showMainMenu(){		//显示主菜单
			/*
			1、选择1显示客户信息管理菜单   调用showCustMMenu()
        	2、选择3显示真情回馈菜单   调用showSendGMenu()
        	3、选择4注销：回到开始登录菜单  调用showLoginMenu()
			*/
		String select;
		System.out.println("\t\t\t欢迎使用我行我素购物管理系统\n");
		for(int i = 0;i<40;i++){
			System.out.print("* ");
		}
		System.out.print("\n");
		System.out.println("\t\t\t1.客户信息管理\n");
		System.out.println("\t\t\t2.购物结算\n");
		System.out.println("\t\t\t3.真情回馈\n");
		System.out.println("\t\t\t4.注销\n\n");
		for(int i = 0;i<40;i++){
			System.out.print("* ");
		}
		System.out.print("\n");

		System.out.print("请选择，输入数字：");
		select = sc.next();
		
		switch(select){
		case "1":
			showCustMMenu();
			break;
		case "2":
		case "3":
			showSendGMenu();
			break;
		case "4":
			showLoginMenu();
			break;
		}
	}
	
	
	public void showCustMMenu(){	//显示客户信息管理菜单
		
		String select;
		System.out.println("我行我素购物管理系统 > 客户信息管理");
		for(int i = 0;i<40;i++){
			System.out.print("* ");
		}
		System.out.print("\n");
		System.out.println("\t\t\t1.显示所有客户信息\n");
		System.out.println("\t\t\t2.添加客户信息\n");
		System.out.println("\t\t\t3.修改客户信息\n");
		System.out.println("\t\t\t4.查询客户信息\n");
		for(int i = 0;i<40;i++){
			System.out.print("* ");
		}
		System.out.print("\n");
		System.out.print("请选择，输入数字或按'n'返回上一级菜单：");
		
		//System.out.print("请选择，输入数字：");
		select = sc.next();
	
		switch(select){
		case "1":
			cmgt.showAllCustomerInfo();
			System.out.print("输入\"n\"返回上一层");
			String isN = sc.next();
			while(!"n".equals(isN)){
					System.out.print("输入错误，请重新输入\"n\"返回上一层");
					isN = sc.next();
			}
			showCustMMenu();
			break;
		case "2":
			cmgt.addCustomer();
			System.out.print("输入\"n\"返回上一层");
			isN = sc.next();
			while(!"n".equals(isN)){
				System.out.print("输入错误，请重新输入\"n\"返回上一层");
				isN = sc.next();
			}
			showCustMMenu();
			break;
		case "3":
			//System.out.print(cmgt.reviseCustomer());
			if(cmgt.reviseCustomer()==true){
				System.out.println("输入\"n\"返回上一层");
				isN = sc.next();
				while(!"n".equals(isN)){
					System.out.print("输入错误，请重新输入\"n\"返回上一层");
					isN = sc.next();
				}
				showCustMMenu();
			}else{
				System.out.print("无匹配，输入\"n\"返回上一层");
				isN = sc.next();
				while(!"n".equals(isN)){
					System.out.print("输入错误，请重新输入\"n\"返回上一层");
					isN = sc.next();
				}
				showCustMMenu();
			}
			break;
		case "4":
			if(cmgt.inquiryCustomer()){
				System.out.print("输入\"n\"返回上一层");
				isN = sc.next();
				while(!"n".equals(isN)){
					System.out.print("输入错误，请重新输入\"n\"返回上一层");
					isN = sc.next();
				}
				showCustMMenu();
			}else{
				System.out.print("无匹配，输入\"n\"返回上一层");
				isN = sc.next();
				while(!"n".equals(isN)){
					System.out.print("输入错误，请重新输入\"n\"返回上一层");
					isN = sc.next();
				}
				showCustMMenu();
			}
			break;
		case "n":
			showMainMenu();
			break;
		}
	}
	
	public void showSendGMenu(){	//显示真情回馈菜单 
		
	}
	
	
}
