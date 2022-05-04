<template>
  <div class="app-container home">

    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 20px">
        <h1>Fashion Management</h1>
        <p>
          Offering used fast fashion products for sale to people nearby
        </p>

        <p>
          The Story of Fashion Management<br>A platform dedicated to second-hand trading of<br>fast fashion products for those living in the neighbourhood
        </p>

        <p>
          <el-button
            type="primary"
            size="mini"
            icon="el-icon-cloudy"
            plain
            @click="goTarget('http://localhost:1024/login')"
            >Click Login</el-button
          >
          <el-button
            size="mini"
            icon="el-icon-s-home"
            plain
            @click="goTarget('http://localhost:1024/register')"
            >Click Register</el-button
          >
        </p>


      </el-col>

      <el-col :sm="24" :lg="12" style="padding-left: 50px">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>Recommended Products</span>
          </div>
          <div class="body">
            <img
              src="https://pic1.zhimg.com/v2-47822bf1b571671afde1c10809cb37d4_b.jpg"
              alt="donate"
              width="100%"
            />
            <span style="display: inline-block; height: 30px; line-height: 30px"
            >You can register and log in on the left to view the items of interest</span
            >
          </div>
        </el-card>

      </el-col>
    </el-row>

    <el-divider />

    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>Product Category: Menswear</span>
          </div>
          <div class="body">
            <img
              src="http://www.mfashionw.com/upload/images/20210929/0215%20(36).jpg"
              alt="donate"
              width="100%"
            />
            <span style="display: inline-block; height: 30px; line-height: 30px">

            </span>
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>Product Category: Womenswear</span>
          </div>
          <div class="body">
            <img
              src="https://img.ixintu.com/download/jpg/201912/eb658f342605f448856afa5b9d350e32.jpg!ys"
              alt="donate"
              width="100%"
            />
            <span style="display: inline-block; height: 30px; line-height: 30px"
            >You can register and log in on the left to view the items of interest</span
            >
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>Product Category: kids</span>
          </div>
          <div class="body">
            <img
              src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTvNyd3vdFydciY5nPNY9QDcHhd5x0vjTFahw&usqp=CAU"
              alt="donate"
              width="100%"
            />
            <span style="display: inline-block; height: 30px; line-height: 30px">
            </span>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.8.1",
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
  },
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

