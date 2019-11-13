package com.zc.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@RequestMapping("/toUpload.do")
	public String toUpload() {
		return "upload";
	}
	
	@RequestMapping(value="/upload.do")
	public String upload(@RequestParam(value="file" , required = false)
			MultipartFile file , HttpServletRequest req , ModelMap model) {
				String path = req.getSession().getServletContext().getRealPath("upload") ;
				String fileName = file.getOriginalFilename();
				System.out.println(path);
				File targetFile = new File(path , fileName) ;
			
				//exists()测试此抽象路径名表示的文件或目录是否存在
				if (!targetFile.exists()) {
					targetFile.mkdirs(); //mkdirs()生成所有目录 ,可以建立多级文件夹
				}
				//保存
				try {
					file.transferTo(targetFile);
					model.addAttribute("fileUrl", req.getContextPath()+"/upload/" + fileName) ;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return "result";
	}
	
	@RequestMapping(value="/uploads.do")
	public String uploads(@RequestParam(value="file" , required = false) MultipartFile[] files ,
			HttpServletRequest req , ModelMap model) {
		List <String> urls = new ArrayList<String>();
		for (MultipartFile	 file : files) {
			String path = req.getSession().getServletContext().getRealPath("upload") ;
			String filename = file.getOriginalFilename();
			System.out.println(path);
			File targetfile	 = new File(path	, filename) ;
			if (!targetfile.exists()) {
				targetfile.mkdirs();
			}
			try {
				file.transferTo(targetfile);
				urls.add(req.getContextPath() + "/upload/" + filename) ;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("fileUrls", urls) ;
		return "result" ;
	}
}
