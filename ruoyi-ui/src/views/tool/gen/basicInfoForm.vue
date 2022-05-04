<template>
  <el-form ref="basicInfoForm" :model="info" :rules="rules" label-width="150px">
    <el-row>
      <el-col :span="12">
        <el-form-item label="表Name" prop="tableName">
          <el-input placeholder="Please Input仓库Name" v-model="info.tableName" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="表描述" prop="tableComment">
          <el-input placeholder="Please Input" v-model="info.tableComment" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="实体类Name" prop="className">
          <el-input placeholder="Please Input" v-model="info.className" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="作者" prop="functionAuthor">
          <el-input placeholder="Please Input" v-model="info.functionAuthor" />
        </el-form-item>
      </el-col>
      <el-col :span="24">
        <el-form-item label="Remarks" prop="remark">
          <el-input type="textarea" :rows="3" v-model="info.remark"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
  </el-form>
</template>

<script>
export default {
  props: {
    info: {
      type: Object,
      default: null
    }
  },
  data() {
    return {
      rules: {
        tableName: [
          { required: true, message: "Please Input表Name", trigger: "blur" }
        ],
        tableComment: [
          { required: true, message: "Please Input表描述", trigger: "blur" }
        ],
        className: [
          { required: true, message: "Please Input实体类Name", trigger: "blur" }
        ],
        functionAuthor: [
          { required: true, message: "Please Input作者", trigger: "blur" }
        ]
      }
    };
  }
};
</script>
