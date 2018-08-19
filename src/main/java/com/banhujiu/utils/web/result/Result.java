package com.banhujiu.utils.web.result;

import com.banhujiu.mybatis.page.PageBean;

public class Result<T> {
	private Long startTime = System.currentTimeMillis();
	private Long costTime;
	private Integer code;
	private String info;
	protected T data;
	private String uri;
	private int showInfo = 0;

	private Boolean havePage;
	private Integer count;
	private Integer totalPage;
	private Integer pageSize;
	private Integer page;

	public Result() {
		this.code = ResultStatusEnum.OK.getVal();
	}

	public Result(String info) {
		this.code = ResultStatusEnum.OK.getVal();
		this.info = info;
	}

	public Result(Integer code, String info) {
		this.code = code;
		this.info = info;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getCostTime() {
		return costTime;
	}

	public void setCostTime(Long costTime) {
		this.costTime = costTime;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
		this.showInfo = 1;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getShowInfo() {
		return showInfo;
	}

	public void setShowInfo(int showInfo) {
		this.showInfo = showInfo;
	}

	public Boolean getHavePage() {
		return havePage;
	}

	public void setHavePage(Boolean havePage) {
		this.havePage = havePage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	@SuppressWarnings("unchecked")
	public void initRslt(PageBean page) {
		if (page.getTotalPage() != null && page.getTotalPage() > 0) {
			this.setTotalPage(page.getTotalPage());
		}
		this.setPage(page.getPage());
		this.setCount(page.getCount());
		this.setData((T) page.getData());
		this.setPageSize(page.getPageSize());
		if (page.getTotalPage() > page.getPage()) {
			this.setHavePage(Boolean.TRUE);
		}
	}
}
