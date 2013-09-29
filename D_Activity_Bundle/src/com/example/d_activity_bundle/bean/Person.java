/**
 * 
 */
package com.example.d_activity_bundle.bean;

import java.io.Serializable;

public class Person implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String pass;
	private String gender;

	public Person()
	{
	}	
	
	/**
	 * @param name
	 * @param pass
	 * @param gender
	 */
	public Person(String name, String pass, String gender)
	{
		this.name = name;
		this.pass = pass;
		this.gender = gender;
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPass()
	{
		return pass;
	}
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}

}
