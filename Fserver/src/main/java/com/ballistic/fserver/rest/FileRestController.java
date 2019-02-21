package com.ballistic.fserver.rest;

import com.ballistic.fserver.model.dto.base64.Base64File;
import com.ballistic.fserver.model.dto.base64.Base64FileWithObject;
import com.ballistic.fserver.model.dto.FileWithObject;
import com.ballistic.fserver.model.dto.http.Data;
import com.ballistic.fserver.model.dto.http.FileInfo;
import com.ballistic.fserver.model.dto.http.HttpRequestInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

import static com.ballistic.fserver.model.dto.http.Data.DATA;
import static com.ballistic.fserver.model.dto.http.Data.DOC_DESCRIPTION;
import static com.ballistic.fserver.model.dto.http.Data.DOC_NAME;
import static com.ballistic.fserver.model.dto.http.FileInfo.*;

/* * * * * * * * * * * * * * * * * *
 *  Note :- File-Management-System *
 * * * * * * * * * * * * * * * * * */
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class FileRestController extends BucketRestController implements IBase64ImageRestController {

    private static final Logger logger = LogManager.getLogger(FileRestController.class);

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * *
     * Note:- Ping-Pong Rest-Api For Test Service Live or Not*
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @RequestMapping(value = "/filestore/ballistic/appsport.com/ping", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String pingPong() { return pingResponse; }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * **
     * Note :- Single-File Rest-Api For Store the Single File *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * **/
    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/singleFileUpload/{folder}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String singleFileUpload(@PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder, @RequestParam(name = "file") MultipartFile file) { // file
        return pingResponse;
    }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * * * * *
     * Note :- Multiple-File's Rest-Api For Store the Multiple File*
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/multipleFileUpload/{folder}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String multipleFileUpload(@PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder, @RequestParam(name = "files") Set<MultipartFile> files) { // file's
        return pingResponse;
    }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * * * * * * * * * * *
     * Note :- Single-File With Object Rest-Api For Store Data + File          *
     * Object Can Be-DeParse and Assign To POJO                                *
     * @Validation Use To Stop If (File's + Meta-data) added through this Url  *
     * Note:- For Data have Option To Parse Either Store Direct Into db        *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/singleFileUploadWithObject/{folder}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String singleFileUploadWithObject(@PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder, FileWithObject object) { // rawData => (file, data)
        return pingResponse;
    }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * * * * * * * * * *
     * Note :- Multiple-File With Object Rest-Api For Store Data + Files     *
     * Object Can Be-DeParse and Assign To POJO                              *
     * @Validation Use To Stop If (File's + Meta-data) added through this Url*
     * Note:- For Data have Option To Parse Either Store Direct Into db      *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/multipleFilesUploadWithObject/{folder}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String multipleFileUploadWithObject(@PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder, FileWithObject object) { // rawData => (files, data)
        return pingResponse;
    }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * * * * * * * * * * * ** *
     * Note :- Multiple-File's With Object Rest-Api For Store (Data + File + File's)*
     * @Validation Use To Stop If (Meta-data) added through this Url                *
     * Note:- For Data have Option To Parse Either Store Direct Into db             *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *  */
    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/filesUploadsWithObject/{folder}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String filesUploadsWithObject(@PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder, FileWithObject object) { // rawData => (file, files, data)
        return pingResponse;
    }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * * * * * *
     * Note :- Multiple-File's With Object Rest-Api For List of Data *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/listOfObjectsWithSingleFile/{folder}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String listOfObjectsWithSingleFile(@PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder, FileWithObject object) { // [{file,data},....]
        List<FileWithObject> rawData = this.getRawData(object);
        return pingResponse;
    }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * * * * * * * * * * *
     * Note :- Multiple-File's With Object Rest-Api Work With Angular-+ version*
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/listOfObjectsWithMultipleFiles/{folder}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String listOfObjectsWithMultipleFiles(@PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder, FileWithObject object) { // [{files,data},....]
        List<FileWithObject> rawData = this.getRawData(object);
        return pingResponse;
    }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * * * * * * * * * * *
     * Note :- Multiple-File's With Object Rest-Api Work With Angular-+ version*
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	@RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/listOfObjectsWithFiles/{folder}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String listOfObjectsWithFiles(@PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder, FileWithObject object) { // [{file,files,data},....]
        List<FileWithObject> rawData = this.getRawData(object);
        return pingResponse;
    }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * *
     * Note :- This Kind OF File Store In DB with All Detail *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public String singleFileUploadWithBase64Object(@PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder, @RequestBody Base64File object) {
        return pingResponse;
    }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public String multipleFileUploadWithBase64Object(@PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder, @RequestBody List<Base64File> objects) {
        return pingResponse;
    }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public String listOfBase64ObjectsWithSingleFile(@PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder, @RequestBody Base64FileWithObject object) {
        return pingResponse;
    }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public String listOfBase64ObjectsWithMultipleFiles(@PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder, @RequestBody List<Base64FileWithObject> objects) {
        return pingResponse;
    }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    public String filesUploadsWithBase64Object(@PathVariable(name="bucket-uuid") String bucketUUId,@PathVariable(name="folder")  String folder, @RequestBody Base64FileWithObject object) {
        return pingResponse;
    }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Note :- Multiple-File's With Object Rest-Api Work With Angular-+ version                                                *
     * a6dc391b-c411-e4c4-8641-d0363a7a3fb7-ElkBoot.postman_collection.json: (binary)                                          *
     * 2c70e4c8-2b8b-202a-91c6-a12aea5a67a6-Exception-hierarchy-516x300.png: (binary)                                          *
     * request: [                                                                                                              *
     *    {                                                                                                                    *
     *      "data":{"doc_description":"Nabeel IS Good Boy","doc_name":"Nabeel Ahmed"},                                         *
     *      "fileInfo":{"file_name":"a6dc391b-c411-e4c4-8641-d0363a7a3fb7-ElkBoot.postman_collection.json","file_size":10122}  *
     *    },                                                                                                                   *
     *    {                                                                                                                    *
     *      "data":{"doc_description":"Adobe Shope","doc_name":"Nabeel"},                                                      *
     *      "fileInfo":{"file_name":"2c70e4c8-2b8b-202a-91c6-a12aea5a67a6-Exception-hierarchy-516x300.png","file_size":25526}  *
     *    }                                                                                                                    *
     * ]                                                                                                                       *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public static final String REQUEST = "request";

    @RequestMapping(value="/singlefile/filestore/{bucket-id}/appsport.com/{folder}", method = RequestMethod.POST)
    public String uploadMultiFiles(HttpServletRequest httpServletRequest) {

        /* * * * * * * * * * * * * * * * * * * * * * * * * * * *
         * This Process Is Only for Parse and Collect the Files*
         * * * * * * * * * * * * * * * * * * * * * * * * * * * */
        String request = httpServletRequest.getParameter(REQUEST);
        List<HttpRequestInfo> httpRequestInfos = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(request);
        for (int i = 0; i < jsonArray.length(); i++) {
            HttpRequestInfo httpRequestInfo = new HttpRequestInfo();
            JSONObject jsonObj = jsonArray.getJSONObject(i);
            JSONObject data = jsonObj.getJSONObject(DATA);
            httpRequestInfo.setData(new Data(data.getString(DOC_NAME),data.getString(DOC_DESCRIPTION)));
            JSONObject fileInfo = jsonObj.getJSONObject(FILE_INFO);
            if(fileInfo != null) {
                httpRequestInfo.setFileInfo(getFileInfo(fileInfo, new FileInfo()));
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
            }
        } catch (Exception ex) {
            System.err.println("Error :- " + ex.getLocalizedMessage());
        }

        return pingResponse;
    }

    /* * * * * * * * * * * * * * *Task-Done* * * * * * * * * * * * * * * * * * *
     * Note :- Multiple-File's With Object Rest-Api Work With Angular-+ version*
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @RequestMapping(value="/multiples/filestore/{bucket-id}/appsport.com/{folder}", method = RequestMethod.POST)
    public String uploadMulticsFiles(HttpServletRequest httpServletRequest) {

        /* * * * * * * * * * * * * * * * * * * * * * * * * * * *
         * This Process Is Only for Parse and Collect the Files*
         * * * * * * * * * * * * * * * * * * * * * * * * * * * */
        List<HttpRequestInfo> httpRequestInfos = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(httpServletRequest.getParameter(REQUEST));
        for (int i = 0; i < jsonArray.length(); i++) {
            HttpRequestInfo httpRequestInfo = new HttpRequestInfo();
            JSONObject jsonObj = jsonArray.getJSONObject(i);
            JSONObject dataJson = jsonObj.getJSONObject(DATA);
            httpRequestInfo.setData(new Data(dataJson.getString(DOC_NAME),dataJson.getString(DOC_DESCRIPTION)));
            JSONObject fileInfoJson = jsonObj.getJSONObject(FILE_INFO);
            if(fileInfoJson != null) {
                httpRequestInfo.setFileInfo(getFileInfo(fileInfoJson, new FileInfo()));
            }
            JSONArray fileInfosJsonArray = jsonObj.getJSONArray(FILE_INFOS);
            if(fileInfosJsonArray != null) {
                List<FileInfo> fileInfos = new ArrayList<>();
                for (int j = 0; j < fileInfosJsonArray.length(); j++) {
                    fileInfoJson = fileInfosJsonArray.getJSONObject(j);
                    fileInfos.add(getFileInfo(fileInfoJson, new FileInfo()));
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
        }

        return pingResponse;
    }
}