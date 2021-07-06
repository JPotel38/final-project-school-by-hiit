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
    path: 'module-update/:id',
    loadChildren: () => import('./module-update/module-update.module').then( m => m.ModuleUpdatePageModule)
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
    path: 'course-update/:id',
    loadChildren: () => import('./course-update/course-update.module').then( m => m.CourseUpdatePageModule)
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
  },
  {
    path: 'file-update/:id',
    loadChildren: () => import('./file-update/file-update.module').then( m => m.FileUpdatePageModule)
  }



];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
