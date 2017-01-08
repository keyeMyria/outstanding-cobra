import {Injectable} from "@angular/core";
import {HttpInterceptor} from "../../shared/http/HttpInterceptor";
import {Observable} from "rxjs";
import {SubjectDto} from "../model/ManageDto";
import {AppCrudService} from "../../shared/services/core/app-crud.service";

@Injectable()
export class SubjectService extends AppCrudService<SubjectDto> {
    constructor(http: HttpInterceptor) {
        super(http, '/subject')
    }

    create(subject: SubjectDto): Observable<SubjectDto> {
        return this.http.put<SubjectDto>(this.baseUri, subject, 'outcobra')
    }

    readById(id: number): Observable<SubjectDto> {
        throw new Error('not implemented');
    }

    readAll(): Observable<SubjectDto[]> {
        return this.http.get<SubjectDto[]>(this.baseUri, 'outcobra');
    }

    deleteById(id: number): Observable<any> {
        return this.http.delete(`${this.baseUri}/${id}`, 'outcobra');
    }

    update(arg: SubjectDto): Observable<SubjectDto> {
        throw new Error('not implemented');
    }

    getCurrentSubjects(): Observable<SubjectDto[]> {
        return this.http.get<SubjectDto[]>(`${this.baseUri}/current`, 'outcobra');
    }
}
