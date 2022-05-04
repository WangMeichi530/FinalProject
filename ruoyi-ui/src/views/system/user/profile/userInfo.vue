<template>
  <el-form ref="form" :model="user" :rules="rules" label-width="80px">
    <el-form-item label="usernickname" prop="nickName">
      <el-input v-model="user.nickName" maxlength="30" />
    </el-form-item>
    <el-form-item label="Phone Number" prop="phonenumber">
      <el-input v-model="user.phonenumber" maxlength="11" />
    </el-form-item>
    <el-form-item label="E-mail" prop="email">
      <el-input v-model="user.email" maxlength="50" />
    </el-form-item>
    <el-form-item label="Sex">
      <el-radio-group v-model="user.sex">
        <el-radio label="0">male</el-radio>
        <el-radio label="1">female</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" size="mini" @click="submit">Keep</el-button>
      <el-button type="danger" size="mini" @click="close">Close</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import { updateUserProfile } from "@/api/system/user";

export default {
  props: {
    user: {
      type: Object
    }
  },
  data() {
    return {
      // 表单校验
      rules: {
        nickName: [
          { required: true, message: "usernicknamecannot be empty", trigger: "blur" }
        ],
        email: [
          { required: true, message: "E-mailAddresscannot be empty", trigger: "blur" },
          {
            type: "email",
            message: "'Please Input正确的E-mailAddress",
            trigger: ["blur", "change"]
          }
        ],
        phonenumber: [
          { required: true, message: "Phone Numbercannot be empty", trigger: "blur" },
          {
            pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/,
            message: "Please Input正确的Phone Number",
            trigger: "blur"
          }
        ]
      }
    };
  },
  methods: {
    submit() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          updateUserProfile(this.user).then(response => {
            this.$modal.msgSuccess("changeSuccess");
          });
        }
      });
    },
    close() {
      this.$tab.closePage();
    }
  }
};
</script>
