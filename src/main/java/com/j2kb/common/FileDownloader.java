package com.j2kb.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/download")
public class FileDownloader {

	@GetMapping(value="image/{imagePath}", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> fileDowload(@PathVariable("imagePath") String imagePath){
		InputStream imageStream = null;
		byte[] imageByteArray = null;
		ResponseEntity<byte[]> entity = null;
		try {
			// 여기다가 서버 이미지 폴더 경로 넣어주시면 됩니다..! 
			imageStream = new FileInputStream("C:\\Users\\ME\\Downloads\\" + imagePath + ".jpg");
			imageByteArray = IOUtils.toByteArray(imageStream);
			entity = new ResponseEntity<byte[]>(imageByteArray,HttpStatus.OK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally{
			try {
				imageStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return entity;
		
	}
}
