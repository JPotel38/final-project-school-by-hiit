export interface Report {
  id?: number;
  teacherId: number;
  tutorId: number;
  studentId: number;
  appointmentDate: Date;
  reportText: string;
  validated: string;
}
