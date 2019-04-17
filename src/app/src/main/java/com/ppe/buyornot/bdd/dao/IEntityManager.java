package com.ppe.buyornot.bdd.dao;

import android.content.ContentValues;

import com.ppe.buyornot.bdd.model.IEntity;

import java.util.List;

public interface IEntityManager<T extends IEntity> {

	List<T> getAll();

	T get(int id);

	long add(T entity);

	int update(T entity);

	void delete(int id);

	public ContentValues fillContentValues(T entity);
}