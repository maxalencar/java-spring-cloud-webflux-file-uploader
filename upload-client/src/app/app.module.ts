import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FileSelectDirective } from 'ng2-file-upload';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { EventService } from './event.service';

import { API_ENDPOINT } from './app.tokens';

@NgModule({
  declarations: [
    AppComponent,
    FileSelectDirective
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule 
  ],
  providers: [
    EventService,
    { provide: API_ENDPOINT, useValue: 'http://localhost:8090/upload' }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
