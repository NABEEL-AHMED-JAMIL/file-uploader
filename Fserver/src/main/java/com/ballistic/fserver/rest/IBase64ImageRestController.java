package com.ballistic.fserver.rest;

import com.ballistic.fserver.model.dto.base64.Base64File;
import com.ballistic.fserver.model.dto.base64.Base64FileWithObject;
import com.ballistic.fserver.model.dto.FileWithObject;
import com.ballistic.fserver.model.dto.http.FileInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static com.ballistic.fserver.model.dto.http.FileInfo.FILE_NAME;
import static com.ballistic.fserver.model.dto.http.FileInfo.FILE_SIZE;

public interface IBase64ImageRestController {

    public static final Logger logger = LogManager.getLogger(IBase64ImageRestController.class);

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Note :- This blow url's are my question related to the file's *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public static final String answerUrl = "https://stackoverflow.com/questions/51415819/spring-boot-multipart-file-upload-along-with-json-data/53737185#53737185";
    public static final String questionUrl = "https://stackoverflow.com/questions/53777228/spring-boot-multiple-files-upload-with-multiple-objects";

    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/singleFileUploadWithBase64Object/{folder}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String singleFileUploadWithBase64Object(@PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder, @RequestBody Base64File object);

    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/multipleFileUploadWithBase64Object/{folder}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String multipleFileUploadWithBase64Object(@PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder, @RequestBody List<Base64File> objects);

    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/filesUploadsWithBase64Object/{folder}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String filesUploadsWithBase64Object(@PathVariable(name="bucket-uuid") String bucketUUId,@PathVariable(name="folder") String folder, @RequestBody Base64FileWithObject object);

    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/listOfBase64ObjectsWithSingleFile/{folder}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String listOfBase64ObjectsWithSingleFile(@PathVariable(name="bucket-uuid") String bucketUUId,@PathVariable(name="folder") String folder, @RequestBody Base64FileWithObject object);

    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/listOfBase64ObjectsWithMultipleFiles/{folder}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String listOfBase64ObjectsWithMultipleFiles(@PathVariable(name="bucket-uuid") String bucketUUId,@PathVariable(name="folder") String folder, @RequestBody List<Base64FileWithObject> objects);

    // separate the main list from the object
    public default List<FileWithObject> getRawData(FileWithObject object) {
        this.displayData(object.getRawData());
        return object.getRawData();
    }

    // display the data coming from the client side
    public default  void displayData(List<FileWithObject> rawData) {
        rawData.stream().forEach(fileWithObject -> {
            logger.warn("-----------------------------------");
            if(fileWithObject.getFile() != null) {
                MultipartFile file = fileWithObject.getFile();
                logger.info("File Name :- " + file.getOriginalFilename());
            }
            if(fileWithObject.getData() != null) { logger.info("Data :- " + fileWithObject.getData()); }

            if(fileWithObject.getFiles() != null) {
                fileWithObject.getFiles().stream().forEach((object) -> {
                    MultipartFile file = (MultipartFile) object;
                    logger.info("File's Name :- " + file.getOriginalFilename());
                });
            }
            logger.warn("-----------------------------------");
        });
    }

    public default FileInfo getFileInfo(JSONObject fileInfoJson, FileInfo fileInfo) {
        if(fileInfoJson.has(FILE_NAME) && !fileInfoJson.get(FILE_NAME).equals(null)) { fileInfo.setFile_name(fileInfoJson.getString(FILE_NAME)); }
        if(fileInfoJson.has(FILE_SIZE) && !fileInfoJson.get(FILE_SIZE).equals(null)) { fileInfo.setFile_size(fileInfoJson.getLong(FILE_SIZE)); }

        return fileInfo;
    }

    public default HashMap<String, MultipartFile> getFileHash(HttpServletRequest httpServletRequest) {
        HashMap<String,MultipartFile> filesHash = new HashMap<>();
        MultipartHttpServletRequest multiPartRequest = (MultipartHttpServletRequest) httpServletRequest;
        multiPartRequest.getParameterMap();
        Iterator<String> itr = multiPartRequest.getFileNames();
        while (itr.hasNext()) {
            String fileName = itr.next();
            filesHash.put(fileName, multiPartRequest.getFile(fileName));
        }
        return filesHash;
    }

}