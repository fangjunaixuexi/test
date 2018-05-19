package com.fj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fj.mapper.Imapper;
import com.fj.model.Section;
import com.fj.model.User;
import com.fj.model.vo.PageBean;



@Service
public class IserviceImpl implements Iservice {
	@Autowired
	private Imapper map;

	
	//查找部门
	@Override
	public List<Section> findSection() {
		
		return map.finSection();
	}
	//添加部门
	@Override
	public void Addsection(Section section) {
		map.Addsection(section);
		
	}
	//删除部门
	@Override
	public void DeleteSection(Integer id) {
		map.DeleteSection(id);
		
	}
	@Override
	public void UpdataSection(Section section) {
		map.UpdataSection(section);
		
	}
	@Override
	public Section selectone(Integer id) {
		
		return map.selectone(id);
	}
	@Override
	public User findByName(User user) {
		
		return map.findName(user);
	}
	@Override
	public PageBean<Section> findDepatrPageBean(int currentPageInt, int currentCount) {
				//获得depart总条数
				Integer totalCount = map.findDepartTotalCount();
				int totalPage = (int) Math.ceil(totalCount/(currentCount*1.0));
				//offset当前开始数据的下标
				int offset = (currentPageInt-1)*currentCount;
				PageBean<Section> pageBean1 = new PageBean<>();
				pageBean1.setOffset(offset);
				pageBean1.setCurrentCount(currentCount);
				//获得分页后的数据
				List<Section> pageData = map.findDepartPageData(pageBean1);
				//封装pageBean
				PageBean<Section> pageBean = new PageBean<>();
				pageBean.setCurrentCount(currentCount);
				pageBean.setCurrentPage(currentPageInt);
				pageBean.setOffset(offset);
				pageBean.setPageData(pageData);
				pageBean.setTotalCount(totalCount);
				pageBean.setTotalPage(totalPage);
				return pageBean;
	}




}
