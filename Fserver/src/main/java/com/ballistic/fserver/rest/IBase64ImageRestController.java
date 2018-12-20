package com.ballistic.fserver.rest;

import com.ballistic.fserver.model.bean.Base64File;
import com.ballistic.fserver.model.bean.Base64FileWithObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Set;

public interface IBase64ImageRestController {

    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/singleFileUploadWithBase64Object/{folder}",
           method = RequestMethod.POST)
    @ResponseBody
    public String singleFileUploadWithBase64Object(
        @PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder,
        Base64File base64File);

    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/multipleFileUploadWithBase64Object/{folder}",
            method = RequestMethod.POST)
    @ResponseBody
    public String multipleFileUploadWithBase64Object(
        @PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder,
        Set<Base64File> base64Files);


    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/filesUploadsWithBase64Object/{folder}",
            method = RequestMethod.POST)
    @ResponseBody
    public String filesUploadsWithBase64Object(
        @PathVariable(name="bucket-uuid") String bucketUUId,@PathVariable(name="folder") String folder,
        Base64FileWithObject base64FileWithObject);

    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/listOfBase64ObjectsWithSingleFile/{folder}",
            method = RequestMethod.POST)
    @ResponseBody
    public String listOfBase64ObjectsWithSingleFile(
        @PathVariable(name="bucket-uuid") String bucketUUId,@PathVariable(name="folder") String folder,
        Base64FileWithObject base64FileWithObject);

    @RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/listOfBase64ObjectsWithMultipleFiles/{folder}",
            method = RequestMethod.POST)
    @ResponseBody
    public String listOfBase64ObjectsWithMultipleFiles(
        @PathVariable(name="bucket-uuid") String bucketUUId,@PathVariable(name="folder") String folder,
        Set<Base64FileWithObject> base64FileWithObjects);
}