import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { URLEntry } from './URLEntry';

@Injectable({
    providedIn: 'root'
})
export class ApiService {

    private shortenedURL: URLEntry = {baseURL: "", shortenedURL: ""};
    private error: string = "";

    constructor(private http: HttpClient) { }

    validateProtocol(url: string): boolean {

        return url.startsWith("http://") || url.startsWith("https://");
    }

    shortenURL(url: string): boolean {

        this.error = "";

        if (!this.validateProtocol(url)) {

            this.error = "please add a protocol (i.e., http:// or https://) to the URL";
            return false;
        }

        this.http.post<URLEntry>("http://localhost:5000/api/shorten", { baseURL: url }).subscribe(
            (m: URLEntry) => {
                if (m.shortenedURL !== "error") {

                    this.shortenedURL = m;
                    this.error = "";
                } else {

                    this.error = "the specified URL cannot be reached";
                    this.shortenedURL.baseURL = "";
                }
            },
            error => {
                
                this.error = error.statusText + ": " + error.message;
                this.shortenedURL.baseURL = "";
            });

        return true;
    }

    getError(): string {

        return this.error ? this.error : "";
    }

    getShortenedURL() {

        return this.shortenedURL && this.shortenedURL.baseURL !== "" ? this.shortenedURL : null;
    }
}
