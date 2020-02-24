function evt() {
	var obj = new Object();

	obj.id = event.currentTarget.parentNode.id;
	obj.type = event.currentTarget.parentNode.parentNode.id;

	const xhr = new XMLHttpRequest();
	xhr.open('POST', 'TodoTypeServlet');
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(JSON.stringify(obj));

	xhr.onreadystatechange = function() {
		if (xhr.readyState !== XMLHttpRequest.DONE)
			return;

		if (xhr.status === 200) {
			// next Type 결정  
			var nextType = "";

			if (obj.type === "todo") {
				nextType = "doing";
			} else if (obj.type === "doing") {
				nextType = "done";
			}

			// 옮겨질 element select
			var element = document.querySelector('#' + CSS.escape(obj.id));

			// type이 done일 경우 버튼 삭제 
			if (nextType == "done") {
				element.removeChild(element.querySelector('img'));
			}

			// 이벤트 발생한 item 삭제 	
			element.parentNode.removeChild(element);

			// 새로운 item 추가 
			var newParent = document.querySelector('#' + CSS.escape(nextType));
			newParent.appendChild(element);

		} else {
			console.log('Error!');
		}
	};
}
