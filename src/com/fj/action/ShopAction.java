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
	//验证操作
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
	//查找已有部门
	@RequestMapping(value="tosection")
	public String tosection(HttpServletRequest request) {
		// 获得表单的数据currentPage
				String currentPage = request.getParameter("currentPage");
				int currentPageInt = 1;
				if (currentPage != null && !"".equals(currentPage)) {
					currentPageInt = Integer.parseInt(currentPage);
				}
				// 设置每页显示的数据条数
				int currentCount = 3;

				// 传递业务 得到pageBean对象
				PageBean<Section> pageBean = ser.findDepatrPageBean(currentPageInt, currentCount);
				// 封装数据到域对象
				request.setAttribute("pageBean", pageBean);
				return "section";
	}
	//跳转到添加部门AddSection页面
	@RequestMapping(value="toAddSection")
	public String toAddSection() {
		return "AddSection";
	}
	//添加部门操作toaddse
	@RequestMapping(value="toaddse")
	public String toaddse(Section section) {
		System.out.println(section.toString());
		ser.Addsection(section); 
		
		return "redirect:tosection";
	}
	//删除部门操作toDeleteSection
	@RequestMapping(value="toDeleteSection")
	public String toDeleteSection(Integer id) {
		ser.DeleteSection(id); 
		
		return "redirect:tosection";
	}
	//修改部门页面toUpdata
	@RequestMapping(value="toUpdata")
	public String toUpdata(Integer id,HttpSession session,Section sect) {
		sect=ser.selectone(id);
		session.setAttribute("sect",sect);
		return "toUpdata";
	}
	//修改部门操作
	@RequestMapping(value="toUpdateSection")
	public String toUpdateSection(Section section) {
		System.out.println(section.getSname());
		ser.UpdataSection(section); 
		return "redirect:tosection";
	}
}
