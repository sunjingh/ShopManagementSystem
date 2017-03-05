package com.etc.icss.management;

import java.util.Scanner;

import com.etc.icss.data.Customer;

public class CustManagement {
	//Menu mn = new Menu();
	
	Customer[] customerArr = new Customer[20];
	Scanner sc = new Scanner(System.in);
	
	public void initCustomerInfo(){			//初始化会员信息
		Customer cus1 = new Customer();
		cus1.custNo = "0001";
		cus1.custBrith = "0909";
		cus1.custScore = 1000;
		customerArr[0] = cus1;
		Customer cus2 = new Customer();
		cus2.custNo = "0002";
		cus2.custBrith = "0919";
		cus2.custScore = 1500;
		customerArr[1] = cus2;
		Customer cus3 = new Customer();
		cus3.custNo = "0003";
		cus3.custBrith = "0409";
		cus3.custScore = 2000;
		customerArr[2] = cus3;
	}
	
	public void showAllCustomerInfo(){		//显示所有会员信息
		System.out.println("会员编号\t会员生日\t会员积分");
		for(int i = 0;customerArr[i]!=null;i++){
			String str = "";
			str+=customerArr[i].custNo+"\t";
			str+=customerArr[i].custBrith+"\t";
			str+=customerArr[i].custScore;
			System.out.println(str);
		}
	}
	
	public void addCustomer(){				//添加会员
		int index = 0;
		String isContinue;
		
		do{
			Customer cus = new Customer();
			System.out.println("请输入会员编号：");
			cus.custNo = sc.next();
			System.out.println("请输入会员生日：");
			cus.custBrith = sc.next();
			System.out.println("请输入会员积分：");
			cus.custScore = sc.nextInt();
			for(int i = 0;i<customerArr.length;i++){
				if(customerArr[i]!=null){
					index = i;
				}
			}
			customerArr[index+1] = cus;
			customerArr[index+1].custNo = cus.custNo;
			customerArr[index+1].custBrith = cus.custBrith;
			customerArr[index+1].custScore = cus.custScore;
			System.out.println("是否继续添加（y/n）");
			isContinue = sc.next();
		}while("y".equals(isContinue));
	}

	public boolean reviseCustomer(){			//修改会员信息
		System.out.println("请输入要修改的会员号：");
		String customerId = sc.next();
		String isN;
		boolean flag = false;
		int index = 0;
		for(int i = 0;customerArr[i]!=null&&i<customerArr.length;i++){
			if(customerArr[i].custNo.equals(customerId)){
				flag = true;
				index = i;
				break;
			}
		}
		if(flag){
			System.out.println("请重新输入会员信息：");
			System.out.println("请输入会员号：");
			customerId = sc.next();
			customerArr[index].custNo = customerId;
			System.out.println("请输入会员生日：");
			String customerBrith = sc.next();
			customerArr[index].custBrith = customerBrith;
			System.out.println("请输入会员积分：");
			int customerScore = sc.nextInt();
			customerArr[index].custScore = customerScore;
			System.out.println("修改成功！");
		}
		return flag;
	}
	
	public boolean inquiryCustomer(){			//查询会员信息
		String isContinue;
		do{
			System.out.println("请输入要查询的会员号：");
			String customerId = sc.next();
			String isN;
			boolean flag = false;
			int index = 0;
			for(int i = 0;customerArr[i]!=null&&i<customerArr.length;i++){
				if(customerArr[i].custNo.equals(customerId)){
					flag = true;
					index = i;
					break;
				}
			}
			if(flag){
				System.out.println("会员编号\t会员生日\t会员积分");
				String str = "";
				str+=customerArr[index].custNo+"\t";
				str+=customerArr[index].custBrith+"\t";
				str+=customerArr[index].custScore;
				System.out.println(str);
				System.out.println("是否继续查询（y/n）");
				isContinue = sc.next();
			}
			return flag;
		}while("y".equals(isContinue));
	}
}
