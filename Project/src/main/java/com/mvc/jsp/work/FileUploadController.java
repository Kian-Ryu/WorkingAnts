package com.mvc.jsp.work;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.google.gson.JsonObject;



@RestController
public class FileUploadController {
   static String uploadPath="C:\\Users\\gram\\git\\Project6\\Project\\src\\main\\resources\\static\\upload";
   UUID uuid = null;
   String tempDir = "C:\\Temp";
   HttpServletRequest req;
   
   
   @RequestMapping(value="/jsp/UploadFile", produces = "application/json")
   @ResponseBody 
   public String uploadSummernoteImageFile(@RequestParam("file") 
                                 MultipartFile multipartFile, HttpServletRequest request )  {
      JsonObject jsonObject = new JsonObject();
      
      // 내부경로로 저장
      String contextRoot = request.getSession().getServletContext().getRealPath("/");
      String fileRoot = contextRoot+"/resources/upload/";
            
      String originalFileName = multipartFile.getOriginalFilename();   //오리지널 파일명
      String extension = originalFileName.substring(originalFileName.lastIndexOf("."));   //파일 확장자
      String savedFileName = UUID.randomUUID() + extension;   //저장될 파일 명
      
      File targetFile = new File(fileRoot + savedFileName);   
      try {
         InputStream fileStream = multipartFile.getInputStream();
         FileUtils.copyInputStreamToFile(fileStream, targetFile);   //파일 저장
         jsonObject.addProperty("url", "/resources/upload/"+savedFileName); // contextroot + resources + 저장할 내부 폴더명
         jsonObject.addProperty("responseCode", "success");
      } catch (IOException e) {
         FileUtils.deleteQuietly(targetFile);   //저장된 파일 삭제
         jsonObject.addProperty("responseCode", "error");
         e.printStackTrace();
      }
      String a = jsonObject.toString();
      return a;
   }
   
}