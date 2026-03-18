package com.nareshit.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nareshit.entity.FilesEntity;
import com.nareshit.model.ResponseMessage;
import com.nareshit.model.userRequestDto;
import com.nareshit.repository.FileRepo;
import com.nareshit.service.ifileService;
import com.nareshit.utility.Constants;
//import org.springframework.web.bind.annotation.RequestBody;

//@Controller
@RestController
public class FileController {

	@Autowired
	private FileRepo fileRepo;

	@Autowired
	private ifileService service;

	@PostMapping("/uploadfiles") // capturing the query param like '?'
	public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file) throws IOException { // <-args name must
																									// be match with
																									// postman key name

		FilesEntity fss = new FilesEntity();
		fss.setFileName(file.getOriginalFilename());
		fss.setFileType(file.getContentType());
		fss.setData(file.getBytes());

		fileRepo.save(fss);
		return ResponseEntity.ok("File insert successfully :" + file.getOriginalFilename());
	}

	@PostMapping("/uploadMultifiles")
	public ResponseEntity<List<Object>> uploadMultiFile(@RequestParam MultipartFile[] files) {

		List<Object> response = Arrays.stream(files).map(elements -> {
			try {
				return uploadFile(elements);
			} catch (Exception e) {
				return "file upload failed" + e.getLocalizedMessage();
			}
		}).collect(Collectors.toList());
		return ResponseEntity.ok(response);

	}

//	@PostMapping("/userRegistersuploadMultifiles")
//	public ResponseEntity<ResponseMessage> createRegisterUploadfile(@RequestParam String JsonData, @RequestParam MultipartFile[] files)  {
//  try {
//	  userRequestDto userRegisterDTO = new ObjectMapper().readValue(JsonData,userRequestDto.class);  //converting jsonData to java obj(userRequestDto)
//
//		UserRegister userRegister= UserRegisterService.uploadMultiUserRegister(userRegisterDTO);
//	   if(userRegister!=null) {
//		   return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constants.SUCCESS, "online bookstore save successfully",userRegister));
//	   }
//} catch (Exception e) {
//	return ResponseEntity<ResponseMessage>
//}

//	}
	@PostMapping("/userRegistersUploadMultifiles")
	public ResponseEntity<ResponseMessage> createRegisterUploadfile(@RequestParam String Json,
			@RequestParam MultipartFile[] files) {
		try {
			userRequestDto userRequestDTO = new ObjectMapper().readValue(Json, userRequestDto.class);
			Map<String, Object> registerUploadfile = service.createRegisterUploadfile(userRequestDTO, files);
			if (registerUploadfile == null) {

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(
						HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILED, "Data does not inserted"));
			}else {
				return ResponseEntity.ok(
						new ResponseMessage(HttpURLConnection.HTTP_OK, Constants.SUCCESS, "Data inserted Successfully",registerUploadfile));
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseMessage(HttpURLConnection.HTTP_INTERNAL_ERROR, Constants.FAILURE, "Server Error"));

			}




	}

}
