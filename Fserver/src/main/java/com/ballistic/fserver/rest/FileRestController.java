package com.ballistic.fserver.rest;

import com.ballistic.fserver.model.bean.Base64File;
import com.ballistic.fserver.model.bean.Base64FileWithObject;
import com.ballistic.fserver.model.bean.FileWithObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/* * * * * * * * * * * * * * * * * *
 *  Note :- File-Management-System *
 * * * * * * * * * * * * * * * * * */
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class FileRestController extends BucketRestController implements IBase64ImageRestController {

    private static final Logger logger = LogManager.getLogger(FileRestController.class);
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Note :- This blow url's are my question related to the file's *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    private static String answerUrl = "https://stackoverflow.com/questions/51415819/spring-boot-multipart-file-upload-along-with-json-data/53737185#53737185";
    private static String questionUrl = "https://stackoverflow.com/questions/53777228/spring-boot-multiple-files-upload-with-multiple-objects";

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * *
     * Note :- Ping-Pong Rest-Api Work With Angular-+ version* // Test Pass :- (Postman + Angular cli)
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @RequestMapping(value = "/filestore/ballistic/appsport.com/ping",
            method = RequestMethod.GET)
    public String pingPong() { return pingResponse; }


    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * * *
     * Note :- Single-File Rest-Api Work With Angular-+ version* // Test Pass :- (Postman + Angular cli)
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/singleFileUpload/{folder}",
            method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String singleFileUpload(
            @PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder,
            @RequestParam(name = "file") MultipartFile file) { // file
        return pingResponse;
    }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * * * * *
     * Note :- Multiple-File's Rest-Api Work With Angular-+ version* // Test Pass :- (Postman + Angular cli)
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
     * Note :- Single-File With Object Rest-Api Work With Angular-+ version * // Test Pass :- (Postman + Angular cli)
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
     * Note :- Multiple-File With Object Rest-Api Work With Angular-+ version* // Test Pass :- (Postman + Angular cli)
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/multipleFilesUploadWithObject/{folder}",
            method = RequestMethod.POST)
    @ResponseBody
    public String multipleFileUploadWithObject(
            @PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder,
            FileWithObject rawData) { // rawData => (files, data)
        return pingResponse;
    }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * * * * * * * * * * *
     * Note :- Multiple-File's With Object Rest-Api Work With Angular-+ version* // Test Pass :- (Postman + Angular cli)
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/filesUploadsWithObject/{folder}",
            method = RequestMethod.POST)
    @ResponseBody
    public String filesUploadsWithObject(
            @PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder,
            FileWithObject rawData) { // rawData => (file, files, data)
        return pingResponse;
    }

    /* * * * * * * *
     * Pending Task*
     * * * * * * * */
    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/listOfObjectsWithSingleFile/{folder}",
            method = RequestMethod.POST)
    @ResponseBody
    public String listOfObjectsWithSingleFile(
            @PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder,
            FileWithObject[] rawData) { // [{file,data},....]
        return pingResponse;
    }

    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/listOfObjectsWithMultipleFiles/{folder}",
            method = RequestMethod.POST)
    @ResponseBody
    public String listOfObjectsWithMultipleFiles(
            @PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder,
            List<FileWithObject> rawData) { // [{files,data},....]
        return pingResponse;
    }
	
	@RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/listOfObjectsWithFiles/{folder}",
            method = RequestMethod.POST)
    @ResponseBody
    public String listOfObjectsWithFiles(
            @PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder,
            List<FileWithObject> rawData) { // [{file,files,data},....]
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


    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * * * * * * * * * * *
     * Note :- Multiple-File's With Object Rest-Api Work With Angular-+ version* // Test Pass :- (Postman + Angular cli)
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public static final String REQUEST = "request";
    public static final String DATA = "data";
    public static final String DOC_NAME = "doc_name";
    public static final String DOC_DESCRIPTION = "doc_description";
    public static final String FILE_INFO = "fileInfo";
    public static final String FILE_INFOS = "fileInfos";
    public static final String FILE_NAME = "file_name";
    public static final String FILE_SIZE = "file_size";
    @RequestMapping(value="/singlefile/filestore/{bucket-id}/appsport.com/{folder}", method = RequestMethod.POST)
    @ResponseBody
    public String uploadMultiFiles(HttpServletRequest httpServletRequest) {

        /* * * * * * * * * * * * * * * * * * * * * * * * * * * *
         * This Process Is Only for Parse and Collect the Files*
         * * * * * * * * * * * * * * * * * * * * * * * * * * * */
        List<HttpRequestInfo> httpRequestInfos = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(httpServletRequest.getParameter(REQUEST));
        for (int i = 0; i < jsonArray.length(); i++) {
            HttpRequestInfo httpRequestInfo = new HttpRequestInfo();
            JSONObject jsonObj = jsonArray.getJSONObject(i);
            JSONObject data = jsonObj.getJSONObject(DATA);
            httpRequestInfo.setData(new HttpRequestInfo.Data(data.getString(DOC_NAME),data.getString(DOC_DESCRIPTION)));
            JSONObject fileInfo = jsonObj.getJSONObject(FILE_INFO);
            if(fileInfo != null) {
                httpRequestInfo.setFileInfo(getFileInfo(fileInfo, new HttpRequestInfo.FileInfo()));
            }
            httpRequestInfos.add(httpRequestInfo);
        }

        try {

            Map<String,MultipartFile> files = getFileHash(httpServletRequest);
            Iterator<HttpRequestInfo> httpRequestInfoIterator = httpRequestInfos.iterator();
            while (httpRequestInfoIterator.hasNext()) {
                HttpRequestInfo httpRequestInfo = httpRequestInfoIterator.next();
                if(httpRequestInfo.getFileInfo().getFile_name() != null && files.containsKey(httpRequestInfo.getFileInfo().getFile_name())) {
                    httpRequestInfo.setFile(files.get(httpRequestInfo.getFileInfo().getFile_name()));
                }

                /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
                 * if(httpRequestInfo.getFileInfo().getFile_name().equals(httpRequestInfo.getFile().getName())) {                                *
                 *    logger.info("Match :- " + httpRequestInfo.getFileInfo().getFile_name() + " -|- " + httpRequestInfo.getFile().getName());   *
                 * }                                                                                                                             *
                 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
            }
        } catch (Exception ex) {
            System.err.println("Error :- " + ex.getLocalizedMessage());
        }

        return pingResponse;
    }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * * * * * * * * * * *
     * Note :- Multiple-File's With Object Rest-Api Work With Angular-+ version* // Test Pass :- (Postman + Angular cli)
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @RequestMapping(value="/multiples/filestore/{bucket-id}/appsport.com/{folder}", method = RequestMethod.POST)
    @ResponseBody
    public String uploadMulticsFiles(HttpServletRequest httpServletRequest) {

        List<HttpRequestInfo> httpRequestInfos = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(httpServletRequest.getParameter(REQUEST));
        for (int i = 0; i < jsonArray.length(); i++) {
            HttpRequestInfo httpRequestInfo = new HttpRequestInfo();
            JSONObject jsonObj = jsonArray.getJSONObject(i);
            JSONObject dataJson = jsonObj.getJSONObject(DATA);
            httpRequestInfo.setData(new HttpRequestInfo.Data(dataJson.getString(DOC_NAME),dataJson.getString(DOC_DESCRIPTION)));
            JSONObject fileInfoJson = jsonObj.getJSONObject(FILE_INFO);
            if(fileInfoJson != null) {
                httpRequestInfo.setFileInfo(getFileInfo(fileInfoJson, new HttpRequestInfo.FileInfo()));
            }
            JSONArray fileInfosJsonArray = jsonObj.getJSONArray(FILE_INFOS);
            if(fileInfosJsonArray != null) {
                List<HttpRequestInfo.FileInfo> fileInfos = new ArrayList<>();
                for (int j = 0; j < fileInfosJsonArray.length(); j++) {
                    fileInfoJson = fileInfosJsonArray.getJSONObject(j);
                    fileInfos.add(getFileInfo(fileInfoJson, new HttpRequestInfo.FileInfo()));
                }
                httpRequestInfo.setFileInfos(fileInfos);
            }
            httpRequestInfos.add(httpRequestInfo);
        }

        Map<String,MultipartFile> files = getFileHash(httpServletRequest);
        Iterator<HttpRequestInfo> httpRequestInfoIterator = httpRequestInfos.iterator();
        while (httpRequestInfoIterator.hasNext()) {
            HttpRequestInfo httpRequestInfo = httpRequestInfoIterator.next();
            if(httpRequestInfo.getFileInfo().getFile_name() != null && files.containsKey(httpRequestInfo.getFileInfo().getFile_name())) {
                httpRequestInfo.setFile(files.get(httpRequestInfo.getFileInfo().getFile_name()));
            }
            if(httpRequestInfo.getFileInfos() != null) {
                List<MultipartFile> hashFiles = httpRequestInfo.getFileInfos().stream().filter(fileInfo -> {
                   return files.containsKey(fileInfo.getFile_name());
                }).map(fileInfo -> {
                    return files.get(fileInfo.getFile_name());
                }).collect(Collectors.toList());
                httpRequestInfo.setFiles(hashFiles);
            }

            /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
             * if(httpRequestInfo.getFileInfo() != null) {                                                                                                       *
             *    if(httpRequestInfo.getFileInfo().getFile_name().equals(httpRequestInfo.getFile().getName())) {                                                 *
             *        logger.info("Match Sinle File :- " + httpRequestInfo.getFileInfo().getFile_name() + " -|- " + httpRequestInfo.getFile().getName());        *
             *    }                                                                                                                                              *
             *    if(httpRequestInfo.getFileInfo() != null) {                                                                                                    *
             *        httpRequestInfo.getFileInfos().forEach(fileInfo -> { logger.info("File Info :- " + fileInfo.getFile_name()); });                           *
             *        httpRequestInfo.getFiles().forEach(file -> { logger.info("File :- " + file.getName()); });                                                 *
             *    }                                                                                                                                              *
             *}                                                                                                                                                  *
             * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

        }

        return pingResponse;
    }

    private HttpRequestInfo.FileInfo getFileInfo(JSONObject fileInfoJson, HttpRequestInfo.FileInfo fileInfo) {
        if(fileInfoJson.has(FILE_NAME) && !fileInfoJson.get(FILE_NAME).equals(null)) { fileInfo.setFile_name(fileInfoJson.getString(FILE_NAME)); }
        if(fileInfoJson.has(FILE_SIZE) && !fileInfoJson.get(FILE_SIZE).equals(null)) { fileInfo.setFile_size(fileInfoJson.getLong(FILE_SIZE)); }

        return fileInfo;
    }

    public HashMap<String, MultipartFile> getFileHash(HttpServletRequest httpServletRequest) {
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

    private static class HttpRequestInfo {

        private Data data;
        private FileInfo fileInfo;
        private MultipartFile file;
        private List<FileInfo> fileInfos;
        private List<MultipartFile> files;

        public HttpRequestInfo() { }

        public HttpRequestInfo(Data data) {
            this.data = data;
        }

        public Data getData() { return data; }
        public void setData(Data data) { this.data = data; }

        public FileInfo getFileInfo() { return fileInfo; }
        public void setFileInfo(FileInfo fileInfo) { this.fileInfo = fileInfo; }

        public List<FileInfo> getFileInfos() { return fileInfos; }
        public void setFileInfos(List<FileInfo> fileInfos) { this.fileInfos = fileInfos; }

        public MultipartFile getFile() { return file; }
        public void setFile(MultipartFile file) { this.file = file; }

        public List<MultipartFile> getFiles() { return files; }
        public void setFiles(List<MultipartFile> files) { this.files = files; }

        public static class Data {

            private String doc_name;
            private String doc_description;

            public Data() {}

            public Data(String doc_name, String doc_description) {
                this.doc_name = doc_name;
                this.doc_description = doc_description;
            }

            public String getDoc_name() { return doc_name; }
            public void setDoc_name(String doc_name) { this.doc_name = doc_name; }

            public String getDoc_description() { return doc_description; }
            public void setDoc_description(String doc_description) { this.doc_description = doc_description; }

        }

        public static class FileInfo {

            private String file_name;
            private Long file_size;

            public FileInfo() {}

            public FileInfo(String file_name, Long file_size) {
                this.file_name = file_name;
                this.file_size = file_size;
            }

            public String getFile_name() { return file_name; }
            public void setFile_name(String file_name) { this.file_name = file_name; }

            public Long getFile_size() { return file_size; }
            public void setFile_size(Long file_size) { this.file_size = file_size; }

        }
    }
}