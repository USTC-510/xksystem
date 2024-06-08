<template>
    <div class="container main">
      <div class="search-container">
        <input type="text" v-model="searchQuery" placeholder="搜索课程..." />
        <button @click="searchCourses">搜索</button>
      </div>
      <h2>3. 选择课程</h2>
      <table>
        <tr>
          <th>课程编号</th>
          <th>课程名称</th>
          <th>教授</th>
          <th>上课时间</th>
          <th>学分</th>
          <th>选择</th>
        </tr>
        <tr v-for="course in filteredCourses" :key="course.id">
          <td>{{ course.id }}</td>
          <td>{{ course.name }}</td>
          <td>{{ course.professor }}</td>
          <td>{{ course.time }}</td>
          <td>{{ course.credits }}</td>
          <td><input type="checkbox" v-model="selectedCourses" :value="course.id" /></td>
        </tr>
      </table>
    </div>
  </template>
  
  <script>
  export default {
    name: 'choose_student',
    data() {
      return {
        searchQuery: '',
        courses: [],
        selectedCourses: [],
        confirmSelection: false
      };
    },
    computed: {
      filteredCourses() {
        return this.courses.filter(course => {
          return course.name.includes(this.searchQuery) || course.professor.includes(this.searchQuery);
        });
      }
    },
    methods: {
      searchCourses() {
        
      },
      submitCourses() {
        if (this.confirmSelection) {
          alert('选课提交成功！');
        } else {
          alert('请确认所选课程无误。');
        }
      }
    }
  };
  </script>
  
  <style scoped>
  .container {
    width: 80%;
    margin: auto;
    overflow: hidden;
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
  