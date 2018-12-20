import { Component, OnInit } from '@angular/core';
import { FileserviceService } from './fileservice.service';
import { FormBuilder, FormControl, FormGroup, Validators, FormArray } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  private response:string = "400";
  // from with object's
  private singleFileWithObject:FormGroup;
  private multipleFileWithObject:FormGroup;
  private filesWithObject:FormGroup;
  // -------Pending-----
  private objectsWithSingleFile:FormGroup;
  private objectsWithMultipleFiles:FormGroup;
  private objectsWithFiles:FormGroup;
  //---Base64Encode Data
  private base64ObjectWithSingleFileUpload:FormGroup;
  private base64ObjectWithmultipleFileUpload:FormGroup;
  private base64ObjectWithfilesUploads:FormGroup;
  private base64ObjectsWithSingleFile:FormGroup;
  private base64ObjectsWithMultipleFiles:FormGroup;
  private base64ObjectWithfiles:FormGroup;
  
  public constructor(private fs:FileserviceService, private fb:FormBuilder) {}


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
      data : new FormGroup({
        name: new FormControl('', Validators.required),
        quantity: new FormControl('', Validators.required),  
      }),
      file : new FormControl()
    });
    //--------------MultipleFileWithObject--------------
    this.multipleFileWithObject = this.fb.group({
      data : new FormGroup({
        name: new FormControl('', Validators.required),
        quantity: new FormControl('', Validators.required),  
      }),
      files : new FormControl()
    });
    //--------------FilesWithObject--------------
    this.filesWithObject = this.fb.group({
      data : new FormGroup({
        name: new FormControl('', Validators.required),
        quantity: new FormControl('', Validators.required),  
      }),
      file : new FormControl(),
      files : new FormControl()
    });
    //--------------ObjectsWithSingleFile---------
    this.objectsWithSingleFile = this.fb.group({
      objects:this.fb.array([this.buildItem(1)])
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
          file : new FormControl(),
          files : new FormControl()
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
    this.base64ObjectWithmultipleFileUpload = this.fb.group({
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

  /* * * * * * * * * * * * * * * * * * * * * *
   * Handle the Single File With Spring Api  *
   * * * * * * * * * * * * * * * * * * * * * */
  //-------------------------------------------
  public single_file_message:string = "-x-x-";
  private single_file_imgURL:any;
  //-------------------------------------------
  private singleFileUpload(file:File):any {
    if(this.isServerActive()) { this.singleFilePreviewAndSubmit(file); }
  }

  private singleFilePreviewAndSubmit(file:File):void {
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
   * Handle the Multiple Files With Spring Api *
   * * * * * * * * * * * * * * * * * * * * * * */
  //----------------------------------------------
  private multiple_files_message:string = "-x-x-";
  private multiple_files_imgURL = new Array<string>();
  //-----------------------------------------------
  private multipleFileUpload(files:FileList):any {
    if(this.isServerActive() && files.length > 0) {
      this.multipleFilesPreviewAndSubmit(files);
    } else {
      this.multiple_files_message = "Process NoT Perform Due to File Not Valid"; 
    }
  }

  private multipleFilesPreviewAndSubmit(files:FileList):void {
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
      reader.onload = (e: any) => {
        this.multiple_files_imgURL.push(e.target.result);
      }
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
  * Handle the Single File With Obj Spring Api *
  * * * * * * * * * * * * * * * * * * * * * * **/
  //---------------------------------------------
  private singleFileWithObjectMessage:string = "-x-x-";
  private singleFileFrom:any = new FormData();
  //--------------------------------------------
  // {file,data} // file
  private singleFileUploadWithObject():any {
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
            }, 1000);
          }
        },error => {
          console.log("Error :- " + JSON.stringify(error));
        });
      }
    }
  }

  private isfileTypeValid(file:File):void {
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
  * Handle the Multiple Files With Obj Spring Api *
  * * * * * * * * * * * * * * * * * * * * * * * * */
  //--------------------------------------------
  private multipleFilesUploadWithObjectMessage:string = "-x-x-";
  private multipleFilesFrom:any = new FormData();
  //--------------------------------------------
  // {files,data} // files
  private multipleFilesUploadWithObject():any {
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
            }, 1000);
          }
        },error => {
          console.log("Error :- " + JSON.stringify(error));
        });
      }
    }
  }

  private isfilesTypeValid(files:FileList):void {
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
  * Handle the Files With Obj Spring Api *
  * * * * * * * * * * * * * * * * * * * **/
 //--------------------------------------------
  private filesUploadWithObjectMessage:string = "-x-x-";
  private type1Message:string = "-x-x-";
  private type2Message:string = "-x-x-";
  private multipleFilesFromObject:any = new FormData();
  //--------------------------------------------
  // {file,files,data} // file, files
  private filesUploadsWithObject(): any {
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
            }, 1000);
          }
        },error => {
          console.log("Error :- " + JSON.stringify(error));
        });
      }
    }
  }
  
  private isfilesUploadsTypeValid(fileType:number,file?:File,files?:FileList):void {
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
          const file = files[index];
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
  * * * * * * * * * * * * * * * * * * * **/
  //--------------------------------------------
  private objectsSingleFile:FormData[] = [];
  private objectsSingleFileMessage = "-x-x-";
  //--------------------------------------------
  // [{file,data}] // file
  private listOfObjectsWithSingleFile(): any {
    if(this.isServerActive()) {
      this.objectsWithSingleFile.get("objects").value.forEach(object => {
        
      });
    }    
  }

  private insertIndext(object:any):void {
    this.objectsWithSingleFileArray.push(object);
    this.objectsSingleFile.push(new FormData());
  }
  
  private deleteIndext(index:number):void{
    this.objectsWithSingleFileArray.removeAt(index);
    this.objectsSingleFile.splice(index,1);
  }
  
  private get objectsWithSingleFileArray(): FormArray{
	  return this.objectsWithSingleFile.get('objects') as FormArray;
  }

  public buildItem(objectType:number):any {
    if(objectType == 1) {
      console.log("Object Type :- " + objectType);
      return new FormGroup({
        data : new FormGroup({
          name: new FormControl('', Validators.required),
          quantity: new FormControl('', Validators.required),  
        }),
        file: new FormControl(File)
      })
    }
  }

  // {files,data} // files
  private listOfObjectsWithMultipleFiles(): any {
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

  private isServerActive():boolean { return this.response == "200" ? true: false; }

}

/* * * * * * * * * * * *Not Delete This * * * * * * * * * * *
 * Note :- https://nehalist.io/uploading-files-in-angular2/ *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * **/