<%@ include file="common/Header.jspf"%>
<%@ include file="common/Navigation.jspf" %>
	<div class="container d-flex flex-column align-items-center">
		<h1>Enter Todo Details</h1>
		<br>
		<form:form method="post" modelAttribute="todo">
			<fieldset>
				
				<fieldset>
					<label for="description"><h5 class="me-2 mb-4">Description</h5></label>
					<form:input name="description" type="text" path="description" required="required"/>
					<form:errors path="description" cssClass="text-danger"/>
				</fieldset>
			
				<fieldset>
					<label for="targetDate"><h5 class="me-2 mb-4" >Target Date</h5></label>
					<form:input name="targetDate" id="targetDate" type="text" path="targetDate" required="required"/>
					<form:errors path="targetDate" cssClass="text-danger"/>
				</fieldset>
				
				<fieldset>
					<label for="done"><h5 class="me-2 mb-4">Done</h5></label> 
					<label for="true" class="fw-normal me-1">True</label><input name="done" id="targetDate" type="radio" path="done" value="true" required="required" class="me-2 mt-2" />
					<label for="false" class="fw-normal me-1">False</label><input name="done" id="targetDate" type="radio" path="done" value="false" required="required"/>
					<form:errors path="done" cssClass="text-danger"/>
				</fieldset>
				<form:input name="id" type="hidden" path="id" required="required"/>
				<!--<form:input name="done" type="hidden" path="done" required="required"/>-->	
				<br>
				<button type="submit" class="btn btn-success">Submit</button>
			</fieldset>
		</form:form>
	</div>
	
	
<%@ include file="common/Footer.jspf" %>

<script type="text/javascript">
		$('#targetDate').datepicker({
		    format: 'yyyy-mm-dd',
		    startDate: "0d",
		});
	</script>



