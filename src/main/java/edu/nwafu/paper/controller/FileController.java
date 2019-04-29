package edu.nwafu.paper.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

/**
 * @author TinChiWay
 * @data 2018/5/29
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable int id) throws IOException {
        String filePath = "E:/paper/" + id + ".txt";
        File file = new File(filePath);
        String fileName = new String(file.getName().getBytes("utf-8"), "ISO-8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment",fileName );
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }
}
