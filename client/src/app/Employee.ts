import {Department} from './Department';

export class Employee {
  id: number;
  name: string;
  active: boolean;
  department: Department;
  constructor(employee: Employee) {
    this.id = employee.id;
    this.name = employee.name;
    this.active = employee.active;
    this.department = new Department(employee.department);
  }
}
