package com.example.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Salary")
public class Salary {
	@javax.persistence.Id
	@Column(name="ID")
	private int id;
	@Column(name="accountNum")
	private int accountNum;
	@Column(name="sal")
	private int sal;
	@Column(name="bonus")
	private int bonus;
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		return "Salary [id=" + id + ", accountNum=" + accountNum + ", sal=" + sal + ", bonus=" + bonus + "]";
	}
	public Salary(int id, int accountNum, int sal, int bonus) {
		super();
		this.id = id;
		this.accountNum = accountNum;
		this.sal = sal;
		this.bonus = bonus;
	}
	public Salary() {
		super();
	}
	
	
}
