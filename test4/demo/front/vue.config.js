const { defineConfig } = require('@vue/cli-service')
const path = require('path');
module.exports = defineConfig({
  outputDir: '../src/main/resources/static',
    devServer: {
        port: 3030,
        proxy: {
            '/api': {
                target: 'http://localhost:3000'
            }
        }
    },
    configureWebpack: {
        resolve: {
            alias: {
                'BOARD': path.join(__dirname, 'src/components/board')
            }
        }
    }
})
