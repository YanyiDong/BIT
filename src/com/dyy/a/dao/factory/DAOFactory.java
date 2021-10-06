package com.dyy.a.dao.factory;

import com.dyy.a.dao.UserDAO;
import com.dyy.a.dao.impl.UserDAOMysqlImpl;


/**
 * 
 * @author Administrator
 * 使用简单工厂设计模式,返回某种类型的DAO
 */
public class DAOFactory {

	public static UserDAO getDAOInstance(String daoType){
		if(daoType.equalsIgnoreCase("mysql")){
			return  UserDAOMysqlImpl.getInstance();
		}else{
			return null;
		}			
	}
}
