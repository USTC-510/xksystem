document.getElementById('showPassword').addEventListener('change', function () {
    var passwordInput = document.getElementById('password');
    if (this.checked) {
        passwordInput.type = 'text';
    } else {
        passwordInput.type = 'password';
    }
});
document.getElementById('loginForm').addEventListener('submit', function(event) {  
    event.preventDefault(); // 阻止表单默认提交行为  
  
    // 清除之前的错误信息  
    document.getElementById('errorMessage').textContent = '';  
  
    // 获取输入值  
    var username = document.getElementById('username').value;  
    var password = document.getElementById('password').value;  
  
    if (username == 'a' && password == '1' && document.getElementById('student').checked) {  
        alert('学生登录成功！');
        //window.location.href = 'studentInformation.html';  
    } 
    else if (username == 'b' && password == '2' && document.getElementById('teacher').checked){  
        alert('老师登录成功！');
        //window.location.href = 'teacherInformation.html';
    }  
    else if (username == 'c' && password == '3' && document.getElementById('admin').checked){
        alert('管理员登录成功！');
        //window.location.href = 'administratorInformation.html';
    }
    else{
        document.getElementById('errorMessage').textContent = '用户名或密码错误，或者您所选的登陆身份有误！';
    }
});