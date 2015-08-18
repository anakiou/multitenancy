package com.anakiou.mt.web;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anakiou.mt.domain.Employee;
import com.anakiou.mt.repository.EmployeeRepository;

@Controller
@RequestMapping("/{tenantid}")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@RequestMapping
	public String employees(@PathVariable String tenantid, Model model) {
		model.addAttribute("tenantid", tenantid);
		model.addAttribute("employee", new Employee());
		model.addAttribute("employees", employeeRepository.findAll());
		return "employees";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Transactional
	public String addEmployee(@ModelAttribute Employee employee, Model model) {
		employeeRepository.save(employee);
		return "redirect:/{tenantid}";
	}
}
