function evt() {	
	var obj = new Object();

	var element = event.currentTarget.parentNode;
	obj.id = event.currentTarget.parentNode.id;
	obj.type = event.currentTarget.parentNode.parentNode.id;

	const xhr = new XMLHttpRequest();
	xhr.open('POST', 'TodoTypeServlet');
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(JSON.stringify(obj));

	xhr.onreadystatechange = function() {
		if (xhr.readyState !== XMLHttpRequest.DONE)
			return;

		if (xhr.status === 200 && xhr.response === 'success') {
			
			// next Type 결정  
			var nextType = "";

			if (obj.type === "todo") {
				nextType = "doing";
			} else if (obj.type === "doing") {
				nextType = "done";
			}

			// 옮겨질 element select
			var element = obj.element;

			// type이 done일 경우 버튼 삭제 
			if (nextType == "done") {
				element.removeChild(element.querySelector('img'));
			}

			// 이벤트 발생한 item 삭제 	
			element.parentNode.removeChild(element);
						
			// 새로운 item 추가 
			var newParent = document.querySelector('#' + CSS.escape(nextType));
			newParent.appendChild(element);
			
//			// 정렬 
//			var itemList = [];
//			var nodeList = newParent.querySelectorAll('.item');
//			
//			for(var i = 0; i < nodeList.length; i++)
//				itemList.push(nodeList[i]);
//			
//			itemList.sort(function(a, b){
//				var aInfoNode = a.querySelector('.info');
//				var bInfoNode = b.querySelector('.info');
//				if(aInfoNode.id === bInfoNode.id){
//					if(a.id < b.id)
//						return -1;
//					else if(a.id > b.id)
//						return 1;
//				}				
//				else if(aInfoNode.id < bInfoNode.id)
//					return -1;
//				else
//					return 1;
//			});
			
						
		} else {
			console.log('Error!');
		}
	};
}
