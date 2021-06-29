export interface User {
  id?: number;
  mail: string;
  firstName: string;
  lastName: string;
  roles: Role[];
}

export interface Role {
  id: number;
  name: string;
}
