package com.cs3398.sportsapp.Model;

import java.util.ArrayList;

// test global database. Idea is to use database class as the array list, rather than having separate
// lists across different classes. So far no changes have been made to other class files, for reasons i have
// explained to the team.
public class Database {
	public ArrayList<User> users;

	private Database() {
		users = new ArrayList<User>();
	}

	private static Database instance;

	public static Database getInstance() {
		if (instance == null) instance = new Database();
		    return instance;
		}
	
	// access data with Database.getInstance().users.get(position);
}
