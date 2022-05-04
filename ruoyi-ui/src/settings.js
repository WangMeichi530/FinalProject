module.exports = {
  /**
   * 侧边栏主题 深色主题theme-dark，浅色主题theme-light
   */
  sideTheme: 'theme-dark',

  /**
   * YesNo系统Layout配置
   */
  showSettings: false,

  /**
   * YesNoshow顶部导航
   */
  topNav: false,

  /**
   * YesNoshow tagsView
   */
  tagsView: true,

  /**
   * YesNo固定头部
   */
  fixedHeader: false,

  /**
   * YesNoshowlogo
   */
  sidebarLogo: true,

  /**
   * YesNoshow动态标题
   */
  dynamicTitle: false,

  /**
   * @type {string | array} 'production' | ['production', 'development']
   * @description Need show err logs component.
   * The default is only used in the production env
   * If you want to also use it in dev, you can pass ['production', 'development']
   */
  errorLog: 'production'
}
