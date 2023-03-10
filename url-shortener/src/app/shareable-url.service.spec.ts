import { TestBed } from '@angular/core/testing';

import { ShareableURLService } from './shareable-url.service';

describe('ShareableURLService', () => {
    let service: ShareableURLService;

    beforeEach(() => {
        TestBed.configureTestingModule({});
        service = TestBed.inject(ShareableURLService);
    });

    it('should be created', () => {
        expect(service).toBeTruthy();
    });
});
