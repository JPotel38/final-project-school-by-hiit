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
    path: 'reports',
    loadChildren: () => import('./reports/reports.module').then( m => m.ReportsPageModule),
  },
  {
    path: '**',
    redirectTo: 'home',
    pathMatch: 'full'
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
