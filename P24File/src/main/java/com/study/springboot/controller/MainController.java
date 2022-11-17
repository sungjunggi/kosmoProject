package com.study.springboot.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class MainController {
	@RequestMapping("/")
	public String root() {
		return "fileForm";
	}
	
	@RequestMapping("/uploading")
	public @ResponseBody String uploading(HttpServletRequest req) {
		int size = 1024*1024*10; // 10MB
		String file="";
		String oriFile = "";
		JSONObject obj = new JSONObject();
		
		try {
			
			String path = ResourceUtils.getFile("classpath:static/upload/").toPath().toString();
			System.out.println( );
			MultipartRequest multi = new MultipartRequest(req, path, size, "UTF-8", new DefaultFileRenamePolicy());
			System.out.println("here");
			Enumeration files = multi.getFileNames();
			String str = (String)files.nextElement();
			
			file = multi.getFilesystemName(str);
			oriFile = multi.getOriginalFileName(str);
			System.out.println("file : "+ file);
			System.out.println("orifile : "+oriFile);
			
			obj.put("success", Integer.valueOf(1));
			obj.put("desc", "업로드 성공");
			
		 }catch(Exception e) {
			 e.printStackTrace();
			 obj.put("success", Integer.valueOf(0));
			 obj.put("desc", "업로드 실패");
		 }
		return obj.toJSONString();
	 }
 }
