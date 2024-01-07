package controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import service.DocumentDao;
import service.UserDao;

@Controller
public class FileUploadController {
	
private final DocumentDao documentdao;
	
	@Autowired
	FileUploadController(DocumentDao documentdao){
		this.documentdao = documentdao;
	}
	@ResponseBody
    @PostMapping("/form")
    public String handleFormUpload(@RequestParam("file") MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			documentdao.uploaddocument(authentication.getName(), bytes);
           return "redirect:uploadSuccess";
       } else {
           return "redirect:uploadFailure";
       }
    }

}