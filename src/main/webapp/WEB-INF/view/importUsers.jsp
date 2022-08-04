<!DOCTYPE html>
<%@include file="menu.jsp"%>
<html>
<head>

<script type="text/javascript">
	function checkfile(sender) {
		var validExts = new Array(".xlsx", "xls");
		var fileExt = sender.value;
		fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
		if (validExts.indexOf(fileExt) < 0) {
			alert("Invalid file selected, valid files are of "
					+ validExts.toString() + " types.");
			sender.value = "";
			return false;
		} else {

			return true;

		}
	}
</script>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<form action="uploadsheet" name="UploadSheet" class="form-data"
					method="post" enctype="multipart/form-data">


					<div class="form-resp">
						<H4 class="text-center">UPLOAD VIA EXCELSHEET</H4>
						<div class="form-group">

							<input type="file" name="file" id="file"
								class="file-data btn btn-primary btn-block"
								onchange="checkfile(this);" accept="application/xls"
								required="required"><br>

							<button type="submit" class="btn btn-primary btn-block">Upload
								& Import</button>
						</div>

					</div>


				</form>
			</div>
		</div>
	</div>



</body>
</html>
