package soa.dao;

import soa.entities.Devise;

import java.util.List;


public interface IDeviseDao
{
	Devise save(Devise devise);
	List<Devise> findAll();
	Devise findOne(Long id);
	Devise update(Devise devise);
	void delete(Long id);
	List getById(Long id);
}
