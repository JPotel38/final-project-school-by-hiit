export interface User {
  id?: string;
  lastName: string;
  firstName: string;
  birthDay: string;
  creationDate?: string;
  mail: string;
  phoneNumber: string;
  password: string;
  roles: Role[];
}

export interface Role {
  id: string;
  name: string;
}
