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
@RequestMapping("jsps/file.do")

public class FileController implements ServletContextAware{
	private ServletContext servletContext;
	
	@Override
	public void setServletContext(ServletContext arg0) {
		this.servletContext = arg0;
	}
	
	@RequestMapping(params="method=upload",method = RequestMethod.POST)
	public String uploadFile(String fileName,@RequestParam("file")CommonsMultipartFile file) {
		if (!file.isEmpty()) {
			String path = this.servletContext.getRealPath("/upload");
			String oriFileName = file.getOriginalFilename();
			
			String fileType = oriFileName.substring(oriFileName.lastIndexOf("."));
			String newFileName = fileName + fileType;
			File newFile = new File(path + "/" + newFileName);
			try {
				file.getFileItem().write(newFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "/jsps/upload";
	}

}
