package com.nareshit.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nareshit.entity.FilesEntity;
import com.nareshit.entity.UserRegister;
import com.nareshit.model.userRequestDto;
import com.nareshit.repository.FileRepo;
import com.nareshit.repository.UserRegisterRepo;
import com.nareshit.service.ifileService;

@Service
public class fileServiceImpl implements ifileService {

	@Autowired
	private FileRepo fileRepo;
    @Autowired
    private UserRegisterRepo userRegisterRepo;

	@Override
	public  Map<String,Object> createRegisterUploadfile(userRequestDto userRequestDTO,MultipartFile[] files) throws IOException {

		ArrayList<Object> savedFiles=new ArrayList<>();
		UserRegister user=new UserRegister();
		user.setFirstName(userRequestDTO.getFirstName());
		user.setLastName(userRequestDTO.getLastName());
		user.setEmail(userRequestDTO.getEmail());
		user.setPassword( Base64.getEncoder().encodeToString(userRequestDTO.getPassword().getBytes()));
		user.setFirstName(userRequestDTO.getFirstName());
	     userRegisterRepo.save(user);
		 System.err.println("Out");
		 if(files!=null && files.length>0){
			 System.err.println("Entered");
			 for (MultipartFile multipartFile : files) {
				 System.err.println("Entered inside for loop");

				 FilesEntity fss=new FilesEntity();
				 fss.setFileName(multipartFile.getOriginalFilename());
				 fss.setFileType(multipartFile.getContentType());
				 fss.setData(multipartFile.getBytes());
				 fileRepo.save(fss);

				 savedFiles.add(fss);

			}
		 }

		 Map<String, Object> response = new HashMap<>();
		 response.put("filesDetails", savedFiles);
		 response.put("userDetails", userRequestDTO);
		return response;
	}


}
