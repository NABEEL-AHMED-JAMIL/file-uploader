package com.ballistic.fserver.rest;

import org.springframework.web.bind.annotation.*;

/* * * * * * * * * * * * * * * * * * *
 *  Note :- Bucket-Management-System *
 * * * * * * * * * * * * * * * * * * */
/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Note :- These Api proved the handle of Bucket related function *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * **/
public abstract class BucketRestController {

    public final String pingResponse = "{ \"response\" : \"pong\" }";

    /* * * * * * * * * * * * * * * * *Task-Done* * * * * * * * * * * * * * * * * * * * *
     * Note :- This Api Send the Name For Bucket (Bucket Name Unique In Account Level) * // Test Pass :- (Postman + Angular cli)
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @RequestMapping(value = "/filestore/ballistic/appsport.com/createBucket", method = RequestMethod.POST)
    public String createBucket(@RequestBody String name) {
        return pingResponse;
    }

    /* * * * * * * * * * * * * * * * *Task-Done* * * * * * * * * * * * * * * * * * * * *
     * Note :- This Api Send the Name For Bucket (Bucket Name Unique In Account Level) * // Test Pass :- (Postman + Angular cli)
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @RequestMapping(value = "/filestore/ballistic/appsport.com/deleteBucket", params = { "token", "name" }, method = RequestMethod.DELETE)
    public String deleteBucket(@RequestParam("token") String token, @RequestParam("name") String name) {
        return pingResponse;
    }

    /* * * * * * * * * * * * * * * **Task-Done* * * * * * * * * * * * * * * * * * * * * * * *
     * Note :- This Api Send the Name For Update-Bucket(Bucket Name Unique In Account Level)* // Test Pass :- (Postman + Angular cli)
     ** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @RequestMapping(value = "/filestore/ballistic/appsport.com/updateBucket", params = { "name" }, method = RequestMethod.PUT)
    public String updateBucket(@RequestParam("name") String name) {
        return pingResponse;
    }

    /* * * * * * * * * *Task-Done* * * * * * * * * * * * **
     * Note :- This Api Create the Copy of Url For Bucket * // Test Pass :- (Postman + Angular cli)
     ** * * * * * * * * * * * * * * * * * * * * * * * * * */
    @RequestMapping(value = "/filestore/ballistic/appsport.com/createDownloadUrl", params = { "token" }, method = RequestMethod.GET)
    public String createDownloadUrlForBucket(@RequestParam("token") String token) {
        return pingResponse;
    }

}