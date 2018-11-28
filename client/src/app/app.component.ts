import {Component, OnInit} from '@angular/core';
import {TestService} from './test.service';
import {Employee} from './Employee';
import {Department} from './Department';


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
  constructor(private service: TestService) { }
  ngOnInit() {
    this.nameUpdateError = false;
    this.searchText = '';
      this.service.findAllEmployees()
        .subscribe((data: any) => {
          this.employees = data;
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
        this.employees = this.employees
          .filter(employee => employee.id !== id);
        if (this.selectedEmployee !== null && id === this.selectedEmployee.id) {
          this.selectedEmployee = null;
        }
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
    this.service.updateEmployee(employee).subscribe(() => {
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
}
