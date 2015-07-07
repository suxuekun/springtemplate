package com.techstudio.sectest.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.techstudio.dao.BaseDaoImpl;
import com.techstudio.model.Groomer;

@Repository
@Transactional
public class GroomerDaoImpl extends BaseDaoImpl<Groomer> implements GroomerDao {
	
	   @Override
	   public List<Groomer> listAll(int first, int max)
	   {
		  Criteria criteria = super.createCriteria();
		  criteria.addOrder(Order.desc("id"));
		  return super.nextPage(criteria, first, max);
	   }
		@Transactional
		@Override
		public long addPage(Groomer entity) {
			saveOrUpdate(entity);
			return entity.getId();
		}

		@Transactional
		@Override
		public void updatePage(Groomer entity) {
			update(entity);
		}
}
