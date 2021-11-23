package com.mybang.khweb.controller.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/file")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class FileController {

    @PostMapping("/uploadVillaImg")
    @ResponseBody
    public String requestUploadVillaFile(
            // @RequestParam("fileList") List<MultipartFile> fileList) {
            @RequestParam("villaList") List<MultipartFile> villaList) {

        log.info("requestUploadFile(): " + villaList);

        try {
            // 결국 저장되는 위치가 images/사진파일명.확장자
            // images/아이디/사진파일명.확장자
            for (MultipartFile multipartFile : villaList) {
                log.info("requestUploadFile(): Make File");
                FileOutputStream writer = new FileOutputStream("C:\\JAVASTUDY\\study_team_project\\proj\\MyBang\\frontend\\src\\assets\\villaUploadImage\\"
                        + multipartFile.getOriginalFilename());
                writer.write(multipartFile.getBytes());
                writer.close();
            }

            /*
            FileOutputStream writer = new FileOutputStream("./images/" + fileList.getOriginalFilename());
            writer.write(fileList.getBytes());
            writer.close();
             */
        } catch (Exception e) {
            return "Upload Fail!!!";
        }

        log.info("requestUploadFile(): Success!!!");

        return "Upload Success!!!";
    }

    @PostMapping("/uploadOneroomImg")
    @ResponseBody
    public String requestUploadOneroomFile(
            @RequestParam("oneroomList") List<MultipartFile> oneroomList) {

        log.info("requestUploadFile(): " + oneroomList);

        try {
            // 결국 저장되는 위치가 images/사진파일명.확장자
            // images/아이디/사진파일명.확장자
            for (MultipartFile multipartFile : oneroomList) {
                log.info("requestUploadFile(): Make File");
                FileOutputStream writer = new FileOutputStream("C:\\JAVASTUDY\\study_team_project\\proj\\MyBang\\frontend\\src\\assets\\oneroomUploadImage\\"
                        + multipartFile.getOriginalFilename());
                writer.write(multipartFile.getBytes());
                writer.close();
            }

        } catch (Exception e) {
            return "Upload Fail!!!";
        }

        log.info("requestUploadFile(): Success!!!");

        return "Upload Success!!!";
    }

    @PostMapping("/uploadOfficetelImg")
    @ResponseBody
    public String requestUploadOfficetelFile(
            @RequestParam("officetelList") List<MultipartFile> officetelList) {

        log.info("requestUploadFile(): " + officetelList);

        try {
            // 결국 저장되는 위치가 images/사진파일명.확장자
            // images/아이디/사진파일명.확장자
            for (MultipartFile multipartFile : officetelList) {
                log.info("requestUploadFile(): Make File");
                FileOutputStream writer = new FileOutputStream("C:\\JAVASTUDY\\study_team_project\\proj\\MyBang\\frontend\\src\\assets\\officetelUploadImage\\"
                        + multipartFile.getOriginalFilename());
                writer.write(multipartFile.getBytes());
                writer.close();
            }

        } catch (Exception e) {
            return "Upload Fail!!!";
        }

        log.info("requestUploadFile(): Success!!!");

        return "Upload Success!!!";
    }
}
