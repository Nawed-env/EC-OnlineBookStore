package com.nareshit.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.nareshit.model.userRequestDto;

public interface ifileService {

	public Map<String,Object> createRegisterUploadfile(userRequestDto userRequestDTO,MultipartFile[] files) throws IOException;
}
