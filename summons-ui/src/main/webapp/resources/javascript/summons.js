var readyStateCheckInterval = setInterval(function() {
	if (document.readyState === "complete") {
		clearInterval(readyStateCheckInterval);
		initCanvas();
	}
}, 10);
var controls =  {
	mt : false,
	lt : false,
	ml : false,
	bl : false,
	mb : false,
	br : false,
	mr : false,
	tr : false,
	tl : false,
	mtr : true
};
var canvas;
var statusColors = {
	PARTICPATING : "green",
	WONT_PARTICIPATE : "red",
	NOT_RESPONSED : "yellow"
};

function getParameterByName(name, url) {
	if (!url)
		url = window.location.href;
	url = url.toLowerCase();
	name = name.replace(/[\[\]]/g, "\\$&").toLowerCase();
	var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"), results = regex
			.exec(url);
	if (!results)
		return null;
	if (!results[2])
		return '';
	return decodeURIComponent(results[2].replace(/\+/g, " "));
}

function initCanvas() {
	window.seatingPlan = new fabric.Canvas('seatingPlanCanvas', {
		backgroundColor : '#F8FBFB',
		selectionColor : 'E8E1DF',
		selectionLineWidth : 2
	});
	this.seatingPlan.hoverCursor = 'pointer';
	var id = getParameterByName('eventId')
	var xmlhttp = new XMLHttpRequest();
	var url = "/summons-service/api/seatingPlan/" + id;
	xmlhttp.open("GET", url);
	xmlhttp.setRequestHeader("Content-Type", "application/json");

	xmlhttp.send();
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var response = this.responseText;
			if (response) {
				draw(JSON.parse(response));
			}
		}
	}
};

function draw(data) {
	if (data[0]) {
		data.forEach(function(entry) {
			var elements = [];
			var table = new fabric.Rect({
				top : entry.position.relativeTop,
				left : entry.position.relativeLeft,
				fill : "blue",
				height : entry.size.height,
				width : entry.size.width,
				type : 'table'
			});

			elements.push(table);
			entry.chairs.forEach(function(chair) {
				var c = new fabric.Rect({
					top : chair.position.top,
					left : chair.position.left,
					fill : "green",
					height : 30,
					width : 30,
					type : 'chair'
				});
				elements.push(c);
			});
			var tableGroup = new fabric.Group(elements, {
				top : entry.position.top,
				left : entry.position.left,
				angle : entry.angle
			});
			this.seatingPlan.add(tableGroup);
		});

		this.seatingPlan.renderAll();
	}
}

fabric.Rect.prototype.type = "Undefined";

fabric.Rect.prototype.toObject = function(angle, top, left) {
	if ('table' === this.type) {
		return new Table(top, left, this.top, this.left, this.height,
				this.width, angle);
	} else if ('chair' === this.type) {
		return new Chair(this.top, this.left);
	}
}

fabric.Group.prototype.toTable = function(obj) {
	var table = null;
	var chairs = [];
	obj.getObjects().forEach(function(element) {
		var o = element.toObject(obj.angle, obj.top, obj.left);
		if (o instanceof Table) {
			table = o;
		}
		if (o instanceof Chair) {
			chairs.push(o);
		}
	});
	if (table != null) {
		table.chairs = chairs;
	}
	return table;
}

function addTable() {
	var elements = []
	var table = new fabric.Rect({
		left : 100,
		top : 100,
		fill : 'black',
		width : 60,
		height : 100,
		type : 'table'
	});
	elements.push(table);
	elements.push(createChair(100, 80));
	elements.push(createChair(135, 80));
	elements.push(createChair(170, 80));
	elements.push(createChair(100, 145));
	elements.push(createChair(135, 145));
	elements.push(createChair(170, 145));
	var tableGroup = new fabric.Group(elements);
	
	for(var prop in controls) {
		tableGroup.setControlVisible(prop, controls[prop]);
	}
	
	this.seatingPlan.add(tableGroup);
}

function createChair(top, left) {
	return new fabric.Rect({
		left : left,
		top : top,
		fill : 'green',
		width : 30,
		height : 30,
		type : 'chair'

	});
}

function Person(id, status) {
	this.id = id;
	this.status = status;
}

function Position(top, left, relativeTop, relativeLeft) {
	this.top = top;
	this.left = left;
	this.relativeTop = relativeTop;
	this.relativeLeft = relativeLeft;
}

function Size(height, width) {
	this.height = height;
	this.width = width;
}

function Table(top, left, relativeTop, relativeLeft, height, width, angle) {
	this.size = new Size(height, width);
	this.position = new Position(top, left, relativeTop, relativeLeft);
	this.angle = angle;
	this.chairs = [];
}

function Chair(top, left, person) {
	this.position = new Position(top, left);
	this.person = person;
}

function buildJson(data) {
	var tables = [];
	data.forEach(function(group) {
		tables.push(group.toTable(group));
	});
	var tablesAsJSON = JSON.stringify(tables);
	return '{ "eventIdentifier": "' + getParameterByName('eventId')
			+ '", "tables":' + tablesAsJSON + "}";
}

function save() {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("PUT", "/summons-service/api/seatingPlan");
	xmlhttp.setRequestHeader("Content-Type", "application/json");
	var data = buildJson(this.seatingPlan.getObjects());
	xmlhttp.send(data);
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var response = this.responseText;
			if (response) {
				var event = JSON.parse(response);
				console.log(event);
				window.location.href = "/summons-ui/event.xhtml?eventId="+event;
			}
					
		}
	}
}