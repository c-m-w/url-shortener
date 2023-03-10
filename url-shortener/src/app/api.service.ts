import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { URLEntry } from './URLEntry';

@Injectable({
    providedIn: 'root'
})
export class ApiService {

    constructor(private http: HttpClient) { }

    shortenURL(url: string) {

        return this.http.post<URLEntry>("http://localhost:5000/api/shorten", {baseURL: url});
    }

    getShortenedURLs() {

        return this.http.get<Array<URLEntry>>("http://localhost:5000/api/url");
    }
}
