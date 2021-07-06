import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import {IsAdminGuard} from "./shared/guard/is-admin-guard.service";
import {IsSignedInGuard} from "./shared/guard/is-signed-in-guard.service";

const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then(m => m.HomePageModule)
  },
  {
    path: 'schedule',
    loadChildren: () => import('./schedule/schedule.module').then( m => m.SchedulePageModule),
    canActivate: [IsAdminGuard]
  },
  {
    path: 'schedule-view',
    loadChildren: () => import('./schedule-view/schedule-view.module').then( m => m.ScheduleViewPageModule),
    canActivate: [IsSignedInGuard]
  },
  {
    path: 'user-list',
    loadChildren: () => import('./user-list/user-list.module').then( m => m.UserListPageModule),
    canActivate: [IsAdminGuard]
  },
  {
    path: 'user-detail/:id',
    loadChildren: () => import('./user-detail/user-detail.module').then( m => m.UserDetailPageModule),
    canActivate: [IsAdminGuard]
  },
  {
    path: 'create-user',
    loadChildren: () => import('./create-user/create-user.module').then( m => m.CreateUserPageModule),
    canActivate: [IsAdminGuard]
  },
  {
    path: 'user-update/:id',
    loadChildren: () => import('./user-update/user-update.module').then( m => m.UserUpdatePageModule),
    canActivate: [IsAdminGuard]
  },
  {
    path: 'login',
    loadChildren: () => import('./login/login.module').then( m => m.LoginPageModule)
  },
  {
    path: 'project-detail/:id',
    loadChildren: () => import('./project-detail/project-detail.module').then( m => m.ProjectDetailPageModule),
    canActivate: [IsSignedInGuard]

  },
  {
    path: 'projects',
    loadChildren: () => import('./project/project.module').then( m => m.ProjectPageModule),
    //canActivate: [IsSignedInGuard]
  },
  {
    path: 'project-update/:id',
    loadChildren: () => import('./project-update/project-update.module').then( m => m.ProjectUpdatePageModule),
    canActivate: [IsAdminGuard]

  },
  {
    path: 'project-add',
    loadChildren: () => import('./project-add/project-add.module').then( m => m.ProjectAddPageModule),
    canActivate: [IsAdminGuard]

  },
  {
    path: 'reports',
    loadChildren: () => import('./reports/reports.module').then( m => m.ReportsPageModule),
  },
  {
    path: '**',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'module-detail/:id',
    loadChildren: () => import('./module-detail/module-detail.module').then( m => m.ModuleDetailPageModule)
  },
  {
    path: 'module-list',
    loadChildren: () => import('./module-list/module-list.module').then( m => m.ModuleListPageModule)
  },
  {
    path: 'module-creation',
    loadChildren: () => import('./module-creation/module-creation.module').then( m => m.ModuleCreationPageModule)
  },
  {
    path: 'course-list',
    loadChildren: () => import('./course-list/course-list.module').then( m => m.CourseListPageModule)
  },
  {
    path: 'course-detail/:id',
    loadChildren: () => import('./course-detail/course-detail.module').then( m => m.CourseDetailPageModule)
  },
  {
    path: 'course-creation',
    loadChildren: () => import('./course-creation/course-creation.module').then( m => m.CourseCreationPageModule)
  },
  {
    path: 'file-list',
    loadChildren: () => import('./file-list/file-list.module').then( m => m.FileListPageModule)
  },
  {
    path: 'file-detail/:id',
    loadChildren: () => import('./file-detail/file-detail.module').then( m => m.FileDetailPageModule)
  },
  {
    path: 'file-creation',
    loadChildren: () => import('./file-creation/file-creation.module').then( m => m.FileCreationPageModule)
  }


];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
