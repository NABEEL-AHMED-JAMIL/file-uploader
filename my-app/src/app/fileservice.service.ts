import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({ providedIn: 'root' })
export class FileserviceService {

  private localhostUrl:string = "http://localhost:9191/api";
  private serverUpCheckUrl:string =  this.localhostUrl + "/filestore/ballistic/appsport.com/ping";
  private singleFileUploadUrl:string = this.localhostUrl + "/filestore/03153817177/appsport.com/singleFileUpload/ballistic";
  private multipleFileUploadUrl:string = this.localhostUrl + "/filestore/03153817177/appsport.com/multipleFileUpload/ballistic";
  private singleFileUploadWithObjectUrl:string = this.localhostUrl + "/filestore/03153817177/appsport.com/singleFileUploadWithObject/ballistic";
  private multipleFilesUploadWithObjectUrl:string = this.localhostUrl + "/filestore/03153817177/appsport.com/multipleFilesUploadWithObject/ballistic";
  private filesUploadsWithObjectUrl:string = this.localhostUrl + "/filestore/03153817177/appsport.com/filesUploadsWithObject/ballistic";
  private fileUploadWithHttpServertUrl:string = this.localhostUrl + "/singlefile/filestore/03153817177/appsport.com/ballistic";
  private multiplefileUploadWithHttpServertUrl:string = this.localhostUrl + "/multiples/filestore/03153817177/appsport.com/ballistic";
  // pending-------
  private listOfObjectsWithSingleFileUrl:string = this.localhostUrl + "/filestore/03153817177/appsport.com/listOfObjectsWithSingleFile/ballistic";
  private listOfObjectsWithMultipleFilesUrl:string = this.localhostUrl + "/filestore/03153817177/appsport.com/listOfObjectsWithMultipleFiles/ballistic";
  private listOfObjectsWithFilesUrl:string = this.localhostUrl + "/filestore/03153817177/appsport.com/listOfObjectsWithFiles/ballistic";
  //---Base64Encode Data
  private singleFileUploadWithBase64ObjectUrl:string = this.localhostUrl + "/filestore/03153817177/appsport.com/singleFileUploadWithBase64Object/ballistic";
  private multipleFileUploadWithBase64ObjectUrl:string = this.localhostUrl + "/filestore/03153817177/appsport.com/multipleFileUploadWithBase64Object/ballistic";
  private filesUploadsWithBase64ObjectUrl:string = this.localhostUrl + "/filestore/03153817177/appsport.com/filesUploadsWithBase64Object/ballistic";
  private listOfBase64ObjectsWithSingleFileUrl:string = this.localhostUrl + "/filestore/03153817177/appsport.com/listOfBase64ObjectsWithSingleFile/ballistic";
  private listOfBase64ObjectsWithMultipleFilesUrl:string = this.localhostUrl + "/filestore/03153817177/appsport.com/listOfBase64ObjectsWithMultipleFiles/ballistic";
  private listOffilesUploadsWithBase64ObjectUrl:string = this.localhostUrl + "/filestore/03153817177/appsport.com/listOffilesUploadsWithBase64ObjectUrl/ballistic";
  // pending-------end

  private headers:any = new HttpHeaders({
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  });

  public constructor(private http:HttpClient) {}

  // done
  public serverUpCheck():any { return this.http.get(this.serverUpCheckUrl,this.headers); }
  // done
  public singleFileUpload(file:File):any {
    const formData:FormData = new FormData();
    formData.append('file',file,file.name);
    return this.http.post(this.singleFileUploadUrl,formData);
  }
  // done
  public multipleFileUpload(files:FileList):any {
    const formData:FormData = new FormData();
    for (let index = 0; index < files.length; index++) { formData.append('files',files[index],files[index].name); }
    return this.http.post(this.multipleFileUploadUrl,formData);
  }
  // done
  public singleFileUploadWithObject(object:any):any { return this.http.post(this.singleFileUploadWithObjectUrl,object); }
  // done
  public multipleFilesUploadWithObject(object:any):any { return this.http.post(this.multipleFilesUploadWithObjectUrl,object); }
  // done
  public filesUploadsWithObject(object:any):any { return this.http.post(this.filesUploadsWithObjectUrl,object); }
  // HTTP-SERVERT_REQUEST
  // done
  public fileUploadWithHttpServert(object:any):any { return this.http.post(this.fileUploadWithHttpServertUrl,object); }
  // done
  public multiplefileUploadWithHttpServert(object:any):any { return this.http.post(this.multiplefileUploadWithHttpServertUrl,object); };

  

  // pendding
  public listOfObjectsWithSingleFile(object:any):any { return this.http.post(this.listOfObjectsWithSingleFileUrl,object);}

  public listOfObjectsWithMultipleFiles(object:any):any { return this.http.post(this.listOfObjectsWithMultipleFilesUrl,object); }
  
  public listOfObjectsWithFiles(object:any):any { return this.http.post(this.listOfObjectsWithFilesUrl,object); }

  public singleFileUploadWithBase64Object(object:any):any { return this.http.post(this.singleFileUploadWithBase64ObjectUrl,object); }

  public multipleFileUploadWithBase64Object(object:any):any { return this.http.post(this.multipleFileUploadWithBase64ObjectUrl,object); }

  public filesUploadsWithBase64Object(object:any):any { return this.http.post(this.filesUploadsWithBase64ObjectUrl,object); }

  public listOfBase64ObjectsWithSingleFile(object:any):any { return this.http.post(this.listOfBase64ObjectsWithSingleFileUrl,object); }

  public listOfBase64ObjectsWithMultipleFiles(object:any):any { return this.http.post(this.listOfBase64ObjectsWithMultipleFilesUrl,object); }

  public listOffilesUploadsWithBase64Object(object:any):any { return this.http.post(this.listOffilesUploadsWithBase64ObjectUrl,object); }

}