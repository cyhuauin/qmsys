package com.cust.qmsys.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	public static <T> T request2Bean(HttpServletRequest request,Class<T> beanClass){
		try {
			//建立封装数据的bean
			T bean = beanClass.newInstance();
			Enumeration e = request.getParameterNames();
			while(e.hasMoreElements()){
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	//赋值
	public static void copyBean(Object src,Object dest){
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			System.out.println("对象转换");
			e.printStackTrace();
		} 
	}
}
