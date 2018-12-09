import {Employee} from './Employee';

export class EmployeeDTO {
  id: number;
  name: string;
  active: boolean;
  departmentId: number;
  constructor(employee: Employee) {
    this.id = employee.id;
    this.name = employee.name;
    this.active = employee.active;
    this.departmentId = employee.department.id;
  }
}
