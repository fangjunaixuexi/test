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

	
	//���Ҳ���
	@Override
	public List<Section> findSection() {
		
		return map.finSection();
	}
	//��Ӳ���
	@Override
	public void Addsection(Section section) {
		map.Addsection(section);
		
	}
	//ɾ������
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
				//���depart������
				Integer totalCount = map.findDepartTotalCount();
				int totalPage = (int) Math.ceil(totalCount/(currentCount*1.0));
				//offset��ǰ��ʼ���ݵ��±�
				int offset = (currentPageInt-1)*currentCount;
				PageBean<Section> pageBean1 = new PageBean<>();
				pageBean1.setOffset(offset);
				pageBean1.setCurrentCount(currentCount);
				//��÷�ҳ�������
				List<Section> pageData = map.findDepartPageData(pageBean1);
				//��װpageBean
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
