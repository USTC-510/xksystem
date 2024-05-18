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
  
    if () {  
        alert('登录成功！');
        window.location.href = 'studentInformation.html';  
    } 
    else if (){  
        alert('登录成功！');
        window.location.href = 'teacherInformation.html';
    }  
    else if (){
        alert('登录成功！');
        window.location.href = 'administratorInformation.html';
    }
    else{
        document.getElementById('errorMessage').textContent = '用户名或密码错误！';
    }
});