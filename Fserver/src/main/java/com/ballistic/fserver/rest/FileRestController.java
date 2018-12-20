package com.ballistic.fserver.rest;

import com.ballistic.fserver.model.bean.Base64File;
import com.ballistic.fserver.model.bean.Base64FileWithObject;
import com.ballistic.fserver.model.bean.FileWithObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/* * * * * * * * * * * * * * * * * *
 *  Note :- File-Management-System *
 * * * * * * * * * * * * * * * * * */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class FileRestController extends BucketRestController implements IBase64ImageRestController {

    private static final Logger logger = LogManager.getLogger(FileRestController.class);
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Note :- This blow url's are my question related to the file's *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    private static String answerUrl = "https://stackoverflow.com/questions/51415819/spring-boot-multipart-file-upload-along-with-json-data/53737185#53737185";
    private static String questionUrl = "https://stackoverflow.com/questions/53777228/spring-boot-multiple-files-upload-with-multiple-objects";

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * * *
     * Note :- Ping-Pong Rest-Api Work With Angular-+ version  *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @RequestMapping(value = "/filestore/ballistic/appsport.com/ping",
            method = RequestMethod.GET)
    public String pingPong() { return pingResponse; }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * *  *
     * Note :- Single-File Rest-Api Work With Angular-+ version *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * *  */
    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/singleFileUpload/{folder}",
            method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String singleFileUpload(
            @PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder,
            @RequestParam(name = "file") MultipartFile file) { // file
        return pingResponse;
    }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * * * * *
     * Note :- Multiple-File's Rest-Api Work With Angular-+ version*
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/multipleFileUpload/{folder}",
            method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String multipleFileUpload(
            @PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder,
            @RequestParam(name = "files") Set<MultipartFile> files) { // file's
        return pingResponse;
    }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * * * * * * * * **
     * Note :- Single-File With Object Rest-Api Work With Angular-+ version *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * **/
    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/singleFileUploadWithObject/{folder}",
            method = RequestMethod.POST)
    @ResponseBody
    public String singleFileUploadWithObject(
            @PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder,
            FileWithObject rawData) { // rawData => (file, data)
        return pingResponse;
    }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * * * * * * * * * *
     * Note :- Multiple-File With Object Rest-Api Work With Angular-+ version*
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/multipleFilesUploadWithObject/{folder}",
            method = RequestMethod.POST)
    @ResponseBody
    // api work
    public String multipleFileUploadWithObject(
            @PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder,
            FileWithObject rawData) { // rawData => (files, data)
        return pingResponse;
    }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * * * * * * * * * * *
     * Note :- Multiple-File's With Object Rest-Api Work With Angular-+ version*
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/filesUploadsWithObject/{folder}",
            method = RequestMethod.POST)
    @ResponseBody
    // api work
    public String filesUploadsWithObject(
            @PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder,
            FileWithObject rawData) { // rawData => (file, files, data)
        return pingResponse;
    }

    /* * * * * * * *
     * Pending Task*
     * * * * * * * */
    @RequestMapping(value="/filestore/{bucket-id}/appsport.com/{folder}", method = RequestMethod.POST)
    @ResponseBody
    public String uploadMultiFiles(HttpServletRequest request) {
        return pingResponse;
    }


    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/listOfObjectsWithSingleFile/{folder}",
            method = RequestMethod.POST)
    @ResponseBody
    public String listOfObjectsWithSingleFile(
            @PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder,
            Set<FileWithObject> rawData) { // [{file,data},....]
        return pingResponse;
    }

    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/listOfObjectsWithMultipleFiles/{folder}",
            method = RequestMethod.POST)
    @ResponseBody
    public String listOfObjectsWithMultipleFiles(
            @PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder,
            Set<FileWithObject> rawData) { // [{files,data},....]
        return pingResponse;
    }
	
	@RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/listOfObjectsWithFiles/{folder}",
            method = RequestMethod.POST)
    @ResponseBody
    public String listOfObjectsWithFiles(
            @PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder,
            Set<FileWithObject> rawData) { // [{file,files,data},....]
        return pingResponse;
    }

    @Override
    public String singleFileUploadWithBase64Object(String bucketUUId, String folder, Base64File base64File) {
        return pingResponse;
    }

    @Override
    public String multipleFileUploadWithBase64Object(String bucketUUId, String folder, Set<Base64File> base64Files) {
        return pingResponse;
    }

    @Override
    public String listOfBase64ObjectsWithSingleFile(String bucketUUId, String folder, Base64FileWithObject base64FileWithObject) {
        return pingResponse;
    }

    @Override
    public String listOfBase64ObjectsWithMultipleFiles(String bucketUUId, String folder, Set<Base64FileWithObject> base64FileWithObjects) {
        return pingResponse;
    }
	
    @Override
    public String filesUploadsWithBase64Object(String bucketUUId, String folder, Base64FileWithObject base64FileWithObject) {
        return pingResponse;
    }

}