import { Injectable, Inject } from '@angular/core';
import { Event } from './event';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from '../../node_modules/rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { MessageService } from './message.service';
import { API_ENDPOINT } from './app.tokens';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  constructor(private http: HttpClient, private messageService: MessageService, @Inject(API_ENDPOINT) private apiEndpoint) { }

  getEvents (): Observable<Event[]> {
    return this.http.get<Event[]>(`${this.apiEndpoint}`)
    .pipe(
      tap(events => this.log('fetched events')),
      catchError(this.handleError('getEvents', []))
    );
  }

  /** Log a EventService message with the MessageService */
  private log(message: string) {
    this.messageService.add(`EventService: ${message}`);
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
  
      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
}
}
