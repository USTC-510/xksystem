
const base = {
    baseurl:"http://localhost:8081/",
    login:"api/user/login",
    realName:"api/user/realName",
    infor:"api/user/getInfor",
    changePassword:"api/user/changePassword",
    allCourses:"api/course/allCourse",
    detailedCourse:"api/course/detailedCourse",
    checkCourse:"api/course/ifCanCheck",
    forgetPassword:"api/user/resetPasswordMail",
    deleteCourses:"api/user/deleteCourses",
    changeCourses:"api/administrator/changeCourses",
    afterForgetPassword:"api/user/resetPassword",
    getStudentCourses:"api/student/getCourses",
    getTeacherCourses:"api/teacher/getCourses",
    notCheck:"api/course/cancelChoose"
    //注意：baseurl和login拼起来才是真正的url路径，这么写是因为在一个程序中url前面那一串基本都是相同的，需要变动的常常是后面那一串
}
export default base;