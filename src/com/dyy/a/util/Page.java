package com.dyy.a.util;

import java.util.List;

/**
 * 
 * @author Administrator
 *  分页的工具类，封装分页所需的数据，并提供泛型支持
 * @param <T>
 */
public class Page<T> {
	
	private int pageNo; // 当前页
	private int pageSize;  // 每页的大小
	private int pageCount;  //总页数
	private int  totalCount;  // 总记录数
	private List<T> list;   // 每页保存的数据（对象集合）
		
	public Page(){
		super();
	}
	
	public Page(int pageNo,int pageSize){
		//当页数小于1的时候都显示第一页，没有小于0的页数
		this.pageNo = pageNo >1 ? pageNo:1;
		this.pageSize = pageSize;
	}
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		// 设置总页数
		this.pageCount = totalCount / pageSize;
		//当没有整除或者没有完整的一页时，页数是需要+1
		if(totalCount % pageSize >0){
			pageCount++;
		}
		// 有记录时，并且是最后一页的时候，再点下一页还是在最后一页；
		//没有记录时，避免将 pageCount 赋值给 pageNo,pageCount为0，pageNo为1，没有第0页的说法
		if((totalCount >0) && (pageNo > pageCount) ){
			pageNo = pageCount;
		}		
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	
	
	
	
	
	

}
