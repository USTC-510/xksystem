<template>
  <div class="container main">
    <div class="search-container">
      <form @submit.prevent="submit">
        <button @click="searchCourses">搜索</button>
        <input type="text" v-model="searchQuery" placeholder="请输入课程或授课老师名称" />
      </form>
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
    <div class="table-container">
    <table>
    <thead>
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
      </thead>
      <tbody>
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
      </tbody>
    </table>
  </div>
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
        this.courses = response.data;
      }).catch(error => {
            alert("发生错误");
            console.log(error);
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
  padding: 20px;
  width: 100%;
  margin: 20px auto;
  overflow: hidden;
}

.main {
  background: #fff;
  margin-top: 20px;
  position: relative;
  width: 100%;
}

.table-container {
  width: 100%;
  overflow-x: auto;
}

table {
  width: 100%;
  margin: 20px 0;
  border-collapse: collapse;
}

thead {
  display: table-header-group;
}

tbody {
  display: table-row-group;
  height: 400px;
  overflow-y: auto;
  display: block;
}

th, td {
  width: 150px;
  padding: 12px;
  text-align: left;
  border: 1px solid #ddd;
}

th {
  background-color: #f2f2f2;
  position: sticky;
  top: 0;
  z-index: 1;
}

.search-container {
  position: relative;
  margin-bottom: 20px;
}

.search-container input[type=text] {
  width: calc(100% - 100px);
  padding: 10px;
  font-size: 17px;
  border: 1px solid #ddd;
  background: #f1f1f1;
}

.search-container button {
  width: 80px;
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

@media (max-width: 768px) {
  .container {
    padding: 10px;
    width: 100%;
  }

  table, thead, tbody, th, td, tr {
    display: block;
  }

  th, td {
    width: 100%;
    box-sizing: border-box;
  }

  th {
    position: relative;
  }
}
</style>
