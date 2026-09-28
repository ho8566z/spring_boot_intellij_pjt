package com.office.calendar.planner.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Slf4j
@Service
public class UploadFileService {

    public String upload(String id, MultipartFile file) {
        log.info("upload()");

        boolean result = false;

        String fileOriName = file.getOriginalFilename(); // abc.jpg
        String fileExtension = fileOriName.substring(fileOriName.lastIndexOf("."), fileOriName.length()); // .jpg
        String uploadDir = "c:\\calendar\\upload\\" + id;

        UUID uuid = UUID.randomUUID();      // afawer-lui34q-23asdf
        String uniqueFileName = uuid.toString().replaceAll("-", "");    // afawerlui34q23asdf

        File saveFile = new File(uploadDir + "\\" + uniqueFileName + fileExtension); //afawerlui34q23asdf.jpg
        if (!saveFile.exists())
            saveFile.mkdirs();

        try {

            file.transferTo(saveFile);
            result = true;

        } catch (Exception e) {
            e.printStackTrace();

        }

        if (result) {
            log.info("FILE UPLOAD SUCCESS!!");
            return uniqueFileName + fileExtension;

        } else {
            log.info("FILE UPLOAD FAIL!!");
            return null;

        }

    }

}
