import { Roles } from "./roles.enum";

export interface user{
  id:number;
  name: string;
  email: string;
  role: Roles;
}