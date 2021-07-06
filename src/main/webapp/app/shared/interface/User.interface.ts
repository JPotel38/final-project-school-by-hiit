export interface User {
  id?: number;
  mail: string;
  firstName: string;
  lastName: string;
  roles: Role[];
  birthDate: string;
  creationDate?: string;
  phoneNumber: string;
  password: string;
}

export interface Role {
  id: number;
  name: string;
}
