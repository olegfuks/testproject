import {Component, OnInit} from '@angular/core';
import {TestService} from './test.service';
import {Employee} from './Employee';
import {Department} from './Department';
import {EmployeeDTO} from './EmployeeDTO';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [TestService]
})
export class AppComponent implements OnInit {
  nameUpdateError: boolean;
  employees: Employee[];
  departments: Department[];
  selectedEmployee: Employee;
  searchText: string;
  page: number;
  totalItems: number;
  constructor(private service: TestService) { }
  ngOnInit() {
    this.page = 1;
    this.nameUpdateError = false;
    this.searchText = '';
      this.service.findEmployees(this.page)
        .subscribe((data: any) => {
          console.log(data);
          this.employees = data.content;
          this.totalItems = data.totalElements;
        });
  }
  onSelect(employee: Employee): void {
    this.nameUpdateError = false;
    this.selectedEmployee = new Employee(employee);
    this.service.findAllDepartments()
      .subscribe((data: any) => {
        this.departments = data;
      });
  }
  removeEmployee(id: number) {
    this.service.deleteEmployee(id).subscribe(() => {
      }, error => console.log(error),
      () => {
        this.ngOnInit();
          this.selectedEmployee = null;
      });
  }
  searchByName(searchText: string) {
    this.service.searchByName(searchText)
      .subscribe((data: any) => {
        this.employees = data;
      });
  }
  updateEmployee(employee: Employee) {
    console.log(employee);
    this.service.updateEmployee(new EmployeeDTO(employee)).subscribe(() => {
      }, error => this.nameUpdateError = true,
      () => {
      this.ngOnInit();
        this.nameUpdateError = false;
        this.selectedEmployee = null;
      });
  }
  cancelEdit() {
    this.nameUpdateError = false;
    this.selectedEmployee = null;
  }
  pageChange($event) {
    this.page = $event;
    this.service.findEmployees(this.page)
      .subscribe((data: any) => {
        console.log(data);
        this.employees = data.content;
        this.totalItems = data.totalElements;
      });
    return $event;
  }
}
