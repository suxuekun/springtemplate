package com.techstudio.sectest.dao;

import java.util.List;

import com.techstudio.dao.BaseDao;
import com.techstudio.model.Groomer;

public interface GroomerDao extends BaseDao<Groomer> {

	public List<Groomer> listAll(int first, int max);
    public void updatePage(Groomer p);

	public long addPage(Groomer p);
}
