import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {EmployeeDTO} from './EmployeeDTO';

@Injectable({
  providedIn: 'root'
})
export class TestService {

  constructor(private http: HttpClient) { }

  findEmployees(page: number): Observable<any> {
    return this.http.get('http://localhost:8080/employee/' + page);
  }
  findAllDepartments(): Observable<any> {
    return this.http.get('http://localhost:8080/department');
  }
  searchByName(page: number, searchText: string): Observable<any> {
    return this.http.get('http://localhost:8080/employee/' + page + '/' + searchText);
  }
  updateEmployee(employee: EmployeeDTO): Observable<any> {
    return this.http.put('http://localhost:8080/employee', employee);
  }
  deleteEmployee(id: number): Observable<any> {
    return this.http.delete('http://localhost:8080/employee/' + id);
  }
}
