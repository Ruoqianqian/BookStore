package com.xrq.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.xrq.model.DBOperation;
import com.xrq.model.DataBean;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataBean dat = new DataBean();
		
		//创建一个解析器工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024*1024); //缓冲区大小
		factory.setRepository(new File("D:\\YOHO\\"));  //文件缓存目录
		//文件上传解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(1024*1024 );   //上传数据最大值，默认1M
		upload.setFileSizeMax(1024*1024);   //单个文件最大值
		upload.setHeaderEncoding("utf-8");
		
		try {
			//把表单里的所有request放在一个list里面
			List<FileItem> itemList = upload.parseRequest(new ServletRequestContext(request));
			for(FileItem item:itemList)
			{
				//true则class不是文件（书名、简介等字符串），要将文件和一般的request分开
				if(item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString("utf-8");
					System.out.println("普通参数和值： "+name +" --> "+value);
					if(name.equals("bookId"))  dat.setId(Integer.parseInt(value));
					if(name.equals("bookName")) dat.setBookName(value);
					if(name.equals("bookPrice")) dat.setBookPrice(value);
					if(name.equals("bookAmount")) dat.setBookAmount(value);
					if(name.equals("bookPublisher")) dat.setBookPublisher(value);
					if(name.equals("bookType")) dat.setBookType(value);
					if(name.equals("bookIntro")) dat.setBookIntro(value);
					
				}else
					//当request是文件时（封面照片）
				{
					String fileName = item.getName();  //文件名
					System.out.println("文件名 " +fileName); 
					dat.setBookCover(fileName);
					//返回表单标签name属性的值
				/*	String namede=item.getFieldName();
					System.out.println(namede);*/
					
					InputStream is = item.getInputStream();  //以流的形式返回文件数据内容
					FileOutputStream fos = new FileOutputStream("E:\\eclipse_javaee_workspace\\BookStore\\WebContent\\images\\"+fileName);
					byte[] buff = new byte[1024];
					int len=0;
					while((len=is.read(buff))>0)
					{
						fos.write(buff); 
					}
						fos.close();
					}
				
			}
	    	new DBOperation().insert(dat);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			 
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
