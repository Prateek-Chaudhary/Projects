package com.retail.services;

import java.util.List;

import com.retail.models.CustomerDetails;
import com.retail.models.CustomerOrder;
import com.retail.models.OrderReport;

public interface OrderService {

	void addCustomer(CustomerDetails cd);

	void setCustomerOrder(CustomerOrder co);

	void addOrderReport(OrderReport or);

	List<OrderReport> getOrderReport();

	void deleteReport(int order_no);

	OrderReport getOrder(int order_no);

	List<CustomerOrder> getCustomerOrderList(int customer_no);

	OrderReport getOrderByCustomerId(int cid);

}
