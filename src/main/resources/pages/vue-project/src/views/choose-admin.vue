<template>
  <div class="container main">
    <div class="search-container">
      <form @submit.prevent="submit">
        <input type="text" v-model="searchQuery" placeholder="请输入课程或授课老师名称" />
      </form>
      <button @click="searchCourses">搜索</button>
    </div>
    <h2>
      管理课程
      <button class="button" @click.prevent="showCard = true">添加</button>
      <addCourse v-if="showCard" @close="showCard = false" />
      <button class="button" @click="toggleEditMode">{{ editMode ? '保存' : '编辑' }}</button>
      <button 
        class="button" 
        @click="toggleDeleteMode" 
        :disabled="editMode" 
        :class="{ 'disabled-button': editMode }"
      >
        {{ deleteMode ? '取消删除' : '删除' }}
      </button>
    </h2>
    <table>
      <tr>
        <th>课程编号</th>
        <th>课程名称</th>
        <th>教授</th>
        <th>上课时间</th>
        <th>地点</th>
        <th>学分</th>
        <th>学时</th>
        <th>选择人数</th>
        <th>操作</th>
      </tr>
      <tr v-for="course in filteredCourses" :key="course.id">
        <td>{{ course.id }}</td>
        <td v-if="editMode">
          {{ course.name }}
          <router-link :to="{ name: 'courseIntro', params: { courseName: course.name } }"> 介绍 </router-link>
        </td>
        <td v-else><input v-model="course.name" @input="trackChanges(course.id, 'name', course.name)" /></td>
        <td v-if="editMode">{{ course.time }}</td>
        <td v-else><input v-model="course.time" @input="trackChanges(course.id, 'time', course.time)" /></td>
        <td v-if="editMode">{{ course.position }}</td>
        <td v-else><input v-model="course.position" @input="trackChanges(course.id, 'position', course.position)" /></td>
        <td v-if="editMode">{{ course.credits }}</td>
        <td v-else><input v-model="course.credits" @input="trackChanges(course.id, 'credits', course.credits)" /></td>
        <td v-if="editMode">{{ course.hour }}</td>
        <td v-else><input v-model="course.hour" @input="trackChanges(course.id, 'hour', course.hour)" /></td>
        <td>
          {{ course.currentPeople }} / 
          <span v-if="editMode">{{ course.maxPeople }}</span>
          <input v-else type="number" v-model="course.maxPeople" @input="trackChanges(course.id, 'maxPeople', course.maxPeople)" />
        </td>
        <td v-if="editMode"><input type="checkbox" v-model="selectedCourses" :value="course.id"/></td>
      </tr>
    </table>
  </div>
</template>

<script>
import api from "../api/function.js";
import addCourse from "../components/addCourse.vue";

export default {
  name: 'choose_teacher',
  data() {
    return {
      searchQuery: '',
      courses: [],
      selectedCourses: [],
      editMode: false,
      deleteMode: false,
      changes: {}
    };
  },
  components: {
    addCourse
  },
  created() {
    api.getAllCourses().then(response => {
      const data = response.data;
      this.courses = data.name.map((id, index) => ({
        id: id,
        name: data.name[index],
        professor: data.professor[index],
        time: data.time[index],
        position: data.position[index],
        credits: data.credits[index],
        hour: data.hour[index],
        currentPeople: data.currentPeople[index],
        maxPeople: data.maxPeople[index]
      }));
    });
  },
  computed: {
    filteredCourses() {
      if (!this.searchQuery) {
        return this.courses;
      }
      const query = this.searchQuery.toLowerCase();
      return this.courses.filter(course => {
        return course.name.toLowerCase().includes(query) || course.professor.toLowerCase().includes(query);
      });
    }
  },
  methods: {
    toggleEditMode() {
      this.editMode = !this.editMode;
      if (!this.editMode) {
        // 保存更改逻辑, 例如发送请求到服务器
        console.log('保存更改:', this.changes);
        this.saveChanges();
        this.changes = {}; // 清空更改记录
      }
    },
    toggleDeleteMode() {
      this.deleteMode = !this.deleteMode;
      if (!this.deleteMode) {
        // 如果取消删除模式，清空已选中的课程
        this.selectedCourses = [];
      }
    },
    deleteSelectedCourses() {
      // 删除选中课程
      this.courses = this.courses.filter(course => !this.selectedCourses.includes(course.id));
      api.deleteCourses(this.selectedCourses)
        .then(response => {
          if (response.data == 0){
            alert("保存成功！");
          } else {
            alert("保存失败！");
          }
        })
        .catch(error => {
          alert("保存失败，请保证你的输入是正确的");
          console.error(error);
        });
      this.selectedCourses = []; // 清空已选中的课程
    },
    trackChanges(courseId, field, newValue) {
      if (!this.changes[courseId]) {
        this.changes[courseId] = {};
      }
      if (!this.changes[courseId][field]) {
        this.changes[courseId][field] = [];
      }
      this.changes[courseId][field].push(newValue);
    },
    saveChanges() {
      api.changeCourses(this.changes)
        .then(response => {
          if (response.data == 0){
            alert("保存成功！");
          } else {
            alert("保存失败！");
          }
        })
        .catch(error => {
          alert("保存失败，请稍后再试");
          console.error(error);
        });
    }
  }
};
</script>
    
    <style scoped>
    .container {
      width: 80%;
      margin: auto;
      overflow: hidden;
      min-width: 70%;
    }
    .main {
      padding: 20px;
      background: #fff;
      margin-top: 20px;
      position: relative;
    }
    table {
      width: 100%;
      margin: 20px 0;
      border-collapse: collapse;
    }
    table, th, td {
      border: 1px solid #ddd;
    }
    th, td {
      padding: 12px;
      text-align: left;
    }
    th {
      background-color: #f2f2f2;
    }
    .button {
      display: inline-block;
      padding: 10px 20px;
      font-size: 16px;
      cursor: pointer;
      text-align: center;
      text-decoration: none;
      outline: none;
      color: #fff;
      background-color: #4CAF50;
      border: none;
      border-radius: 15px;
      box-shadow: 0 9px #999;
    }
    .button:hover {
      background-color: #3e8e41;
    }
    .button:active {
      background-color: #3e8e41;
      box-shadow: 0 5px #666;
      transform: translateY(4px);
    }
    .search-container {
      position: absolute;
      top: 20px;
      right: 20px;
    }
    .search-container input[type=text] {
      padding: 10px;
      font-size: 17px;
      border: 1px solid #ddd;
      background: #f1f1f1;
    }
    .search-container button {
      padding: 10px;
      background: #4CAF50;
      color: white;
      font-size: 17px;
      border: 1px solid #ddd;
      border-left: none;
      cursor: pointer;
    }
    .search-container button:hover {
      background: #45a049;
    }
    </style>