import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then( m => m.HomePageModule)
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },  {
    path: 'module-detail',
    loadChildren: () => import('./module-detail/module-detail/module-detail.module').then( m => m.ModuleDetailPageModule)
  },
  {
    path: 'module-list',
    loadChildren: () => import('./module-list/module-list/module-list.module').then( m => m.ModuleListPageModule)
  },
  {
    path: 'module-list',
    loadChildren: () => import('./module-list/module-list/module-list.module').then( m => m.ModuleListPageModule)
  },  {
    path: 'module-creation',
    loadChildren: () => import('./module-creation/module-creation.module').then( m => m.ModuleCreationPageModule)
  },
  {
    path: 'course-list',
    loadChildren: () => import('./course-list/course-list.module').then( m => m.CourseListPageModule)
  },
  {
    path: 'course-detail',
    loadChildren: () => import('./course-detail/course-detail.module').then( m => m.CourseDetailPageModule)
  },
  {
    path: 'course-creation',
    loadChildren: () => import('./course-creation/course-creation.module').then( m => m.CourseCreationPageModule)
  },


];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
