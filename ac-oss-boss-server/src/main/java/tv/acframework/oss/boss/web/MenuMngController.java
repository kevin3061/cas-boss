package tv.acframework.oss.boss.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tv.acframework.oss.boss.entity.User;
import tv.acframework.oss.boss.util.DateUtil;
import org.jasig.cas.client.filter.CasFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tv.acframework.oss.boss.entity.RtsMenu;
import tv.acframework.oss.boss.service.RtsMenuService;
import tv.acframework.exception.ServiceException;
import tv.acframework.web.bean.Message;

@Controller
public class MenuMngController extends BaseController {
	
	@Resource
	private RtsMenuService menuService;

	@RequestMapping(value = "/menu/add", method = RequestMethod.GET)
	public String add(Model model, Integer pid, HttpServletResponse response) throws Exception {
		if(null != pid && pid != 0) {
			RtsMenu menu = menuService.get(pid);
			model.addAttribute("PARENT_MENU", menu);
			if(menu.getGrade() >= 4) {
				addErrorMessage(model, "最高只能添加5级菜单");
				return ERROR_VIEW;
			}
		}
		else {
			pid = 0;
		}
		model.addAttribute("parentId", pid);
		return "menu/add";
	}
	
	@RequestMapping(value = "/menu/edit", method = RequestMethod.GET)
	public String edit(Model model, Integer id, HttpServletResponse response) throws Exception {
		RtsMenu menu = menuService.get(id);
		Integer pid = menu.getParentId();
		if(null != pid && pid != 0) {
			RtsMenu parentMenu = menuService.get(pid);
			model.addAttribute("PARENT_MENU", parentMenu);
		}
		else {
			pid = 0;
		}
		model.addAttribute("parentId", pid);
		model.addAttribute("MENU", menu);
		return "menu/edit";
	}
	
	@RequestMapping(value = "/menu/save")
	public String save(Model model, RtsMenu menu, HttpServletRequest request) {
		try {
			if (menu.getParentId() != 0) {
				RtsMenu parent = menuService.get(menu.getParentId());
				menu.setGrade(parent.getGrade() + 1);
				menu.setBaseUrl(parent.getBaseUrl());
			} else {
				menu.setGrade(0);
			}
			User user = (User)request.getSession().getAttribute(CasFilter.SESSION_USER_KEY);
			menu.setCreateTime(DateUtil.getTodayDate());
			menu.setUpdateTime(DateUtil.getTodayDate());
			menu.setLastOperatorId(user.getId());
			menu.setLastOperatorName(user.getUsername());
			menuService.add(menu);
		} catch (ServiceException e) {
			addErrorMessage(model, e.getMessage());
			return ERROR_VIEW;
		}
		addSuccessMessage(model, "添加菜单成功", "list");
		return SUCCESS_VIEW;

	}
	
	@RequestMapping(value = "/menu/update")
	public String update(Model model, RtsMenu menu, HttpServletRequest request) {
		try {			
			if (menu.getParentId() != 0) {
				RtsMenu parent = menuService.get(menu.getParentId());
				menu.setBaseUrl(parent.getBaseUrl());
				menu.setGrade(parent.getGrade() + 1);
			} else {
				menu.setGrade(0);
			}
			User user = (User)request.getSession().getAttribute(CasFilter.SESSION_USER_KEY);
			menu.setUpdateTime(DateUtil.getTodayDate());
			menu.setLastOperatorId(user.getId());
			menu.setLastOperatorName(user.getUsername());
			menuService.update(menu);
		} catch (ServiceException e) {
			addErrorMessage(model, e.getMessage());
			return ERROR_VIEW;
		}
		addSuccessMessage(model, "修改菜单成功", "list");
		return SUCCESS_VIEW;
	}
	
	@RequestMapping(value = "/menu/list")
	public String list(Model model, HttpServletResponse response) throws Exception {
		List<RtsMenu> list = menuService.findAll();
		model.addAttribute("MENU_LIST", list);
		return "menu/list";
	}
	
	/*@RequestMapping(value = "/menu/delete", method = RequestMethod.GET)
	public String delete(Model model, Integer id, HttpServletResponse response) {
		try {
			RtsMenu menu = menuService.get(id);
			menuService.delete(menu);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		addSuccessMessage(model, "修改菜单成功", "list");
		return SUCCESS_VIEW;
	}*/
	
	@RequestMapping(value = "/menu/delete", method = RequestMethod.POST)
	public @ResponseBody
	Message delete(Integer id) {
		RtsMenu menu;
		try {
			menu = menuService.get(id);
			menuService.delete(menu);
			return SUCCESS_MESSAGE;
		} catch (ServiceException e) {
			return Message.error(e.getMessage());
		}
		
	}

}
