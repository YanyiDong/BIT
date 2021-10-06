package com.dyy.a.service;

import java.util.List;

import com.dyy.a.entity.Customer;
import com.dyy.a.util.Page;



public interface UserService {
	//登录业务逻辑
		public int Login();
		
		//取出所有的用户信息
		public List<Customer> getAllCustomers();
		
		
		/**
		 * 获取按条件查找后，对应页码的员工信息集合分页对象
		 */
		public Page<Customer> getEmpByConditions( int pageNo,
				int pageSize);
		
		public Customer selectOne(int custid);
		
		public int updateCust();
		
		public int deleteCust();
		
		public int insertCust();
}
