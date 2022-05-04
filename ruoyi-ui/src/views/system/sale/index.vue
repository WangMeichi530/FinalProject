<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="Product Title" prop="noticeTitle">
        <el-input
          v-model="queryParams.noticeTitle"
          placeholder="Please InputProduct Title"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="Type" prop="noticeType">
        <el-select v-model="queryParams.noticeType" placeholder="Product Type" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_notice_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">Search</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">Reset</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:notice:add']"
        >Add</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:notice:edit']"
        >change</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:notice:remove']"
        >Delete</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="noticeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="Serial number" align="center" prop="noticeId" width="100" />
      <el-table-column
        label="Product Title"
        align="center"
        prop="noticeTitle"
        :show-overflow-tooltip="true"
      />
      <el-table-column label="Product Type" align="center" prop="noticeType" width="100">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_notice_type" :value="scope.row.noticeType"/>
        </template>
      </el-table-column>
      <el-table-column label="Status" align="center" prop="status" width="100">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_notice_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="Created By" align="center" prop="createBy" width="100" />
      <el-table-column label="Create Time" align="center" prop="createTime" width="100">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="Operation" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleOpenLiuYan(scope.row)"
            v-hasPermi="['system:notice:edit']"
          >View Message</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:notice:edit']"
          >View Product</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:notice:remove']"
          >Delete</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或changeProduct对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="780px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="Product Title" prop="noticeTitle">
              <el-input v-model="form.noticeTitle" placeholder="Please InputProduct Title" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="Product Type" prop="noticeType">
              <el-select v-model="form.noticeType" placeholder="请选择">
                <el-option
                  v-for="dict in dict.type.sys_notice_type"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="Productid" prop="noticeId" v-show="false">
              <el-input v-model="form.noticeId" placeholder="" v-show="false" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="Status">
              <el-radio-group v-model="form.status">
                <el-radio
                  v-for="dict in dict.type.sys_notice_status"
                  :key="dict.value"
                  :label="dict.value"
                >{{dict.label}}</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>


          <el-col :span="24">
            <el-form-item label="Message">
              <el-input v-model="form.remark" type="textarea" placeholder="Please InputMessageinformation"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="24">
            <el-form-item label="Image content">
              <editor v-model="form.noticeContent" :min-height="500"/>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">Sure</el-button>
        <el-button @click="cancel">Cancel</el-button>
      </div>
    </el-dialog>


    <el-dialog :title="title" :visible.sync="openLiuYan" width="1000px" append-to-body>

      <el-table v-loading="loading" :data="noticeLiuYanList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="Messageinformation" align="center" prop="remark" width="500" />
        <el-table-column label="Messageby" align="center" prop="createBy" width="100" />
        <el-table-column label="Messagetime" align="center" prop="createTime" width="100">
          <template slot-scope="scope">
            <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>

      </el-table>

      <pagination
        v-show="totalLiuYan>0"
        :total="totalLiuYan"
        :page.sync="queryParamsLiuYan.pageNum"
        :limit.sync="queryParamsLiuYan.pageSize"
        @pagination="getList"
      />
    </el-dialog>


  </div>
</template>

<script>
import { listNotice, getNotice,getNoticeLiuYan, delNotice, addNotice, updateNotice } from "@/api/system/notice";

export default {
  name: "Notice",
  dicts: ['sys_notice_status', 'sys_notice_type'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // showSearcharticle件
      showSearch: true,
      // 总article数
      total: 0,
      totalLiuYan: 0,
      // Product表格数据
      noticeList: [],
      noticeLiuYanList: [],
      // 弹出层标题
      title: "",
      // YesNoshow弹出层
      open: false,
      openLiuYan: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        params: {
          menuId: "2000"
        },
        noticeTitle: undefined,
        createBy: undefined,
        status: undefined
      },
      // 查询参数
      queryParamsLiuYan: {
        pageNum: 1,
        pageSize: 10,
        params: {
          menuId: "2001"
        },
        noticeTitle: undefined
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        noticeTitle: [
          { required: true, message: "Product Titlecannot be empty", trigger: "blur" }
        ],
        noticeType: [
          { required: true, message: "Product Typecannot be empty", trigger: "change" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询Product列表 */
    getList() {
      this.loading = true;
      listNotice(this.queryParams).then(response => {
        this.noticeList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },

    /** View MessagebuttonOperation */
    handleOpenLiuYan(row) {
      this.reset();
      const noticeId = row.noticeId
      let queryParamsLiuYan = this.queryParamsLiuYan;
      console.log(queryParamsLiuYan);
      queryParamsLiuYan.noticeTitle = noticeId;
      console.log(queryParamsLiuYan);
      getNoticeLiuYan(queryParamsLiuYan).then(response => {
        this.noticeLiuYanList = response.rows;
        console.log(this.noticeLiuYanList);
        this.totalLiuYan = response.total;
        this.openLiuYan = true;
        this.title = "View ProductMessage";
      });
    },

    // Cancelbutton
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单Reset
    reset() {
      this.form = {
        noticeId: undefined,
        noticeTitle: undefined,
        noticeType: undefined,
        noticeContent: undefined,
        status: "0"
      };
      this.resetForm("form");
    },
    /** SearchbuttonOperation */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** ResetbuttonOperation */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.noticeId)
      this.single = selection.length!=1
      this.multiple = !selection.length
    },
    /** AddbuttonOperation */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加Product";
    },
    /** changebuttonOperation */
    handleUpdate(row) {
      this.reset();
      const noticeId = row.noticeId || this.ids
      getNotice(noticeId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "changeProduct";
      });
    },

    /** Submitbutton */
    submitForm: function() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.noticeId != undefined) {
            updateNotice(this.form).then(response => {
              this.$modal.msgSuccess("changeSuccess");
              this.open = false;
              this.getList();
            });
          } else {
            addNotice(this.form).then(response => {
              this.$modal.msgSuccess("AddSuccess");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** DeletebuttonOperation */
    handleDelete(row) {
      const noticeIds = row.noticeId || this.ids
      this.$modal.confirm('YesNoconfirmDeleteProductNumberis"' + noticeIds + '"data？').then(function() {
        return delNotice(noticeIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("DeleteSuccess");
      }).catch(() => {});
    }
  }
};
</script>
