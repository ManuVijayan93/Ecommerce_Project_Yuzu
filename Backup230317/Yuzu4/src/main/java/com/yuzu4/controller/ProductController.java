package com.yuzu4.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yuzu.dao.CategoryDAO;
import com.yuzu.dao.ProductDAO;
import com.yuzu.dao.SupplierDAO;
import com.yuzu.domain.Category;
import com.yuzu.domain.Product;
import com.yuzu.domain.Supplier;

@Controller
public class ProductController {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private Product product;
	@Autowired(required = true)
	private CategoryDAO categoryDAO;
	@Autowired
	private Category category;

	@Autowired(required = true)
	private SupplierDAO supplierDAO;
	@Autowired
	private Supplier supplier;

	// add Product
	// method 1 for add Product
	@RequestMapping("/manage_product_create")
	public ModelAndView createProductForm() {
		System.out.println("createProductForm called*****************");
		ModelAndView mv = new ModelAndView("createProductForm");
		mv.addObject("createProductObj", product);
		mv.addObject("productList", this.productDAO.list());
		mv.addObject("category", new Category());
		mv.addObject("categoryList", this.categoryDAO.list());
		mv.addObject("supplier", new Supplier());
		mv.addObject("supplierList", this.supplierDAO.list());
		return mv;

	}

	// add Product
	// method 2 for add Product
	@RequestMapping(value = "/manage_product_create", method = RequestMethod.POST)
	public ModelAndView createProduct(@Valid @ModelAttribute(value = "createProductObj") Product product, Model model,
			BindingResult result) {
		System.out.println("createProduct called****");
		ModelAndView mv = new ModelAndView("adminHome");
		if (result.hasErrors())
			return new ModelAndView("createProductForm");

		Category category = categoryDAO.getCategoryByName(product.getCategory().getName());
		System.out.println(category.getId() + ":" + category.getName() + ":" + category.getDescription());

		Supplier supplier = supplierDAO.getSupplierByName(product.getSupplier().getName());
		System.out.println(supplier.getId() + ":" + supplier.getName() + ":" + supplier.getAddress());

		product.setCategory(category);
		product.setSupplier(supplier);
		productDAO.save(product);
		mv.addObject("isUserClickedProducts", "true");
		mv.addObject("productList", productDAO.list());

		return mv;

	}

	// delete Product
	@RequestMapping(value = "/manage_product_delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@PathVariable(value = "id") int id, Model model) {
		System.out.println("deleteProduct called****");

		ModelAndView mv = new ModelAndView("adminHome");
		Product product = (Product) productDAO.getProductByID(id);
		if (productDAO.delete(product)) {
			mv.addObject("messsage", "Successfully deleted the product");
		} else {
			mv.addObject("messsage", "Not able to delete the  product,so please contact administrator");
		}

		model.addAttribute("productList", productDAO.list());
		mv.addObject("isUserClickedProducts", "true");
		return mv;

	}

	// edit Product
	// method 1 for edit Product
	@RequestMapping(value = "/manage_product_edit/{id}", method = RequestMethod.GET)
	public ModelAndView getEditProductForm(@PathVariable(value = "id") int id, HttpServletRequest request) {
		System.out.println("getEditProductForm called******");

		Product product = (Product) this.productDAO.getProductByID(id);
		System.out.println(product);

		// ModelAndView mv = new ModelAndView("editProductForm");
		// request.setAttribute("editProductObj", product);
		ModelAndView mv = new ModelAndView("editProductForm");
		mv.addObject("editProductObj", product);
		mv.addObject("isUserClickedProducts", "true");
		return mv;
	}

	// edit Product
	// method 2 for edit Product
	@RequestMapping(value = "/manage_product_edit", method = RequestMethod.POST)
	public ModelAndView editProduct(@ModelAttribute(value = "editProductObj") Product product, Model model) {
		System.out.println("editProduct  called****");

		this.productDAO.update(product);
		ModelAndView mv = new ModelAndView("adminHome");
		model.addAttribute("productList", productDAO.list());
		mv.addObject("isUserClickedProducts", "true");
		return mv;

	}

}
