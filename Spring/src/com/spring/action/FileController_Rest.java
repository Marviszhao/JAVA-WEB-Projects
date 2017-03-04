package com.spring.action;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/file")
public class FileController_Rest implements ServletContextAware{
private ServletContext servletContext;
	
	@Override
	public void setServletContext(ServletContext arg0) {
		this.servletContext = arg0;
	}
	
	@RequestMapping(value="/upload",method = RequestMethod.POST)
	public String uploadFile(String fileName,@RequestParam("file")CommonsMultipartFile file) {
		if (!file.isEmpty()) {
			String path = this.servletContext.getRealPath("/upload_rest");
			String oriFileName = file.getOriginalFilename();
			
			String fileType = oriFileName.substring(oriFileName.lastIndexOf("."));
			String newFileName = fileName + fileType;
			File newFile = new File(path + "/" + newFileName);
			 //�ж�Ŀ���ļ����ڵ�Ŀ¼�Ƿ����  
	        if(!newFile.getParentFile().exists()) {  
	            //���Ŀ���ļ����ڵ�Ŀ¼�����ڣ��򴴽���Ŀ¼  
	            System.out.println("Ŀ���ļ�����Ŀ¼�����ڣ�׼����������");  
	            if(!newFile.getParentFile().mkdirs()) {  
	                System.out.println("����Ŀ���ļ�����Ŀ¼ʧ�ܣ�");  
	            }  
	        }  
			try {
				file.getFileItem().write(newFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "/jsps/upload_rest";
	}
}
