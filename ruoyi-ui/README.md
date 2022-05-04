## 开发

```bash
# clone
git clone https://gitee.com/y_project/RuoYi-Vue

# Go to the project catalogue
cd ruoyi-ui

# Installing dependencies
npm install

# It is recommended that you do not use cnpm to install dependencies directly, as this can lead to all sorts of weird bugs. npm's slow download speed can be solved by doing the following
npm install --registry=https://registry.npm.taobao.org

# run
npm run dev
```

Browser access http://localhost:80

##  Publish

```bash
# Building the test environment
npm run build:stage

# Building the production environment
npm run build:prod
```