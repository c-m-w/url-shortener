import { Component, Input } from '@angular/core';

@Component({
    selector: 'app-shadow-box',
    templateUrl: './shadow-box.component.html',
    styleUrls: ['./shadow-box.component.css']
})
export class ShadowBoxComponent {

    @Input() title!: string;
    @Input() interactionState!: boolean;
}
