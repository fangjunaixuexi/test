package com.fj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fj.model.Section;
import com.fj.model.User;
import com.fj.model.vo.PageBean;
import com.fj.service.Iservice;



@Controller
@RequestMapping(value="/user")
public class ShopAction {
	@Autowired
	private Iservice ser;
	
	@RequestMapping(value="tologin")
	public String tologin(){
		return "login";
	}
	//��֤����
	@RequestMapping(value="/toyz")

	public String doLogin(User user,HttpSession session){
		User sessionUser = ser.findByName(user);
	
		if(sessionUser!=null) {
			if(sessionUser.getPassword().equals(user.getPassword())) {
				session.setAttribute("sessionUser", sessionUser);
				return "index";
			}else {
				return "login";
			}
		}
			return "login";
	
	}
	
	@RequestMapping(value="toindex")
	public String toindex() {
		return "index";
	}
	//�������в���
	@RequestMapping(value="tosection")
	public String tosection(HttpServletRequest request) {
		// ��ñ�������currentPage
				String currentPage = request.getParameter("currentPage");
				int currentPageInt = 1;
				if (currentPage != null && !"".equals(currentPage)) {
					currentPageInt = Integer.parseInt(currentPage);
				}
				// ����ÿҳ��ʾ����������
				int currentCount = 3;

				// ����ҵ�� �õ�pageBean����
				PageBean<Section> pageBean = ser.findDepatrPageBean(currentPageInt, currentCount);
				// ��װ���ݵ������
				request.setAttribute("pageBean", pageBean);
				return "section";
	}
	//��ת����Ӳ���AddSectionҳ��
	@RequestMapping(value="toAddSection")
	public String toAddSection() {
		return "AddSection";
	}
	//��Ӳ��Ų���toaddse
	@RequestMapping(value="toaddse")
	public String toaddse(Section section) {
		System.out.println(section.toString());
		ser.Addsection(section); 
		
		return "redirect:tosection";
	}
	//ɾ�����Ų���toDeleteSection
	@RequestMapping(value="toDeleteSection")
	public String toDeleteSection(Integer id) {
		ser.DeleteSection(id); 
		
		return "redirect:tosection";
	}
	//�޸Ĳ���ҳ��toUpdata
	@RequestMapping(value="toUpdata")
	public String toUpdata(Integer id,HttpSession session,Section sect) {
		sect=ser.selectone(id);
		session.setAttribute("sect",sect);
		return "toUpdata";
	}
	//�޸Ĳ��Ų���
	@RequestMapping(value="toUpdateSection")
	public String toUpdateSection(Section section) {
		System.out.println(section.getSname());
		ser.UpdataSection(section); 
		return "redirect:tosection";
	}
}
