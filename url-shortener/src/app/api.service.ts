import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Message } from './message';

@Injectable({
    providedIn: 'root'
})
export class ApiService {

    constructor(private http: HttpClient) { }

    shortenURL(url: string) {

        return this.http.post<Message>("http://localhost:5000/api/shorten", {url: url});
    }
}
