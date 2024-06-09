<template>
  <div class="container main">
    <div class="search-container">
      <input type="text" v-model="searchQuery" placeholder="请输入课程或授课老师名称" />
      <button @click="searchCourses">搜索</button>
    </div>
    <h2>选择课程</h2>
    <table>
      <tr>
        <th>课程编号</th>
        <th>课程名称</th>
        <th>教授</th>
        <th>上课时间</th>
        <th>地点</th>
        <th>学分</th>
        <th>选择人数</th>
        <th>选择</th>
      </tr>
      <tr v-for="course in filteredCourses" :key="course.id">
        <td>{{ course.id }}</td>
        <td>
          {{ course.name }}
          <router-link :to="{ name: 'courseIntro', params: { courseName: course.name } }"> 介绍</router-link>
        </td>
        <td>{{ course.professor }}</td>
        <td>{{ course.time }}</td>
        <td>{{ course.position }}</td>
        <td>{{ course.credits }}</td>
        <td>{{ course.currentPeople }} / {{ course.maxPeople }}</td>
        <td><input type="checkbox" v-model="selectedCourses" :value="course.id" /></td>
      </tr>
    </table>
  </div>
</template>

<script>
import api from "../api/function.js";
export default {
  name: 'choose_student',
  data() {
    return {
      searchQuery: '',
      courses: [],
      selectedCourses: []
    };
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
  