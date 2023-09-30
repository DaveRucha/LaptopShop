/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.PrintWriter;
import static java.lang.System.out;

/**
 *
 * @author kishan
 */
public class UpdateBean {
	private String id, name, proc, memory, price;

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getproc() {
		return proc;
	}

	public void setproc(String proc) {
		this.proc = proc;
	}

	public String getmemory() {
		return memory;
	}

	public void setmemory(String memory) {
		this.memory = memory;
	}

	public String getprice() {
		return id;
	}

	public void setprice(String price) {
		this.price = price;
	}
	private Object response;

	
	

	public int Update() throws NamingException, SQLException {
		int j = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/test", "root", "root");

			String sql = ("Update laptops set bname=?,proc=?,memory=?,price=? where id=?");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, proc);
			ps.setString(3, memory);
			ps.setString(4, price);
			ps.setString(5, id);
			j = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		return j;

	}
}
