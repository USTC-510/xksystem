<template>
    <div class="container">
      <h1>大学课程表</h1>
      <table>
        <thead>
          <tr>
            <th>时间</th>
            <th>星期一</th>
            <th>星期二</th>
            <th>星期三</th>
            <th>星期四</th>
            <th>星期五</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(timeSlot, index) in timeSlots" :key="index">
            <td>{{ timeSlot }}</td>
            <td v-for="day in days" :key="day">
              <template v-if="schedule[day][index] && !schedule[day][index].covered">
                <td :rowspan="schedule[day][index].rowspan" class="course-cell">
                  <div class="course-content">{{ schedule[day][index].course }}</div>
                </td>
              </template>
              <template v-else>
                <td></td>
              </template>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        days: ['星期一', '星期二', '星期三', '星期四', '星期五'],
        timeSlots: [
          "7:50 - 8:35", "8:40 - 9:25", "9:45 - 10:30", "10:35 - 11:20", "11:25 - 12:10",
          "14:00 - 14:45", "14:50 - 15:35", "15:55 - 16:40", "16:45 - 17:30", "17:35 - 18:20",
          "19:30 - 20:15", "20:20 - 21:05", "21:10-21:55"
        ],
        schedule: {
          '星期一': Array(13).fill(null),
          '星期二': Array(13).fill(null),
          '星期三': Array(13).fill(null),
          '星期四': Array(13).fill(null),
          '星期五': Array(13).fill(null)
        }
      };
    },
    mounted() {
      this.fetchSchedule();
    },
    methods: {
      fetchSchedule() {
        const username = localStorage.getItem("username");
        getStudentCourse(username).then(response => {
            const scheduleData = response.data;
            scheduleData.forEach(course => {
              const dayIndex = this.days.indexOf(course.day);
              const startSlotIndex = course.startTime;
              const endSlotIndex = course.endTime;
              const rowspan = endSlotIndex - startSlotIndex + 1;
              this.schedule[course.day][startSlotIndex] = {
                course: course.course,
                rowspan: rowspan
              }.catch(error => {
                console.log(error);
              });
              // 标记被合并的单元格
              for (let i = startSlotIndex + 1; i <= endSlotIndex; i++) {
                this.schedule[course.day][i] = { covered: true };
              }
            });
          }).catch(error => {
            console.error('Error fetching schedule:', error);
          });
      }
    }
  };
  </script>
  <style scoped>
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f0f0f0;
  }
  .container {
    width: 80%;
    margin: 0 auto;
    background-color: #fff;
    padding: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }
  h1 {
    text-align: center;
    color: #333;
  }
  table {
    width: 100%;
    border-collapse: collapse;
    margin: 20px 0;
  }
  th, td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: center;
  }
  th {
    background-color: #f4f4f4;
  }
  tr:nth-child(even) {
    background-color: #f9f9f9;
  }
  tr:hover {
    background-color: #f1f1f1;
  }
  .course-cell {
    position: relative;
  }
  .course-content {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100%;
    width: 100%;
  }
  </style>
  