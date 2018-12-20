import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse, HttpRequest, HttpEventType, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FileserviceService {

  private localhostUrl:string = "http://localhost:9191/api";
  private serverUpCheckUrl:string =  this.localhostUrl + "/filestore/ballistic/appsport.com/ping";
  private singleFileUploadUrl:string = this.localhostUrl + "/filestore/03153817177/appsport.com/singleFileUpload/ballistic";
  private multipleFileUploadUrl:string = this.localhostUrl + "/filestore/03153817177/appsport.com/multipleFileUpload/ballistic";
  private singleFileUploadWithObjectUrl:string = this.localhostUrl + "/filestore/03153817177/appsport.com/singleFileUploadWithObject/ballistic";
  private multipleFilesUploadWithObjectUrl:string = this.localhostUrl + "/filestore/03153817177/appsport.com/multipleFilesUploadWithObject/ballistic";
  private filesUploadsWithObjectUrl:string = this.localhostUrl + "/filestore/03153817177/appsport.com/filesUploadsWithObject/ballistic";
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
  public serverUpCheck():any {
    return this.http.get(this.serverUpCheckUrl, this.headers);
  }

  // done
  public singleFileUpload(file:File):any {
    const formData:FormData = new FormData();
    formData.append('file', file, file.name);
    return this.http.post(this.singleFileUploadUrl,formData);
  }

  // done
  public multipleFileUpload(files:FileList):any {
    const formData:FormData = new FormData();
    for (let index = 0; index < files.length; index++) {
      formData.append('files', files[index], files[index].name);
    }
    return this.http.post(this.multipleFileUploadUrl, formData);
  }

  // done
  public singleFileUploadWithObject(fileWithObject:any): any {
    return this.http.post(this.singleFileUploadWithObjectUrl, fileWithObject);
  }

  // done
  public multipleFilesUploadWithObject(fileWithObject:any): any {
    return this.http.post(this.multipleFilesUploadWithObjectUrl, fileWithObject);
  }

  // done
  public filesUploadsWithObject(fileWithObject:any): any {
    return this.http.post(this.filesUploadsWithObjectUrl, fileWithObject);
  }

  public listOfObjectsWithSingleFile(): any {
    return this.http.post(this.listOfObjectsWithSingleFileUrl, null);
    
  }

  public listOfObjectsWithMultipleFiles(): any {
    return this.http.post(this.listOfObjectsWithMultipleFilesUrl, null);
  }
  
  public listOfObjectsWithFiles(): any {
    return this.http.post(this.listOfObjectsWithFilesUrl, null);
  }

  public singleFileUploadWithBase64Object(): any {
    return this.http.post(this.singleFileUploadWithBase64ObjectUrl, null);
  }

  public multipleFileUploadWithBase64Object(): any {
    return this.http.post(this.multipleFileUploadWithBase64ObjectUrl, null);
  }

  public filesUploadsWithBase64Object(): any {
    return this.http.post(this.filesUploadsWithBase64ObjectUrl, null);
  }

  public listOfBase64ObjectsWithSingleFile(): any {
    return this.http.post(this.listOfBase64ObjectsWithSingleFileUrl, null);
  }

  public listOfBase64ObjectsWithMultipleFiles(): any {
    return this.http.post(this.listOfBase64ObjectsWithMultipleFilesUrl, null);
  }

  public listOffilesUploadsWithBase64Object(): any {
    return this.http.post(this.listOffilesUploadsWithBase64ObjectUrl, null);
  }

}