<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />
<title>test</title>
<meta name="description" content>
<meta name="keywords" content="">
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<h2>index</h2>
	<input type="button" onclick="dadadada">
	<button onclick="dadadada()"> asdasda </button>
	<script type="text/javascript">
		function dadadada() {
			var data2 = {
// 				"id" : "8",
				"userName" : "ddfsa",
				"userPassword" : "ddfsa",
				"nickName" : "dd",
				"mobile" : "213"
			};
			$.ajax({
				type : "POST",
				url : "/user/main",
				dataType : "json",
				data : data2,
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
