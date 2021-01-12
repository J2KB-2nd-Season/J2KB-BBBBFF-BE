<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/view/include/Header.jsp" %> 

<style>
select{
    border: 0;
    outline: 0;
}
select{
    width: 100%;
    height: 40px;
    border: 1px solid #cccccc;
    border-radius: 3px;
    background-color: #ffffff;
    padding-left: 10px;
    color: #8898aa;
    margin-bottom: 20px;
}
.register {
    margin-top: 20px;
}
.Login {
    float: left;
}
.Login a:hover {
    color: black;
    transition: 0.3s;
    font-weight: 700;
}
.Login a{
    color: #8898aa;
}
</style>


</head>
<body>
	
	<div class="limiter">
		<div class="container-login100" >
			<div class="wrap-login100">
				<form class="login100-form validate-form" onSubmit="return checkPwd();" 
				method="POST" action="${pageContext.request.contextPath }/employee/register" autocomplete="off">
					<span class="login100-form-title p-b-26">
						** ENT   REGISTER
					</span>
					
					<select name="empTeam" id="empTeam">
					</select>
					<select name="empGrade" id= "empGrade">
						
					</select>

					<div class="wrap-input100 validate-input" data-validate = "">
						<input class="input100" type="date" name="empDate" id="empDate">
						<span class="focus-input100" data-placeholder="Date of joining the year"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Valid name">
						<input class="input100" type="text" name="empName" id="empName">
						<span class="focus-input100" data-placeholder="name"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
					
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
						<input class="input100" type="password" name="empPwd" id="empPwd">
						<span class="focus-input100" data-placeholder="Password"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
						<input class="input100" type="password" name="rePwd" id="rePwd">
						<span class="focus-input100" data-placeholder="Password Check"></span>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button type="submit" class="login100-form-btn">
								REGISTER
							</button>
						</div>
					</div>

					<div class="register">
						<span class="Login" >
							<a href="${pageContext.request.contextPath }/login">LOGIN</a>
						</span>
						
					</div>
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/re_main.js"></script>

</body>

<script>
	function loadTeam(){
		$.ajax({
			url : "${pageContext.request.contextPath }/grp_get_team",
			type : "post",
			data : "",
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			dataType : "json",
			success : function(resData){
				$.each(resData, function(key, value) {
						$("#empTeam").append("<option value="+value.team_id+">"+value.team_name+"</option>");
					});
			},
			error : function(){
				alert("시스템에러");
				},			
				complete : function(){}
	});
}
	function loadGrade(){
		$.ajax({
			url : "${pageContext.request.contextPath }/grp_get_grade",
			type : "post",
			data : "",
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			dataType : "json",
			success : function(resData){
				$.each(resData, function(key, value) {
						$("#empGrade").append("<option value="+value.grade_id+">"+value.grade_name+"</option>");
					});
			},
			error : function(){
				alert("시스템에러");
				},			
				complete : function(){}
	});
}
	function checkPwd(){
		var a = $("#empPwd");
		var b = $("#rePwd");
		if(a.val().lenght > 15 || a.val().lenght < 10){
				alert("비밀번호는 10자리 이상 15자리 미만으로 입력하셔야 합니다.");
				a.val("");
				a.focus();
				return false;
			}
		if(b.val().lenght > 15 || b.val().lenght < 10){
			alert("비밀번호는 확인은 10자리 이상 15자리 미만으로 입력하셔야 합니다.");
			b.val("");
			b.focus();
			return false;
		}
		
		if(a.val() != b.val()){
			alert("비밀번호가 다릅니다.");
			a.val("");
			b.val("");
			a.focus();
			return false;
			}
	} 다 만들고 이 주석을 없애야 편함*/
	$(function(){
		loadTeam();
		loadGrade();
		});
</script>

</html>