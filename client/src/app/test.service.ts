import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {EmployeeDTO} from './EmployeeDTO';

@Injectable({
  providedIn: 'root'
})
export class TestService {

  constructor(private http: HttpClient) { }

  findAllEmployees(): Observable<any> {
    return this.http.get('http://localhost:8080/employee');
  }
  findAllDepartments(): Observable<any> {
    return this.http.get('http://localhost:8080/department');
  }
  searchByName(searchText: string): Observable<any> {
    return this.http.get('http://localhost:8080/employee/' + searchText);
  }
  updateEmployee(employee: EmployeeDTO): Observable<any> {
    return this.http.put('http://localhost:8080/employee', employee);
  }
  deleteEmployee(id: number): Observable<any> {
    return this.http.delete('http://localhost:8080/employee/' + id);
  }
}
