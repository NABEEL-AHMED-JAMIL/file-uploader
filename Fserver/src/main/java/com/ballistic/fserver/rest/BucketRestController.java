package com.ballistic.fserver.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/* * * * * * * * * * * * * * * * * * *
 *  Note :- Bucket-Management-System *
 * * * * * * * * * * * * * * * * * * */
public abstract class BucketRestController {

    public final String pingResponse = "{ \"response\" : \"pong\" }";

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    * Note :- These Api proved the handle of Bucket related function *
    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * **/
    @RequestMapping(value = "/filestore/ballistic/appsport.com/createBucket", method = RequestMethod.POST)
    @ResponseBody
    public String createBucket(@RequestBody String name) {
        return pingResponse;
    }

    @RequestMapping(value = "/filestore/ballistic/appsport.com/deleteBucket", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteBucket(@RequestBody String name) {
        return pingResponse;
    }

    @RequestMapping(value = "/filestore/ballistic/appsport.com/updateBucket", method = RequestMethod.PUT)
    @ResponseBody
    public String updateBucket(@RequestBody String name) {
        return pingResponse;
    }

    @RequestMapping(value = "/filestore/ballistic/appsport.com/createDownloadUrl", method = RequestMethod.GET)
    @ResponseBody
    public String createDownloadUrlForBucket() {
        return pingResponse;
    }

}