<template>
  <el-form ref="form" :model="user" :rules="rules" label-width="80px">
    <el-form-item label="oldpassword" prop="oldPassword">
      <el-input v-model="user.oldPassword" placeholder="Please Inputoldpassword" type="password" show-password/>
    </el-form-item>
    <el-form-item label="Newpassword" prop="newPassword">
      <el-input v-model="user.newPassword" placeholder="Please InputNewpassword" type="password" show-password/>
    </el-form-item>
    <el-form-item label="confirmpassword" prop="confirmPassword">
      <el-input v-model="user.confirmPassword" placeholder="Please confirmpassword" type="password" show-password/>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" size="mini" @click="submit">Keep</el-button>
      <el-button type="danger" size="mini" @click="close">Close</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import { updateUserPwd } from "@/api/system/user";

export default {
  data() {
    const equalToPassword = (rule, value, callback) => {
      if (this.user.newPassword !== value) {
        callback(new Error("两次输入的password不一致"));
      } else {
        callback();
      }
    };
    return {
      user: {
        oldPassword: undefined,
        newPassword: undefined,
        confirmPassword: undefined
      },
      // 表单校验
      rules: {
        oldPassword: [
          { required: true, message: "oldpasswordcannot be empty", trigger: "blur" }
        ],
        newPassword: [
          { required: true, message: "Newpasswordcannot be empty", trigger: "blur" },
          { min: 6, max: 20, message: "长度在 6 到 20 个字符", trigger: "blur" }
        ],
        confirmPassword: [
          { required: true, message: "confirmpasswordcannot be empty", trigger: "blur" },
          { required: true, validator: equalToPassword, trigger: "blur" }
        ]
      }
    };
  },
  methods: {
    submit() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          updateUserPwd(this.user.oldPassword, this.user.newPassword).then(response => {
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
