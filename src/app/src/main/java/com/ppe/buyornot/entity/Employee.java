package com.ppe.buyornot.entity;

import java.util.Date;
import android.os.Parcel;
import android.os.Parcelable;

public class Employee implements Parcelable {

	private int id;
	private String name;
	private Date dateOfBirth;
	private double salary;

	public Employee() {
		super();
	}

	private Employee(Parcel in) {
		super();
		this.id = in.readInt();
		this.name = in.readString();
		this.dateOfBirth = new Date(in.readLong());
		this.salary = in.readDouble();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id);
		dest.writeString(name);
		dest.writeDouble(salary);
	}

	public static final Creator<Employee> CREATOR = new Creator<Employee>() {
		@Override
		public Employee createFromParcel(Parcel in) {
			return new Employee(in);
		}

		@Override
		public Employee[] newArray(int size) {
			return new Employee[size];
		}
	};
}
