package com.cmpay.service.bank.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装分页和排序参数及分页查询结果.
 */
public class BasePage<T> {

	public final static Integer DEFAULT_PAGESIZE = 20;

	public final static Integer DEFAULT_PAGE = 1;

	private Integer pageNo = DEFAULT_PAGE;

	private Integer pageSize = DEFAULT_PAGESIZE;

	private Long totalCount = null;

	private List<T> list = null;

	public BasePage() {
	}

	public BasePage(Integer pageNo, Integer pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	public BasePage(Integer pageNo, List<T> list, Integer pageSize, Long totalCount) {
		this.pageNo = pageNo;
		this.list = list;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}

	/** 第一条记录在结果集中的位置,序号从0开始 */
	public Integer getStart() {
		if (pageNo < 0 || pageSize < 0) {
			return -1;
		} else {
			return ((pageNo - 1) * pageSize);
		}
	}

	/** 总页数 */
	public Long getTotalPageCount() {
		Long count = totalCount / pageSize;
		if (totalCount % pageSize > 0) {
			count++;
		}
		return count;
	}

	/** 是否还有下一页 */
	public boolean isHasNextPage() {
		return (pageNo + 1 <= getTotalPageCount());
	}

	/** 返回下页的页号,序号从1开始 */
	public Integer getNextPage() {
		if (isHasNextPage()) {
			return pageNo + 1;
		} else {
			return pageNo;
		}
	}

	/** 是否还有上一页 */
	public boolean isHasPrePage() {
		return (pageNo - 1 >= 1);
	}

	/** 返回上页的页号,序号从1开始 */
	public Integer getPrePage() {
		if (isHasPrePage()) {
			return pageNo - 1;
		} else {
			return pageNo;
		}
	}

	/** 每页的记录数量 */
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/** 当前页的页号,序号从1开始 */
	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer page) {
		this.pageNo = page;
	}

	/** 页内的数据列表 */
	public List<T> getList() {
		if (totalCount==null||totalCount==0) {
			return new ArrayList<T>();
		}
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	/** 总记录数量 */
	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
}
