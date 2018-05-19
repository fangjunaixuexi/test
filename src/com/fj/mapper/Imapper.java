package com.fj.mapper;

import java.util.List;

import com.fj.model.Section;
import com.fj.model.User;
import com.fj.model.vo.PageBean;



public interface Imapper {


	List<Section> finSection();

	void Addsection(Section section);

	void DeleteSection(Integer id);

	void UpdataSection(Section section);

	Section selectone(Integer id);

	User findName(User user);

	Integer findDepartTotalCount();

	List<Section> findDepartPageData(PageBean<Section> pageBean1);

}
