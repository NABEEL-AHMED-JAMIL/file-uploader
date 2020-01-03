import { Component, OnInit } from '@angular/core';
import { FileserviceService } from './fileservice.service';
import { FormBuilder, FormControl, FormGroup, Validators, FormArray } from '@angular/forms';

export interface Base64File {
  filename:string;
  filetype:string;
  value:string;
}

export interface HttpRequestInfo {
  data:Data;
  fileInfo?:FileInfo;
  fileInfos?:FileInfo[];
}

export interface Data {
  doc_name:string;
  doc_description:string;
}

export interface FileInfo {
  file_name:string;
  file_size:number;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  public response:string = "400";
  public singleFileWithObject:FormGroup;
  public multipleFileWithObject:FormGroup;
  public filesWithObject:FormGroup;
  // httpserverltRequest
  public fileWithObjectHttpServelt:FormGroup;
  public multipleFilesUploadWithHttpServert:FormGroup;
  // -------Pending-----
  public objectsWithSingleFile:FormGroup;
  public objectsWithMultipleFiles:FormGroup;
  public objectsWithFiles:FormGroup;
  //---Base64Encode Data
  public base64ObjectWithSingleFileUpload:FormGroup;
  public base64ObjectWithMultipleFileUpload:FormGroup;
  public base64ObjectWithfilesUploads:FormGroup;
  public base64ObjectsWithSingleFile:FormGroup;
  public base64ObjectsWithMultipleFiles:FormGroup;
  public base64ObjectWithfiles:FormGroup;
  
  public constructor(public fs:FileserviceService, public fb:FormBuilder) {}

  public ngOnInit():void {

    // check the server active or not?
    this.fs.serverUpCheck().subscribe((response:any) => {
      if(response['response'] == "pong") { this.response = "200"; }
    }, error => {
      this.response = "400";
      console.log("Error :- " + JSON.stringify(error));
    });
    //--------------SingleFileWithObject--------------
    this.singleFileWithObject = this.fb.group({
      data: new FormGroup({
        name: new FormControl('',Validators.required),
        quantity: new FormControl('',Validators.required),  
      }),
      file: new FormControl()
    });
    //--------------MultipleFileWithObject--------------
    this.multipleFileWithObject = this.fb.group({
      data: new FormGroup({
        name: new FormControl('',Validators.required),
        quantity: new FormControl('',Validators.required),  
      }),
      files: new FormControl()
    });
    //--------------FilesWithObject--------------
    this.filesWithObject = this.fb.group({
      data: new FormGroup({
        name: new FormControl('',Validators.required),
        quantity: new FormControl('',Validators.required),  
      }),
      file: new FormControl(),
      files: new FormControl()
    });
    //--------------HTTP-SERVERT_REQUEST-----------
    this.fileWithObjectHttpServelt = this.fb.group({
      items: this.fb.array([
        this.buildItem(0),this.buildItem(0)
      ])
    });
    this.multipleFilesUploadWithHttpServert = this.fb.group({
      items: this.fb.array([
        this.buildItem(1),this.buildItem(1)        
      ])
    });
    
    //-------------------------------
    this.objectsWithSingleFile = this.fb.group({
      objects:this.fb.array([this.buildItem(2)])
    });
    //-------------------------------
    this.objectsWithMultipleFiles = this.fb.group({
      itemsWithMultipleFiles: this.fb.array([
        {
          data : new FormGroup({
            name: new FormControl('', Validators.required),
            quantity: new FormControl('', Validators.required),  
          }),
          files : new FormControl()
        }
      ])
    });
    //-------------------------------
    this.objectsWithFiles = this.fb.group({
      itemsWithFiles: this.fb.array([
        {
          data : new FormGroup({
            name: new FormControl('', Validators.required),
            quantity: new FormControl('', Validators.required),  
          }),
          file: new FormControl(),
          files: new FormControl()
        }
      ])
    });
    //---------------Base64O----------------
    this.base64ObjectWithSingleFileUpload = this.fb.group({
      data : new FormGroup({
        name: new FormControl('', Validators.required),
        quantity: new FormControl('', Validators.required),  
      }),
      file : new FormControl(),
    });
    //-------------------------------
    this.base64ObjectWithMultipleFileUpload = this.fb.group({
      data : new FormGroup({
        name: new FormControl('', Validators.required),
        quantity: new FormControl('', Validators.required),  
      }),
      files : new FormControl(),
    });
    //-------------------------------
    this.base64ObjectWithfilesUploads = this.fb.group({
      data : new FormGroup({
        name: new FormControl('', Validators.required),
        quantity: new FormControl('', Validators.required),  
      }),
      file : new FormControl(),
      files : new FormControl()
    });
    //-------------------------------
    this.base64ObjectsWithSingleFile = this.fb.group({
      itemsBase64ObjectsWithSingleFile: this.fb.array([
        {
          data : new FormGroup({
            name: new FormControl('', Validators.required),
            quantity: new FormControl('', Validators.required),  
          }),
          file : new FormControl()
        }
      ])
    });
    //-------------------------------
    this.base64ObjectsWithMultipleFiles = this.fb.group({
      itemsBase64ObjectsWithMultipleFiles: this.fb.array([
        {
          data : new FormGroup({
            name: new FormControl('', Validators.required),
            quantity: new FormControl('', Validators.required),  
          }),
          files : new FormControl()
        }
      ])
    });
    //-------------------------------
    this.base64ObjectWithfiles = this.fb.group({
      itemsBase64ObjectWithfiles: this.fb.array([
        {
          data : new FormGroup({
            name: new FormControl('', Validators.required),
            quantity: new FormControl('', Validators.required),  
          }),
          file : new FormControl(),
          files : new FormControl()
        }
      ])
    });
  }

  public buildItem(objectType:number):any {
    //FileWithObjectHttpServelt
    if(objectType == 0) {
      this.totalfiles.push(null);
      return new FormGroup({
        file: new FormControl(),
        data: new FormGroup({
          doc_name: new FormControl('',Validators.required),
          doc_description: new FormControl('',Validators.required),  
        })
      });
    } else if(objectType == 1) {
      this.singlefiles.push(null);
      this.multiplefiles.push(null);
      return new FormGroup({
        file: new FormControl(File),
        files: new FormControl(FileList),
        data: new FormGroup({
          doc_name: new FormControl('',Validators.required),
          doc_description: new FormControl('',Validators.required),  
        })
      });
    } else if(objectType == 2) {
      return new FormGroup({
        data: new FormGroup({
          name: new FormControl('',Validators.required),
          quantity: new FormControl('',Validators.required),  
        }),
        file: new FormControl(File)
      });
    }
  }

  /* * * * * * * * * * * * * * * * * * * * * *
   * Handle the Single File With Spring Api  *  // Test Pass :- (Postman + Angular cli)
   * * * * * * * * * * * * * * * * * * * * * */
  //-------------------------------------------
  public single_file_message:string = "-x-x-";
  public single_file_imgURL:any;
  //-------------------------------------------
  public singleFileUpload(file:File):any {
    if(this.isServerActive()) { this.singleFilePreviewAndSubmit(file); }
  }

  public singleFilePreviewAndSubmit(file:File):void {
    if(file == undefined) {
      this.single_file_message = "Process NoT Perform Due to File Not Valid";
      return;    
    }
    var mimeType = file.type;
    if (mimeType.match(/image\/*/) == null) {
      this.single_file_message = "Only images are supported.";
      this.single_file_imgURL = "";
      return;
    }
    var reader = new FileReader();
    reader.readAsDataURL(file); 
    reader.onload = (_event) => {
      this.single_file_message = "Image Type " + file.type +" -:- "+ " Image Name " + file.name;
      this.single_file_imgURL = reader.result; 
      this.fs.singleFileUpload(file).subscribe((response:any) => {
        if(response['response'] == "pong") {
          this.single_file_message = "File Save To Server";
          setTimeout(() => {
            this.single_file_message = "-x-x-";
            this.single_file_imgURL = "";
            alert("File's Save To Server");
          }, 1000);
        }
      },error => {
        console.log("Error :- " + JSON.stringify(error));
      });
    }
  }

  /* * * * * * * * * * * * * * * * * * * * * * *
   * Handle the Multiple Files With Spring Api * // Test Pass :- (Postman + Angular cli)
   * * * * * * * * * * * * * * * * * * * * * * */
  //----------------------------------------------
  public multiple_files_message:string = "-x-x-";
  public multiple_files_imgURL = new Array<string>();
  //-----------------------------------------------
  public multipleFileUpload(files:FileList):any {
    if(this.isServerActive() && files.length > 0) {
      this.multipleFilesPreviewAndSubmit(files);
    } else {
      this.multiple_files_message = "Process NoT Perform Due to File Not Valid"; 
    }
  }

  public multipleFilesPreviewAndSubmit(files:FileList):void {
    // check :- only send 5 image at time
    if(files.length > 6) {
      this.multiple_files_message = "Only 5 images are supported.";
      this.multiple_files_imgURL = [];
      return;
    }
    this.multiple_files_message = "";
    for (let index = 0; index < files.length; index++) {
      const file = files[index];
      // check :- only support images for upload
      if (file.type.match(/image\/*/) == null) {
        // if any of the file not image then show message
        this.multiple_files_message = "Only images are supported.";
        this.multiple_files_imgURL = [];    
        return;  
      }
      this.multiple_files_message +=  "("+file.type + ","+file.name+")"; 
      let reader = new FileReader();
      reader.onload = (e: any) => { this.multiple_files_imgURL.push(e.target.result); }
      reader.readAsDataURL(file);
    }
    // process for post the list of files
    this.fs.multipleFileUpload(files).subscribe((response: any) => {
      if(response['response'] == "pong") {
        this.multiple_files_message = "File's Save To Server";
        setTimeout(() => {
          alert("File's Save To Server");
          this.multiple_files_message = "-x-x-";
          this.multiple_files_imgURL = [];
        }, 1000);
      }
    }, error => {
      console.log("Error :- " + JSON.stringify(error));
    });
  }
  
  /* * * * * * * * * * * * * * * * * * * * * * *
  * Handle the Single File With Obj Spring Api * // Test Pass :- (Postman + Angular cli)
  * * * * * * * * * * * * * * * * * * * * * * **/
  //---------------------------------------------
  public singleFileWithObjectMessage:string = "-x-x-";
  public singleFileFrom:any = new FormData();
  //--------------------------------------------
  // {file,data} // file
  public singleFileUploadWithObject():any {
    if(this.isServerActive()) {
      if(this.singleFileWithObjectMessage != "Image Accept.") {
        this.singleFileWithObjectMessage = "Process NoT Perform Due to File Not Valid";
      }else {
        this.singleFileFrom.append('data', JSON.stringify(this.singleFileWithObject.get('data').value));
        this.fs.singleFileUploadWithObject(this.singleFileFrom).subscribe((response: any) => {
          if(response['response'] == "pong") {
            this.singleFileWithObjectMessage = "Single File With Object Save";
            setTimeout(() => {
              alert("Single File With Object Save");
              this.singleFileWithObjectMessage = "-x-x-";
              this.singleFileFrom  = new FormData();
            }, 1000);
          }
        },error => {
          console.log("Error :- " + JSON.stringify(error));
        });
      }
    }
  }

  public isfileTypeValid(file:File):void {
    if(file == undefined || file == null) {
      this.singleFileWithObjectMessage = "Process NoT Perform Due to File Not Valid";
      return;    
    } else if (file.type.match(/image\/*/) == null) {
      this.singleFileWithObjectMessage = "Only images are supported.";
      return;  
    } else {
      this.singleFileWithObjectMessage = "Image Accept.";
      this.singleFileFrom.append('file', file, file.name);
    }
  } 

  /* * * * * * * * * * * * * * * * * * * * * * *  *
  * Handle the Multiple Files With Obj Spring Api * // Test Pass :- (Postman + Angular cli)
  * * * * * * * * * * * * * * * * * * * * * * * * */
  //--------------------------------------------
  public multipleFilesUploadWithObjectMessage:string = "-x-x-";
  public multipleFilesFrom:any = new FormData();
  //--------------------------------------------
  // {files,data} // files
  public multipleFilesUploadWithObject():any {
    if(this.isServerActive()) {
      if(this.multipleFilesUploadWithObjectMessage != "Image's Accept.") {
        this.multipleFilesUploadWithObjectMessage = "Process NoT Perform Due to File Not Valid";
      }else {
        this.multipleFilesFrom.append('data', JSON.stringify(this.multipleFileWithObject.get('data').value));
        this.fs.multipleFilesUploadWithObject(this.multipleFilesFrom).subscribe((response: any) => {
          if(response['response'] == "pong") {
            this.multipleFilesUploadWithObjectMessage = "Image's With Object Save";
            setTimeout(() => {
              alert("Multiple File's With Object Save");
              this.multipleFilesUploadWithObjectMessage = "-x-x-";
              this.multipleFilesFrom = new FormData(); 
            }, 1000);
          }
        },error => {
          console.log("Error :- " + JSON.stringify(error));
        });
      }
    }
  }

  public isfilesTypeValid(files:FileList):void {
    if(files == undefined) {
      this.multipleFilesUploadWithObjectMessage = "Process NoT Perform Due to File Not Valid";
      return;
    } else if(files.length > 6) {
      this.multipleFilesUploadWithObjectMessage = "Only 5 images are supported.";
      return;
    } else {
      for (let index = 0; index < files.length; index++) {
        const file = files[index];
        // check :- only support images for upload
        if (file.type.match(/image\/*/) == null) {
          // if any of the file not image then show message
          this.multipleFilesUploadWithObjectMessage = "Only images are supported.";   
          return;  
        }
        this.multipleFilesUploadWithObjectMessage = "Image's Accept.";
        this.multipleFilesFrom.append('files', files[index], files[index].name);
      }
    }
  }

  /* * * * * * * * * * * * * * * * * * * *
  * Handle the Files With Obj Spring Api *  // Test Pass :- (Postman + Angular cli)
  * * * * * * * * * * * * * * * * * * * **/
 //--------------------------------------------
  public filesUploadWithObjectMessage:string = "-x-x-";
  public type1Message:string = "-x-x-";
  public type2Message:string = "-x-x-";
  public multipleFilesFromObject:any = new FormData();
  //--------------------------------------------
  // {file,files,data} // file, files
  public filesUploadsWithObject():any {
    if(this.isServerActive()) {
      if(this.type1Message != "Image Accept.") {
        this.type1Message = "Process NoT Perform Due to File Not Valid";
      } else if(this.type2Message != "Image's Accept.") {
        this.type2Message = "Process NoT Perform Due to File Not Valid";
      }else {
        this.filesUploadWithObjectMessage = "Image's && Image Accept.";
        this.multipleFilesFromObject.append('data', JSON.stringify(this.filesWithObject.get('data').value));
        this.fs.filesUploadsWithObject(this.multipleFilesFromObject).subscribe((response: any) => {
          if(response['response'] == "pong") {
            this.type1Message = "-x-x-";
            this.type2Message = "-x-x-";
            this.filesUploadWithObjectMessage = "Image's && Image With Object Save";
            setTimeout(() => {
              alert("Image's && Image With Object Save");
              this.filesUploadWithObjectMessage = "-x-x-";
              this.multipleFilesFromObject = new FormData();
            }, 1000);
          }
        },error => {
          console.log("Error :- " + JSON.stringify(error));
        });
      }
    }
  }
  
  public isfilesUploadsTypeValid(fileType:number,file?:File,files?:FileList):void {
    if(fileType == 1) {
      if(file == undefined) {
        this.type1Message = "Process NoT Perform Due to File Not Valid";
        return;    
      } else if (file.type.match(/image\/*/) == null) {
        this.type1Message = "Only images are supported.";
        return;  
      } else {
        this.type1Message = "Image Accept.";
        this.multipleFilesFromObject.append('file', file, file.name);
      }
    } else if(fileType == 2) {
      if(files == undefined) {
        this.type2Message = "Process NoT Perform Due to File Not Valid";
        return;
      } else if(files.length > 6) {
        this.type2Message = "Only 5 images are supported.";
        return;
      } else {
        for (let index = 0; index < files.length; index++) {
          const file:File = files[index];
          // check :- only support images for upload
          if (file.type.match(/image\/*/) == null) {
            // if any of the file not image then show message
            this.type2Message = "Only images are supported.";   
            return;  
          }
          this.type2Message = "Image's Accept.";
          this.multipleFilesFromObject.append('files', files[index], files[index].name);
        }
      }
    }
  }

  /* * * * * * * * * * * * * * * * * * * *
  * Handle the Files With Obj Spring Api *
  * With HttpServeletReqeust             *
  * * * * * * * * * * * * * * * * * * * **/
  public totalfiles:File[] = [];
  public fileUploadWithHttpServert(objects:any):any {
    if(this.isServerActive()) {
      let main_form: FormData = new FormData();
      let allHttReqeustInfo: HttpRequestInfo[] = [];
      for (let index = 0; index < objects.items.length; index++) {
        let object:any = objects.items[index];
        let file:File = this.totalfiles[index];
        let file_name = null;
        let file_size = null;
        if(file != null) {
          // uuid need for remove the duplication name
          file_name = this.guid()+"-"+file.name;
          file_size = file.size;
          main_form.append(file_name,file);
        }

        let httpRequetInfo: HttpRequestInfo = {
          data: { doc_description: object.data.doc_description, doc_name: object.data.doc_name },
          fileInfo: {file_name:file_name, file_size:file_size}
        };

        allHttReqeustInfo.push(httpRequetInfo);      
      }
      main_form.append("request",JSON.stringify(allHttReqeustInfo));
      this.fs.fileUploadWithHttpServert(main_form).
        subscribe((response: any) => {
          if(response['response'] == "pong") {
            //console.log("You are Successfully Send the Request");
            setTimeout(() => { 
              alert("You are Successfully Send the Request");
              this.totalfiles = [];
            },1000);
            }
      },error => {
        console.log("Error :- " + JSON.stringify(error));
      });
    }
  }

  private guid():any {
    function s4():any { return Math.floor((1+Math.random())*0x10000).toString(16).substring(1); }
    return s4()+s4()+'-'+s4()+'-'+s4()+'-'+s4()+'-'+s4()+s4()+s4();
  }
  
  public get httpServertItems():FormArray { return this.fileWithObjectHttpServelt.get('items') as FormArray; };

  public httpServertFileSelectionEvent(fileInput:File,index:number) { this.totalfiles[index] = fileInput; }

  public httpServertAddItem():void { this.httpServertItems.push(this.buildItem(0)); }

  public httpServertRemoveItem(index:number) { this.httpServertItems.removeAt(index); this.totalfiles.splice(index,1); }
  
  /* * * * * * * * * * * * * * * * * * * *
  * Handle the Files With Obj Spring Api *
  * With HttpServeletReqeust             *
  * * * * * * * * * * * * * * * * * * * **/
  public singlefiles:File[] = [];
  public multiplefiles:any[] = []; // list of file's in index
  public multiplefileUploadWithHttpServert(objects:any):any {
    if(this.isServerActive()) {
      let request: FormData = new FormData();
      let httpRequetInfos: HttpRequestInfo[] = [];
      for (let index = 0; index < objects.items.length; index++) {
        let object = objects.items[index];
        let file:File = this.singlefiles[index];
        let files:FileList = this.multiplefiles[index];

        let file_name = null;
        let file_size = null;
        if(file != null) {
          file_name = this.guid()+"-"+file.name;
          file_size = file.size;
          request.append(file_name, file);
        }

        let allFileInfo:FileInfo[] = [];
        if(files != null) {
          for (let index = 0; index < files.length; index++) {
            const file:File = files[index];
            let fileInfo:FileInfo = {
              file_name: this.guid()+"-"+file.name,
              file_size: file.size
            }
            request.append(fileInfo.file_name, file);
            allFileInfo.push(fileInfo);
          }
        }

        let httpRequetInfo: HttpRequestInfo = {
          data: { doc_description: object.data.doc_description, doc_name: object.data.doc_name },
          fileInfo: { file_name:file_name, file_size:file_size },
          fileInfos: allFileInfo
        };

        httpRequetInfos.push(httpRequetInfo);
      }

      request.append('request', JSON.stringify(httpRequetInfos));
      // sending request
      this.fs.multiplefileUploadWithHttpServert(request).
      subscribe((response: any) => {
        if(response['response'] == "pong") {
          setTimeout(() => { 
            alert("You are Successfully Send the Request");
            this.singlefiles = [];
            this.multiplefiles = [];
          },1000);
        }
      },error => {
        console.log("Error :- " + JSON.stringify(error));
      });
    }
  };

  public get httpServertsItems():FormArray { return this.multipleFilesUploadWithHttpServert.get('items') as FormArray; };

  public httpServertsAddItem():void { this.httpServertsItems.push(this.buildItem(0)); }

  public httpServertsRemoveItem(index:number) { 
    this.httpServertsItems.removeAt(index);
    this.singlefiles.splice(index,1); 
    this.multiplefiles.splice(index,1); 
  }

  public httpServertsFileSelectionEvent(index:number,file?:File,files?:FileList):void {
    if(file != null) {
      this.singlefiles[index] = file;
    }else if(files != null){
      this.multiplefiles[index] = files;
    }
  }

  /* * * * * * * * * * * * * * * * * * * *
  * Handle the Files With Obj Spring Api *
  * * * * * * * * * * * * * * * * * * * **/
  //--------------------------------------------
  public objectsSingleFile:FormData[] = [];
  public objectsSingleFileMessage = "-x-x-";
  //--------------------------------------------
  // [{file,data}] // file
  public listOfObjectsWithSingleFile(): any {
    if(this.isServerActive()) {
      this.objectsWithSingleFile.get("objects").value.forEach(object => {
      });
    }    
  }

  public insertIndext(object:any):void {
    this.objectsWithSingleFileArray.push(object);
    this.objectsSingleFile.push(new FormData());
  }
  
  public deleteIndext(index:number):void{
    this.objectsWithSingleFileArray.removeAt(index);
    this.objectsSingleFile.splice(index,1);
  }
  
  public get objectsWithSingleFileArray(): FormArray{
	  return this.objectsWithSingleFile.get('objects') as FormArray;
  }

  // {files,data} // files
  public listOfObjectsWithMultipleFiles(): any {
    if(this.isServerActive()) {}
  }

  // [{file,files,data}] // file, files
  public listOfObjectsWithFiles(): any {
    if(this.isServerActive()) {}
  }

  // {file,data} // file=>base64
  public singleFileUploadWithBase64Object(): any {
    if(this.isServerActive()) {}
  }
  
  // {files,data} // files=>base64
  public multipleFileUploadWithBase64Object(): any {
    if(this.isServerActive()) {}
  }
  
  // {file,files,data} // file=>base64, files=>base64
  public filesUploadsWithBase64Object(): any {
    if(this.isServerActive()) {}
  }

  // [{file,data}] // file=>base64
  public listOfBase64ObjectsWithSingleFile(): any {
    if(this.isServerActive()) {}
  }

  // [{files,data}] // files=>base64
  public listOfBase64ObjectsWithMultipleFiles(): any {
    if(this.isServerActive()) {}
  }

  // [{file,files,data}] // file=>base64, files=>base64
  public listOffilesUploadsWithBase64Object(): any {
    if(this.isServerActive()) {}
  }

  public isServerActive():boolean { return this.response == "200" ? true: false; }

}

/* * * * * * * * * * * *Not Delete This * * * * * * * * * * *
 * Note :- https://nehalist.io/uploading-files-in-angular2/ *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * **/
