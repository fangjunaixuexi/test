package com.fj.service;

import java.util.List;

import com.fj.model.Section;
import com.fj.model.User;
import com.fj.model.vo.PageBean;



public interface Iservice {
	

	List<Section> findSection();

	void Addsection(Section section);

	void DeleteSection(Integer id);

	void UpdataSection(Section section);

	Section selectone(Integer id);

	User findByName(User user);

	PageBean<Section> findDepatrPageBean(int currentPageInt, int currentCount);



}
