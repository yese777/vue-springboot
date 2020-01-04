<template>
  <div>
    <!-- 弹出表单 -->
    <el-dialog title="新增数据" :visible.sync="dialogFormVisible" @close="resetForm('form')"
               :close-on-click-modal="closeOnClickModal">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-radio-group v-model="form.sex">
            <el-radio label="男"></el-radio>
            <el-radio label="女"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="手机号码" prop="tell">
          <el-input v-model="form.tell"></el-input>
        </el-form-item>
        <el-form-item label="地址" prop="addr">
          <el-input v-model="form.addr"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">保存</el-button>
          <el-button @click="dialogFormVisible = false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <!-- 新增、删除按钮 -->
    <el-row>
      <el-button @click="open()" type="primary" icon="el-icon-edit"
                 circle></el-button>
      <el-button @click="del()" type="danger" :disabled="idList.length > 0? false:true" icon="el-icon-delete"
                 circle></el-button>
    </el-row>
    <!--列表-->
    <el-table ref="multipleTable" :data="tableData" tooltip-effect="dark"
              style="width: 100%" @selection-change="selectionChange">
      <el-table-column type="selection" width="50"></el-table-column>
      <el-table-column prop="id" label="id" width="200"></el-table-column>
      <el-table-column prop="name" label="姓名" width="200"></el-table-column>
      <el-table-column prop="sex" label="性别" width="200"></el-table-column>
      <el-table-column prop="tell" label="手机号码" width="200"></el-table-column>
      <el-table-column prop="addr" label="地址"></el-table-column>
      <el-table-column fixed="right" label="操作" width="200">
        <el-button prop="id" type="text" size="small">查看</el-button>
        <el-button prop="id" @click="update(props.id)" type="text" size="small">编辑</el-button>
      </el-table-column>
    </el-table>

    <!--分页-->
    <el-pagination v-if="page.total>page.size" background
                   layout="prev, pager, next" @current-change="currentChange"
                   :current-page="page.current" :page-size="page.size" :total="page.total">
    </el-pagination>
  </div>
</template>

<script>
    let baseUrl = "http://localhost:8080/";
    export default {
        name: "UserList",
        data() {
            return {
                //列表相关
                tableData: [],
                page: {
                    current: 1,
                    size: 5,
                    total: 0
                },
                idList: [],

                // 表单相关
                form: {
                    id: '',
                    name: '',
                    sex: '男',
                    tell: '',
                    addr: ''
                },
                dialogFormVisible: false,
                closeOnClickModal: false
            }
        },
        mounted() { //一般在此钩子函数中去请求数据
            this.getData();
        },
        methods: {
            //通过axios去请求服务端，获取数据
            getData() {
                let api = baseUrl + "customerTable?current=" + this.page.current + "&size=" + this.page.size;
                this.axios.get(api).then((response) => {
                    // response.就是从后端拿到的json数据
                    this.tableData = response.data.data.records;
                    this.page.total = response.data.data.total;
                })
            },

            //分页点击事件
            currentChange(current) {
                // console.log(current);
                this.page.current = current;
                this.getData();
            },

            // 行选择触发事件
            selectionChange(selection) {
                this.idList = [];
                selection.forEach(element => {
                    this.idList.push(element.id);
                });
                //console.log(this.idList);
            },

            // 删除数据
            del() {
                if (this.idList.length > 0) {
                    let idList = this.idList.toString();
                    //console.log(idList);
                    let api = baseUrl + "customerTable?idList=" + idList;
                    this.axios.delete(api).then((response) => {
                        if (response.data.code == 0) {
                            //重新获取数据
                            this.getData();
                        }
                    })
                }
            },

            // 打开弹窗
            open() {
                this.dialogFormVisible = true;
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            //保存
            onSubmit() {
                let api = baseUrl + "customerTable";
                let obj = this.form;
                let data = JSON.stringify(obj);
                //console.log(data);
                this.axios.post(api, data, {headers: {'Content-Type': 'application/json'}}).then((response) => {
                    if (response.data.code == 0) {
                        //关闭弹窗
                        this.dialogFormVisible = false;
                        //重新获取数据
                        this.getData();
                    }
                });
            },
            update(id) {
                console.log(id);
                this.dialogFormVisible = true;
            }


        }
    }
</script>

<style scoped>

</style>
