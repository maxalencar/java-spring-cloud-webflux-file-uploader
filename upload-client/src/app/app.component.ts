import { Component, OnInit, Inject } from '@angular/core';
import { FileUploader, FileSelectDirective } from 'ng2-file-upload/ng2-file-upload';
import { EventService } from './event.service';
import { Event } from './event';
import { API_ENDPOINT } from './app.tokens';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'upload-client';
  file;
  events: Event[];

  constructor(private eventService: EventService, @Inject(API_ENDPOINT) private apiEndpoint) { }

  public uploader: FileUploader = new FileUploader({url: `${this.apiEndpoint}`, itemAlias: 'file'});

  getEvents(): void {
    this.eventService.getEvents().subscribe(events => this.events = events);
  }

  ngOnInit() {
    this.uploader.onAfterAddingFile = (file) => { file.withCredentials = false; };
    this.uploader.onCompleteItem = (item: any, response: any, status: any, headers: any) => {
      this.file = item;
      
      if (this.file.isSuccess) {
        this.getEvents();
      }
     };

     this.getEvents();
 }
}
