import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: Routing configuration items
 * hidden: true
 * hidden: true // when set true the route will not appear in the sidebar on pages such as 401, login, etc., or on some edit pages /edit/1
 * alwaysShow: true // When you have more than one route declared by children under a route, it will automatically become nested - e.g. component pages
 * // When there is only one, that child route will be displayed in the sidebar as the root route - e.g. on the guide page
 * // If you want to show your root route regardless of the number of children declared under the route
 * // You can set alwaysShow: true so that it ignores the previously defined rule and always shows the root route
 * redirect: noRedirect // when noRedirect is set the route is not clickable in the breadcrumb navigation
 * name:'router-name' // Set the name of the route, make sure you fill it in or you'll have problems with <keep-alive>
 * query: '{"id": 1, "name": "ry"}' // Default parameters passed for accessing the route
 * roles: ['admin', 'common'] // Role permissions for accessing routes
 * permissions: ['a:a:a', 'b:b:b'] // Menu permissions to access the route
 * meta : {
    noCache: true // if set to true, not cached by <keep-alive> (default false)
    title: 'title' // set the name of the route to be displayed in the sidebar and breadcrumbs
    icon: 'svg-name' // Set the icon for the route, corresponding to the path src/assets/icons/svg
    breadcrumb: false // if set to false, it will not be displayed in the breadcrumb breadcrumbs
    activeMenu: '/system/user' // When this property is set for the route, the corresponding sidebar will be highlighted.
  }
 */


export const constantRoutes = [
  {
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path(.*)',
        component: () => import('@/views/redirect')
      }
    ]
  },
  {
    path: '/login',
    component: () => import('@/views/login'),
    hidden: true
  },
  {
    path: '/register',
    component: () => import('@/views/register'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('@/views/error/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views/error/401'),
    hidden: true
  },
  {
    path: '',
    component: Layout,
    redirect: 'index',
    children: [
      {
        path: 'index',
        component: () => import('@/views/index'),
        name: 'Index',
        meta: { title: 'Home', icon: 'dashboard', affix: true }
      }
    ]
  },
  {
    path: '/user',
    component: Layout,
    hidden: true,
    redirect: 'noredirect',
    children: [
      {
        path: 'profile',
        component: () => import('@/views/system/user/profile/index'),
        name: 'Profile',
        meta: { title: 'Personal Information', icon: 'user' }
      }
    ]
  }
]


export const dynamicRoutes = [
  {
    path: '/system/user-auth',
    component: Layout,
    hidden: true,
    permissions: ['system:user:edit'],
    children: [
      {
        path: 'role/:userId(\\d+)',
        component: () => import('@/views/system/user/authRole'),
        name: 'AuthRole',
        meta: { title: 'Allocation Role', activeMenu: '/system/user' }
      }
    ]
  },
  {
    path: '/system/role-auth',
    component: Layout,
    hidden: true,
    permissions: ['system:role:edit'],
    children: [
      {
        path: 'user/:roleId(\\d+)',
        component: () => import('@/views/system/role/authUser'),
        name: 'AuthUser',
        meta: { title: 'Allocation user', activeMenu: '/system/role' }
      }
    ]
  },
  {
    path: '/system/dict-data',
    component: Layout,
    hidden: true,
    permissions: ['system:dict:list'],
    children: [
      {
        path: 'index/:dictId(\\d+)',
        component: () => import('@/views/system/dict/data'),
        name: 'Data',
        meta: { title: 'Dictionary data', activeMenu: '/system/dict' }
      }
    ]
  },
  {
    path: '/monitor/job-log',
    component: Layout,
    hidden: true,
    permissions: ['monitor:job:list'],
    children: [
      {
        path: 'index',
        component: () => import('@/views/monitor/job/log'),
        name: 'JobLog',
        meta: { title: 'Scheduling log', activeMenu: '/monitor/job' }
      }
    ]
  },
  {
    path: '/tool/gen-edit',
    component: Layout,
    hidden: true,
    permissions: ['tool:gen:edit'],
    children: [
      {
        path: 'index',
        component: () => import('@/views/tool/gen/editTable'),
        name: 'GenEdit',
        meta: { title: 'change Generate configuration', activeMenu: '/tool/gen' }
      }
    ]
  }
]

export default new Router({
  mode: 'history',
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})
