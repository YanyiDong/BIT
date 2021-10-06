package com.dyy.a.dao;

import java.util.List;

import com.dyy.a.entity.Customer;


public interface UserDAO {

	public Customer Login(Customer cust);
	
	public List<Customer> getAllCustomers();
	
	/**
	 * 统计符合条件的员工总条数
	 * 
	 */
	public int selectCustCountByConditions();
	
	/**
	 * 统计符合条件的员工 
	 */
	public List<Customer> selectCustCountByConditions(int pageNo,int pageSize);
	
	
	public Customer selectOne(int custid);
	
	
    public int updateCust(Customer cust) ;
    
    public int deleteCust(Customer cust);
    
    public int insertCust(Customer cust);

    public int Max() ;//求id 最大值
}
