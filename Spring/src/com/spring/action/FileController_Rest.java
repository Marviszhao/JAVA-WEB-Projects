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
			 //判断目标文件所在的目录是否存在  
	        if(!newFile.getParentFile().exists()) {  
	            //如果目标文件所在的目录不存在，则创建父目录  
	            System.out.println("目标文件所在目录不存在，准备创建它！");  
	            if(!newFile.getParentFile().mkdirs()) {  
	                System.out.println("创建目标文件所在目录失败！");  
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
