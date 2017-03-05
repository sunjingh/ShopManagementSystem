package com.etc.icss.data;

import java.util.Scanner;

import com.etc.icss.management.Menu;

public class Manager {
	public static String mName = "manager";
	public static String mPassword = "0000";
	
	public boolean checkManager(String magUser,String magPassword){	//校验密码
		boolean flag=false;
    	  if(magPassword.equals(mPassword)&&magUser.equals(mName)){
    		  flag=true;
    	  }
    	  return flag;
	}
	
	public void updateManager(String magUser,String magPassword){	//修改密码
		Scanner sc = new Scanner(System.in);
		Menu m = new Menu();
  	  	if(checkManager(magUser,magPassword)){
  	  		System.out.print("请输入新用户名：");
  	  		mName=sc.next();
  	  		System.out.print("请输入新用户名：");
  	  		mPassword=sc.next();
  	  		System.out.println("修改成功！");
  	  		m.showLoginMenu();			//修改成功后重新登陆
  	  	}
  	  	else{
  	  		System.out.println("用户和密码不匹配你没有权限更改信息！！");
  	  		m.showLoginMenu();
  	  	}
    }
}