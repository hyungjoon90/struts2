package com.bit.struts2.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.bit.struts2.model.GuestDao;
import com.bit.struts2.model.entity.GuestVo;
import com.opensymphony.xwork2.ModelDriven;

public class GuestAction implements ModelDriven<GuestVo>{
	//POJO Plain Old Java Object, 간단히 POJO는 말 그대로 해석을 하면 오래된 방식의 간단한 자바 오브젝트라는 말
	GuestDao dao=new GuestDao();
	Logger log =Logger.getLogger(getClass());
	private List<GuestVo> list;
	private String msg;
	private int idx;
	private GuestVo bean=new GuestVo();
	
	public List<GuestVo> getList() {
		return list;
	}
	
	public GuestVo getBean() {
		return bean;
	}
	
	public void setBean(GuestVo bean) {
		this.bean = bean;
	}
	
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String detail() throws Exception{
		log.debug("detail()");
		bean=dao.selectOne(idx);
		return "success";
	}	
	
	public String list() throws Exception{
		log.debug("list()");
		list=dao.selectAll();
		
		return "success";
	}
	
	public String execute() throws Exception{
		return "success";
	}
	
	public String add() throws Exception{
		dao.insertOne(bean);
		return "success";
	}

	@Override
	public GuestVo getModel() {
		// TODO Auto-generated method stub
		return bean;
	}
}
