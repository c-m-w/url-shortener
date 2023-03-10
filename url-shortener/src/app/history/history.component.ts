import { Component } from '@angular/core';
import { ApiService } from '../api.service';
import { URLEntry } from '../URLEntry';

@Component({
    selector: 'app-history',
    templateUrl: './history.component.html',
    styleUrls: ['./history.component.css']
})
export class HistoryComponent {

    history: Array<URLEntry> = [];

    constructor(private apiService: ApiService) { }

    ngOnInit(): void {

        this.apiService.getShortenedURLs().subscribe((history: Array<URLEntry>) => {

            console.log(history);
            this.history = history;
        },
        error => {
            console.log("error");
        })
    }
}
