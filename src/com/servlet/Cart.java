package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Order;
import com.bean.OrderItem;
import com.bean.Product;
import com.bean.User;
import com.service.OrderItemService;
import com.service.OrderService;
import com.service.impl.OrderItemServiceImpl;
import com.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int productid=Integer.parseInt(request.getParameter("productId"));
		Order order=new Order();
		order.setUser((User)request.getSession().getAttribute("user"));
		order.setStatus(1);
		OrderService os = new OrderServiceImpl();
		os.add(order);
		
		OrderItem orderItem =new OrderItem();
		Product p = new Product();
		p.setId(productid);
		orderItem.setProduct(p);
		orderItem.setProductcount(1);
		orderItem.setSelasOrder(order);

		OrderItemService ois = new OrderItemServiceImpl();
		ois.add(orderItem);
		
	}

}
