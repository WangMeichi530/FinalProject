'use strict'
const path = require('path')

function resolve(dir) {
  return path.join(__dirname, dir)
}

const CompressionPlugin = require('compression-webpack-plugin')

const name = process.env.VUE_APP_TITLE || 'Fashion Management' // Page Title

const port = process.env.port || process.env.npm_config_port || 80 // port

// vue.config.js configuration instructions
// Official vue.config.js reference documentation https://cli.vuejs.org/zh/config/#css-loaderoptions
// Only a part of it is listed here, refer to the documentation for the specific configuration
module.exports = {
  // The URL for deploying production and development environments.
  // By default, the Vue CLI will assume that your application is deployed on the root path of a domain
  // For example https://www.ruoyi.vip/. If the application is deployed on a subpath, you will need to specify that subpath with this option. For example, if your application is deployed at https://www.ruoyi.vip/admin/, set the baseUrl to /admin/.
  publicPath: process.env.NODE_ENV === "ion" ? "/" : "/",
  // When npm run build or yarn build, the directory name of the generated file (to match the production environment path of baseUrl) (default dist)
  outputDir: 'dist',
  // for static resources (js, css, img, fonts) generated; (static resources are placed in this folder after the project is packaged)
  assetsDir: 'static',
  // If or not eslint save detection is enabled, valid values: ture | false | 'error'
  lintOnSave: process.env.NODE_ENV === 'development',
  // If you don't need a source map for production, you can set it to false to speed up production builds.
  productionSourceMap: false,
  // webpack-dev-server related configuration
  devServer: {
    host: '0.0.0.0',
    port: port,
    open: true,
    proxy: {
      // detail: https://cli.vuejs.org/config/#devserver-proxy
      [process.env.VUE_APP_BASE_API]: {
        target: `http://localhost:8080`,
        changeOrigin: true,
        pathRewrite: {
          ['^' + process.env.VUE_APP_BASE_API]: ''
        }
      }
    },
    disableHostCheck: true
  },
  css: {
    loaderOptions: {
      sass: {
        sassOptions: { outputStyle: "expanded" }
      }
    }
  },
  configureWebpack: {
    name: name,
    resolve: {
      alias: {
        '@': resolve('src')
      }
    },
    plugins: [
      // http://doc.ruoyi.vip/ruoyi-vue/other/faq.html#使用gzip解压缩静态文件
      new CompressionPlugin({
        test: /\.(js|css|html)?$/i,     // Compressed file formats
        filename: '[path].gz[query]',   // Compressed file name
        algorithm: 'gzip',              // Compression with gzip
        minRatio: 0.8                   // Compression ratio less than 1 before compression
      })
    ],
  },
  chainWebpack(config) {
    config.plugins.delete('preload') // TODO: need test
    config.plugins.delete('prefetch') // TODO: need test

    // set svg-sprite-loader
    config.module
      .rule('svg')
      .exclude.add(resolve('src/assets/icons'))
      .end()
    config.module
      .rule('icons')
      .test(/\.svg$/)
      .include.add(resolve('src/assets/icons'))
      .end()
      .use('svg-sprite-loader')
      .loader('svg-sprite-loader')
      .options({
        symbolId: 'icon-[name]'
      })
      .end()

    config
      .when(process.env.NODE_ENV !== 'development',
        config => {
          config
            .plugin('ScriptExtHtmlWebpackPlugin')
            .after('html')
            .use('script-ext-html-webpack-plugin', [{
            // `runtime` must same as runtimeChunk name. default is `runtime`
              inline: /runtime\..*\.js$/
            }])
            .end()
          config
            .optimization.splitChunks({
              chunks: 'all',
              cacheGroups: {
                libs: {
                  name: 'chunk-libs',
                  test: /[\\/]node_modules[\\/]/,
                  priority: 10,
                  chunks: 'initial' // only package third parties that are initially dependent
                },
                elementUI: {
                  name: 'chunk-elementUI', // split elementUI into a single package
                  priority: 20, // the weight needs to be larger than libs and app or it will be packaged into libs or app
                  test: /[\\/]node_modules[\\/]_?element-ui(.*)/ // in order to adapt to cnpm
                },
                commons: {
                  name: 'chunk-commons',
                  test: resolve('src/components'), // can customize your rules
                  minChunks: 3, //  minimum common number
                  priority: 5,
                  reuseExistingChunk: true
                }
              }
            })
          config.optimization.runtimeChunk('single'),
          {
             from: path.resolve(__dirname, './public/robots.txt'), //Anti-crawler files
             to: './' //Go to the root directory
          }
        }
      )
  }
}
