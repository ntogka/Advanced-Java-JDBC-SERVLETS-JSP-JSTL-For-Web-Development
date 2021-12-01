package com.marina.app32.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) {
		BufferedReader br = null;
		System.out.println("Student Management System");
		System.out.println("-----------------------------");
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				System.out.println();
				System.out.println("1. ADD Student");
				System.out.println("2. SEARCH Student");
				System.out.println("3. UPDATE Student");
				System.out.println("4. DELETE Student");
				System.out.println("5. EXIT");
				System.out.print("Your Option  : ");
				int option = Integer.parseInt(br.readLine());
				switch (option) {
				case 1:
					System.out.println("You Selected ADD Module");
					break;
				case 2:
					System.out.println("You Selected SEARCH Module");
					break;
				case 3:
					System.out.println("You Selected UPDATE Module");
					break;
				case 4:
					System.out.println("You Selected DELETE Module");
					break;
				case 5:
					System.out.println("You Selected EXIT Module");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Option You Selected, Provide the numbers from 1, 2, 3, 4 and 5");
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
