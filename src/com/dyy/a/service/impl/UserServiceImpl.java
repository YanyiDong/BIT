package com.dyy.a.service.impl;

import java.util.List;

import com.dyy.a.dao.factory.DAOFactory;
import com.dyy.a.entity.Customer;
import com.dyy.a.service.UserService;
import com.dyy.a.util.Page;

public class UserServiceImpl implements UserService {

	private Customer cust;

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	@Override
	public int Login() {
		int flag = 3;
		Customer customer = DAOFactory.getDAOInstance("mysql").Login(cust);
		if (customer != null) {
			int status = customer.getStatus();
			if (status == 1) {
				flag = 1;
			} else if (status == 2) {
				flag = 2;
			} else {
				flag = 0;
			}
		}

		return flag;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> list = DAOFactory.getDAOInstance("mysql")
				.getAllCustomers();
		return list;
	}

	/**
	 * 获取按条件查找后，对应页码的员工信息集合分页对象
	 */
	@Override
	public Page<Customer> getEmpByConditions(int pageNo, int pageSize) {

		Page<Customer> page = new Page<Customer>(pageNo, pageSize);
		int totalCount = 0;
		totalCount = DAOFactory.getDAOInstance("mysql")
				.selectCustCountByConditions();
		// 设置总记录数,setTotalCount方法已被重写
		page.setTotalCount(totalCount);

		// 获取满足查询条件的记录数
		List<Customer> custList = null;
		custList = DAOFactory.getDAOInstance("mysql")
				.selectCustCountByConditions(page.getPageNo(),
						page.getPageSize());
		page.setList(custList);
		return page;
	}

	@Override
	public Customer selectOne(int custid) {
		Customer cust = DAOFactory.getDAOInstance("mysql").selectOne(custid);
		return cust;
	}

	@Override
	public int updateCust() {
		int flag =  DAOFactory.getDAOInstance("mysql").updateCust(cust);
		return flag;
	}

	@Override
	public int deleteCust() {
		int flag =  DAOFactory.getDAOInstance("mysql").deleteCust(cust);
		return flag;
	}

	@Override
	public int insertCust() {
		int flag =  DAOFactory.getDAOInstance("mysql").insertCust(cust);
		return flag;
	}
}
