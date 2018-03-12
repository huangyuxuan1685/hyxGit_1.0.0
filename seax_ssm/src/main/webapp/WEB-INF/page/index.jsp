<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />
<title>test</title>
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="white">
<meta name="format-detection" content="telephone=no" />
<meta name="description" content>
<meta name="keywords" content="">
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<h2>index</h2>
	<button onclick="add()"> add </button>
	<button onclick="check()"> check </button>
	<script type="text/javascript">
		function add() {
			var userPassword = new Object();
			userPassword.userPasswordStr = "abcd456"
			var data2 = {
// 				"id" : "8",
				"userName" : "hyx",
				"userPassword" : "abcd456",
				"nickName" : "hyx",
				"mobile" : "321"
			};
			$.ajax({
				type : "POST",
				url : "/user/main",
				dataType : "json",
				data : {
					"params" : JSON.stringify(data2)
				},
				success : function(a, b, c, d) {
					console.log(a)
					console.log(b)
					console.log(c)
					console.log(d)
				},
				error : function(a, b, c, d) {
					console.log(a)
					console.log(b)
					console.log(c)
					console.log(d)
				},
				fail : function(a, b, c, d) {
					console.log(a)
					console.log(b)
					console.log(c)
					console.log(d)
				}
			});
		}
		function check() {
			var userPassword = new Object();
			userPassword.userPasswordStr = "abcd456"
			date = {
					
			}
			var data2 = {
	 			"id" : "6",
				"userName" : "hyx",
				"userPassword" : "abcd456",
				"nickName" : "hyx",
				"mobile" : "321"
			};
			$.ajax({
				type : "POST",
				url : "/user/check",
				dataType : "json",
				data : {
					"params" : JSON.stringify(data2)
				},
				success : function(a, b, c, d) {
					console.log(a)
					console.log(b)
					console.log(c)
					console.log(d)
				},
				error : function(a, b, c, d) {
					console.log(a)
					console.log(b)
					console.log(c)
					console.log(d)
				},
				fail : function(a, b, c, d) {
					console.log(a)
					console.log(b)
					console.log(c)
					console.log(d)
				}
			});
		}
	</script>
</body>
</html>
